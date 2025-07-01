package com.example.referral.reward.controller;

import com.example.referral.reward.entity.RewardTransaction;
import com.example.referral.reward.repository.RewardTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rewards")
@RequiredArgsConstructor
public class RewardController {

    private final RewardTransactionRepository rewardRepo;

    @GetMapping("/user/{userId}")
    public List<RewardTransaction> getRewardsForUser(@PathVariable UUID userId) {
        return rewardRepo.findByUserId(userId);
    }
}

