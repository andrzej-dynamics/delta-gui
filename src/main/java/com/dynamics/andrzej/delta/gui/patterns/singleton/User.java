package com.dynamics.andrzej.delta.gui.patterns.singleton;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class User {
    @Getter
    private final String mailAddress;
    @Getter
    private final String passwordHash;

    private final List<Message> messages;

    public User(String mailAddress, String passwordHash) {
        this.mailAddress = mailAddress;
        this.passwordHash = passwordHash;
        messages = new ArrayList<>();
    }

    public void newMessage(Message message) {
        messages.add(message);
    }
}
