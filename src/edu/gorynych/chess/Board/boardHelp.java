package edu.gorynych.chess.Board;

import edu.gorynych.chess.Game.Move;
import edu.gorynych.chess.Game.Validator;

public class boardHelp {

    public static boolean isCellUnderAttacked (int color, int[] pos, Board board) {
        Validator move = new Validator(board, color);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.getFigure(i, j).getColor() == color) {



                }
            }
        }
    }
}
