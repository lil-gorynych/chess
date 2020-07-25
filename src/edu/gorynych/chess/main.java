package edu.gorynych.chess;

import edu.gorynych.chess.Game.Game;
import edu.gorynych.chess.PP.Printer;


public class main {

    public static void main(String[] args) {
        Game game = new Game();
        int winner;

        System.out.println("Hello!!! Begin game\n\n");

        winner = game.beginGame();
        Printer.printWinner(winner);
    }


}
