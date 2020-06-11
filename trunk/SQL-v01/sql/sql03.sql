-- 字符串函数
-- 转换大小写
SELECT upper('aBcdEFg'),lower('abcDEFghiJKLMN') FROM dual;

-- 拼接字符串
SELECT 'ABCD'||'  '||'xyz', concat('Hello ','World!') FROM dual; 

-- 截取字符串中的子串：第一个参数是从什么字符中取，第二个参数是从哪位开始fwbc，第三个参数是取多少字符
SELECT substr('abcdefghijklmn',3,5) FROM dual;

-- 得到字符串的长度
SELECT length('abcdefghijklmnop') FRom dual;

-- 在字符串的左侧填充指定的字符串，第二个参数是要填充的最大宽度
-- 如果原始字符串长度大于第二个参数设置的值，则截取掉大于 宽度的部分。
SELECT lpad('abc',10,'$') FROM dual;
SELECT lpad('abcdefghijklmn',10,'$') FROM dual;

-- 在字符串的右侧填充指定的字符串，第二个参数是要填充的最大宽度
SELECT rpad('abc',10,'$') FROM dual;
SELECT rpad('abcdefghijklmn',10,'$') FROM dual;

-- 替换字符串中的某一部分
SELECT replace('This is an apple!','is','IS') FROM dual;

-- 修剪
SELECT TRIM('          LSKDFD        ') FROM DUAL;


-- 数学函数
-- 四舍五入
SELECT round(3.1415926,2) FROM dual
SELECT round(3.1415926,3) FROM dual
SELECT round(3.1415926,0) FROM dual
SELECT round(217889433.1415926,-2) FROM dual

-- 截取
SELECT trunc(3.1415926,2) FROM dual
SELECT trunc(3.1415926,3) FROM dual
SELECT trunc(3.1415926,0) FROM dual
SELECT trunc(217889433.1415926,-2) FROM dual

-- 取余
SELECT mod(28,5) FROM dual
SELECT mod(-28,5) FROM dual
SELECT mod(28,-5) FROM dual
SELECT mod(-28,-5) FROM dual

-- 日期
-- 取系统时间
SELECT sysdate FROM dual

-- 数据类型转换
-- 日期转字符串
-- 格式标识：yyyy年，mm月，month英文的月份全称，mon是英文月份的简称（由三个字母组成）
-- day是星期几（英文全称），dy是星期几的简称（三个字母组成），dd月中的日期
-- hh24，hh12分别表示24小时制和12小时制的小时，mi分钟，ss秒
SELECT to_char(sysdate,'yyyy/mm/dd hh24:mi') FROM dual;

-- 数字转换为字符串
-- 格式标识：9表示一个数字，0表示0，$表示美元符号，L表示本地货币符号，.表示点，,表示逗号
SELECT to_char(12345,'99,999,999') FROM dual;
SELECT to_char(12345,'00,000,000') FROM dual;
SELECT to_char(12345,'$99,999,999') FROM dual;
SELECT to_char(12345,'L99,999,999') FROM dual;
-- 如果数字的长度超出了格式串指定的长度，则显示一串#来加以警告
SELECT to_char(1234567890,'99,999,999') FROM dual;

-- 字符串转日期
SELECT to_date('2015-12-12','yyyy-mm-dd') FROM dual;

-- 字符串转数字
SELECT to_number('$129,390,239','$999,999,999') FROM dual;


-- 通用函数
-- nvl函数用于安全的处理null值，当第一个参数是null时返回第二个参数值，否则直接返回第一个参数值
SELECT nvl('abc','empty') FROM dual;
SELECT nvl(null,'empty') FROM dual;

-- nvl2函数
-- 也用于安全的处理null值，当第一个参数是null时返回第三个参数的值，否则返回第二个参数的值
SELECT nvl2('abc','ABC','empty') FROM dual;
SELECT nvl2(null,'ABC','empty') FROM dual;
SELECT nvl2('','ABC','empty') FROM dual;

-- nullif函数：如果参数1不等于参数2，返回参数1，否则返回null
SELECT nullif(1,2) FROM dual;
SELECT nullif(1,1) FROM dual;

-- coalesce函数返回参数列表中第一个非null的值，如果参数列表中的所有值都是null，则返回null
SELECT coalesce(1,2,3,4,5) FROM dual;
SELECT coalesce(null,2,3,4,5) FROM dual;
SELECT coalesce(null,2,null,4,5) FROM dual;
SELECT coalesce(null,null,null,5) FROM dual;
SELECT coalesce(null,null,null,null) FROM dual;

-- 统计函数
-- 总数量：count；总和：sum；平均：avg；最大：max；最小：min

-- 查询所有员工总数
SELECT count(*) FROM hr.employees
-- 推荐使用表中的主键列进行count统计
SELECT count(employee_id) FROM hr.employees;

-- 查询id是100的部门有多少员工
SELECT count(employee_id) FROM hr.employees WHERE department_id=100;
-- 查询工资大于等于10000的员工数量
SELECT count(employee_id) FROM hr.employees WHERE salary>=10000;


-- 求所有员工的总工资
SELECT sum(salary) FROM hr.employees;
-- 查询id是100的部门的员工总工资
SELECT sum(salary) FROM hr.employees WHERE department_id=100;


-- 求公司所有员工的平均工资
SELECT avg(salary) FROM hr.employees;
SELECT round(avg(salary),2) FROM hr.employees;
-- 查询id是100的部门的员工的平均工资
SELECT round(avg(salary),2) FROM hr.employees WHERE department_id=100;

-- 求公司中最高工资和最低工资及它们的差
SELECT min(salary) 最低工资,max(salary) 最高工资, (max(salary)-min(salary)) FROM hr.employees;