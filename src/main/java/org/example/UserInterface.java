package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class UserInterface {
    Scanner input = new Scanner(System.in);

    // instance / laver et Game object
    // laver en nyt game

    AdventureController spil = new AdventureController();
    private String previousRoom;

    //MMH Vi kunne definere constructor og køre startGame herinde. Så skal metodekald af startGame slettes fra Main
    public UserInterface() {
        welcome();
        startAndPlayGame();
    }

    public void startAndPlayGame() {

        final String SENTINEL = "exit";
        String playerInput = " ";
        this.previousRoom = spil.getCurrentRoom();


        while (!playerInput.toLowerCase().equals(SENTINEL)) {
            if(isPlayerDead()) { //Hver iteration af while loop tjekkes players health. Hvis <= 0 breaker vi while loop, hvor brugeren får nogle sysout beskeder.
                playerisDeadMessageUI();
                break;
            }
            System.out.println("In what direction do you want to go: North, South, East og West?");
            System.out.println("Or type inventory, take, drop, eat, equip, attack, help, look or exit.");
            playerInput = input.nextLine();
            String[] inputArray = playerInputManipulation(playerInput);
            String firstWord = inputArray[0];
            String secondWord = inputArray[1];
            String playerInput3 = inputArray[2];


            switch (firstWord) {
                case "take" -> {
                    takeItemChoice(secondWord);
                    break;
                }

                case "drop" -> {
                    dropItemChoice(secondWord);
                    break;
                }

                case "eat" -> {
                    eatWithCheckofEatability(secondWord);
                    break;
                }

                case "equip" -> {
                    equipWeapon(secondWord);
                    break;
                }

                case "attack" -> {
                    if (secondWord == " ") {
                        attackFunction();
                    } else {
                        attackFunctionTarget(secondWord);
                    }
                    break;
                }

                case "help" -> {
                    helpCommands();
                    break;
                }
                case "look" -> {
                    System.out.println(spil.getCurrentRoomDescription());
                    break;
                }
                case "inventory", "invent", "inv" -> {
                    playerInventory();
                    //playerEquiped(); // just to test
                    break;
                }
                case "health" -> {
                    showPlayerHealthUI();
                    break;
                }
                case "exit" -> {
                    System.out.println("Thank you for playing and see you soon");
                    playerInput3 = SENTINEL;
                    firstWord = SENTINEL;
                    break;
                }


                default -> playerMovement(playerInput3);

            }

        }

    }

    public void welcome() {
        System.out.println(" ");
        System.out.println("Welcome to the AdventureGame - MULTIVERSE");
        System.out.println("We hope you are ready for som action.");
        System.out.println(" ");
        System.out.println("You start in room1 where you find yourself standing on a \nbeautiful green hill with a marvelous view...\n");
    }

    //denne metode tager input fra player, laver til små bogstaver, deler op på ord i nyt Array, så disse kan bruges videre
    public String[] playerInputManipulation(String playerInput) {
        String playerInput2 = playerInput.toLowerCase();
        String[] output = playerInput2.split(" ");
        String firstWord = output[0];
        String secondWord;
        if (output.length > 1) {
            secondWord = output[1];
        } else {
            secondWord = " ";
        }
        String playerInput3 = playerInput2;
        return new String[]{firstWord, secondWord, playerInput3};

    }

    public void takeItemChoice(String chosenItem) {
        String result = spil.takeItemMethod(chosenItem);
        if (result.equals("takeOkay")) {
            System.out.println("You have now added " + chosenItem + " to your bag");
        } else if (result.equals("takeNotPossible")) {
            System.out.println("This item is not available to take.");
        }
    }

    public void dropItemChoice(String chosenItem) {
        String result = spil.dropItemMethod(chosenItem);
        if (result.equals("dropOkay")) {
            System.out.println("You now have left in your bag: " + spil.getPlayerInventory());
        } else if (result.equals("dropNotPossible")) {
            System.out.println("This item is not available to drop.");
        }

    }

    public void playerMovement(String userChoice) {
        spil.movePlayer(userChoice);
        addInformation();
    }

    public void attackFunction() { //Til attacks ud i luften, uden enemy parameter. Implementer sammen med attack branch i switch
        if (spil.doIHaveWeaponEquipped()) {
            if (spil.getRemainingShots() > 0) {
                Enemy randomEnemy = spil.getEnemyArrayList().getFirst();
                String enemyString = randomEnemy.getName();
                System.out.println("You attack "+enemyString+".");
                spil.attackRandom();
                //Måske nogle player getters på weapon objects damage med printout til brugeren om hvor meget dmg osv.

            } else {
                System.out.println("Your weapon is out of ammunition.");
            }
        }else {
            System.out.println("No weapon is equipped, so you cannot attack." + "\n");
        }
    }

    public void attackFunctionTarget(String playerInput) {//Til attacks ud med et target, MED enemy parameter. Implementer sammen med attack branch i switch

        String enemyName = playerInput; // "attack" + enemy navn
        System.out.println("You chose to attack: " + enemyName);

        if (spil.doIHaveWeaponEquipped()) {
            if (spil.getRemainingShots() > 0) {
                Enemy target = supportAttackFunctionTarget(enemyName); //Vi returner en enemy baseret på String input.
                if (target != null) {
                    spil.attackEnemy(target);
                    System.out.println("Attacked " + target.getName());
                    System.out.println("Current HP" + target.getHealthscore());
                } else {
                    System.out.println("No enemy with the name " + enemyName + " found.");
                }
            } else {
                System.out.println("You are out of ammo.");
            }
        } else {
            System.out.println("No weapon is equipped, so you cannot attack.");
        }
    }

    public Enemy supportAttackFunctionTarget(String input) { // Vi leder efter Enemy objekter baseret på stringinput.
        ArrayList<Enemy> enemies = spil.getEnemyArrayList();
        for (Enemy enemy : enemies) {
            if (enemy.getName().equalsIgnoreCase(input)) {
                return enemy;
            }
        }
        return null;
    }

    public void sortArrayListItem() {
        spil.getsortArrayListItem();
    }


    public void addInformation() {
        //MMH her vil jeg gerne have den til at udskrive noget om hvor spilleren befinder sig, og en melding, hvis vedkomende ikke kan gå den vej
        //Til dette bruger jeg lokal variable previousRoom og currentRoom
        String currentRoom = spil.getCurrentRoom();//MMH variabel så kan tjekke om spiller har flyttet sig
        if (previousRoom.equals(currentRoom)) {
            System.out.println("Unfortunately you cannot go in this direction");
            System.out.println("You are still located in " + spil.getCurrentRoom());
        } else {
            System.out.println("You are now located in " + spil.getCurrentRoom());
            System.out.println(spil.getCurrentRoomDescription());
            System.out.println(" ");
            displayItemsInRoom();
            displayEnemyInRoom();
            System.out.println(" ");
        }
        previousRoom = currentRoom;
    }

    public void displayItemsInRoom() { //Metode til at displaye items i room. Items bliver foreløbigt sat i buildMap().
        if (!spil.getitemsArrayList().isEmpty()) { //Hvis arraylisten IKKE er tom
            System.out.println("You spot items that may be of use to you in this room: ");
            for (Item item : spil.getitemsArrayList()) { //For each loop itererer gennem vores itemsArrayList for at finde Items, der er forbundet med det enkelte rum.
                System.out.println(item.getItem());
            }
        } else {
            System.out.println("You see nothing of use to you in this room.");
        }
    }

    public void displayEnemyInRoom() { //Metode til at displaye items i room. Items bliver foreløbigt sat i buildMap().
        if (!spil.getEnemyArrayList().isEmpty()) { //Hvis arraylisten IKKE er tom
            System.out.println("You spot enemies in this room: ");
            for (Enemy enemy : spil.getEnemyArrayList()) { //For each loop itererer gennem vores itemsArrayList for at finde Items, der er forbundet med det enkelte rum.
                System.out.println(enemy.toString());
            }
        } else {
            System.out.println("You see no enemies in this room.");
        }
    }

    public void playerInventory() {
        if (spil.getPlayerInventory().length() > 0) {
            String playerInventory = spil.getPlayerInventory();
            System.out.println(playerInventory);
        } else {
            System.out.println("Your inventory is empty.");
        }

    }

    //-----Weapon Management--------------------------------------------------------------------------
    public void playerEquiped() {
        System.out.println("\n you have the following weapon equiped: ");
        String equiped = spil.getPlayerEquiped();
        System.out.println(equiped);
    }

    public void equipWeapon(String input) {
        if (spil.setEquipedWeapon(input).equals("notWeapon")) {
            System.out.println("This is not an available weapon in your bag...find something else.");
            System.out.println(" ");
        } else {
            String equipedItem = spil.getPlayerEquiped();
            System.out.println("You have the following weapon equipped: " + equipedItem);
            System.out.println(" ");
        }
    }


    public void helpCommands() { //bare for at samle sysout. Kan fjernes, hvis helt dumt.
        System.out.println("----------------------------------------------------------------");
        System.out.println("Help functions:");
        System.out.println(" ");
        System.out.println("Type direction you want to move.");
        System.out.println("Type take and name of item, if you want to take an item from a room. ");
        System.out.println("Type drop and name of item, if you want to drop an item in a room. ");
        System.out.println("Type look to get a description of the current room. ");
        System.out.println("Type eat and name of food you want to eat. ");
        System.out.println("Type equip and name of weapon you want to use. ");
        System.out.println("Type attack and .... ");
        System.out.println("Type exit to terminate the program.");
        System.out.println("---------------------------------------------------------------- ");
    }

    public void eatWithCheckofEatability(String chosenitem) {
        if (spil.playerEatsFood(chosenitem).equals("foodOkay")) {
            System.out.println("Bon appetite");
        } else if (spil.playerEatsFood(chosenitem).equals("notFood")) {
            System.out.println("Unfortunately you cannot eat this item.");
        } else if (spil.playerEatsFood(chosenitem).equals("foodNotAvailable")) {
            System.out.println("You do not have this available.");
        }
    }
    /*public void playerMovement (String userChoiceString) {
        spil.playerDirection(userChoiceString);
        int userChoiceInt = spil.playerDirection(userChoiceString);
        spil.moveRoom(userChoiceInt);
        addInformation();
    }*/

    public void showPlayerHealthUI() { ///Sysouts af nuværende player health. Thresholds ligger på højere eller lige med 50 & 30 med sidste else.
        if (spil.getHealthPlayer() >= 50) {
            System.out.println("Your health is currently at " + spil.getHealthPlayer() + "." + " You are in good health and feel super duper.");
        } else if (spil.getHealthPlayer() < 30) {
            System.out.println("Your health is currently at " + spil.getHealthPlayer() + "." + " You feel dizzy and might cross into the afterlife anytime soon.");
        } else {
            System.out.println("Your health is currently at " + spil.getHealthPlayer() + "." + " Your health is getting low now. You better avoid fighting.");
        }
    }
    public void playerisDeadMessageUI() {
        if (spil.getHealthPlayer() <=0) {
            System.out.println("\nYour health is currently at "+spil.getHealthPlayer()+".");
            System.out.println("You have sustained critical injury and are now susceptible the enemies lurking nearby.");
            System.out.println("You succumb to your wounds and perish.");
        }
    }
    public boolean isPlayerDead() {
        if(spil.getHealthPlayer() <= 0) {
            return true;
        }
        return false;
    }
}



