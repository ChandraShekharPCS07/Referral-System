package com.example.referral.referral.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "referral_event")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReferralEvent {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private UUID inviterId;

    @Column(nullable = false)
    private UUID inviteeId;

    @Enumerated(EnumType.STRING)
    private ReferralStatus status;

    private Instant createdAt;

    private Instant completedAt;
}

