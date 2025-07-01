package com.example.referral.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "users", indexes = {
        @Index(name = "idx_referral_code", columnList = "referralCode", unique = true),
        @Index(name = "idx_referred_by", columnList = "referredBy")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false, unique = true)
    private String referralCode;

    private String referredBy; // stores inviter's code

    private Integer pointsBalance;

    private Instant createdAt;
}
