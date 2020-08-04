package edu.gorynych.chess.Figures;

public class Knight implements Figure {
    private final int color;
    private final Character image;


    public Knight(int color) {
        this.color = color;
        this.image = (color == 1) ? ((Character) '\u2658') : ((Character) '\u265e');
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

        return (x == 2 && y == 1) ||
                (x == 1 && y == 2);
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
