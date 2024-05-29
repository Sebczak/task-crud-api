package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrelloMapper {

    public TrelloBoard mapToBoard(TrelloBoardDto trelloBoardDto) {
        return new TrelloBoard(
                trelloBoardDto.getId(),
                trelloBoardDto.getName(),
                mapToTrelloList(trelloBoardDto.getLists())
        );
    }

    public List<TrelloList> mapToTrelloList(List<TrelloListDto> lists) {
        return lists.stream()
                .map(list -> new TrelloList(list.getId(), list.getName(), list.isClosed()))
                .toList();
    }

    public List<TrelloBoard> mapToBoards(List<TrelloBoardDto> trelloBoardDto) {
        return trelloBoardDto.stream()
                .map(this::mapToBoard)
                .toList();
    }

    public List<TrelloBoardDto> mapToBoardsDto(final List<TrelloBoard> trelloBoards) {
        return trelloBoards.stream()
                .map(board -> new TrelloBoardDto(board.getId(), board.getName(), mapToListDto(board.getLists())))
                .toList();
    }

    public List<TrelloListDto> mapToListDto(final List<TrelloList> trelloLists) {
        return trelloLists.stream()
                .map(trelloList -> new TrelloListDto(trelloList.getId(), trelloList.getName(), trelloList.isClosed()))
                .toList();
    }

    public TrelloCardDto mapToCardDto(final TrelloCard trelloCard) {
        return new TrelloCardDto(
                trelloCard.getName(),
                trelloCard.getDescription(),
                trelloCard.getPos(),
                trelloCard.getListId()
        );
    }

    public TrelloCard mapToCard(final TrelloCardDto trelloCardDto) {
        return new TrelloCard(
                trelloCardDto.getName(),
                trelloCardDto.getDescription(),
                trelloCardDto.getPos(),
                trelloCardDto.getListId()
        );
    }
}
