package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
    private Optional<String> cc;

    public boolean hasCc() {
        return cc.isPresent();
    }
}