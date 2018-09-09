package com.haomins.main.things.flyer;

import com.haomins.main.things.Creature;
import com.haomins.main.things.Thing;

public class Fly extends Creature implements Flyer {

    public Fly(String name) {
        super(name);
    }

    @Override
    public void eat(Thing thing) {
        if (thing.getClass().equals(Thing.class)) super.eat(thing);
        else System.out.println(this + " " + "won't eat a" + " " + thing + ".");
    }

    @Override
    public void fly() {
        System.out.println(this + " " + "is buzzing around in flight.");
    }

    @Override
    public void move() {
        this.fly();
    }
}
