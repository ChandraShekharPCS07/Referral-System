package com.example.referral.fraud.service;

import com.example.referral.fraud.entity.FraudCheckLog;
import com.example.referral.fraud.repository.FraudCheckLogRepository;
import com.example.referral.referral.service.ReferralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FraudService {

    private final FraudCheckLogRepository fraudRepo;
    private final ReferralService referralService;

    public boolean checkForFraud(UUID inviterId, UUID inviteeId, String ipAddress, String deviceId) {
        // Example fraud rules
        if (inviterId.equals(inviteeId)) {
            logFraud(inviteeId, "SELF_REFERRAL");
            return true;
        }

        // Add IP/device matching logic here
        // For now just log pass
        logPass(inviteeId);
        return false;
    }

    private void logFraud(UUID userId, String reason) {
        fraudRepo.save(FraudCheckLog.builder()
                .userId(userId)
                .result("FAIL")
                .reason(reason)
                .createdAt(Instant.now())
                .build());
    }

    private void logPass(UUID userId) {
        fraudRepo.save(FraudCheckLog.builder()
                .userId(userId)
                .result("PASS")
                .reason("No issues")
                .createdAt(Instant.now())
                .build());
    }
}

