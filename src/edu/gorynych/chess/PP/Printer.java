package edu.gorynych.chess.PP;

import edu.gorynych.chess.Board.Board;


public class Printer {

    //print chessboard
    public static void printBoard(Board board) {

        printBoardLine();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("| " +
                        board.getFigure(i, j).getImage() + " ");
            }
            System.out.println("|  " + Math.abs(i - 8));

            printBoardLine();
        }

        printAbcLine();
    }


    //HELP FUNCTIONS
    //prints ab...h line in the end
    private static void printAbcLine () {
        String s = "abcdefgh";

        System.out.print("  ");
        for (int i = 0; i < 8; i++) {
            System.out.print(s.charAt(i) + "   ");
        }
        System.out.println();
    }
    //prints the line after every row
    private static void printBoardLine () {
        for (int i = 0; i < 8; i++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }
    //prints array in the line
    public static void printArray (int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }
}
