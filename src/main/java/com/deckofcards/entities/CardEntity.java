package com.deckofcards.entities;

import com.deckofcards.entities.enums.CardSuit;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CARDS")
public class CardEntity {
    @Id
    private UUID id;

    private String code;

    private String image;

    @Column(name = "`VALUE`")
    private String value;

    @Enumerated
    private CardSuit suit;

    @JsonBackReference
    @ManyToOne @JoinColumn(name = "deck_id")
    private DeckEntity deck;
}
