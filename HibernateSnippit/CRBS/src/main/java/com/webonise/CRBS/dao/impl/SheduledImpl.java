package com.webonise.CRBS.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.webonise.CRBS.dao.Shedule;
import com.webonise.CRBS.model.ConferenceRoom;
import com.webonise.CRBS.model.ScheduleDetail;
import com.webonise.CRBS.sessionmanager.SessionManager;

@Service
public class SheduledImpl implements Shedule {
	final static Logger logger = Logger.getLogger(SheduledImpl.class);

	int fno;
	Session session;
	Transaction tx;

	@Override
	public int getFloorNumber(String roomnumber) {
		ConferenceRoom room = new ConferenceRoom();
		int roomno = Integer.parseInt(roomnumber);
		try {
			session = SessionManager.getSessionFactory().openSession();
			tx = session.beginTransaction();
			room = (ConferenceRoom) session.get(ConferenceRoom.class, roomno);
			fno = room.getFloorNo();
		} catch (Exception ex) {
			logger.error("Exception : {}", ex);
			tx.commit();
			session.close();
		}
		tx.commit();
		session.close();
		return fno;

	}

	@Override
	public void insertBookedRoom(String roomId, String empId, String comment,
			String date, String floorno, String fromTime, String toTime) {
		session = SessionManager.getSessionFactory().openSession();
		tx = session.beginTransaction();
		int rId = Integer.parseInt(roomId);
		int eId = Integer.parseInt(empId);
		int fNo = Integer.parseInt(floorno);
		ScheduleDetail detail = new ScheduleDetail(fNo, date, fromTime, toTime,
				comment, eId, rId);

		session.save(detail);
		session.getTransaction().commit();
		session.close();

	}
}
