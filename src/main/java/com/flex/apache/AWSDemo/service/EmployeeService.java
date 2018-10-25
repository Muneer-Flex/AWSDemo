/**
 * 
 */
package com.flex.apache.AWSDemo.service;

import static com.flex.apache.AWSDemo.util.AppConstants.ERROR_MSG;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flex.apache.AWSDemo.dao.Employee;
import com.flex.apache.AWSDemo.entity.EmployeeDao;

/**
 * This class acts as the service layer for Employee details.
 * 
 * @author gssmunej
 * @version 1.0
 * 
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public List<Employee> listEmployeeDetails() {

		List<Employee> empDaoList = null;

		try {
			empDaoList = new ArrayList<>();

			empDaoList = employeeDao.listEmployeeDetails();

			return empDaoList;
		} catch (Exception exception) {
			System.out.println(
					"Exception occured in EmployeeService#listEmployeeDetails(). The Exception is:: " + exception);
		}

		return empDaoList;

	}
	
	public String createEmployeeDetails(Employee employee) {

		String result = null;

		try {
			result = employeeDao.createEmployeeDetails(employee);

			return result;
		} catch (Exception exception) {
			
			result = ERROR_MSG; 
			
			System.out.println(
					"Exception occured in EmployeeService#createEmployeeDetails(). The Exception is:: " + exception);
		}
		
		return result;

	}
	
	public String updateEmployeeDetails(Employee employee) {
		
		String result = null;

		try {
			result = employeeDao.updateEmployeeDetails(employee);

			return result;
		} catch (Exception exception) {
			
			result = ERROR_MSG; 
			
			System.out.println(
					"Exception occured in EmployeeService#createEmployeeDetails(). The Exception is:: " + exception);
		}
		
		return result;

	}
	
	public String deleteEmployeeDetails(int empId) {

		String result = null;

		try {
			result = employeeDao.deleteEmployeeDetails(empId);

			return result;
		} catch (Exception exception) {

			result = ERROR_MSG;

			System.out.println(
					"Exception occured in EmployeeService#deleteEmployeeDetails(). The Exception is:: " + exception);
		}

		return result;
	}
}
