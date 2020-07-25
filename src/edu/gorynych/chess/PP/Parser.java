package edu.gorynych.chess.PP;

import edu.gorynych.chess.Figures.*;

public class Parser {


    public static Figure parseCell(String cell) {
        int color = 0;

        switch (cell.charAt(1)) {
            case 'w': color = 1; break;
            case '0': break;
            case 'b': color = -1; break;
        }

        switch (cell.charAt(0)) {
            case 'r': return new Rook(color);
            case 'k': return new Knight(color);
            case 'b': return new Bishop(color);
            case 'Q': return new Queen(color);
            case 'K': return new King(color);
            case 'p': return new Pawn(color);
        }

        return new Empty();
    }


    public static boolean parseMove(String s, int[] from, int[] to) {
        if (s.length() != 4) {
            return false;
        }

        from[0] = parseCol(s.charAt(0));
        to[0] = parseCol(s.charAt(2));

        from[1] = s.charAt(1) - '1';
        to [1] = s.charAt(3) - '1';

        return true;
    }

    private static int parseCol(char c) {
        switch (c) {
            case 'a': return 0;
            case 'b': return 1;
            case 'c': return 2;
            case 'd': return 3;
            case 'e': return 4;
            case 'f': return 5;
            case 'g': return 6;
            case 'h': return 7;
        }

        return -1;
    }
}
