/**
* File: DrawPanel.java
* Description: This is a sub class that draws all the shapes.
* Lessons Learned: How to us Graphics2D to draw shapes
* Instructor's Name: Barbara Chamberlin
*
* @author: Miguel Elizalde
* @since: 12/13/2023
*/
package DrawBaseLine;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import java.awt.geom.*;

/**
 * Class used to create a DrawPanel where shapes will be drawn by the programmer
 * (via code).
 * 
 * @author Jared N. Plumb
 * @version 1.0
 * @since 2019-11-26
 * @Minor modifications by Jeff Light
 * @since 2019-12-01
 */
public class DrawPanel extends JPanel {
	// Attributes
	private static final long serialVersionUID = 6311020027600344213L;

	public DrawPanel() {
		this.setPreferredSize(new Dimension(1600, 900)); // Sets the dimensions of the DrawPanel. Change this if your
															// screen doesn't support this size.
		this.setOpaque(true);
		this.setBackground(Color.WHITE); // Sets the background of the DrawPanel LIGHT_GRAY. You may change this if
											// desired.
	}

	/**
	 * Overrides the JComponent.paintComponent method.
	 * EVERYTHING that gets drawn to the Component (which sits on the content frame
	 * of the JFrame) is drawn in this method.
	 * Draw12a
	 * Draw all your objects in the paintComponent method.
	 * Automatically called by the event handler whenever the screen needs to be
	 * redrawn.
	 * DO NOT CALL THIS METHOD MANUALLY
	 * 
	 * @param g //All drawing in Java must go through a Graphics object
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; // Allows us to draw using both the Graphics class methods and the Graphics2D
										// class methods

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Makes drawn shapes
																									// and fonts clearer
		// Draw12a a rectangle
		g2.setColor(Color.RED);
		g2.setStroke(new BasicStroke(1));
		g2.drawRect(50, 50, 200, 100);
		g2.fillRect(300, 50, 100, 200);

		// Draw12a a triangle
		g2.setColor(Color.BLUE);
		g2.setStroke(new BasicStroke(3));
		int[] xPoints1 = { 1000, 1100, 1200 };
		int[] yPoints1 = { 250, 50, 250 };
		g2.drawPolygon(xPoints1, yPoints1, 3);
		int x = 1100;
		int y = 150;
		int d = 120;
		int sep = 250;
		int ax = (int) Math.round(d * Math.cos(Math.toRadians(120))) + x;
		int ay = (int) Math.round(d * Math.sin(Math.toRadians(120))) + y;
		int bx = (int) Math.round(d * Math.cos(Math.toRadians(240))) + x;
		int by = (int) Math.round(d * Math.sin(Math.toRadians(240))) + y;
		int cx = (int) Math.round(d * Math.cos(Math.toRadians(360))) + x;
		int cy = (int) Math.round(d * Math.sin(Math.toRadians(360))) + y;
		int[] xPoints2 = { ax + sep, bx + sep, cx + sep };
		int[] yPoints2 = { ay, by, cy };
		g2.fillPolygon(xPoints2, yPoints2, 3);

		// Create a rounded rectangle object and draw it
		g2.setColor(Color.decode("#899D78"));
		g2.setStroke(new BasicStroke(4));
		var emptyRR = new RoundRectangle2D.Double(50, 350, 200, 100, 30, 30);
		var filledRR = new RoundRectangle2D.Double(300, 350, 100, 200, 30, 30);
		g2.draw(emptyRR);
		g2.fill(filledRR);

		// Create an ellipse object and draw it
		g2.setColor(Color.YELLOW);
		g2.setStroke(new BasicStroke(5));
		var emptyEllipse = new Ellipse2D.Double(500, 50, 200, 100);
		var filledEllipse = new Ellipse2D.Double(750, 50, 100, 200);
		g2.draw(emptyEllipse);
		g2.fill(filledEllipse);

		// Create a polygon object and draw it
		g2.setColor(Color.cyan);
		g2.setStroke(new BasicStroke(6));
		g2.drawRect(500, 350, 150, 150);
		g2.fillRect(750, 350, 150, 150);

		// Create a polygon object and draw it
		g2.setColor(Color.decode("#F0BCD4"));
		g2.setStroke(new BasicStroke(7));
		x = 1100;
		y = 425;
		d = 100;
		sep = 250;
		ax = (int) Math.round(d * Math.cos(Math.toRadians(72))) + x;
		ay = (int) Math.round(d * Math.sin(Math.toRadians(72))) + y;
		bx = (int) Math.round(d * Math.cos(Math.toRadians(144))) + x;
		by = (int) Math.round(d * Math.sin(Math.toRadians(144))) + y;
		cx = (int) Math.round(d * Math.cos(Math.toRadians(216))) + x;
		cy = (int) Math.round(d * Math.sin(Math.toRadians(216))) + y;
		int dx = (int) Math.round(d * Math.cos(Math.toRadians(288))) + x;
		int dy = (int) Math.round(d * Math.sin(Math.toRadians(288))) + y;
		int ex = (int) Math.round(d * Math.cos(Math.toRadians(360))) + x;
		int ey = (int) Math.round(d * Math.sin(Math.toRadians(360))) + y;
		int[] xPoints3 = { ax, bx, cx, dx, ex };
		int[] yPoints3 = { ay, by, cy, dy, ey };
		int[] xPoints4 = { ax + sep, bx + sep, cx + sep, dx + sep, ex + sep };
		int[] yPoints4 = { ay, by, cy, dy, ey };
		g2.drawPolygon(xPoints3, yPoints3, 5);
		g2.fillPolygon(xPoints4, yPoints4, 5);

		/*
		 * Use this section to write your code.
		 * DrawShapes
		 * Draw at least 6 shapes in BOTH draw and fill formats using methods found
		 * in
		 * the Graphics class and/or the Graphics2D class.
		 * In other words, if you draw an empty rectangle, you should also draw a
		 * filled
		 * rectangle. That counts as one (1) shape.
		 * The empty and filled versions of the shape should be at different
		 * orientations.
		 * One of the shapes MUST be a triangle.
		 * Each shape should be a different color. An empty and a filled rectangle
		 * may
		 * be the same color, but they must be a different color from an empty and
		 * filled triangle.
		 * At least one of the colors should NOT be a standard color from the COLOR
		 * palette.
		 * Each empty shape should have a different stroke size.
		 * Be sure all shapes are located such that they can all be seen.
		 */

	}// end of method paintComponent(Graphics)

}// end of class DrawPanel