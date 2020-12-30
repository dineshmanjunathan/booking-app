/*
 * package com.hc.app.controller;
 * 
 * import javax.servlet.http.HttpServletRequest;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.ModelMap; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod;
 * 
 * import com.hc.app.model.AppointmentRepository; import
 * com.hc.app.model.CategoryCodeRepository; import
 * com.hc.app.model.DoctorDetailsRepository; import
 * com.hc.app.model.UserRepository; import com.hc.app.vo.TrackAppointmentVo;
 * 
 * @Controller public class UserRewardWalletController {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Autowired private AppointmentRepository appointmentRepository;
 * 
 * @Autowired private CategoryCodeRepository categoryCodeRepository;
 * 
 * @Autowired private DoctorDetailsRepository doctorDetailsRepository;
 * 
 * @RequestMapping(value = "/track/appoinment", method = RequestMethod.POST)
 * public String trackAppoinmentSearch(TrackAppointmentVo trackVo,
 * HttpServletRequest request, ModelMap model) { try {
 * model.addAttribute("appointmentTrackList", "true");
 * 
 * } catch (Exception e) { e.printStackTrace(); } return "trackAppoinment"; }
 * 
 * }
 */