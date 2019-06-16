package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Simulation {

    public int getTotalRockets() {
        return totalRockets;
    }

    public int getSucceededRockets() {
        return succeededRockets;
    }

    public int getCrushRockets() {
        return crushRockets;
    }

    public int getFailLaunched() {
        return failLaunched;
    }

    public int getFailLanded() {
        return failLanded;
    }

    private int totalRockets;
    private int succeededRockets;
    private int crushRockets;

    private int failLaunched;
    private int failLanded;


    public ArrayList loadItems( String path){

        ArrayList<Item> items = new ArrayList<>();

        File file = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for( int i  = 0; scanner.hasNextLine(); i++){
            String line = scanner.nextLine();
            Item item = new Item(line);
            items.add(item);
        }

        Collections.sort(items);
        return items;
    }

    private ArrayList load(ArrayList<Item> items, String rocketType) throws Exception {

        ArrayList<Rocket> rockets = new ArrayList<>();

        while (!items.isEmpty()){
            Item item = items.get(0);

            boolean carried = false;

            for (Rocket rocket: rockets){
                if (rocket.canCarry(item)){
                    rocket.carry(item);
                    items.remove(0);
                    carried = true;
                    break;
                }
            }

            if (!carried){
                Rocket rocket = rocketType == "U1" ? new U1(): new U2();
                rockets.add(rocket);

                if (rocket.canCarry(item)){
                    rocket.carry(item);
                    items.remove(0);
                }
                else {
                    throw new Exception("Item weight exceed max weight of rocket");
                }
            }
        }

        return rockets;

    }

    public ArrayList loadU1(ArrayList<Item> items) throws Exception{
        return load(items, "U1");
    }

    public ArrayList loadU2(ArrayList<Item> items) throws Exception{
        return load(items, "U2");
    }

    public int runSimulation(ArrayList<Rocket> rockets){

        int totalBudget = 0;

        for (Rocket rocket: rockets ){
            boolean isLaunched = false;
            boolean isLanded = false;
            do {
                totalRockets++;
                isLaunched = rocket.launch();
                totalBudget += rocket.cost;

                if (isLaunched){
                    isLanded = rocket.land();
                    if (!isLanded){
                        failLanded++;
                        crushRockets++;
                    }
                }
                else{
                    failLaunched++;
                    crushRockets++;
                }
                if (isLaunched && isLanded){
                    succeededRockets++;
                }
            }
            while(!isLaunched || !isLanded);
        }

        return totalBudget;

    }
}

