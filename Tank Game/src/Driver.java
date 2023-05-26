
//https://github.com/domingodavid/froggerEclipse



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.image.*;
import java.awt.geom.AffineTransform;

public class Driver extends JPanel implements ActionListener, KeyListener {

	private int score;
	boolean temp2 = true;
	//Music hop = new Music("Sweep.wav", false);
	
	//hop.play
	
	int screen_width = 800;
	int screen_height = 800;
	Tank tank;
	
	Background bg;
	int lives = 3; // example

	String lose = "";
	String win = "";
	String lost = "";

	// ****************************paint
	// method******************************************
	public void paint(Graphics g) {

		super.paintComponent(g);
		bg.paint(g);
		for(int i = 10; i < 800; i += 20) {
			g.drawLine(i, 0, i, 800);
			g.drawLine(0, i, 800, i);
		}

		g.setFont(font);
		g.setColor(Color.white);
		g.drawString(("Lives:") + Integer.toString(lives), 20, 20);
		g.setFont(font2);

		// HITBOX
		Color nG = new Color(112, 84, 62);
		g.setColor(nG);
		
		 g.setColor(Color.white);
		// VISUAL LINES 
		 int temp = 537;
		 //g.drawLine(0, temp, 800, temp);
		 
		 g.setColor(Color.CYAN);
		// g.drawLine(0, 380, 800, 380);
		 g.setColor(Color.white);
		// g.drawLine(0, 805, 400, 805);
		
		
		
		
		// paint and update tank
		tank.paint(g);
		

	}

	Font font = new Font("Courier New", 1, 50);
	Font font2 = new Font("Courier New", 1, 30);

	//
	public void update() {
		tank.move();
	}

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	/*
	 * * Used to setup all of the objects on the screen
	 */
	public Driver() {
		JFrame f = new JFrame();
		f.setTitle("Tanksss");
		f.setSize(screen_width, screen_height);
		f.setResizable(false);
		f.addKeyListener(this); // listen for keypresses on this frame

		// sprite instantiation
		tank = new Tank("Boba Tank.png");


		// Add background
		bg = new Background("Floor.jpeg");

		// do not add to frame, call paint on
		// these objects in paint method

		f.add(this);
		t = new Timer(12, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	Timer t;

	@Override
	public void keyPressed(KeyEvent e) {
		// detect up, down, left, right arrow keypresses
		// call setters for volovety attributes accordingly
		// 37 <- ,
		// 38 up ,
		// 40 down,
		// 39 ->

		switch (e.getKeyCode()) {

		case 37: // left
			tank.rotateCounterClockwise();
            break;

		case 38: // up
			tank.setVy(-5);
			tank.setVx(0);
			temp2 = true;
			break;
		case 39: // right
            tank.rotateClockwise();
			break;
			
		case 40: //down
			tank.setVy(5);
			temp2 = true;
			break;

		/*
		 * case KeyEvent.VK_W: // up tank.hop(10); break;
		 * 
		 * case KeyEvent.VK_S: // down break;
		 */

		// handle going left and right
		// A and D keys

		}

	}


	
	@Override
	public void keyReleased(KeyEvent e) {
		/*
		 * turn off velocity for Frog if you don't want it moving when you have stopped
		 * pressing the keys
		 */
		if (e.getKeyCode() == 38) {
			tank.setVy(0);
			tank.setVx(0);
			
		}

		if (e.getKeyCode() == 39) {
			tank.setVy(0);
			tank.setVx(0);
			
		}

		if (e.getKeyCode() == 37) {
			tank.setVy(0);
			tank.setVx(0);
		}
		
		if (e.getKeyCode() == 40) {
			tank.setVy(0);
			tank.setVx(0);
		}

		// do the same thing for the other keys
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}