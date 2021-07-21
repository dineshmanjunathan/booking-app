package com.ba.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ba.app.entity.Booking;
import com.ba.app.model.BookingRepository;
import com.ba.app.vo.BookingVo;

@Controller
public class BookingController {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@RequestMapping(value = "/booking/save", method = RequestMethod.POST)
	private String saveBookingDetails(HttpServletRequest request, BookingVo bookingVo, ModelMap model) {
		Booking booking = new Booking();
		BeanUtils.copyProperties(booking, bookingVo);
		bookingRepository.save(booking);
		return "booking";
	}
	@RequestMapping("/outgoingParcel")
	public String incomingParcel() {
		return "outgoingParcel";
	}
	
	@RequestMapping("/booking")
	public String booking() {
		return "booking";
	}

}
