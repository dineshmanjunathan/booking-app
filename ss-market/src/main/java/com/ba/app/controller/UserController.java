package com.ba.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ba.app.entity.CountryCode;
import com.ba.app.entity.User;
import com.ba.app.model.CountryCodeRepository;
import com.ba.app.model.UserRepository;
import com.ba.app.vo.CountryCodeVo;
import com.ba.app.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CountryCodeRepository countryCodeRepository;

	@RequestMapping("/")
	public String landingPage(HttpServletRequest request, ModelMap model) {
		return "login";
	}

	@RequestMapping("/login")
	public String inlogin(HttpServletRequest request, ModelMap model) {
		return "login";
	}

	@RequestMapping("/menu")
	public String menu(HttpServletRequest request, ModelMap model) {
		return "menu";
	}

	@RequestMapping("/home")
	public String home(HttpServletRequest request, ModelMap model) {
		UserVo ab = (UserVo) request.getSession().getAttribute("USER");
		model.addAttribute("CURRENT_USER", ab);
		return "home";
	}

	@RequestMapping("/register")
	public String user(HttpServletRequest request, ModelMap model) {
		/*
		 * Iterable<CountryCode> countryCodeList = countryCodeRepository.findAll();
		 * model.addAttribute("countryCodeList", countryCodeList);
		 */
		return "user";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, ModelMap model) {
		String redirectPath = "login";
		if (request.getSession() != null) {
			if (request.getSession().getAttribute("ROLE") != null
					&& request.getSession().getAttribute("ROLE").equals("ADMIN")) {
				model.addAttribute("ROLE", "ADMIN");
				redirectPath = "commonLogin";
			} else if (request.getSession().getAttribute("ROLE") != null
					&& request.getSession().getAttribute("ROLE").equals("STOCK_POINT")) {
				model.addAttribute("ROLE", "STOCK_POINT");
				redirectPath = "commonLogin";
			}

			request.getSession().invalidate();
			model.addAttribute("adminlogout", "Successfully logged out");
		}
		return redirectPath;
	}

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public String
	 * loginSubmit(HttpServletRequest request, UserVo user, ModelMap model) { try {
	 * User member = userRepository.findByIdAndPasswordAndRole(user.getId(),
	 * user.getPassword(), "MEMBER").get(); if (member != null && member.getId() !=
	 * null) { if (!user.getPassword().equals(member.getPassword())) {
	 * model.addAttribute("errormsg", "Password is incorrect!"); return "login"; }
	 * request.getSession().setAttribute("LOGGED_ON", "true");
	 * request.getSession().setAttribute("MEMBER_ID", user.getId());
	 * request.getSession().setAttribute("MEMBER_NAME", member.getName());
	 * request.getSession().setAttribute("ROLE", member.getRole()); return "menu"; }
	 * else { model.addAttribute("errormsg", "User Id or Password is incorrect!"); }
	 * } catch (Exception e) { model.addAttribute("errormsg",
	 * "Member does not Exists!"); } return "login"; }
	 */

	@RequestMapping(value = "/userlisting", method = RequestMethod.GET)
	public String adminListingSubmit(HttpServletRequest request, ModelMap model) {
		try {
			Iterable<User> userList = userRepository.findAll();
			model.addAttribute("userList", userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userListing";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerSubmit(HttpServletRequest request, UserVo user, ModelMap model) {
		try {
			String role = (String) request.getSession().getAttribute("ROLE");

			User userEntity = new User();
			model.addAttribute("member", user);

			BeanUtils.copyProperties(user, userEntity, "createon", "updatedon");
			userRepository.save(userEntity);

			if (role != null && role.equals("ADMIN")) {
				model.addAttribute("successMessage", "Member Created Successfully! ");
				Iterable<User> memberList = userRepository.findAll();
				model.addAttribute("memberList", memberList);
				return "memberListing";
			} else {
				model.addAttribute("registersuccess", "Member Registered Successfully! ");
			}

			// TODO SMS to member mobile number
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errormsg", "Member Registered Failed! ");
			return "user";
		}
		return "login";
	}

	@RequestMapping(value = "/user/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("user_id") String userId, HttpServletRequest request, ModelMap model) {
		try {
			User user = userRepository.findById(userId).get();
			model.addAttribute("member", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "useredit";
	}

	@RequestMapping("/countryCodeListing")
	public String countryCodeListing(HttpServletRequest request, ModelMap model) {
		try {
			Iterable<CountryCode> countryCodeList = countryCodeRepository.findAll();
			model.addAttribute("countryCodeList", countryCodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "countryCodeListing";
	}

	@RequestMapping(value = "/countryCode/delete", method = RequestMethod.GET)
	public String countryCodeDelete(@RequestParam("id") String id, HttpServletRequest request, ModelMap model) {
		try {
			countryCodeRepository.deleteById(Long.parseLong(id));
			model.addAttribute("deletesuccessmessage", "Deleted Successfully");
			Iterable<CountryCode> countryCodeList = countryCodeRepository.findAll();
			model.addAttribute("countryCodeList", countryCodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "countryCodeListing";
	}

	@RequestMapping(value = "/countryCode/edit", method = RequestMethod.GET)
	public String countryCodeEdit(@RequestParam("id") String id, HttpServletRequest request, ModelMap model) {
		try {
			CountryCode countryCode = countryCodeRepository.findById(Long.parseLong(id)).get();
			CountryCodeVo countryCodeVo = new CountryCodeVo();
			BeanUtils.copyProperties(countryCodeVo, countryCode);
			model.addAttribute("countryCode", countryCodeVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "countryCode";
	}

	@RequestMapping(value = "/countryCode/edit", method = RequestMethod.POST)
	public String countryCodeEditSubmit(HttpServletRequest request, CountryCodeVo countryCodeVo, ModelMap model) {
		CountryCode countryCode = new CountryCode();
		try {
			BeanUtils.copyProperties(countryCode, countryCodeVo);
			countryCodeRepository.save(countryCode);
			Iterable<CountryCode> countryCodeList = countryCodeRepository.findAll();
			model.addAttribute("countryCodeList", countryCodeList);
			model.addAttribute("successMessage", "Successfully Edited Admin Record");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "countryCodeListing";
	}

	@RequestMapping(value = "/countryCode/save", method = RequestMethod.POST)
	public String countryCodeSubmit(HttpServletRequest request, CountryCodeVo countryCodeVo, ModelMap model) {
		try {
			CountryCode countryCode = new CountryCode();
			BeanUtils.copyProperties(countryCode, countryCodeVo);
			countryCodeRepository.save(countryCode);
			Iterable<CountryCode> countryCodeList = countryCodeRepository.findAll();
			model.addAttribute("countryCodeList", countryCodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "countryCodeListing";
	}

	@RequestMapping("/contactus")
	public String contactus(HttpServletRequest request, ModelMap model) {
		return "contactus";
	}

	/*
	 * @RequestMapping("/get/member") public ResponseEntity<String>
	 * findMember(@RequestParam("memberId") String memberId, HttpServletRequest
	 * request, ModelMap model) { User member =
	 * userRepository.findById(memberId).get(); return new
	 * ResponseEntity<String>(member.getName(), HttpStatus.OK); }
	 */
}