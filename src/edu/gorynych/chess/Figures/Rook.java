package edu.gorynych.chess.Figures;

public class Rook implements Figure {
    private final int color;
    private final Character image;


    public Rook(int color) {
        this.color = color;
        this.image = (color == 1) ? ((Character) '\u2656') : ((Character) '\u265c');
    }


    @Override
    public Figure copyOf() {
        return new Rook(this.color);
    }

    //comes from interface Figure
    @Override
    public boolean validateMove(int x, int y) {
        return x == 0 || y == 0;
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
