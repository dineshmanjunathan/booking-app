package com.ss.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ss.app.entity.Member;
import com.ss.app.model.UserRepository;
import com.ss.app.vo.MemberVo;

@Controller
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/admin/login")
	public String inlogin(HttpServletRequest request,ModelMap model) {
		model.addAttribute("ROLE","ADMIN");
		return "commonLogin";
	} 
	
	@RequestMapping("/admin/menu")
	public String adminMenu(HttpServletRequest request,ModelMap model) {
		return "adminMenu";
	} 
	
	@RequestMapping("/member/listing")
	public String adminListing(HttpServletRequest request,ModelMap model) {
		Iterable<Member> memberList = userRepository.findAll();
		model.addAttribute("memberList",memberList);
		return "memberListing";
	} 
	
	@RequestMapping(value="/admin/login",method=RequestMethod.POST)
	public String stockPointLoginSubmit(HttpServletRequest request,MemberVo user,ModelMap model) {
		try {
			Member member = userRepository.findByIdAndPasswordAndRole(user.getId(), user.getPassword(), user.getRole()).get();
			if(member!=null && member.getId() !=null) {
				request.getSession().setAttribute("LOGGED_ON", "true");
				request.getSession().setAttribute("MEMBER_ID", user.getId());
				request.getSession().setAttribute("MEMBER_NAME", member.getName());
				request.getSession().setAttribute("ROLE", member.getRole());
				return "adminMenu";
			} else {
				model.addAttribute("errormsg","User Id or Password is incorrect!");
			}
		} catch (Exception e) {
			model.addAttribute("errormsg","Member does not Exists!");
		}
		return "commonLogin";
	}

}
