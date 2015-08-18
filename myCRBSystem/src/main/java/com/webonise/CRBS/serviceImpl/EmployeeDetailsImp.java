package com.webonise.CRBS.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webonise.CRBS.db.ConnectToDatabase;
import com.webonise.CRBS.model.EmployeeDetail;
import com.webonise.CRBS.service.EmployeeSevice;

@Component
public class EmployeeDetailsImp implements EmployeeSevice {
	final static Logger logger = Logger.getLogger(EmployeeDetailsImp.class);
	@Autowired
	ConnectToDatabase db;

	Connection con;

	ArrayList<EmployeeDetail> list = new ArrayList<EmployeeDetail>();

	@Override
	public ArrayList<EmployeeDetail> getData() {
		try {
			logger.info("In EmployeeDetailsImp Controller");
			con = db.connect();
			logger.info("Connected to database");
			Statement stmt = con.createStatement();
			String sql;
			sql = "SELECT * FROM employee_details";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				EmployeeDetail user = new EmployeeDetail();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setType(rs.getString(3));
				user.setCity(rs.getString(4));
				list.add(user);
			}
			con.close();
			logger.info("database connection closed");

		} catch (Exception ex) {
			logger.error("exception "+ex);
		}
		return list;
	}
}
