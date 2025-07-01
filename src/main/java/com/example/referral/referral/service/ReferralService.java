package com.example.referral.referral.service;


import com.example.referral.referral.entity.ReferralEvent;
import com.example.referral.referral.entity.ReferralStatus;
import com.example.referral.event.ReferralCreatedEvent;
import com.example.referral.referral.repository.ReferralEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReferralService {

    private final ReferralEventRepository referralRepo;
    private final ApplicationEventPublisher eventPublisher;

    public ReferralEvent createReferralEvent(UUID inviterId, UUID inviteeId) {
        ReferralEvent event = ReferralEvent.builder()
                .inviterId(inviterId)
                .inviteeId(inviteeId)
                .status(ReferralStatus.PENDING)
                .createdAt(Instant.now())
                .build();
        ReferralEvent saved = referralRepo.save(event);
        eventPublisher.publishEvent(new ReferralCreatedEvent(saved));
        return saved;
    }

    public void markReferralSuccess(UUID referralEventId) {
        ReferralEvent event = referralRepo.findById(referralEventId)
                .orElseThrow(() -> new RuntimeException("Referral event not found"));
        event.setStatus(ReferralStatus.SUCCESS);
        event.setCompletedAt(Instant.now());
        referralRepo.save(event);
    }

    public void markReferralFraud(UUID referralEventId) {
        ReferralEvent event = referralRepo.findById(referralEventId)
                .orElseThrow(() -> new RuntimeException("Referral event not found"));
        event.setStatus(ReferralStatus.FRAUD);
        referralRepo.save(event);
    }
}

