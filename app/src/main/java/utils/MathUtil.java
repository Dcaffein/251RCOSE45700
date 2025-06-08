package utils;

import java.awt.*;

public class MathUtil {
    public static Rectangle computeRectangle(int startX, int startY, int endX,int endY) {
        int x = Math.min(startX, endX);
        int y = Math.min(startY, endY);
        int width = Math.abs(startX - endX);
        int height = Math.abs(startY - endY);
        return new Rectangle(x, y, width, height);
    }
}
