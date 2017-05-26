package cmp428;

public class Ball extends CircleBetter {
	private int lives;
	public Ball(double x, double y, int r) {
		super(x, y, r);
		lives = 3;
	}
	
	public void respondToInput(boolean[] input){
		if(input[GameApplet.UP])	jumpUp();
		if(input[GameApplet.DN])	stopJump();
		if(input[GameApplet.RT])	moveForwardBy(3);
		if(input[GameApplet.LT])	moveBackwardBy(2);
	}
	
	public void addLife(){
		if (lives<3){
			lives++;
		}
	}
	
	public void die(){
		if (lives>0){
			lives--;
		}
	}
	
	public void moveTo(double x, double y){
		this.x = x;
		this.y = y;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

}
