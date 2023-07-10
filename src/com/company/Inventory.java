package com.company;


import java.util.ArrayList;

public class Inventory {
    ArrayList<Items> playerInventory = new ArrayList<>();
    int maxSize = 5;

    public void add(Items item){
        if(playerInventory.size() < maxSize){
            playerInventory.add(item);
            System.out.println(item.name + " has been added to your inventory.");
        }
        else{
            System.out.println("Your inventory is full. Drop an item first.");
        }
    }

    public Items drop(String item){
        boolean contained = false;
        Items temp = null;
        if(playerInventory.size() > 0){
            for(int i = 0; i < playerInventory.size(); i++){
                if(playerInventory.get(i).name.toLowerCase().equals(item)){
                    contained = true;
                    temp = playerInventory.get(i);
                    System.out.println(playerInventory.get(i).name + " was dropped.");
                    playerInventory.remove(i);
                }
            }
            if(!contained){
                System.out.println("You don't have that item in your inventory.");
            }
        }
        else{
            System.out.println("There is nothing in your inventory to drop.");
        }

        return temp;
    }



    public void display(){

        if (playerInventory.size() > 0) {
            System.out.println("Inventory (" + playerInventory.size() + "/" + maxSize + "):");

            for (int i = 0; i < playerInventory.size(); i++) {
                System.out.println(playerInventory.get(i).name);
            }
        } else{
            System.out.println("Your inventory is empty.");
        }

        System.out.println();

    }


    public int checkForWeapons(){
        int totalAttackBoost = 0;

        for(int i = 0; i < playerInventory.size(); i++){
            if(playerInventory.get(i).name.toLowerCase().equals("dagger")){
                totalAttackBoost = totalAttackBoost + 2;
            }
            else if(playerInventory.get(i).name.toLowerCase().equals("rapier")){
                totalAttackBoost = totalAttackBoost + 5;
            }
        }
        return totalAttackBoost;
    }


    public int checkForArmour(){
        int totalDefenceBoost = 0;

        for(int i = 0; i < playerInventory.size(); i++){
            if(playerInventory.get(i).name.toLowerCase().equals("helm")){
                totalDefenceBoost = totalDefenceBoost + 1;
            }
            else if(playerInventory.get(i).name.toLowerCase().equals("chestplate")){
                totalDefenceBoost = totalDefenceBoost + 3;
            }
        }
        return totalDefenceBoost;
    }


    public int eat(String food){
        int healthBoost = 0;
        boolean foodEaten = false;

        for(int i = 0; i < playerInventory.size(); i++) {

            if(playerInventory.get(i).edible) {
                if (playerInventory.get(i).name.toLowerCase().equals(food)) {
                    if (food.equals("apple")) {
                        healthBoost = 5;
                        foodEaten = true;
                        playerInventory.remove(i);
                    } else if (food.equals("pie")) {
                        healthBoost = 10;
                        foodEaten = true;
                        playerInventory.remove(i);
                    } else if (food.equals("mushroom")) {
                        healthBoost = 3;
                        foodEaten = true;
                        playerInventory.remove(i);
                    }
                }
            }
        }

        if(foodEaten == false){
            System.out.println("Maybe try eating something else.");
        }
        else{
            System.out.println("You eat the " + food + " and feel refreshed.");
        }

        return healthBoost;
    }
}