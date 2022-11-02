package com.deckofcards.adapter.gateway.dto;

import com.deckofcards.adapter.gateway.dto.cards.CardResponse;
import com.deckofcards.entities.CardEntity;
import com.deckofcards.entities.DeckEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DeckResponse {
    private String deckId;
    private List<CardResponse> cards;

    public static DeckEntity toEntity(final DeckResponse deck) {
        return DeckEntity.builder()
                .id(deck.getDeckId())
                .build();
    }

    public static DeckEntity toEntity(final DeckEntity deck, final List<CardEntity> cards) {
        return DeckEntity.builder()
                .id(deck.getId())
                .cards(cards)
                .build();
    }
}
