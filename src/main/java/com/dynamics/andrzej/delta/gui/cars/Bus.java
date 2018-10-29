package com.dynamics.andrzej.delta.gui.cars;

import lombok.Getter;
import lombok.Setter;

public class Bus extends Vehicle {

    @Getter
    private final int capacity;

    @Getter
    private final String name;

    @Setter
    @Getter
    private int ticketPrice;

    public Bus(int fuelConsumption, int capacity, String name) {
        super(fuelConsumption);
        this.capacity = capacity;
        this.name = name;
    }

    public int calcIncome(int numOfPassengers) {
        return 0;
    }
}
