package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class JwtUtil {

    public JwtUtil() {
    }

    // =========================
    // TOKEN GENERATION
    // =========================
    public String generateToken(Long userId, String email, String role) {

        // Format: userId:email:role
        String raw = userId + ":" + email + ":" + role;

        return Base64.getEncoder().encodeToString(raw.getBytes());
    }

    // =========================
    // TOKEN VALIDATION
    // =========================
    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // =========================
    // INTERNAL DECODER
    // =========================
    private String[] decode(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split(":");
    }

    // =========================
    // CLAIM EXTRACTION
    // =========================
    public String getEmailFromToken(String token) {
        return decode(token)[1];
    }

    public String getRoleFromToken(String token) {
        return decode(token)[2];
    }

    public Long getUserIdFromToken(String token) {
        return Long.parseLong(decode(token)[0]);
    }
}
