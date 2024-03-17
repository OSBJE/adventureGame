package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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


    // equiped Weapon ////
    Item[] equiped = new Item[1];

    //ArrayList<Item> equiped = new ArrayList<>();


    //---------testing--------------------------------------------------------------------------------------------------------

    public String getPlayerEquiped () {
        String equiped2 = " ";
        if (equiped[0] != null) {
            for (int i = 0; i <= equiped.length - 1; i++) {
                equiped2 = equiped[i].toString();
                return equiped2;
            }
        }
        return equiped2;
    }


    //------------------------------------------------------------------------------------------------------------------------

    // Det her er vores navigator (Compass) så vi kan gå rundt i vores spil //


    public void moveRoom(int compass) {
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


    public void takeItem(String chosenItem) {
        for (Item item : currentRoom.getitemsArrayList()) {
            if (item.getItem().equalsIgnoreCase(chosenItem)) {
                currentRoom.removeItemsArrayList(item);
                playerInventory.add(item);
                break;
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

    public String getPlayerInventory () {
        String playerInventoryList = "";
        for (int i = 0; i <= playerInventory.size() -1; i++) {
            playerInventoryList += playerInventory.get(i).toString();
        }
        return playerInventoryList;
    }


    ////************** Player eat Items ************************/////////



    // metode der checker om det kan spises //
    public void playerEatsFood(String input) {
        // tjekker om givne item er i rummet.
        for (Item item : currentRoom.getitemsArrayList()) {
            if (item.getItem().equalsIgnoreCase(input)) {
                if (item instanceof Food) {
                    Food foodItem = (Food) item;
                    double healthGain = foodItem.getHealthGain();

                    setHealthPlayer(getHealthPlayer() + healthGain);

                    currentRoom.removeItemsArrayList(item);

                    break;
                }
            }
        }
        // tjekker om givne item er i playerinventory.
        for (Item item : playerInventory) {
            if (item.getItem().equalsIgnoreCase(input)) {
                if (item instanceof Food) {
                    Food foodItem = (Food) item;
                    double healthGain = foodItem.getHealthGain();

                    setHealthPlayer(getHealthPlayer() + healthGain);

                    playerInventory.remove(item);

                    break;
                }
            }
        }
    }
    public boolean eatableItem(String itemToCheck) {
        for (Item item : currentRoom.getitemsArrayList()) {
            if (item.getItem().equalsIgnoreCase(itemToCheck)) {
                if (item instanceof Food) {
                    return true;
                }

            }
        }
        return false;
    }

    /// Player Attack action ///
    public void attackP() {
        if(isAnythingEquipped()) {
            for(Item item : equiped) {
                if(item instanceof Weapon) {
                    Weapon weaponItem = (Weapon) item;
                    weaponItem.attack(); //Depleter vores skud i RangedWeapon
                    //int depleteMonsterHealth = weaponItem.getWeaponDmg()-getMonsterHealth(); Vi gemmer resultatet af våbenskade og nuværende monster health i en variabel.

                    //setMonsterHealth(depleteMonsterHealth); Vi sætter monsterets nye health med ovenstående variabel.

                    //Herfra kræver funktionen vores monster objekt(er). Logikken her er, at vi laver en settermetode på vores monstre.


                    break;
                }
            }
        }
    }
    public int getRemainingShots() {
        if(isAnythingEquipped()) {
            for(Item item : equiped) {
                if(item instanceof Weapon weaponItem ) {
                    int remainingShots = weaponItem.getWeaponShoots();
                    return remainingShots;
                }
            }
        }
        return 0;
    }
    public boolean isAnythingEquipped() {
        return equiped[0] != null;
    }

    /// Player equip item to attack with ////


    public void equipWeapon (String input){
       Item checkInventory =  playerInventory.stream().filter(Item -> input.equals(Item.getItem())).findAny().orElse(null);
       if (checkInventory instanceof Weapon) {
           playerInventory.remove(checkInventory);
           equipWeaponCheck();
           equiped[0] = checkInventory;
       }
        Item checkRoom =  currentRoom.getitemsArrayList().stream().filter(Item -> input.equals(Item.getItem())).findAny().orElse(null);
        if (checkRoom instanceof Weapon) {
            currentRoom.getitemsArrayList().remove(checkRoom);
            equipWeaponCheck();
            equiped[0] = checkRoom;
        }
    }

    //---This function helps check and add back the weapon equip to player inventory.
    public void equipWeaponCheck () {
        if (equiped[0] != null){
            playerInventory.add(equiped[0]);
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


    public String cleanItemInput(String input) {
        String[] navnearray = input.split(" ");
        String output = navnearray[1];
        return output;
    }
}





