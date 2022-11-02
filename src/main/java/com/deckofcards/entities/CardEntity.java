package com.deckofcards.entities;

import com.deckofcards.entities.enums.CardSuit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CARDS")
public class CardEntity {
    @Id private UUID id;
    private String code;
    private String image;
    @Column(name = "`VALUE`")
    private String value;
    private CardSuit suit;
    @ManyToOne @JoinColumn(name = "deck_id")
    private DeckEntity deck;
}
