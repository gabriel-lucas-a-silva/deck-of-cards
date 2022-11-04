package com.deckofcards.entities;

import com.deckofcards.adapter.gateway.dto.cards.CardResponse;
import com.deckofcards.adapter.http.dto.response.DeckResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "DECK")
public class DeckEntity {
    @Id private String id;

    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CardEntity> cards;

    public static DeckResponseDTO toResponse(DeckEntity deck) {
        return DeckResponseDTO.builder()
                .deckId(deck.getId())
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
