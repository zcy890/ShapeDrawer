package ca.cmpt213.as4.shapes;

import ca.cmpt213.as4.UI.Canvas;

import java.awt.*;

/**
 * Implementation of the shape interface and setting up the draw method for other inherited
 * classes to use.
 */

public abstract class ShapeImpl implements Shape {
    private int x;
    private int y;
    private int width;
    private int height;

    private char defaultBorderChar = '*';
    private Color defaultColor = Color.YELLOW;

    public ShapeImpl(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getLocationX() {
        return x;
    }

    @Override
    public int getLocationY() {
        return y;
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

    @Override
    public char getBorderChar() {
        return defaultBorderChar;
    }

    @Override
    public void setBorderChar(char character) {
        this.defaultBorderChar = character;
    }

    @Override
    public Color getColor() {
        return defaultColor;
    }

    @Override
    public void setColor(Color color) {
        this.defaultColor = color;
    }

    @Override
    public void draw(Canvas canvas) {
        for (int row = x; row < x + width; row++) {
            for (int col = y; col < y + height; col++) {
                if (isBorder(row, col)) {
                    canvas.setCellColor(row, col, defaultColor);
                    canvas.setCellText(row, col, defaultBorderChar);
                } else if (isInside(row, col)) {
                    canvas.setCellColor(row, col, defaultColor);
                }
            }
        }
    }

    protected abstract boolean isBorder(int x, int y);

    protected abstract boolean isInside(int x, int y);
}
