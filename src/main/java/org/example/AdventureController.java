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


    ///////************** Players movement  *********** ////////

    public void moveRoom(int input){
        player.moveRoom(input);
    }

    public int playerDirection(String input){
        return player.playerDirection(input);
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



    ///////************** Hjælpe funktion til at håndtere inputs  *********** ////////

    public String cleanItemInput (String userInput) {
        String cleanInput = player.cleanItemInput(userInput);
        return cleanInput;
    }

}
