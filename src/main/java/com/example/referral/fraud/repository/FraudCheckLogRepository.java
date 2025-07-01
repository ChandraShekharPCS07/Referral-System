package com.example.referral.fraud.repository;

import com.example.referral.fraud.entity.FraudCheckLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FraudCheckLogRepository extends JpaRepository<FraudCheckLog, UUID> {

    List<FraudCheckLog> findByUserId(UUID userId);

    List<FraudCheckLog> findByReferralEventId(UUID referralEventId);
}

