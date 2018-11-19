package com.dynamics.andrzej.delta.gui.tdd;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TrainTest {

    @DataProvider(name = "toTrainTest")
    public static Object[][] setDataProvider() {
        return new Object[][]{
                new Object[]{1, 100, 10, 100 * 10},
                new Object[]{15, 10, 15, 15 * 10 * 15}
        };
    }

    @Test(dataProvider = "toTrainTest")
    public void testGoToAnotherStation(int priceForKilometer, int distance, int peoplesOnTheBoard, int result) {
        Train toTest = new Train(priceForKilometer, distance);
        assertEquals(toTest.goToAnotherStation(peoplesOnTheBoard), result);
    }

    @Test(invocationCount = 100)
    public void testTrain() {
        final int distance = 2;
        final int priceForKilometer = 10;
        final int numOfPeople = (int) Math.round(Math.random() * 100);
        final Train toTest = new Train(priceForKilometer, distance);
        final int result = toTest.goToAnotherStation(numOfPeople);
        assertEquals(result / (distance * priceForKilometer), numOfPeople);
    }
}