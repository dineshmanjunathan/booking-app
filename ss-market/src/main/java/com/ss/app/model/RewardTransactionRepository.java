package com.ss.app.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ss.app.entity.RewardTransaction;

public interface RewardTransactionRepository extends CrudRepository<RewardTransaction, Long> {
	
	List<RewardTransaction> findByMemberid(String memberId);

	List<RewardTransaction> findByRewardedMember(String rewardedMember);
}
