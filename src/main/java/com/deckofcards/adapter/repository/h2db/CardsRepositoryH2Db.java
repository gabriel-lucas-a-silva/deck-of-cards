package com.deckofcards.adapter.repository.h2db;

import com.deckofcards.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepositoryH2Db extends JpaRepository<CardEntity, Long> {
    List<CardEntity> findCardEntityByDeckId(final String deckId);
}
