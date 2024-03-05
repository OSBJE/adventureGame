package org.example;
import java.util.*;
import java.util.stream.*;


public class Game {
    //*** ATTRIBUTES ***//
    // Et kort af "Rooms" har et Room, som det laves på baggrund af.

    // Scanner input = new Scanner();

    Room current;

    //*** Constructor *** //
    // Når et spil startes, kalder den sin metode buildGame.
    // kald metoden i constructor

    public Game() {
        buildGame();
    }


    //*** Methods ***//
    // Nedståden metode bygger vores "rooms map"
    //

    public void buildGame() {
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

    // Det her er vores navigator (Compass) så vi kan gå rundt i vores spil


    public void moveRoom(int compass) {
        switch (compass) {
            case 1: // North room
                if (current.getRoomDoorNorth() != null) {
                    current = current.getRoomDoorNorth();
                }
                break;
            case 2: // South Room
                if (current.getRoomDoorSouth() != null) {
                    current = current.getRoomDoorSouth();
                }
                break;
            case 3: // East Room
                if (current.getRoomDoorEast() != null) {
                    current = current.getRoomDoorEast();
                }
                break;
            case 4: // West Room
                if (current.getRoomDoorWest() != null) {
                    current = current.getRoomDoorWest();
                }
                break;
        }
    }


    //////// Method to handle String direction inputs ////////////

    public int playerDirection(String str) {
        int direction = 0;
        int lng = str.length()-1;
        String str2 = str.toLowerCase();

        for (int i = 0; i <= lng; i++) {
            if (str2.charAt(i) == 'n'){
                direction = 1;
                break;
            } else if (str2.charAt(i) == 's'){
                direction = 2;
                break;
            } else if (str2.charAt(i) == 'e'){
                direction = 3;
                break;
            } else if (str2.charAt(i) == 'w'){
                direction = 4;
                break;
            }
        }
        return direction;
    }

    ///// Alternative method to handle play direction //////


    public int playDirectionAdvance (String input){

        final Map<String, Integer> WORDMAP = new HashMap<>();

        WORDMAP.put("north", 1);
        WORDMAP.put("south", 2);
        WORDMAP.put("east",3);
        WORDMAP.put("west",4);

        List<Integer> result = WORDMAP.entrySet().stream().filter(e -> e.getKey().startsWith(cleanInput(input))).map(Map.Entry::getValue).collect(Collectors.toList());
        if(result.size() == 1){
            return result.get(0); // Det her er index. når det ikke er et array som bruger man get. Fordi det er en collection kalder man metode.
        }
        return 0;

        // Entry har en key og en value set er en list
        // stream er et API som er et filter google java streams det er noget man bruger for lister
            // når man laver et filter fravælger vi alle som ikke opfylder vores kriteri.
            // Lambda expression e -> e.getKey det er bare et variable
        // Map siger bare at vi få vores getvalue som er vores key in vores Hashmap
        // collect(Collectors.toList()) det er hjælpe class som samler resultatet. Den samler det et list.
    }

    public static String cleanInput(String input) {
        input = input.toLowerCase();
        if (input.startsWith("go ")){
            input = input.substring(input.indexOf(" ")+1);
        }
        return input;
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
