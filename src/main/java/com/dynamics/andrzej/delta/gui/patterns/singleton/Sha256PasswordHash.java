package com.dynamics.andrzej.delta.gui.patterns.singleton;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Sha256PasswordHash {
    private final MessageDigest messageDigest;

    private Sha256PasswordHash() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("cannot get algorithm 256");
        }
    }

    public static Sha256PasswordHash getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public String encode(String rawPassword) {
        return Arrays.toString(messageDigest.digest(rawPassword.getBytes(StandardCharsets.UTF_8)));
    }

    private static class InstanceHolder {
        static final Sha256PasswordHash INSTANCE = new Sha256PasswordHash();

    }

}
