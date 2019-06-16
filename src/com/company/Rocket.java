package com.company;

public class Rocket implements SpaceShip {

    private int currentWeight;

    public int getCurrentWeight() {
        return currentWeight;
    }

    protected int maxWeight;

    public int getMaxWeight() {
        return maxWeight;
    }

    protected int startWeight;

    protected int cost;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public final boolean canCarry(Item item) {

        return currentWeight + item.getWeight() <= maxWeight - startWeight;

    }

    @Override
    public final void carry(Item item) {

        currentWeight += item.getWeight();

    }

    @Override
    public String toString() {
        return "currentWeight: " + this.currentWeight + "\n";
    }
}
