package cmp428;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Drawing extends GameApplet {
//	Image background = Toolkit.getDefaultToolkit().getImage("bounceBall/bounce_background.gif");
	Line firstLine = new Line(252,580,252,715);
	Line secondLine = new Line(450,500,450,715);
	Line thirdLine = new Line(492,400,492,717);
	Line fourthLine = new Line(544,300,544,717);
	Line fifthLine = new Line(595,200,595,717);
	Line sixthLine = new Line(646,100,646,717);
	Line seventhLine = new Line(697,100,697,717);
	Line eigthLine = new Line(748,100,748,717);
	Line ninthLine = new Line(799,100,799,717);
	Line tenthLine = new Line(945,100,945,717);
	Line eleventhLine = new Line(995,100,995,717);
	Line twelveLine = new Line(1090,100,1090,717);
	Line thirteenthLine = new Line(1140,100,1140,717);
//	Ball B = new Ball(20,257,20);
	
//	Tank tank = new Tank(200,200,0);
//	BadTank btank = new BadTank(200,400,0);
	
	Ball B;
	BackgroundLayer background;
	Rect obs1,obs2,obs3;
	Rect lifeR;
//	Rect bottom1;
	Rect[] rArr = new Rect[3];
	Rect[] lifeRectArr = new Rect[1];
	
	@Override
	public void initialize() {
		background = new BackgroundLayer("bounceBall/bounce_background.gif",0,0);
		B = new Ball(20,695,20);
		obs1 = new Rect(382,545,66,48);
		obs2 = new Rect(504,395,38,34);
		obs3 = new Rect(880,252,64,46);
		rArr[0] = obs1;
		rArr[1] = obs2;
		rArr[2] = obs3;
		lifeR = new Rect(703,202,38,38);
		lifeRectArr[0] = lifeR;
		//bottom1 = new Rect(0,250,100,200);
		//for(int i=0;i<2;i++){
		///rArr[0] = bottom0;
		//rArr[1] = bottom1;
		//}
	}

	@Override
	public void respondToInput() {
		//tank.respondToInput(input);
		B.respondToInput(input);
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
//		double d = groundLine.distanceTo((int)(C.x), (int)(C.y));
//		
//		if (d<C.r){
//			C.moveBy((int)((C.r-d)*groundLine.yv), (int)((d-C.r)*groundLine.xv));
//			//C.isOnGround = true;
//		}else{
//			//C.isOnGround = false;
//		}
//		d= midLine.distanceTo((int)(C.x), (int)(C.y));
//		if (d<C.r){
//			C.moveBy((int)((C.r-d)*midLine.yv), (int)((d-C.r)*midLine.xv));
//			//C.currenGroundX = C.x;
//			//C.currentGroundY = C.y;
//			C.isOnGround = true;
//			//C.hitCeiling = true;
//		}else{
//			//C.hitCeiling = false;
//		}
		for(int i = 0; i<rArr.length;i++){
			if(B.hasCollidedWith(rArr[i])){
				B.die();
				B.moveTo(20,695);
			}
		}
		for(int i = 0; i<lifeRectArr.length;i++){
			if (lifeRectArr[i].active){
				if(B.hasCollidedWith(lifeRectArr[i])){
					B.addLife();
					lifeRectArr[i].active = false;
				}
			}
		}
	}
	
	public void paint(Graphics g){
		//layer1.draw(g);
//		tank.draw(g);
//		btank.draw(g);
		background.draw(g);
		g.setColor(Color.BLUE);

//		firstLine.draw(g);
//		secondLine.draw(g);
//		thirdLine.draw(g);
//		fourthLine.draw(g);
//		fifthLine.draw(g);
//		sixthLine.draw(g);
//		seventhLine.draw(g);
//		eigthLine.draw(g);
//		ninthLine.draw(g);
//		tenthLine.draw(g);
//		eleventhLine.draw(g);
//		twelveLine.draw(g);
//		thirteenthLine.draw(g);
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage("bounceBall/door.jpg"), 1170 , 560, this);
		B.draw(g);
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
		g.setColor(Color.RED);
		g.drawString("Lives: "+Integer.toString(B.lives), 20, 20);
		
		if(B.x>=1200 && B.y>=600){
			g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 100));
			g.setColor(Color.BLUE);
			g.drawString("You Won!", 420, 375);
			paused = true;
		}
		
		//g.drawString(Double.toString(firstLine.distanceTo((int)B.x+20, (int)B.y)), 50, 50);
//		for (int i = 0; i<rArr.length;i++){
//			rArr[i].draw(g);
//		}
//		for (int i = 0; i<lifeRectArr.length;i++){
//			lifeRectArr[i].draw(g);
//		}
		if (B.lives==0){
			g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 100));
			g.setColor(Color.RED);
			g.drawString("Game Over!", 520, 375);
			//paused = true;
		}
		//bottom1.draw(g);
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
