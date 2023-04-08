package com.paridhi.api;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import com.paridhi.Employee;
import com.paridhi.Project;
import com.paridhi.Hibernate.util.HibernateUtil;

public class ProjectApi {
	
	public void updateProjectDetails(int Id, Project project) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			session.beginTransaction();
			Employee employee = session.get(Employee.class, Id);
			if(employee != null) {
				employee.setProject((List<Project>) project);
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




//public void saveProjectDetails(Project project) {
//	Transaction transaction = null;
//	try(Session session = HibernateUtil.getSessionFactory().openSession()){
//		session.beginTransaction();
//		session.save(project);
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