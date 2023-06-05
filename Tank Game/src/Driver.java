
//https://github.com/domingodavid/froggerEclipse

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
	boolean fired = false;
	boolean fired2 = false;
	boolean temp2 = true;
	private Map strawberry;
	private Map matcha;
	// Music hop = new Music("Sweep.wav", false);

	// hop.play

	int screen_width = 800;
	int screen_height = 800;
	boolean isHome = true;
	boolean isSelectP1 = false;
	boolean isSelectP2 = false;
	boolean isSelectMap = false;
	boolean isGame = false;
	int tank1;
	int tank2;
	
	Tank p1;
	Tank p2;
	Tank regEx;
	Tank matchaEx;
	Tank thaiEx;
	Tank taroEx;
	Tank strawberryEx;
	Tank regEx2;
	Tank matchaEx2;
	Tank thaiEx2;
	Tank taroEx2;
	Tank strawberryEx2;
	Ball b;
	Ball b2;
	int map;

	Background bg;
	Background start;
	Background m;
	int lives1 = 5;
	int lives2 = 5;

	String lose = "";
	String win = "";
	String lost = "";

	// ****************************paint
	// method******************************************
	public void paint(Graphics g) {
		super.paintComponent(g);
		if(isHome) {
			isSelectP1 = false;
			isSelectP2 = false;
			isSelectMap = false;
			isGame = false;
			start.paint(g);
			g.setFont(new Font("Courier New", 1, 100));
			g.setColor(Color.black);
		    g.drawString("BOBA TANKS", 95, 300);
		    g.setFont(new Font("Courier New", 1, 30));
		    g.drawString("Press space to start", 200, 400);
		}
		else if(isSelectP1) {
			isHome = false;
			isSelectP2 = false;
			isSelectMap = false;
			isGame = false;
			start.paint(g);
			g.setFont(new Font("Courier New", 1, 35));
			g.setColor(Color.black);
		    g.drawString("Player 1: Choose your boba flavor!", 30, 100);
		    g.setFont(new Font("Courier New", 1, 20));
			regEx.paint(g);
			regEx.setX(75);
			regEx.setY(200);
			g.drawString("Brown Sugar", 65, 300);
			g.drawString("Press 1", 85, 325);
			matchaEx.paint(g);
			matchaEx.setX(325);
			matchaEx.setY(200);
			g.drawString("Matcha", 342, 300);
			g.drawString("Press 2", 335, 325);
			thaiEx.paint(g);
			thaiEx.setX(575);
			thaiEx.setY(200);
			g.drawString("Thai", 605, 300);
			g.drawString("Press 3", 585, 325);
			taroEx.paint(g);
			taroEx.setX(188);
			taroEx.setY(400);
			g.drawString("Taro", 218, 500);
			g.drawString("Press 4", 200, 525);
			strawberryEx.paint(g);
			strawberryEx.setX(444);
			strawberryEx.setY(400);
			g.drawString("Strawberry", 440, 500);
			g.drawString("Press 5", 460, 525);
		}
		else if(isSelectP2) {
			isHome = false;
			isSelectP1 = false;
			isSelectMap = false;
			isGame = false;
			start.paint(g);
			g.setFont(new Font("Courier New", 1, 35));
			g.setColor(Color.black);
		    g.drawString("Player 2: Choose your boba flavor!", 30, 100);
		    g.setFont(new Font("Courier New", 1, 20));
			regEx2.paint(g);
			regEx2.setX(75);
			regEx2.setY(200);
			g.drawString("Brown Sugar", 65, 300);
			g.drawString("Press 1", 85, 325);
			matchaEx2.paint(g);
			matchaEx2.setX(325);
			matchaEx2.setY(200);
			g.drawString("Matcha", 342, 300);
			g.drawString("Press 2", 335, 325);
			thaiEx2.paint(g);
			thaiEx2.setX(575);
			thaiEx2.setY(200);
			g.drawString("Thai", 605, 300);
			g.drawString("Press 3", 585, 325);
			taroEx2.paint(g);
			taroEx2.setX(188);
			taroEx2.setY(400);
			g.drawString("Taro", 218, 500);
			g.drawString("Press 4", 200, 525);
			strawberryEx2.paint(g);
			strawberryEx2.setX(444);
			strawberryEx2.setY(400);
			g.drawString("Strawberry", 440, 500);
			g.drawString("Press 5", 460, 525);
		}
		else if(isSelectMap) {
			start.paint(g);
			if(tank1 == 1) {
				p1 = regEx;
			}
			if(tank2 == 1) {
				p2 = regEx2;
			}
			if(tank1 == 2) {
				p1 = matchaEx;
			}
			if(tank2 == 2) {
				p2 = matchaEx2;
			}
			if(tank1 == 3) {
				p1 = thaiEx;
			}
			if(tank2 == 3) {
				p2 = thaiEx2;
			}
			if(tank1 == 4) {
				p1 = taroEx;
			}
			if(tank2 == 4) {
				p2 = taroEx2;
			}
			if(tank1 == 5) {
				p1 = strawberryEx;
			}
			if(tank2 == 5) {
				p2 = strawberryEx2;
			}
			Tank strawberryMap = new Tank("Strawberry Map.png");
			Tank matchaMap = new Tank("Matcha Map.png");
			strawberryMap.setX(500);
			strawberryMap.setY(300);
			strawberryMap.paint(g);
			matchaMap.setX(200);
			matchaMap.setY(300);
			matchaMap.paint(g);
			g.setFont(new Font("Courier New", 1, 35));
			g.setColor(Color.black);
		    g.drawString("Choose your map!", 225, 100);
		    g.setFont(new Font("Courier New", 1, 20));
		    g.drawString("Matcha Map", 190, 425);
		    g.drawString("Press 1", 200, 450);
		    g.drawString("Strawberry Map", 450, 425);
		    g.drawString("Press 2", 480, 450);
		}
		else if(isGame) {
			isHome = false;
			isSelectP1 = false;
			isSelectP2 = false;
			isSelectMap = false;

		g.setColor(Color.black);
//		for (int i = 0; i < 800; i += 20) {
//			g.drawLine(i, 0, i, 800);
//			g.drawLine(0, i, 800, i);
//		}
		if(map == 2) {
			bg.paint(g);
		strawberry = new Map();
		strawberry.addWall(0, 0, 800, 20);
		strawberry.addWall(0, 0, 20, 800);
		strawberry.addWall(760, 0, 30, 800);
		strawberry.addWall(0, 780, 800, 20);
		strawberry.addWall(120, 180, 20, 260);
		strawberry.addWall(640, 180, 20, 260);
		strawberry.addWall(240, 440, 20, 160);
		strawberry.addWall(520, 440, 20, 160);
		strawberry.addWall(360, 640, 60, 20);
		strawberry.addWall(240, 140, 300, 20);
		strawberry.addWall(280, 120, 220, 20);
		strawberry.addWall(380, 60, 20, 60);
		strawberry.addWall(240, 260, 20, 20);
		strawberry.addWall(340, 260, 20, 20);
		strawberry.addWall(420, 260, 20, 20);
		strawberry.addWall(520, 260, 20, 20);
		strawberry.addWall(280, 360, 20, 20);
		strawberry.addWall(380, 360, 20, 20);
		strawberry.addWall(480, 360, 20, 20);
		strawberry.addWall(420, 460, 20, 20);
		strawberry.addWall(340, 460, 20, 20);
		strawberry.addWall(380, 560, 20, 20);
		Color x = new Color(97, 138, 61);
		g.setColor(x);;
		for(int i = 0; i < strawberry.getMap().size(); i++) {
			g.fillRect(strawberry.getMap().get(i).getX(), strawberry.getMap().get(i).getY(), strawberry.getMap().get(i).getWidth(), strawberry.getMap().get(i).getHeight());
		}
		}
		if(map == 1) {
			m.paint(g);
			matcha = new Map();
			matcha.addWall(0, 0, 800, 20);
			matcha.addWall(0, 0, 20, 800);
			matcha.addWall(760, 0, 30, 800);
			matcha.addWall(0, 780, 800, 20);
			matcha.addWall(120, 240, 20, 240);
			matcha.addWall(100, 240, 20, 20);
			matcha.addWall(100, 460, 20, 20);
			matcha.addWall(660, 240, 20, 20);
			matcha.addWall(640, 240, 20, 240);
			matcha.addWall(660, 460, 20, 20);
			matcha.addWall(120, 100, 80, 20);
			matcha.addWall(120, 600, 80, 20);
			matcha.addWall(580, 600, 80, 20);
			matcha.addWall(580, 100, 80, 20);
			matcha.addWall(220, 320, 40, 80);
			matcha.addWall(520, 320, 40, 80);
			matcha.addWall(260, 140, 20, 80);
			matcha.addWall(260, 140, 80, 20);
			matcha.addWall(440, 140, 80, 20);
			matcha.addWall(500, 140, 20, 80);
			matcha.addWall(260, 500, 20, 80);
			matcha.addWall(260, 560, 80, 20);
			matcha.addWall(440, 560, 80, 20);
			matcha.addWall(500, 500, 20, 80);
			g.setColor(Color.white);
			for(int i = 0; i < matcha.getMap().size(); i++) {
				g.fillRect(matcha.getMap().get(i).getX(), matcha.getMap().get(i).getY(), matcha.getMap().get(i).getWidth(), matcha.getMap().get(i).getHeight());
			}
		}

		g.setFont(new Font("Courier New", 1, 30));
		g.setColor(Color.black);
		g.drawString(("Lives:") + Integer.toString(lives1), 20, 20);
		g.drawString(("Lives:") + Integer.toString(lives2), 635, 20);
		g.setFont(font2);

		// paint and update tank
		p1.paint(g);
		p2.paint(g);
//		g.drawRect(tank.getX() + 28, tank.getY() + 30, tank.getWidth() - 56, tank.getHeight() - 60);
		if(fired) {
			if(b != null) {
			b.paint(g);
			//g.drawRect(b.getX(), b.getY(), b.getW(), b.getH());
			}
		}
		if(fired2) {
			if(b2 != null) {
				b2.paint(g);
			}
		}
		if(lives1 == 0 || lives2 == 0) {
			start.paint(g);
			if(lives1 == 0) {
				g.setFont(new Font("Courier New", 1, 100));
				g.setColor(Color.black);
				g.drawString("Player 1 wins!", 5, 300);
				g.setFont(new Font("Courier New", 1, 30));
			    g.drawString("Press space to restart", 200, 400);
			}
			else {
				g.setFont(new Font("Courier New", 1, 100));
				g.setColor(Color.black);
				g.drawString("Player 2 wins!", 5, 300);
				g.setFont(new Font("Courier New", 1, 30));
			    g.drawString("Press space to restart", 200, 400);
			}
		}
		
		// Draw tank angle
//	    g.setColor(Color.black);
//	    g.drawString("Tank Angle: " + p1.getAngle(), 20, 60);
		}
	}

	Font font = new Font("Courier New", 1, 50);
	Font font2 = new Font("Courier New", 1, 30);

	//
	public void update() {
		boolean colid = false;
		boolean colid2 = false;
		if(map == 2) {
		if(strawberry != null) {
		for(int i = 0; i < strawberry.getMap().size(); i++) {
			if(p1.collided(strawberry.getMap().get(i).getX(), strawberry.getMap().get(i).getY(), strawberry.getMap().get(i).getWidth(), strawberry.getMap().get(i).getHeight())) {
				colid = true;
				p1.setVx(-p1.getVx() * 10);
				p1.setVy(-p1.getVy() * 10);
			}
			if(fired) {
				if(b.collided(p2.getX() + 28, p2.getY() + 30, p2.getWidth() - 56, p2.getHeight() - 60)) {
					b.setx(900);
					b.sety(900);
					b.setvx(0);
					b.setvy(0);
					p1.setVx(0);
					p1.setVy(0);
					p2.setVx(0);
					p2.setVy(0);
					p1.setAngle(0);
					p2.setAngle(0);
					p1.setX(650);
					p1.setY(250);
					p2.setX(20);
					p2.setY(260);
					fired = false;
					lives1--;
				}
				if(b.collided(strawberry.getMap().get(i).getX(), strawberry.getMap().get(i).getY(), strawberry.getMap().get(i).getWidth(), strawberry.getMap().get(i).getHeight())) {
					b.setx(900);
					b.sety(900);
					b.setvx(0);
					b.setvy(0);
					fired = false;
				}
			}
				if(fired2) {
					if(b2.collided(p1.getX() + 28, p1.getY() + 30, p1.getWidth() - 56, p1.getHeight() - 60)) {
						b2.setx(900);
						b2.sety(900);
						b2.setvx(0);
						b2.setvy(0);
						p1.setVx(0);
						p1.setVy(0);
						p2.setVx(0);
						p2.setVy(0);
						p1.setAngle(0);
						p2.setAngle(0);
						p1.setX(650);
						p1.setY(250);
						p2.setX(20);
						p2.setY(260);
						fired2 = false;
						lives2--;
					}
					if(b2.collided(strawberry.getMap().get(i).getX(), strawberry.getMap().get(i).getY(), strawberry.getMap().get(i).getWidth(), strawberry.getMap().get(i).getHeight())) {
						b2.setx(900);
						b2.sety(900);
						b2.setvx(0);
						b2.setvy(0);
						fired2 = false;
					}
			}
			if(p2.collided(strawberry.getMap().get(i).getX(), strawberry.getMap().get(i).getY(), strawberry.getMap().get(i).getWidth(), strawberry.getMap().get(i).getHeight())) {
				colid2 = true;
				p2.setVx(-p2.getVx() * 10);
				p2.setVy(-p2.getVy() * 10);
			}
		}
		if(p1 != null) {
			p1.move();
		}
		if(p2 != null) {
			p2.move();
		}
		if(colid) {
			p1.setVx(0);
			p1.setVy(0);
		}
		if(colid2) {
			p2.setVx(0);
			p2.setVy(0);
		}
		}
		}
		if(map == 1) {
			if(matcha != null) {
				for(int i = 0; i < matcha.getMap().size(); i++) {
					if(fired) {
						if(b.collided(p2.getX() + 28, p2.getY() + 30, p2.getWidth() - 56, p2.getHeight() - 60)) {
							b.setx(900);
							b.sety(900);
							b.setvx(0);
							b.setvy(0);
							p1.setVx(0);
							p1.setVy(0);
							p2.setVx(0);
							p2.setVy(0);
							p1.setAngle(0);
							p2.setAngle(0);
							p1.setX(650);
							p1.setY(315);
							p2.setX(20);
							p2.setY(315);  
							fired = false;
							lives1--;
						}
						if(b.collided(matcha.getMap().get(i).getX(), matcha.getMap().get(i).getY(), matcha.getMap().get(i).getWidth(), matcha.getMap().get(i).getHeight())) {
							b.setx(900);
							b.sety(900);
							b.setvx(0);
							b.setvy(0);
							fired = false;
						}
					}
						if(fired2) {
							if(b2.collided(p1.getX() + 28, p1.getY() + 30, p1.getWidth() - 56, p1.getHeight() - 60)) {
								b2.setx(900);
								b2.sety(900);
								b2.setvx(0);
								b2.setvy(0);
								fired2 = false;
								p1.setVx(0);
								p1.setVy(0);
								p2.setVx(0);
								p2.setVy(0);
								p1.setAngle(0);
								p2.setAngle(0);
								p1.setX(650);
								p1.setY(315);
								p2.setX(20);
								p2.setY(315);  
								lives2--;
							}
							if(b2.collided(matcha.getMap().get(i).getX(), matcha.getMap().get(i).getY(), matcha.getMap().get(i).getWidth(), matcha.getMap().get(i).getHeight())) {
								b2.setx(900);
								b2.sety(900);
								b2.setvx(0);
								b2.setvy(0);
								fired2 = false;
							}
						}
					if(p1.collided(matcha.getMap().get(i).getX(), matcha.getMap().get(i).getY(), matcha.getMap().get(i).getWidth(), matcha.getMap().get(i).getHeight())) {
						colid = true;
						p1.setVx(-p1.getVx() * 10);
						p1.setVy(-p1.getVy() * 10);
					}
					if(p2.collided(matcha.getMap().get(i).getX(), matcha.getMap().get(i).getY(), matcha.getMap().get(i).getWidth(), matcha.getMap().get(i).getHeight())) {
						colid2 = true;
						p2.setVx(-p2.getVx() * 10);
						p2.setVy(-p2.getVy() * 10);
					}
				}
				}
			if(p1 != null) {
				p1.move();
			}
			if(p2 != null) {
				p2.move();
			}
			if(colid) {
				p1.setVx(0);
				p1.setVy(0);
			}
			if(colid2) {
				p2.setVx(0);
				p2.setVy(0);
			}
				
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(isGame) {
		update();
		}
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

		b = new Ball();
		b2 = new Ball();
		// sprite instantiation
		regEx = new Tank("Boba Tank.png");
		matchaEx = new Tank("matcha.png");
		thaiEx = new Tank("thai.png");
		taroEx = new Tank("taro.png");
		strawberryEx = new Tank("strawberry.png");
		regEx2 = new Tank("Boba Tank.png");
		matchaEx2 = new Tank("matcha.png");
		thaiEx2 = new Tank("thai.png");
		taroEx2 = new Tank("taro.png");
		strawberryEx2 = new Tank("strawberry.png");
		//b = new Ball(5, 5, tank.getX(), tank.getY(), "Boba.png");

		// Add background
		start = new Background("start.png");
		start.resize(2, 2);
		bg = new Background("strawberry (1).png");
		bg.resize(2, 2);
		m = new Background("matcham.png");
		m.resize(3, 3);
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
			if(isGame) {
				p1.rotateCounterClockwise();
			}
			break;

		case 38: // up
			if(isGame) {
			double radians = Math.toRadians(p1.getAngle());
			double dx = Math.sin(radians);
			double dy = -Math.cos(radians);
			p1.setVx((int) (2 * dx)); // Set the velocity components based on the angle
			p1.setVy((int) (2 * dy));
			temp2 = true;
			}
			break;
		case 39: // right
			if(isGame) {
				p1.rotateClockwise();
			}
			break;

		case 40: // down
			if(isGame) {
			double rads = Math.toRadians(p1.getAngle());
			double dx2 = Math.sin(rads);
			double dy2 = -Math.cos(rads);
			p1.setVx(-(int) (2 * dx2)); // Set the velocity components based on the angle
			p1.setVy(-(int) (2 * dy2));
			temp2 = true;
			}
			break;
		case 65: // left
			if(isGame) {
				p2.rotateCounterClockwise();
			}
			break;

		case 87: // up
			if(isGame) {
			double radians = Math.toRadians(p2.getAngle());
			double dx1 = Math.sin(radians);
			double dy1 = -Math.cos(radians);
			p2.setVx((int) (2 * dx1)); // Set the velocity components based on the angle
			p2.setVy((int) (2 * dy1));
			temp2 = true;
			}
			break;
		case 68: // right
			if(isGame) {
				p2.rotateClockwise();
			}
			break;

		case 83: // down
			if(isGame) {
			double rads = Math.toRadians(p2.getAngle());
			double dx12 = Math.sin(rads);
			double dy12 = -Math.cos(rads);
			p2.setVx(-(int) (2 * dx12)); // Set the velocity components based on the angle
			p2.setVy(-(int) (2 * dy12));
			temp2 = true;
			}
			break;
		case 32:
			if(isHome) {
				isHome = false;
				isSelectP1 = true;
				isSelectP2 = false;
				isSelectMap = false;
				isGame = false;
			}
			if(lives1 == 0 || lives2 == 0) {
				isGame = false;
				isHome = true;
				lives1 = 5;
				lives2 = 5;
			}
			break;
			/*
			 * case KeyEvent.VK_W: // up tank.hop(10); break;
			 * 
			 * case KeyEvent.VK_S: // down break;
			 */

			// handle going left and right
			// A and D keys
		case 49:
			if(isSelectP1) {
				isHome = false;
				isSelectP1 = false;
				isSelectP2 = true;
				isSelectMap = false;
				isGame = false;
				tank1 = 1;
			}
			else if(isSelectP2) {
				isHome = false;
				isSelectP1 = false;
				isSelectP2 = false;
				isSelectMap = true;
				isGame = false;
				tank2 = 1;
			}
			else if(isSelectMap) {
				isHome = false;
				isSelectP1 = false;
				isSelectP2 = false;
				isSelectMap = false;
				isGame = true;
				map = 1;
				p1.setX(650);
				p1.setY(315);
				p2.setX(20);
				p2.setY(315);  
			}
			break;
		case 50:
			if(isSelectP1) {
				isHome = false;
				isSelectP1 = false;
				isSelectP2 = true;
				isSelectMap = false;
				isGame = false;
				tank1 = 2;
			}
			else if(isSelectP2) {
				isHome = false;
				isSelectP1 = false;
				isSelectP2 = false;
				isSelectMap = true;
				isGame = false;
				tank2 = 2;
			}
			else if(isSelectMap) {
				isHome = false;
				isSelectP1 = false;
				isSelectP2 = false;
				isSelectMap = false;
				isGame = true;
				map = 2;
				p1.setX(650);
				p1.setY(250);
				p2.setX(20);
				p2.setY(260);
			}
			break;
		case 51:
			if(isSelectP1) {
				isHome = false;
				isSelectP1 = false;
				isSelectP2 = true;
				isSelectMap = false;
				isGame = false;
				tank1 = 3;
			}
			else if(isSelectP2) {
				isHome = false;
				isSelectP1 = false;
				isSelectP2 = false;
				isSelectMap = true;
				isGame = false;
				tank2 = 3;
			}
			break;
		case 52:
			if(isSelectP1) {
				isHome = false;
				isSelectP1 = false;
				isSelectP2 = true;
				isSelectMap = false;
				isGame = false;
				tank1 = 4;
			}
			else if(isSelectP2) {
				isHome = false;
				isSelectP1 = false;
				isSelectP2 = false;
				isSelectMap = true;
				isGame = false;
				tank2 = 4;
			}
			break;
		case 53:
			if(isSelectP1) {
				isHome = false;
				isSelectP1 = false;
				isSelectP2 = true;
				isSelectMap = false;
				isGame = false;
				tank1 = 5;
			}
			else if(isSelectP2) {
				isHome = false;
				isSelectP1 = false;
				isSelectP2 = false;
				isSelectMap = true;
				isGame = false;
				tank2 = 5;
			}
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		/*
		 * turn off velocity for Frog if you don't want it moving when you have stopped
		 * pressing the keys
		 */
		if (e.getKeyCode() == 38) {
			if(isGame) {
				p1.setVy(0);
				p1.setVx(0);
			}
		}

		if (e.getKeyCode() == 39) {
			if(isGame) {
				p1.setVy(0);
				p1.setVx(0);
			}

		}

		if (e.getKeyCode() == 37) {
			if(isGame) {
				p1.setVy(0);
				p1.setVx(0);
			}
		}

		if (e.getKeyCode() == 40) {
			if(isGame) {
				p1.setVy(0);
				p1.setVx(0);
			}
		}
		if (e.getKeyCode() == 87) {
			if(isGame) {
				p2.setVy(0);
				p2.setVx(0);
			}
		}

		if (e.getKeyCode() == 65) {
			if(isGame) {
				p2.setVy(0);
				p2.setVx(0);
			}

		}

		if (e.getKeyCode() == 68) {
			if(isGame) {
				p2.setVy(0);
				p2.setVx(0);
			}
		}

		if (e.getKeyCode() == 83) {
			if(isGame) {
				p2.setVy(0);
				p2.setVx(0);
			}
		}
		
		if(e.getKeyCode() == 77) {
			//Ball b = new Ball();
			if(!fired && isGame) {
			fired = true;
			double rads = Math.toRadians(p1.getAngle());
			if(rads == 0.0) {
				b.setx(p1.getX() + 49);
				b.sety(p1.getY() + 10);
			}
			else if(rads == 0.78539816339744830) {
				b.setx(p1.getX() + 73);
				b.sety(p1.getY() + 23);
			}
			else if(rads == 1.5707963267948966) {
				b.setx(p1.getX() + 85);
				b.sety(p1.getY() + 47);
			}
			else if(rads == 2.356194490192345) {
				b.setx(p1.getX() + 73);
				b.sety(p1.getY() + 80);
			}
			else if(rads == 3.141592653589793) {
				b.setx(p1.getX() + 43);
				b.sety(p1.getY() + 85);
			}
			else if(rads == 3.9269908169872414) {
				b.setx(p1.getX() + 15);
				b.sety(p1.getY() + 75);
			}
			else if(rads == 4.71238898038469) {
				b.setx(p1.getX() + 9);
				b.sety(p1.getY() + 44);
			}
			else if(rads == 5.497787143782138) {
				b.setx(p1.getX() + 17);
				b.sety(p1.getY() + 15);
			}
			double dx = Math.sin(rads);
			double dy = -Math.cos(rads);
			b.setvx((int) (4 * dx)); // Set the velocity components based on the angle
			b.setvy((int) (4 * dy));
			b.move();
			}
		}
		if(e.getKeyCode() == 67) {
			//Ball b = new Ball();
			if(!fired2 && isGame) {
			fired2 = true;
			double rads = Math.toRadians(p2.getAngle());
			if(rads == 0.0) {
				b2.setx(p2.getX() + 49);
				b2.sety(p2.getY() + 10);
			}
			else if(rads == 0.78539816339744830) {
				b2.setx(p2.getX() + 73);
				b2.sety(p2.getY() + 23);
			}
			else if(rads == 1.5707963267948966) {
				b2.setx(p2.getX() + 85);
				b2.sety(p2.getY() + 47);
			}
			else if(rads == 2.356194490192345) {
				b2.setx(p2.getX() + 73);
				b2.sety(p2.getY() + 80);
			}
			else if(rads == 3.141592653589793) {
				b2.setx(p2.getX() + 43);
				b2.sety(p2.getY() + 85);
			}
			else if(rads == 3.9269908169872414) {
				b2.setx(p2.getX() + 15);
				b2.sety(p2.getY() + 75);
			}
			else if(rads == 4.71238898038469) {
				b2.setx(p2.getX() + 9);
				b2.sety(p2.getY() + 44);
			}
			else if(rads == 5.497787143782138) {
				b2.setx(p2.getX() + 17);
				b2.sety(p2.getY() + 15);
			}
			double dx = Math.sin(rads);
			double dy = -Math.cos(rads);
			b2.setvx((int) (4 * dx)); // Set the velocity components based on the angle
			b2.setvy((int) (4 * dy));
			b2.move();
			}
		}

		// do the same thing for the other keys
	}
	
	private boolean isAngleCloseToCardinalOrDiagonal(double angle) {
	    double angleDegrees = Math.toDegrees(angle);
	    return (Math.abs(angleDegrees) < 15 || Math.abs(angleDegrees - 45) < 15 || Math.abs(angleDegrees - 90) < 15
	            || Math.abs(angleDegrees - 135) < 15 || Math.abs(angleDegrees - 180) < 15
	            || Math.abs(angleDegrees - 225) < 15 || Math.abs(angleDegrees - 270) < 15
	            || Math.abs(angleDegrees - 315) < 15 || Math.abs(angleDegrees - 360) < 15);
	}
	
	private void handleCardinalOrDiagonalMovement(boolean isUp) {
	    int velocityMagnitude = 5;
	    if (isUp) {
	    	p1.setVx(0);
	    	p1.setVy(-velocityMagnitude);
	    } else {
	    	p1.setVx(0);
	    	p1.setVy(velocityMagnitude);
	    }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}