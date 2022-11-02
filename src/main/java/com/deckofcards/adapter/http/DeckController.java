package com.deckofcards.adapter.http;

import com.deckofcards.adapter.http.dto.DeckResponseDTO;
import com.deckofcards.usecases.CreateNewDeck;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/v1/api/deck")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DeckController {
    private final CreateNewDeck createNewDeck;

    @GetMapping(path = "/create")
    public ResponseEntity<DeckResponseDTO> createDeck() {
        log.info("INIT createDeck.");
        final var createdDeck = createNewDeck.execute();

        log.info("SUCCESS createDeck. created deck: {}", createdDeck);
        return ResponseEntity.status(CREATED).body(createdDeck);
    }
}
