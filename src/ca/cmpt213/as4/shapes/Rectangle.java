package ca.cmpt213.as4.shapes;

/**
 * This class inherits the shape interface and layout its borders
 */
public class Rectangle extends ShapeImpl {
    public Rectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    protected boolean isBorder(int x, int y) {
        return x == getLocationX()
                || x == getLocationX() + getWidth() - 1
                || y == getLocationY()
                || y == getLocationY() + getHeight() - 1;
    }

    @Override
    protected boolean isInside(int x, int y) {
        return x > getLocationX()
                || x < getLocationX() + getWidth() - 1
                || y > getLocationY()
                || y < getLocationY() + getHeight() - 1;
    }
}
