package cmp428;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class BackgroundLayer {
	
	Image image;
	double x,y;
	
	public BackgroundLayer(String fileName, double x, double y) {
		image = Toolkit.getDefaultToolkit().getImage(fileName);
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		g.drawImage(image, (int)(x), (int)(y), null);
	}

}
