package com.crud.tasks.trello.service;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrelloService {

    private final TrelloClient trelloClient;

    public TrelloService(TrelloClient trelloClient) {
        this.trelloClient = trelloClient;
    }

    public List<TrelloBoardDto> getTrelloBoards() {
        List<TrelloBoardDto> boards = trelloClient.getTrelloBoards();

        List<TrelloBoardDto> filteredBoards = boards.stream()
                .filter(board -> board.getName().contains("Kodilla"))
                .toList();

        System.out.println(filteredBoards);

        return boards;
    }

    public CreatedTrelloCard createNewCard(TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }
}
