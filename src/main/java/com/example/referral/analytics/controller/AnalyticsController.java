package com.example.referral.analytics.controller;


import com.example.referral.analytics.service.AnalyticsService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/summary")
    public AnalyticsSummary getSummary() {
        return new AnalyticsSummary(
                analyticsService.getSuccessfulReferrals(),
                analyticsService.getTotalRewardsIssued(),
                analyticsService.getFraudAttempts()
        );
    }

    @Getter
    @AllArgsConstructor
    public static class AnalyticsSummary {
        private long successfulReferrals;
        private long totalRewardsIssued;
        private long fraudAttempts;
    }
}

