package com.webonise.service;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.webonise.entity.Employee;
import com.webonise.entitymanger.Manger;

public class UpdateEmployee {
	static final Logger log = Logger.getLogger(UpdateEmployee.class);

	public static void main(String[] args) {
		Manger manger = new Manger();
		EntityManager entitymanager = manger.getEntityManager();
		try {
			Employee employee = entitymanager.find(Employee.class, 101);
			log.info("BEFORE {}" + employee);
			employee.setSalary(50000);
			entitymanager.getTransaction().commit();
			log.info("AFTER {}" + employee);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		manger.closeEntityManager();
	}
}