package com.dynamics.andrzej.delta.gui.patterns.singleton;

public class SendingMailsClient {
    private final String userToken;

    public SendingMailsClient(String address, String password) {
        userToken = MailBox.getInstance().login(address, password);
    }

    public void sendMessage(String address, String subject, String text) {
        final Message message = new Message(address, subject, text);
        MailBox.getInstance().sendMessage(userToken, message);
    }
}
