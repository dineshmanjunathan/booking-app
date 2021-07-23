package com.ba.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ba.app.entity.Booking;
import com.ba.app.entity.Location;
import com.ba.app.model.BookingRepository;
import com.ba.app.service.LocationService;
import com.ba.app.vo.BookingVo;

@Controller
public class BookingController {
	
	@Autowired
	private BookingRepository bookingRepository;
	LocationService locationService;
	@RequestMapping(value = "/booking/save", method = RequestMethod.POST)
	private String saveBookingDetails(HttpServletRequest request, BookingVo bookingVo, ModelMap model) {
		Booking booking = new Booking();
		BeanUtils.copyProperties(booking, bookingVo);
		bookingRepository.save(booking);
		return "booking";
	}
	@RequestMapping("/outgoingParcel")
	public String outgoingParcel() {
		return "outgoingParcel";
	}
	@RequestMapping("/incomingParcel")
	public String incomingParcel() {
		return "incomingParcel";
	}
	
	
	@RequestMapping("/booking")
	public String booking() {
		return "booking";
	}

	@RequestMapping("/addLocation")
	public void saveConfigure(@RequestBody Location location) {
		locationService.saveLocation(location);
		//return "configure";
	}

}
