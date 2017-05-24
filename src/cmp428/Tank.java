package cmp428;

import java.awt.Color;
import java.awt.Graphics;
import cmp428.GameApplet;
public class Tank extends PolygonModel2D{
	
	public Tank(double x, double y, int angle) {
		super(x,y,angle);
	}
	
	public int[][] x_data()
	{
		int[][] struct_x =
		{
			{50,-50,-50,50},
			{40,-40,-40,40},
			{40,-40,-40,40},
			{45,15,15,45}	
		};
		return struct_x;
	}
	
	public int[][] y_data()
	{
		int[][] struct_y =
		{
			{30,30,-30,-30},
			{-30,-30,-40,-40},
			{30,30,40,40},
			{3,3,-3,-3}
		};
		return struct_y;
	}
	
	public void draw(Graphics g){
		super.draw(g);
		g.drawOval((int)x-15, (int)y-15, 30, 30);
	}

	@Override
	public Color[] getColors() {
		Color[] c = {new Color(150,200,150), new Color(192,192,192), new Color(192,192,192), Color.green};
		return c;
	}
	
	public void respondToInput(boolean[] input){
		if(input[GameApplet.UP])	moveForwardBy(3);
		if(input[GameApplet.DN])	moveBackwardBy(1);
		if(input[GameApplet.LT])	rotateLeftBy(3);
		if(input[GameApplet.RT])	rotateRightBy(1);
	}
	
}
