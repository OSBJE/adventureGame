package org.example;

import java.util.Scanner;

public class Game {
    //*** ATTRIBUTES ***//
    // Et kort af "Rooms" har et Room, som det laves på baggrund af.

    // Scanner input = new Scanner();

    private Room current;

    //*** Constructor *** //
    // Når et spil startes, kalder den sin metode buildGame.
    // kald metoden i constructor

    public Game() {
        buildGame();
    }


    //*** Methods ***//
    // Nedståden metode bygger vores "rooms map"
    //

    public void buildGame(){
        // vi starter med at lave 9 room objkter, et som repræsentere hver room i vores spil
        //

        Room room1 = new Room("Room 1", "connected to room2 og room4");
        Room room2 = new Room("Room 2", "Connected to room1 og room3");
        Room room3 = new Room("Room 3", "Connected to room2 og room6");
        Room room4 = new Room("Room 4", "Connected to room1 og room7");
        Room room5 = new Room("Room 5", "Connected to room8 ");
        Room room6 = new Room("Room 6", "Connected to room3 og room9 ");
        Room room7 = new Room("Room 7", "Connected to room4 og room8 ");
        Room room8 = new Room("Room 8", "Connected to room5, room7 og room9 ");
        Room room9 = new Room("Room 9", "Connected to room6 og room8 ");

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

        // Her starter vi vores spil

        current = room1;

    }

    public String getCurrentRoom() {
        return current.getRoomName();
    }
    //MMH getter for at kunne kalde metoden med beskrivelser i Room
    public Room getCurrent(){
        return current;
    }


    // Det her er vores navigator (Compass) så vi kan gå rundt i vores spil


    public void moveRoom (int compass){
        switch (compass) {
            case 1: // North room
                if (current.getRoomDoorNorth() != null) {
                    current = current.getRoomDoorNorth();
                }
                break;
            case 2: // South Room
                if (current.getRoomDoorSouth() != null){
                    current = current.getRoomDoorSouth();
                }
                break;
            case 3: // East Room
                if (current.getRoomDoorEast() != null){
                    current = current.getRoomDoorEast();
                }
                break;
            case 4: // West Room
                if (current.getRoomDoorWest() != null){
                    current = current.getRoomDoorWest();
                }
                break;
        }
    }
}
