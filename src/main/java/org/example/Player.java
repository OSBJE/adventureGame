package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Player extends Character {


    ///********** Player inventory and equiped weapon slot holders *************////////
    ArrayList<Item> playerInventory = new ArrayList<>();
    Weapon equiped = null;


    //****************** ATTRIBUTES **************************************************//
    private Room currentRoom;
    private double healthPlayer;


    // ***************** Constructor *********************************************** ///
    public Player(Room room, double healthPlayer, String name, double healthScore) {
        super(name, healthScore);
        currentRoom = room;
        this.healthPlayer = healthPlayer; //Health angives ved skabelsen af playerobjekt. Dette kan ses i Controller.
    }


    /// ************************* Getter methods **********************************////
    public double getHealthPlayer() { //hente playerHealth
        return healthPlayer;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String getPlayerEquiped() {
        String equiped2 = " ";
        if (equiped != null) {
            equiped2 = equiped.toString();
            return equiped2;
        }
        return equiped2;
    }

    // --- Method to get inventory --- //
    public String getPlayerInventory() {
        String playerInventoryList = "";
        for (int i = 0; i <= playerInventory.size() - 1; i++) {
            playerInventoryList += playerInventory.get(i).toString();
        }
        return playerInventoryList;
    }

    // --- method to UI navigating shots --- //
    public int getRemainingShots() {
        if (isAnythingEquipped()) {
            int remainingShots = equiped.getWeaponShoots();
            return remainingShots;
        }
        return 0;
    }

    /// ************************* Setter methods **********************************////
    public void setHealthPlayer(double healthPlayer) { //setter til damage eller healthregain  fra indtagelse af food.
        this.healthPlayer = healthPlayer; //Health angives ved skabelsen af playerobjekt. Dette kan ses i Controller.
    }


    /// *********************** Player navigation **********************************////

    // ---Vælger hvilket room player går ind i ---//
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

    // --- Method to handle String direction inputs --- //
    public int playerDirection(String input) {

        final HashMap<String, Integer> WORDMAP = new HashMap<>();

        WORDMAP.put("north", 1);
        WORDMAP.put("south", 2);
        WORDMAP.put("east", 3);
        WORDMAP.put("west", 4);

        List<Integer> result = WORDMAP.entrySet().stream().filter(e -> e.getKey().startsWith(cleanInput(input))).map(HashMap.Entry::getValue).collect(Collectors.toList());
        if (result.size() == 1) {
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

    // --- Helper til navigations input ---//
    private static String cleanInput(String input) {
        input = input.toLowerCase();
        if (input.startsWith("go ")) {
            input = input.substring(input.indexOf(" ") + 1);
        }
        return input;
    }

    /// ******************* Player inventory management and equip functions *************////

    // --- method to take item ---//
    public String takeItem(String chosenItem) {
        String result = "takeNotPossible";
        for (Item item : currentRoom.getitemsArrayList()) {
            if (item.getItem().equalsIgnoreCase(chosenItem)) {
                currentRoom.removeItemsArrayList(item);
                playerInventory.add(item);
                result = "takeOkay";
                break;
            }
        }
        return result;
    }

    // --- method to drop item ---//
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

    // --- method to equip item from inventory --- //
    public String equipWeapon(String input) {
        String result = "notWeapon";
        Item checkInventory = playerInventory.stream().filter(Item -> input.equals(Item.getItem().toLowerCase())).findAny().orElse(null);
        if (checkInventory instanceof Weapon) {
            playerInventory.remove(checkInventory);
            equipWeaponCheck();
            equiped = (Weapon) checkInventory;
            result = "weaponOkay";
        }
        return result;
    }

    // --- helper method to unequip weapon --- //
    public void equipWeaponCheck() {
        if (equiped != null) {
            playerInventory.add(equiped);
        }
    }

    ///*************************** Player eat Items **************************************////


    // --- metode der checker om det kan spises --- //
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


    ///*************************** Player combat management ********************************////


    // --- Player Attack random enemy --- //
    public void attackRandom() { // Vi angriber ud i luften. Denne handling hopper på nærmeste enemy.
            currentRoom.sortArrayListEnemy();
            Enemy enemy = currentRoom.getEnemyArrayList().getFirst();
            attackEnemy(enemy);


    }

    // --- Player Attack specific enemy  --- //
    public void attackEnemy(Enemy enemy) { //DOJ Ny metode der tager enemy som input
        equiped.attack(); //Depleter vores skud i RangedWeapon
        int damage = equiped.getWeaponDmg();
        double result = enemy.getHealthscore() - damage;
        enemy.setHealthscore(result);

        enemy.attackPlayer(this);
        enemy.enemyDies(enemy);

        //int depleteMonsterHealth = weaponItem.getWeaponDmg()-getMonsterHealth(); Vi gemmer resultatet af våbenskade og nuværende monster health i en variabel.

        //setMonsterHealth(depleteMonsterHealth); Vi sætter monsterets nye health med ovenstående variabel.

        //Herfra kræver funktionen vores monster objekt(er). Logikken her er, at vi laver en settermetode på vores monstre.


    }

    // --- helper method to check equiped weapon --- // ----> might recode and delete
    public boolean isAnythingEquipped() {
        return equiped != null;
    }

}





