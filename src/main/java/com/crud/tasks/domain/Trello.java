package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

@Setter
public class Trello {
    @JsonProperty("board")
    private int board;
    @JsonProperty("card")
    private int card;
}