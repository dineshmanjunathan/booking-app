package com.ss.app.controller;

import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.google.gson.Gson;
import com.ss.app.entity.CountryCode;
import com.ss.app.entity.Member;
import com.ss.app.model.CountryCodeRepository;
import com.ss.app.model.UserRepository;
import com.ss.app.vo.CountryCodeVo;
import com.ss.app.vo.MemberTree;
import com.ss.app.vo.MemberVo;
import com.ss.utils.ReportGenerator;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class MemberController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CountryCodeRepository countryCodeRepository;

	@RequestMapping("/")
	public String login(HttpServletRequest request, ModelMap model) {
		return "login";
	}

	@RequestMapping("/login")
	public String inlogin(HttpServletRequest request, ModelMap model) {
		return "login";
	}

	@RequestMapping("/stock/point/login")
	public String stockPoint(HttpServletRequest request, ModelMap model) {
		return "stockPointLogin";
	}

	@RequestMapping("/menu")
	public String menu(HttpServletRequest request, ModelMap model) {
		return "menu";
	}

	@RequestMapping("/home")
	public String home(HttpServletRequest request, ModelMap model) {
		MemberVo ab = (MemberVo) request.getSession().getAttribute("USER");
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
		if (request.getSession() != null) {
			request.getSession().invalidate();
			model.addAttribute("adminlogout", "Successfully logged out");
		}
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSubmit(HttpServletRequest request, MemberVo user, ModelMap model) {
		try {
			Member member = userRepository.findByIdAndPasswordAndRole(user.getId(), user.getPassword(), "MEMBER").get();
			if (member != null && member.getId()!=null) {
				if (!user.getPassword().equals(member.getPassword())) {
					model.addAttribute("errormsg", "Password is incorrect!");
					return "login";
				}
				request.getSession().setAttribute("LOGGED_ON", "true");
				request.getSession().setAttribute("MEMBER_ID", user.getId());
				request.getSession().setAttribute("MEMBER_NAME", member.getName());
				request.getSession().setAttribute("ROLE", member.getRole());
				return "menu";
			} else {
				model.addAttribute("errormsg", "User Id or Password is incorrect!");
			}
		} catch (Exception e) {
			model.addAttribute("errormsg", "Member does not Exists!");
		}
		return "login";
	}

	@RequestMapping(value = "/stock/point/login", method = RequestMethod.POST)
	public String stockPointLoginSubmit(HttpServletRequest request, MemberVo user, ModelMap model) {
		try {
			Member member = userRepository.findById(user.getId()).get();
			if (member != null) {
				if (!user.getPassword().equals(member.getPassword())) {
					model.addAttribute("errormsg", "Password is incorrect!");
					return "stockPointLogin";
				}
				request.getSession().setAttribute("LOGGED_ON", "true");
				request.getSession().setAttribute("MEMBER_ID", user.getId());
				request.getSession().setAttribute("MEMBER_NAME", member.getName());
				return "stockPointMenu";
			} else {
				model.addAttribute("errormsg", "User Id or Password is incorrect!");
			}
		} catch (Exception e) {
			model.addAttribute("errormsg", "Member does not Exists!");
		}
		return "stockPointLogin";
	}

	@RequestMapping(value = "/wallet", method = RequestMethod.GET)
	public String getWalletBalance(HttpServletRequest request, ModelMap model) {
		try {
			String userId = (String) request.getSession().getAttribute("MEMBER_ID");

			Member member = userRepository.findById(userId).get();
			if (member != null && member.getId() != null) {

				member.setTotalbalance(member.getWalletBalance() + member.getWalletWithdrawn());
				model.addAttribute("userwallet", member);
				return "wallet";
			} else {
				model.addAttribute("errormsg", "Try again sometime");
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return "login";
	}

	@RequestMapping(value = "/wallet/rePurchase", method = RequestMethod.POST)
	public String redirectToRePurcahse(HttpServletRequest request, MemberVo user, ModelMap model) {
		Member userEntity = new Member();
		try {

			BeanUtils.copyProperties(user, userEntity);
			model.addAttribute("member", userEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "rePurchase";
	}

	@RequestMapping(value = "updateRePurchase", method = RequestMethod.POST)
	public String updateToRePurcahse(HttpServletRequest request, MemberVo user, ModelMap model) {
		try {
			String userId = (String) request.getSession().getAttribute("MEMBER_ID");
			Member member = userRepository.findById(userId).get();

			if (user.getWalletBalance() <= user.getRepurcahse()) {
				model.addAttribute("errormsg", "Given value is greater than available balance!");
				

				model.addAttribute("member", member);
				
				return "rePurchase";
			}
			
			member.setRepurcahse(user.getRepurcahse());
			member.setWalletBalance(member.getWalletBalance() - user.getRepurcahse());
			member.setUpdatedon(new Date(System.currentTimeMillis()));
			member = userRepository.save(member);

			member.setTotalbalance(member.getWalletBalance() + member.getWalletWithdrawn() + member.getRepurcahse());
			model.addAttribute("userwallet", member);

			model.addAttribute("successMessage", "Points successfully added to Re Purchase!");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errormsg", "Failed to add points in  Re Purchase!");
		}
		return "wallet";
	}

	@RequestMapping(value = "/userlisting", method = RequestMethod.GET)
	public String adminListingSubmit(HttpServletRequest request, ModelMap model) {
		try {
			Iterable<Member> userList = userRepository.findAll();
			model.addAttribute("userList", userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userListing";
	}

	@RequestMapping(value = "/member/tree", method = RequestMethod.GET)
	public String memberTree(HttpServletRequest request, ModelMap model) {
		try {
			List<MemberTree> treeList = new ArrayList<>();
			String memberId = (String) request.getSession().getAttribute("MEMBER_ID");
			Member member = userRepository.findById(memberId).get();
			MemberTree tree = new MemberTree();
			tree.setId(memberId);
			tree.setParent("#");
			tree.setText(memberId);
			treeList.add(tree);
			findTree(member.getReferencecode(), memberId, treeList);
			String json = new Gson().toJson(treeList);
			System.out.println(json);
			model.addAttribute("JSON_TREE", json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "memberTree";
	}

	@SuppressWarnings("unused")
	private List<String> recursionTree(MemberTree tree, String basekeyCode, String memberId) {
		List<Member> child = userRepository.findByReferedby(basekeyCode);
		List<String> c = new ArrayList<>();
		List<MemberTree> subTreeList = new ArrayList<>();
		MemberTree subTree = null;
		for (Member mem : child) {
			subTree = new MemberTree();
			subTree.setId(mem.getId());
			subTree.setParent(memberId);
			subTree.setText(mem.getId());
			recursionTree(subTree, mem.getReferencecode(), mem.getId());
			subTreeList.add(subTree);
		}
		// tree.setChildren(subTreeList);
		return c;
	}

	private void findTree(String basekeyCode, String memberId, List<MemberTree> treeList) {
		List<Member> child = userRepository.findByReferedby(basekeyCode);
		MemberTree subTree = null;
		for (Member mem : child) {
			subTree = new MemberTree();
			subTree.setId(mem.getId());
			subTree.setParent(memberId);
			subTree.setText(mem.getId() + "(" + mem.getName() + ")");
			treeList.add(subTree);
			findTree(mem.getReferencecode(), mem.getId(), treeList);
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerSubmit(HttpServletRequest request, MemberVo user, ModelMap model) {
		try {
			String role = (String) request.getSession().getAttribute("ROLE");

			Member userEntity = new Member();
			model.addAttribute("member", user);
			user.setRole("MEMBER");
			
			BeanUtils.copyProperties(user, userEntity, "createon", "updatedon");
			if (StringUtils.isNotEmpty(user.getReferedby())) {
				String referedBy = userRepository.checkSponserExists(user.getReferedby());
				if (StringUtils.isEmpty(referedBy)) {
					
					model.addAttribute("errormsg", "Invalid Sponser Id.");
					if(role!=null && role.equals("ADMIN")) {
						model.addAttribute("member", userEntity);
						return "useredit";
					}else {
						return "user";
					}
				}
			}
			userRepository.save(userEntity);
			
			if(role!=null && role.equals("ADMIN")) {
				model.addAttribute("successMessage", "Member Created Successfully! ");
				Iterable<Member> memberList = userRepository.findAll();
				model.addAttribute("memberList",memberList);
				return "memberListing";
			}else {
				model.addAttribute("registersuccess", "Member Registered Successfully! ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errormsg", "Member Registered Failed! ");
			return "user";
		}
		return "login";
	}

	@RequestMapping(value = "/user/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("user_id") String userId,HttpServletRequest request, ModelMap model) {
		try {
			Member user = userRepository.findById(userId).get();
			MemberVo memberVo = new MemberVo();
			BeanUtils.copyProperties(user, memberVo);
			model.addAttribute("member", memberVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "useredit";
	}

	@RequestMapping(value = "/user/edit", method = RequestMethod.POST)
	public String editSubmit(HttpServletRequest request, MemberVo user, ModelMap model) {
		Member userEntity = new Member();
		try {
			BeanUtils.copyProperties(user, userEntity);
			userEntity.setUpdatedon(new Date(System.currentTimeMillis()));

			Member member = userRepository.save(userEntity);

			model.addAttribute("member", member);
			model.addAttribute("successMessage", "Member profile updated successfully");
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

	@RequestMapping(value = "/user/generate/pdf", method = RequestMethod.GET)
	public void export(@RequestParam("user_id") String userId, ModelAndView model, HttpServletResponse response) {
		try {
			JasperPrint jasperPrint = null;
			response.setContentType("application/x-download");
			response.setHeader("Content-Disposition", String.format("attachment; filename=" + userId + ".pdf"));
			Member user = userRepository.findById(userId).get();
			OutputStream out = response.getOutputStream();
			ReportGenerator reportGenerator = new ReportGenerator();
			jasperPrint = reportGenerator.getJasperContext(reportGenerator.getReportData(user), "templates/reg.jrxml");
			JasperExportManager.exportReportToPdfStream(jasperPrint, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/wallet/balance")
	public ResponseEntity<Member> loadWallet(@RequestParam("memberId") String memberId, HttpServletRequest request,
			ModelMap model) {
		Member member = userRepository.findById(memberId).get();
		model.addAttribute("balance", member.getWalletBalance());
		model.addAttribute("withdrawn", member.getWalletWithdrawn());
		model.addAttribute("totalEarned", member.getWalletBalance() + member.getWalletWithdrawn());
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@RequestMapping("/contactus")
	public String contactus(HttpServletRequest request, ModelMap model) {
		return "contactus";
	}
	
}