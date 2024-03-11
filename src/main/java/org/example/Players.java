package org.example;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    //*** ATTRIBUTES ***//
    // Vi skal lave en current af vores map


    private Room currentRoom;

    public Room getCurrentRoom() {
        return currentRoom;
    }


    // Constructor ///
    public Players(Room room) {
        currentRoom = room;
    }


    // Player variable til brug i methode //

    ArrayList<Items> playerInventory = new ArrayList<>();


    // Det her er vores navigator (Compass) så vi kan gå rundt i vores spil //


    public void moveRoom(int compass) {
        switch (compass) {
            case 1: // North room
                if (currentRoom.getRoomDoorNorth() != null) {
                    currentRoom = currentRoom.getRoomDoorNorth();
                }
                break;
            case 2: // South Room
                if (currentRoom.getRoomDoorSouth() != null) {
                    currentRoom = currentRoom.getRoomDoorSouth();
                }
                break;
            case 3: // East Room
                if (currentRoom.getRoomDoorEast() != null) {
                    currentRoom = currentRoom.getRoomDoorEast();
                }
                break;
            case 4: // West Room
                if (currentRoom.getRoomDoorWest() != null) {
                    currentRoom = currentRoom.getRoomDoorWest();
                }
                break;
        }
    }


    //"Method to handle String direction inputs"//

    public int playerDirection(String str) {
        int direction = 0;
        int lng = str.length() - 1;
        String str2 = str.toLowerCase();

        for (int i = 0; i <= lng; i++) {
            if (str2.charAt(i) == 'n') {
                direction = 1;
                break;
            } else if (str2.charAt(i) == 's') {
                direction = 2;
                break;
            } else if (str2.charAt(i) == 'e') {
                direction = 3;
                break;
            } else if (str2.charAt(i) == 'w') {
                direction = 4;
                break;
            }
        }
        return direction;
    }

    //// Player item liste ////

    public void addToPlayerInventory(Items item) { // Metode til at tilføje items til player inventory.
        playerInventory.add(item);
    }


public void dropItemFromInventory(String itemToRemove) { //Metode til at fjerne items fra player inventory.
    for (Items searchItems : playerInventory) {
        if (searchItems.getItem().contains(itemToRemove)) {   //// Vi skal have en bedre metode en getItem til at fjerne fra liste.
            currentRoom.addItemsArrayList(searchItems); //Tilføjer den "dropped" item til det room, man er i.
            playerInventory.remove(searchItems);
        }
    }
}



    ///// Alternative method to handle play direction //////


    /*public int playDirectionAdvance (String input){

        final Map<String, Integer> WORDMAP = new HashMap<>();

        WORDMAP.put("north", 1);
        WORDMAP.put("south", 2);
        WORDMAP.put("east", 3);
        WORDMAP.put("west", 4);

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

    private static String cleanInput(String input) {
        input = input.toLowerCase();
        if (input.startsWith("go ")){
            input = input.substring(input.indexOf(" ")+1);
        }
        return input;
    }*/

}
