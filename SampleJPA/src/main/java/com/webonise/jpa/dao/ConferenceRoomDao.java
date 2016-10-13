package com.webonise.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webonise.jpa.models.ConferenceRoom;

public interface ConferenceRoomDao extends
		JpaRepository<ConferenceRoom, Integer> {

}
