package com.webonise.CRBS;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webonise.CRBS.dao.impl.ConferenceRoomsImp;
import com.webonise.CRBS.model.ConferenceRoom;

@Controller
public class RoomController {

	@Autowired
	ConferenceRoomsImp rooms;

	@RequestMapping("/rooms")
	public ModelAndView allusers() {
		ModelAndView model = new ModelAndView("allRooms");
		ArrayList<ConferenceRoom> roomlist = rooms.getData();
		model.addObject("roomList", roomlist);
		return model;
	}

	@RequestMapping("/rooms/{rid}")
	public ModelAndView user(@PathVariable("rid") int rid) {
		ModelAndView model = new ModelAndView("room");
		ArrayList<ConferenceRoom> roomlist = rooms.getData();
		ConferenceRoom room = new ConferenceRoom();
		for (int i = 0; i < roomlist.size(); i++) {
			room = roomlist.get(i);
			if (room.getRoomId() == rid) {
				model.addObject("room", room);
				break;
			}
		}
		return model;

	}

	@RequestMapping(value = "/process")
	public String getdata(Locale locale, Model model) {
		ArrayList<ConferenceRoom> roomlist = rooms.getData();
		model.addAttribute("roomList", roomlist);
		return "select";
	}
}
