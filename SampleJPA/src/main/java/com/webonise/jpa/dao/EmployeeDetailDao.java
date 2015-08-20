package com.webonise.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webonise.jpa.models.EmployeeDetail;

@Repository
public interface EmployeeDetailDao extends
		JpaRepository<EmployeeDetail, Integer> {

}
