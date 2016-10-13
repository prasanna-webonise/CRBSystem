package com.webonise.jpa.models;

import javax.persistence.*;
@Entity
@Table(name="conference_rooms")
public class ConferenceRoom {
	@Id
	@Column(name="roomid")
	@GeneratedValue
	private int roomId ;
	@Column(name="floornumber")	
	private int floorNo ;
	@Column(name="description")
	private String description ;
	@Column(name="capacity")
	private int capacity ;
	
	public ConferenceRoom(){
		this.floorNo=0;
		this.capacity=0;
		this.description="";
		
	}
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String toString() {
		return roomId + "	" + floorNo + "		" + description +  "	" + capacity ;
	}

}
