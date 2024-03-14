package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {

    //*** ATTRIBUTES ***//
    // Vi skal lave en current af vores map


    private Room currentRoom;

    private double healthPlayer;

    public Room getCurrentRoom() {
        return currentRoom;
    }


    // Constructor ///
    public Player(Room room, double healthPlayer) {
        currentRoom = room;
        this.healthPlayer = healthPlayer; //Health angives ved skabelsen af playerobjekt. Dette kan ses i Controller.
    }

    public double getHealthPlayer() { //hente playerHealth
        return healthPlayer;
    }

    public void setHealthPlayer(double healthPlayer) { //setter til damage eller healthregain  fra indtagelse af food.
        this.healthPlayer = healthPlayer; //Health angives ved skabelsen af playerobjekt. Dette kan ses i Controller.
    }


    // Player variable til brug i methode //

    ArrayList<Item> playerInventory = new ArrayList<>();


    // Player Health Bar//


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


    /// de to nedstående metoder har vi fået af lucas, vi skal teste om de virker ///
    public ArrayList<Item> takeItemMethod(String name) {
        ArrayList<Item> itemsCopy = new ArrayList<>(currentRoom.getitemsArrayList());
        for (Item item : itemsCopy) {
            if (item.getItem().equalsIgnoreCase(name)) {
                playerInventory.add(item);
                currentRoom.removeItemsArrayList(item);

                return playerInventory;
            }
        }
        return playerInventory;
    }


    public ArrayList<Item> dropItemMethod(String name) {
        ArrayList<Item> itemsCopy = new ArrayList<>(playerInventory);
        for (Item item : itemsCopy) {
            if (item.getItem().equalsIgnoreCase(name)) {
                currentRoom.addItemsArrayList(item);
                playerInventory.remove(item);
                return playerInventory;

            }
        }
        return playerInventory;
    }

    public String getPlayerInventory() {
        String playerInventoryList = "";
        for (int i = 0; i <= playerInventory.size() - 1; i++) {
            playerInventoryList += playerInventory.get(i).toString();
        }
        return playerInventoryList;
    }


    ////************** Player eat Items ************************/////////


    // metode der checker om det kan spises //
    public void playerEatsFood(String input) {
        // tjekker om givne item er i rummet.
        for (Item item : currentRoom.getitemsArrayList()) {
            if (item.getItem().equalsIgnoreCase(input)) {
                if (item instanceof Food) {
                    Food foodItem = (Food) item;
                    double healthGain = foodItem.getHealthGain();

                    setHealthPlayer(getHealthPlayer() + healthGain);

                    currentRoom.removeItemsArrayList(item);

                    break;
                }
            }
        }
        // tjekker om givne item er i playerinventory.
        for (Item item : playerInventory) {
            if (item.getItem().equalsIgnoreCase(input)) {
                if (item instanceof Food) {
                    Food foodItem = (Food) item;
                    double healthGain = foodItem.getHealthGain();

                    setHealthPlayer(getHealthPlayer() + healthGain);

                    playerInventory.remove(item);

                    break;
                }
            }
        }
    }


    /// overstående metoder har vi fået fra Lucas nedstående virker ////


    public String cleanItemInput(String input) {
        String[] navnearray = input.split(" ");
        String output = navnearray[1];
        return output;
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


