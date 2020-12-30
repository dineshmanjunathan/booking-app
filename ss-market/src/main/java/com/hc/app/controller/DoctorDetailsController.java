package com.hc.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hc.app.entity.Category;
import com.hc.app.entity.CountryCode;
import com.hc.app.entity.DoctorDetails;
import com.hc.app.model.CategoryCodeRepository;
import com.hc.app.model.CountryCodeRepository;
import com.hc.app.model.DoctorDetailsRepository;
import com.hc.app.model.UserRepository;
import com.hc.app.vo.CategoryVo;
import com.hc.app.vo.DoctorDetailsVo;

@Controller
public class DoctorDetailsController {

	@Autowired
	private CategoryCodeRepository categoryCodeRepository;

	@Autowired
	private DoctorDetailsRepository doctorDetailsRepository;
	
	@Autowired
	private CountryCodeRepository countryCodeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping("/loadDoctor")
	public ResponseEntity<Iterable<DoctorDetails>> loadDoctor(@RequestParam("categoryId") String categoryId,HttpServletRequest request,ModelMap model) { 
		List<DoctorDetails> doctorDetailsList = doctorDetailsRepository.findByCategoryId(Long.parseLong(categoryId));
		model.addAttribute("doctorDetailsList", doctorDetailsList);  
		return new ResponseEntity(doctorDetailsList, HttpStatus.OK);
	}

	
	@RequestMapping("/categoryCodeListing")
	public String categoryCodeListing(HttpServletRequest request,ModelMap model) { 
		try {
			Iterable<Category> categoryCodeList = categoryCodeRepository.findAll();
			model.addAttribute("categoryCodeList", categoryCodeList); 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return "categoryCodeListing";
	}

	@RequestMapping(value="/categoryCode/delete",method=RequestMethod.GET)
	public String categoryCodeDelete(@RequestParam("id")String id,HttpServletRequest request,ModelMap model) { 
		try {
			categoryCodeRepository.deleteById(Long.parseLong(id));
			model.addAttribute("deletesuccessmessage","Deleted Successfully"); 
			Iterable<Category> categoryCodeList = categoryCodeRepository.findAll();
			model.addAttribute("categoryCodeList", categoryCodeList); 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return "categoryCodeListing";
	}

	@RequestMapping(value="/categoryCode/edit",method=RequestMethod.GET)
	public String categoryCodeEdit(@RequestParam("id")String id,HttpServletRequest request,ModelMap model) { 
		try {
			Category categoryCode = categoryCodeRepository.findById(Long.parseLong(id)).get();
			CategoryVo categoryCodeVo=new CategoryVo();
			BeanUtils.copyProperties(categoryCodeVo, categoryCode);
			model.addAttribute("categoryCode", categoryCodeVo); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "categoryCode";  
	}


	@RequestMapping(value="/categoryCode/edit",method=RequestMethod.POST)
	public String categoryCodeEditSubmit(HttpServletRequest request,CategoryVo categoryCodeVo,ModelMap model) {
		Category categoryCode=new Category();
		try {
			BeanUtils.copyProperties(categoryCode, categoryCodeVo);
			categoryCodeRepository.save(categoryCode);
			Iterable<Category> categoryCodeList = categoryCodeRepository.findAll();
			model.addAttribute("categoryCodeList", categoryCodeList); 
			model.addAttribute("successMessage","Successfully Edited Admin Record"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "categoryCodeListing";
	}	

	@RequestMapping(value="/categoryCode/save",method=RequestMethod.POST)
	public String categoryCodeSubmit(HttpServletRequest request,CategoryVo categoryCodeVo,ModelMap model) {
		try {
			Category category=new Category();
			BeanUtils.copyProperties(category, categoryCodeVo);
			categoryCodeRepository.save(category);
			Iterable<Category> categoryCodeList = categoryCodeRepository.findAll();
			model.addAttribute("categoryCodeList", categoryCodeList); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "categoryCodeListing";
	}
	
	@RequestMapping("/doctor/detail/create")
	public String createDocDetails(HttpServletRequest request,ModelMap model) {
		Iterable<CountryCode> countryCodeList = countryCodeRepository.findAll();
		model.addAttribute("countryCodeList", countryCodeList);
		Iterable<Category> categoryCodeList = categoryCodeRepository.findAll();
		model.addAttribute("categoryCodeList", categoryCodeList);
		return "doctorDetails";
	} 

	@RequestMapping("/doctorDetailsListing")
	public String doctorListing(HttpServletRequest request,ModelMap model) { 
		try {
			Iterable<DoctorDetails> doctorDetailsList = doctorDetailsRepository.findAll();
			model.addAttribute("doctorDetailsList", doctorDetailsList); 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return "doctorDetailsListing";
	}

	@RequestMapping(value="/doctor/detail/delete",method=RequestMethod.GET)
	public String doctorDetailsDelete(@RequestParam("id")String id,HttpServletRequest request,ModelMap model) { 
		try {
			doctorDetailsRepository.deleteById(Long.parseLong(id));
			model.addAttribute("deletesuccessmessage","Deleted Successfully"); 
			Iterable<DoctorDetails> doctorDetailsList = doctorDetailsRepository.findAll();
			model.addAttribute("doctorDetailsList", doctorDetailsList);  
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return "doctorDetailsListing";
	}

	@RequestMapping(value="/doctor/detail/edit",method=RequestMethod.GET)
	public String doctorDetailEdit(@RequestParam("id")String id,HttpServletRequest request,ModelMap model) { 
		try {
			DoctorDetails doctorDetails = doctorDetailsRepository.findById(Long.parseLong(id)).get();
			DoctorDetailsVo doctorDetailsVo=new DoctorDetailsVo();
			BeanUtils.copyProperties(doctorDetailsVo, doctorDetails);
			model.addAttribute("doctorDetails", doctorDetailsVo); 
			Iterable<CountryCode> countryCodeList = countryCodeRepository.findAll();
			model.addAttribute("countryCodeList", countryCodeList);
			Iterable<Category> categoryCodeList = categoryCodeRepository.findAll();
			model.addAttribute("categoryCodeList", categoryCodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "doctorDetails";  
	}


	@RequestMapping(value="/doctor/detail/edit",method=RequestMethod.POST)
	public String doctorDetailEditSubmit(HttpServletRequest request,DoctorDetailsVo doctorDetailsVo,ModelMap model) {
		DoctorDetails doctorDetails=new DoctorDetails();
		try {
			BeanUtils.copyProperties(doctorDetails, doctorDetailsVo);
			doctorDetailsRepository.save(doctorDetails);
			Iterable<DoctorDetails> doctorDetailsList = doctorDetailsRepository.findAll();
			model.addAttribute("doctorDetailsList", doctorDetailsList);  
			model.addAttribute("successMessage","Successfully Edited Admin Record"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "doctorDetailsListing";
	}	

	@RequestMapping(value="/doctor/detail/save",method=RequestMethod.POST)
	public String doctorDetailSubmit(HttpServletRequest request,DoctorDetailsVo doctorDetailsVo,ModelMap model) {
		try {
			DoctorDetails doctorDetails=new DoctorDetails();
			Category category=new Category();
			category.setId(Long.parseLong(doctorDetailsVo.getCategoryId()));
			doctorDetailsVo.setCategory(category);
			BeanUtils.copyProperties(doctorDetails, doctorDetailsVo);
			doctorDetailsRepository.save(doctorDetails);
			Iterable<DoctorDetails> doctorDetailsList = doctorDetailsRepository.findAll();
			model.addAttribute("doctorDetailsList", doctorDetailsList);   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "doctorDetailsListing";
	}

}
