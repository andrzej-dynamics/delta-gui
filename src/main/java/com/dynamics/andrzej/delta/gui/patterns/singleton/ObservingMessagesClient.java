package com.dynamics.andrzej.delta.gui.patterns.singleton;

public class ObservingMessagesClient implements IMailClientObserver {
    private final String userToken;

    public ObservingMessagesClient(String address, String password) {
        final MailBox mailBox = MailBox.getInstance();
        userToken = mailBox.login(address, password);
        mailBox.registerMaliClient(userToken, this);
    }

    @Override
    public void receiveMessage(Message message) {
        System.out.println("Got message: " + message);
    }
}
