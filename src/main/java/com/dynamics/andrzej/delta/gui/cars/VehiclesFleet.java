package com.dynamics.andrzej.delta.gui.cars;

import java.util.Collection;

public interface VehiclesFleet {
    /**
     * liczy ile dany samochód wygenerował zysku dla firmy
     * @param vehicles
     * @return suma zysków samochodu
     */
    int calcComparison(Collection<Vehicle> vehicles);

    void buyVehicle(Vehicle vehicle);

    void sellVehicle(Vehicle vehicle);

}
