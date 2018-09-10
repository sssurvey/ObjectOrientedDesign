package com.haomins.main.things;

public class Thing {

    private final String name;

    public Thing(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (this.getClass() == Thing.class) {
            return this.name;
        } else {
            return this.name + " " + this.getClass().getSimpleName();
        }
    }
}
