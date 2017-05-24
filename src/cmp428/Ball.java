package cmp428;

public class Ball extends CircleBetter {
	Rect rectangle;
	public Ball(double x, double y, int r) {
		super(x, y, r);
		// TODO Auto-generated constructor stub
	}
	
	public void respondToInput(boolean[] input){
		if(input[GameApplet.UP])	jumpUp();
		//if(input[GameApplet.DN])	moveBackwardBy(1);
		if(input[GameApplet.RT])	moveForwardBy(1);
		if(input[GameApplet.LT])	moveBackwardBy(1);
	}

}
