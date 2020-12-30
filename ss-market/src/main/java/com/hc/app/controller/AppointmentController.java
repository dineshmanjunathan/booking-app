package com.hc.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hc.app.entity.Appointment;
import com.hc.app.entity.Category;
import com.hc.app.entity.UserMaster;
import com.hc.app.model.AppointmentRepository;
import com.hc.app.model.CategoryCodeRepository;
import com.hc.app.model.DoctorDetailsRepository;
import com.hc.app.model.UserRepository;
import com.hc.app.vo.AppointmentVo;
import com.hc.app.vo.TrackAppointmentVo;

@Controller
public class AppointmentController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private CategoryCodeRepository categoryCodeRepository;
	
	@Autowired
	private DoctorDetailsRepository doctorDetailsRepository;
	
	
	
	@RequestMapping("/appoinment")
	public String appoinment(HttpServletRequest request,ModelMap model) { 
		return "appointment";
	}
		
	
	@RequestMapping("/manage/time")
	public String manageTime(HttpServletRequest request,ModelMap model) { 
		return "manageTime";
	}
	
	@RequestMapping("/track/appoinment")
	public String trackAppoinment(HttpServletRequest request,ModelMap model) { 
		try {
			Iterable<Category> categoryList = categoryCodeRepository.findAll();
			model.addAttribute("categoryList", categoryList); 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return "trackAppoinment";
	}
	
	@RequestMapping(value="/track/appoinment",method=RequestMethod.POST)
	public String trackAppoinmentSearch(TrackAppointmentVo trackVo,HttpServletRequest request,ModelMap model) { 
		try {
			model.addAttribute("appointmentTrackList", "true"); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return "trackAppoinment";
	}
	
	@RequestMapping(value="/searchUser",method=RequestMethod.POST)
	public String searchUser(HttpServletRequest request,ModelMap model) { 
		try {
			UserMaster user=null;
			String searchOption=(String)request.getParameter("searchOption");
			String searchBy=(String)request.getParameter("searchBy");
			if("id".equals(searchOption)){
				user=userRepository.findById(Long.parseLong(searchBy.trim())).get();
			}else if("mobile".equals(searchOption)){
				user=userRepository.findByMobile(searchBy);
			}else {
				return "redirect:user";
			}
			model.addAttribute("user", user);
			Iterable<Category> categoryList = categoryCodeRepository.findAll();
			model.addAttribute("categoryList", categoryList); 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return "appointment";
	}
	
	@RequestMapping("/appointmentListing")
	public String categoryCodeListing(HttpServletRequest request,ModelMap model) { 
		try {
			Iterable<Appointment> appointmentList = appointmentRepository.findAll();
			model.addAttribute("appointmentList", appointmentList); 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return "appointmentListing";
	}
	
	@RequestMapping(value="/appointment/delete",method=RequestMethod.GET)
	public String appointmentDelete(@RequestParam("id")String id,HttpServletRequest request,ModelMap model) { 
		try {
			appointmentRepository.deleteById(Long.parseLong(id));
			model.addAttribute("deletesuccessmessage","Deleted Successfully"); 
			Iterable<Appointment>  appointmentList= appointmentRepository.findAll();
			model.addAttribute("appointmentList", appointmentList); 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return "appointmentListing";
	}

	@RequestMapping(value="/appointment/edit",method=RequestMethod.GET)
	public String appointmentEdit(@RequestParam("id")String id,HttpServletRequest request,ModelMap model) { 
		try {
			Appointment appointment = appointmentRepository.findById(Long.parseLong(id)).get();
			AppointmentVo appointmentVo=new AppointmentVo();
			BeanUtils.copyProperties(appointmentVo, appointment);
			model.addAttribute("appointment", appointmentVo); 
			
			Iterable<UserMaster> userList = userRepository.findAll();
			model.addAttribute("userList", userList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "appointment";  
	}


	@RequestMapping(value="/appointment/edit",method=RequestMethod.POST)
	public String appointmentEditSubmit(HttpServletRequest request,AppointmentVo appointmentVo,ModelMap model) {
		Appointment appointment=new Appointment();
		try {
			BeanUtils.copyProperties(appointment, appointmentVo);
			appointmentRepository.save(appointment);
			Iterable<Appointment>  appointmentList= appointmentRepository.findAll();
			model.addAttribute("appointmentList", appointmentList); 
			model.addAttribute("successMessage","Successfully Edited Admin Record"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "appointmentListing";
	}	

	@RequestMapping(value="/appointment/save",method=RequestMethod.POST)
	public String appointmentSubmit(HttpServletRequest request,AppointmentVo appointmentVo,ModelMap model) {
		try {
			System.out.println("inside");
			Appointment appointment=new Appointment();
			BeanUtils.copyProperties(appointment, appointmentVo);
			appointmentRepository.save(appointment);
			Iterable<Appointment>  appointmentList= appointmentRepository.findAll();
			model.addAttribute("appointmentList", appointmentList);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "appointmentListing";
	}
	
	


}
