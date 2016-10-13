package com.webonise.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webonise.jpa.models.ScheduleDetail;
import com.webonise.jpa.service.ScheduleDetailService;


@Controller
public class ShedulerController {

	@Autowired
	ScheduleDetailService shedule;

	@RequestMapping(value = "/status", method = RequestMethod.POST)
	public String Staus(@RequestParam String roomN, Model model) {
		String roomnumber = roomN;
		int floorNumber = shedule.getFloorNumber(roomnumber);
		model.addAttribute("roomnumber", roomnumber);
		model.addAttribute("floorNumber", floorNumber);
		model.addAttribute("scheduleDetail",new ScheduleDetail());
		return "showStatus";
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String book(@RequestParam String roomId, @RequestParam String empId,
			@RequestParam String comment, @RequestParam String date,
			@RequestParam String fromTime, @RequestParam String toTime,
			@RequestParam String floor, Model model) {
		shedule.insertBookedRoom(roomId, empId, comment, date, floor, fromTime,
				toTime);

		return "done";
	}
}
