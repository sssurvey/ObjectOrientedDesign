package com.haomins.main.things;

public class Tiger extends Creature {

    public Tiger(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(this.name + " " + this.getClass().getSimpleName() + " " + "has just pounced.");
    }

}