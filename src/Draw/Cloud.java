/**
* File: Cloud.java
* Description: This is a sub class that designs and draw the basic attributes of a cloud.
* Lessons Learned: How to us Graphics2D to draw shapes
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 12/13/2023
*/
package Draw;

import java.awt.Color;
import java.awt.Graphics2D;

public class Cloud extends LandscapeObject {
    private boolean isCloudy;
    private int cloudLength;
    private int cloudHeight;
    private int numClouds;
    private Color cloudColor;

    public Cloud(Graphics2D g2, int x, int y, double scale, boolean isCloudy, int cloudLength, int cloudHeight,
            int numClouds) {
        super(g2, x, y, scale);
        this.isCloudy = isCloudy;
        this.cloudLength = cloudLength;
        this.cloudHeight = cloudHeight;
        this.numClouds = numClouds;
    }

    @Override
    public void draw() {
        applyScale();
        if (isCloudy) {
            cloudColor = Color.DARK_GRAY;
            for (int i = 0; i < numClouds; i++) {
                drawCloud();
                currentX += cloudLength / 2;
            }
        } else {
            cloudColor = Color.WHITE;
            for (int i = 0; i < numClouds; i++) {
                drawCloud();
                currentX += cloudLength / 2;
            }
        }
    }

    @Override
    public void applyScale() {
        this.cloudLength = (int) (this.cloudLength * getScale());
        this.cloudHeight = (int) (this.cloudHeight * getScale());
    }

    private void drawCloud() {
        g2.setColor(cloudColor);
        g2.fillOval(currentX, currentY - cloudHeight, cloudLength, cloudHeight);
    }

}
