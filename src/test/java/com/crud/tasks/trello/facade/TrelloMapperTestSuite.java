package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void shouldMapTrelloListDtoToTrelloList() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1", "sample name", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "sample name", false);
        List<TrelloListDto> trelloListDtos = List.of(trelloListDto, trelloListDto2);

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToTrelloList(trelloListDtos);

        //Then
        assertEquals(2, trelloLists.size());
    }

    @Test
    void shouldMapTrelloBoardDtoToTrelloBoard() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1", "sample name", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "sample name", false);
        List<TrelloListDto> trelloListDtos = List.of(trelloListDto, trelloListDto2);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "sample name", trelloListDtos);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("1", "sample name", trelloListDtos);
        List<TrelloBoardDto> trelloBoardDtos = List.of(trelloBoardDto, trelloBoardDto2);

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        assertEquals(2, trelloBoards.size());
    }

    @Test
    void shouldMapTrelloListToTrelloListDto() {
        //Given
        TrelloList trelloList = new TrelloList("1", "sample name", false);
        TrelloList trelloList2 = new TrelloList("1", "sample name", false);
        List<TrelloList> trelloLists = List.of(trelloList, trelloList2);

        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(2, trelloListDtos.size());
    }

    @Test
    void shouldMapTrelloBoardToTrelloBoardDto() {
        //Given
        TrelloList trelloList = new TrelloList("1", "sample name", false);
        TrelloList trelloList2 = new TrelloList("1", "sample name", false);
        List<TrelloList> trelloLists = List.of(trelloList, trelloList2);
        TrelloBoard trelloBoard = new TrelloBoard("1", "sample name", trelloLists);
        TrelloBoard trelloBoard2 = new TrelloBoard("1", "sample name", trelloLists);
        List<TrelloBoard> trelloBoards = List.of(trelloBoard, trelloBoard2);

        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals(2, trelloBoardDtos.size());
    }

    @Test
    void shouldMapTrelloCardDtoToTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("sample name", "sample desc", "sample pos", "sample list id");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("sample name", trelloCard.getName());
        assertEquals("sample desc", trelloCard.getDescription());
        assertEquals("sample pos", trelloCard.getPos());
        assertEquals("sample list id", trelloCard.getListId());
    }

    @Test
    void shouldMapTrelloCardToTrelloCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("sample name", "sample desc", "sample pos", "sample list id");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("sample name", trelloCardDto.getName());
        assertEquals("sample desc", trelloCardDto.getDescription());
        assertEquals("sample pos", trelloCardDto.getPos());
        assertEquals("sample list id", trelloCardDto.getListId());
    }
}
