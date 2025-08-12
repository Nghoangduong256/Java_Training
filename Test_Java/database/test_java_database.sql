drop database if exists test_database;
create database test_database;
use test_database;

#Table Account
drop table if exists Account;
create table Account (
	id int not null primary key auto_increment,
    username varchar(255) not null,
    fullname nvarchar(255) not null,
    department nvarchar(255) not null,
    position nvarchar(255) not null,
    createdDate date not null
);

#Khởi tạo 1 vài Account
insert into Account (username, fullname, department, position, createdDate) values 
('Duong404', 'Nguyễn Hoàng Dương', 'BU3', 'Intern BrSE', '2025-8-11'),
('Hien505', 'Đoàn Ngọc Hiền', 'BU3', 'Intern BrSE', '2025-8-3'),
('phương333', 'Hoàng Thị Hà Phương', 'BU3', 'Intern BrSE', '2025-8-12');

select * from Account where fullname = 'Nguyễn Hoàng Dương';
update Account set username = 'giang404', fullname='Hoàng Giang', department='BU12' where username = 'phương333';
select * from Account;
