package com.ss.app.controller;

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
		return "adminLogin";
	} 
	
	@RequestMapping(value="/admin/login",method=RequestMethod.POST)
	public String stockPointLoginSubmit(HttpServletRequest request,MemberVo user,ModelMap model) {
		try {
			Member member = userRepository.findById(user.getId()).get();
			if(member!=null) {
				if(!user.getPassword().equals(member.getPassword())) {
					model.addAttribute("errormsg","Password is incorrect!");
					return "adminLogin";
				}
				request.getSession().setAttribute("LOGGED_ON", "true");
				request.getSession().setAttribute("MEMBER_ID", user.getId());
				request.getSession().setAttribute("MEMBER_NAME", member.getName());
				return "adminMenu";
			} else {
				model.addAttribute("errormsg","User Id or Password is incorrect!");
			}
		} catch (Exception e) {
			model.addAttribute("errormsg","Member does not Exists!");
		}
		return "adminLogin";
	}

}
