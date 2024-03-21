package org.example;

import java.util.ArrayList;

public class AdventureController {


    ///********** Generate our Map and connect to Player *************************///

    private Map map;
    private Player player;


    // ***************** Constructor ******************************************** ///

    public AdventureController() {
        map = new Map();
        player = new Player(map.getFirstRoom(), 50);
    }


    /// *********************** Player navigation *******************************///

    public void movePlayer(String playerDirection){
        player.movePlayer(getPLayerDirection(playerDirection));
    }

    public int getPLayerDirection(String playerInput){
        return player.playerDirection(playerInput);
    }


    /// *********************** Map functions **********************************///

    // --- Helper function give Player current room --- //
    public String getCurrentRoom() { //Room name
        return player.getCurrentRoom().getRoomName();
    }
    public String getCurrentRoomDescription() {
        return player.getCurrentRoom().getRoomDescription();
    }

    // --- Helper function to look in room and see enemies --- //
    public ArrayList<Enemy> getEnemyArrayList() {
        return player.getCurrentRoom().getEnemyArrayList();
    }

    // --- Helper function to look in room and see items --- //
    public ArrayList<Item> getitemsArrayList (){  //Returnerer assignede items, der er forbundet med rummene.
        return player.getCurrentRoom().getitemsArrayList();
    }


    /// ************** Item handling between room and player inventory  *********** ///

    // --- Methods to handlings items --- //
    public String takeItemMethod (String input) {
        return player.takeItem(input);
    }

    public String dropItemMethod (String input) {
        return player.dropItem(input);
    }

    // --- getter to get overview of Inventory --- //
    public String getPlayerInventory () { // returnere ting i player inventory
        return player.getPlayerInventory();
    }

    // --- Methods to equip items --- //
    public String setEquipedWeapon (String input) {
        return player.equipWeapon(input);
    }

    // --- getter to see equiped weapon --- //
    public String getPlayerEquiped (){
        return player.getPlayerEquiped();
    }


    /// ************************* Player health management  ************************ ///
    public double getHealthPlayer() { //hente playerHealth
        return player.getHealthPlayer();
    }

    public String playerEatsFood(String input) {
        String foodOrNoFood = player.playerEatsFood(input);
        return foodOrNoFood;
    }


    /// ************************* Player health management  ************************ ///

    // --- Methods to attach Enenmy --- //
    public void attackRandom() {
        player.attackRandom();
    }

    public void attackEnemy(Enemy enemy) {
        player.attackEnemy(enemy);
    }

    // --- Helper to see if we have equiped weapon --- //
    public boolean doIHaveWeaponEquipped() {
        return player.isAnythingEquipped();
    }

    // --- Helper to get see if we have shoots to use for attack --- //
    public int getRemainingShots() {
        return player.getRemainingShots();
    }

}
