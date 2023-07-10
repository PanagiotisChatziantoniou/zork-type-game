package com.company;


import java.util.ArrayList;

public class Scenes {
    String name;
    String description;
    ArrayList<Items> itemsInArea = new ArrayList<>();


    public Items removeItem(String item){
        boolean contained = false;
        Items temp = null;
        for(int i = 0; i < itemsInArea.size(); i++){
            if(itemsInArea.get(i).name.toLowerCase().equals(item)) {
                temp = itemsInArea.get(i);
                itemsInArea.remove(i);
                contained = true;
            }
        }

        if(!contained){
            System.out.println("There is no such item in this area.");
        }
        return temp;
    }

    public void addItem(Items itemToAdd){
        itemsInArea.add(itemToAdd);
    }

    public void look(){
        System.out.println(description);
        System.out.println("Items in area:");
        if(itemsInArea.size() == 0){
            System.out.println("There are no items in this area.");
        }
        else {
            for (int i = 0; i < itemsInArea.size(); i++) {
                System.out.println(itemsInArea.get(i).name);
            }
        }
    }

}

class OpenField extends Scenes{

    Items sledgeHammer = new Sledgehammer();
    Items dagger = new Dagger();

    public OpenField(){
        name = "Open Field";
        description = "You find yourself in a vast, open field. " +
                "The faint sounds of birdsong can be heard in the distance." +
                "\nTo the north is a black house and to the east lies a swamp.";
        itemsInArea.add(sledgeHammer);
        itemsInArea.add(dagger);
    }
}

class BlackHouse extends Scenes{

    Items journal = new Journal();
    Items pie = new Pie();


    public BlackHouse(){
        name = "Black House";
        description = "In the black house, a torn up rug lies in front of you." +
                "There are deep indents in the walls and scratch marks on the floors." +
                "\nTo the north are mountains and to the east is a village.";
        itemsInArea.add(journal);
        itemsInArea.add(pie);

    }
}

class Mountains extends Scenes{

    Items chestplate = new Chestplate();

    public Mountains(){
        name = "Mountains";
        description = "Towering mountains block your path. The land around you is a dreary, ravaged sight." +
                "\nTo the south is a black house and to the east is a stone path.";
        itemsInArea.add(chestplate);
    }
}

class StonePath extends Scenes{

    public StonePath(){
        name = "Stone Path";
        description = "A long, path stretches out before you." +
                "\nA rusted post with three signs indicates the following: to the west are mountains, to the south is a village " +
                "and to the east is a shrine";
    }
}

class Village extends Scenes{
    public Village(){
        name = "Village";
        description = "You enter a small, quite village.The community board reads: Welcome to Morgoth Village." +
                "\n A villager is standing nearby Maybe he has something to say." +
                "\n To the north is the stone path," +
                "\nTo the west is a black house, to the south is a swamp, to the east is a dark forest.";
    }
}

class Swamp extends Scenes{

    Items helm = new Helm();

    public Swamp(){
        name = "Swamp";
        description = "An expansive marshland extends for several hundred meters. This swamp smells death" +
                "\nTo the north is a village, to the west is an open field and to the east is a dragon cave.";
        itemsInArea.add(helm);
    }
}

class Shrine extends Scenes{
    public Shrine(){
        name = "Shrine";
        description = "Enchanting wooden pillars envelop a stone pedestal, before which an old man is kneeling." +
                "\nThis man seems to be the village elder. You should probably address him as such." +
                "\nTo your west is a stone path and to the south is a dark forest.";
    }
}

class DarkForest extends Scenes{

    Items mushroom = new Mushroom();


    public DarkForest(){
        name = "Dark Forest";
        description = "Tall trees of many different types fade into the forest." +
                "\nBroken branches everywhere. It would appear as if something tore through the forest..." +
                "\nTo the north is a shrine, to the west is a village and to the south is a dragon cave.";
        itemsInArea.add(mushroom);
    }
}

class DragonCave extends Scenes{

    public DragonCave() {
        name = "Dragon Cave";
        description = "An immense boulder blocks the entrance to the cave. Perhaps a tool of some sort could be used to" +
                " break it.";

    }
}