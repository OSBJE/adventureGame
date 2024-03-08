package org.example;

import java.util.ArrayList;

public class AdventureController {


    // Her kalder vi de forskellige instancer af vores class

    private Map map;
    private Players players;




    // Det her er vores konstroktor

    public AdventureController() {
        map = new Map();
        players = new Players(map.getFirstRoom());
    }


    //////*********** Map ******************** ///////
    // At kalde den her funktion bygger vores kort.

    public void buildMap(){
        map.buildMap();
    }

    public String getCurrentRoom() { //Room name
        return players.getCurrentRoom().getRoomName();
    }
    public String getCurrentRoomDescription() {
        return players.getCurrentRoom().getRoomDescription();
    }


    ///////************** Players *********** ////////

    public void moveRoom(int input){
        players.moveRoom(input);
    }

    public int playerDirection(String input){
        return players.playerDirection(input);
    }
    public void addToPlayerInventory(Items item) { //Player inventory
        players.addToPlayerInventory(item);
    }
    public void dropItemFromInventory(String itemToRemove) {
        players.dropItemFromInventory(itemToRemove);
    }
    public void addItemsArrayList(Items Item) {
        map.getFirstRoom().addItemsArrayList(Item);
    }
    public void removeItemsArrayList(String itemToRemove) {
        map.getFirstRoom().removeItemsArrayList(itemToRemove);
    }
    public ArrayList<Items> getitemsArrayList (){  // really nice Mette og Daniel //Returner
        return map.getFirstRoom().getitemsArrayList();
    }
    public void displayItemsInRoom() {
        players.getCurrentRoom().displayItemsInRoom();
    }




}
