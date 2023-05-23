package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/trello")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TrelloController {

    private final TrelloClient trelloClient;

    public TrelloController(TrelloClient trelloClient) {
        this.trelloClient = trelloClient;
    }

    @GetMapping("boards")
    public void getTrelloBoards() {
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        List<TrelloBoardDto> filteredBoards = trelloBoards.stream()
                .filter(this::boardContainsIdAndName)
                .filter(this::boardContainsKodilla)
                .collect(Collectors.toList());

        filteredBoards.forEach(trelloBoardDto -> {
            System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
        });
    }

    private boolean boardContainsIdAndName(TrelloBoardDto board) {
        return board.getId() != null && board.getName() != null;
    }

    private boolean boardContainsKodilla(TrelloBoardDto board) {
        return board.getName().contains("Kodilla");
    }
}