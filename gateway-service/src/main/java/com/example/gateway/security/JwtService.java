package com.example.gateway.security;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY =
            "X9aB7cQmP4tR2vL8wZ6yN0kD3fH5jG1uE7oS4nM2bV9rT8qC5xJ";

    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return extractAllClaims(token)
                .get("role", String.class);
    }

    public boolean isValid(String token) {
        try {
            Date expiry = extractAllClaims(token).getExpiration();
            return expiry.after(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}