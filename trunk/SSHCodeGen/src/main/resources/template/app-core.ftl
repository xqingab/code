<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:aop="http://www.springframework.org/schema/aop"
	xmlns:tx="http://www.springframework.org/schema/tx" xmlns:task="http://www.springframework.org/schema/task"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context-3.0.xsd
           http://www.springframework.org/schema/mvc 
           http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd
           http://www.springframework.org/schema/tx 
           http://www.springframework.org/schema/tx/spring-tx-3.0.xsd
           http://www.springframework.org/schema/aop
           http://www.springframework.org/schema/aop/spring-aop-3.0.xsd
           http://www.springframework.org/schema/task
           http://www.springframework.org/schema/task/spring-task-3.0.xsd">
	<mvc:annotation-driven />
	<aop:aspectj-autoproxy />
	<context:component-scan base-package="${basePackage}" />
	<context:property-placeholder location="classpath*:/system/*.properties" />

	<bean id="dataSource" destroy-method="close"
		class="org.apache.commons.dbcp.BasicDataSource">
		<property name="driverClassName" value="${'${'}jdbc.driverClassName${'}'}" />
		<property name="url" value="${'${'}jdbc.url${'}'}" />
		<property name="username" value="${'${'}jdbc.username${'}'}" />
		<property name="password" value="${'${'}jdbc.password${'}'}" />
		<property name="initialSize" value="${'${'}jdbc.initialSize${'}'}" />
		<property name="maxActive" value="${'${'}jdbc.maxActive${'}'}" />
		<property name="maxIdle" value="${'${'}jdbc.maxIdle${'}'}" />
		<property name="minIdle" value="${'${'}jdbc.minIdle${'}'}" />
		<property name="maxWait" value="${'${'}jdbc.maxWait${'}'}" />
	</bean>

	<!-- 配置Spring包装的Hibernate SessionFactory对象 -->
	<!-- 如果是Hibernate3，此处的class应该成org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean -->
	<!-- 如果是Hibernate4，此处的class应该成org.springframework.orm.hibernate4.LocalSessionFactoryBean -->
	<bean id="sessionFactory"
		class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="packagesToScan">
			<list>
				<value>${basePackage}.**.entity</value>
			</list>
		</property>
		<!-- Hibernate属性配置 -->
		<property name="hibernateProperties">
			<props>
				<prop key="hibernate.dialect">${'${'}hibernate.dialect${'}'}</prop>
				<prop key="hibernate.cache.use_second_level_cache">${'${'}hibernate.cache.use_second_level_cache${'}'}</prop>
				<prop key="hibernate.cache.use_query_cache">${'${'}hibernate.cache.use_query_cache${'}'}</prop>
				<prop key="hibernate.cache.region.factory_class">${'${'}hibernate.cache.region.factory_class${'}'}</prop>
				<prop key="hibernate.jdbc.fetch_size">${'${'}hibernate.jdbc.fetch_size${'}'}</prop>
				<prop key="hibernate.jdbc.batch_size">${'${'}hibernate.jdbc.batch_size${'}'}</prop>
				<prop key="hibernate.hbm2ddl.auto">${'${'}hibernate.hbm2ddl.auto${'}'}</prop>
				<prop key="hibernate.show_sql">${'${'}hibernate.show_sql${'}'}</prop>
			</props>
		</property>
	</bean>

	<bean id="transactionManager"
		class="org.springframework.orm.hibernate4.HibernateTransactionManager">
		<property name="sessionFactory" ref="sessionFactory"></property>
	</bean>

	<tx:annotation-driven transaction-manager="transactionManager" />
	
	<bean
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/pages/" />
		<property name="suffix" value=".jsp" />
	</bean>
	
	<bean id="multipartResolver"
		class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<property name="maxUploadSize" value="10485760" />
	</bean>
</beans>