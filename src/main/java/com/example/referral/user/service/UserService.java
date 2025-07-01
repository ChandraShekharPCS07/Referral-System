package com.example.referral.user.service;

import com.example.referral.user.entity.User;
import com.example.referral.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private static final String ALPHANUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public User registerUser(String email, String passwordHash, String referralCode) {
        String newReferralCode = generateUniqueReferralCode();
        User user = User.builder()
                .email(email)
                .passwordHash(passwordHash)
                .referralCode(newReferralCode)
                .referredBy(referralCode)
                .pointsBalance(0)
                .createdAt(Instant.now())
                .build();
        return userRepository.save(user);
    }

    private String generateUniqueReferralCode() {
        String code;
        do {
            code = randomAlphanumeric(8); // Generate a random alphanumeric code of length 8
            // Ensure the code is unique in the database
        } while (userRepository.existsByReferralCode(code));
        return code;
    }

    public Optional<User> getUserById(UUID userId) {
        return userRepository.findById(userId);
    }

    public void addPoints(UUID userId, int points) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPointsBalance(user.getPointsBalance() + points);
        userRepository.save(user);
    }

    public User getUserByReferralCode(String referralCode) {
        return userRepository.findByReferralCode(referralCode)
                .orElseThrow(() -> new RuntimeException("User not found with referral code: " + referralCode));
    }

    private String randomAlphanumeric(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHANUM.charAt(RANDOM.nextInt(ALPHANUM.length())));
        }
        return sb.toString();
    }
}


