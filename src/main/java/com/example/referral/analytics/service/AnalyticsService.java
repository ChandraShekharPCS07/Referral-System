package com.example.referral.analytics.service;

import com.example.referral.fraud.repository.FraudCheckLogRepository;
import com.example.referral.referral.entity.ReferralStatus;
import com.example.referral.referral.repository.ReferralEventRepository;
import com.example.referral.reward.repository.RewardTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final ReferralEventRepository referralRepo;
    private final RewardTransactionRepository rewardRepo;
    private final FraudCheckLogRepository fraudRepo;

    public long getSuccessfulReferrals() {
        return referralRepo.countByStatus(ReferralStatus.SUCCESS);
    }

    public long getTotalRewardsIssued() {
        return rewardRepo.count();
    }

    public long getFraudAttempts() {
        return fraudRepo.count();
    }
}

