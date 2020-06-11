-- 查询数据使用SELECT语句
-- 简单格式：SELECT 列名1[,列名2,.....,列名n]|* FROM schema名.表名

-- 查询国家表中的所有数据
SELECT * FROM hr.countries;

-- 只查询所有国家的id和名称
SELECT country_id,country_name FROM hr.countries;

-- 添加两条国家名称都是'Zimbabwe'的数据，用于测试DISTINCT的作用
INSERT INTO hr.countries VALUES ('ZZ','Zimbabwe',4);
INSERT INTO hr.countries VALUES ('ZY','Zimbabwe',4);

-- DISTINCT用于对查询出的数据结果集合进行排重操作
-- 会影响性能
SELECT DISTINCT country_name,region_id FROM hr.countries;

-- Oracle中可以使用名为dual的一张虚表来对表达式进行运算
SELECT 3*5 FROM DUAL;
-- 在sql中，对字符串进行拼接的运算符是"||"
SELECT 'Hello' || 'World!' FROM dual;

-- 可以使用as为列或表分配别名，在Oracle中AS也可以省略
SELECT 3*5 AS 乘积 FROM DUAL;
SELECT 3*5 乘积 FROM DUAL;
SELECT c.country_id 国家id,c.country_name 国家名称 FROM hr.countries c;

-- 使用WHERE子句进行数据的条件查询
-- 比较运算符：>、>=、<、<=、=、!=(<>)
-- 查询所属大洲id不是2的那些国家数据
SELECT * FROM hr.countries WHERE region_id!=2;
-- 查询所属大洲id是2的那些国家数据
SELECT * FROM hr.countries WHERE region_id=2;
-- 查询所属大洲id大于2的那些国家数据
SELECT * FROM hr.countries WHERE region_id>2;

-- 为测试IS NULL准备数据
UPDATE hr.countries SET country_name=null WHERE country_id='ZZ';

-- IS NULL和IS NOT NULL用于筛选某个字段的值为null或不为null的数据
SELECT * FROM hr.countries WHERE country_name IS NULL;
SELECT * FROM hr.countries WHERE country_name IS NOT NULL;

-- ORDER BY子句可以对查询出的数据结果集合进行排序
-- 排序分为两种：升序和降序，分别使用ASC和DESC表示，升序是默认的排序类型，所以ASC可以省略
-- 可使用多个字段进行排序，先按首要字段（在前边的）排序，
-- 如果首要字段的值相同，则再按次要字段的数据进行排序，可分别指定排序方式

-- 按国家所在大洲的id升序排序
SELECT * FROM hr.countries ORDER BY region_id ASC;
-- ASC是默认排序类型，所以可以省略，结果与上一条语句一致
SELECT * FROM hr.countries ORDER BY region_id;
-- 按国家所在大洲的id降序排序
SELECT * FROM hr.countries ORDER BY region_id DESC;

-- 先按所在大洲id进行升序排序，如果所在大洲的id一致则这批数据再按国家名称降序排序
SELECT * FROM hr.countries ORDER BY region_id ASC,country_name DESC;

-- ORDER BY子句在SELECT语句的最末位置
-- 查询所在大洲id是2的那些国家，并以国家名称升序排序
SELECT * FROM hr.countries WHERE region_id=2 ORDER BY country_name;

-- 字符串查询可以使用LIKE表达式
-- 通配符%表示0到多个任意字符，通配符_表示1个任意字符
-- 查询所有名称以C开头的国家数据
SELECT * FROM hr.countries WHERE country_name LIKE 'C%';
-- Oracle对字符串中的大小写字母是敏感的，所以以下语句不能得到任何数据结果
SELECT * FROM hr.countries WHERE country_name LIKE 'c%';
-- 可以使用lower()或upper()函数进行字段或值的处理，来屏蔽掉以上问题
-- 数据还是原始值，只是在比较时进行了大小写字母的转换
SELECT * FROM hr.countries WHERE lower(country_name) LIKE 'c%';
-- 查询名称以C开头并且长度是5个字符的数据
SELECT * FROM hr.countries WHERE country_name LIKE 'C____';

-- 以下两条语句的结果是一致的
-- 都是在做精确匹配查询，但=操作符性能更好
SELECT * FROM hr.countries WHERE country_name LIKE 'China';
SELECT * FROM hr.countries WHERE country_name='China';

-- 查询国家名称中包含c的数据
SELECT * FROM hr.countries WHERE lower(country_name) LIKE '%c%';
-- 查询国家名称以a结尾的数据
SELECT * FROM hr.countries WHERE lower(country_name) LIKE '%a';

-- IN：只要字段中的数据在IN表达式中的括号里出现，则就是符合条件的数据
-- 查询所在大洲id是1和3的那些国家
SELECT * FROM hr.countries WHERE region_id IN (1,3);
-- 查询所在大洲id是1,3,4的那些国家
SELECT * FROM hr.countries WHERE region_id IN (1,3,4);
-- IN是逻辑或的一种简写形式
SELECT * FROM hr.countries WHERE region_id=1 OR region_id=3 OR region_id=4;
-- 查询所在大洲id不是1,3,4的那些国家
SELECT * FROM hr.countries WHERE region_id NOT IN (1,3,4);

-- BETWEEN：可以定义查询字段的值是否在某个范围内，是闭区间
-- 查询所在大洲id在2到4之间的那些国家
SELECT * FROM hr.countries WHERE region_id BETWEEN 2 AND 4;
-- BETWEEN是逻辑与的一种简写形式
SELECT * FROM hr.countries WHERE region_id>=2 AND region_id<=4;
-- 查询所在大洲id不在2到4之间的那些国家
SELECT * FROM hr.countries WHERE region_id NOT BETWEEN 2 AND 4;

-- 查询所在大洲id是1或者国家名称中包含C的数据
SELECT * FROM hr.countries WHERE region_id=1 OR upper(country_name) LIKE '%C%';
-- 查询所在大洲id是1并且国家名称中包含C的数据
SELECT * FROM hr.countries WHERE region_id=1 AND upper(country_name) LIKE '%C%';
-- 查询所在大洲的id不是1或国家名称中不包含C的数据
SELECT * FROM hr.countries WHERE NOT (region_id=1 OR upper(country_name) LIKE '%C%');