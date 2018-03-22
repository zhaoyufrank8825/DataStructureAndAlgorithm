package sort;

public class Point {
	
	private final double x;
	private final double y;
	
	public Point(){
		this.x = 0;
		this.y = 0;
	}
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public static int ccw(Point a, Point b, Point c){
		double key = (b.x - a.x)*(c.y - a.y) - (b.y - a.y)*(c.x - a.x);
		if(key > 0 ){
			return 1;
		} else if (key < 0){
			return -1;
		}else {
			return 0;
		}
	}
}
