package com.company;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;

class State{
     Hero hero;
     Inventory inv;
     Map map;
     boolean running = true;
     boolean boulderBroken = false;
     boolean hasSledgehammer = false;
     boolean goblinHasNotAttacked = true, whiteOrcHasNotAttacked = true, trollHasNotAttacked = true;
     boolean win;
     public State(Hero h,Inventory i,Map m,boolean _running,boolean _boulderBroken,boolean  _hasSledgehammer,
     boolean _goblinHasNotAttacked,boolean _whiteOrcHasNotAttacked,boolean _trollHasNotAttacked,boolean _win){
         hero = h;
         inv=i;
         map=m;
         running=_running;
         boulderBroken=_boulderBroken;
         hasSledgehammer=_hasSledgehammer;
         goblinHasNotAttacked=_goblinHasNotAttacked;
         whiteOrcHasNotAttacked=_whiteOrcHasNotAttacked;
         trollHasNotAttacked=_trollHasNotAttacked;
         win=_win;

     }
}
public class Main {

    static Hero hero = new Hero();
    static Inventory inv = new Inventory();
    static Map map = new Map();


    static boolean running = true;
    static boolean boulderBroken = false;
    static boolean hasSledgehammer = false;
    static boolean goblinHasNotAttacked = true, whiteOrcHasNotAttacked = true, trollHasNotAttacked = true;
    static boolean win;
    static State state = new State(hero,inv,map,running,boulderBroken,hasSledgehammer,goblinHasNotAttacked,whiteOrcHasNotAttacked,trollHasNotAttacked,win);

    static String input;
    static ArrayList<String> command = new ArrayList<>();
    static String word;

    public static void main(String args[]) {
        printIntro();
        while (running) {


            System.out.print("\n>");
            input = Read.getString();
            input = input.trim().toLowerCase();


            splitCommand();
            checkCommand();


        }

    }

    public static void Save()
            throws IOException {
        try {
            File myObj = new File("GameData.json");

            myObj.createNewFile() ;



        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
         state = new State(hero,inv,map,running,boulderBroken,hasSledgehammer,goblinHasNotAttacked,whiteOrcHasNotAttacked,trollHasNotAttacked,win);
        Gson gson = new Gson();

        String J = gson.toJson(state);
        FileOutputStream outputStream = new FileOutputStream("GameData.json");
        byte[] strToBytes = J.getBytes();
        outputStream.write(strToBytes);
        outputStream.close();

    }

    public static void Load(){
       try

    {
        File myObj = new File("GameData.json");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            Gson gson = new Gson();
            State s = gson.fromJson(data, State.class);
            inv=s.inv;
            hero=s.hero;
            map=s.map;
          running=s.running;
        boulderBroken=s.boulderBroken;
            hasSledgehammer=s.hasSledgehammer;
        goblinHasNotAttacked=s.goblinHasNotAttacked;
            whiteOrcHasNotAttacked=s.whiteOrcHasNotAttacked;
        trollHasNotAttacked=s.trollHasNotAttacked;
            win=s.win;


        }
        myReader.close();
    } catch(
    FileNotFoundException e)

    {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }

}

    public static void printIntro(){
        System.out.println("\nWelcome to Middle Earth, an adventure text-based game");
        System.out.println("Defeat the Orc army, save your village and become a legend!");
        System.out.println("\nTo start, try using the \"look\" command to see where you are.");
    }

    public static void printCommands(){
        System.out.println("\nPOSSIBLE COMMANDS:");
        System.out.println("\n>commands - prints a list of all commands.");
        System.out.println(">look - provides a description of the area you are in.");
        System.out.println(">go (north/south/east/west) OR >north/south/east/west"      + " - move in direction accordingly.");
                System.out.println(">speak (person) - inuth/east/west)\"\n" +
                        "                + \" - move in direction accordingly.\");\n" +
                        "        System.out.println(\">get/take (item) - pick up the item.\");\n" +
                        "        System.out.println(\">drop (item) - leaves the item\");\n" +
                        "        System.out.println(\">eat (item) - eat food to restore health.\");\n" +
                        "        System.out.println(\">diagnose - shows hero's current health condition.\");\n" +
                        "        System.out.println(\">inventory - displays all items held in the inventory.\");itiates dialogue with person selected.");
    }
    public static void splitCommand(){
        command.clear();
        word = "";
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ' '){
                command.add(word);
                word = "";
            }
            else if(i == input.length()-1){
                word = word + input.charAt(i);
                command.add(word);
            }
            else{
                word = word + input.charAt(i);
            }
        }
    }

    public static void checkCommand(){
        if(command.size() == 1) {

            if(command.get(0).equals("look")) {
                map.location.look();
            }
            else if(command.get(0).equals("inventory")){
                inv.display();
            }
            else if(command.get(0).equals("diagnose")){
                hero.diagnose();
            }
            else if(command.get(0).equals("commands")){
                printCommands();

            }
            else if(command.get(0).equals("save")) {
               try {
                   Save();
               }
               catch(IOException e){

                }
            }
            else if(command.get(0).equals("load")) {
                Load();
            }
            else{
                System.out.println("I don't understand.");

            }
        }


        else if(command.size() == 2){
            if(command.get(0).equals("go")){
                if(command.get(1).equals("north")){
                    map.goNorth();
                    checkForEnemies();
                }
                else if(command.get(1).equals("south")){
                    map.goSouth();
                    boulderCheck();
                    checkForEnemies();
                }
                else if(command.get(1).equals("east")){
                    map.goEast();
                    boulderCheck();
                    checkForEnemies();
                }
                else if(command.get(1).equals("west")){
                    map.goWest();
                    checkForEnemies();
                }
                else{
                    System.out.println("I don't understand.");
                }
            }
            else if(command.get(0).equals("get") || command.get(0).equals("take")){
                if(command.get(1).equals("sledgehammer") && hero.blessed == false){
                    System.out.println("The sledgehammer is too heavy for you to pick up at the moment.");
                }
                else if(command.get(1).equals("sledgehammer") && hero.blessed == true){
                    Items temp = map.location.removeItem(command.get(1));
                    inv.add(temp);
                    hasSledgehammer = true;
                }
                else {
                    Items temp = map.location.removeItem(command.get(1));
                    inv.add(temp);
                }
            }
            else if(command.get(0).equals("drop")){
                Items temp = inv.drop(command.get(1));
                map.location.addItem(temp);
            }
            else if(command.get(0).equals("eat")){
                int healthBoost = inv.eat(command.get(1));
                hero.increaseHealth(healthBoost);
            }
            else if(command.get(0).equals("speak")){
                if(map.location == map.village && command.get(1).equals("villager")){
                    System.out.println("Villager: Hello stranger" +
                            "\nYou look confused. Maybe you should go see the village elder for guidance." +
                            "\nThe village shrine is northeast of the village. Good luck.");
                }
                else if(map.location == map.shrine && command.get(1).equals("elder")){

                    Items rapier = new Rapier();
                    boolean rapierGiven = false;

                    if(hero.blessed == false) {
                        System.out.println("Elder: So you have come." +
                                "\nDecades ago, we lived in peace. This peace was disrupted by a primal evil" +
                                "\nThere is still hope, however. It is being told that a brave warrior will give an end to the orc empire" +
                                "\nThat warrior... is you.Allow me to bless you with a transcendent power." +
                                "\nWith this, you now be able to carry heavy objects. Take this blessed rapier as well." +
                                "\nPlease, save our village.");
                        hero.blessed = true;
                        System.out.println("\nYou feel powerful. Tremendous strength courses through you.\n");
                        if(inv.playerInventory.size() < inv.maxSize) {
                            inv.add(rapier);
                            rapierGiven = true;
                        }
                        else{
                            System.out.println("Elder: You don't seem to have enough room. Drop an item then talk to me again.");
                        }
                    }
                    else if(rapierGiven == false){
                        System.out.println("Elder: Here, take the blessed rapier.");
                        if(inv.playerInventory.size() < inv.maxSize) {
                            inv.add(rapier);
                            rapierGiven = true;
                        }
                        else{
                            System.out.println("Elder: You don't seem to have enough room. Drop an item then talk to me again.");
                        }
                    }
                    else{
                        System.out.println("Hm? Do you need something? If not, then waste no more time. Go save our village");
                    }
                }
                else{
                    System.out.println("There is no one to talk to right now.");
                }
            }
            else{
                System.out.println("I don't understand.");
            }
        }
        else{
            System.out.println("I don't understand.");
        }
    }


    public static void boulderCheck(){
        if(map.location.name.equals(  map.dragonCave.name) && hasSledgehammer){
            System.out.println("\nYou swing the sledgehammer and shatter" +
                    " the boulder, revealing the cave's entrance.");
            boulderBroken = true;
        }
    }

    public static void checkForEnemies(){

        String name;
        int attack, defence, health;

        if(map.location.name.equals(map.darkForest.name)){

            if(goblinHasNotAttacked){

                goblinHasNotAttacked = false;

                name = "Goblin";
                attack = 3;
                defence = 2;
                health = 10;

                battleEnemy(name, attack, defence, health);
            }
        }


        else if(map.location.name.equals(map.mountains.name)){
            if(trollHasNotAttacked){

                trollHasNotAttacked = false;

                name = "Troll";
                attack = 4;
                defence = 2;
                health = 12;

                battleEnemy(name, attack, defence, health);
            }
        }
        else if(map.location.name.equals(map.dragonCave.name)){
            if(boulderBroken){
                if(whiteOrcHasNotAttacked){

                    whiteOrcHasNotAttacked = false;

                    name = "White Orc";
                    attack = 4;
                    defence = 4;
                    health = 14;

                    battleEnemy(name, attack, defence, health);
                }
            }
        }


    }

    public static void battleEnemy(String name, int attack, int defence, int health){

        System.out.println("\nYou are attacked by a " + name + "!");


        int goFirstMargin, hitMargin;
        int damage;


        while(hero.health != 0 || health !=0) {

            System.out.println("Hero Health:" + hero.health + "\nEnemy Health:" + health);

            goFirstMargin = (int) Math.round(10 * Math.random() + 1);
            if (goFirstMargin < 5) {
                hitMargin = (int) Math.round(3 * Math.random());
                damage = hero.attack + inv.checkForWeapons() - defence + hitMargin;

                if(damage > 0){
                    health = health - damage;
                }

                if(health <= 0){
                    break;
                }


                hitMargin = (int) Math.round(3 * Math.random());
                damage = attack - hero.defence + inv.checkForArmour() + hitMargin;

                if(damage > 0){
                    hero.health = hero.health - damage;
                }

                if(hero.health <= 0){
                    break;
                }

            } else {

                hitMargin = (int) Math.round(3 * Math.random());
                damage = attack - hero.defence + inv.checkForArmour() + hitMargin;
                if(damage > 0){
                    hero.health = hero.health - damage;
                }

                if(hero.health <= 0){
                    break;
                }


                hitMargin = (int) Math.round(3 * Math.random());
                damage = hero.attack + inv.checkForWeapons() - defence + hitMargin;
                if(damage > 0){
                    health = health - damage;
                }

                if(health <= 0){
                    break;
                }
            }
        }

        if(hero.health <= 0){
            System.out.println("You have been slain!");
            win = false;
            endGame();
        }
        else if(health <= 0){
            System.out.println("After a long fight, the vicious " + name + " falls to your might.");
            System.out.println("You have slain the " + name + "!");
            if(name.equals("White Orc")){
                win = true;
                endGame();
            }
            else{
                hero.diagnose();
            }
        }
    }

    public static void endGame() {
        if (win) {
            System.out.println("\nCongratulations! You conquered the Middle Earth! The village is saved from the threat of Orcs!" +
                    "\nCreated by: Panagiotis,Anastasis,Christos");
            running = false;
        }
        else{
            System.out.println("\nThe village is doomed to fall thanks to you... Better luck next time!");
            running = false;
        }
    }
}