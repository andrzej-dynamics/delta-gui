package com.dynamics.andrzej.delta.gui.cars;

import lombok.Getter;
import lombok.Setter;

public class Vehicle {

    @Getter
    private final float fuelConsumption;

    @Getter
    private int distanceTravelled;

    @Getter
    private float fuel;

    public Vehicle(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    //metoda tankująca samochod
    public void tank(int fuel){
        this.fuel += fuel;
    }

    public void go(int distance) {
        distanceTravelled += distance;
        fuel -= (distance / 100f * fuelConsumption);
    }
}
