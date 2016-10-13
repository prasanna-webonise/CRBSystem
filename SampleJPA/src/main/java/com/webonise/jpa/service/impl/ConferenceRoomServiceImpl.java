package com.webonise.jpa.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webonise.jpa.dao.ConferenceRoomDao;
import com.webonise.jpa.models.ConferenceRoom;
import com.webonise.jpa.service.ConferenceRoomService;

@Service
public class ConferenceRoomServiceImpl implements ConferenceRoomService {

	@Autowired
	ConferenceRoomDao conferenceDao;

	@Override
	public ArrayList<ConferenceRoom> getData() {
		ArrayList<ConferenceRoom> rooms = (ArrayList<ConferenceRoom>) conferenceDao
				.findAll();
		return rooms;
	}

}
