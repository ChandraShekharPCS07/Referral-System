package com.example.referral.event;

import com.example.referral.fraud.service.FraudService;
import com.example.referral.referral.entity.ReferralEvent;
import com.example.referral.referral.service.ReferralService;
import com.example.referral.reward.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReferralEventListener {

    private final FraudService fraudService;
    private final RewardService rewardService;
    private final ReferralService referralService;

    @EventListener
    public void handleReferralCreated(ReferralCreatedEvent event) {
        ReferralEvent referralEvent = event.getReferralEvent();
        boolean isFraud = fraudService.checkForFraud(
                referralEvent.getInviterId(),
                referralEvent.getInviteeId(),
                null,
                null
        );

        if (isFraud) {
            referralService.markReferralFraud(referralEvent.getId());
        } else {
            referralService.markReferralSuccess(referralEvent.getId());
            rewardService.processReward(
                    referralEvent.getId(),
                    referralEvent.getInviterId(),
                    referralEvent.getInviteeId()
            );
        }
    }
}

