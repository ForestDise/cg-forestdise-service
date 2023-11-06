package com.forestdise.service;

import com.forestdise.entity.User;
import com.forestdise.entity.VerificationToken;

public interface EmailService {
    void sendConfirmEmail(User user, String token);
    void sendPaymentEmail(User user);
}
