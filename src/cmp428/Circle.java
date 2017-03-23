package cmp428;

import java.awt.Color;
import java.awt.Graphics;

public class Circle {
	
	double x,y;
	int r;
	int angle;
	boolean isOnGround,hitCeiling;
	
	public Circle(double x, double y, int r, int angle) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
		this.angle = angle;
		isOnGround = true;
		hitCeiling = false;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillOval((int)x-r, (int)y-r, 2*r, 2*r);
		g.setColor(Color.BLACK);
		g.drawOval((int)x-r, (int)y-r, 2*r, 2*r);
		g.drawLine((int)x, (int)y, (int)(r*Lookup.cos[angle]+x),(int) (r*Lookup.sin[angle]+y));
	}
	
	public void rotateLeftBy(int degrees){
		angle -= degrees;
		if(angle<0)		angle+=360;
	}
	
	public void rotateRightBy(int degrees){
		angle += degrees;
		if(angle>359)	angle-=360;
	}
	
	public void moveForwardBy(int d){
		x += (int) d * Lookup.cos[angle];
		y += (int) d * Lookup.sin[angle];
	}
	
	public void moveBackwardBy(int d){
		x -= (int) d * Lookup.cos[angle];;
		y -= (int) d * Lookup.sin[angle];		
	}
	
	public void moveBy(int dx, int dy){
		x += dx;
		y += dy;
	}
	
	public void jumpUpBy(int dy) {
		y -= dy;
	}

//	public void moveDownBy(int dy) {
//		y += dy;
//	}
	
//	public void moveLeftBy(int dx){
//		x -= dx;
//	}
//	
//	public void moveRightBy(int dx){
//		x += dx;
//	}


}
