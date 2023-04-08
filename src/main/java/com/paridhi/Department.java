package com.paridhi;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="deptId")
	private int deptId;
	@Column(name="deptName")
	private String name;
	@Column(name="deptTechnology")
	private String technology;
	@Column(name="deptContact")
	private int contact;
	@Column(name="deptAddress")
	private String address;
	
	
	@OneToOne(mappedBy="department",cascade = CascadeType.ALL)
	private Employee employee;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Department(int deptId, String name, String technology, int contact, String address, Employee employee) {
		super();
		this.deptId = deptId;
		this.name = name;
		this.technology = technology;
		this.contact = contact;
		this.address = address;
		this.employee = employee;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", name=" + name + ", technology=" + technology + ", contact=" + contact
				+ ", address=" + address + "]";
	}
	
	

}
