/**
* File: House.java
* Description: This is a sub class that designs and draw the basic attributes of a House.
* Lessons Learned: How to us Graphics2D to draw shapes
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 12/13/2023
*/
package Draw;

import java.awt.Color;
import java.awt.Graphics2D;

public class House extends LandscapeObject {
    private String houseColor;
    private String roofColor;
    private int houseLength;
    private int houseHeight;
    private int roofHeight;
    private boolean isDoorOpen;
    private boolean isWindowOpen;

    public House(Graphics2D g2, int x, int y, double scale, String houseColor, String roofColor, int houseLength,
            int houseHeight, int roofHeight, boolean isDoorOpen, boolean isWindowOpen) {
        super(g2, x, y, scale);
        this.houseColor = "#" + houseColor;
        this.roofColor = "#" + roofColor;
        this.houseLength = houseLength;
        this.houseHeight = houseHeight;
        this.roofHeight = roofHeight;
        this.isDoorOpen = isDoorOpen;
        this.isWindowOpen = isWindowOpen;
    }

    @Override
    public void draw() {
        applyScale();
        drawHouse();
        drawRoof();
        if (isDoorOpen) {
            drawDoor(Color.black);
        } else {
            drawDoor(Color.decode(houseColor).darker());
        }
        if (isWindowOpen) {
            drawWindow(Color.black);
        } else {
            drawWindow(Color.cyan);
        }

    }

    @Override
    public void applyScale() {
        this.houseLength = (int) (this.houseLength * getScale());
        this.houseHeight = (int) (this.houseHeight * getScale());
        this.roofHeight = (int) (this.roofHeight * getScale());
    }

    private void drawHouse() {
        g2.setColor(Color.decode(houseColor));
        g2.fillRect(currentX, currentY - houseHeight, houseLength, houseHeight);
        g2.setColor(Color.black);
        g2.drawRect(currentX, currentY - houseHeight, houseLength, houseHeight);
    }

    private void drawRoof() {
        g2.setColor(Color.decode(roofColor));
        g2.fillPolygon(new int[] { currentX, currentX + (houseLength / 2), currentX + houseLength },
                new int[] { currentY - houseHeight, currentY - houseHeight - roofHeight, currentY - houseHeight },
                3);
        g2.setColor(Color.black);
        g2.drawPolygon(new int[] { currentX, currentX + (houseLength / 2), currentX + houseLength },
                new int[] { currentY - houseHeight, currentY - houseHeight - roofHeight, currentY - houseHeight },
                3);
    }

    private void drawDoor(Color color) {
        g2.setColor(color);
        g2.fillRect(currentX + (houseLength / 2) - (houseLength / 10) + 1, currentY - houseHeight / 2,
                houseLength / 5, houseHeight / 2);
        g2.setColor(Color.black);
        g2.drawRect(currentX + (houseLength / 2) - (houseLength / 10), currentY - houseHeight / 2, houseLength / 5,
                houseHeight / 2);
    }

    private void drawWindow(Color color) {
        g2.setColor(color);
        g2.fillRect(currentX + (houseLength / 2) - (houseLength / 10) + 1, currentY - houseHeight * 3 / 4,
                houseLength / 5, houseHeight / 5);
        g2.setColor(Color.black);
        g2.drawRect(currentX + (houseLength / 2) - (houseLength / 10), currentY - houseHeight * 3 / 4, houseLength / 5,
                houseHeight / 5);
    }
}
