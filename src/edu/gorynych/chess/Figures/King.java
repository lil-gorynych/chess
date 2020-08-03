package edu.gorynych.chess.Figures;


public class King implements Figure {
    private final int color;
    private final char image;


    public King(int color) {
        this.color = color;
        this.image = (color == 1) ? ('\u2654') : ('\u265a');
    }


    //comes from interface Figure

    @Override
    public Figure copyOf() {
        return new King(this.color);
    }

    @Override
    public boolean validateMove(int x, int y) {

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
