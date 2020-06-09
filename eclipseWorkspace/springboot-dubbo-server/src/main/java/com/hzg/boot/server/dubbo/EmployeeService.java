package com.hzg.boot.server.dubbo;
import com.hzg.boot.server.entity.Employee;
/**
 * 员工服务层接口
 * @author hzg1214
 *
 */
public interface EmployeeService {
/**
* 根据员工姓名查询 
* @param employeeName
* @return
*/
Employee queryEmployeeByName(String employeeName);

}
 