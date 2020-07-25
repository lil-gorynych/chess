package edu.gorynych.chess.PP;

import edu.gorynych.chess.Board.Board;


public class Printer {
    static String[] colors = {"black, white"};


    //print chessboard
    public static void printBoard(Board board) {

        System.out.println("\n\n\n");
        printWhiteCaptured(board);
        printAbcLine();
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
        printBlackCaptured(board);
        System.out.println();
    }


    //HELP FUNCTIONS
    //prints ab...h line in the end
    private static void printWhiteCaptured(Board board) {
        System.out.print("Captured white figures: ");
        for (Character i : board.getCapturedWhite()) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    private static void printBlackCaptured(Board board) {
        System.out.print("Captured black figures: ");
        for (Character i : board.getCapturedBlack()) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

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

    //prints status
    public static void printStatus(int status) {
        switch (status) {
            case 0: break;
            case 1:
                System.out.println("Check!");
                break;
            case 2:
                System.out.println("Checkmate!");
                break;
        }
    }


    //print winner
    public static void printWinner(int winner) {
        switch (winner) {
            case -1:
                System.out.println("Blacks wins!");
                break;
            case 0:
                System.out.println("It's a draw!");
                break;
            case 1:
                System.out.println("White wins!");
                break;
        }
    }
}
