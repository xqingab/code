# JNDI
#jdbc.jndiName=java\:comp/env/jdbc/OracleDB

# JDBC setting for MySQL
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8
jdbc.username=root
jdbc.password=123456
jdbc.initialSize=50
jdbc.maxActive=50
jdbc.maxIdle=50
jdbc.minIdle=20
jdbc.maxWait=300000

# JDBC setting for ORACLE
#jdbc.driverClassName=oracle.jdbc.driver.OracleDriver
#jdbc.url=jdbc:oracle:thin:@166.111.3.150:1521:forten
#jdbc.username=scott
#jdbc.password=tiger

# Hibernate setting
hibernate.cache.use_query_cache=true
hibernate.cache.use_second_level_cache=true
hibernate.cache.region.factory_class=org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory
hibernate.dialect=org.hibernate.dialect.MySQLDialect
#hibernate.dialect=org.hibernate.dialect.Oracle10gDialect
hibernate.jdbc.fetch_size=50
hibernate.jdbc.batch_size=50
hibernate.jdbc.use_streams_for_binary=true
hibernate.show_sql=true
hibernate.hbm2ddl.auto=update
