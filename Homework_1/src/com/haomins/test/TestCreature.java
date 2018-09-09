package com.haomins.test;

import com.haomins.main.things.Ant;
import com.haomins.main.things.Creature;
import com.haomins.main.things.Thing;
import com.haomins.main.things.Tiger;
import com.haomins.main.things.flyer.Bat;
import com.haomins.main.things.flyer.Fly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestCreature {

    private static int THING_COUNT = 20;

    public static void main(String[] args) {

        testThingArray(THING_COUNT); // Test Thing creation
        testTigerArray(THING_COUNT); // Test Thing array holding creature

        // Part II test
        // Modify your test program to test the Creatures. The main() must create a separate array for Creature instances
        List arrayList = new ArrayList<>();

        arrayList.add(new Tiger("Woof Meow"));
        arrayList.add(new Fly("Annoying Buzzer"));
        arrayList.add(new Bat("Bat Man"));
        arrayList.add(new Ant("Maven Ant"));

        arrayList.add(new Thing("Rocky Rock"));
        arrayList.add(new Thing("Banana Nana"));
        arrayList.add(new Thing("Bling Light"));
        arrayList.add(new Thing("Teeny Bug"));

        System.out.println("\nThings:\n");
        for (Object o : arrayList) if (o instanceof Thing) System.out.println(o);
        System.out.println("\nCreatures:\n");
        for (Object o : arrayList) if (o.getClass().getSuperclass().equals(Creature.class)) System.out.println(o);

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