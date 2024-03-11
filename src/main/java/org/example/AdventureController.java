package org.example;

import java.util.ArrayList;

public class AdventureController {


    // Her kalder vi de forskellige instancer af vores class

    private Map map;
    private Player player;




    // Det her er vores konstroktor

    public AdventureController() {
        map = new Map();
        player = new Player(map.getFirstRoom());
    }


    //////*********** Map ******************** ///////
    // At kalde den her funktion bygger vores kort.

    public void buildMap(){
        map.buildMap();
    }

    public String getCurrentRoom() { //Room name
        return player.getCurrentRoom().getRoomName();
    }
    public String getCurrentRoomDescription() {
        return player.getCurrentRoom().getRoomDescription();
    }


    ///////************** Players *********** ////////

    public void moveRoom(int input){
        player.moveRoom(input);
    }

    public int playerDirection(String input){
        return player.playerDirection(input);
    }
    public void addToPlayerInventory(Item item) { //Player inventory
        player.addToPlayerInventory(item);
    }
    public void dropItemFromInventory(String itemToRemove) {
        player.dropItemFromInventory(itemToRemove);
    }
    public void addItemsArrayList(Item item) {
        map.getFirstRoom().addItemsArrayList(item);
    }
    public void removeItemsArrayList(String itemToRemove) {
        map.getFirstRoom().removeItemsArrayList(itemToRemove);
    }
    public ArrayList<Item> getitemsArrayList (){  //Returnerer assignede items, der er forbundet med rummene.
        return player.getCurrentRoom().getitemsArrayList();
    }
    public void displayItemsInRoom() {
        player.getCurrentRoom().displayItemsInRoom();
    }




}
