package com.ba.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ba.app.entity.Booking;
import com.ba.app.entity.Location;
import com.ba.app.entity.PayOption;
import com.ba.app.model.BookingRepository;
import com.ba.app.model.LocationRepository;
import com.ba.app.model.PayOptionRepository;
import com.ba.app.vo.BookingVo;
import com.ba.app.vo.LocationVo;
import com.ba.app.vo.PayOptionVo;

@Controller
public class BookingController {
	
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private PayOptionRepository payOptionRepository;
	
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
		return "locationListing";
	}
	
	@RequestMapping(value = "/location/delete", method = RequestMethod.GET)
	public String locationDelete(@RequestParam("id") String id, HttpServletRequest request, ModelMap model) {
		try {
			locationRepository.deleteById(id);
			model.addAttribute("deletesuccessmessage", "Deleted Successfully");
			Iterable<Location> locaIterable = locationRepository.findAll();
			model.addAttribute("locationListing", locaIterable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "locationListing";
	}
	@RequestMapping(value = "/payOption", method = RequestMethod.POST)
	public String savePayout(HttpServletRequest request, PayOptionVo payOptionVo, ModelMap model) {
		try {			
			PayOption payOptionEntity = new PayOption();

			BeanUtils.copyProperties(payOptionVo, payOptionEntity, "createon", "updatedon");
			payOptionEntity=	payOptionRepository.save(payOptionEntity);
			model.addAttribute("successMessage", payOptionEntity.getPayOption()+" - Payoption added! ");
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errormsg", "Failed to Pay Option! ");
			return "payOption";
		}
		return "payOption";
	}
	
	@RequestMapping("/payOptionListing")
	public String payOptionListing(HttpServletRequest request, ModelMap model) {
		try {
			Iterable<PayOption> locaIterable = payOptionRepository.findAll();
			model.addAttribute("payOptionListing", locaIterable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "payOptionListing";
	}
	
	@RequestMapping(value = "/payOption/delete", method = RequestMethod.GET)
	public String payOptionDelete(@RequestParam("id") String id, HttpServletRequest request, ModelMap model) {
		try {
			locationRepository.deleteById(id);
			model.addAttribute("deletesuccessmessage", "Deleted Successfully");
			Iterable<PayOption> locaIterable = payOptionRepository.findAll();
			model.addAttribute("payOptionListing", locaIterable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "payOptionListing";
	}
}
