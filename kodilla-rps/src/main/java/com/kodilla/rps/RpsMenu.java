package com.kodilla.rps;

/*Klasa odpowiada za obsługę menu użytkownika

Ma zawierać metody :
- Powitanie z pytaniem o imię gracza i ilość rund - Done
- Wyświetlać informacje z klawiszami obsługi - Done
- Wyświetlać prośbę o wykonanie ruchu - Done
- Wyświetlać komunikat o wyniku rundy, ilości wykonanych ruchów i biężącym wyniku gry
- No koniec gry wyświetla podsumowanie wraz zapytaniem o zakończenie gry lub ponowna gre - Done
 */

import java.util.Scanner;

public class RpsMenu {
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
        //Tutaj dopisz jakiś patent na restart gry
    }

    //Wyświetla powitanie gracza oraz ustala jego imię i ilość rund
    public void helloPlayer(){
        System.out.println("Welcome to the game, what's your name ?");
        Scanner name = new Scanner(System.in);
        playerName = name.nextLine();
        System.out.println("How many rounds do you want to play ?");
        Scanner scan = new Scanner(System.in);
        rounds = scan.nextInt();
    }

    //Wyświetla instrukcje sterowania grą
    public void instructionDisplay(){
        System.out.println("\nGAME CONTROL\n"+"1 - Rock"+"\n"+"2 - Paper"+"\n"+"3 - Scissors"+"\n"+
                "x - Quit Game"+"\n"+"n - New Game"+"\n");
    }

    //Wyświetla komunikat proszący o wykonanie ruchu
    public void pleasePlay(){
        System.out.println("Please play your move");
    }

    //Gettery
    public String getPlayerName() {
        return playerName;
    }

    public int getRounds() {
        return rounds;
    }
}
