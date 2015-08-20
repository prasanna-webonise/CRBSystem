package com.webonise.jpa.service;

public interface ScheduleDetailService {
	public int getFloorNumber(String roomnumber);

	public void insertBookedRoom(String roomId, String empId, String comment,
			String date, String floorno, String fromTime, String toTime);
}
