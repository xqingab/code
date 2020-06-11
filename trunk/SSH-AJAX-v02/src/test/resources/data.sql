DROP TABLE IF EXISTS test_book;

CREATE TABLE test_book
(
	id int(10) PRIMARY KEY AUTO_INCREMENT,
	name varchar(50) not null,
	author varchar(50) not null,
	type int(2) not null default 0,
	pub_date date,
	price double(8,2) not null default 50.0,
	discount double (5,1) not null default 10.0
);

INSERT INTO test_book (name,author,type,pub_date,price,discount)
VALUES
('三国演义','罗贯中',1,'1987-03-02',3.2,10.0);
INSERT INTO test_book (name,author,type,pub_date,price,discount)
VALUES
('三国演义第二版','罗贯小中',2,'1997-05-22',303.2,8.0);
INSERT INTO test_book (name,author,type,pub_date,price,discount)
VALUES
('石头记','曹雪芹',1,'1999-10-26',103,8.5);

COMMIT;
