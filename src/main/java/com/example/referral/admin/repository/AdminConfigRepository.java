package com.example.referral.admin.repository;

import com.example.referral.admin.entity.AdminConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdminConfigRepository extends JpaRepository<AdminConfig, UUID> {

    Optional<AdminConfig> findByConfigKey(String configKey);
}

