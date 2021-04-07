package ca.cmpt213.as4.shapes;

import ca.cmpt213.as4.UI.Canvas;

import java.awt.*;

/**
 * Basic shape interface, no implementation
 */

public interface Shape {

    int getLocationX();

    int getLocationY();

    char getBorderChar();

    void setBorderChar(char character);

    Color getColor();

    void setColor(Color color);

    void draw(Canvas canvas);

}
