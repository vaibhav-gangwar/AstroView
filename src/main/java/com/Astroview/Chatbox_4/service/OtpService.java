package com.Astroview.Chatbox_4.service;

import com.Astroview.Chatbox_4.entity.Customer;
import com.Astroview.Chatbox_4.entity.RestResponse;
import com.Astroview.Chatbox_4.repository.CustomerRepository;
import com.Astroview.Chatbox_4.repository.RestResponseRepository;
import com.Astroview.Chatbox_4.util.OtpGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class OtpService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestResponseRepository restResponseRepository;

    @Autowired
    private OtpGenerator otpGenerator;

    private final String API_URL = "https://msgn.mtalkz.com/api";

    public String sendOtp(String mobileNo) {
        String otp = otpGenerator.generateOtp();
        String message = "Your OTP- One Time Password is {" + otp +
                "} to authenticate your login with {" + otp + "}\n\nPowered By mTalkz";

        Map<String, String> request = Map.of(
                "apikey", "JYx3tnGVQSmz4nrP",
                "senderid", "MTAMOI",
                "number", mobileNo,
                "message", message,
                "format", "json"
        );

        ResponseEntity<Map> response = restTemplate.postForEntity(API_URL, request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            // Save response in DB
            Map data = (Map) ((List) response.getBody().get("data")).get(0);
            RestResponse restResponse = new RestResponse();
            restResponse.setId(data.get("id").toString());
            restResponse.setMobile(data.get("mobile").toString());
            restResponse.setStatus(data.get("status").toString());
            restResponse.setMsgId(response.getBody().get("msgid").toString());
            restResponse.setMessage(response.getBody().get("message").toString());
            restResponseRepository.save(restResponse);
        }
        return otp;
    }
}