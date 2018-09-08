package com.haomins.test;

import com.haomins.main.things.Thing;
import com.haomins.main.things.Tiger;

import java.util.ArrayList;
import java.util.Random;

public class TestCreature {

    private static int THING_COUNT = 20;

    public static void main(String[] args) {
        testThingArray(THING_COUNT);
        testTigerArray(THING_COUNT);
    }

    private static void testThingArray(int CONSTANTS) {
        ArrayList<Thing> lists = new ArrayList<>();
        for (int i = 0; i < CONSTANTS; i++) {
            lists.add(new Thing((new Random().nextInt()) + " TestThing"));
            for (Thing item : lists) {
                System.out.println("Name is:" + " " + item);
            }
        }
    }

    private static void testTigerArray(int CONSTANTS) {
        ArrayList<Thing> lists = new ArrayList<>();
        for (int i = 0; i < CONSTANTS; i++) {
            lists.add(new Tiger((new Random().nextInt()) + " TestTiger"));
            for (Thing item : lists) {
                System.out.println("Name is:" + " " + item);
            }
        }
    }
}