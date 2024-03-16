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
    public void movePlayer(String playerDirection) {

        switch (playerDirection) {
            case "north" -> {
                if (currentRoom.getRoomDoorNorth() != null) {
                    currentRoom = currentRoom.getRoomDoorNorth();
                }
            }
            case "south" -> {
                if (currentRoom.getRoomDoorSouth() != null) {
                    currentRoom = currentRoom.getRoomDoorSouth();
                }
            }
            case "east" -> {
                if (currentRoom.getRoomDoorEast() != null) {
                    currentRoom = currentRoom.getRoomDoorEast();
                }
            }
            case "west" -> {
                if (currentRoom.getRoomDoorWest() != null) {
                    currentRoom = currentRoom.getRoomDoorWest();
                }

            }
        }
    }

    public void takeItem(String chosenItem) {
        for (Item item : currentRoom.getitemsArrayList()) {
            if (item.getItem().equalsIgnoreCase(chosenItem)) {
                currentRoom.removeItemsArrayList(item);
                playerInventory.add(item);
                break;//denne laves om, så vi kan få UI tekst, hvis item ikke er i rum
            }
        }
    }

    public void dropItem(String chosenItem) {
        for (Item item : playerInventory) {
            if (item.getItem().equalsIgnoreCase(chosenItem)) {
                currentRoom.addItemsArrayList(item);
                playerInventory.remove(item);
                break;
            }
        }
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
    public String playerEatsFood(String input) {

        ArrayList<Item> itemsToCheck = new ArrayList<>();
        String result = "";

        for (Item item : currentRoom.getitemsArrayList()) {
            if (item.getItem().equalsIgnoreCase(input)) {
                itemsToCheck.add(item);
            }
        }
        for (Item item : playerInventory) {
            if (item.getItem().equalsIgnoreCase(input)) {
                itemsToCheck.add(item);
            }
        }
        if (itemsToCheck.isEmpty()) {
            result = "foodNotAvailable";
        } else {
            boolean isFood = false;
            for (Item item : itemsToCheck) {
                if (item instanceof Food) {
                    Food foodItem = (Food) item;
                    double healthGain = foodItem.getHealthGain();
                    setHealthPlayer(getHealthPlayer() + healthGain);
                    result = "foodOkay";
                    isFood = true;
                    if (currentRoom.getitemsArrayList().contains(item)) {
                        currentRoom.removeItemsArrayList(item);
                    }

                    if (playerInventory.contains(item)) {
                        playerInventory.remove(item);
                    }
                    break;
                }
            }
            if (!isFood) {
                result = "notFood";
            }

        }
        return result;
    }



    /// overstående metoder har vi fået fra Lucas nedstående virker ////


    public String cleanItemInput(String input) {
        String[] navnearray = input.split(" ");
        String output = navnearray[1];
        return output;
    }
}


