package edu.gorynych.chess.Figures;

import edu.gorynych.chess.Game.Move;

public interface Figure {

    Figure copyOf();
    boolean validateMove(int x, int y);
    int getColor();
    char getImage();

}
