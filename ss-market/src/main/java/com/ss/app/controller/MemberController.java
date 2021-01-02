package com.ss.app.controller;


import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ss.app.dao.UserDao;
import com.ss.app.entity.CountryCode;
import com.ss.app.entity.Member;
import com.ss.app.model.CountryCodeRepository;
import com.ss.app.model.UserRepository;
import com.ss.app.vo.CountryCodeVo;
import com.ss.app.vo.MemberVo;
import com.ss.utils.ReportGenerator;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class MemberController {

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
		MemberVo ab = (MemberVo) request.getSession().getAttribute("USER");
		model.addAttribute("CURRENT_USER", ab);
		return "home";
	} 
	@RequestMapping("/register")
	public String user(HttpServletRequest request,ModelMap model) {
		/*
		 * Iterable<CountryCode> countryCodeList = countryCodeRepository.findAll();
		 * model.addAttribute("countryCodeList", countryCodeList);
		 */
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
	public String loginSubmit(HttpServletRequest request,MemberVo user,ModelMap model) {
		try {
			Member member = userRepository.findById(user.getId()).get();
			if(member!=null) {
				request.getSession().setAttribute("LOGGED_ON", "true");
				request.getSession().setAttribute("MEMBER_ID", user.getId());
				request.getSession().setAttribute("MEMBER_NAME", member.getName());
				return "menu";
			} else {
				model.addAttribute("errormsg","User Id or Password is incorrect!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}
	
	@RequestMapping(value="/wallet",method=RequestMethod.GET)
	public String getWalletBalance(HttpServletRequest request,ModelMap model) {
		try {
			String userId=(String) request.getSession().getAttribute("MEMBER_ID");
			
			Member member = userRepository.findById(userId).get();
			if(member!=null && member.getId()!=null) {
				
				member.setTotalbalance(member.getWalletBalance()+member.getWalletWithdrawn());
				model.addAttribute("userwallet", member);
				return "wallet";
			}else {
				model.addAttribute("errormsg","Try again sometime");
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return "login";
	}

	@RequestMapping(value="/userlisting",method=RequestMethod.GET)
	public String adminListingSubmit(HttpServletRequest request,ModelMap model) {
		try {
			Iterable<Member> userList = userRepository.findAll(); 
			model.addAttribute("userList", userList); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userListing";
	}
	
	@RequestMapping(value="/member/tree",method=RequestMethod.GET)
	public String memberTree(HttpServletRequest request,ModelMap model) {
		try {
			Map<String, List<String>> tree = new HashedMap();
			String memberId = (String) request.getSession().getAttribute("MEMBER_ID");
			Member member = userRepository.findById(memberId).get();
			recursionTree(tree, member.getReferencecode(), memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "memberTree";
	}
	
	private List<String> recursionTree(Map<String, List<String>> tree, String basekeyCode, String memberId) {
		List<Member> child= userRepository.findByReferedby(basekeyCode);
		List<String> c = new ArrayList<>();
		for(Member mem : child) {
			c.add(mem.getId());
		}
		tree.put(memberId, c);
		for(String keycode : c) {
			recursionTree(tree, keycode, memberId);
		}
		return c;
	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerSubmit(HttpServletRequest request,MemberVo user,ModelMap model) {
		try {
			Member userEntity=new Member();
			model.addAttribute("member", user);
			BeanUtils.copyProperties(user, userEntity, "createon", "updatedon");
			if(StringUtils.isNotEmpty(user.getReferedby())) {
				String referedBy = userRepository.checkSponserExists(user.getReferedby());
				if(StringUtils.isEmpty(referedBy)) {
					model.addAttribute("errormsg", "Invalid Sponser Id.");
					return "user";
				}
			}
			userRepository.save(userEntity);
			System.out.println("Name ::"+user.getName());
			model.addAttribute("registersuccess", "Member Registered Successfully! ");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errormsg", "Member Registered Failed! ");
			return "user";
		}
		return "login";
	}

	@RequestMapping(value="/user/edit",method=RequestMethod.GET)
	public String edit(@RequestParam("user_id")String userId,HttpServletRequest request,ModelMap model) { 
		try {
			Member user = userRepository.findById(userId).get();
			MemberVo MemberVo=new MemberVo();
			BeanUtils.copyProperties(user, MemberVo);
			model.addAttribute("user", MemberVo); 
			Iterable<CountryCode> countryCodeList = countryCodeRepository.findAll();
			model.addAttribute("countryCodeList", countryCodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user";  
	}
	

	@RequestMapping(value="/user/edit",method=RequestMethod.POST)
	public String editSubmit(HttpServletRequest request,MemberVo user,ModelMap model) {
		Member userEntity=new Member();
		try {
			BeanUtils.copyProperties(userEntity, user);
			System.out.println(userEntity.getId());
			userRepository.save(userEntity);
			Iterable<Member> userList = userRepository.findAll();  
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
			userRepository.deleteById(userId);
			//userRepository.delete(user);
			model.addAttribute("deletesuccessmessage","Deleted Successfully"); 
			Iterable<Member> userList = userRepository.findAll();
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
			userRepository.deleteById(user_id);
			model.addAttribute("deletesuccessmessage","Deleted Successfully"); 
			List<MemberVo> userList;
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
			Member user = userRepository.findById(userId).get();
			OutputStream out = response.getOutputStream();
			ReportGenerator reportGenerator = new ReportGenerator();
			jasperPrint = reportGenerator.getJasperContext(reportGenerator.getReportData(user),"templates/reg.jrxml");
			JasperExportManager.exportReportToPdfStream(jasperPrint, out);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/wallet/balance")
	public ResponseEntity<Member> loadWallet(@RequestParam("memberId") String memberId,HttpServletRequest request,ModelMap model) { 
		Member member = userRepository.findById(memberId).get();
		model.addAttribute("balance", member.getWalletBalance());
		model.addAttribute("withdrawn", member.getWalletWithdrawn()); 
		model.addAttribute("totalEarned", member.getWalletBalance() + member.getWalletWithdrawn()); 
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	
} 