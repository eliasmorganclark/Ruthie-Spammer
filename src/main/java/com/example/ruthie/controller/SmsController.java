package com.example.ruthie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.util.Arrays;

@RestController
public class SmsController {

    private String TWILIO_ACCOUNT_SID;
    private String TWILIO_AUTH_TOKEN;

    @Autowired
    public SmsController(@Value("${twilio.account.sid}") String twilioAccountSid, @Value("${twilio.auth.token}") String twilioAuthToken) {
        this.TWILIO_ACCOUNT_SID = twilioAccountSid;
        this.TWILIO_AUTH_TOKEN = twilioAuthToken;
    }

    @GetMapping(value = "/sendSMS")
    public ResponseEntity<String> sendSMS() {

        Twilio.init(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);

        Message.creator(new PhoneNumber("+13304729951"),
                new PhoneNumber("+19183934179"), "Ruthie Time!")
                .setMediaUrl(
                        Arrays.asList(URI.create("https://raw.githubusercontent.com/dianephan/flask_upload_photos/main/UPLOADS/DRAW_THE_OWL_MEME.png")))
                .create();


        // need to have a list of image URLS and get one at random

        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }



}