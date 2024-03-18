package org.example;

public class Map {
    //*** ATTRIBUTES ***//
    // Et kort af "Rooms" har et Room, som det laves på baggrund af.


    private Room startRoom;
    private Item itemsList;
    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;
    private Room room6;
    private Room room7;
    private Room room8;
    private Room room9;


    //*** Constructor *** //
    // Når et spil startes, kalder den sin metode buildGame.
    // kald metoden i constructor

    public Map() {
        buildMap();
    }


    //*** Methods ***//
    // Nedståden metode bygger vores "rooms map"


    public void buildMap() {
        // vi starter med at lave 9 room objekter, et som repræsenterer hvert room i vores spil
        //

        this.room1 = new Room("Room 1", "This is a beautiful green hill with a nice view.");
        this.room2 = new Room("Room 2", "This is a dark cave with a thousand bats. Watch out!!!");
        this.room3 = new Room("Room 3", "This is a cold icy mountain.");
        this.room4 = new Room("Room 4", "This is a wooden cottage that is about to collapse. Watch out!!!");
        this.room5 = new Room("Room 5", "This is a warm and cozy fireplace.");
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

    }

    public Room getFirstRoom() {
        return startRoom;
    }


    public void buildAndPlaceItems() {


        Food itemApple = new Food("Apple", "from snowwhite", -15, true);
        Food itemMeat = new Food("Meat", "from cow", 25, false);
        Food itemBanana = new Food("Banana", "from minions", 10, false);
        Food itemProteinBar = new Food("ProteinBar", "from arnolds gym", 35, false);
        Item itemKnife = new MeleeWeapon("Knife", "Magic Grim", 10, 1000);
        Item itemSword = new MeleeWeapon("Sword", "It's a big sword", 10, 1000);
        Item itemAxe = new MeleeWeapon("Axe", "Its name is gimli", 20, 1000);
        Item itemWashboard = new RangedWeapon("Washboard", "Remember to do your laundy", 50, 2);


        room3.addItemsArrayList(itemKnife);
        room3.addItemsArrayList(itemSword);
        room3.addItemsArrayList(itemAxe);
        room7.addItemsArrayList(itemWashboard);
        room2.addItemsArrayList(itemApple);
        room2.addItemsArrayList(itemMeat);
        room4.addItemsArrayList(itemBanana);
        room7.addItemsArrayList(itemProteinBar);
    }


}
