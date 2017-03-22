package cmp428;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Drawing extends Applet implements Runnable, KeyListener, MouseListener{
	
	Line L = new Line(800,400,20,400);
	Line L2 = new Line(20,100,800,100);
	Circle C = new Circle(500,500,20);
	Tank tank = new Tank(200,200,0);
	
	
	
	BattleLord battlelord;
	GreenGuy greenguy;
	
	Sprite guard;
	
	Rect 	 r;
	Rect     r2;
	
	Thread t;
	
	boolean leftPressed = false;
	boolean rightPressed = false;
	boolean upPressed = false;
	boolean downPressed = false;	 
	
	public void paint(Graphics g){
		
		L.draw(g);
		L2.draw(g);
		C.draw(g);
		tank.draw(g);
		
		if(L.distanceTo(C.x, C.y)< C.r || L2.distanceTo(C.x, C.y)< C.r) message = "Collision";
		else							message = "No Collision";
		g.drawString(message, 0, 10);
		
		/*
		battlelord.draw(g);
		greenguy.draw(g);
		guard.draw(g);
		//r.draw(g);r2.draw(g);
		
		//g.drawString(message, 0, 25);
		//g.drawString(message2, 50, 25);
		//*/
	}
	
	public void init(){
		battlelord = new BattleLord(1000,300);
		greenguy = new GreenGuy(500,200);
		r = new Rect(500,400,100,50);
		r2 = new Rect(250,400,100,50);
		
		requestFocus();
		addKeyListener(this);
		addMouseListener(this);
		
		t = new Thread(this);
		t.start();
	}
	

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)	leftPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) rightPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_UP)	upPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)	downPressed = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)	leftPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) rightPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_UP)	upPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)	downPressed = false;
	}
	
	String message = "0";
	String message2 = "Missed";
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		message = "d = " + L.distanceTo(mx, my);
		
		/*
		if(r.contains(mx, my))	message = "Inside";
		else					message = "Outside";
		//*/
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void run() {
		while (true){
			//*
			if (leftPressed){	
				greenguy.moveLeftBy(2);
				battlelord.moveLeftBy(2);
				r.moveLeftBy(2);
				C.moveLeftBy(2);
				tank.rotateLeftBy(2);
			}	
			if (rightPressed){
				greenguy.moveRightBy(2);
				battlelord.moveRightBy(2);
				r.moveRightBy(2);
				C.moveRightBy(2);
				tank.rotateRightBy(2);
			}
			if (upPressed){
				greenguy.moveUpBy(2);
				battlelord.moveUpBy(2);
				r.moveUpBy(2);
				C.moveUpBy(2);
				tank.moveForwardBy(3);
			}
			if (downPressed){
				greenguy.moveDownBy(2);
				battlelord.moveDownBy(2);
				r.moveDownBy(10);
				C.moveDownBy(2);
				tank.moveBackwardBy(1);
			}
			//*/
			
			double d = L.distanceTo(C.x, C.y);
			double d2 = L2.distanceTo(C.x, C.y);
			if (d<C.r){
				C.moveBy((int)((C.r-d)*L.yv), (int)((d-C.r)*L.xv));
			} else if (d2<C.r){
				C.moveBy((int)((C.r-d2)*L2.yv), (int)((d2-C.r)*L2.xv));
			}
			
			repaint(); //asks OS to call paint
			
			if(r.hasCollidedWith(r2))	message2 = "collided";
			else						message2 = "missed";
			
			try{
				t.sleep(15);//
			} catch(Exception x){};
		}
		
	}

}
