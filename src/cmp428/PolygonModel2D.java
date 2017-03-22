package cmp428;

import java.awt.Graphics;

public abstract class PolygonModel2D {
	double x,y;
	int A;
	
	int[][] struct_x = x_data();
	
	int[][] struct_y = y_data();
	
	public PolygonModel2D(double x, double y, int angle) {
		super();
		this.x = x;
		this.y = y;
		A = angle;
	}
	
	public abstract int[][] x_data();
	public abstract int[][] y_data();
	
	public void draw(Graphics g){
		int[] xpoints = new int[4];
		int[] ypoints = new int[4];
		
		double cosA = Lookup.cos[A];
		double sinA = Lookup.sin[A];
		
		for(int poly = 0; poly < struct_x.length; poly++) {
			for(int vert = 0; vert < struct_x[poly].length; vert++){
				xpoints[vert] = (int) (struct_x[poly][vert]*cosA - struct_y[poly][vert]*sinA +x);
				ypoints[vert] = (int) (struct_x[poly][vert]*sinA + struct_y[poly][vert]*cosA +y);
			}
			g.drawPolygon(xpoints, ypoints, struct_x[poly].length);
		}
	}
	
	public void rotateLeftBy(int degrees){
		A -= degrees;
		if(A<0)		A+=360;
	}
	
	public void rotateRightBy(int degrees){
		A += degrees;
		if(A>359)	A-=360;
	}
	
	public void moveForwardBy(int d){
		x += (int) d * Lookup.cos[A];
		y += (int) d * Lookup.sin[A];
	}
	
	public void moveBackwardBy(int d){
		x -= (int) d * Lookup.cos[A];;
		y -= (int) d * Lookup.sin[A];		
	}
	

}

