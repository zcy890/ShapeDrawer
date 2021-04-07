package ca.cmpt213.as4.shapes;

/**
 * This class inherits the shape interface and layout its borders
 */
public class Triangle extends ShapeImpl {

    public Triangle(int x, int y, int width) {
        super(x, y, width, width);
    }

    @Override
    protected boolean isBorder(int x, int y) {
        return x == getLocationX()
                || y == (getLocationY() + getWidth() - 1)
                || getLocationX() - x == getLocationY() - y;
    }

    @Override
    protected boolean isInside(int x, int y) {
        return getLocationX() - x > getLocationY() - y;
    }
}
