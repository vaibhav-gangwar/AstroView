package com.Astroview.Chatbox_4.controller;

import com.Astroview.Chatbox_4.entity.Customer;
import com.Astroview.Chatbox_4.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    private final Map<String, String> otpCache = new ConcurrentHashMap<>();

    @GetMapping("/hello")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("Hii");
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestParam String mobileNo) {
        String otp = otpService.sendOtp(mobileNo);
        otpCache.put(mobileNo, otp);
        return ResponseEntity.ok("OTP sent successfully!");
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateOtp(@RequestParam String mobileNo, @RequestParam String otp) {
        String generatedOtp = otpCache.get(mobileNo);
        if (otp.equals(generatedOtp))
        {
            return new ResponseEntity<>("Valid OTP", HttpStatus.OK);
        }
        return new ResponseEntity<>("InValid OTP", HttpStatus.BAD_REQUEST);


    }
}
