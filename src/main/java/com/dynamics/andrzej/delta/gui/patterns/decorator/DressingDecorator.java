package com.dynamics.andrzej.delta.gui.patterns.decorator;

public class DressingDecorator extends CakeDecorator {
    public DressingDecorator(Cake cake) {
        super(cake);
        price = cake.type.size * 2;
    }

    @Override
    public double bake() {
        System.out.println("Price for dressing: " + price);
        return super.bake() + price;
    }
}
