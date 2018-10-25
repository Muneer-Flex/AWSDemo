/**
 * 
 */
package com.flex.apache.AWSDemo.entity;

import static com.flex.apache.AWSDemo.util.AppConstants.ERROR_MSG;
import static com.flex.apache.AWSDemo.util.AppConstants.SUCCESS_MSG;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.flex.apache.AWSDemo.dao.Employee;
import com.flex.apache.AWSDemo.util.HibernateUtil;

/**
 * This class acts as the Dao Layer for Employee details.
 * 
 * @author gssmunej
 * @version 1.0
 * 
 */
@Repository
public class EmployeeDao {

	public EmployeeDao() {
		// Default Constructor
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployeeDetails() {

		List<Employee> empList = null;

		Session session = null;

		Query query = null;

		try {
			empList = new ArrayList<>();

			session = HibernateUtil.getSessionFatory().openSession();
			session.getTransaction().begin();
			
			String hql = "Select emp from Employee emp order by emp.empId";
			
			query = session.createQuery(hql);

			empList = query.list();

			return empList;
		} catch (Exception exception) {
			System.out
					.println("Exception occured in EmployeeDao#listEmployeeDetails(). The Exception is:: " + exception);
		} finally {

			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception exception) {
				System.out.println("Exception occured while closing session. The Exception is:: " + exception);
			}

		}

		return empList;

	}

	public String createEmployeeDetails(Employee employee) {

		String result = null;
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFatory().openSession();
			session.getTransaction().begin();
			
			session.save(employee);
			
			session.getTransaction().commit();
			
			result = SUCCESS_MSG;
			
			return result;
			 
		} catch (Exception exception) {
			
			result = ERROR_MSG; 
			
			System.out
					.println("Exception occured in EmployeeDao#createEmployeeDetails(). The Exception is:: " + exception);
		} finally {

			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception exception) {
				System.out.println("Exception occured while closing session. The Exception is:: " + exception);
			}

		}
		return result;

	}
	
	public String updateEmployeeDetails(Employee employee) {

		String result = null;

		Session session = null;
		
		Query query = null;
		
		try {
			session = HibernateUtil.getSessionFatory().openSession();
			session.getTransaction().begin();
			
			String hql = "UPDATE Employee set empName = :empName, empEmailId = :empEmailId WHERE empId = :empId";

			query = session.createQuery(hql);
			query.setParameter("empName", employee.getEmpName());
			query.setParameter("empEmailId", employee.getEmpEmailId());
			query.setParameter("empId", employee.getEmpId());
			
			int status = query.executeUpdate();
			
			session.getTransaction().commit();
			
			return status >=1 ? SUCCESS_MSG : ERROR_MSG;
			
		} catch (Exception exception) {

			result = ERROR_MSG;

			System.out.println(
					"Exception occured in EmployeeDao#updateEmployeeDetails(). The Exception is:: " + exception);
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception exception) {
				System.out.println("Exception occured while closing session. The Exception is:: " + exception);
			}
		}

		return result;

	}
	
	public String deleteEmployeeDetails(int empId) {

		String result = null;
		Session session = null;
		Query query = null;

		try {
			session = HibernateUtil.getSessionFatory().openSession();
			session.getTransaction().begin();

			String hql = "Delete from Employee where empId = :empId";
			query = session.createQuery(hql);
			query.setParameter("empId", empId);
			
			int status = query.executeUpdate();

			return status >= 1 ? SUCCESS_MSG : ERROR_MSG;

		} catch (Exception exception) {

			result = ERROR_MSG;

			System.out.println(
					"Exception occured in EmployeeDao#deleteEmployeeDetails(). The Exception is:: " + exception);
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception exception) {
				System.out.println("Exception occured while closing session. The Exception is:: " + exception);
			}
		}

		return result;
	}
}
