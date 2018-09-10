package com.haomins.main.things.flyer;

import com.haomins.main.things.Creature;
import com.haomins.main.things.Thing;

public class Bat extends Creature implements Flyer {

    public Bat(String name) {
        super(name);
    }

    @Override
    public void eat(Thing thing) {
        if (thing.getClass().equals(Thing.class)) System.out.println(this + " " + "won't eat a" + " " + thing + ".");
        else if (thing.getClass().getSuperclass().equals(Creature.class)) super.eat(thing);
        else return;
    }

    @Override
    public void move() {
        this.fly();
    }

    @Override
    public void fly() {
        System.out.println(this + " " + "is swooping through the dark.");
    }
}
