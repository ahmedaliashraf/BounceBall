package bounce;

/**
 * Extending Rect class, Spike defines 
 * the obstacle objects player will face
 * 
 * @author Ahmed Ashraf
 *
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Spike extends Rect{
	private Image image;
	private boolean active;
	
	public Spike(int x, int y, int w, int h, String fileName) {
		super(x, y, w, h);
		image = Toolkit.getDefaultToolkit().getImage(fileName);
		active = true;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public void draw (Graphics g){
		if(active)	g.drawImage(image, getX(), getY(), null);
	}
	
	
}
