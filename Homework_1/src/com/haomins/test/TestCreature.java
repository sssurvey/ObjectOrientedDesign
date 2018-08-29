package com.haomins.test;

import com.haomins.main.things.Thing;
import java.util.ArrayList;
import java.util.Random;

public class TestCreature {

    public static void main(String[] args) {
        ArrayList<Thing> things = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            things.add(new Thing((new Random().nextInt()) + " TestThing"));
            for (Thing thing : things) {
                System.out.println("Name is:" + " " + thing);
            }
        }
    }
}