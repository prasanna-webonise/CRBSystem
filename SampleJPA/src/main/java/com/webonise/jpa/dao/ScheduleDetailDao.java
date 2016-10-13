package com.webonise.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webonise.jpa.models.ScheduleDetail;

@Repository
public interface ScheduleDetailDao extends
		JpaRepository<ScheduleDetail, Integer> {

}
