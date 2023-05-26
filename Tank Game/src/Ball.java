

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
public class Ball {
	private String fileName;
	private int width;
	private int height;
	private int vX;
	private int vY; 
	private int x;
	private int y;
	private Image img; 
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	public Ball(int width, int height, int x, int y, String fileName) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.fileName = fileName;
		img = getImage(fileName);
	}
	public void setVX(int vX) {
		this.vX = vX;
	}
	public void setVY(int vY) {
		this.vY = vY;
	}
	public void move() {
		y += vY;
		x += vX;
	}
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Ball.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch(Exception e){  
			e.printStackTrace(); 
		}
		return tempImage; 
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		move();
		g2.drawImage(img, tx, null);
	}
	public void fireBall(Tank t) {
		vX = t.getVx();
		vY = t.getVy(); 
	}
}
