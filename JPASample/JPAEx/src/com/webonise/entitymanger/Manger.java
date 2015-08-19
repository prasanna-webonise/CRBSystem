package com.webonise.entitymanger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manger {
	private EntityManagerFactory emfactory;
	private EntityManager entitymanager ;
	public Manger() {
	}

	public EntityManager getEntityManager() {
		emfactory = Persistence
				.createEntityManagerFactory("JPAEx");
		entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		return entitymanager;
	}
	
	public void closeEntityManager() {
		entitymanager.close();
		emfactory.close();
	}
}
