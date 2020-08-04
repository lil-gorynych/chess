package edu.gorynych.chess.Figures;


public class King implements Figure {
    private final int color;
    private final Character image;


    public King(int color) {
        this.color = color;
        this.image = (color == 1) ? ((Character) '\u2654') : ((Character) '\u265a');
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
    public Character getImage() {
        return this.image;
    }
}
