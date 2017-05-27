package bounce;

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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Line firstLine,secondLine,thirdLine,fourthLine,fifthLine,sixthLine,
		seventhLine,eigthLine,ninthLine,tenthLine,eleventhLine,twelveLine,thirteenthLine; 
	
	Ball B;
	BackgroundLayer background;
	Spike obs1,obs2,obs3,obs4;
	Life lifeR;
	Spike[] rArr;
	Life[] lifeRectArr;
	
	@Override
	public void initialize() {
		//Initialize Game objects
		B = new Ball(20,695,20);
		background = new BackgroundLayer("bounceBall/bounce_background.gif",0,0);
		//Initialize collision detection objects
		rArr = new Spike[4];lifeRectArr = new Life[1];//arrays to hold rects for obstacles, lives
		obs1 = new Spike(382,565,22,30,"bounceBall/spike.png");
		obs2 = new Spike(510,400,22,30,"bounceBall/spike.png");
		obs3 = new Spike(880,272,22,30,"bounceBall/spike.png");
		obs4 = new Spike(1050,470,22,30,"bounceBall/spike.png");
		rArr[0] = obs1;rArr[1] = obs2;rArr[2] = obs3;rArr[3]=obs4;
		lifeR = new Life(703,202,38,38,"bounceBall/life.png");
		lifeRectArr[0] = lifeR;
		
		firstLine = new Line(252,580,252,715);
		secondLine = new Line(450,500,450,715);
		thirdLine = new Line(492,400,492,717);
		fourthLine = new Line(544,300,544,717);
		fifthLine = new Line(595,200,595,717);
		sixthLine = new Line(646,100,646,717);
		seventhLine = new Line(697,100,697,717);
		eigthLine = new Line(748,100,748,717);
		ninthLine = new Line(799,100,799,717);
		tenthLine = new Line(945,100,945,717);
		eleventhLine = new Line(995,100,995,717);
		twelveLine = new Line(1090,100,1090,717);
		thirteenthLine = new Line(1140,100,1140,717);
	}

	@Override
	public void respondToInput() {
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
//		double d = firstLine.distanceTo((int)(B.x), (int)(B.y));
//		
//		if (d<B.r){
//			//B.moveBy((int)((B.r-d)*firstLine.getYV()), (int)((d-B.r)*firstLine.getXV()));
//			B.moveOnlyXBy((int)((B.r-d)*firstLine.getYV()));
//			B.velocityX = 0.0;
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
			if (lifeRectArr[i].isActive() && B.getLives()<3){
				if(B.hasCollidedWith(lifeRectArr[i])){
					B.addLife();
					lifeRectArr[i].setActive(false);
				}
			}
		}
	}
	
	public void paint(Graphics g){
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

		int counter = 5;
		for (int i = 0; i<B.getLives();i++){
			Life hp = new Life(counter,5,38,38,"bounceBall/life.png");
			hp.draw(g);
			counter+=38;
			hp.setActive(false);
		}
		
		if(B.x>=1200 && B.y>=600){
			g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 100));
			g.setColor(Color.BLUE);
			g.drawString("You Won!", 420, 375);
			paused = true;
		}
		
		//g.drawString(Double.toString(firstLine.distanceTo((int)B.x+20, (int)B.y)), 50, 50);
		for (int i = 0; i<rArr.length;i++){
			rArr[i].draw(g);
		}
		for (int i = 0; i<lifeRectArr.length;i++){
			lifeRectArr[i].draw(g);
		}
		if (B.getLives()==0){
			g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 100));
			g.setColor(Color.RED);
			g.drawString("Game Over!", 520, 375);
			//paused = true;
		}
		
		B.draw(g);
	}

}
