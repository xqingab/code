CREATE TABLE `scss_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL DEFAULT '',
  `password` varchar(32) NOT NULL DEFAULT '123456',
  `type` varchar(1) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `scss_course` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '',
  `teach_time` varchar(100) NOT NULL DEFAULT '',
  `teacher_name` varchar(30) NOT NULL DEFAULT '',
  `credit` int(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `scss_user_course` (
  `user_id` int(11) NOT NULL DEFAULT '0',
  `course_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `scss_course` VALUES (1,'Java程序设计','周一上午','梁建隆',5);
INSERT INTO `scss_course` VALUES (2,'C++程序设计','周二下午','朱昱',3);
INSERT INTO `scss_course` VALUES (3,'高等数学','周二上午','钱英',5);
INSERT INTO `scss_course` VALUES (4,'数字电路','周一下午','郑雨开',3);
INSERT INTO `scss_course` VALUES (5,'模拟电路','周三上午','何建丹',3);
INSERT INTO `scss_course` VALUES (6,'科技文写作','周四下午','蒋镇中',1);
INSERT INTO `scss_course` VALUES (7,'数据库技术','周五上午','姜平',2);

INSERT INTO `scss_user` VALUES (1,'李学燕','123456','S');
INSERT INTO `scss_user` VALUES (2,'魏北','123456','S');
INSERT INTO `scss_user` VALUES (3,'西门博隆','123456','S');
INSERT INTO `scss_user` VALUES (4,'卫牧','123456','S');
INSERT INTO `scss_user` VALUES (5,'韩玉瑞','123456','S');
INSERT INTO `scss_user` VALUES (6,'金富洋','123456','S');
INSERT INTO `scss_user` VALUES (7,'阮博','123456','S');
INSERT INTO `scss_user` VALUES (8,'闵民','123456','S');
INSERT INTO `scss_user` VALUES (9,'袁向兰','123456','S');
INSERT INTO `scss_user` VALUES (10,'施婷','123456','S');
INSERT INTO `scss_user` VALUES (11,'admin','admin','A');

INSERT INTO `scss_user_course` VALUES (1,1);
INSERT INTO `scss_user_course` VALUES (1,2);
INSERT INTO `scss_user_course` VALUES (1,3);
INSERT INTO `scss_user_course` VALUES (1,4);
INSERT INTO `scss_user_course` VALUES (1,5);
INSERT INTO `scss_user_course` VALUES (1,6);
