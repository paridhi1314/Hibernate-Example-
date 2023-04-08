package com.paridhi;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import com.paridhi.api.DepartmentApi;
import com.paridhi.api.EmployeeApi;
import com.paridhi.api.ProjectApi;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department dept1 = new Department();
		//dept.setDeptId(102);
		dept1.setName("Product Development");
		dept1.setAddress("Bangalore");
		dept1.setContact(846210824);
		dept1.setTechnology("Java backend");
		
		Department dept2 = new Department();
		dept2.setName("Product Design");
		dept2.setAddress("Bangalore");
		dept2.setContact(900189101);
		dept2.setTechnology("UX/UI");
		
		Department dept3 = new Department();
		dept3.setName("Integrity");
		dept3.setAddress("Chandigarh");
		dept3.setContact(678002147);
		dept3.setTechnology("SAP");
		

		Project proj1 = new Project();
		proj1.setTitle("Springboot Project");
		proj1.setDescription("Java Spring project");
        proj1.setStartDate("2/02/2023");
        proj1.setEndDate("31/03/2023");
        
        Project proj2 = new Project();
		proj2.setTitle("Web Services");
		proj2.setDescription("Java web services project");
        proj2.setStartDate("15/02/2023");
        proj2.setEndDate("23/04/2023");
        
        List<Project> projectList = Arrays.asList(proj1,proj2);
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Paridhi");
		emp.setDob("13/06");
		emp.setContact(90018910);
		emp.setEmail("paridhimalav@gmail.com");
		emp.setSalary(6000000);
		emp.setAddress("Kota");
		
		Employee emp2 = new Employee();
		emp.setId(2);
		emp2.setName("Aditi");
		emp2.setDob("26/05");
		emp2.setContact(99689234);
		emp2.setEmail("aditi1710@gmail.com");
		emp2.setSalary(7000000);
		emp2.setAddress("Delhi");
		
		Employee emp3 = new Employee();
		emp.setId(3);
		emp3.setName("Harsh");
		emp3.setDob("23/05");
		emp3.setContact(73467901);
		emp3.setEmail("harsh2305@gmail.com");
		emp3.setSalary(8000000);
		emp3.setAddress("Jaipur");

		emp.setProject(projectList);
		
//		
		//DELETE EMPLOYEE
		EmployeeApi employeeApi = new EmployeeApi();
		employeeApi.detetetDEmployeeeDetails(2);
		
		//CREATING NEW PROJECT
		Project proj3 = new Project();
		proj1.setTitle("JPA Project");
		proj1.setDescription("JPA/Hybernate project");
        proj1.setStartDate("1/01/2023");
        proj1.setEndDate("31/03/2023");
        
        //CREATING NEW DEPARTMENT
        Department dept4 = new Department();
		dept3.setName("Web Development");
		dept3.setAddress("Bhubneshwar");
		dept3.setContact(986542767);
		dept3.setTechnology("Web Dev");
		
		//UPDATE PROJECT FOR EMPLOYEE
		ProjectApi projectApi = new ProjectApi();
		projectApi.updateProjectDetails(4, proj2);
		
		//UPDATE PROJECT FOR EMPLOYEE
		DepartmentApi departmentApi = new DepartmentApi();
		departmentApi.updateDepartmentDetails(1, dept3);
//        
//		emp.setProject(project);
		EntityManager factory = EntityManagerUtil.getEntityManager();
		factory.getTransaction().begin();
	
		factory.persist(emp);
		factory.persist(emp2);
		factory.persist(emp3);
		proj1.setEmployee(emp);
		proj2.setEmployee(emp2);
		proj3.setEmployee(emp3);
		emp.setDepartment(dept3);
		emp2.setDepartment(dept2);
		emp3.setDepartment(dept1);
		factory.persist(proj1);
		factory.persist(proj2);
		factory.persist(proj3);
		factory.persist(dept1);
		factory.persist(dept2);
		factory.persist(dept3);
		factory.persist(dept4);
		
		factory.getTransaction().commit();
		factory.close();

	}

}
