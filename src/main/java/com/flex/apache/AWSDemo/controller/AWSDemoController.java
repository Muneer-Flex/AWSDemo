/**
 * 
 */
package com.flex.apache.AWSDemo.controller;

import static com.flex.apache.AWSDemo.util.AppConstants.APP;
import static com.flex.apache.AWSDemo.util.AppConstants.HEALTH_CHECK;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class AWSDemoController {

	@Value("${appName}")
	private String appName;

	@Value("${appVersion}")
	private String appVersion;

	@RequestMapping(value = HEALTH_CHECK, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
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
