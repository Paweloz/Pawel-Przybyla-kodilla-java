package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        RpsMenu menu = new RpsMenu();
        Game newGame = new Game();
        menu.helloPlayer();
        RpsMenu.instructionDisplay();
        menu.pleasePlay();
        newGame.playGame(menu.getRounds());
        menu.verdict(newGame);
    }
}
