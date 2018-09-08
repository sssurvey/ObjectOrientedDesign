package com.haomins.test;

import com.haomins.main.things.Thing;
import java.util.ArrayList;
import java.util.Random;

public class TestCreature {

    private static int CREATIRE_COUNT = 20;
    //private static int THING_COUNT = 20;

    public static void main(String[] args) {
        ArrayList<Thing> things = new ArrayList<>();
        for (int i = 0; i < CREATIRE_COUNT; i++) {
            things.add(new Thing((new Random().nextInt()) + " TestThing"));
            for (Thing thing : things) {
                System.out.println("Name is:" + " " + thing);
            }
        }
    }
}