-- 子查询
-- 子查询又被称为嵌套查询，可以用在WHERE、HAVING、FROM子句中
-- 内层查询会被优先执行，越是内层的查询，优先级就越高

-- 查询出工资大于first_name是'Bruce'的那些员工
SELECT salary FROM hr.employees WHERE first_name='Bruce';
SELECT * FROM hr.employees WHERE salary>6000;

-- 单行子查询
-- 可以使用>、<、>=、<=、=、!=
SELECT * FROM hr.employees WHERE salary>(SELECT salary FROM hr.employees WHERE first_name='Bruce');

-- 多行子查询
-- 可以使用ANY、ALL、IN
-- ANY：
--      大于：大于结果中最小的值
--      小于：小于结果中最大的值
--      等于：相当于IN的效果
--      不等：如果查出来的数据等于一条，相当于不等于此值
--               如果查出来的数据多于一条，则会查出所有数据
SELECT * FROM hr.employees
WHERE salary> ANY (SELECT salary FROM hr.employees WHERE first_name='David');

SELECT * FROM hr.employees
WHERE salary< ANY (SELECT salary FROM hr.employees WHERE first_name='David');

SELECT * FROM hr.employees
WHERE salary=ANY (SELECT salary FROM hr.employees WHERE first_name='David');

SELECT * FROM hr.employees
WHERE salary!=ANY (SELECT salary FROM hr.employees WHERE first_name='David');

-- ALL：
--      大于：大于结果中最大的
--      小于：小于结果中最小的
--      等于：NULL
--      不等：相当于NOT IN的效果
SELECT * FROM hr.employees
WHERE salary> ALL (SELECT salary FROM hr.employees WHERE first_name='David');

SELECT * FROM hr.employees
WHERE salary< ALL (SELECT salary FROM hr.employees WHERE first_name='David');

SELECT * FROM hr.employees
WHERE salary=ALL (SELECT salary FROM hr.employees WHERE first_name='David');

SELECT * FROM hr.employees
WHERE salary!=ALL (SELECT salary FROM hr.employees WHERE first_name='David');

--  在多行子查询中除ANY和ALL外，也可以使用IN或NOT IN
SELECT * FROM hr.employees
WHERE salary IN  (SELECT salary FROM hr.employees WHERE first_name='David');

SELECT * FROM hr.employees
WHERE salary NOT IN  (SELECT salary FROM hr.employees WHERE first_name='David');

-- 使用子查询复制表结构并复制符合条件的数据
CREATE TABLE hr.HIGH_SALARY_EMPLOYEES
AS
(SELECT * FROM hr.employees WHERE salary>=10000)

-- 使用子查询进行表结构的复制，不复制数据（使用一个结果是false的子查询）
CREATE TABLE hr.EMPTY_SALARY_EMPLOYEES
AS
(SELECT * FROM hr.employees WHERE 1=2)

-- 通过子查询复制数据
INSERT INTO hr.EMPTY_SALARY_EMPLOYEES
(employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id)
(SELECT * FROM hr.employees WHERE salary<10000)

-- 如果复制所有列，可以省略列名列表
INSERT INTO hr.EMPTY_SALARY_EMPLOYEES (SELECT * FROM hr.employees WHERE salary<10000)