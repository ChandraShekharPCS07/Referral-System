package com.example.referral.reward.repository;

import com.example.referral.reward.entity.RewardStatus;
import com.example.referral.reward.entity.RewardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RewardTransactionRepository extends JpaRepository<RewardTransaction, UUID> {

    List<RewardTransaction> findByUserId(UUID userId);

    long countByStatus(RewardStatus status);

    List<RewardTransaction> findByReferralEventId(UUID referralEventId);
}

