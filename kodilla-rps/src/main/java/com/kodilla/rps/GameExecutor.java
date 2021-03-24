package com.kodilla.rps;

import java.util.Scanner;

public class GameExecutor {

    /*public void playGame(int rounds) {
        boolean end = false;
        int control = rounds;
        RpsMenu menu = new RpsMenu();

        while (!end) {
            playerChoice();
            if (exit){
                System.out.println("Finish game");
                end = true;
            }else if(restart){
                System.out.println("Are you sure you want to restart ? y/n");
                Scanner scan1 = new Scanner(System.in);
                String restart1 = scan1.nextLine();
                if(restart1.equals("y")){
                    restart = false;
                    playerWins = 0;
                    cpuWins = 0;
                    System.out.println("How many rounds you want to play ?");
                    Scanner scan = new Scanner(System.in);
                    control = scan.nextInt();
                    menu.instructionDisplay();
                    playerChoice();
                }else {
                    restart = false;
                    menu.pleasePlay();
                    playerChoice();
                }
            }
            choiceGenerator();
            conclusion();
            if (draw) {
                System.out.println("DRAW ! CPU also choose " + cpuChoice);
                draw = false;
            } else if (winning) {
                System.out.println("You WON!, CPU choose " + cpuChoice);
                playerWins++;
                winning = false;
            } else {
                System.out.println("You LOST!, CPU choose " + cpuChoice);
                cpuWins++;
            }
            if (playerWins == control || cpuWins == control ){
                end = true;
            }
        }
    }*/
}
