package com.example.referral.admin.controller;

import com.example.referral.admin.service.AdminConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminConfigService adminService;

    @GetMapping("/reward-amount")
    public int getRewardAmount() {
        return adminService.getRewardAmount();
    }

    @PostMapping("/reward-amount")
    public void setRewardAmount(@RequestParam int amount) {
        adminService.updateConfig("rewardAmount", String.valueOf(amount));
    }

    @GetMapping("/campaign-enabled")
    public boolean isCampaignEnabled() {
        return adminService.isCampaignEnabled();
    }

    @PostMapping("/campaign-enabled")
    public void setCampaignEnabled(@RequestParam boolean enabled) {
        adminService.updateConfig("campaignEnabled", String.valueOf(enabled));
    }
}

