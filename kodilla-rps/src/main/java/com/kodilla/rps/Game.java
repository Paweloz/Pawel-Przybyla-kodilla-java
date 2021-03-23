package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private boolean winning;
    private boolean draw;
    private String cpuChoice;
    private String playerChoice;
    private int playerWins;
    private int cpuWins;
    private boolean exit = false;
    private boolean restart = false;

    // Metoda, która przeprowadza rozgrywkę
    public void playGame(int rounds) {
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
                    RpsMenu.instructionDisplay();
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
    }

    // Metoda, która pobiera wybór gracza
    public void playerChoice(){
        boolean end = false;
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();

        while(!end) {                                           //Tak długo wybiera, aż wybór będzie poprawny
            if (read.equals("1")) {
                playerChoice = "ROCK";
                end = true;
            } else if (read.equals("2")) {
                playerChoice = "PAPER";
                end = true;
            } else if (read.equals("3")) {
                playerChoice = "SCISSORS";
                end = true;
            } else if (read.equals("x")) {
                exit = true;
                end = true;
            } else if (read.equals("n")) {
                restart = true;
                end = true;
            }else {
                System.out.println("Incorrect choice! Choose again.");
                RpsMenu.instructionDisplay();
                Scanner scanAgain = new Scanner(System.in);
                read = scanAgain.nextLine();
            }
        }
    }

    // Metoda, która losuje wybór komputera
    public void choiceGenerator(){
        Random generator = new Random();
        int result = generator.nextInt(30);
        if(result <= 9){
            cpuChoice = "ROCK";
        }else if(result <= 19){
            cpuChoice = "PAPER";
        }else{
            cpuChoice = "SCISSORS";
        }
    }



    // Metoda, która przyjmuje wybór graczy i zwraca wynik potyczki z komputerem

    public void conclusion(){

        switch (playerChoice) {
            //Rock
            case "ROCK":
                if (cpuChoice.equals("ROCK")) {
                    draw = true;
                } else if (cpuChoice.equals("PAPER")) {
                    winning = false;
                } else if (cpuChoice.equals("SCISSORS")) {
                    winning = true;
                }
                break;
            case "PAPER":
                if (cpuChoice.equals("ROCK")) {
                    winning = true;
                } else if (cpuChoice.equals("PAPER")) {
                    draw = true;
                } else if (cpuChoice.equals("SCISSORS")) {
                    winning = false;
                }
                break;
            case "SCISSORS":
                if (cpuChoice.equals("ROCK")) {
                    winning = false;
                } else if (cpuChoice.equals("PAPER")) {
                    winning = true;
                } else if (cpuChoice.equals("SCISSORS")) {
                    draw = true;
                }
                break;
        }
    }

    public boolean isWinning() {
        return winning;
    }

    public boolean isDraw() {
        return draw;
    }

    public String getCpuChoice() {
        return cpuChoice;
    }

    public String getPlayerChoice() {
        return playerChoice;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getCpuWins() {
        return cpuWins;
    }
}
