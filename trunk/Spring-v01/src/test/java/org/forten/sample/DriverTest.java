package org.forten.sample;

import static org.junit.Assert.*;

import org.forten.sample.model.Car;
import org.forten.sample.model.Driver;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DriverTest {
	@Test
	public void testOldWay() throws Exception {
		Car c = new Car();
		c.setName("法拉利");
		c.setPrice(2000000);
		c.setSpeed(200);
		Driver d = new Driver();
		d.setName("吕布");
		d.setAge(45);
		d.setCar(c);
		d.drive();
	}
	
	@Test
	public void testIoC() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/app-*.xml");
		Driver d1 = ctx.getBean("d1", Driver.class);
		d1.drive();
		
		Driver d2 = ctx.getBean("d2",Driver.class);
		d2.drive();
		
		Driver d3 = ctx.getBean("d3",Driver.class);
		d3.drive();
	}
}
