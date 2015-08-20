package com.webonise.jpa.models;


import javax.persistence.*;

@Entity
@Table(name = "schedule_details")
public class ScheduleDetail {

	public ScheduleDetail(int fNo, String date, String fromTime, String toTime,
			String comment, int eId, int rId) {
		this.floorNumber = fNo;
		this.scheduleDate = date;
		this.startTime = fromTime;
		this.endTime = toTime;
		this.comment = comment;
		EmployeeDetail emp = new EmployeeDetail();
		emp.setId(eId);
		this.employee=emp;
		ConferenceRoom room = new ConferenceRoom();
		room.setRoomId(rId);
		this.room=room;
	}

	public ScheduleDetail() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sheduleid")
	private int sheduleid;

	@Column(name = "floorNumber")
	private int floorNumber;

	@Column(name = "scheduleDate")
	private String scheduleDate;

	@Column(name = "startTime")
	private String startTime;

	@Column(name = "endTime")
	private String endTime;

	@Column(name = "comment")
	private String comment;

	@OneToOne()
	@JoinColumn(name = "empid")
	private EmployeeDetail employee;

	@OneToOne()
	@JoinColumn(name = "roomid")
	private ConferenceRoom room;

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public EmployeeDetail getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDetail employee) {
		this.employee = employee;
	}

	public ConferenceRoom getRoom() {
		return room;
	}

	public void setRoom(ConferenceRoom room) {
		this.room = room;
	}

	public int getSheduleid() {
		return sheduleid;
	}

	public void setSheduleid(int sheduleid) {
		this.sheduleid = sheduleid;
	}

}
