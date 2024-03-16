package org.example;

import java.util.ArrayList;

public class AdventureController {


    // Her kalder vi de forskellige instancer af vores class

    private Map map;
    private Player player;



    // Det her er vores konstroktor

    public AdventureController() {
        map = new Map();
        player = new Player(map.getFirstRoom(), 50);
    }


    //////*********** Map ******************** ///////
    // At kalde den her funktion bygger vores kort.

    public String getCurrentRoom() { //Room name
        return player.getCurrentRoom().getRoomName();
    }
    public String getCurrentRoomDescription() {
        return player.getCurrentRoom().getRoomDescription();
    }


    ///////************** Players movement  *********** ////////

    public void movePlayer(String playerDirection){
        player.movePlayer(playerDirection);
    }


    ///////************** Item handling between room and player inventory  *********** ////////

    public void takeItemMethod (String input) {
        player.takeItem(input);
    }

    public void dropItemMethod (String input) {
        player.dropItem(input);
    }

    public ArrayList<Item> getitemsArrayList (){  //Returnerer assignede items, der er forbundet med rummene.
        return player.getCurrentRoom().getitemsArrayList();
    }

    public String getPlayerInventory () { // returnere ting i player inventory
        return player.getPlayerInventory();
    }

    ///////************** Player health management  *********** ////////
    public double getHealthPlayer() { //hente playerHealth
        return player.getHealthPlayer();
    }
    public void setHealthPlayer(double healthPlayer) { //setter til damage eller healthregain  fra indtagelse af food.
        player.setHealthPlayer(healthPlayer);
    }
    public String playerEatsFood(String input) {
        String foodOrNoFood = player.playerEatsFood(input);
        return foodOrNoFood;
    }

}
