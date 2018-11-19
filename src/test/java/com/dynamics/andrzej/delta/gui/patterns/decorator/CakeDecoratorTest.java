package com.dynamics.andrzej.delta.gui.patterns.decorator;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CakeDecoratorTest {

    @Test
    public void test() {
        final Cake muffin = CakeBase.muffin(); // cost: 5.0
        Cake chocolateMuffin = new ChocolateDecorator(muffin); // 5.0 + 2.0
        Assert.assertEquals(chocolateMuffin.bake(), 7.0);
        Cake muffinWithDressing = new DressingDecorator(chocolateMuffin); // 5.0 + 2.0 + 1.0
        Assert.assertEquals(muffinWithDressing.bake(), 8.0);
    }

}