package com.example.referral.admin.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "admin_config")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminConfig {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "config_key", nullable = false, unique = true)
    @Value("${referral.reward.defaultKey}")
    private String configKey;

    @Column(name = "config_value", nullable = false)
    @Value("${referral.reward.defaultAmount}")
    private String configValue;

    private Instant updatedAt;
}

