package com.webonise.CRBS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webonise.CRBS.dao.impl.EmployeeDetailsImp;
import com.webonise.CRBS.model.EmployeeDetail;

@Controller
public class UserController {

	@Autowired
	EmployeeDetailsImp users;

	@RequestMapping("/users")
	public ModelAndView allusers() {
		ModelAndView model = new ModelAndView("allUsers");
		ArrayList<EmployeeDetail> userlist = users.getData();
		model.addObject("userList", userlist);
		return model;
	}

	@RequestMapping(value = "/users/{uid}")
	public ModelAndView getUser(@PathVariable int uid) {
		ModelAndView model = new ModelAndView("user");
		ArrayList<EmployeeDetail> userlist = users.getData();
		EmployeeDetail user = new EmployeeDetail();
		for (int i = 0; i < userlist.size(); i++) {
			user = userlist.get(i);
			if (user.getId() == uid) {
				model.addObject("user", user);
				break;
			}
		}
		return model;
	}

	@RequestMapping(value = "/users/all", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeDetail>> listAllUsers() {
		List<EmployeeDetail> list = users.getData();
		return new ResponseEntity<List<EmployeeDetail>>(list, HttpStatus.OK);
	}

}
