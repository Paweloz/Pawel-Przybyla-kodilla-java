package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        boolean end=false;
        while(!end) {
            Menu menu = new Menu();
            Game game = new Game();
            menu.helloPlayer();
            menu.instructionDisplay();
            end = game.playGame(menu.getPlayerName(), menu.getRounds());
            menu.verdict(game);
            if(!end) {                              //Jeśli gracz rozegrał wszystkie rundy i nie przerwał gry w trakcie
                end = game.keepPlaying();
            }
        }
    }
}
