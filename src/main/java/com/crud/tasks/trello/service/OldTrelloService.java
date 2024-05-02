package com.crud.tasks.trello.service;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OldTrelloService {

    private final TrelloClient trelloClient;

    public OldTrelloService(TrelloClient trelloClient) {
        this.trelloClient = trelloClient;
    }

    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCard createNewCard(TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }
}
