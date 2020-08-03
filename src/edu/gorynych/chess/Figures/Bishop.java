package edu.gorynych.chess.Figures;


public class Bishop implements Figure {
    private final int color;
    private final char image;


    public Bishop(int color) {
        this.color = color;
        this.image = (color == 1) ? ('\u2657') : ('\u265d');
    }

    @Override
    public Figure copyOf() {
        return new Bishop(this.color);
    }


    //comes from interface Figure
    @Override
    public boolean validateMove(int x, int y) {
        return Math.abs(x) == Math.abs(y);
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
