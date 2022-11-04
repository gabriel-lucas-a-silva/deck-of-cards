package com.deckofcards.usecases;

import com.deckofcards.adapter.http.dto.response.PlayersResponseDTO;
import com.deckofcards.adapter.repository.provider.CardsDbProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class BuildHands {
    private final CardsDbProvider cardsDbProvider;

    public PlayersResponseDTO execute(final String deckId) {
        final var cards = cardsDbProvider.findCardsByDeckId(deckId);

        // shuffle cards


        log.info("Building players' hand.");
        var playersCards = new HashSet<String>();
        var players = new HashMap<String, Set<String>>();
        var playerNumber = 4;

        for (int i = 1; i <= cards.size(); i++) {
            final var card = cards.get(i - 1);

            if (i % 5 == 0) {
                players.put(String.format("Jogador %s", playerNumber), playersCards);
                log.info("Built player {}. hand: {}", playerNumber, playersCards);
                playersCards = new HashSet<>();
                playerNumber--;
            }

            playersCards.add(card.getValue());
        }

        log.info("Players' hands built. {}", players);
        return new PlayersResponseDTO(players);
    }
}
