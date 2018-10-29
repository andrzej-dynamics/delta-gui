package com.dynamics.andrzej.delta.gui.cars;

import java.util.Collection;

public class TrafiCar implements VehiclesFleet {
    @Override
    public int calcComparison(Collection<Vehicle> vehicles) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void buyVehicle(Vehicle vehicle) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sellVehicle(Vehicle vehicle) {
        throw new UnsupportedOperationException();
    }

    public Vehicle rent(Vehicle vehicle) {
        return null;
    }

    public int takeBack(Vehicle vehicle) {
        return 0;
    }
}
