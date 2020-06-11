-- 分组统计
-- 按部门分组统计出工资总和、平均工资、最小工资、最大工资、部门人数
SELECT department_id,sum(salary),avg(salary),min(salary),max(salary),count(employee_id)
FROM hr.employees
GROUP BY department_id
ORDER BY department_id;

-- 按部门和工种分组统计出工资总和、平均工资、最小工资、最大工资、部门人数
SELECT department_id,sum(salary),avg(salary),min(salary),max(salary),count(employee_id)
FROM hr.employees
GROUP BY department_id, job_id
ORDER BY department_id;

-- 按部门分组统计出平均工资大于等于8000的部门的工资总和、平均工资、最小工资、最大工资、部门人数
SELECT department_id,sum(salary),avg(salary),min(salary),max(salary),count(employee_id)
FROM hr.employees
--WHERE avg(salary)>=8000  错误，WHERE子句中不允许使用分组函数
GROUP BY department_id
HAVING avg(salary)>=8000
ORDER BY department_id;

-- 查询出所有非销售人员所在部门的平均工资大于等于8000的工资总和、平均工资、最小工资、最大工资、部门人数
-- 如果使用WHERE和HAVING子句都可以完成某项查询，则优先使用WHERE
-- WHERE筛选的时机是在分组之前
-- HAVING筛选的时机是在分组之后
SELECT department_id,sum(salary),avg(salary),min(salary),max(salary),count(employee_id)
FROM hr.employees
WHERE commission_pct IS NULL
GROUP BY department_id
HAVING avg(salary)>=8000
ORDER BY department_id;

-- 查询出平均工资最小的那个部门
SELECT min(avg(salary)) FROM hr.employees
GROUP BY department_id
