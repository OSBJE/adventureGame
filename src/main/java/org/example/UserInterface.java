package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    Scanner input = new Scanner(System.in);

    // instance / laver et Game object
    // laver en nyt game

    Game spil = new Game();
    String previousRoom;

    //MMH Vi kunne definere constructor og køre startGame herinde. Så skal metodekald af startGame slettes fra Main
    public UserInterface() {
        startGame();
    }

    public void startGame() {
        final String SENTINEL = "exit"; // den her skal bruges senere, lige nu holder den bare loopet igang.
        String userChoiceString=""; // starter bare så den kan loop hele tiden


        // starten på spillet, her skal det køre en gang
        System.out.println("Welcome to AdventureGame!");
        System.out.println("You are located in " + spil.getCurrentRoom());

        this.previousRoom = spil.getCurrentRoom();//MMH String variabel til hjælp så vi kan bedømme i if else, om spilleren har flyttet sig
        System.out.println(spil.roomDescription(previousRoom)); //MMH beskrivelse af start rum
        System.out.println(" ");//MMH bare for at få en ekstra linje

        while (!userChoiceString.toLowerCase().equals(SENTINEL)) {

            System.out.println("In what direction do you want to go?");
            System.out.println("Type in what direction or type help, look, exit.");
            userChoiceString = input.nextLine();
            if(userChoiceString.toLowerCase().equals("help") || userChoiceString.toLowerCase().equals("look") || userChoiceString.toLowerCase().equals("exit")) {
                helpExitLook(userChoiceString); //Metodekald.
            } else {
                spil.playDirectionAdvance(userChoiceString);

                int userChoiceInt = spil.playDirectionAdvance(userChoiceString);

                spil.moveRoom(userChoiceInt);

                addInformation();
            }




        }
    }
    public void helpCommands() { //bare for at samle sysout. Kan fjernes, hvis helt dumt.
        System.out.println("Help functions:");
        System.out.println("Type exit to terminate the program.");
        System.out.println("Type look to get a description of the current room.");
    }
    public void helpExitLook(String userChoiceString) {
        if(userChoiceString.toLowerCase().equals("help")) { //Hjælp kommando i terminal
            helpCommands(); //udprintning af hjælpekommandoer
        } else if (userChoiceString.toLowerCase().equals("look")) { //henter værelsesbeskrivelse
            System.out.println("Description of surroundings");
            System.out.println(spil.roomDescription(spil.getCurrentRoom())); //Henter Mettes beskrivelser.
            System.out.println(spil.current.getRoomDescription()); //henter Room objektets description, der også er parameter.
        } else {
            // spil.moveRoom(userchoice2); //Udkommenteret, da parameter skal kræve String og ikke int.
        }
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
            System.out.println(spil.roomDescription(currentRoom));
            System.out.println(" ");

        }
        previousRoom = currentRoom;
    }

    //**** Error handling methods ****//
    // nedstående error handling skal fange forkerte input i vores program
    // Det skal gerne kunne genbruges som en general error hanndling

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
    }
}












