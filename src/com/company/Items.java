package com.company;



public class Items {
    String name;
    boolean edible;
}


class Dagger extends Items{
    public Dagger(){
        name = "Dagger";
        edible = false;
    }
}

class Sledgehammer extends Items{
    public Sledgehammer(){
        name = "Sledgehammer";
        edible = false;
    }
}

class Journal extends Items{
    public Journal(){
        name = "Journal";
        edible = false;
    }
}

class Pie extends Items{
    public Pie(){
        name = "Pie";
        edible = true;
    }
}


class Helm extends Items{
    public Helm() {
        name = "Helm";
        edible = false;
    }
}

class Chestplate extends Items {
    public Chestplate() {
        name = "Chestplate";
        edible = false;
    }
}

class Mushroom extends Items{
    public Mushroom(){
        name = "Mushroom";
        edible = true;
    }
}


class Rapier extends Items{
    public Rapier(){
        name = "Rapier";
        edible = false;
    }
}