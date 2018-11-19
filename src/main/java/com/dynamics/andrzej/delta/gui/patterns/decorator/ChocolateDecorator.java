package com.dynamics.andrzej.delta.gui.patterns.decorator;

public class ChocolateDecorator extends CakeDecorator {
    public ChocolateDecorator(Cake cake) {
        super(cake);
        price = cake.type.size * 4;
    }

    @Override
    public double bake() {
        System.out.println("Price for chocolate cake: " + price);
        return super.bake() + price;
    }
}
