package cmp428;

import java.awt.Color;
import java.awt.Graphics;

public class CircleBetter {
	
	double x,y;
	int r;
	double velocityX = 0.0;
	double velocityY = 0.0;
	double gravity = 0.4;
	double currenGroundX;
	double currentGroundY;
	boolean isOnGround,hitCeiling;
	
	public CircleBetter(double x, double y, int r) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
		isOnGround = false;
		hitCeiling = false;
		this.currenGroundX = x;
		this.currentGroundY = y;
	}
	
	public void draw(Graphics g){
		update();
		g.setColor(Color.RED);
		g.fillOval((int)x-r, (int)y-r, 2*r, 2*r);
		g.setColor(Color.BLACK);
		g.drawOval((int)x-r, (int)y-r, 2*r, 2*r);
	}
	
	public void moveForwardBy(int dx){
		x += dx;
	}
	
	public void moveBackwardBy(int dx){
		x -= dx;
	}
	
	public void moveBy(int dx, int dy){
		x += dx;
		y += dy;
	}
	
	public void jumpUpBy(int dy) {
		//y -= dy;
		startJump();
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
		y += velocityY;
	    velocityY += gravity;
	    
	    x += velocityX;
	    
	    if(y > currentGroundY)
	    {
	        y = currentGroundY;
	        velocityY = 0.0;
	        isOnGround = true;
	    }
	    
//	    if(x < 10 || x > 190)
//	        velocityX *= -1;
	    if(x < 1)
        velocityX *= -1;
	}
}
