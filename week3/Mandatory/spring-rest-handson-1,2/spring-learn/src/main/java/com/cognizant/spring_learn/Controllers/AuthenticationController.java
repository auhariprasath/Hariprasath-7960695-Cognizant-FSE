package com.cognizant.spring_learn.Controller;

import java.util.Base64;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.model.AuthenticationResponse;
import com.cognizant.spring_learn.util.JwtUtil;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate(

            @RequestHeader("Authorization")
            String authHeader) {

        String encoded =
                authHeader.substring(6);

        String credentials =
                new String(
                        Base64.getDecoder()
                                .decode(encoded));

        String username =
                credentials.split(":")[0];

        String token =
                JwtUtil.generateToken(
                        username);

        return new AuthenticationResponse(
                token);

    }
}
