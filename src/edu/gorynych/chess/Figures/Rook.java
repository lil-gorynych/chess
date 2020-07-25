package edu.gorynych.chess.Figures;

public class Rook implements Figure{
    private final int color;
    private final char image;


    public Rook(int color) {
        this.color = color;
        this.image = (color == 1) ? ('\u2656') : ('\u265c');
    }


    @Override
    public Figure copyOf() {
        return new Rook(this.color);
    }

    //comes from interface Figure
    @Override
    public boolean validateMove(int x, int y) {
        if (x == 0 || y == 0) { return true; }
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
