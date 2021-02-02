package com.ss.utils;

import java.util.Map;

import com.google.gson.Gson;
import com.ss.app.entity.RewardTransaction;
import com.ss.app.model.RewardTransactionRepository;
import com.ss.app.vo.MemberRewardTree;

public class BatchProcess {

	static String awardMember = null;
	static Double awdVal = 0.0;

	public static Double parse(String a, Map<String, Double> configMap,
			RewardTransactionRepository rewardTransactionRepository) {
		Gson g = new Gson();
		awdVal=0.0;
		try {
			MemberRewardTree e = g.fromJson(a, MemberRewardTree.class);
			awardMember = e.getId();
			parseMember(e);
			rewardMember(e, configMap, rewardTransactionRepository);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return awdVal;

	}

	private static void parseMember(MemberRewardTree e) {
		setParentAndLevel(e, 0, e.getId());
	}

	private static void setParentAndLevel(MemberRewardTree e, int lvl, String parent) {
		try {
		e.setLevel(lvl);
		e.setParentId(parent);
		if (e.getChildren() != null && e.getChildren().size() > 0) {
			lvl++;
			for (MemberRewardTree emp : e.getChildren()) {
				setParentAndLevel(emp, lvl, e.getId());
			}
		}
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void rewardMember(MemberRewardTree e, Map<String, Double> configMap,
			RewardTransactionRepository rewardTransactionRepository) {
		try {
			System.out.println(e);
			Double rewardVal = 0.0;
			if (e.getLevel() != 0) {
				rewardVal = configMap.get("L" + e.getLevel());
			}
			RewardTransaction reward = new RewardTransaction();
			reward.setMemberid(e.getId());
			reward.setPoint(rewardVal);
			reward.setOrderNumber(100001L);
			reward.setRewardedMember(awardMember);
			reward.setSponserId(e.getSponserId());
			awdVal = awdVal + rewardVal;
			if (rewardVal > 0) {
				rewardTransactionRepository.save(reward);
			}

			if (e.getChildren() != null && e.getChildren().size() > 0) {
				for (MemberRewardTree emp : e.getChildren()) {
					rewardMember(emp, configMap, rewardTransactionRepository);
				}
			} else {
				return;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
