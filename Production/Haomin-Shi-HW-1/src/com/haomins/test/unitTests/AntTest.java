package com.haomins.test.unitTests;

import com.haomins.main.things.Ant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AntTest {

    Ant ant = new Ant("Antdsaf A");

    @Test
    void create() {
        assertEquals(Ant.class, (new Ant("Test")).getClass());
    }

    @Test
    void move() {
        ant.move();
    }
}