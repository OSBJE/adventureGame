package org.example;

public class Map {
    //****************** ATTRIBUTES **************************************************//
    // Et kort af "Rooms" har et Room, som det laves på baggrund af.
    private Room startRoom;
    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;
    private Room room6;
    private Room room7;
    private Room room8;
    private Room room9;


    // ***************** Constructor *********************************************** ///
    // Når et spil startes, kalder den sin metode buildGame.
    // kald metoden i constructor

    public Map() {
        buildMap();
    }


    //*** Methods ***//
    // Nedståden metode bygger vores "rooms map"


    /// ************************* Getter methods **********************************////

    // --- method to get player started --- //
    public Room getFirstRoom() {
        return startRoom;
    }


    /// *********************** Map construction **********************************////
    // --- build map opskrift ---//
    public void buildMap() {
        // vi starter med at lave 9 room objekter, et som repræsenterer hvert room i vores spil
        //

        this.room1 = new Room("Room 1", "This is a beautiful green hill with a nice view.");
        this.room2 = new Room("Room 2", "This is a dark cave with a thousand bats. Watch out!!!");
        this.room3 = new Room("Room 3", "This is a cold icy mountain.");
        this.room4 = new Room("Room 4", "This is a wooden cottage that is about to collapse. Watch out!!!");
        this.room5 = new Room("Room 5", "This is a - Jysk sengtøjslager - Dont get lost! .");
        this.room6 = new Room("Room 6", "This is an erupting volcano... watch out for the burning lava!!!");
        this.room7 = new Room("Room 7", "This is a noisy metropolis with polluting traffic.");
        this.room8 = new Room("Room 8", "This is an olive grove with butterflies.");
        this.room9 = new Room("Room 9", "This is a battlefield from World War 1. \nKeep your head down, so you don't get hit!");

        // Her skal vi have forbindelserne mellem de forskellige "Rooms"

        // Her er forbindelserne mellem room1
        room1.setRoomDoorEast(room2);
        room1.setRoomDoorSouth(room4);

        // Her er forbindelserne mellem room2
        room2.setRoomDoorWest(room1);
        room2.setRoomDoorEast(room3);

        // her er forbindelserne mellem room 3
        room3.setRoomDoorWest(room2);
        room3.setRoomDoorSouth(room6);

        // her forbindelserne mellem room 4
        room4.setRoomDoorNorth(room1);
        room4.setRoomDoorSouth(room7);

        // Her er forbindelserne mellem room 5
        room5.setRoomDoorSouth(room8);

        // her er forbindelserne mellem room 6
        room6.setRoomDoorNorth(room3);
        room6.setRoomDoorSouth(room9);

        // Her er forbindelserne mellem room 7
        room7.setRoomDoorNorth(room4);
        room7.setRoomDoorEast(room8);

        // Her er forbindelserne mellem room 8
        room8.setRoomDoorNorth(room5);
        room8.setRoomDoorWest(room7);
        room8.setRoomDoorEast(room9);

        // Her er forbindelserne mellem room 9
        room9.setRoomDoorNorth(room6);
        room9.setRoomDoorWest(room8);

        // Her har vi det endelig kort.

        startRoom = room1;
        buildAndPlaceItems();
        buildAndPlaceEnemies();

    }

    // --- Helper method to fill map --- //
    public void buildAndPlaceItems() {

        Food itemApple = new Food("Apple", "from snowwhite", -15, true);
        Food itemMeat = new Food("Meat", "from cow", 25, false);
        Food itemBanana = new Food("Banana", "from minions", 10, false);
        Food itemProteinBar = new Food("ProteinBar", "from arnolds gym", 35, false);
        Item itemKnife = new MeleeWeapon("Knife", "Magic Grim", 10, 1000);
        Item itemSword = new MeleeWeapon("Sword", "It's a big sword", 10, 1000);
        Item itemAxe = new MeleeWeapon("Axe", "Its name is gimli", 25, 1000);
        Item itemWashboard = new RangedWeapon("Washboard", "Remember to do your laundy", 50, 2);
        Item jarOfHoney = new Food("The Jar of honey", "it's delicious", 60, false);

        room3.addItemsArrayList(itemKnife);
        room3.addItemsArrayList(itemSword);
        room3.addItemsArrayList(itemAxe);
        room7.addItemsArrayList(itemWashboard);
        room2.addItemsArrayList(itemApple);
        room2.addItemsArrayList(itemMeat);
        room4.addItemsArrayList(itemBanana);
        room7.addItemsArrayList(itemProteinBar);
        room8.addItemsArrayList(jarOfHoney);


    }

    public void buildAndPlaceEnemies() {
        //Monster Items
        Item enemyItem1 = new MeleeWeapon("Rapier", "An elegant rapier.", 5, 1000);
        Item enemyItem2 = new RangedWeapon("Bow", "Sweet jesus is big", 10, 2);
        Item enemyItem3 = new RangedWeapon("Handgranade", "Its very holy", 20, 1);
        Item enemyItem4 = new MeleeWeapon("Mattress", "Its super cheap", - 5, 1000);
        Item enemyItem5 = new RangedWeapon("Blaster", "Hard to hit with", 0, 10);
        Item enemyItem6 = new MeleeWeapon("The Bee Stinger", "if you are allergic you die", 35, 1000);
        Item enemyItem7 = new RangedWeapon("The portalgun", "It is missing fluid", 10, 3);

        //Enemies with items
        Enemy enemy1 = new Enemy("Bob", 50, "Jose Mourinho", room2, (Weapon) enemyItem1); //new MeleeWeapon("Rapier", "", 10, 1000)
        enemy1.setWeaponEquipt(enemyItem1);// really wird but only this works !
        Enemy enemy2 = new Enemy("Legolas", 25, "only 42", room4, (Weapon) enemyItem2);
        enemy2.setWeaponEquipt(enemyItem2);
        Enemy enemy3 = new Enemy("Rabbit", 30, "get the holy handgrande", room4, (Weapon) enemyItem3);
        enemy3.setWeaponEquipt(enemyItem3);
        Enemy enemy4 = new Enemy("Lars Larsen", 75,"Han har et godt tilbud", room5, (Weapon) enemyItem4);
        enemy4.setWeaponEquipt(enemyItem4);
        Enemy enemy5 = new Enemy("Storm tropper", 30, "Not very scary", room6, (Weapon) enemyItem5);
        enemy5.setWeaponEquipt(enemyItem5);
        Enemy enemy6 = new Enemy("Bee", 10, "its a honey Bee ", room7, (Weapon) enemyItem6);
        enemy6.setWeaponEquipt(enemyItem6);
        Enemy enemy7 = new Enemy("Morty", 2, "Ohh jeeeee", room9,(Weapon) enemyItem7);
        enemy7.setWeaponEquipt(enemyItem7);

        // enemy1.setWeaponEquipt((Weapon) itemAxe); //DOJ


        room2.addEnemyArrayList(enemy1);
        room4.addEnemyArrayList(enemy2);
        room4.addEnemyArrayList(enemy3);
        room5.addEnemyArrayList(enemy4);
        room6.addEnemyArrayList(enemy5);
        room7.addEnemyArrayList(enemy6);
        room9.addEnemyArrayList(enemy7);
    }
}
