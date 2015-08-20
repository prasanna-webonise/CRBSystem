package com.webonise.jpa;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webonise.jpa.models.EmployeeDetail;
import com.webonise.jpa.service.EmployeeDetailService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController1 {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController1.class);

	@Autowired
	private EmployeeDetailService empService;

	@RequestMapping(value = "/eid/{eid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody EmployeeDetail categoryList(@PathVariable int eid)
			throws JsonGenerationException, JsonMappingException, IOException {
		EmployeeDetail emp = empService.findEmployee(eid);
		System.out.println(new ObjectMapper().writeValueAsString(emp));
		return emp;
	}
	
}
