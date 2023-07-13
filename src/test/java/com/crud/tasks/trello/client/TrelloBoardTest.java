package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloBoardTest {
    private TrelloBoard trelloBoard;

    @BeforeEach
    public void setup() {
        // Przygotowanie danych testowych
        String id = "board123";
        String name = "Test Board";
        List<TrelloList> lists = new ArrayList<>();

        trelloBoard = new TrelloBoard(id, name, lists);
    }

    @Test
    public void testGetId() {
        // Sprawdzenie poprawności pobrania ID
        String expectedId = "board123";
        String actualId = trelloBoard.getId();

        Assertions.assertEquals(expectedId, actualId);
    }

    @Test
    public void testGetName() {
        // Sprawdzenie poprawności pobrania nazwy
        String expectedName = "Test Board";
        String actualName = trelloBoard.getName();

        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetLists() {
        // Sprawdzenie poprawności pobrania list
        List<TrelloList> expectedLists = new ArrayList<>();
        List<TrelloList> actualLists = trelloBoard.getLists();

        Assertions.assertEquals(expectedLists, actualLists);
    }

    @Test
    public void testAllArgsConstructor() {
        // Sprawdzenie poprawności konstruktora z wszystkimi argumentami
        String id = "board456";
        String name = "Another Board";
        List<TrelloList> lists = new ArrayList<>();

        TrelloBoard trelloBoard = new TrelloBoard(id, name, lists);

        Assertions.assertEquals(id, trelloBoard.getId());
        Assertions.assertEquals(name, trelloBoard.getName());
        Assertions.assertEquals(lists, trelloBoard.getLists());
    }

    @Test
    public void testNoArgsConstructor() {
        // Sprawdzenie poprawności konstruktora bez argumentów
        TrelloBoard trelloBoard = new TrelloBoard();

        Assertions.assertNull(trelloBoard.getId());
        Assertions.assertNull(trelloBoard.getName());
        Assertions.assertNull(trelloBoard.getLists());
    }
}