package edu.gorynych.chess.Figures;

public class Empty implements Figure{
    private final int color = 0;
    private final char image = ' ';


    @Override
    public Figure copyOf() {
        return new Empty();
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
