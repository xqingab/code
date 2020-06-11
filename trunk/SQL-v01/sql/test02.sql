-- 查询员工姓名及其所属部门的名称
SELECT e.first_name,d.department_name
FROM hr.employees e JOIN hr.departments d
    ON (e.department_id=d.department_id)
-- 106
SELECT e.first_name,d.department_name
FROM hr.employees e LEFT JOIN hr.departments d
    ON (e.department_id=d.department_id)
-- 107
    
-- 查询员工姓名及其所属部门的名称和部门所在城市
SELECT e.first_name,d.department_name,lo.city
FROM hr.employees e JOIN hr.departments d
    ON (e.department_id=d.department_id)
JOIN hr.locations lo
    ON (lo.location_id=d.location_id)

-- 查询工资大于等于10000的员工姓名、所属部门名称和所在城市
SELECT e.first_name,d.department_name,lo.city
FROM hr.employees e JOIN hr.departments d
    ON (e.department_id=d.department_id)
JOIN hr.locations lo
    ON (lo.location_id=d.location_id)
WHERE 
    e.salary>=10000
    
-- 查询部门名称是IT的所有员工的姓名，工资和所在城市
SELECT e.first_name,e.salary,lo.city
FROM hr.employees e JOIN hr.departments d
    ON (e.department_id=d.department_id)
JOIN hr.locations lo
    ON (lo.location_id=d.location_id)
WHERE 
    d.department_name='IT'

-- 查询IT部门所有员工的姓名和职位
SELECT e.first_name,j.job_title,d.department_name
FROM hr.employees e JOIN hr.jobs j
	ON (e.job_id=j.job_id)
JOIN hr.departments d
	ON (d.department_id=e.department_id)
WHERE d.department_name='IT'

-- 查询部门对应的经理姓名
SELECT d.department_name,e.first_name
FROM hr.employees e JOIN hr.departments d
    ON (e.employee_id=d.manager_id)
    
-- 查询所有员工的姓名，如果是经理，显示他所在的部门
SELECT d.department_name,e.first_name
FROM hr.employees e LEFT JOIN hr.departments d
    ON (e.employee_id=d.manager_id)
    
-- 查询所有部门，如果部门中有经理，显示其姓名
SELECT d.department_name,e.first_name
FROM hr.employees e RIGHT JOIN hr.departments d
    ON (e.employee_id=d.manager_id)
    
-- 查询所有部门和员工，如果部门有经理则显示出其姓名
SELECT d.department_name,e.first_name
FROM hr.employees e FULL JOIN hr.departments d
    ON (e.employee_id=d.manager_id)