package stringSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class LRS {

	public static void main(String[] args) {
		String st = "2134210012412341100100511101342"
				+ "31305232102232345200123210031001"
				+ "100200100110021003100110041003";
		longer(st);
	}

	public static void longer(String s){
		int N = s.length();
		String[] suffixes = new String[N];
		LinkedList<String> list = new LinkedList<String>();
		
		for(int i=0; i<N; i++){
			suffixes[i] = s.substring(i);
			list.add(suffixes[i]);
		}
		
		Collections.sort(list);
//		for(int i=0; i<N; i++)
//			System.out.println(list.remove(0));
		
//		ThreewayQuick.sort(suffixes, 0, N-1, 0);
		
		String lrs = "";
		for(int i=0; i<N-1; i++){
//			int len = repeat(suffixes[i], suffixes[i+1]);
			int len = repeat(list.get(i), list.get(i+1));
			if( len > lrs.length() ){
	//			lrs = suffixes[i].substring(0, len);
				lrs = list.get(i).substring(0, len);
			}
		}
		
		System.out.println(lrs);
	}
	
	public static int repeat(String s, String t){
		int N = Math.min(s.length(), t.length());
		
		for( int i=0; i<N; i++){
			if( s.charAt(i) != t.charAt(i) ){
				return i;
			}
		}
		return N;
	}
}
