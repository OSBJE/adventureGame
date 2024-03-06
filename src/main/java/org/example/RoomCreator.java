package org.example;

// Den class er beregnet til at oprette "Rooms"

public class RoomCreator {

    //*** ATTRIBUTES ***//
    // Et Room har følgende egenskaber (attributes) et navn (String), En beskrivelse og fire forbindelser (Room).
    // Angiv de nødvendige attributes

    private String roomName;  // roomNavn
    private String roomDescription;   // Skal indhold hvilke "Rooms" den er konktet til
    private RoomCreator roomDoorNorth;
    private RoomCreator roomDoorSouth;
    private RoomCreator roomDoorEast;
    private RoomCreator roomDoorWest;


    //*** CONSTRUCTOR ***//
    // når et Room objekt skabes, så gives det et navn (som argument), og en beskrivelse - det er det eneste.


    public RoomCreator(String roomName, String roomDescription) {
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

    public RoomCreator getRoomDoorNorth() {
        return roomDoorNorth;
    }

    public RoomCreator getRoomDoorSouth() {
        return roomDoorSouth;
    }

    public RoomCreator getRoomDoorEast() {
        return roomDoorEast;
    }

    public RoomCreator getRoomDoorWest() {
        return roomDoorWest;
    }


    // Setter Methods

    public void setRoomDoorNorth(RoomCreator roomDoorNorth) {
        this.roomDoorNorth = roomDoorNorth;
    }

    public void setRoomDoorSouth(RoomCreator roomDoorSouth) {
        this.roomDoorSouth = roomDoorSouth;
    }

    public void setRoomDoorEast(RoomCreator roomDoorEast) {
        this.roomDoorEast = roomDoorEast;
    }

    public void setRoomDoorWest(RoomCreator roomDoorWest) {
        this.roomDoorWest = roomDoorWest;
    }


}
