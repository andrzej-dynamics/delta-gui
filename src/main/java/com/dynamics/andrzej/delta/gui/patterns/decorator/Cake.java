package com.dynamics.andrzej.delta.gui.patterns.decorator;

import jdk.nashorn.internal.objects.annotations.Getter;

public abstract class Cake {
    protected double price;

    protected final CakeType type;

    public Cake(CakeType type) {
        this.type = type;
    }

    public abstract double bake();

    protected enum CakeType {
        MUFFIN(0.5),
        CAKE(1),
        BIRTHDAY_CAKE(1.5),
        WEDDING_CAKE(3);

        protected double size;

        CakeType(double size) {
            this.size = size;
        }
    }
}