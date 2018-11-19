package com.dynamics.andrzej.delta.gui.patterns.singleton;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MailBoxTest {

    @Test
    void test() {
        final SendingMailsClient adamClient = new SendingMailsClient("adam@gmail.com", "adam");
        final ObservingMessagesClient janClient = new ObservingMessagesClient("jan@gmail.com", "jan");
        adamClient.sendMessage("jan@gmail.com", "test", "test text");
    }

}