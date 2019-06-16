package com.company;


public class U1 extends Rocket{

    public U1(){
        this.maxWeight = 18000;
        this.startWeight = 10000;
        this.cost = 100;
    }

    @Override
    public boolean launch() {

        double chanceLaunched = 0.05 * getCurrentWeight() / getMaxWeight();

        if (chanceLaunched >= Math.random()) {
            System.out.println("U1 Exploded! Sending another rocket U1...");
            return false;
        } else {
            System.out.println("Success! U1 launched well!");
            return true;
        }
    }

    @Override
    public boolean land() {

        double chanceLanded = 0.01 * getCurrentWeight() / getMaxWeight();

        if (chanceLanded >= Math.random()) {
            System.out.println("U1 Exploded! Sending another rocket U1...");
            return false;
        } else {
            System.out.println("Success! U1 landed well! \n" );
            return true;
        }
    }
}
