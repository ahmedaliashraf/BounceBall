package cmp428;

import java.awt.Color;
import java.awt.Graphics;

public class CircleBetter {
	
	double x,y;
	int r;
	double velocityX = 0.0;
	double velocityY = 0.0;
	double gravity = 0.4;
	//double currenGroundX;
	double currentGroundY;
	boolean isOnGround,hitCeiling;
	boolean hasCollided=false;
	Rect rectangle;
	
	public CircleBetter(double x, double y, int r) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
		isOnGround = false;
		hitCeiling = false;
		//this.currenGroundX = x;
		this.currentGroundY = y;
		rectangle = new Rect((int)x-r,(int)y-r,r*2,r*2);
	}
	
	public void draw(Graphics g){
		update();
		g.setColor(Color.RED);
		g.fillOval((int)x-r, (int)y-r, 2*r, 2*r);
		g.setColor(Color.BLACK);
		g.drawOval((int)x-r, (int)y-r, 2*r, 2*r);
		g.setColor(Color.BLACK);
		//rectangle.draw(g);
	}
	
	public void moveForwardBy(int dx){
		x += dx;
		rectangle.moveRightBy(dx);
		Camera2D.moveRightBy(dx);
	}
	
	public void moveBackwardBy(int dx){
		x -= dx;
		rectangle.moveLeftBy(dx);
		Camera2D.moveLeftBy(dx);
	}
	
	public void moveBy(int dx, int dy){
		x += dx;
		y += dy;
	}
	
	public void jumpUp() {
		//y -= dy;
		startJump();
		rectangle.x = (int)x-r;
		rectangle.y = (int)y-r;
	}

//	public void moveDownBy(int dy) {
//		y += dy;
//	}
	
	private void startJump(){
		if(isOnGround){
	        velocityY = -11.0;
	        isOnGround = false;
	    }
	}
	
	private void endJump(){
	    if(velocityY < -3.0)	velocityY = -3.0;

	}
	
	private void update()
	{
		updateCurrentGround();
		y += velocityY;
	    velocityY += gravity;
	    
	    x += velocityX;
	    
	    if(y > currentGroundY)
	    {
	        y = currentGroundY;
	        velocityY = 0.0;
	        isOnGround = true;
	    }
//	    if(y<=61){
//	    	y = currentGroundY;
//	        velocityY = 0.0;
//	        hitCeiling = true;
//	    }
//	    if(hasCollided){
//	    	y = currentGroundY;
//	        velocityY = 0.0;
//	        isOnGround = true;
//	    }
	    
//	    if(x < 10 || x > 190)
//	        velocityX *= -1;
//	    if(x < 20)	velocityX *= -1;
		rectangle.x = (int)x-r;
		rectangle.y = (int)y-r;
		
	}
	
//	public void hasCollidedWith(Rect[] rArr){
//		for(int i = 0; i<rArr.length;i++){
//			if (rectangle.hasCollidedWith(rArr[i])){
//				hasCollided = true;
//				break;
//			}
//		}
//	}
	public void hasCollidedWith(Rect rt){
		if (rectangle.hasCollidedWith(rt)){
			hasCollided = true;
		}
	}
	
	private void updateCurrentGround(){
	    if(x<235){
	    	currentGroundY = 695;
	    }
	    if (x>=235 && x<430){
	    	currentGroundY = 575;
	    }
	    if (x>=430 && x<474){
	    	currentGroundY = 495;
	    }
	    if (x>=474 && x<529){
	    	currentGroundY = 410;
	    }
	    if (x>=529 && x<580){
	    	currentGroundY = 361;
	    }
	    if (x>=580 && x<631){
	    	currentGroundY = 220;
	    }
	    if (x>=631 && x<712){
	    	currentGroundY = 170;
	    }
	    if (x>=712 && x<730){
	    	currentGroundY = 220;
	    }
	    if (x>=730 && x<814){
	    	currentGroundY = 170;
	    }
	    if (x>=814 && x<960){
	    	currentGroundY = 280;
	    }
	    if (x>=960 && x<1010){
	    	currentGroundY = 345;
	    }
	    if (x>=1010 && x<1105){
	    	currentGroundY = 480;
	    }
	    if (x>=1105 && x<1158){
	    	currentGroundY = 608;
	    }
	    if (x>=1158){
	    	currentGroundY = 670;
	    }
	    
	}
	
}
