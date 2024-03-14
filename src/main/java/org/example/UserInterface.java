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
        startGame();
    }


    /////****** Start and control game ********//////////////////

    public void startGame() {
        final String SENTINEL = "exit"; // den her skal bruges senere, lige nu holder den bare loopet igang.
        String userChoiceString = ""; // starter bare så den kan loop hele tiden

        ArrayList<String> wordCheck = wordDirection2(); //Great a list to direct the game based on word

        // starten på spillet, her skal det køre en gang
        System.out.println("Welcome to AdventureGame!");
        System.out.println("You are located in " + spil.getCurrentRoom());
        System.out.println(" ");//MMH bare for at få en ekstra linje
        System.out.println(spil.getCurrentRoomDescription());

        this.previousRoom = spil.getCurrentRoom();//MMH String variabel til hjælp så vi kan bedømme i if else, om spilleren har flyttet sig
        //System.out.println(spil.getRoomDescription()); //MMH beskrivelse af start rum


        while (!userChoiceString.toLowerCase().equals(SENTINEL)) {
            System.out.println("What do you wanna do now?");
            System.out.println("Either type in what direction you want to go or type help, look, inventory or exit");
            System.out.println(" ");
            userChoiceString = input.nextLine();
            String userChoice = userChoiceCleaner(userChoiceString);

            if (wordCheck.contains(userChoice)) {
                playerChoiceHelper(userChoiceString);
            } else if (userChoice.equals("inventory")) {
                playerInventory();
            } else {
                playerMovement(userChoiceString);
            }
        }
    }


    ////***** Game interface and help functions and exit program functions *****////////////

    // userChoiceString cleaner

    public ArrayList<String> wordDirection2() {
        ArrayList<String> wordDirection = new ArrayList<>();

        wordDirection.add("help");
        wordDirection.add("look");
        wordDirection.add("exit");
        wordDirection.add("take");
        wordDirection.add("drop");

        return wordDirection;
    }

    public String userChoiceCleaner(String userChoice1) {
        String userChoice2 = userChoice1.toLowerCase();
        String[] output = userChoice2.split(" ");

        return output[0];
    }

    /// To make code in the interface more simple
    public void playerChoiceHelper(String userChoiceString) {
        if (userChoiceString.equals("help") || userChoiceString.equals("look") || userChoiceString.equals("exit")) {
            helpExitLook(userChoiceString); //Metodekald.
        } else if (userChoiceString.toLowerCase().contains("take")) {
            takeItemInRoom(userChoiceString);
        } else if (userChoiceString.toLowerCase().contains("drop")) {
            dropItemInRoom(userChoiceString);
        } else {
            playerMovement(userChoiceString);
        }
    }


    public void helpCommands() { //bare for at samle sysout. Kan fjernes, hvis helt dumt.
        System.out.println("Help functions:");
        System.out.println(" ");
        System.out.println("Type exit to terminate the program.");
        System.out.println("Type look to get a description of the current room.");
        System.out.println(" ");
    }

    public void helpExitLook(String userChoiceString) {
        if (userChoiceString.toLowerCase().equals("help")) { //Hjælp kommando i terminal
            helpCommands(); //udprintning af hjælpekommandoer
        } else if (!userChoiceString.toLowerCase().equals("exit")) { //henter værelsesbeskrivelse
            System.out.println(spil.getCurrentRoomDescription());
            // System.out.println(spil.getRoomDescription()(spil.getCurrentRoom())); //Henter Mettes beskrivelser.
            //System.out.println(spil.getRoomDescription()); //henter Room objektets description, der også er parameter.
        }
    }


    ////***** Player movement function and associated help functions *****////////////

    public void playerMovement(String userChoiceString) {
        spil.playerDirection(userChoiceString);
        int userChoiceInt = spil.playerDirection(userChoiceString);
        spil.moveRoom(userChoiceInt);
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


    /////******** Player and Room Item handling *************/////////

    public void displayItemsInRoom() { //Metode til at displaye items i room. Items bliver foreløbigt sat i buildMap().
        if (!spil.getitemsArrayList().isEmpty()) { //Hvis arraylisten IKKE er tom
            System.out.println("You spot items that may be of use to you in this room: ");
            for (Item item : spil.getitemsArrayList()) { //For each loop itererer gennem vores itemsArrayList for at finde Items, der er forbundet med det enkelte rum.
                System.out.println(item.getItem());
            }
            takeItemChoice();
            eatWithCheckofEatability();
        } else {
            System.out.println("You see nothing of use to you in this room.");
            if (!spil.getPlayerInventory().isEmpty()) {
                dropItemChoice();
            }
        }
    }

    public void takeItemChoice() { //lidt mere brugervenlig info
        System.out.println("Do you want to take an item, yes or no?");
        String playerChoice = input.nextLine();
        switch (playerChoice.toLowerCase()) {
            case "no" -> {
                System.out.println("Then let us move on");
            }
            case "yes", "take", "yes take" -> {
                System.out.println("What item do you want to take?");
                String chosenItem = input.nextLine();
                spil.takeItemMethod(chosenItem);
                System.out.println("You have now added " + chosenItem + " to your bag");
            }
            default -> {
                System.out.println("Sorry you entered a wrong command");
                takeItemChoice();

            }
        }
    }

    public void dropItemChoice() {
        System.out.println("Do you want to drop an item in this room, yes or no?");
        String playerChoice = input.nextLine();
        switch (playerChoice.toLowerCase()) {
            case "no" -> {
                System.out.println("Then let us move on");
            }
            case "yes" -> {
                System.out.println("What item do you want to drop?");
                String chosenItem = input.nextLine();
                spil.dropItemMethod(chosenItem);
                System.out.println("You now have in your bag: " + spil.getPlayerInventory());
            }
            default -> {
                System.out.println("Sorry you entered a wrong command.");
                dropItemChoice();

            }
        }

    }

    public void eatWithCheckofEatability () {
        System.out.println("Are you hungry, yes or no?");
        String playerChoice = input.nextLine();
        switch (playerChoice.toLowerCase()) {
            case "no" -> {
                System.out.println("Then let us move on");
            }
            case "yes" -> {
                System.out.println("Here you can see a list of items in this room and in your bag");
                for (Item item : spil.getitemsArrayList()) {
                    System.out.println(item.getItem());
                }
                System.out.println(spil.getPlayerInventory());
                System.out.println(" ");

                System.out.println("Type item you would like eat og not hungry if you want to move on");
                String chosenItem = input.nextLine();
                if (spil.eatableItemMethod(chosenItem)) {
                    System.out.println("Bon appetite");
                    //eatoghealth metode
                    break;
                }
                System.out.println("Unfortunately you cannot eat this item");
            }
            default -> {
                System.out.println("Sorry you entered a wrong command.");
                eatWithCheckofEatability();

            }
        }
    }


    public void takeItemInRoom(String userChoiceString) {
        String cleanInput = spil.cleanItemInput(userChoiceString);
        spil.takeItemMethod(cleanInput);
    }

    public void dropItemInRoom(String userChoiceString) {
        String cleanInput = spil.cleanItemInput(userChoiceString);
        spil.dropItemMethod(cleanInput);
    }

    // method to print our playerInventory
    public void playerInventory() {
        String playerInventory = spil.getPlayerInventory();
        System.out.println(playerInventory);
    }

    public void eatItem(String chosenItem) {

    }


}


//**** Error handling methods ****//
// nedstående error handling skal fange forkerte input i vores program
// Det skal gerne kunne genbruges som en general error hanndling
/*
    private int inputValidation(String prompt, int min, int max) {
        int userInput = 0;
        boolean flagdown = false;

        while (!flagdown) {
            try {
                System.out.println(prompt);
                userInput = input.nextInt();
                input.nextLine();

                if (userInput >= min && userInput <= max) {
                    flagdown = true;
                } else {
                    System.out.println("Error! please input a number between " + min + " and " + max);
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Error! Please input a valid number");
                input.nextLine();
            }
        }
        return userInput;
    } */













