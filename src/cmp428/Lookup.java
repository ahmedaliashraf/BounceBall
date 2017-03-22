package cmp428;

public interface Lookup {
	
	final static double[] cos = calcCos();
	final static double[] sin = calcSin();
	
	public static double[] calcSin(){
		double[] sin = new double[360];
		for(int i= 0; i < 360; i++){
			sin[i] = Math.sin(i*Math.PI/180);
		}
		
		return sin;
	}
	
	
	public static double[] calcCos(){
		double[] cos = new double[360];
		for(int i= 0; i < 360; i++){
			cos[i] = Math.cos(i*Math.PI/180);
		}
		
		return cos;
	}

}
