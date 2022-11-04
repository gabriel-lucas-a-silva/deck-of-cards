package com.deckofcards.entities.enums;

public enum Points {
    ACE(1),
    KINGS(13),
    QUEEN(12),
    JACK(11);

    private final int point;

    Points(final int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
}
