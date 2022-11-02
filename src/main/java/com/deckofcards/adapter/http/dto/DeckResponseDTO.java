package com.deckofcards.adapter.http.dto;

import com.deckofcards.adapter.gateway.dto.CardResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeckResponseDTO {
    private String deckId;
    private List<CardResponse> cards;
}
