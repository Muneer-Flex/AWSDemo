/**
 * 
 */
package com.flex.apache.AWSDemo.controller;

import static com.flex.apache.AWSDemo.util.AppConstants.CREATE_EMPLOYEE;
import static com.flex.apache.AWSDemo.util.AppConstants.DELETE_EMPLOYEE;
import static com.flex.apache.AWSDemo.util.AppConstants.EMPLOYEE;
import static com.flex.apache.AWSDemo.util.AppConstants.ERROR_MSG;
import static com.flex.apache.AWSDemo.util.AppConstants.HTTP_FORBIDDEN;
import static com.flex.apache.AWSDemo.util.AppConstants.HTTP_NOT_FOUND;
import static com.flex.apache.AWSDemo.util.AppConstants.HTTP_OK;
import static com.flex.apache.AWSDemo.util.AppConstants.HTTP_UNAUTHORIZED;
import static com.flex.apache.AWSDemo.util.AppConstants.LIST_EMPLOYEE;
import static com.flex.apache.AWSDemo.util.AppConstants.UPDATE_EMPLOYEE;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flex.apache.AWSDemo.dao.Employee;
import com.flex.apache.AWSDemo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class is the controller for Employee Details.
 * 
 * @author gssmunej
 * @version 1.0
 * 
 */
@RestController
@RequestMapping(EMPLOYEE)
@Api(value="AWSDemo")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@ApiOperation(value="List Employee", notes="This API is used to list down all the employees in DB")
	@ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = HTTP_OK),
            @ApiResponse(code = HttpStatus.SC_UNAUTHORIZED, message = HTTP_UNAUTHORIZED),
            @ApiResponse(code = HttpStatus.SC_FORBIDDEN, message = HTTP_FORBIDDEN),
            @ApiResponse(code = HttpStatus.SC_NOT_FOUND, message = HTTP_NOT_FOUND) })
	@RequestMapping(value = LIST_EMPLOYEE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Employee> listEmployeeDetails() {

		List<Employee> empList = new ArrayList<>();

		try {
			empList = employeeService.listEmployeeDetails();

			return empList;

		} catch (Exception exception) {
			System.out.println(
					"Exception occured in AWSDemoController#listEmployeeDetails(). The Exception is:: " + exception);
		}

		return empList;
	}
	
	@ApiOperation(value="Create Employee", notes="This API is used to create & store the Employee details in DB")
	@ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = HTTP_OK),
            @ApiResponse(code = HttpStatus.SC_UNAUTHORIZED, message = HTTP_UNAUTHORIZED),
            @ApiResponse(code = HttpStatus.SC_FORBIDDEN, message = HTTP_FORBIDDEN),
            @ApiResponse(code = HttpStatus.SC_NOT_FOUND, message = HTTP_NOT_FOUND) })
	@RequestMapping(value=CREATE_EMPLOYEE, method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.TEXT_PLAIN_VALUE)
	public String createEmployeeDetails(@RequestBody Employee employee) {

		String result = null;

		try {
			result = employeeService.createEmployeeDetails(employee);

			return result;
		} catch (Exception exception) {
			result = ERROR_MSG;

			System.out.println(
					"Exception occured in AWSDemoController#createEmployeeDetails(). The Exception is:: " + exception);
		}

		return result;
	}
	
	@ApiOperation(value="Update Employee", notes="This API is used to update the Employee details in DB")
	@ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = HTTP_OK),
            @ApiResponse(code = HttpStatus.SC_UNAUTHORIZED, message = HTTP_UNAUTHORIZED),
            @ApiResponse(code = HttpStatus.SC_FORBIDDEN, message = HTTP_FORBIDDEN),
            @ApiResponse(code = HttpStatus.SC_NOT_FOUND, message = HTTP_NOT_FOUND) })
	@RequestMapping(value=UPDATE_EMPLOYEE, method=RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.TEXT_PLAIN_VALUE)
	public String updateEmployeeDetails(@RequestBody Employee employee) {
		
		String result = null;
		
		try {
			result = employeeService.updateEmployeeDetails(employee);
			
			return result;
		} catch(Exception exception) {
			result = ERROR_MSG;

			System.out.println(
					"Exception occured in AWSDemoController#updateEmployeeDetails(). The Exception is:: " + exception);
		}
		
		return result;
	}
	
	@ApiOperation(value="Delete Employee", notes="This API is used to delete the Employee details from DB")
	@ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = HTTP_OK),
            @ApiResponse(code = HttpStatus.SC_UNAUTHORIZED, message = HTTP_UNAUTHORIZED),
            @ApiResponse(code = HttpStatus.SC_FORBIDDEN, message = HTTP_FORBIDDEN),
            @ApiResponse(code = HttpStatus.SC_NOT_FOUND, message = HTTP_NOT_FOUND) })
	@RequestMapping(value=DELETE_EMPLOYEE, method=RequestMethod.DELETE, produces=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String deleteEmployeeDetails(@RequestParam("empId") int empId) {

		String result = null;

		try {
			result = employeeService.deleteEmployeeDetails(empId);

			return result;
		} catch (Exception exception) {
			result = ERROR_MSG;

			System.out.println(
					"Exception occured in AWSDemoController#deleteEmployeeDetails(). The Exception is:: " + exception);
		}
		
		return result;

	}
}
