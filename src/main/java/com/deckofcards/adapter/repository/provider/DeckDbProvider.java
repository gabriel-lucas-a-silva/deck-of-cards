package com.deckofcards.adapter.repository.provider;

import com.deckofcards.adapter.repository.h2db.DeckRepositoryH2Db;
import com.deckofcards.entities.DeckEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DeckDbProvider {
    private final DeckRepositoryH2Db deckRepositoryH2Db;

    public DeckEntity save(final DeckEntity deck) {
        log.info("Saving deck in database. deck id: [{}]", deck.getDeckId());
        final var savedDeck = deckRepositoryH2Db.save(deck);

        log.info("Deck was saved in the database with success. deck id: [{}]", savedDeck.getDeckId());
        return savedDeck;
    }
}
