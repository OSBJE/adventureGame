package org.example;

public class Map {
    //*** ATTRIBUTES ***//
    // Et kort af "Rooms" har et Room, som det laves på baggrund af.

    RoomCreator startRoom;


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

        RoomCreator room1 = new RoomCreator("Room 1", " is a beautiful green hill with a nice view.");
        RoomCreator room2 = new RoomCreator("Room 2", " is a dark cave with a thousand bats. Watch out!!!");
        RoomCreator room3 = new RoomCreator("Room 3", " is a cold icy mountain.");
        RoomCreator room4 = new RoomCreator("Room 4", " is a wooden cottage that is about to collapse. Watch out!!!.");
        RoomCreator room5 = new RoomCreator("Room 5", " is a warm and cozy fireplace.");
        RoomCreator room6 = new RoomCreator("Room 6", " is an erupting volcano...watch out for the burning lava!!!");
        RoomCreator room7 = new RoomCreator("Room 7", " is a noisy metropolis with polluting traffic.");
        RoomCreator room8 = new RoomCreator("Room 8", " is an olive grove with butterflies.");
        RoomCreator room9 = new RoomCreator("Room 9", " is a battlefield from World War 1. \nKeep your head down, so you don't get hit!.");

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

    }

    public RoomCreator getFirstRoom() {
        return startRoom;
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
