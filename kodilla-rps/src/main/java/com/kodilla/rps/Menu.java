package com.kodilla.rps;

/*Klasa odpowiada za obsługę menu użytkownika

Ma zawierać metody :
- Powitanie z pytaniem o imię gracza i ilość rund - Done
- Wyświetlać informacje z klawiszami obsługi - Done
- Wyświetlać prośbę o wykonanie ruchu - Done
- No koniec gry wyświetla podsumowanie wraz zapytaniem o zakończenie gry lub ponowna gre - Done
 */

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Menu {
    private String playerName;
    private int rounds;

    //Wyświetla wynik końcowy wraz z podsumowaniem
    public void verdict(Game game){
        if (game.getPlayerWins() == rounds) {
            System.out.println("\n YOU WON "+"\n"+playerName+" "+ game.getPlayerWins()+" : "+
                    game.getCpuWins()+ " CPU");
        }else if(game.getCpuWins() == rounds){
            System.out.println("\n YOU LOST "+"\n"+playerName+" "+ game.getPlayerWins()+" : "+
                    game.getCpuWins()+ " CPU");
        }
    }

    //Wyświetla powitanie gracza oraz ustala jego imię i ilość rund
    public void helloPlayer() {

        System.out.println("Welcome to the game, what's your name ?");
        Scanner name = new Scanner(System.in);
        playerName = name.nextLine();
    }
    public int setRounds() {
        String roundsStr;
        boolean correct = false;
        while (!correct) {
            System.out.println("To how many victories do you want to play ?");
            Scanner scan = new Scanner(System.in);
            roundsStr = scan.nextLine();
            correct = true;
            try {                                                                   //Obsługuje NumberFormatException
                rounds = parseInt(roundsStr);
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Please type only numbers");
                correct = false;
            }
        }
        return rounds;
    }


    //Wyświetla instrukcje sterowania grą
    public void instructionDisplay(){
        System.out.println("\nGAME CONTROL\n"+"1 - Rock"+"\n"+"2 - Paper"+"\n"+"3 - Scissors"+"\n"+
                "x - Quit Game"+"\n"+"n - New Game"+"\n");
    }

    //Wyświetla komunikat proszący o wykonanie ruchu
    public void pleasePlay(){
        System.out.println("\nPlease play your move");
    }

    //Gettery
    public String getPlayerName() {
        return playerName;
    }

    public int getRounds() {
        return rounds;
    }
}
