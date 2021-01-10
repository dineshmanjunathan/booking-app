package com.ss.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.common.collect.Lists;
import com.ss.app.entity.Member;

public class Utils {
	/**
	 * 
	 * @param memberList
	 * @return
	 */
	public HashMap<String, Long> computeMemberCount(Iterable<Member> memberList) {
		HashMap<String, Long> userList = new HashMap<String, Long>();
		long active = 0;
		long inactive = 0;
		long stock = 0;
		long todaycount = 0;
		try {
			if (memberList != null) {
				ArrayList<Member> importOrderList = Lists.newArrayList(memberList);
				for (Member member : importOrderList) {
					LocalDateTime computeDate = member.getActive_days();
					
					if (member.getRole() != null && member.getRole().equalsIgnoreCase("ADMIN")) {
						continue;
					}
							
							
					if (computeDate == null) {
						computeDate = LocalDateTime.now();
					}
					if (computeDate.isAfter(LocalDateTime.now())) {
						++active;
					} else {
						++inactive;
					}
					if (member.getRole() != null && member.getRole().equalsIgnoreCase("STOCK_POINT"))
						++stock;
					if (member.getCreateon() != null && member.getCreateon().toLocalDate().equals(LocalDate.now()))
						++todaycount;
				}
			}
			userList.put("ACTIVE_MEMBER", active);
			userList.put("INACTIVE_MEMBER", inactive);
			userList.put("STOCK_MEMBER", stock);
			userList.put("TOTAL_MEMBER", active + inactive);
			userList.put("TOTAY_MEMBER", todaycount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public static String checkNull(String str, String _default) {
		String result = null;
		try {
			if (str != null && str.trim().length() > 0 && !str.trim().equals("null")) {
				result = str.trim();
			} else {
				result = _default;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] arg) {
		
		Long rp = 40L;
		Long remaningPoint = 540L;
		Double config1 = Double.parseDouble(Utils.checkNull("10", "0.0"));
		Double config2 = Double.parseDouble(Utils.checkNull("5", "0.0"));
		Double deductAmt1 = (rp.doubleValue() / 100) * config1;
		Double deductAmt2 = (rp.doubleValue() / 100) * config2;
		Long totaldeduct = (long) (deductAmt1 + deductAmt2);

		remaningPoint = remaningPoint - rp;
		
		System.out.println("config1 -->"+config1);
		System.out.println("config2 -->"+config2);
		System.out.println("deductAmt1 -->"+deductAmt1);
		System.out.println("deductAmt2 -->"+deductAmt2);
		System.out.println("deductAmt2 -->"+deductAmt2);

	}
}
