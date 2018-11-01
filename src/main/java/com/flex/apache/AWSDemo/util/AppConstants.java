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
	
	public static final String APP = "/App";
	
	public static final String EMPLOYEE = "/Employee";
	
	public static final String HEALTH_CHECK = "/healthCheck";
	
	public static final String LIST_EMPLOYEE = "/listEmpDetails";
	
	public static final String CREATE_EMPLOYEE = "/createEmloyee";
	
	public static final String UPDATE_EMPLOYEE = "/updateEmployee";
	
	public static final String DELETE_EMPLOYEE = "/deleteEmployee";
	
	public static final String SUCCESS_MSG = "Employee Details Created/Updated/Deleted Successfully!";
	
	public static final String ERROR_MSG = "Failed to Create/Update/Delete Employee Details!";
	
	//Swagger Constants
	public static final String SWAGGER_URL = "swagger-ui.html";
	
	public static final String APP_TITLE = "ACCOUNT MANAGEMENT";
	
	public static final String VERSION = "1.0.0";
	
	public static final String APP_NAME = "Account-Management";
	
	public static final String ABOUT = "https://flex.com/about/";
	
	public static final String CONTACT_EMAIL = "MuneerAhmed.J@Flex.com";
	
	//Http Client Constants
	public static final String HTTP_OK = "Success|OK";
	
	public static final String HTTP_UNAUTHORIZED = "Not Authorized";
	
	public static final String HTTP_FORBIDDEN = "Forbidden";
	
	public static final String HTTP_NOT_FOUND = "Not Found";
}
