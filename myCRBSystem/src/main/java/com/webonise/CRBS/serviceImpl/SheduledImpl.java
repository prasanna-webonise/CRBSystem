package com.webonise.CRBS.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webonise.CRBS.db.ConnectToDatabase;
import com.webonise.CRBS.service.Shedule;

@Service
public class SheduledImpl implements Shedule {
	final static Logger logger = Logger.getLogger(SheduledImpl.class);
	@Autowired
	ConnectToDatabase db;

	Connection con;
	int fno;

	@Override
	public int getFloorNumber(String roomnumber) {
		logger.info("In SheduledImpl Controller");
		con = db.connect();
		logger.info("Connected to database");
		int roomno = Integer.parseInt(roomnumber);
		try {
			PreparedStatement ps = con
					.prepareStatement("select * from conference_rooms where roomId="
							+ roomno);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				fno = rs.getInt(2);
			}
			con.close();
			logger.info("Database connection closed");

		} catch (Exception ex) {
			logger.error("Exception : {}",ex);
		}
		return fno;

	}

	@Override
	public void insertBookedRoom(String roomId, String empId, String comment,
			String date, String floorno, String fromTime, String toTime)
			throws SQLException {
		con = db.connect();
		int rId = Integer.parseInt(roomId);
		int eId = Integer.parseInt(empId);
		int fNo = Integer.parseInt(floorno);
		Statement st = con.createStatement();
		st.executeUpdate("INSERT INTO schedule_details (empid, roomid, floorNumber,scheduleDate,startTime,endTime,comment) "
				+ "VALUES ("
				+ eId
				+ ","
				+ rId
				+ ","
				+ fNo
				+ ",'"
				+ date
				+ "','" + fromTime + "', '" + toTime + "','" + comment + "')");

	}

}
