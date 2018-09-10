package com.haomins.test.unitTests;

import com.haomins.main.things.Creature;
import com.haomins.main.things.Thing;
import com.haomins.main.things.flyer.Fly;
import org.junit.jupiter.api.Test;

class FlyTest {

    Fly fly = new Fly("FFFF");

    @Test
    void eatCreature() {
        fly.eat(new Creature("Test Creature") {
            @Override
            public void move() {
                return;
            }
        });
        fly.eat(new Thing("Test Thing"));
    }

    @Test
    void fly() {
        fly.fly();
    }

    @Test
    void move() {
        fly.move();
    }
}