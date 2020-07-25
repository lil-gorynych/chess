package edu.gorynych.chess.Board;

import edu.gorynych.chess.Figures.Empty;
import edu.gorynych.chess.Figures.Figure;

import java.util.ArrayList;

import static edu.gorynych.chess.PP.Parser.parseCell;


public class Board {
    private final Figure[][] board = new Figure[8][8];
    private ArrayList<Character> capturedWhite = new ArrayList<>();
    private ArrayList<Character> capturedBlack = new ArrayList<>();

    public void newBoard() {
        String[][] newBoard = {
                {"rb", "kb", "bb", "Qb", "Kb", "bb", "kb", "rb"},
                {"pb", "pb", "pb", "pb", "pb", "pb", "pb", "pb"},
                {"00", "00", "00", "00", "00", "00", "00", "00"},
                {"00", "00", "00", "00", "00", "00", "00", "00"},
                {"00", "00", "00", "00", "00", "00", "00", "00"},
                {"00", "00", "00", "00", "00", "00", "00", "00"},
                {"pw", "pw", "pw", "pw", "pw", "pw", "pw", "pw"},
                {"rw", "kw", "bw", "Qw", "Kw", "bw", "kw", "rw"}
        };

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = parseCell(newBoard[i][j]);
            }
        }
    }

    public Figure getFigure(int i, int j) {
        return this.board[i][j];
    }




    public void transformBoard(int[] from, int[] to) {
        int fromCol = from[0], fromRow = from[1];
        int toCol = to[0], toRow = to[1];

        moveFigure(toRow, toCol, fromRow, fromCol);
        killFigure(fromRow, fromCol);

    }

    //help functions
    private void addToCaptured(int i, int j) {
        Figure tmp = getFigure(i, j);

        switch (tmp.getColor()) {
            case 1:
                this.capturedWhite.add(Character.valueOf(tmp.getImage()));
                break;
            case -1:
                this.capturedBlack.add(Character.valueOf(tmp.getImage()));
                break;
        }
    }

    public ArrayList<Character> getCapturedWhite() {
        return this.capturedWhite;
    }
    public ArrayList<Character> getCapturedBlack() {
        return this.capturedBlack;
    }

    private void killFigure(int i, int j) {
        this.board[i][j] = new Empty();
    }

    private void moveFigure(int i, int j, int k, int l) {
        addToCaptured(i, j);
        this.board[i][j] = this.board[k][l].copyOf();
    }

}
