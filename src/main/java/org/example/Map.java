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
        // vi starter med at lave 9 room objkter, et som repræsentere hver room i vores spil
        //

        Room room1 = new Room("Room 1", "This is a beautiful green hill with a nice view.");
        Room room2 = new Room("Room 2", "This is a dark cave with a thousand bats. Watch out!!!");
        Room room3 = new Room("Room 3", "This is a cold icy mountain.");
        Room room4 = new Room("Room 4", "This is a wooden cottage that is about to collapse. Watch out!!!.");
        Room room5 = new Room("Room 5", "This is a warm and cozy fireplace.");
        Room room6 = new Room("Room 6", "This is an erupting volcano...watch out for the burning lava!!!");
        Room room7 = new Room("Room 7", "This is a noisy metropolis with polluting traffic.");
        Room room8 = new Room("Room 8", "This is an olive grove with butterflies.");
        Room room9 = new Room("Room 9", "This is a battlefield from World War 1. \nKeep your head down, so you don't get hit!.");

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


        Item itemKniv = new  Item("Kniv", "Magisk Grim");
        Item itemSværd = new Item("Sværd", "Det er stort");
        Item itemØkse = new Item("Økse", "Den hedder gimli");
        Item itemVaskebrædt = new Item("Vaskebrædt", "Husk at vasketøj");


        room3.addItemsArrayList(itemKniv);
        room3.addItemsArrayList(itemSværd);
        room3.addItemsArrayList(itemØkse);
        room7.addItemsArrayList(itemVaskebrædt);

    }

    public Room getFirstRoom() {
        return startRoom;
    }



    public void buildItems() {

        Item itemKniv = new  Item("Kniv", "Magisk Grim");
        Item itemsSværd = new Item("Sværd", "Det er stort");
        Item itemsØkse = new Item("Økse", "Den hedder gimli");
        Item itemsVaskebrædt = new Item("Vaskebrædt", "Husk at vasketøj");


    }

    //MMH Methods to connect description to the rooms
/*
    public String roomDescription(String roomName) {
        if (roomName.equals("Room 1")) {
            return roomName + " is a beautiful green hill with a nice view.";
        } else if (roomName.equals("Room 2")) {
            return roomName + " is a dark cave with a thousand bats. Watch out!!!";
        } else if (roomName.equals("Room 3")) {
            return roomName + " is a cold icy mountain.";
        } else if (roomName.equals("Room 4")) {
            return roomName + " is a wooden cottage that is about to collapse. Watch out!!!.";
        } else if (roomName.equals("Room 5")) {
            return roomName + " is a warm and cozy fireplace.";
        } else if (roomName.equals("Room 6")) {
            return roomName + " is an erupting volcano...watch out for the burning lava!!!";
        } else if (roomName.equals("Room 7")) {
            return roomName + " is a noisy metropolis with polluting traffic.";
        } else if (roomName.equals("Room 8")) {
            return roomName + " is an olive grove with butterflies.";
        } else {
            return roomName + " is a battlefield from World War 1. \nKeep your head down, so you don't get hit!.";
        }

    }
*/

}
