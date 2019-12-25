mysql -uroot -proot

create database ems character set utf8 collate utf8_bin;

use ems;

create table emp(
	id int primary key auto_increment, -- 自动增长
	nickname varchar(32),
	password varchar(32),
	gender char(2),
	salary double
);

insert into emp values(null, 'siri', 'siri123', 'f', 11.11);

select * from emp;
