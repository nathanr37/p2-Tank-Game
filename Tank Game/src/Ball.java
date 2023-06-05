

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
public class Ball {
	private int width;
	private int height;
	private double vx;
	private double vy; 
	private int x;
	private int y;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	public Ball() {
		x = 900;
		y = 900;
		width = 8;
		height = 8;
		init();
	}
	public void setvx(double vx) {
		this.vx = vx;
	}
	public void setvy(double vy) {
		this.vy = vy;
	}
	
	public void setx(int ex) {
		x = ex;
	}
	public void sety(int ey) {
		y = ey;
	}
	public double getvx() {
		return vx;
	}
	public double getvy() {
		return vy; 
	}
	public void move() {
		y += vy;
		x += vx;
        tx.setToTranslation(x, y);
	}

	private void init() {
		tx.setToTranslation(x, y);
		tx.scale(1, 1);
	}
	
	 public boolean collided(int ox, int oy, int ow, int oh) { //collide with walls or tank
	    	Rectangle obs = new Rectangle(ox, oy, ow, oh);
	    	Rectangle b = new Rectangle(x, y, width, height);
	    	return obs.intersects(b);
	    }

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		move();
		AffineTransform oldTransform = g2.getTransform();
		g2.setColor(Color.black);
		g2.fillOval(x, y, width, height);
        g2.translate(x, y);
        g2.setTransform(oldTransform);

	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return width;
	}
	public int getH() {
		return height;
	}
}
