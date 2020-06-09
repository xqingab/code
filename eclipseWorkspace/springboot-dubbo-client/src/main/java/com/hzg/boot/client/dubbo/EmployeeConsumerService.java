package com.hzg.boot.client.dubbo;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hzg.boot.client.entity.Employee;

/**
 *  * dubbo 员工消费者  * @author hzg1214  *  
 */
@Component
public class EmployeeConsumerService {

	@Reference(version = "1.0.0")
	EmployeeService employeeService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void printEmployee() {
		String employeeName = "上海";
		if (employeeService == null) {
			System.out.println("employeeService 服务对象 为空");
		} else {
			Employee employee = employeeService.queryEmployeeByName(employeeName);
			System.out.println(employee.toString());
		}
	}

}