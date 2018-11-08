/**
 * 
 */
package com.flex.apache.AWSDemo.controller;

import static com.flex.apache.AWSDemo.util.AppConstants.APP;
import static com.flex.apache.AWSDemo.util.AppConstants.HEALTH_CHECK;
import static com.flex.apache.AWSDemo.util.AppConstants.HTTP_FORBIDDEN;
import static com.flex.apache.AWSDemo.util.AppConstants.HTTP_NOT_FOUND;
import static com.flex.apache.AWSDemo.util.AppConstants.HTTP_OK;
import static com.flex.apache.AWSDemo.util.AppConstants.HTTP_UNAUTHORIZED;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class is the controller for Application Health Check.
 * 
 * @author gssmunej
 * @version 1.0
 * 
 */
@RestController
@PropertySource("classpath:application.properties")
@RequestMapping(APP)
@Api(value="HealthCheck")
public class AWSDemoController {

	@Value("${appName}")
	private String appName;

	@Value("${appVersion}")
	private String appVersion;

	@ApiOperation(value="Health Check", notes="This API is used to perform Health Check of the App")
	@ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = HTTP_OK),
            @ApiResponse(code = HttpStatus.SC_UNAUTHORIZED, message = HTTP_UNAUTHORIZED),
            @ApiResponse(code = HttpStatus.SC_FORBIDDEN, message = HTTP_FORBIDDEN),
            @ApiResponse(code = HttpStatus.SC_NOT_FOUND, message = HTTP_NOT_FOUND) })
	@RequestMapping(value = HEALTH_CHECK, method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String healthCheck() {

		StringBuilder sb = new StringBuilder();
		
		sb.append("App Name is: ");
		sb.append(appName);
		sb.append(" and App Version is: ");
		sb.append(appVersion);
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		sb.append("Welcome to Amazon Web Service Demo!");

		return sb.toString();
	}
}
