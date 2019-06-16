package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String firstPhase = "/home/zaneta/Documents/Sources/SpaceChallenge/src/Phase1.txt";
        String secondPhase = "/home/zaneta/Documents/Sources/SpaceChallenge/src/Phase2.txt";


        try {
            System.out.println("Start simulation for rocket type U1...");
            System.out.println("Simulation for Phase 1...");
            int budgetU1Phase1 = runSimulationForU1(firstPhase);
            System.out.println("Begin simulation for Phase 1...");
            int budgetU1Phase2 = runSimulationForU1(secondPhase);

            System.out.println("Start simulation for rocket type U2...");
            System.out.println("Begin simulation for Phase 1...");
            int budgetU2Phase1 = runSimulationForU2(firstPhase);
            System.out.println("Simulation for Phase 1...");
            int budgetU2Phase2 = runSimulationForU2(secondPhase);

            System.out.println("TOTAL SUMMARY!...");


            System.out.println("budget U1 for phase 1 is: " + budgetU1Phase1 +" millions $ and for phase 2: " + budgetU1Phase2 + " millions $");
            System.out.println("budget U2 for phase 1 is: " + budgetU2Phase1 +" millions $ and for phase 2: " + budgetU2Phase2 + " millions $");

            if ((budgetU1Phase1 + budgetU1Phase2) < (budgetU2Phase1 + budgetU2Phase2)){
                System.out.println("Better simulation is for U1. Total cost: " + (budgetU1Phase1 + budgetU1Phase2) + " millions $");
            }
            else if((budgetU1Phase1 + budgetU1Phase2) > (budgetU2Phase1 + budgetU2Phase2)){
                System.out.println("Better simulation is for U2. Total cost: " + (budgetU2Phase1 + budgetU2Phase2) + " millions $");
            } else {
                System.out.println("Simulations are the same! " + (budgetU2Phase1 + budgetU2Phase2) + " millions $");

            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static int runSimulationForU1(String phase) throws Exception{

        Simulation simulation = new Simulation();
        ArrayList<Item> items = simulation.loadItems(phase);
        ArrayList<Rocket> rockets= simulation.loadU1(items);
        int budgetU1 = simulation.runSimulation(rockets);

        summarySimulation(simulation);

        return budgetU1;

    }

    public static int runSimulationForU2(String phase) throws Exception{

        Simulation simulation = new Simulation();
        ArrayList<Item> items = simulation.loadItems(phase);

        ArrayList<Rocket> rockets= simulation.loadU2(items);

        int budgetU2 = simulation.runSimulation(rockets);

        summarySimulation(simulation);

        return budgetU2;
    }

    public static void summarySimulation(Simulation simulation){

        System.out.println("Summary...");
        System.out.println("Total launched rockets is: " + simulation.getTotalRockets());
        System.out.println("From this succeeded launched and landed rockets is: " + simulation.getSucceededRockets());
        System.out.println(simulation.getCrushRockets() + " get crushed: " + simulation.getFailLaunched() +
                " fail launched and " + simulation.getFailLanded() + " fail landed \n\n");

    }
}
