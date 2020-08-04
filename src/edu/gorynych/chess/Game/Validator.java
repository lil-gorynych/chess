package edu.gorynych.chess.Game;

import edu.gorynych.chess.Board.Board;
import edu.gorynych.chess.Figures.Figure;
import edu.gorynych.chess.Figures.King;
import edu.gorynych.chess.Figures.Knight;
import edu.gorynych.chess.Figures.Pawn;


public class Validator {
    private final int color;
    private final Board board;
    private int curRow, curCol;
    private int newRow, newCol;

    public Validator(Board board, Move move) {
        setMove(move);
        this.color = move.getColor();
        this.board = board;
    }
    public void setMove(Move move) {
        this.curRow = (short) move.getCurPos()[1];
        this.curCol = (short) move.getCurPos()[0];
        this.newRow = (short) move.getNewPos()[1];
        this.newCol = (short) move.getNewPos()[0];
    }

    public Validator (Board board, int color) {
        this.color = color;
        this.board = board;
    }
    public void setMove (int curRow, int curCol,
                         int newRow, int newCol) {
        this.curRow = curRow; this.curCol = curCol;
        this.newRow = newRow; this.newCol = newCol;
    }

    public boolean checkMove() {
        return checkBounds() & checkColor() & checkRule();
    }


    private boolean checkBounds() {
        return 0 <= curRow && curRow <= 7 &&
                0 <= curCol && curCol <= 7 &&
                0 <= newRow && newRow <= 7 &&
                0 <= newCol && newCol <= 7;

    }

    private boolean checkColor() {
        return this.color == this.board.getFigure(this.curRow, this.curCol).getColor() &&
                this.color != this.board.getFigure(this.newRow, this.newCol).getColor();
    }

    private boolean checkRule() {
        Figure a = this.board.getFigure(this.curRow, this.curCol);

        if (a instanceof Pawn) {
            return checkRulePawn((Pawn) a);
        }
        if (a instanceof Knight) {
            return checkRuleKnight((Knight) a);
        }
        if (a instanceof King) {
            return checkRuleKing((King) a);
        }

        return checkRuleBase(a);
    }

    private boolean checkRulePawn(Pawn a) {
        int deltaRow = this.newRow - this.curRow;
        int deltaCol = this.newCol - this.curCol;

        if (isAttack()) {
            return a.validateAttack(deltaRow, deltaCol) & checkLine();
        }
        return a.validateMove(deltaRow, deltaCol) & checkLine();
    }

    private boolean checkRuleKnight(Knight a) {
        int deltaRow = this.newRow - this.curRow;
        int deltaCol = this.newCol - this.curCol;

        return a.validateMove(deltaRow, deltaCol);
    }

    private boolean checkRuleKing(King a) {
        return false;
    }

    private boolean checkRuleBase(Figure a) {
        return a.validateMove(this.newRow - this.curCol,
                this.newCol - this.curCol) &
                checkLine();
    }


    //help functions
    private boolean isAttack() {
        return this.board.getFigure(this.curRow, this.curCol).getColor() ==
                (-1) * this.board.getFigure(this.newRow, this.newCol).getColor();
    }

    private boolean isEmpty(int x, int y) {
        return this.board.getFigure(x, y).getColor() == 0;
    }

    private boolean checkLine() {
        int deltaRow = this.newRow - this.curRow;
        int deltaCol = this.newCol - this.curCol;
        int x = this.curRow,
                y = this.curCol;

        int[] step = stepsToDestinations(deltaRow, deltaCol);

        for (int i = 0; i < step[0] - 1; i++) {
            x += step[1];
            y += step[2];
            if (!isEmpty(x, y)) {
                return false;
            }
        }
        return true;
    }

    private int[] stepsToDestinations(int x, int y) {
        int max = Math.max(Math.abs(x), Math.abs(y));
        return new int[]{max, x / max, y / max};
    }
}
