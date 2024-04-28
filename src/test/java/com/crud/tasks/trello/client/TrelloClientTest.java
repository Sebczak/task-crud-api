package com.crud.tasks.trello.client;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.config.TrelloConfig;
import com.crud.tasks.trello.service.TrelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrelloClientTest {

    @InjectMocks
    private TrelloClient trelloClient;

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private TrelloConfig trelloConfig;

    @Test
    void shouldFetchTrelloBoards() throws URISyntaxException {
        // Given
        lenient().when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://test.com");
        lenient().when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        lenient().when(trelloConfig.getTrelloToken()).thenReturn("test");
        lenient().when(trelloConfig.getTrelloUsername()).thenReturn("test");

        TrelloBoardDto[] trelloBoards = new TrelloBoardDto[1];
        trelloBoards[0] = new TrelloBoardDto("test_id", "Kodilla", new ArrayList<>());

        URI uri = new URI("http://test.com/members/test/boards?key=test&token=test&fields=id,name&lists=all");

        lenient().when(restTemplate.getForObject(uri, TrelloBoardDto[].class)).thenReturn(trelloBoards);
        // When
        List<TrelloBoardDto> fetchedTrelloBoards = trelloClient.getTrelloBoards();
        // Then
        assertEquals(1, fetchedTrelloBoards.size());
        assertEquals("test_id", fetchedTrelloBoards.get(0).getId());
        assertEquals("Kodilla", fetchedTrelloBoards.get(0).getName());
        assertEquals(new ArrayList<>(), fetchedTrelloBoards.get(0).getLists());
    }

    @Test
    void shouldCreateCard() throws URISyntaxException {
        // Given
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://test.com");
        when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        when(trelloConfig.getTrelloToken()).thenReturn("test");
        TrelloCardDto trelloCardDto = new TrelloCardDto(
                "Test task",
                "Test Description",
                "top",
                "test_id"
        );
        URI uri = new URI("http://test.com/cards?key=test&token=test&name=Test%20task&desc=Test%20Description&pos=top&idList=test_id");

        CreatedTrelloCard createdTrelloCard = new CreatedTrelloCard(
                "1",
                "test task",
                "http://test.com"
        );

        when(restTemplate.postForObject(uri, null, CreatedTrelloCard.class)).thenReturn(createdTrelloCard);
        // When
        CreatedTrelloCard newCard = trelloClient.createNewCard(trelloCardDto);

        // Then
        assertEquals("1", newCard.getId());
        assertEquals("test task", newCard.getName());
        assertEquals("http://test.com", newCard.getShortUrl());
    }

    @Test
    void shouldReturnEmptyList() throws URISyntaxException {
        // Given
        lenient().when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://test.com");
        lenient().when(trelloConfig.getTrelloAppKey()).thenReturn("no test");
        lenient().when(trelloConfig.getTrelloToken()).thenReturn("no test");
        lenient().when(trelloConfig.getTrelloUsername()).thenReturn("no test");

        TrelloBoardDto[] trelloBoards = new TrelloBoardDto[1];
        trelloBoards[0] = new TrelloBoardDto("test_id", "Crud", new ArrayList<>());

        URI uri = new URI("http://test.com/members/test/boards?key=test&token=test&fields=id,name&lists=all");

        lenient().when(restTemplate.getForObject(uri, TrelloBoardDto[].class)).thenReturn(trelloBoards);
        // When
        List<TrelloBoardDto> fetchedTrelloBoards = trelloClient.getTrelloBoards();
        // Then
        assertEquals(0, fetchedTrelloBoards.size());
    }

}