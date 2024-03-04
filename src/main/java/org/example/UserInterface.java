package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    Scanner input = new Scanner(System.in);

    // instance / laver et Game object
    // laver en nyt game

    Game spil = new Game();

    public void startGame(){
        int sentinal = 5; // den her skal bruges senere, lige nu holder den bare loopet igang.
        int userChoice = 0; // starter bare så den kan loop hele tiden


        // starten på spillet, her skal det køre en gang
        System.out.println("Velkommen til AdventureGame!");
        System.out.println("You are located in " + spil.getCurrentRoom());

        while (userChoice != sentinal){


            System.out.println("vælg hvilke retning du vil gå på compasset");
            System.out.println("1. North 2. South 3. East 4. West");

        userChoice = input.nextInt();

        spil.moveRoom(userChoice);
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












