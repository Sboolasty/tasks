package com.crud.tasks.service;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.client.TrelloClient;
import com.crud.tasks.trello.config.AdminConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
class TrelloServiceTest {

    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleEmailService emailService;

    @Mock
    private AdminConfig adminConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        trelloService = new TrelloService(trelloClient, emailService, adminConfig);
    }

    @Test
    void fetchTrelloBoards_ShouldReturnListOfTrelloBoards() {
        // Arrange
        List<TrelloBoardDto> boards = new ArrayList<>();
        List<TrelloListDto> lists1 = new ArrayList<>();
        lists1.add(new TrelloListDto("list1", "List 1",true));
        lists1.add(new TrelloListDto("list2", "List 2",true));
        boards.add(new TrelloBoardDto("board1", "Board 1", lists1));

        List<TrelloListDto> lists2 = new ArrayList<>();
        lists2.add(new TrelloListDto("list3", "List 3",true));
        boards.add(new TrelloBoardDto("board2", "Board 2", lists2));

        when(trelloClient.getTrelloBoards()).thenReturn(boards);

        // Act
        List<TrelloBoardDto> result = trelloService.fetchTrelloBoards();

        // Assert
        assertEquals(boards, result);
        verify(trelloClient, times(1)).getTrelloBoards();
    }

    @Test
    void createTrelloCard_ShouldReturnCreatedTrelloCard() {
        // Arrange
        TrelloCardDto trelloCardDto = new TrelloCardDto("Card 1", "Description", "List 1", "1");
        CreatedTrelloCardDto createdCard = new CreatedTrelloCardDto("123", "Card 1", "URL", null);

        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdCard);

        // Act
        CreatedTrelloCardDto result = trelloService.createTrelloCard(trelloCardDto);

        // Assert
        assertEquals(createdCard.getId(), result.getId());
        assertEquals(createdCard.getName(), result.getName());
        assertEquals(createdCard.getShortUrl(), result.getShortUrl());
        assertEquals(createdCard.getBadges(), result.getBadges());
        verify(trelloClient, times(1)).createNewCard(trelloCardDto);
    }

/*    @Test
    void createTrelloCard_ShouldSendEmail() {
        // Arrange
        TrelloCardDto trelloCardDto = new TrelloCardDto("Card 1", "Description", "List 1", "1");
        CreatedTrelloCardDto createdCard = new CreatedTrelloCardDto("123", "Card 1", "URL", null);

        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdCard);

        // Act
        trelloService.createTrelloCard(trelloCardDto);

        // Assert
        verify(emailService, times(1)).send(argThat(mail ->
                mail.getSubject().equals(TrelloService.SUBJECT) &&
                        mail.getBody().equals("New card: " + trelloCardDto.getName() + " has been created on your Trello account") &&
                        mail.getRecipient().equals(adminConfig.getAdminMail())
        ));
    }
*/
}