package com.deckofcards.usecases;

import com.deckofcards.adapter.gateway.DeckClientProvider;
import com.deckofcards.adapter.http.dto.response.DeckResponseDTO;
import com.deckofcards.adapter.repository.provider.DeckDbProvider;
import com.deckofcards.entities.DeckEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateNewDeck {
    private final DeckClientProvider deckClientProvider;
    private final DeckDbProvider deckDbProvider;

    public DeckResponseDTO execute() {
        final var deck = deckClientProvider.createDeck();
        final var deckWithItsCards = deckClientProvider.drawCards(deck);
        final var savedDeck = deckDbProvider.save(deckWithItsCards);
        return DeckEntity.toResponse(savedDeck);
    }
}
