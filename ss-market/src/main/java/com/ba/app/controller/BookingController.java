package com.ba.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ba.app.entity.Booking;
import com.ba.app.entity.Location;
import com.ba.app.entity.PayType;
import com.ba.app.entity.Vehicle;
import com.ba.app.model.BookingRepository;
import com.ba.app.model.LocationRepository;
import com.ba.app.model.PayOptionRepository;
import com.ba.app.model.VehicleRepository;
import com.ba.app.vo.BookingVo;
import com.ba.app.vo.LocationVo;
import com.ba.app.vo.PayOptionVo;
import com.ba.app.vo.VehicleVo;

@Controller
public class BookingController {
	
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private PayOptionRepository payOptionRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@RequestMapping(value = "/booking/save", method = RequestMethod.POST)
	public String saveBookingDetails(HttpServletRequest request, BookingVo bookingVo, ModelMap model) {
		try {
		Booking booking = new Booking();
		BeanUtils.copyProperties(bookingVo, booking);
		model.addAttribute("bookingsuccessmessage", "Booked Successfully");
		bookingRepository.save(booking);
		}catch(Exception ex) {
			ex.printStackTrace();
			model.addAttribute("errormsg", "Failed to Book ");
			return "booking";
		}
		return "booking";
	}
	@RequestMapping("/outgoingParcel")
	public String outgoingParcel(HttpServletRequest request, ModelMap model) {
		setAllLocationListInModel(model);
		setAllVehileListInModel(model);
		return "outgoingParcel";
	}
	
	@RequestMapping("/incomingParcel")
	public String incomingParcel(HttpServletRequest request, ModelMap model) {
		setAllLocationListInModel(model);
		setAllVehileListInModel(model);
		return "incomingParcel";
	}
	
	@RequestMapping("/booking")
	public String booking(ModelMap model) {
		setAllLocationListInModel(model);
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
			Iterable<Location> locaIterable = locationRepository.findAll();
			model.addAttribute("locationListing", locaIterable);
			// TODO SMS to member mobile number
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errormsg", "Failed to add new location! ");
			return "addLocation";
		}
		return "locationListing";
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

	@RequestMapping(value = "/location/edit/{id}", method = RequestMethod.GET)
	public String locationEdit(@PathVariable("id") Long id, HttpServletRequest request, ModelMap model) {
		try {
			Location location = locationRepository.findById(id).get();
			LocationVo locationVo = new LocationVo();
			BeanUtils.copyProperties(location, locationVo);
			model.addAttribute("location", locationVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "addLocation";
	}
	@RequestMapping(value = "/location/delete/{id}", method = RequestMethod.GET)
	public String locationDelete(@PathVariable("id") Long id, HttpServletRequest request, ModelMap model) {
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
			PayType payOptionEntity = new PayType();

			BeanUtils.copyProperties(payOptionVo, payOptionEntity, "createon", "updatedon");
			payOptionEntity=	payOptionRepository.save(payOptionEntity);
			model.addAttribute("successMessage", payOptionEntity.getPayOption()+" - Payoption added! ");
			Iterable<PayType> locaIterable = payOptionRepository.findAll();
			model.addAttribute("payOptionListing", locaIterable);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errormsg", "Failed to Pay Option! ");
			return "payOption";
		}
		return "payOptionListing";
	}
	
	@RequestMapping("/payOptionListing")
	public String payOptionListing(HttpServletRequest request, ModelMap model) {
		try {
			Iterable<PayType> locaIterable = payOptionRepository.findAll();
			model.addAttribute("payOptionListing", locaIterable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "payOptionListing";
	}
	
	@RequestMapping(value = "/payOption/delete/{id}", method = RequestMethod.GET)
	public String payOptionDelete(@PathVariable ("id") Long id, HttpServletRequest request, ModelMap model) {
		try {
			payOptionRepository.deleteById(id);
			model.addAttribute("deletesuccessmessage", "Deleted Successfully");
			Iterable<PayType> locaIterable = payOptionRepository.findAll();
			model.addAttribute("payOptionListing", locaIterable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "payOptionListing";
	}
	private void setAllLocationListInModel(ModelMap model) {
		Iterable<Location> locaIterable = locationRepository.findAll();
		model.addAttribute("locationList", locaIterable);
	}
	
	@RequestMapping(value = "get/incomingParcel", method = RequestMethod.GET)
	public String importIncomingParcel(@RequestParam("fromLocation") String fromLocation,@RequestParam("toLocation") String toLocation,HttpServletRequest request, ModelMap model) {
		List<Booking> incomeList= bookingRepository.findByFromLocationAndToLocation(fromLocation,toLocation);
		model.addAttribute("incomeList", incomeList);
		return "incomingParcel";
	}
	@RequestMapping(value = "get/outgoingParcel", method = RequestMethod.GET)
	public String importOutgoingParcel(@RequestParam("fromLocation") String fromLocation,@RequestParam("toLocation") String toLocation,HttpServletRequest request, ModelMap model) {
		List<Booking> outgoingList= bookingRepository.findByFromLocationAndToLocation(fromLocation,toLocation);
		model.addAttribute("outgoingList", outgoingList);
		return "outgoingParcel";
	}
	private void setAllVehileListInModel(ModelMap model) {
		Iterable<Vehicle> vechileIterable = vehicleRepository.findAll();
		model.addAttribute("vehicleList", vechileIterable);
	}
	
	@RequestMapping(value = "/payOption/edit/{id}", method = RequestMethod.GET)
	public String payOptionEdit(@PathVariable("id") Long id, HttpServletRequest request, ModelMap model) {
		try {
			PayType payOption = payOptionRepository.findById(id).get();
			PayOptionVo payOptionVo = new PayOptionVo();
			BeanUtils.copyProperties(payOption, payOptionVo);
			model.addAttribute("payOption", payOptionVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "payOption";
	}
	@RequestMapping(value = "/vehicle", method = RequestMethod.POST)
	public String saveVehicle(HttpServletRequest request, VehicleVo vehicleVo, ModelMap model) {
		try {			
			Vehicle vehicleEntity = new Vehicle();
			BeanUtils.copyProperties(vehicleVo, vehicleEntity, "createon", "updatedon");
			vehicleEntity=	vehicleRepository.save(vehicleEntity);
			model.addAttribute("successMessage", vehicleEntity.getVehicle()+" - Vehicle added! ");
			Iterable<Vehicle> vehicleIterable = vehicleRepository.findAll();
			model.addAttribute("vehicleListing", vehicleIterable);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errormsg", "Failed to Pay Option! ");
			return "vehicleDetails";
		}
		return "vehicleListing";
	}
	
	@RequestMapping("/vehicleListing")
	public String saveVehicleListing(HttpServletRequest request, ModelMap model) {
		try {
			Iterable<Vehicle> locaIterable = vehicleRepository.findAll();
			model.addAttribute("vehicleListing", locaIterable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "vehicleListing";
	}
	
	@RequestMapping(value = "/vehicle/delete/{id}", method = RequestMethod.GET)
	public String vehicleDelete(@PathVariable ("id") Long id, HttpServletRequest request, ModelMap model) {
		try {
			vehicleRepository.deleteById(id);
			model.addAttribute("deletesuccessmessage", "Deleted Successfully");
			Iterable<Vehicle> vehicleIterable = vehicleRepository.findAll();
			model.addAttribute("vehicleListing", vehicleIterable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "vehicleListing";
	}
	
	@RequestMapping(value = "/vehicle/edit/{id}", method = RequestMethod.GET)
	public String vehicleEdit(@PathVariable("id") Long id, HttpServletRequest request, ModelMap model) {
		try {
			Vehicle vehicle = vehicleRepository.findById(id).get();
			VehicleVo vehicleVo = new VehicleVo();
			BeanUtils.copyProperties(vehicle, vehicleVo);
			model.addAttribute("vehicle", vehicleVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "vehicleDetails";
	}
}
