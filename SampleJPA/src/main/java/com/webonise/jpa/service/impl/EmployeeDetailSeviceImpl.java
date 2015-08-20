package com.webonise.jpa.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webonise.jpa.dao.EmployeeDetailDao;
import com.webonise.jpa.models.EmployeeDetail;
import com.webonise.jpa.service.EmployeeDetailService;

@Service
public class EmployeeDetailSeviceImpl implements EmployeeDetailService {

	@Autowired
	private EmployeeDetailDao employeeDetailDao;

	@Override
	public EmployeeDetail findEmployee(int eId) {
		EmployeeDetail emp = employeeDetailDao.findOne(eId);
		return emp;
	}

	@Override
	public ArrayList<EmployeeDetail> getData() {
		ArrayList<EmployeeDetail> details = (ArrayList<EmployeeDetail>) employeeDetailDao
				.findAll();
		return details;
	}

}
