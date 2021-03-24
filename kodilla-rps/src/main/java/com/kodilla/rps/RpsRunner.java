package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        RpsMenu menu = new RpsMenu();
        Game newGame = new Game();
        menu.helloPlayer();
        menu.instructionDisplay();
        menu.pleasePlay();
        newGame.playGame(menu.getPlayerName(), menu.getRounds());
        menu.verdict(newGame);
    }
}
