package cmp428;

import java.awt.Graphics;

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
	
}
