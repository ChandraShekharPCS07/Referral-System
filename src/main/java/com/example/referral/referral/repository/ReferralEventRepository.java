package com.example.referral.referral.repository;

import com.example.referral.referral.entity.ReferralEvent;
import com.example.referral.referral.entity.ReferralStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReferralEventRepository extends JpaRepository<ReferralEvent, UUID> {

    List<ReferralEvent> findByInviterId(UUID inviterId);

    List<ReferralEvent> findByInviteeId(UUID inviteeId);

    long countByStatus(ReferralStatus status);
}
