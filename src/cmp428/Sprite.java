package cmp428;

import java.awt.*;

public class Sprite {
	int x,y,w,h;
	Animation[] animation;
	
	public static final int UP = 0;
	public static final int DN = 1;
	public static final int LT = 2;
	public static final int RT = 3;
	
	//public static final int IDL = 0;
	int action = DN;
	
	boolean moving = false;
	
	public Sprite(int x, int y, int w, int h, String fileName, int count, int duration, String[] action){
		this.x = y;
		this.y = y;
		this.w = w;
		this.h = h;
		//image = Toolkit.getDefaultToolkit().getImage(fileName);
		animation = new Animation[action.length];
		
		for(int i=0;i<animation.length;i++){
			animation[i] = new Animation(fileName+"_"+action[i]+"_",count,duration);
		}
	}
	
	public boolean contains(int mx, int my){
		return ((mx < x+w) && (mx > x) && (my > y) && (my < y+h));
	}
	
	public boolean hasCollidedWith(Rect r){
		return ((r.x <= x+w) && (r.x+r.w >= x) && (r.y+r.h >= y) && (r.y <= y+h));
	}
	
	public void moveBy(int dx, int dy){
		x += dx;
		y += dy;
	}
	
	public void moveLeftBy(int dx){
		x -= dx;
		action = LT;
		moving = true;
	}
	
	public void moveRightBy(int dx){
		x += dx;
		action = RT;
		moving = true;
	}
	
	public void moveUpBy(int dy){
		y -= dy;
		action = UP;
		moving = true;
	}
	
	public void moveDownBy(int dy){
		y += dy;
		action = DN;
		moving = true;
	}
	

	public void draw(Graphics g){
		if (moving)		g.drawImage(animation[action].nextImage(), x, y, null);
		
		else			g.drawImage(animation[action].staticImage(), x, y, null);
		
		moving = false;
		//g.drawImage(animation[action].nextImage(), x, y, null);
		g.drawRect(x, y, w, h);
	}
}
