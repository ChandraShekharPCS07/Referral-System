package com.example.referral.referral.controller;

import com.example.referral.referral.entity.ReferralEvent;
import com.example.referral.referral.repository.ReferralEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/referrals")
@RequiredArgsConstructor
public class ReferralController {

    private final ReferralEventRepository referralRepo;

    @GetMapping("/inviter/{inviterId}")
    public List<ReferralEvent> getReferralsByInviter(@PathVariable UUID inviterId) {
        return referralRepo.findByInviterId(inviterId);
    }

    @GetMapping("/invitee/{inviteeId}")
    public List<ReferralEvent> getReferralsByInvitee(@PathVariable UUID inviteeId) {
        return referralRepo.findByInviteeId(inviteeId);
    }
}

