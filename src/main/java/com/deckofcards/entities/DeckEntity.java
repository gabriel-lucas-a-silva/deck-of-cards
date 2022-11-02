package com.deckofcards.entities;

import com.deckofcards.adapter.gateway.dto.CardResponse;
import com.deckofcards.adapter.http.dto.DeckResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "DECK")
public class DeckEntity {
    @Id private String deckId;

    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CardEntity> cards;

    public static DeckResponseDTO toResponse(DeckEntity deck) {
        return DeckResponseDTO.builder()
                .deckId(deck.getDeckId())
                .cards(deck.getCards()
                        .stream()
                        .map(card ->
                                CardResponse.builder()
                                        .code(card.getCode())
                                        .image(card.getImage())
                                        .value(card.getValue())
                                        .suit(card.getSuit().name())
                                        .build()
                        ).collect(Collectors.toList())
                )
                .build();
    }
}
