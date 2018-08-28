package com.haomins.main.things;

public class Thing {

    private final String name;

    public Thing(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
