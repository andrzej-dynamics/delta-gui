package com.dynamics.andrzej.delta.gui.patterns.singleton;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MailBox {
    private final Set<User> users;
    private final Map<String, User> loggedUsers;
    private final ConcurrentHashMap<String, List<IMailClientObserver>> mailClientObservers;

    private MailBox() {
        final Sha256PasswordHash passwordHash = Sha256PasswordHash.getInstance();
        final User adam = new User("adam@gmail.com", passwordHash.encode("adam"));
        final User jan = new User("jan@gmail.com", passwordHash.encode("jan"));
        users = Stream.of(adam, jan).collect(Collectors.toSet());
        loggedUsers = new HashMap<>();
        mailClientObservers = new ConcurrentHashMap<>();
    }

    public static MailBox getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public synchronized String login(String address, String password) {
        final User userToLogin = users.stream()
                .filter(user -> user.getMailAddress().equals(address))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("address not found: " + address));
        final Sha256PasswordHash passwordHash = Sha256PasswordHash.getInstance();
        final String hashedPassword = passwordHash.encode(password);

        if (!userToLogin.getPasswordHash().equals(hashedPassword)) {
            throw new IllegalArgumentException("invalid password for: " + address);
        }
        final String token = passwordHash.encode(address + String.valueOf(new Timestamp(new Date().getTime())) + Math.random() * 100);
        loggedUsers.put(token, userToLogin);
        return token;
    }

    public synchronized void sendMessage(String token, Message message) {
        final User user = loggedUsers.get(token);
        if (user == null) {
            throw new IllegalArgumentException("user not found!");
        }
        message.setFrom(user.getMailAddress());
        System.out.println(String.format("sending message: from: %s, %s", user.getMailAddress(), message));
        users.stream()
                .filter(userToFind -> userToFind.getMailAddress().equals(message.getTo()))
                .findAny()
                .ifPresent(foundUser -> {
                    loggedUsers.entrySet().stream()
                            .filter(entry -> entry.getValue() == foundUser)
                            .findFirst()
                            .ifPresent(foundUserEntry -> {
                                mailClientObservers.get(foundUserEntry.getKey())
                                        .forEach(observer -> observer.receiveMessage(message));
                            });
                });
        ;
        user.newMessage(message);
        final List<IMailClientObserver> mailClientObservers = this.mailClientObservers.get(token);
        if (mailClientObservers != null) {
            mailClientObservers.forEach(mailClientObserver -> mailClientObserver.receiveMessage(message));
        }
    }

    public synchronized void registerMaliClient(String userToken, IMailClientObserver mailClientObserver) {
        mailClientObservers.computeIfAbsent(userToken, k -> new ArrayList<>());
        mailClientObservers.get(userToken).add(mailClientObserver);
    }

    private static class InstanceHolder {
        static final MailBox INSTANCE = new MailBox();
    }
}
