package com.example.referral.user.repository;

import com.example.referral.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    Optional<User> findByReferralCode(String referralCode);

    boolean existsByReferralCode(String referralCode);
}
