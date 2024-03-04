package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    Scanner input = new Scanner(System.in);

    // instance / laver et Game object
    // laver en nyt game

    Game spil = new Game();

    //MMH Vi kunne definere constructor og køre startGame herinde. Så skal metodekald af startGame slettes fra Main
    public UserInterface() {
        startGame();
    }

    public void startGame() {
        int sentinel = 5; // den her skal bruges senere, lige nu holder den bare loopet igang.
        int userChoice = 0; // starter bare så den kan loop hele tiden


        // starten på spillet, her skal det køre en gang
        System.out.println("Welcome to AdventureGame!");
        System.out.println("You are located in " + spil.getCurrentRoom());

        String previousRoom = spil.getCurrentRoom();//MMH String variabel til hjælp så vi kan bedømme i if else, om spilleren har flyttet sig
        System.out.println(spil.getCurrent().roomDescription(previousRoom)); //MMH beskrivelse af start rum
        System.out.println(" ");
        while (userChoice != sentinel) {


            System.out.println("In what direction do you want to go?");
            System.out.println("1. North \n2. South \n3. East \n4. West");

            userChoice = input.nextInt();

            spil.moveRoom(userChoice);

            //MMH her vil jeg gerne have den til at udskrive noget om hvor spilleren befinder sig, og en melding, hvis vedkomende ikke kan gå den vej
            //Til dette bruger jeg variable
            String currentRoom = spil.getCurrentRoom();//MMH variabel så kan tjekke om spiller har flyttet sig
            if (previousRoom.equals(currentRoom)) {
                System.out.println("Unfortunately you cannot go in this direction");
                System.out.println("You are still located in " + spil.getCurrentRoom());
            } else {
                System.out.println("You are now located in " + spil.getCurrentRoom());
                System.out.println(spil.getCurrent().roomDescription(currentRoom));
                System.out.println(" ");

            }
            previousRoom = currentRoom;


        }
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












