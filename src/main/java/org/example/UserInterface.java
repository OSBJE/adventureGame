package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
            System.out.println("In what direction do you want to go: North, South, East og West?");
            System.out.println("Or type inventory, take, drop, eat, equip, attack, help, look or exit.");
            playerInput = input.nextLine();
            String[] inputArray = playerInputManipulation(playerInput);
            String firstWord = inputArray[0];
            String secondWord = inputArray[1];
            String playerInput3 = inputArray[2];
            //System.out.println("dette er ord 1: " + firstWord);    test af input
            //System.out.println("dette er ord 2: " + secondWord);    test af input

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
                    //equipMethod(secondWord);
                    break;
                }
            }

            switch (playerInput3) {
                case "north", "go north", "n" -> {
                    playerMovement("north");
                    break;
                }
                case "go south", "south", "s" -> {
                    playerMovement("south");
                    break;
                }
                case "go east", "east", "e" -> {
                    playerMovement("east");
                    break;
                }
                case "go west", "west", "w" -> {
                    playerMovement("west");
                    break;
                }
                case "help" -> {
                    helpCommands();
                    break;
                }
                case "look" -> {
                    spil.getCurrentRoomDescription();
                    break;
                }
                case "inventory", "invent", "inv" -> {
                    playerInventory();
                    break;
                }
                case "health" -> {
                    showPlayerHealthUI();
                    break;
                }
                case "exit", "Exit" -> {
                    System.out.println("Thank you for playing and see you soon");
                    playerInput3 = SENTINEL;
                    firstWord = SENTINEL;

                }

            }

        }

    }
    public void welcome() {
        System.out.println(" ");
        System.out.println("Welcome to the AdventureGame");
        System.out.println("We hope you are ready for som action.");
        System.out.println(" ");
        System.out.println("You start in room1 where you find yourself standing on a \nbeautiful green hill with a marvelous view...");
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
        spil.takeItemMethod(chosenItem); //metoden skal tilrettes lidt, så vi kan tilføje tekst, hvis item ikke er i rum
        System.out.println("You have now added " + chosenItem + " to your bag");
    }

    public void dropItemChoice(String chosenItem) {
        spil.dropItemMethod(chosenItem);
        System.out.println("You now have in your bag: " + spil.getPlayerInventory());
    }

    public void playerMovement(String userChoice) {
        spil.movePlayer(userChoice);
        addInformation();
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

    public void playerInventory() {
        if (spil.getPlayerInventory().length() > 0) {
            String playerInventory = spil.getPlayerInventory();
            System.out.println(playerInventory);
        } else {
            System.out.println("Your inventory is empty.");
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
        System.out.println("Type exit to terminate the program.");
        System.out.println("---------------------------------------------------------------- ");
    }

    public void eatWithCheckofEatability(String chosenitem) {
        if(spil.playerEatsFood(chosenitem).equals("foodOkay")){
            System.out.println("Bon appetite");
        } else if (spil.playerEatsFood(chosenitem).equals("notFood")) {
            System.out.println("Unfortunately you cannot eat this item.");
        } else if (spil.playerEatsFood(chosenitem).equals("foodNotAvailable")) {
            System.out.println("You do not have this available.");
        }
    }

    public void showPlayerHealthUI() { ///Sysouts af nuværende player health. Thresholds ligger på højere eller lige med 50 & 30 med sidste else.
        if (spil.getHealthPlayer() >= 50) {
            System.out.println("Your health is currently at " + spil.getHealthPlayer() + "." + " You are in good health, but avoid fighting right now.");
        } else if (spil.getHealthPlayer() < 30) {
            System.out.println("Your health is currently at " + spil.getHealthPlayer() + "." + " You feel dizzy and might cross into the afterlife anytime soon.");
        } else {
            System.out.println("Your health is currently at " + spil.getHealthPlayer() + "." + " Your health is worryingly low right now.");
        }
    }
}


