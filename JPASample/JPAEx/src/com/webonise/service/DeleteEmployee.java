package com.webonise.service;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.webonise.entity.Employee;
import com.webonise.entitymanger.Manger;

public class DeleteEmployee {
	static final Logger log = Logger.getLogger(DeleteEmployee.class);

	public static void main(String[] args) {
		Manger manger = new Manger();
		EntityManager entitymanager = manger.getEntityManager();
		try {
			Employee employee = entitymanager.find(Employee.class, 101);
			entitymanager.remove(employee);
			entitymanager.getTransaction().commit();
			log.info("removed");
		} catch (Exception e) {
			log.error(e.getMessage());
			manger.closeEntityManager();
		}
		manger.closeEntityManager();
	}
}