package com.example.referral.event;

import com.example.referral.referral.entity.ReferralEvent;

public class ReferralCreatedEvent {
    private final ReferralEvent referralEvent;

    public ReferralCreatedEvent(ReferralEvent referralEvent) {
        this.referralEvent = referralEvent;
    }

    public ReferralEvent getReferralEvent() {
        return referralEvent;
    }
}

