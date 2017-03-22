package cmp428;

public class GreenGuy extends Sprite {
	
	private static final String[] action = {"up","dn","lt","rt"};
	
	public static final int UP = 0;
	public static final int DN = 1;
	public static final int LT = 2;
	public static final int RT = 3;

	public GreenGuy(int x, int y) {
		super(x, y, 20, 50,"greenGuyImages/g", 5, 10, action);
	}

}
