package com.example.referral.reward.service;

import com.example.referral.admin.service.AdminConfigService;
import com.example.referral.utils.service.NotificationService;
import com.example.referral.reward.entity.RewardStatus;
import com.example.referral.reward.entity.RewardTransaction;
import com.example.referral.reward.repository.RewardTransactionRepository;
import com.example.referral.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RewardService {

    private final RewardTransactionRepository rewardRepo;
    private final UserService userService;
    private final AdminConfigService adminConfigService;
    private final NotificationService notificationService;

    @Transactional
    public void processReward(UUID referralEventId, UUID inviterId, UUID inviteeId) {
        int rewardAmount = adminConfigService.getRewardAmount();

        // Create reward transactions
        RewardTransaction inviterReward = RewardTransaction.builder()
                .userId(inviterId)
                .referralEventId(referralEventId)
                .amount(rewardAmount)
                .status(RewardStatus.PAID)
                .createdAt(Instant.now())
                .build();

        RewardTransaction inviteeReward = RewardTransaction.builder()
                .userId(inviteeId)
                .referralEventId(referralEventId)
                .amount(rewardAmount)
                .status(RewardStatus.PAID)
                .createdAt(Instant.now())
                .build();

        rewardRepo.saveAll(List.of(inviterReward, inviteeReward));

        // Credit points
        userService.addPoints(inviterId, rewardAmount);
        userService.addPoints(inviteeId, rewardAmount);

        // Notify users
        notificationService.sendRewardNotification(inviterId, rewardAmount);
        notificationService.sendRewardNotification(inviteeId, rewardAmount);
    }
}

