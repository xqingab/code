-- 视图
--          与表格相对，视图是逻辑存在的，以一条SELECT语句为基础
-- 优点：
--        限制数据访问
--        重用复杂的查询语句
--        保持数据的独立性
--        使用相同的数据提供不同的视图
-- 注意：
-- 何时不可以对视图中的数据进行delete
--        在创建视图的SELECT语句中存在分组函数
--        有GROUP BY子句
--        使用了distinct
--        使用了rownum伪列
-- 何时不何以对视图中的数据进行update
--        在创建视图的SELECT语句中存在分组函数
--        有GROUP BY子句
--        使用了distinct
--        使用了rownum伪列
--        使用了表达式来定义列
-- 何时不可以对视图中的数据时行 INSERT
--        在创建视图的SELECT语句中存在分组函数
--        有GROUP BY子句
--        使用了distinct
--        使用了rownum伪列
--        使用了表达式来定义列
--        基础表中有NOT NULL约束列，但没有被视图包含

-- 创建视图
CREATE VIEW hr.emp_connect
AS
SELECT employee_id,first_name||' '||last_name name,email,phone_number
FROM hr.employees

-- 对视图的查询与对表的查询一致
-- 只关注必要的数据列
SELECT * FROM hr.emp_connect
SELECT * FROM hr.emp_connect WHERE phone_number LIKE '650%'

CREATE VIEW hr.emp_connect2
AS
SELECT e.employee_id,e.first_name||' '||e.last_name name,e.email,e.phone_number,d.department_name
FROM hr.employees e LEFT JOIN hr.departments d
ON (e.department_id=d.department_id)

-- 重用复杂的查询语句
SELECT * FROM hr.emp_connect2

CREATE VIEW hr.emp_connect3
AS
SELECT e.employee_id,e.first_name||' '||e.last_name name,e.email,e.phone_number,d.department_name
FROM hr.employees e LEFT JOIN hr.departments d
ON (e.department_id=d.department_id)
WHERE e.salary>=10000;

SELECT * FROM hr.emp_connect3

-- 索引
-- 提高某些查询的性能，类似于书籍中的目录。

-- 索引的特点
--		独立于表
--		创建索引是手动的，使用索引是自动的
--		提高查询速度，迅速定位到磁盘中的数据所在位置

-- 自动创建：主键约束和唯一约束的列会被自动创建唯一索引
-- 手动创建：用户可为列创建索引，这种索引是非唯一索引
--		CREATE [UNIQUE] INDEX 索引名称 ON 表名(列1[,列2...,列n)

-- 何时应该创建索引（对于什么样的列应该创建索引）
--		列中取值范围比较宽的时候（重复出现的值不多）
--		含有大量null的列
--		一或多列经常被用在WHERE子句中
--		表中的数据很多，但大量查询只作用于其中较少的数据

-- 何时不应该创建索引（对于什么样的列不应该创建索引）
--		列不常作为WHERE子句中的条件进行查询
--		表中的数据少或大量查询获取的数据大于2%到4%
--		经常被更新的列
--		经常被用于表达式的一部分的列


-- 约束
--	用于保证数据的完整性
--	植根于数据库内部的机制，是最有效的数据完整性保障，推荐在数据库表的创建时就把数据约束定义好，性能高
--	类型：非空、唯一、主键、外键、CHECK
--	规则：
--		起一个有意义的约束名称
--		可在创建表时或修改表时加入约束
--		约束可以表或列级别上存在

-- 非空约束（Not Null）
--	保证列中不会插入null值，通常是列级别的定义
--		格式：列名  数据类型(长度) [CONSTRAINT 约束名称] NOT NULL [DEFAULT 默认值]

-- 唯一约束（UNIQUE）
--	保证一列中的数据不出现重复
--	默认会对被唯一约束限定的列创建唯一索引，以提高排重的性能
--	可以限定单独的列，也可以限定多列
--		格式：列名  数据类型(长度) [CONSTRAINT 约束名称] UNIQUE

-- 主键约束（PRIMARY KEY）——非空且唯一
--	一张表最多可以有一个主键约束
--	一个主键可以是一列或多列
--	主键的取值应该与业务无关，所以避免使用复合主键
--		格式：CONSTRAINT 约束名 PRIMARY KEY (列1[,列2...,列n)

-- 外键约束（FOREIGN KEY）
--	主表的主键在子表中相对应的那个引用列即为外键
--	格式：
--		CONSTRAINT 约束名 FOREING KEY (子表中映射父表主键的列名) REFERENCES 父表名称
--		ON DELETE CASCADE 当主表中的数据被删除时，首先会把子表中与其相关联的数据删除
--		ON DELETE SET NULL 当主表中的数据被删除时，首先会把子表中与其相关联的数据的外键列设置为null

-- CHECK约束
--	定义了每列（每行）必须遵守的规则
--	在设置条件的语句中不允许用以下表达式：CURRVAL、NEXTVAL、LEVEL、ROWNUM伪列、SYSDATE、UID、USER、USERINV函数
--	查询在其它行引用的其它值
--	格式：CONSTRAINT 约束名称 CHECK (条件表达式)



-- 事务
--	4大特性：ACID（原子性、一致性、隔离性、持久性）
--	原子性：整个事务中的所有对数据的操作要么全部完成，要么全部不完成，不可能停滞在中间某个环节。事务执行中发生错误后，会被回滚到事务开始前的状态。（转账）
--	一致性：在事务开始前和结束后，数据库的完整性约束没有被破坏。比如表与表之间存在外键约束，则对数据库进行修改时必须要满足约束条件，
--		    即如果修改了一张表中的数据，则需要修改与其存在外键约束关系的其它表中的对应数据，以达到一致。
--	隔离性：以隔离的状态执行事务，使它们好像是系统在给定时间内执行的唯一操作。如果有两个事务运行在相同的时间内，执行相同的功能，
--		    事务的隔离性将确保每一个事务在系统中认为只有该事务在使用系统。这种属性有时被称为“串行化”，为了防止事务操作间的混乱，必须串行化或序列化请求，
--		  使得在同一时间仅有一个请求用于同一数据。
--  持久性：在事务完成以后，此事务对数据库所作的更改会持久的保存在数据库中，并不会被回滚。

-- 序列
--	ORACLE数据库中特有的数据对象，通常用于表中主键值的生成
--	语法：
--	CREATE SEQUENCE seq名
--		START WITH 1
--		MAXVALUE 10
--		MINVALUE 1
--		NOCYCLE
--		CACHE 2
--		ORDER;

-- 读取下一值：SELECT seq名.NEXTVAL FROM dual
-- 读取当前值：SELECT seq名.CURRVAL FROM dual
















