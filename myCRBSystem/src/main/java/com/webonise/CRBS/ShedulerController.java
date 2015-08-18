package com.webonise.CRBS;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webonise.CRBS.serviceImpl.SheduledImpl;

@Controller
public class ShedulerController {

	@Autowired
	SheduledImpl shedule;

	@RequestMapping(value = "/status", method = RequestMethod.POST)
	public String Staus(@RequestParam String roomN, Model model) {
		String roomnumber = roomN;
		int floorNumber = shedule.getFloorNumber(roomnumber);
		model.addAttribute("roomnumber", roomnumber);
		model.addAttribute("floorNumber", floorNumber);
		return "showStatus";
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String book(@RequestParam String roomId, @RequestParam String empId,
			@RequestParam String comment, @RequestParam String date,
			@RequestParam String fromTime, @RequestParam String toTime,
			@RequestParam String floor, Model model) {
		try {
			shedule.insertBookedRoom(roomId, empId, comment, date, floor,
					fromTime, toTime);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "done";
	}
}
