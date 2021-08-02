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
import com.ba.app.entity.CountryCode;
import com.ba.app.entity.Location;
import com.ba.app.entity.User;
import com.ba.app.model.BookingRepository;
import com.ba.app.model.LocationRepository;
import com.ba.app.service.LocationService;
import com.ba.app.vo.BookingVo;
import com.ba.app.vo.LocationVo;
import com.ba.app.vo.UserVo;

@Controller
public class BookingController {
	
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private LocationRepository locationRepository;
	
	
	@RequestMapping(value = "/booking/save", method = RequestMethod.POST)
	private String saveBookingDetails(HttpServletRequest request, BookingVo bookingVo, ModelMap model) {
		Booking booking = new Booking();
		BeanUtils.copyProperties(bookingVo, booking);
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

	@RequestMapping(value = "/addLocation", method = RequestMethod.POST)
	public String saveConfigure(HttpServletRequest request, LocationVo locationVo, ModelMap model) {
		try {			
			Location locationEntity = new Location();

			BeanUtils.copyProperties(locationVo, locationEntity, "createon", "updatedon");
			locationEntity=	locationRepository.save(locationEntity);
			model.addAttribute("successMessage", locationEntity.getLocation()+" - location added! ");
			//model.addAttribute("location", locationEntity);

			// TODO SMS to member mobile number
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errormsg", "Failed to add new location! ");
			return "addLocation";
		}
		return "addLocation";
	}
	@RequestMapping("/locationListing")
	public String countryCodeListing(HttpServletRequest request, ModelMap model) {
		try {
			Iterable<Location> locaIterable = locationRepository.findAll();
			model.addAttribute("locationListing", locaIterable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "locationList";
	}

}
