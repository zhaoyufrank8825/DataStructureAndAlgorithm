package stringSort;

import java.util.ArrayList;

public class ThreewayQuick {
	public static void main(String[] args){
		String st = "2134,210,0124,1234,1100,1005,1110,1342"
				+ ",3130,52321,0223,2345200,1232,"
				+ "100,200,1001,1002,1003,1001";
		sort(st);
	}
	
	public static void sort(String s){
		String[] st = s.split(",");	
		sort(st, 0, st.length-1, 0);
		
		for(int i=0; i<st.length; i++)
			System.out.println(st[i]);
	}
	
	public static void sort(String[] str, int lo, int hi, int d){
		if( lo >= hi) return;
		
		int lt = lo, gt = hi, i=lo+1;
		int v = charAt(str[lo], d);
		while( i <= gt ){
			int t =  charAt(str[i], d);
			if( t < v) exchange(str, lt++, i++);
			else if ( t > v ) exchange(str, i, gt--);
			else i++;
		}
		
		sort(str, lo, lt-1, d);
		if( v>=0 ) sort(str, lt, gt,d+1);
		sort(str, gt+1, hi,d);
	}
	
	private static void exchange(String[] str, int i, int j){
		String temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}
	
	public static int charAt(String s, int d){
		if(d < s.length()) return s.charAt(d);
		else return -1;
	}
}
