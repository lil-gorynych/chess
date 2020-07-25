package edu.gorynych.chess.Figures;

public class Queen implements Figure{
    private final int color;
    private final char image;


    public Queen(int color) {
        this.color = color;
        this.image = (color == 1) ? ('\u2655') : ('\u265b');
    }


    @Override
    public Figure copyOf() {
        return new Queen(this.color);
    }

    //comes from interface Figures
    @Override
    public boolean validateMove(int x, int y) {
        if ((x == 0 || y == 0) || (Math.abs(x) == Math.abs(y))) { return true; }
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
