package com.kodilla.rps;

import java.awt.*;
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
    //Przenieś tą metodę do innej klasy
    public void playGame(String playerName, int rounds) {
        boolean end = false;
        int control = rounds;
        RpsMenu menu = new RpsMenu();

        while (!end) {
            playerChoice();
            //Tu napisz metodę wyłączającą gre
            if (exit){
                System.out.println("Finish game");
                end = true;
                //Tu nappisz metodę restartującą gre
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
                draw = false;
                System.out.println("Round result : DRAW ! \nYou choose "+playerChoice+" and CPU also choose " + cpuChoice+
                        "\nActual result : "+playerName+" "+playerWins+" : CPU "+cpuWins);
            } else if (winning) {
                winning = false;
                playerWins++;
                System.out.println("Round result : You WON! \n You choose "+playerChoice+" and CPU choose " + cpuChoice+
                        "\nActual result : "+playerName+" "+playerWins+" : CPU "+cpuWins);
            } else {
                cpuWins++;
                System.out.println("Round result : You LOST! \n You choose "+playerChoice+" and CPU choose " + cpuChoice+
                        "\nActual result : "+playerName+" "+playerWins+" : CPU "+cpuWins);

            }
            if (playerWins == control || cpuWins == control ){
                end = true;
            }
        }
    }

    // Metoda, która pobiera wybór gracza
    public void playerChoice(){
        boolean end = false;
        //Odczytuje wybór gracza
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();

        //Tak długo wybiera, aż wybór będzie poprawny
        while(!end) {
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
                RpsMenu menu = new RpsMenu();
                menu.instructionDisplay();
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
