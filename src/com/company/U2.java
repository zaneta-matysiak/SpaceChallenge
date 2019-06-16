package com.company;

public class U2 extends Rocket {

    public U2(){
        this.maxWeight = 29000;
        this.startWeight = 18000;
        this.cost = 120;
    }

    @Override
    public boolean launch() {

        double chanceLaunched = 0.04 * getCurrentWeight() / getMaxWeight();

        if (chanceLaunched >= Math.random()) {
            System.out.println("U2 Exploded! Sending another rocket U2...");
            return false;
        } else {
            System.out.println("Success! U2 launched well!");
            return true;
        }
    }

    @Override
    public boolean land() {

        double chanceLanded = 0.08 * getCurrentWeight() / getMaxWeight();

        if (chanceLanded >= Math.random()) {
            System.out.println("U2 Exploded! Sending another rocket U2...");
            return false;
        } else {
            System.out.println("Success! U2 landed well! \n");
            return true;
        }
    }
}
