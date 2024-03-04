package org.example;

// Den class er beregnet til at oprette "Rooms"

public class Room {

    //*** ATTRIBUTES ***//
    // Et Room har følgende egenskaber (attributes) et navn (String), En beskrivelse og fire forbindelser (Room).
    // Angiv de nødvendige attributes

    private String roomName;  // roomNavn
    private String roomDescription;   // Skal indhold hvilke "Rooms" den er konktet til
    private Room roomDoorNorth;
    private Room roomDoorSouth;
    private Room roomDoorEast;
    private Room roomDoorWest;


    //*** CONSTRUCTOR ***//
    // når et Room objekt skabes, så gives det et navn (som argument), og en beskrivelse - det er det eneste.


    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.roomDoorNorth = null;
        this.roomDoorSouth = null;
        this.roomDoorEast = null;
        this.roomDoorWest = null;
    }

    // getter Methods

    public String getRoomName() {
        return roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    // this getter methods is used to check if it is okay go into the room. The value will either be a room or null

    public Room getRoomDoorNorth() {
        return roomDoorNorth;
    }

    public Room getRoomDoorSouth() {
        return roomDoorSouth;
    }

    public Room getRoomDoorEast() {
        return roomDoorEast;
    }

    public Room getRoomDoorWest() {
        return roomDoorWest;
    }


    // Setter Methods

    public void setRoomDoorNorth(Room roomDoorNorth) {
        this.roomDoorNorth = roomDoorNorth;
    }

    public void setRoomDoorSouth(Room roomDoorSouth) {
        this.roomDoorSouth = roomDoorSouth;
    }

    public void setRoomDoorEast(Room roomDoorEast) {
        this.roomDoorEast = roomDoorEast;
    }

    public void setRoomDoorWest(Room roomDoorWest) {
        this.roomDoorWest = roomDoorWest;
    }

//MMH Methods to connect description to the rooms

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
}
