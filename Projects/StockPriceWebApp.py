# Libraries 
import streamlit as st
import yfinance as yf
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
import plotly.graph_objects as go
import plotly.express as px
import datetime
from datetime import date, timedelta
from statsmodels.tsa.seasonal import seasonal_decompose
import statsmodels.api as sm
from statsmodels.tsa.stattools import adfuller

# Title
app_name = 'Stock Market Forecasting Project'
st.title(app_name)
st.subheader('This project is made to forcast the prices of the selected stocks, It should not be used for real world trading.')

# Adding an image from online source
st.image("https://img.freepik.com/free-vector/gradient-stock-market-concept_23-2149166929.jpg?w=900&t=st=1691519342~exp=1691519942~hmac=6699a7b163ffaff0b848f131e846c0dc4c5f951fa7e318aad3ed2351c7be1141")

# Take Input From The User From The User (Date and Time)
st.sidebar.header('User Input Parameters Below')

start_date = st.sidebar.date_input('Start Date', date(2020,1,1))
end_date = st.sidebar.date_input('End Date', date(2020,12,31))


# add ticker symbol list
ticker_list = ["AAPL", "MSFT", "GOOG", "GOOGL", "META", "TSLA", "NVDA", "ADBE", "PYPL", "INTC", "CMCSA", "NFLX", "PEP"]
# ticker = st.sidebar.selectbox('Select the Company', ticker_list)

# Get user input for ticker selection
ticker_selection = st.sidebar.radio('Select Ticker Source:', ('Select Company', 'Enter Custom Company'))

# Making a Default Choice
ticker = 'AAPL'

# Creating If Else Logic for SElecting from Drop List or Custom Stocks.
if ticker_selection == 'Select Company':
    ticker = st.sidebar.selectbox('Select the Company', ticker_list)
elif ticker_selection == 'Enter Custom Company':
    custom_ticker = st.sidebar.text_input("Enter the Stock Symbol:")
    if custom_ticker:
        ticker = custom_ticker

# Display the selected or entered ticker

if ticker is not None:
    st.write("Selected/Entered Stock:", ticker)
    
# We Need To Fetch Data From User Inputs using yfinance library.

data = yf.download(ticker, start= start_date, end= end_date)

# Inserting Date as a Column to the Dataframe
data.insert(0, "Date", data.index, True)
data.reset_index(drop= True, inplace= True)

st.write('Data From', start_date, 'to', end_date)
st.write(data)

# Ploting the Data

st.header('Data Visualization')
st.subheader('Plot of the Data')
st.write("**Note:** Select your specific date range on the sidebar, or zoom in on the plot and select your specific column")

# Plotting through LineChart
fig = px.line(data, x= 'Date', y= data.columns, title= 'Closing Price of the Stock', template= 'plotly_dark', width= 1000, height= 600)

st.plotly_chart(fig)

# Add to select the box to select column from the data
columns_without_first = data.columns[1:]
column = st.selectbox('Select the Column to be used for forecasting', columns_without_first)

# Subsetting the data
data = data[['Date', column]]
st.write('Selected Data')
st.write(data)

# ADF test checks stationarity
st.header('Is Data Stationary')
# If p-value is less than 0.05, then data is stationary
st.write(adfuller(data[column])[1] < 0.05)

# Decomposing the data
st.header('Decposition of the data')
decomposition = seasonal_decompose(data[column], model = 'additive', period= 12)
st.write(decomposition.plot())

# Make the same plot using plotly
st.plotly_chart(px.line(x=data["Date"], y=decomposition.trend, title="Trend", width=1200, height=400, labels={'x': 'Date', 'y': 'Price'}).update_traces(line_color= 'blue'))
st.plotly_chart(px.line(x=data["Date"], y=decomposition._seasonal, title="Seasonality", width=1200, height=400, labels={'x': 'Date', 'y': 'Price'}).update_traces(line_color= 'green'))
st.plotly_chart(px.line(x=data["Date"], y=decomposition.resid, title="Residuals", width=1200, height=400, labels={'x': 'Date', 'y': 'Price'}).update_traces(line_color= 'red', line_dash='dot'))

# Let's run the Model
# User input for three parameters of the model and seasonal order

p = st.slider('Select the value of p', 0, 5, 2)
d = st.slider('Select the value of d', 0, 5, 1)
q = st.slider('Select the value of q', 0, 5, 2)
seasonal_order = st.number_input('Select the value of seasonal p', 0, 24, 12)

model = sm.tsa.statespace.SARIMAX(data[column], order=(p,d,q), seasonal_order=(p,d,q,seasonal_order))
model = model.fit()

# Printing the Model
st.header('Model Summary')
st.write(model.summary())
st.write("----------------------------------------------------------------")

# Forcasting the Values
st.write("<p style='color:green; font-size= 5-px; font-weight: bold;'>Forcasting the Data</p>", unsafe_allow_html= True)
forecast_period = st.number_input('Select the number of days to forecast', 1, 365, 10)

# Forcast the future values
predictions = model.get_prediction(start= len(data), end= len(data) + forecast_period - 1)
predictions = predictions.predicted_mean

# st.write(len(predictions)) this writes the number of data prediction numbers

# Adding index to the results dataframe as dates
predictions.index = pd.date_range(start= end_date, periods= len(predictions), freq = 'D')
predictions = pd.DataFrame(predictions)
predictions.insert(0, 'Date', predictions.index)
predictions.reset_index(drop = True, inplace = True)
st.write("## Predictions", predictions)
st.write("## Actual Data", data)
st.write("## Combined Data", pd.concat([data,predictions], axis = 0))

# Ploting the data 
fig = go.Figure()
# Add actual data to the plot
fig.add_trace(go.Scatter(x=data["Date"], y=data[column], mode='lines', name='Actual', line=dict(color='blue')))
# Add predictions to the plot
fig.add_trace(go.Scatter(x=predictions["Date"], y=predictions["predicted_mean"], mode='lines', name='Predicted', line=dict(color='red')))
# Set the title and axis labels
fig.update_layout(title='Actual vs Predicted', xaxis_title='date', yaxis_title='Price', width = 1000, height = 400)
# Display the plot
st.plotly_chart(fig)

# Add buttons to show and hide the seperate plots
show_plots = False
if st.button('Show Seperate Plots'):
    if not show_plots:
        st.write(px.line(x=data["Date"], y=data[column], title='Actual', width = 1200, height = 400, labels={'x': 'Date', 'y': 'Price'}).update_traces(line_color= 'blue'))
        st.write(px.line(x=predictions["Date"], y=predictions["predicted_mean"], title='Predicted', width = 1200, height = 400, labels={'x': 'Date', 'y': 'Price'}).update_traces(line_color= 'red'))
        show_plots = True
    else:
        show_plots = False

hide_plots = False
if st.button("Hide Seperate Plots"):
    if not hide_plots:
        hide_plots = True
    else:
        hide_plots = False
        
st.write("----------------------------------------------------------------")