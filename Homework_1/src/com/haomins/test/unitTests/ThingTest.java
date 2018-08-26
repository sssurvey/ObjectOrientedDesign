package com.haomins.test.unitTests;

import static org.junit.jupiter.api.Assertions.*;

import com.haomins.main.things.Thing;

import org.junit.jupiter.api.Test;

class ThingTest {

    private String thingName = "Test Name";

    @Test
    void createThing() {
        Thing thing = new Thing(thingName);
        assertNotNull(thing);
    }

    @Test
    void getThingName() {
        Thing thing = new Thing(thingName);
        String s = thing.toString();
        assertEquals(s, thingName);
    }
}