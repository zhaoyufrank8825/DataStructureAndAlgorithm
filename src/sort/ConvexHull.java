//package sort;
//
//import java.util.Arrays;
//import java.util.Stack;
//
//public class ConvexHull {
//	public static void main(String[] args){
//		Stack<Point> hull = new Stack<Point>();
//		Point[] p = new Point[15];
//		
//		Arrays.sort(p, Point.Y_ORDER);
//		Arrays.sort(p, p[0].BY_POLAR_ORDER);
//		
//		hull.push(p[0]);
//		hull.push(p[1]);
//		
//		for(int i=2; i<p.length; i++){
//			Point top = hull.pop();
//			while( Point.ccw(hull.peek(), top, p[i]) <= 0 ){
//				top = hull.pop();
//			}
//			hull.push(top);
//			hull.push(p[i]);
//		}
//		
//	}
//}
