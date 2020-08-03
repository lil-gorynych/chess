package edu.gorynych.chess.Game;

import edu.gorynych.chess.Board.Board;

import java.util.Scanner;

import static edu.gorynych.chess.PP.Parser.parseMove;


public class Move {
    private int[] newPos = new int[2];
    private int[] curPos = new int[2];
    private int color;

    private Scanner scanner = new Scanner(System.in);

    public Move(int step) {
        this.color = (step % 2 == 0) ? 1 : -1;
    }

    //getters
    public int[] getNewPos() {
        return this.newPos;
    }

    public int[] getCurPos() {
        return this.curPos;
    }

    public int getColor() {
        return this.color;
    }

    //main setter - no need to divide them
    public void setMove() {
        System.out.print("Your move: ");
        String move = scanner.nextLine();

        while (!parseMove(move, curPos, newPos)) {
            System.out.print("Wrong move! Try again!\nYour move: ");
            move = scanner.nextLine();
        }
        reverseMove();
    }

    //make change on the board
    public void makeMove(Board board) {
        board.transformBoard(this.curPos, this.newPos);
    }


    //help functions
    private int reverseInt(int pos) {
        return 7 - pos;
    }

    private void reverseMove() {
        newPos[1] = reverseInt(this.newPos[1]);
        curPos[1] = reverseInt(this.curPos[1]);
    }
}
