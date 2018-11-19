package com.dynamics.andrzej.delta.gui.patterns.decorator;

public class CakeBase extends Cake {

    public static CakeBase muffin() {
        return new CakeBase(CakeType.MUFFIN);
    }

    public static CakeBase normalCake() {
        return new CakeBase(CakeType.CAKE);
    }

    public static CakeBase birthdayCake() {
        return new CakeBase(CakeType.BIRTHDAY_CAKE);
    }

    public static CakeBase weddingCake() {
        return new CakeBase(CakeType.WEDDING_CAKE);
    }

    private CakeBase(CakeType type) {
        super(type);
        price = type.size * 10.0;
    }

    @Override
    public double bake() {
        System.out.println("Baking cake base: " + price);
        return price;
    }
}
