package com.paridhi;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="employee")
public class Employee {
	@Id

	@Column(name="empId")
	private int empid;
	
	@Column(name="empName")
	private String name;
	@Column(name="dob")
	private String dob;
	@Column(name="salary")
	private long salary;
	@Column(name="contact")
	private int contact;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="dept_id")
	//@PrimaryKeyJoinColumn
	private Department department;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	
	private List<Project> project;
	
	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empid, String name, String dob, long salary, int contact, String email, String address,
			Department department, List<Project> project) {
		super();
		this.empid = empid;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.contact = contact;
		this.email = email;
		this.address = address;
		this.department = department;
		this.project = project;
	}
	
	public int getId() {
		return empid;
	}
	public void setId(int id) {
		empid = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [Id=" + empid + ", Name=" + name + ", dob=" + dob + ", Salary=" + salary + ", Contact=" + contact
				+ ", Email=" + email + ", Address=" + address + "]";
	}
	


}
