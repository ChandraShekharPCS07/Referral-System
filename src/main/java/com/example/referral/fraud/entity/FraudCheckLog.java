package com.example.referral.fraud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "fraud_check_log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudCheckLog {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID userId;

    private UUID referralEventId;

    private String result; // e.g. PASS, FAIL, FLAGGED

    private String reason;

    private Instant createdAt;
}
