drop table if exists stock;

create table stock(
	stock_id int,
	company_name varchar(50),
	symbol varchar(10),
	price decimal(10,2)
);