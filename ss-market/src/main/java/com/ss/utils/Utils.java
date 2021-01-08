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

	public static void main(String[] arg) {

	}
}
