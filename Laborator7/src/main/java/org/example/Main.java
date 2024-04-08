package org.example;

public class Main {
    public static void main(String args[]) {
        Game game = new Game(10);
        game.addPlayer(new Player("CAZAN",game));
        game.addPlayer(new Player("DENIS",game));
        game.addPlayer(new Player("MARIAN",game));
        game.play();
    }
}