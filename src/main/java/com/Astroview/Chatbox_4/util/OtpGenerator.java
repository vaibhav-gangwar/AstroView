package com.Astroview.Chatbox_4.util;

import org.springframework.stereotype.Component;

@Component
public class OtpGenerator {
    public String generateOtp() {
        return String.valueOf((int) (Math.random() * 9000) + 1000);
    }
}

