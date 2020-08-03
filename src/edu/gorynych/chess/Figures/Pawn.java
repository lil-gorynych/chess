package edu.gorynych.chess.Figures;

public class Pawn implements Figure {
    private final int color;
    private final char image;
    private boolean firstMove;


    public Pawn(int color) {
        this.color = color;
        this.image = (color == 1) ? ('\u2659') : ('\u265f');
        this.firstMove = true;
    }


    //for copy function
    public Pawn(int color, boolean firstMove) {
        this.color = color;
        this.image = (color == 1) ? ('\u2659') : ('\u265f');
        this.firstMove = firstMove;
    }


    @Override
    public Figure copyOf() {
        return new Pawn(this.color, this.firstMove);
    }

    //validation of an attack move
    public boolean validateAttack(int x, int y) {
        x = (this.color == 1) ? -x : x;
        if (x == 1 && (y == 1 || y == -1)) {
            this.firstMove = false;
            return true;
        }
        return false;
    }

    //comes from interface Figure
    @Override
    public boolean validateMove(int x, int y) {
        x = (this.color == 1) ? -x : x;
        if (firstMove & (x == 1 || x == 2)) {
            this.firstMove = false;
            return y == 0;
        }
        if (x == 1) {
            return y == 0;
        }
        return false;
    }

    @Override
    public int getColor() {
        return this.color;
    }

    @Override
    public char getImage() {
        return this.image;
    }

}
