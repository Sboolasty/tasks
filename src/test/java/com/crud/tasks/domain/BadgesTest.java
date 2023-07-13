package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BadgesTest {
    private Badges badges;

    @BeforeEach
    public void setup() {
        badges = new Badges();
    }

    @Test
    public void testVotes() {
        // Ustawienie wartości i pobranie Votes
        int expectedVotes = 10;
        badges.setVotes(expectedVotes);
        int actualVotes = badges.getVotes();

        Assertions.assertEquals(expectedVotes, actualVotes);
    }

    @Test
    public void testAttachmentsByType() {
        // Ustawienie wartości i pobranie attachmentsByType
        AttachmentByType expectedAttachments = new AttachmentByType();
        badges.setAttachments(expectedAttachments);
        AttachmentByType actualAttachments = badges.getAttachments();

        Assertions.assertEquals(expectedAttachments, actualAttachments);
    }
}