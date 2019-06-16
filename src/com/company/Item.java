package com.company;

public class Item implements Comparable{

    private String name;

    public int getWeight() {
        return weight;
    }

    private int weight;

    public Item(String line) {
        String[] split = line.split("=");
        name = split[0];
        weight = Integer.parseInt(split[1]);

    }

    @Override
    public int compareTo(Object o) {
        int compareWeight=((Item)o).getWeight();
        return compareWeight-this.weight;

    }

    @Override
    public String toString() {
        return "name: " + this.name + ", weight = " + this.weight + "\n";
    }

}