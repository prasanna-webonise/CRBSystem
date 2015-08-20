package com.webonise.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webonise.jpa.dao.ConferenceRoomDao;
import com.webonise.jpa.dao.ScheduleDetailDao;
import com.webonise.jpa.models.ConferenceRoom;
import com.webonise.jpa.models.ScheduleDetail;
import com.webonise.jpa.service.ScheduleDetailService;

@Service
public class ScheduleDetailServiceImpl implements ScheduleDetailService {

	@Autowired
	ConferenceRoomDao conferenceDao;

	@Autowired
	ScheduleDetailDao shedule;

	@Override
	public int getFloorNumber(String roomnumber) {
		int roomno = Integer.parseInt(roomnumber);
		ConferenceRoom room = conferenceDao.findOne(roomno);
		return room.getFloorNo();
	}

	@Override
	public void insertBookedRoom(String roomId, String empId, String comment,
			String date, String floorno, String fromTime, String toTime) {
		int rId = Integer.parseInt(roomId);
		int eId = Integer.parseInt(empId);
		int fNo = Integer.parseInt(floorno);

		ScheduleDetail detail = new ScheduleDetail(fNo, date, fromTime, toTime,
				comment, eId, rId);

		shedule.saveAndFlush(detail);

	}

}
