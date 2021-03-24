package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;
/* Klasa odpowiada za mechanizmy gry
Ma zawierać metody
- Pobierającą ruch gracza
- Losującą ruch komputera
- Rozstrzygajacą wynik rundy
- Przeprowadzającą runde
- Restartującą rozgrywkę
- Kończącą rozgrywkę
 */
public class Game {
    //Zmienne sterujące zachowaniem metod
    private boolean winning;
    private boolean draw;
    private String cpuChoice;
    private String playerChoice;
    private int playerWins;
    private int cpuWins;
    private boolean exit = false;
    private boolean restart = false;
    private int control;
    private boolean end = false;

    // Metoda, która przeprowadza rozgrywkę
    public boolean playGame(String playerName, int rounds) {
        control = rounds;                                   //Control po restarcie może mieć inną wartość, niż round
        boolean quit=false;

        while (!end) {
            playerChoice();
            quit=false;                                     //Resetuje zmieną, gdy gracz po wciśnięciu 'x' zmieni zdanie
            if (exit) {
                exitGame(playerName);
                quit=true;
            } else if (restart) {
                restartGame();
            } else {
                choiceGenerator();
                arbitrate();
                if (draw) {
                    draw = false;
                    System.out.println("Round result : DRAW ! \nYou choose " + playerChoice + " and CPU also choose " + cpuChoice +
                            "\nActual result : " + playerName + " " + playerWins + " : CPU " + cpuWins);
                } else if (winning) {
                    winning = false;
                    playerWins++;
                    System.out.println("Round result : You WON! \n You choose " + playerChoice + " and CPU choose " + cpuChoice +
                            "\nActual result : " + playerName + " " + playerWins + " : CPU " + cpuWins);
                } else {
                    cpuWins++;
                    System.out.println("Round result : You LOST! \n You choose " + playerChoice + " and CPU choose " + cpuChoice +
                            "\nActual result : " + playerName + " " + playerWins + " : CPU " + cpuWins);

                }
                if (playerWins == control || cpuWins == control) {
                    end = true;
                }
            }
        }
        return quit;
    }

    //Metoda kontunuacji gry
    public boolean keepPlaying(){
        boolean result=false;
        boolean correct =false;
        System.out.println("\n Game Over. Choose what you whant to do next :");
        System.out.println("Press 'x' to quit game\nPress 'n' to start again");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();
        while(!correct) {
            if (decision.equals("x")) {
                result = true;
                correct = true;
                System.out.println("Thank you for playing, have a nice day");
            } else if (decision.equals("n")) {
                correct = true;
                System.out.println("Great ! Get ready for another game!");
            } else {
                System.out.println("Incorrect choice! Please type 'x' to quit or 'n' to start again");
                Scanner scan = new Scanner(System.in);
                decision = scan.nextLine();
            }
        }
        return result;
    }

    //Metoda kończąca rozgrywkę
    public void exitGame(String playerName){
        boolean correct = false;
        Menu menu = new Menu();
        System.out.println("Are you sure you want to quit game? y/n");
        Scanner scan = new Scanner(System.in);
        String quit = scan.nextLine();
        while(!correct) {                                               //Tak długo, aż gracz dokona poparawnego wyboru
            if (quit.equals("y")) {
                end = true;
                correct = true;
                System.out.println("GAME OVER\n" + playerName + " " + playerWins + " : CPU " + cpuWins);
            } else if (quit.equals("n")) {
                correct = true;
                exit = false;
                menu.instructionDisplay();
            } else {
                System.out.println("Incorret choice! Please type 'y' to quit or 'n' to keep playing");
                Scanner scan2 = new Scanner(System.in);
                quit = scan2.nextLine();
            }
        }
    }

    //Metoda restartujaca rozgrywkę
    public void restartGame() {
        boolean correct = false;
        Menu menu = new Menu();
        System.out.println("Are you sure you want to start again? y/n");
        Scanner scan1 = new Scanner(System.in);
        String restart1 = scan1.nextLine();
        while(!correct) {                                               //Tak długo, aż gracz dokona poparawnego wyboru
            if (restart1.equals("y")) {
                correct = true;
                restart = false;
                playerWins = 0;
                cpuWins = 0;
                System.out.println("How many rounds you want to play ?");
                Scanner scan = new Scanner(System.in);
                control = scan.nextInt();
                menu.instructionDisplay();
            } else if(restart1.equals("n")){
                correct = true;
                restart = false;
            }else{
                System.out.println("Incorrect choice! Please type 'y' to start again or 'n' to keep playing");
                Scanner scanner = new Scanner(System.in);
                restart1 = scanner.nextLine();
            }
        }
    }


    // Metoda, która pobiera wybór gracza
    public void playerChoice(){
        boolean end = false;
        Menu message = new Menu();
        message.pleasePlay();
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();

        while(!end) {                                               //Tak długo, aż gracz dokona poprawnego wyboru
            switch (read) {
                case "1":
                    playerChoice = "ROCK";
                    end = true;
                    break;
                case "2":
                    playerChoice = "PAPER";
                    end = true;
                    break;
                case "3":
                    playerChoice = "SCISSORS";
                    end = true;
                    break;
                case "x":
                    exit = true;
                    end = true;
                    break;
                case "n":
                    restart = true;
                    end = true;
                    break;
                default:
                    System.out.println("Incorrect choice! Choose again.");
                    Menu menu = new Menu();
                    menu.instructionDisplay();
                    Scanner scanAgain = new Scanner(System.in);
                    read = scanAgain.nextLine();
                    break;
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



    // Metoda, która przyjmuje wybór gracza i zwraca wynik potyczki z komputerem

    public void arbitrate(){

        switch (playerChoice) {
            //Rock
            case "ROCK":
                switch (cpuChoice) {
                    case "ROCK":
                        draw = true;
                        break;
                    case "PAPER":
                        winning = false;
                        break;
                    case "SCISSORS":
                        winning = true;
                        break;
                }
                break;
            case "PAPER":
                switch (cpuChoice) {
                    case "ROCK":
                        winning = true;
                        break;
                    case "PAPER":
                        draw = true;
                        break;
                    case "SCISSORS":
                        winning = false;
                        break;
                }
                break;
            case "SCISSORS":
                switch (cpuChoice) {
                    case "ROCK":
                        winning = false;
                        break;
                    case "PAPER":
                        winning = true;
                        break;
                    case "SCISSORS":
                        draw = true;
                        break;
                }
                break;
        }
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getCpuWins() {
        return cpuWins;
    }
}
