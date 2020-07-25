package edu.gorynych.chess.Game;
import edu.gorynych.chess.Board.Board;

import static edu.gorynych.chess.PP.Printer.printBoard;


public class Game {

    private int steps;
    private Board board = new Board();

    public Game() {
        this.steps = 0;
        this.board.newBoard();
    }


    public int beginGame() {

        while (this.steps < 10) {
            printBoard(this.board);
            makeStep();
            this.steps++;
        }

        return 1;
    }


    private void makeStep() {
        Move move = new Move(this.steps);
        move.setMove();

        Validator validator = new Validator(this.board, move);

        while (!validator.checkMove()) {
            System.out.println("Illegal move");
            move.setMove();
            validator.setMove(move);
        }

        move.makeMove(this.board);
    }


}
