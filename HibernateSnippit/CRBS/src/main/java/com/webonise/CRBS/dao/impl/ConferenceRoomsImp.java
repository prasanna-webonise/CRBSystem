package com.webonise.CRBS.dao.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.webonise.CRBS.dao.ConfernceRoom;
import com.webonise.CRBS.model.ConferenceRoom;
import com.webonise.CRBS.sessionmanager.SessionManager;

@Component
public class ConferenceRoomsImp implements ConfernceRoom {
	final static Logger logger = Logger.getLogger(ConferenceRoomsImp.class);
	Session session;
	Transaction tx;

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ConferenceRoom> getData() {
		ArrayList<ConferenceRoom> list = new ArrayList<ConferenceRoom>();
		try {
			session = SessionManager.getSessionFactory().openSession();
			tx = session.beginTransaction();
			list = (ArrayList<ConferenceRoom>) session.createQuery(
					"from ConferenceRoom").list();
		} catch (Exception ex) {
			logger.error("exception ");
			tx.commit();
			session.close();
		}
		tx.commit();
		session.close();
		return list;

	}
}
