-- 老式的连接写法
-- 通过WHERE子句中的条件，把某张表的主键与另一张表的外键进行连接
SELECT hr.countries.country_id,hr.countries.country_name,HR.regions.region_name
FROM hr.countries,HR.regions
WHERE hr.countries.region_id=HR.regions.region_id

-- 使用别名进行老式的连接
SELECT c.country_id,c.country_name,r.region_name
FROM hr.countries c,HR.regions r
WHERE c.region_id=r.region_id

-- 自然连接
-- 自动查找两张表中字段名称和字段类型一致的两个列，进行关系的连接
-- 如果字段名相同，类型不同会返回错误
SELECT c.country_id,c.country_name,r.region_name
FROM hr.countries c NATURAL JOIN HR.regions r

-- 内连接
-- 只返回两张表中存在匹配关系的行，孤立的行不会被返回
-- 可以使用INNER JOIN或JOIN来进行内连接
SELECT c.country_id,c.country_name,r.region_name
FROM hr.countries c INNER JOIN HR.regions r
ON (c.region_id=r.region_id)

SELECT c.country_id,c.country_name,r.region_name
FROM hr.countries c JOIN HR.regions r
ON (c.region_id=r.region_id)

-- 连接两张以上的数据表
SELECT c.country_id,c.country_name,r.region_name,lo.street_address,lo.city
FROM hr.regions r JOIN hr.countries c
    ON (r.region_id=c.region_id)
JOIN hr.locations lo
    ON (c.country_id=lo.country_id)
    
-- 外连接：左外连接、右外连接、全外连接
-- 左外连接：除了所有可以与右表匹配的数据之外，还可返回指定的左侧表中没有被匹配的数据
SELECT c.country_id,c.country_name,r.region_name
FROM hr.countries c LEFT OUTER JOIN HR.regions r
ON (c.region_id=r.region_id)

-- OUTER可以省略
SELECT c.country_id,c.country_name,r.region_name
FROM hr.countries c LEFT JOIN HR.regions r
ON (c.region_id=r.region_id)

-- 右外连接：除了所有可以与左表匹配的数据之外，还可返回指定的右侧表中没有被匹配的数据
SELECT c.country_id,c.country_name,r.region_name
FROM hr.countries c RIGHT OUTER JOIN HR.regions r
ON (c.region_id=r.region_id)

-- OUTER可以省略
SELECT c.country_id,c.country_name,r.region_name
FROM hr.countries c RIGHT JOIN HR.regions r
ON (c.region_id=r.region_id)

-- 全外连接：除了可以返回所有匹配的数据之外，还可以返回左右两侧表中没有被匹配上的数据
SELECT c.country_id,c.country_name,r.region_name
FROM hr.countries c FULL OUTER JOIN HR.regions r
ON (c.region_id=r.region_id)

-- OUTER可以省略
SELECT c.country_id,c.country_name,r.region_name
FROM hr.countries c FULL JOIN HR.regions r
ON (c.region_id=r.region_id)

-- 交叉连接
-- 可返回两表中数据的笛卡尔积
SELECT c.country_id,c.country_name,r.region_name
FROM hr.countries c CROSS JOIN HR.regions r

-- 自连接
-- 数据虽然组织在同一张表中，但通过概念细分可以把这张表拆分成多张后再进行连接
-- 查询员工姓名和其直属上司的姓名
SELECT e.department_id,e.first_name||' '||e.last_name,m.first_name||' '||m.last_name
FROM hr.employees e LEFT OUTER JOIN hr.employees m
ON (m.employee_id=e.manager_id)
ORDER BY e.department_id

-- 不等连接
-- 创建工资等级表
CREATE TABLE hr.salary_level
(
	id char(1 char) primary key,
	min_salary number(6,1),
	max_salary number(7,1)
);
-- 添加数据
INSERT INTO hr.salary_level VALUES ('A',20000,30000);
INSERT INTO hr.salary_level VALUES ('B',15000,19999);
INSERT INTO hr.salary_level VALUES ('C',10000,14999);
INSERT INTO hr.salary_level VALUES ('D',5000,9999);
INSERT INTO hr.salary_level VALUES ('E',0,4999);

-- 查询每个员工的所属工资等级
SELECT e.first_name,e.salary,sl.id
FROM hr.employees e JOIN hr.salary_level sl
on (e.salary BETWEEN sl.min_salary AND sl.max_salary)
