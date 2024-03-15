package org.example;

public class Map {
    //*** ATTRIBUTES ***//
    // Et kort af "Rooms" har et Room, som det laves på baggrund af.



    private Room startRoom;
    private Item itemsList;


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

        Room room1 = new Room("Room 1", "This is a beautiful green hill with a nice view.");
        Room room2 = new Room("Room 2", "This is a dark cave with a thousand bats. Watch out!!!");
        Room room3 = new Room("Room 3", "This is a cold icy mountain.");
        Room room4 = new Room("Room 4", "This is a wooden cottage that is about to collapse. Watch out!!!");
        Room room5 = new Room("Room 5", "This is a warm and cozy fireplace.");
        Room room6 = new Room("Room 6", "This is an erupting volcano... watch out for the burning lava!!!");
        Room room7 = new Room("Room 7", "This is a noisy metropolis with polluting traffic.");
        Room room8 = new Room("Room 8", "This is an olive grove with butterflies.");
        Room room9 = new Room("Room 9", "This is a battlefield from World War 1. \nKeep your head down, so you don't get hit!");

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


        Item itemKnife = new MeleeWeapon("Knife", "Magic Grim", 10, 1000);
        Item itemSword = new Item("Sword", "It's a big sword");
        Item itemAxe = new Item("Axe", "Its name is gimli");
        Item itemWashboard = new Item("Washboard", "Remember to do your laundy");


        room3.addItemsArrayList(itemKnife);
        room3.addItemsArrayList(itemSword);
        room3.addItemsArrayList(itemAxe);
        room7.addItemsArrayList(itemWashboard);

        ///// Her laver vi mad og tilføjde dem til room ///
        Food itemApple = new Food("Apple", "from snowwhite", -25, true);
        Food itemMeat = new Food("Meat", "from cow", 25, false);
        Food itemBanana = new Food("Banana", "from minions", 15, false);
        Food itemProtienBar = new Food("Protien Bar", "from arnolds gym", 35, false);

        room2.addItemsArrayList(itemApple);
        room2.addItemsArrayList(itemMeat);
        room4.addItemsArrayList(itemBanana);
        room7.addItemsArrayList(itemProtienBar);

    }

    public Room getFirstRoom() {
        return startRoom;
    }


    public void buildItems() {

        Item itemKnife = new  Item("Knife", "Magic Grim");
        Item itemSword = new Item("Sword", "It's a big sword");
        Item itemAxe = new Item("Axe", "Its name is gimli");
        Item itemWashboard = new Item("Washboard", "Remember to do your laundy");
}
    public void buildFood() {
        Food itemApple = new Food("Apple", "from snowwhite", -25, true);
        Food itemMeat = new Food("Meat", "from cow", 25, false);
        Food itemBanana = new Food("Banana", "from minions", 15, false);
        Food itemProtienBar = new Food("Protien Bar", "from arnolds gym", 35, false);
    }

}
