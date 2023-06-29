package com.crud.tasks.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
    private String cc;
}