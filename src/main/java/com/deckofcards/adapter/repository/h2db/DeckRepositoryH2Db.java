package com.deckofcards.adapter.repository.h2db;

import com.deckofcards.entities.DeckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepositoryH2Db extends JpaRepository<DeckEntity, Long> {
}
