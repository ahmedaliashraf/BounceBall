package cmp428;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Drawing extends GameApplet {
	Image background = Toolkit.getDefaultToolkit().getImage("bounceBall/bounce_background.gif");
	Line groundLine = new Line(600,278,0,278);
	Line midLine = new Line(600,158,254,158);
	Line ceilingLine = new Line(0,41,600,41);
	Ball C = new Ball(20,257,20);
//	Tank tank = new Tank(200,200,0);
//	BadTank btank = new BadTank(200,400,0);
	
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void respondToInput() {
		//tank.respondToInput(input);
		C.respondToInput(input);
		if(input[_D])	Camera2D.moveRightBy(50);
		if(input[_A])	Camera2D.moveLeftBy(50);
		
	}

	@Override
	public void moveGameObjects() {
		//btank.chase(tank);
	}

	@Override
	public void handleCollisions() {
		//Collision detection
		double d = groundLine.distanceTo((int)(C.x), (int)(C.y));
		
		if (d<C.r){
			C.moveBy((int)((C.r-d)*groundLine.yv), (int)((d-C.r)*groundLine.xv));
			//C.isOnGround = true;
		}else{
			//C.isOnGround = false;
		}
		d= midLine.distanceTo((int)(C.x), (int)(C.y));
		if (d<C.r){
			C.moveBy((int)((C.r-d)*midLine.yv), (int)((d-C.r)*midLine.xv));
			C.currenGroundX = C.x;
			C.currentGroundY = C.y;
			C.isOnGround = true;
			//C.hitCeiling = true;
		}else{
			//C.hitCeiling = false;
		}
		

	}
	
	public void paint(Graphics g){
		//layer1.draw(g);
//		tank.draw(g);
//		btank.draw(g);
		g.drawImage(background, 0, 0, this);
		ceilingLine.draw(g);
		midLine.draw(g);
		groundLine.draw(g);
		C.draw(g);
		
	}
		 
	
//	public void paint(Graphics g){
//		g.drawImage(background, 0, 0, this);
//		L.draw(g);
//		L2.draw(g);
//		C.draw(g);
//		tank.draw(g);
//		
//		if(L.distanceTo((int)C.x, (int)C.y)< C.r || L2.distanceTo((int)C.x, (int)C.y)< C.r) message = "Collision";
//		else							message = "No Collision";
//		g.drawString(message, 0, 10);
//		
//		/*
//		battlelord.draw(g);
//		greenguy.draw(g);
//		guard.draw(g);
//		//r.draw(g);r2.draw(g);
//		
//		//g.drawString(message, 0, 25);
//		//g.drawString(message2, 50, 25);
//		//*/
//	}
//	
//	
//	public void init(){
//		
//
//		
//		requestFocus();
//		addKeyListener(this);
//		addMouseListener(this);
//		
//		t = new Thread(this);
//		t.start();
//	}
//	
//
//	@Override
//	public void keyTyped(KeyEvent e) {}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		if (e.getKeyCode() == KeyEvent.VK_LEFT)	leftPressed = true;
//		if (e.getKeyCode() == KeyEvent.VK_RIGHT) rightPressed = true;
//		if (e.getKeyCode() == KeyEvent.VK_UP)	upPressed = true;
//		if (e.getKeyCode() == KeyEvent.VK_DOWN)	downPressed = true;
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		if (e.getKeyCode() == KeyEvent.VK_LEFT)	leftPressed = false;
//		if (e.getKeyCode() == KeyEvent.VK_RIGHT) rightPressed = false;
//		if (e.getKeyCode() == KeyEvent.VK_UP)	upPressed = false;
//		if (e.getKeyCode() == KeyEvent.VK_DOWN)	downPressed = false;
//	}
//	
//	String message = "0";
//	String message2 = "Missed";
//
//	
//
//	@Override
//	public void run() {
//		while (true){
//			//*
//			if (leftPressed){	
//				greenguy.moveLeftBy(2);
//				battlelord.moveLeftBy(2);
//				r.moveLeftBy(2);
//				if (C.isOnGround){
//					C.angle = 110;
//					C.moveForwardBy(3);
//					System.out.print("On Ground");
//				}
//				tank.rotateLeftBy(2);
//			}	
//			if (rightPressed){
//				greenguy.moveRightBy(2);
//				battlelord.moveRightBy(2);
//				r.moveRightBy(2);
//				if (C.isOnGround){
//					C.angle = 35;
//					C.moveForwardBy(3);
//					System.out.print("On Ground");
//				}
//				tank.rotateRightBy(2);
//			}
//			if (upPressed){
//				greenguy.moveUpBy(2);
//				battlelord.moveUpBy(2);
//				r.moveUpBy(2);
//				if(C.isOnGround){
//					C.jumpUpBy(6);
//				}
//				tank.moveForwardBy(3);
//			}
//			if (downPressed){
//				greenguy.moveDownBy(2);
//				battlelord.moveDownBy(2);
//				r.moveDownBy(10);
//				C.moveBackwardBy(2);
//				tank.moveBackwardBy(1);
//			}
//			/*
//			
//			repaint(); //asks OS to call paint
//			
//			if(r.hasCollidedWith(r2))	message2 = "collided";
//			else						message2 = "missed";
//			
//			try{
//				t.sleep(15);//
//			} catch(Exception x){};
//		}
//		
//	}

}
