package com.haomins.test.unitTests;

import com.haomins.main.things.Creature;
import com.haomins.main.things.Thing;
import com.haomins.main.things.Tiger;
import com.haomins.main.things.flyer.Bat;
import org.junit.jupiter.api.Test;

class BatTest {

    Bat bat = new Bat("BBB");

    @Test
    void eat() {
        bat.eat(new Thing("A thing"));
        bat.eat(new Creature("A creature") {
            @Override
            public void move() {
                return;
            }
        });
        bat.eat(new Tiger("TT"));
    }

    @Test
    void whatDidYouEat() {
        bat.whatDidYouEat();
        bat.eat(new Tiger("TT"));
        bat.whatDidYouEat();
    }

    @Test
    void move() {
        bat.move();
    }

    @Test
    void fly() {
        bat.fly();
    }
}