package com.haomins.main.things;

public abstract class Creature extends Thing implements CreatureContract {

    private Stomach stomach;

    public Creature(String name) {
        super(name);
        stomach = new Stomach();
    }

    @Override
    public void eat(Thing thing) {
        System.out.println(super.toString() + " " + "has just eaten a" + " " + thing);
        this.stomach.addContent(thing);
    }

    @Override
    public void whatDidYouEat() {
        if (stomach == null) {
            System.out.println(
                this + this.getClass().getSimpleName() + " " + "has had nothing to eat!");
        } else {
            System.out.println(
                this + this.getClass().getSimpleName() + " " + "has eaten a" + " "
                    + stomach.getInStomach());
        }
    }

    public abstract void move();
    // TODO --- might need to switch to abstract is needed

    private class Stomach {

        private Thing inStomach;

        void addContent(Thing thing) {
            inStomach = thing;
        }

        private Thing getInStomach() {
            return inStomach;
        }
    }

}
