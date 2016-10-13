package com.webonise.service;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.webonise.entity.Employee;
import com.webonise.entitymanger.Manger;

public class CreateEmployee {
  static final Logger log =Logger.getLogger(CreateEmployee.class);
	public static void main(String[] args) {

		Manger manger = new Manger();
		EntityManager entitymanager = manger.getEntityManager();
		try{
			
		Employee employee = new Employee();
		employee.setEid(101);
		employee.setSalary(40000);
		employee.setEname("Pradeep");
		employee.setPhoneno(44552200);
		employee.setDesigation("Technical Manager");

		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();

		manger.closeEntityManager();
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}
}