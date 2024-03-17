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

    ///////************** Player health management  *********** ////////
    public double getHealthPlayer() { //hente playerHealth
        return player.getHealthPlayer();
    }
    public void setHealthPlayer(double healthPlayer) { //setter til damage eller healthregain  fra indtagelse af food.
        player.setHealthPlayer(healthPlayer);
    }
    public void playerEatsFood(String input) {
        player.playerEatsFood(input);
    }

    public String getRoomsArrayList () {
        return player.getCurrentRoom().getRoomsArrayListWithDescription();
    }

    public boolean eatableItemMethod(String itemToCheck){
        return player.eatableItem(itemToCheck);
    }



    ///////************** Hjælpe funktion til at håndtere inputs  *********** ////////

    public String cleanItemInput (String userInput) {
        String cleanInput = player.cleanItemInput(userInput);
        return cleanInput;
    }

    //------Testing----------------------------------------------------------------------

    public String getPlayerEquiped (){
        return player.getPlayerEquiped();
    }

    public void setEquipedWeapon (String input) {
        player.equipWeapon(input);
    }

    public void attackP() {
        player.attackP();
    }
    public boolean doIHaveWeaponEquipped() {
        return player.isAnythingEquipped();
    }
    public int getRemainingShots() {
        return player.getRemainingShots();
    }

    //------------------------------------------------------------------------------------


}
