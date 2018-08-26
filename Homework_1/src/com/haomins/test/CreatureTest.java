package com.haomins.test;

import static org.junit.jupiter.api.Assertions.*;

import com.haomins.main.things.Creature;
import com.haomins.main.things.Thing;
import org.junit.jupiter.api.Test;

class CreatureTest {

    @Test
    void createCreatureTest() {
        CreatureForTesting creature = new CreatureForTesting();
        assertEquals(creature == null, false);
    }

    @Test
    void creatureEatTest() {
        CreatureForTesting creature = new CreatureForTesting();
        Thing thing = new Thing("Tobe Eaten");
        creature.eat(thing);
        creature.whatDidYouEat();
    }
}

// This class is created for unit testing the Creature __Abstract__ class
class CreatureForTesting extends Creature {

    CreatureForTesting() {
        super("TestCreature");
    }

    @Override
    public void move() {
        System.out.println("Moved Test Creature");
    }
}