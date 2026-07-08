package com.cognizant.spring_learn.util;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.security.Keys;

public class JwtUtil {

    private static final Key key =
            Keys.secretKeyFor(
                    SignatureAlgorithm.HS256);

    public static String generateToken(
            String username) {

        return Jwts.builder()

                .setSubject(username)

                .setIssuedAt(
                        new Date())

                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1200000))

                .signWith(key)

                .compact();

    }

}