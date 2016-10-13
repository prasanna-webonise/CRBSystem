package com.webonise.service;

import javax.persistence.EntityManager;
import org.apache.log4j.Logger;
import com.webonise.entity.Employee;
import com.webonise.entitymanger.Manger;

public class FindEmployee {
	static final Logger log = Logger.getLogger(FindEmployee.class);

	public static void main(String[] args) {

		Manger manger = new Manger();
		EntityManager entitymanager = manger.getEntityManager();
		Employee employee = entitymanager.find(Employee.class, 101);
		manger.closeEntityManager();
		log.info(employee);
	}
}