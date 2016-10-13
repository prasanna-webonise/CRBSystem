package com.webonise.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {

	public Employee(int eid, String ename, double salary, int phoneno,
			String desigation) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.phoneno = phoneno;
		this.desigation = desigation;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	private String ename;
	private double salary;
	private int phoneno;
	private String desigation;

	public Employee() {
		super();
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}

	public String getDesigation() {
		return desigation;
	}

	public void setDesigation(String desigation) {
		this.desigation = desigation;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary="
				+ salary + ", phoneno=" + phoneno + ", desigation="
				+ desigation + "]";
	}

}