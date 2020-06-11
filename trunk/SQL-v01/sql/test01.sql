--查询所有员工数据
SELECT * FROM hr.employees;

--查询所有员工的姓名（first_name||' '||last_name）,email,hire_date,phone_number
SELECT first_name||' '||last_name name,email,hire_date,phone_number FROM hr.employees;

-- 虚拟出的列不作为查询条件
-- SELECT first_name||' '||last_name name,email,hire_date,phone_number FROM hr.employees WHERE name LIKE '%s%';

--查询在职员工的所有工作id，每种工作id只显示一份
SELECT DISTINCT job_id FROM hr.employees;

-- 查询所有职工姓名，工资及工资翻倍后的数字
SELECT first_name||' '||last_name name,salary,salary*2 double_salary FROM hr.employees;

-- 查询工资大于8000的所有员工
SELECT first_name||' '||last_name name,salary FROM hr.employees WHERE salary>8000;

-- 查询工资大于8000并小于等于10000的员工
SELECT first_name||' '||last_name name,salary FROM hr.employees WHERE salary>8000 AND salary<=10000;

-- 查询工资大于10000并属于id是100的部门的员工
SELECT first_name||' '||last_name name,salary FROM hr.employees WHERE salary>10000 AND department_id=100;

-- 查询所有销售人员（提成不为null的）数据
SELECT * FROM hr.employees WHERE commission_pct IS NOT NULL;

-- 查询所有非销售人员（提成为null的）数据
SELECT * FROM hr.employees WHERE commission_pct IS NULL;

-- 查询所有员工，按工资倒序排序
SELECT * FROM hr.employees ORDER BY salary DESC

-- 查询部门id是90的所有员工，按工资正序排序，如果工资相等，按入职时间降序排序
SELECT * FROM hr.employees WHERE department_id=90 ORDER BY salary,hire_date DESC;

-- 查询工资在5000到8000之间的员工
SELECT * FROM hr.employees WHERE salary BETWEEN 5000 AND 8000;

-- 查询入职时间在2007年的员工
SELECT * FROM hr.employees 
WHERE hire_date BETWEEN to_date('2007-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')
AND to_date('2007-12-31 23:59:59','yyyy-mm-dd hh24:mi:ss');

-- 查询last_name中有m的员工
SELECT * FROM hr.employees WHERE lower(last_name) LIKE '%m%';

-- 查询first_name以A开头，并由5个字母组成的员工
SELECT * FROM hr.employees WHERE lower(first_name) LIKE 'a____';


-------------------------------------------------------
-- 练习
-- 创建学生成绩表（id,name,class,gender,score）
CREATE TABLE hr.stu_score
(
    id number(10) primary key,
    name varchar2(30 char) not null,
    class varchar2(30 char) not null,
    gender varchar2(2 char) default '男' not null,
    score number(5,1) default 450 not null
);
-- 添加10条数据，分属性三个班
INSERT INTO hr.stu_score VALUES (1,'Tom1','20151','男',600);
INSERT INTO hr.stu_score VALUES (2,'Tom2','20153','女',420);
INSERT INTO hr.stu_score VALUES (3,'Tom3','20151','男',510);
INSERT INTO hr.stu_score VALUES (4,'Tom4','20152','女',680);
INSERT INTO hr.stu_score VALUES (5,'Tom5','20151','男',300);
INSERT INTO hr.stu_score VALUES (6,'Tom6','20153','女',450);
INSERT INTO hr.stu_score VALUES (7,'Tom7','20151','女',400);
INSERT INTO hr.stu_score VALUES (8,'Tom8','20152','男',370);
INSERT INTO hr.stu_score VALUES (9,'Tom9','20153','女',520);
INSERT INTO hr.stu_score VALUES (10,'Tom10','20151','女',430);
-- 统计所有学生的总分、平均分、最高分
SELECT sum(score),avg(score),max(score) FROM hr.stu_score;
-- 统计每班学生的总分、平均分、最高分
SELECT class,sum(score),avg(score),max(score) FROM hr.stu_score GROUP BY class;
-- 统计男生女生的总分、平均分、最高分
SELECT gender,sum(score),avg(score),max(score) FROM hr.stu_score GROUP BY gender;
-- 统计每班男女生的总分、平均分、最高分
SELECT class,gender,sum(score),avg(score),max(score) FROM hr.stu_score GROUP BY class,gender;
-- 统计平均分在500以上的班级的总分、平均分、最高分
SELECT class,sum(score),avg(score),max(score) FROM hr.stu_score GROUP BY class HAVING avg(score)>500;
-- 统计男生的总分、平均分、最高分
SELECT sum(score),avg(score),max(score) FROM hr.stu_score WHERE gender='男';

-- 统计各班男生的总分、平均分、最高分
SELECT class,sum(score),avg(score),max(score) FROM hr.stu_score WHERE gender='男' GROUP BY class;

