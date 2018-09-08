package com.haomins.test.unitTests;

import com.haomins.main.things.Tiger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TigerTest {

    Tiger tiger = new Tiger("TTiger");

    @Test
    void initT() {
        assertEquals(Tiger.class, (new Tiger("Haha")).getClass());
    }

    @Test
    void moveTest() {
        tiger.move();
    }

    @Test
    void toStringTest() {
        System.out.println(tiger);
    }
}