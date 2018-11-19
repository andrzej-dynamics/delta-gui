package com.dynamics.andrzej.delta.gui.tdd;

import lombok.Getter;

public class Train {

    @Getter
    private final int priceForKilometer;

    @Getter
    private final int distance;

    public Train(int priceForKilometer, int distance) {
        this.priceForKilometer = priceForKilometer;
        this.distance = distance;
    }

    public int goToAnotherStation(int peopleOnTheBoard) {
        return peopleOnTheBoard * priceForKilometer * distance;
    }
}
