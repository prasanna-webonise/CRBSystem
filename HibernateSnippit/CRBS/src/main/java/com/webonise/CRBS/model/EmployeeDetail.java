package com.webonise.CRBS.model;

import javax.persistence.*;

@Entity
@Table(name="employee_details")
public class EmployeeDetail {
	@Id
	@Column(name="empid")
	@GeneratedValue
	private int id;
	@Column(name="ename")
	private String name;
	@Column(name="etype")
	private String type;
	@Column(name="ecity")
	private String city;
	@Column(name="password")
	private String password;

	public EmployeeDetail(){
		this.city="";
		this.name="";
		this.password="";
		this.type="";
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String toString() {
		return "EmployeeDetails [id=" + id + ", name=" + name + ", type=" + type + ", city=" + city + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
