package org.example;

import java.util.ArrayList;

public class AdventureController {


    // Her kalder vi de forskellige instancer af vores class

    private Map map;
    private Player player;
    private Enemy enemy;



    // Det her er vores konstroktor

    public AdventureController() {
        map = new Map();
        player = new Player(map.getFirstRoom(), 50, "SuperPlayer", 100);
        //Blev nød til at indsætte lidt tekst for at få programmet til at spille.
        //Vi kommer til at bruge Player for meget - det Oskar sagde
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
        player.movePlayer(getPLayerDirection(playerDirection));
    }

    public int getPLayerDirection(String playerInput){
       return player.playerDirection(playerInput);
    }


    ///////************** Item handling between room and player inventory  *********** ////////

    public String takeItemMethod (String input) {
        return player.takeItem(input);
    }

    public String dropItemMethod (String input) {
        return player.dropItem(input);
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
    public void attackEnemy(Enemy enemy) {
        player.attackEnemy(enemy);
    }

    public ArrayList<Enemy> getEnemyArrayList() {
        return player.getCurrentRoom().getEnemyArrayList();
    }

    //------------------------------------------------------------------------------------


}
