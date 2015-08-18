package com.webonise.CRBS.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webonise.CRBS.db.ConnectToDatabase;
import com.webonise.CRBS.model.ConferenceRoom;
import com.webonise.CRBS.service.ConfernceRoom;

@Component
public class ConferenceRoomsImp implements ConfernceRoom {
	final static Logger logger = Logger.getLogger(ConferenceRoomsImp.class);
	@Autowired
	ConnectToDatabase db;

	Connection con;
	@Override
	public ArrayList<ConferenceRoom> getData() {
		ArrayList<ConferenceRoom> list = new ArrayList<ConferenceRoom>();
		try {
			logger.info("In ConferenceRoomsImp Controller");
			con = db.connect();
			logger.info("Connected to database");
			Statement stmt = con.createStatement();
			String sql;
			sql = "SELECT * FROM conference_rooms";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ConferenceRoom room = new ConferenceRoom();
				room.setRoomId(rs.getInt(1));
				room.setFloorNo(rs.getInt(2));
				room.setDescription(rs.getString(3));
				room.setCapacity(rs.getInt(4));
				list.add(room);
			}
			con.close();
			logger.info("coonection closed");

		} catch (Exception ex) {
			logger.error("exception ");
		}
		return list;

	}
}
