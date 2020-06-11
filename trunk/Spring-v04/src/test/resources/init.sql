DROP TABLE IF EXISTS `test_book`;

CREATE TABLE `test_book` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  `publisher` varchar(50) DEFAULT NULL,
  `price` double(6,2) DEFAULT NULL,
  `discount` double(3,1) DEFAULT NULL,
  `pub_date` date DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `test_book` VALUES (1,'新书','鲁迅','人民大学出版社',3000.00,9.0,'1986-01-01','2015-01-03 08:34:22'),(2,'红楼梦','曹雪芹','大清邮电出版社',302.00,9.0,'1973-01-22','2013-11-30 18:04:32'),(3,'Java基础教程','张小良','电子工业出版社',68.00,9.0,'2014-12-30','2015-01-05 10:10:10'),(4,'面向对象程序设计','刘伟','人民邮电出版社',89.00,9.0,'2013-10-03','2013-11-01 09:30:30'),(5,'Oracle数据库管理','马宣','人民邮电出版社',65.00,8.0,'2015-04-23','2015-04-30 15:30:30'),(7,'Java教程','张良','电子工业',83.00,9.0,'2015-12-24','2015-12-24 14:41:23'),(8,'TestBook','李纪','电子工业',56.00,8.0,'2015-12-24','2015-12-24 16:27:23'),(9,'Thinkpad使用手册','联想','联想出版社',10.00,9.0,'2015-12-25','2015-12-25 09:34:59');