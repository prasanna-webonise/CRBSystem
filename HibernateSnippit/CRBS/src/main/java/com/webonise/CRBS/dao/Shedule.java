package com.webonise.CRBS.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public interface Shedule {
	public int getFloorNumber(String roomnumber);

	public void insertBookedRoom(String roomId, String empId, String comment,
			String date, String floorno, String fromTime, String toTime)
			throws SQLException;
}
