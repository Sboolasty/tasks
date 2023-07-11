package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrelloMapperTest {

    private final TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void testMapToList() {
        // Given
        TrelloListDto listDto1 = new TrelloListDto("1", "List 1", false);
        TrelloListDto listDto2 = new TrelloListDto("2", "List 2", true);
        List<TrelloListDto> listDtos = Arrays.asList(listDto1, listDto2);

        // When
        List<TrelloList> lists = trelloMapper.mapToList(listDtos);

        // Then
        assertTrue(lists != null);
        assertTrue(lists.size() == 2);
        assertTrue(lists.get(0).getId().equals("1"));
        assertTrue(lists.get(0).getName().equals("List 1"));
        assertTrue(!lists.get(0).isClosed());
        assertTrue(lists.get(1).getId().equals("2"));
        assertTrue(lists.get(1).getName().equals("List 2"));
        assertTrue(lists.get(1).isClosed());
    }

    @Test
    public void testMapToListDto() {
        // Given
        TrelloList list1 = new TrelloList("1", "List 1", false);
        TrelloList list2 = new TrelloList("2", "List 2", true);
        List<TrelloList> lists = Arrays.asList(list1, list2);

        // When
        List<TrelloListDto> listDtos = trelloMapper.mapToListDto(lists);

        // Then
        assertTrue(listDtos != null);
        assertTrue(listDtos.size() == 2);
        assertTrue(listDtos.get(0).getId().equals("1"));
        assertTrue(listDtos.get(0).getName().equals("List 1"));
        assertTrue(!listDtos.get(0).isClosed());
        assertTrue(listDtos.get(1).getId().equals("2"));
        assertTrue(listDtos.get(1).getName().equals("List 2"));
        assertTrue(listDtos.get(1).isClosed());
    }

    @Test
    public void testMapToCardDto() {
        // Given
        TrelloCard card = new TrelloCard("Card 1", "Description 1", "1.0", "1");

        // When
        TrelloCardDto cardDto = trelloMapper.mapToCardDto(card);

        // Then
        assertTrue(cardDto != null);
        assertTrue(cardDto.getName().equals("Card 1"));
        assertTrue(cardDto.getDescription().equals("Description 1"));
        assertTrue(cardDto.getPos() == "1.0");
        assertTrue(cardDto.getListId().equals("1"));
    }

    @Test
    public void testMapToCard() {
        // Given
        TrelloCardDto cardDto = new TrelloCardDto("Card 1", "Description 1", "1.0", "1");

        // When
        TrelloCard card = trelloMapper.mapToCard(cardDto);

        // Then
        assertTrue(card != null);
        assertTrue(card.getName().equals("Card 1"));
        assertTrue(card.getDescription().equals("Description 1"));
        assertTrue(card.getPos() == "1.0");
        assertTrue(card.getListId().equals("1"));
    }
}
