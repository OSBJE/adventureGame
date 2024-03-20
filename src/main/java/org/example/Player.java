package org.example;

import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Player extends Character {

    // Player variable til brug i methode //

    ArrayList<Item> playerInventory = new ArrayList<>();

    // equiped Weapon ////
    Weapon equiped = null;


    //*** ATTRIBUTES ***//
    // Vi skal lave en current af vores map


    private Room currentRoom;
    private double healthPlayer;

    public Room getCurrentRoom() {
        return currentRoom;
    }


    // Constructor ///
    public Player(Room room, double healthPlayer, String name, double healthScore) {
        super(name, healthScore);
        currentRoom = room;
        this.healthPlayer = healthPlayer; //Health angives ved skabelsen af playerobjekt. Dette kan ses i Controller.
    }

    public double getHealthPlayer() { //hente playerHealth
        return healthPlayer;
    }

    public void setHealthPlayer(double healthPlayer) { //setter til damage eller healthregain  fra indtagelse af food.
        this.healthPlayer = healthPlayer; //Health angives ved skabelsen af playerobjekt. Dette kan ses i Controller.
    }



    //---------testing--------------------------------------------------------------------------------------------------------

    public String getPlayerEquiped () {
        String equiped2 = " ";
        if (equiped != null) {
            equiped2 = equiped.toString ();
                return equiped2;
            }
        return equiped2;
    }


    //------------------------------------------------------------------------------------------------------------------------

    // Det her er vores navigator (Compass) så vi kan gå rundt i vores spil //


    public void movePlayer(int compass) {
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

    /*
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

     */


    ///// Alternative method to handle play direction //////


    public int playerDirection (String input){

        final HashMap<String, Integer> WORDMAP = new HashMap<>();

        WORDMAP.put("north", 1);
        WORDMAP.put("south", 2);
        WORDMAP.put("east", 3);
        WORDMAP.put("west", 4);

        List<Integer> result = WORDMAP.entrySet().stream().filter(e -> e.getKey().startsWith(cleanInput(input))).map(HashMap.Entry::getValue).collect(Collectors.toList());
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
    }

    //// Player item liste ////


    public String takeItem(String chosenItem){
        String result = "takeNotPossible";
        for (Item item : currentRoom.getitemsArrayList()){
            if (item.getItem().equalsIgnoreCase(chosenItem)){
                currentRoom.removeItemsArrayList(item);
                playerInventory.add(item);
                result = "takeOkay";
                break;
            }
        }
        return result;
    }



    public String dropItem(String chosenItem) {
        String result = "dropNotPossible";
        for (Item item : playerInventory) {
            if (item.getItem().equalsIgnoreCase(chosenItem)) {
                currentRoom.addItemsArrayList(item);
                playerInventory.remove(item);
                result = "dropOkay";
                break;
            }
        }
        return result;
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



    /// Player Attack action ///
    public void attackP() { // Vi angriber ud i luften. Denne handling hopper på nærmeste enemy.
        if(isAnythingEquipped()) {
           currentRoom.sortArrayListEnemy();
           Enemy enemy = currentRoom.getEnemyArrayList().getFirst();
           attackEnemy(enemy);

        }
    }

    public void attackEnemy(Enemy enemy) { //DOJ Ny metode der tager enemy som input
        if(isAnythingEquipped()) { //Ændre til at lede efter valid enemy.
            equiped.attack(); //Depleter vores skud i RangedWeapon
            int damage = equiped.getWeaponDmg();
            double result = enemy.getHealthscore()-damage;
            enemy.setHealthscore(result);

            enemy.attackPlayer(this);
            enemy.enemyDies(enemy);

            //int depleteMonsterHealth = weaponItem.getWeaponDmg()-getMonsterHealth(); Vi gemmer resultatet af våbenskade og nuværende monster health i en variabel.

            //setMonsterHealth(depleteMonsterHealth); Vi sætter monsterets nye health med ovenstående variabel.

            //Herfra kræver funktionen vores monster objekt(er). Logikken her er, at vi laver en settermetode på vores monstre.

        }
    }



    public int getRemainingShots() {
        if(isAnythingEquipped()) {
            int remainingShots = equiped.getWeaponShoots();
                return remainingShots;
                }
        return 0;
    }


    public boolean isAnythingEquipped() {
        return equiped != null;
    }

    /// Player equip item to attack with ////


    public void equipWeapon (String input){
        Item checkInventory =  playerInventory.stream().filter(Item -> input.equals(Item.getItem().toLowerCase())).findAny().orElse(null);
       if (checkInventory instanceof Weapon) {
           playerInventory.remove(checkInventory);
           equipWeaponCheck();
           equiped = (Weapon) checkInventory;
       }
    }

    //---This function helps check and add back the weapon equip to player inventory.
    public void equipWeaponCheck () {
        if (equiped != null){
            playerInventory.add(equiped);
        }
    }




    /*public void equipWeapon(String input) {
        Iterator<Item> iterator = playerInventory.iterator();
        while (iterator.hasNext()) {
            Item Item = iterator.next();
            if (Item.getItem().equals(input)){
                playerInventory.remove(Item);
                equiped.add(Item);

                System.out.println(Item + "Has been equiped");
                break;
            }
        }
    }*/

    /*
    public void equipWeapon (String input) {
        for (Item item : playerInventory){
            if(item.getItem().equals(input)){
                playerInventory.remove(item);
                equiped[0] = item;
                break;
            }
        }
    }
    */


    /// overstående metoder har vi fået fra Lucas nedstående virker ////

    /*
    public void isEnemyDead(Enemy enemy) {
        if (enemy.getHealthscore() <= 0){
            dropWeapon(enemy);
            currentRoom.removeEnemyArrayList(enemy);
        }
    }

    // get enemyWeapon.
    public void dropWeapon(Enemy enemy) {
        Item toDrop = enemy.getWeaponEquipt();
        currentRoom.addItemsArrayList(toDrop);
    }*/


    public String cleanItemInput(String input) {
        String[] navnearray = input.split(" ");
        String output = navnearray[1];
        return output;
    }

}





