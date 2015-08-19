package com.webonise.CRBS.dao.impl;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.webonise.CRBS.dao.EmployeeSevice;
import com.webonise.CRBS.model.EmployeeDetail;
import com.webonise.CRBS.sessionmanager.SessionManager;

@Component
public class EmployeeDetailsImp implements EmployeeSevice {
	final static Logger logger = Logger.getLogger(EmployeeDetailsImp.class);

	ArrayList<EmployeeDetail> employees = new ArrayList<EmployeeDetail>();
	Session session;
	Transaction tx;

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<EmployeeDetail> getData() {
		try {
			session = SessionManager.getSessionFactory().openSession();
			tx = session.beginTransaction();
			employees = (ArrayList<EmployeeDetail>) session.createQuery(
					"from EmployeeDetail").list();
		} catch (Exception ex) {
			logger.error("exception " + ex);
			tx.commit();
			session.close();
		}
		tx.commit();
		session.close();
		return employees;
	}
}
