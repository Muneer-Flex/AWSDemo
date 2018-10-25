/**
 * 
 */
package com.flex.apache.AWSDemo.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gssmunej
 *
 */
@Entity
@Table(name="EMP")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMP_ID")
	private int empId;

	@Column(name = "EMP_NAME")
	private String empName;

	@Column(name = "EMP_EMAIL_ID")
	private String empEmailId;

	public Employee() {
		// Default Constructor
	}

	/**
	 * @param empId
	 * @param empName
	 * @param empEmailId
	 */
	public Employee(int empId, String empName, String empEmailId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmailId = empEmailId;
	}

	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId
	 *            the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName
	 *            the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the empEmailId
	 */
	public String getEmpEmailId() {
		return empEmailId;
	}

	/**
	 * @param empEmailId
	 *            the empEmailId to set
	 */
	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmailId=" + empEmailId + "]";
	}

}
