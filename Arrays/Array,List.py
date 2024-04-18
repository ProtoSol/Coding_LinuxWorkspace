import numbers
import string
x = 0
numbers = (1,2,3,4,5,6)
string = ("Hello", "World","!")
#These are array and tuple that can be used in code
print(numbers)
print(string)
#these print the whole array but they seems to be suspicious
#lets try while loop
while x <= 5:
    print(numbers[x])
    x += 1
#the while loop works similiar to the c while loop

# I noticed one thing that the python dosnt make any .exe files to execute at all