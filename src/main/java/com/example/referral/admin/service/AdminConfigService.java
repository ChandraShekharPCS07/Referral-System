package com.example.referral.admin.service;

import com.example.referral.admin.entity.AdminConfig;
import com.example.referral.admin.repository.AdminConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AdminConfigService {

    private final AdminConfigRepository adminRepo;

    public int getRewardAmount() {
        return Integer.parseInt(
                adminRepo.findByConfigKey("rewardAmount")
                        .orElseThrow(() -> new RuntimeException("rewardAmount not set"))
                        .getConfigValue()
        );
    }

    public boolean isCampaignEnabled() {
        return Boolean.parseBoolean(
                adminRepo.findByConfigKey("campaignEnabled")
                        .orElseThrow(() -> new RuntimeException("campaignEnabled not set"))
                        .getConfigValue()
        );
    }

    public void updateConfig(String key, String value) {
        AdminConfig config = adminRepo.findByConfigKey(key)
                .orElse(AdminConfig.builder().configKey(key).build());
        config.setConfigValue(value);
        config.setUpdatedAt(Instant.now());
        adminRepo.save(config);
    }
}

