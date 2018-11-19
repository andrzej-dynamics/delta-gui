package com.dynamics.andrzej.delta.gui.patterns.decorator;

public abstract class CakeDecorator extends Cake {
    protected Cake cake;

    public CakeDecorator(Cake cake) {
        super(cake.type);
        this.cake = cake;
    }

    @Override
    public double bake() {
        return cake.bake();
    }
}
