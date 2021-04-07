package ca.cmpt213.as4.shapes;
/**
 * This class inherits Rectangle class and fills in the rectangle with texts
 */

import ca.cmpt213.as4.UI.Canvas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextBox extends Rectangle {
    private String message;
    private int currLength = 0;
    private int textWidth = getWidth() - 2;

    public TextBox(int x, int y, int width, int height, String message) {
        super(x, y, width, height);
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void draw(Canvas canvas) {
        String[] arrayOfMessages = message.split(" ");
        List<String> listOfMessages = new ArrayList<>();
        List<String> allWords = new ArrayList<>();

        allWords.addAll(Arrays.asList(arrayOfMessages));

        for (String word : allWords) {
            if (word.length() > textWidth) {
                listOfMessages.add(word.substring(0, textWidth));
                listOfMessages.add(word.substring(textWidth));
            } else {
                listOfMessages.add(" " + word);
            }
        }
        //draw the rectangles
        super.draw(canvas);
        //fill in the rectangles
        for (int col = 0; col < listOfMessages.size() && col < getHeight() - 2; col++) {
            String message = listOfMessages.get(col);
            currLength += message.length() + 1;
            if (currLength < textWidth) {
                for (int row = currLength; row < message.length() + 1; row++) {
                    canvas.setCellText(
                            getLocationX() + row,
                            getLocationY() + col + 1,
                            message.charAt(row - 1)
                    );
                }
            } else {
                currLength = message.length();
                for (int row = 1; row < message.length() + 1; row++) {
                    canvas.setCellText(
                            getLocationX() + row,
                            getLocationY() + col + 1,
                            message.charAt(row - 1)
                    );
                }
            }
        }
    }
}
