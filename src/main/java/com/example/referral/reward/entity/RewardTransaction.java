package com.example.referral.reward.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "reward_transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RewardTransaction {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private UUID userId;

    private Integer amount;

    private UUID referralEventId;

    @Enumerated(EnumType.STRING)
    private RewardStatus status;

    private Instant createdAt;
}

