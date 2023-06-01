import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Tank {

    private int x, y;
    private double vx, vy;
    private boolean alive;
    private int width;
    private int height;
    private String fileName;
    private Image img;
    private double angle;

    public Tank(String fileName) {
        x = 0;
        y = 0;
        vx = 0.0;
        vy = 0.0;
        width = 100;
        height = 100;
        angle = 0;

        img = getImage(fileName);
        init();
    }

    public void move() {
        x += vx;
        y += vy;
        tx.setToTranslation(x, y);
    }

    public void rotateClockwise() {
        angle += 45;
        if (angle >= 360) {
            angle -= 360;
        }
    }

    public void rotateCounterClockwise() {
        angle -= 45;
        if (angle < 0) {
            angle += 360;
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        move();
        AffineTransform oldTransform = g2.getTransform();
        g2.translate(x, y);
        g2.rotate(Math.toRadians(angle), width / 2, height / 2);
        g2.drawImage(img, 0, 0, width, height, null);
        g2.setTransform(oldTransform);
        
        
    }

    private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

    private void init() {
        tx.setToTranslation(x, y);
        tx.scale(4, 4);
    }

    private Image getImage(String path) {
        Image tempImage = null;
        try {
            URL imageURL = Tank.class.getResource(path);
            tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempImage;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        tx.setToTranslation(x, y);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        tx.setToTranslation(x, y);
    }

    public Image getImage() {
        return img;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getAngle() {
        return angle;
    }
    
    //test writing
}
