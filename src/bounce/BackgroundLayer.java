package bounce;

/**
 * Defines image to be drawn as the background
 * 
 * @author Ahmed Ashraf
 *
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class BackgroundLayer {
	
	private Image image;
	private double x,y;
	
	public BackgroundLayer(String fileName, double x, double y) {
		image = Toolkit.getDefaultToolkit().getImage(fileName);
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		g.drawImage(image, (int)(x), (int)(y), null);
	}

}
