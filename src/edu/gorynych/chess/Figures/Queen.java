package edu.gorynych.chess.Figures;

public class Queen implements Figure {
    private final int color;
    private final Character image;


    public Queen(int color) {
        this.color = color;
        this.image = (color == 1) ? ((Character) '\u2655') : ((Character) '\u265b');
    }


    @Override
    public Figure copyOf() {
        return new Queen(this.color);
    }

    //comes from interface Figures
    @Override
    public boolean validateMove(int x, int y) {
        return Math.abs(x) == Math.abs(y);
    }

    @Override
    public int getColor() {
        return this.color;
    }

    @Override
    public Character getImage() {
        return this.image;
    }
}
