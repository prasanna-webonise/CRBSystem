package com.webonise.jpa.service;

import java.util.ArrayList;

import antlr.collections.List;

import com.webonise.jpa.models.EmployeeDetail;

public interface EmployeeDetailService {

	public EmployeeDetail findEmployee(int eId);
	public ArrayList<EmployeeDetail> getData();
	
}
