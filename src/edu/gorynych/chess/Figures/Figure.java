package edu.gorynych.chess.Figures;

public interface Figure {

    Figure copyOf();

    boolean validateMove(int x, int y);

    int getColor();

    char getImage();

}
