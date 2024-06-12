/**
* File: Car.java
* Description: This is a sub class that designs and draw the basic attributes of a car.
* Lessons Learned: How to us Graphics2D to draw shapes
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 12/13/2023
*/
package Draw;

import java.awt.Color;
import java.awt.Graphics2D;

public class Car extends LandscapeObject {
    private String color;
    private Boolean isConvertible;
    private String orientation;
    private int carLength;
    private int carHeitght;

    public Car(Graphics2D g2, int x, int y, double scale, String color, Boolean isConvertible, String orientation,
            int carLength, int carHeitght) {
        super(g2, x, y, scale);
        this.color = "#" + color;
        this.isConvertible = isConvertible;
        this.orientation = orientation;
        this.carLength = carLength;
        this.carHeitght = carHeitght;
    }

    @Override
    public void draw() {
        applyScale();
        drawCarBody(currentX, currentY, getScale());
        drawWheels(currentX, currentY, getScale());
        if (isConvertible) {
            if (orientation.equals("right")) {
                drawConvertibleTop(currentX, currentY, getScale());
            } else {
                drawConvertibleTopLeft(currentX, currentY, getScale());
            }
        } else {
            drawTop(currentX, currentY, getScale());
        }
    }

    @Override
    public void applyScale() {
        this.carLength = (int) (this.carLength * getScale());
        this.carHeitght = (int) (this.carHeitght * getScale());
    }

    private void drawWheels(int x, int y, double scale) {
        int size = (int) (carHeitght * scale) / 2;
        g2.setColor(Color.black);
        g2.fillOval(x, y, size, size);
        g2.fillOval(x + (int) (carLength * scale) - size, y, size, size);
        g2.setColor(Color.white);
        g2.fillOval(x + (size / 4), y + (size / 4), size / 2, size / 2);
        g2.fillOval(x + (int) (carLength * scale) - size + (size / 4), y + (size / 4), size / 2, size / 2);

    }

    private void drawCarBody(int x, int y, double scale) {
        g2.setColor(Color.decode(color));
        g2.fillRect(x, y - (carHeitght / 4), (int) (carLength * scale), (int) ((carHeitght / 2) * scale));
        g2.setColor(Color.black);
        g2.drawRect(x, y - (carHeitght / 4), (int) (carLength * scale), (int) ((carHeitght / 2) * scale));
    }

    private void drawConvertibleTop(int x, int y, double scale) {
        int[] xPoints = { x + (int) ((carLength * 2 / 3) * scale),
                x + (int) (carLength * scale),
                x + (int) ((carLength * 2 / 3) * scale) };
        int[] yPoints = { y - (carHeitght / 4), y - (carHeitght / 4), y - (carHeitght * 3) / 5 };
        g2.setColor(Color.cyan);
        g2.fillPolygon(xPoints, yPoints, 3);
        g2.setColor(Color.black);
        g2.drawPolygon(xPoints, yPoints, 3);
    }

    private void drawConvertibleTopLeft(int x, int y, double scale) {
        int[] xPoints = { x + (int) ((carLength * 1 / 3) * scale),
                x,
                x + (int) ((carLength * 1 / 3) * scale) };
        int[] yPoints = { y - (carHeitght / 4), y - (carHeitght / 4), y - (carHeitght * 3) / 5 };
        g2.setColor(Color.cyan);
        g2.fillPolygon(xPoints, yPoints, 3);
        g2.setColor(Color.black);
        g2.drawPolygon(xPoints, yPoints, 3);
    }

    private void drawTop(int x, int y, double scale) {
        int topHeight = (int) (carHeitght * scale) / 2;
        int[] xPoints = { x, x + (int) (carLength * scale), x + (int) (carLength *
                scale) - (topHeight / 2),
                x + (topHeight / 2) };
        int[] yPoints = { y - (carHeitght / 4), y - (carHeitght / 4), y - (carHeitght
                / 2), y - (carHeitght / 2) };
        g2.setColor(Color.cyan);
        g2.fillPolygon(xPoints, yPoints, 4);
        g2.setColor(Color.black);
        g2.drawPolygon(xPoints, yPoints, 4);
    }

}
