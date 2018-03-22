package binarysearch;


public class Test {
	public static void main(String[] args){
		int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(Recursion.Bsearch(arr, 6, 0, arr.length-1));
		System.out.println(Iteration.itSearch(arr, 6));
		
		
	}
}
