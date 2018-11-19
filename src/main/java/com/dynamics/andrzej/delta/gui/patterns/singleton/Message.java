package com.dynamics.andrzej.delta.gui.patterns.singleton;

import lombok.*;

@RequiredArgsConstructor
@ToString
@Getter
public class Message {
    private final String to;
    private final String subject;
    private final String text;

    @Setter
    private String from;
}
