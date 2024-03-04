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
    }

    // getter Methods


    // Setter Methods

    public void setRoomDoorNorth(Room roomDoorNorth){
        this.roomDoorNorth = roomDoorNorth;
    }

    public void setRoomDoorSouth(Room roomDoorSouth){
        this.roomDoorSouth = roomDoorSouth;
    }

    public void setRoomDoorEast(Room roomDoorEast){
this.roomDoorEast
    }








    // Beskrivelse constructor til at oprette rooms in vores spil

}
