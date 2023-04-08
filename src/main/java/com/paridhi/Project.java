package com.paridhi;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="projtId")
	private int projectId;
	@Column(name="projtTitle")
	private String title;
	@Column(name="projtDesc")
	private String description;
	@Column(name="StartDate")
	private String startDate;
	@Column(name="EndDate")
	private String endDate;
	
	@ManyToOne(targetEntity=Project.class, cascade = CascadeType.ALL)
	@JoinColumn
	private Employee employee;

	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(int projectId, String title, String description, String startDate, String endDate, Employee employee) {
		super();
		this.projectId = projectId;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employee = employee;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", title=" + title + ", description=" + description + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
	

}
