package com.deckofcards.usecases;

import com.deckofcards.adapter.http.dto.request.PlayerRequestDTO;
import com.deckofcards.adapter.http.dto.response.WinnerPlayerResponseDTO;
import com.deckofcards.entities.enums.Points;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@AllArgsConstructor
public class GetWinner {


    public WinnerPlayerResponseDTO execute(final List<PlayerRequestDTO> players) {
        var playersPoints = new HashMap<String, Integer>();

        players.forEach(player -> {
            AtomicInteger sum = new AtomicInteger();
            player.getCards().forEach(card ->{
                var points = 0;

                try {
                    points += Integer.parseInt(card);
                } catch (Exception e) {
                    points += Points.valueOf(card).getPoint();
                }

                sum.addAndGet(points);
            });

            playersPoints.put(player.getName(), sum.get());
        });

        String winner = getPlayerWithHighestPoints(playersPoints);
        int points = playersPoints.get(winner);
        return new WinnerPlayerResponseDTO(winner, points);
    }

    private <K, V extends Comparable<V>> K getPlayerWithHighestPoints(HashMap<K, V> playersPoints) {
        Optional<Map.Entry<K, V>> winner = playersPoints.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        return winner.map(Map.Entry::getKey).orElse(null);
    }
}
