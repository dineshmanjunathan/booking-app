package com.hc.app.controller;


import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hc.app.dao.UserDao;
import com.hc.app.entity.CountryCode;
import com.hc.app.entity.UserMaster;
import com.hc.app.model.UserRepository;
import com.hc.app.model.CountryCodeRepository;
import com.hc.app.vo.CountryCodeVo;
import com.hc.app.vo.UserVo;
import com.hc.utils.ReportGenerator;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CountryCodeRepository countryCodeRepository;
		
	@RequestMapping("/")
	public String login(HttpServletRequest request,ModelMap model) {
		return "login";
	} 
	@RequestMapping("/login")
	public String inlogin(HttpServletRequest request,ModelMap model) {
		return "login";
	} 

	@RequestMapping("/menu")
	public String menu(HttpServletRequest request,ModelMap model) {
		return "menu";
	}
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request,ModelMap model) {
		UserVo ab = (UserVo) request.getSession().getAttribute("USER");
		model.addAttribute("CURRENT_USER", ab);
		return "home";
	} 
	@RequestMapping("/user")
	public String user(HttpServletRequest request,ModelMap model) {
		Iterable<CountryCode> countryCodeList = countryCodeRepository.findAll();
		model.addAttribute("countryCodeList", countryCodeList);
		return "user";
	} 
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,ModelMap model) {
		if(request.getSession()!=null) {
			request.getSession().invalidate();
			model.addAttribute("adminlogout", "Successfully logged out");
		}
		return "login";
	} 

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginSubmit(HttpServletRequest request,UserVo user,ModelMap model) {
		try {
			request.getSession().setAttribute("LOGGED_ON", "true");
			request.getSession().setAttribute("USER_NAME", "Admin");
			return "menu";
			/*User ab = userDao.findUser(user);  
			if(ab != null) { 
				request.getSession().setAttribute("USER", ab);
				model.addAttribute("CURRENT_USER", ab);
				request.getSession().setAttribute("USER_NAME", ab.getName());
				return "home";   //menu 
			} else {
				model.addAttribute("errormsg","Username or Password is incorrect");
				return "login";
			}  */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}

	@RequestMapping(value="/userlisting",method=RequestMethod.GET)
	public String adminListingSubmit(HttpServletRequest request,ModelMap model) {
		try {
			Iterable<UserMaster> userList = userRepository.findAll(); 
			model.addAttribute("userList", userList); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userListing";
	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerSubmit(HttpServletRequest request,UserVo user,ModelMap model) {
		try {
			UserMaster userEntity=new UserMaster();
			BeanUtils.copyProperties(userEntity, user);
			userRepository.save(userEntity);
			System.out.println("Name ::"+user.getName());
			Iterable<UserMaster> userList = userRepository.findAll();
			model.addAttribute("userList", userList); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userListing";
	}

	@RequestMapping(value="/user/edit",method=RequestMethod.GET)
	public String edit(@RequestParam("user_id")String userId,HttpServletRequest request,ModelMap model) { 
		try {
			UserMaster user = userRepository.findById(Long.parseLong(userId)).get();
			UserVo userVo=new UserVo();
			BeanUtils.copyProperties(userVo, user);
			model.addAttribute("user", userVo); 
			Iterable<CountryCode> countryCodeList = countryCodeRepository.findAll();
			model.addAttribute("countryCodeList", countryCodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user";  
	}
	

	@RequestMapping(value="/user/edit",method=RequestMethod.POST)
	public String editSubmit(HttpServletRequest request,UserVo user,ModelMap model) {
		UserMaster userEntity=new UserMaster();
		try {
			BeanUtils.copyProperties(userEntity, user);
			System.out.println(userEntity.getId());
			userRepository.save(userEntity);
			Iterable<UserMaster> userList = userRepository.findAll();  
			model.addAttribute("userList", userList); 
			model.addAttribute("successMessage","Successfully Edited Admin Record"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userListing";
	}	

	@RequestMapping("/user/delete")
	public String delete(@RequestParam("user_id")String userId,HttpServletRequest request,ModelMap model) { 
		try {
			userRepository.deleteById(Long.parseLong(userId));
			//userRepository.delete(user);
			model.addAttribute("deletesuccessmessage","Deleted Successfully"); 
			Iterable<UserMaster> userList = userRepository.findAll();
			model.addAttribute("userList", userList); 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return "userListing";
	}

	@RequestMapping(value="/user/delete",method=RequestMethod.POST)
	public String deleteSubmit(HttpServletRequest request,ModelMap model) { 
		try {
			String user_id = request.getParameter("id");
			//Optional<User> user=userRepository.findById(Long.parseLong(user_id));
			userRepository.deleteById(Long.parseLong(user_id));
			model.addAttribute("deletesuccessmessage","Deleted Successfully"); 
			List<UserVo> userList;
			userList = userDao.findUsers();
			model.addAttribute("userList", userList); 
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		return "userListing";
	}
	
	@RequestMapping("/countryCodeListing")
	public String countryCodeListing(HttpServletRequest request,ModelMap model) { 
		try {
			Iterable<CountryCode> countryCodeList = countryCodeRepository.findAll();
			model.addAttribute("countryCodeList", countryCodeList); 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return "countryCodeListing";
	}

	@RequestMapping(value="/countryCode/delete",method=RequestMethod.GET)
	public String countryCodeDelete(@RequestParam("id")String id,HttpServletRequest request,ModelMap model) { 
		try {
			countryCodeRepository.deleteById(Long.parseLong(id));
			model.addAttribute("deletesuccessmessage","Deleted Successfully"); 
			Iterable<CountryCode> countryCodeList = countryCodeRepository.findAll();
			model.addAttribute("countryCodeList", countryCodeList); 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return "countryCodeListing";
	}
	
	@RequestMapping(value="/countryCode/edit",method=RequestMethod.GET)
	public String countryCodeEdit(@RequestParam("id")String id,HttpServletRequest request,ModelMap model) { 
		try {
			CountryCode countryCode = countryCodeRepository.findById(Long.parseLong(id)).get();
			CountryCodeVo countryCodeVo=new CountryCodeVo();
			BeanUtils.copyProperties(countryCodeVo, countryCode);
			model.addAttribute("countryCode", countryCodeVo); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "countryCode";  
	}
	

	@RequestMapping(value="/countryCode/edit",method=RequestMethod.POST)
	public String countryCodeEditSubmit(HttpServletRequest request,CountryCodeVo countryCodeVo,ModelMap model) {
		CountryCode countryCode=new CountryCode();
		try {
			BeanUtils.copyProperties(countryCode, countryCodeVo);
			countryCodeRepository.save(countryCode);
			Iterable<CountryCode> countryCodeList = countryCodeRepository.findAll();
			model.addAttribute("countryCodeList", countryCodeList); 
			model.addAttribute("successMessage","Successfully Edited Admin Record"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "countryCodeListing";
	}	
	
	@RequestMapping(value="/countryCode/save",method=RequestMethod.POST)
	public String countryCodeSubmit(HttpServletRequest request,CountryCodeVo countryCodeVo,ModelMap model) {
		try {
			CountryCode countryCode=new CountryCode();
			BeanUtils.copyProperties(countryCode, countryCodeVo);
			countryCodeRepository.save(countryCode);
			Iterable<CountryCode> countryCodeList = countryCodeRepository.findAll();
			model.addAttribute("countryCodeList", countryCodeList); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "countryCodeListing";
	}

	

	@RequestMapping(value = "/user/generate/pdf", method = RequestMethod.GET)
	public void export(@RequestParam("user_id")String userId,ModelAndView model, HttpServletResponse response){
		try {
			JasperPrint jasperPrint = null;
			response.setContentType("application/x-download");
			response.setHeader("Content-Disposition", String.format("attachment; filename=" + userId +".pdf" ));
			UserMaster user = userRepository.findById(Long.parseLong(userId)).get();
			OutputStream out = response.getOutputStream();
			ReportGenerator reportGenerator = new ReportGenerator();
			jasperPrint = reportGenerator.getJasperContext(reportGenerator.getReportData(user),"templates/reg.jrxml");
			JasperExportManager.exportReportToPdfStream(jasperPrint, out);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
} 