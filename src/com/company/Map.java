package com.company;



public class Map {

    Scenes[][] scenes = new Scenes[3][3];
    Scenes location;
    int x = 0, y = 0;


    Scenes openField = new OpenField();
    Scenes blackHouse = new BlackHouse();
    Scenes mountains = new Mountains();
    Scenes stonePath = new StonePath();
    Scenes village = new Village();
    Scenes swamp = new Swamp();
    Scenes shrine = new Shrine();
    Scenes darkForest = new DarkForest();
    Scenes dragonCave = new DragonCave();

    public Map(){

        scenes[0][0] = openField;
        scenes[0][1] = blackHouse;
        scenes[0][2] = mountains;
        scenes[1][0] = swamp;
        scenes[1][1] = village;
        scenes[1][2] = stonePath;
        scenes[2][0] = dragonCave;
        scenes[2][1] = darkForest;
        scenes[2][2] = shrine;

        location = scenes[x][y];
    }

    public void updateLocation(){
        location = scenes[x][y];
        location.look();
    }

    public void goNorth(){
        if(y < 2){
            y++;
            updateLocation();
        }
        else{
            System.out.println("You cannot go any further north.");
        }
    }

    public void goSouth(){
        if(y > 0){
            y--;
            updateLocation();
        }
        else{
            System.out.println("You cannot go any further south.");
        }
    }

    public void goEast(){
        if(x < 2){
            x++;
            updateLocation();
        }
        else{
            System.out.println("You cannot go any further east.");
        }

    }

    public void goWest(){
        if(x > 0){
            x--;
            updateLocation();
        }
        else{
            System.out.println("You cannot go any further west.");
        }
    }
}



