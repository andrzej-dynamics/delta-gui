package com.dynamics.andrzej.delta.gui.cars;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class VehicleTest {

    @Test
    public void testTank() {
        final Vehicle vehicle = new Vehicle(5.2f);
        Assert.assertEquals(vehicle.getFuelConsumption(), 5.2f);
        Assert.assertEquals(vehicle.getFuel(), 0.0f);
        Assert.assertEquals(vehicle.getDistanceTravelled(), 0);

        vehicle.tank(10);
        Assert.assertEquals(vehicle.getFuel(), 10.0f);
        Assert.assertEquals(vehicle.getFuelConsumption(), 5.2f);
        Assert.assertEquals(vehicle.getDistanceTravelled(), 0);
    }

    @Test
    public void testGo() {
        final Vehicle vehicle = new Vehicle(4.3f);
        Assert.assertEquals(vehicle.getFuelConsumption(), 4.3f);
        Assert.assertEquals(vehicle.getFuel(), 0.0f);
        Assert.assertEquals(vehicle.getDistanceTravelled(), 0);

        vehicle.tank(10);
        Assert.assertEquals(vehicle.getFuel(), 10.0f);

        int distance = 5 + (int) (Math.random() * 100);
        vehicle.go(distance);
        Assert.assertEquals(vehicle.getFuel(), 10 - (distance / 100f * 4.3f));
        Assert.assertEquals(vehicle.getDistanceTravelled(), distance);
    }
}