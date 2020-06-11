-- 删除表
-- 格式 ：DROP TABLE schema名.表名;
DROP TABLE test.test_student;

-- 创建数据表
-- CREATE TABLE schema名.表名
--      (
--          列名1 数据类型 [(size [byte|char])|(p,s)]
--          [,列名2 数据类型 [(size [byte|char])|(p,s)]
--           ,列名3 数据类型 [(size [byte|char])|(p,s)]
--              ......
--          ,列名n 数据类型 [(size [byte|char])|(p,s)]
--          ]
--      )
-- 如果列有默认值，可以使用default子句来指定
-- 注意，字符串类型数据需要使用单引号引起来
-- 日期相关类型的数据需要使用to_date('日期字符串‘,‘格式串')函数来定义
-- 如果定义一列要有非空约束，则在列的定义后加上not null
CREATE TABLE test.TEST_STUDENT
(
    id number(10) primary key,
    name varchar2(30 char) default 'unknown'  not null, 
    birthday date,
    hometown varchar2(50 char),
    score number(3) default 450 not null
);

-- 使用INSERT INTO语句向数据库中插入数据
-- 格式：INSERT INTO schema名.表名 [(列名1[,列名2,...列名n])] VALUES (值1[,值2,...值n])
-- 注意列名中指定的列的顺序要与值列表中值的顺序一一对应
INSERT INTO test.test_student 
    (id,name,birthday,hometown,score)
VALUES
    (5,'曹操',to_date('1970-03-23','yyyy-MM-dd'),'安徽',839);
    
-- 如果列名列表中列的顺序与表中列的自然顺序不同也可以，
-- 但一定要注意，值列表中的值要与其一一对应上
INSERT INTO test.test_student 
    (birthday,name,score,hometown,id)
VALUES
    (to_date('1973-03-23','yyyy-MM-dd'),'曹豹',239,'安徽',7);
    

-- INSERT INTO语句的列名列表部分可以省略
-- 省略则表示要按照表中列定义的自然顺序进行全部值的插入
-- 并且不能缺少
-- 如果按照表中列的自然顺序插入全部列的数据，则可以省略列名列表部分
-- 如果插入数据的列数小于表中的总列数，不能省略列名列表部分
-- 值列表中值的顺序如果与表中列的自然顺序不同，也不可省略列名列表，并且列名顺序要与值顺序一致
INSERT INTO test.test_student VALUES
    (3,'张飞',to_date('1985-06-13','yyyy-MM-dd'),'河北',549);
    

INSERT INTO test.test_student 
    (id,name,birthday)
VALUES
    (9,'关羽',to_date('1980-03-02','yyyy-MM-dd'));

-- 提交数据操作的结果到磁盘    
commit;

-- 删除数据使用DELETE语句
-- 格式：DELETE FROM schema名.表名 [WHERE 条件表达式]

-- 删除学生表中的所有数据
DELETE FROM test.test_student;

-- 配合WHERE子句，可以对要删除的数据限定范围

-- 删除id是9的学生数据
DELETE FROM test.test_student WHERE id=9;

-- 删除成绩大于500分的学生数据
DELETE FROM test.test_student WHERE score>500; 


-- 更新数据使用UPDATE语句
-- 格式：UPDATE schema名.表名 SET 列名1=值1[,列名2=值2...,列名n=值n] [WHERE 条件]
-- 值也可以是表达式的运算结果

-- 所有学生数据的成绩修改为500，籍贯修改为'中国'
UPDATE test.test_student SET score=500,hometown='中国';
-- 把id是7的学生数据的成绩修改为500，籍贯修改为'中国'
UPDATE test.test_student SET score=500,hometown='中国' WHERE id=7;
-- 为每个学生的成绩加十分
UPDATE test.test_student SET score=score+10;