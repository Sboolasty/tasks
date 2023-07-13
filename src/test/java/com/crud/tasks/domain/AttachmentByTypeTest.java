package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AttachmentByTypeTest {
    private AttachmentByType attachmentByType;

    @BeforeEach
    public void setup() {
        attachmentByType = new AttachmentByType();
    }

    @Test
    public void testTrello() {
        // Ustawienie wartości i pobranie Trello
        Trello expectedTrello = new Trello();
        attachmentByType.setTrello(expectedTrello);
        Trello actualTrello = attachmentByType.getTrello();

        Assertions.assertEquals(expectedTrello, actualTrello);
    }
}
