package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.service.TrelloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/trello")
public class TrelloController {

    private final TrelloService trelloService;

    public TrelloController(TrelloService trelloService) {
        this.trelloService = trelloService;
    }

    @GetMapping("/boards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloService.getTrelloBoards();
    }

    @PostMapping("/cards")
    public CreatedTrelloCard createAndAddCardToBoard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloService.createNewCard(trelloCardDto);
    }
}
