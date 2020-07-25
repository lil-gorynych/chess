package edu.gorynych.chess.Figures;

import edu.gorynych.chess.Game.Move;

public interface Figure {

    Figure copyOf();

    //comes from interface Figure
    boolean validateMove(int x, int y);

    int getColor();
    char getImage();

}
