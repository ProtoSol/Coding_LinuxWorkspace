-- Creating a database with name school
create database school;

-- selecting the created database
use school;

-- creating table structure
create table students(
    id int PRIMARY KEY auto_increment,
    name varchar(255) not null,
    email varchar(255) not null unique,
    phone varchar(20),
    address varchar(255),
    dob date
)

-- Description of the table
desc students;

-- Insert data into the table
insert into students(name, email, phone, address) values
('John Doe', 'j@j.com', '1234567890', '123 Main Street',2016-12-01),
('Jane Doe', 'j@j.com', '1234567890', '123 Main Street',2016-12-02),
('Jim Doe', 'j@j.com', '1234567890', '123 Main Street',2016-12-03); 

-- Select data from the table
select * from students;

-- Update data in the table
update students
set 
email = 'j@j.com',
phone = '1234567890',
address = '123 Main Street'
where id = 1;

-- Delete data from the table
delete from students where id = 

-- Change table structure
alter table students
add column gender varchar(10);

-- Modify table structure
alter table students
modify column gender varchar(10) not null;