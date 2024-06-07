# How to connect to Mysql

We use the command after setting the Path variable as follows:

```mysql
mysql -u username -p{There should be no space between}password
```

> After the MySQL shell gets activated we can perform various operations.

## Creation of Database

- The Command to see the databases present in the system

```mysql
show databases;
``` 

- To select the Database

```mysql
use database_name;
``` 

- To Create Database

```mysql
create database database_name;
``` 

- To Create a Table

```mysql
create table table_name ( 
    column1 datatype attribute,
    column2 datatype,
);
```
- To drop database

```mysql
drop database database_name;
```

- To Insert data into the table

    - This mehtod is mostly used when the table has multiple columns.
```mysql
insert into table_name (column1, a, column2 b) values (a, b);
```

```mysql
insert into table_name values (a, b, c);
```
- `It has to be in Order and Number of Columns should be same`



******
### Types of Commands ->

- DDL (Data Definition Language) -> Create, A database, Create a table, Alter a table, Drop a table, Drop a database, truncate
- DML (Data Manipulation Language) -> Insert, Update, Delete
- DQL (Data Query Language) -> Select. Join, Aggregate
- TCL (Transaction Control Language) -> Commit, Rollback, Savepoint
- DCL (Data Control Language) -> Grant, Revoke

![Types of Commands](image-6.png)

******

### Types of Datatypes ->

![Types of Database](image-7.png)

******