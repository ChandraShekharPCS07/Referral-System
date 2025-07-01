package com.example.referral.user.controller;

import com.example.referral.referral.service.ReferralService;
import com.example.referral.user.entity.User;
import com.example.referral.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ReferralService referralService;

    @PostMapping("/register")
    public User registerUser(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam(required = false) String referralCode
    ) {
        User newUser = userService.registerUser(email, password, referralCode);

        // if referral code was used, create ReferralEvent
        if (referralCode != null && !referralCode.isBlank()) {
            User inviter = userService.getUserByReferralCode(referralCode);
            referralService.createReferralEvent(inviter.getId(), newUser.getId());
        }

        return newUser;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable UUID id) {
        return userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}

