package com.paridhi.api;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.paridhi.Department;
import com.paridhi.Employee;
import com.paridhi.Hibernate.util.HibernateUtil;
public class DepartmentApi {
	public void updateDepartmentDetails(int Id, Department department) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			session.beginTransaction();
			Employee employee = session.get(Employee.class,Id);
			if(employee != null) {
				employee.setDepartment(department);
			}else {
				session.saveOrUpdate(employee);
				transaction.commit();
				session.close();
			}
				
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
				e.printStackTrace();
			}
		}
	}

}




//public void saveDepartmentDetails(Department department) {
//	Transaction transaction = null;
//	try(Session session = HibernateUtil.getSessionFactory().openSession()){
//		session.beginTransaction();
//		session.save(department);
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