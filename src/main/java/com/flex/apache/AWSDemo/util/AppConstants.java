/**
 * 
 */
package com.flex.apache.AWSDemo.util;

/**
 * This class is for maintaining the App Constants.
 * 
 * @author gssmunej
 * @version 1.0
 * 
 */
public class AppConstants {

	private AppConstants() {
		//Default Constructors
	}
	
	public static final String HEALTH_CHECK = "/healthCheck";
	
	public static final String LIST_EMPLOYEE = "/Employee/listEmpDetails";
	
	public static final String CREATE_EMPLOYEE = "/Employee/createEmloyee";
	
	public static final String UPDATE_EMPLOYEE = "/Employee/updateEmployee";
	
	public static final String DELETE_EMPLOYEE = "/Employee/deleteEmployee";
	
	public static final String SUCCESS_MSG = "Employee Details Created/Updated/Deleted Successfully!";
	
	public static final String ERROR_MSG = "Failed to Create/Update/Delete Employee Details!";
}
