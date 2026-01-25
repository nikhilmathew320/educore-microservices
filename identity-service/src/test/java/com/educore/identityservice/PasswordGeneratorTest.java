package com.educore.identityservice;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGeneratorTest {

    @Test
    public void generateBcryptHash() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "Admin@123";
        String hash = encoder.encode(rawPassword);
        System.out.println("-----------------------------------------");
        System.out.println("🔑 RAW PASSWORD: " + rawPassword);
        System.out.println("🔒 BCRYPT HASH:  " + hash);
        System.out.println("-----------------------------------------");
    }
}
