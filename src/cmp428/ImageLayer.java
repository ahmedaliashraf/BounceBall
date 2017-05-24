package cmp428;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class ImageLayer {
	
	Image image;
	double x,y,z;
	
	int w;
	
	
	public ImageLayer(String fileName, double x, double y,double z,int w) {
		image = Toolkit.getDefaultToolkit().getImage(fileName);
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public void draw(Graphics g){
		for (int i= 0; i<50;i++){
			g.drawImage(image, (int)(x-Camera2D.x/z)+w*i, (int)(y-Camera2D.y), null);
		}
	}

}
