package edu.gorynych.chess.Game;

import edu.gorynych.chess.Board.Board;
import edu.gorynych.chess.PP.Printer;


public class Game {

    private int steps;
    private final Board board = new Board();
    private int status = 0;

    public Game() {
        this.steps = 0;
        this.board.newBoard();
    }

    public int beginGame() {

        while (this.steps < 10) {
            makeStep();
            changeStatus();
        }

        return 1;
    }


    private void makeStep() {
        Printer.printBoard(this.board);
        Printer.printStatus(this.status);
        Move move = new Move(this.steps);
        move.setMove();

        Validator validator = new Validator(this.board, move);

        while (!validator.checkMove()) {
            System.out.println("Illegal move");
            move.setMove();
            validator.setMove(move);
        }

        move.makeMove(this.board);

        this.steps++;
    }


    private void changeStatus(){

    }


}
