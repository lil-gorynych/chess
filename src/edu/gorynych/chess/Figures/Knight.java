package edu.gorynych.chess.Figures;

public class Knight implements Figure{
    private final int color;
    private final char image;


    public Knight(int color) {
        this.color = color;
        this.image = (color == 1) ? ('\u2658') : ('\u265e');
    }


    @Override
    public Figure copyOf() {
        return new Knight(this.color);
    }

    //comes from interface Figure
    @Override
    public boolean validateMove(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if ((x == 2 && y == 1) ||
                (x == 1 && y == 2)) {
            return true;
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
