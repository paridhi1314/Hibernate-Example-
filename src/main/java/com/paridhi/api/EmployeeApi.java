package com.paridhi.api;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.paridhi.Employee;
import com.paridhi.Hibernate.util.HibernateUtil;

public class EmployeeApi {
	public void detetetDEmployeeeDetails(int Id) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			session.beginTransaction();
			Employee employee = session.get(Employee.class,Id);
			session.delete(employee);
			System.out.println("Deleted!!");
			transaction.commit();
			session.close();	
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
				e.printStackTrace();
			}
		}
	}

}









//
//public void saveEmployeeDetails(Employee employee) {
//	Transaction transaction = null;
//	try(Session session = HibernateUtil.getSessionFactory().openSession()){
//		session.beginTransaction();
//		session.save(employee);
//		transaction.commit();
//		session.close();
//		
//	}catch(Exception e) {
//		if(transaction != null) {
//			transaction.rollback();
//			e.printStackTrace();
//		}
//	}
//}