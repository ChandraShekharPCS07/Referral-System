package com.example.referral.utils.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationService {

    public void sendRewardNotification(UUID userId, int amount) {
        // TODO: Integrate email/SMS service
        System.out.println("Notifying user " + userId + ": You've earned " + amount + " points!");
    }
}

