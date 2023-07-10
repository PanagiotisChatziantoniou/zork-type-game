package com.company;

public class Hero {

    int attack;
    int defence;
    int health;
    int maxHealth;
    boolean blessed;

    public Hero(){
        maxHealth = 15;
        health = maxHealth;
        attack = 3;
        defence = 3;
        blessed = false;
    }

    public void increaseHealth(int healthBoost){
        health = health + healthBoost;
        if(health > maxHealth){
            health = maxHealth;
        }
    }

    public void diagnose(){
        if(health == maxHealth){
            System.out.println("You are in perfect condition.");
        }
        else if(health >= 8 && health <= 12){
            System.out.println("You are in good condition; mild injuries have been sustained.");
        }
        else if(health >= 4 && health <=8){
            System.out.println("You are in moderate condition. Eating food would be advised.");
        }
        else if(health > 0 && health <= 4){
            System.out.println("You are in critical condition. Eating food would be greatly advised.");
        }
    }
}
