package edu.gorynych.chess.Figures;

public class Empty implements Figure {


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
        return 0;
    }

    @Override
    public Character getImage() {
        return ' ';
    }
}
