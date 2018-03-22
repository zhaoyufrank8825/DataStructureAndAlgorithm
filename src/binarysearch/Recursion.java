package binarysearch;

public class Recursion {
	
//	private int max;
//	private int mid;
//	private int min;
//	private int[] arr;
	
	
	public static int Bsearch(int[] arr, int val, int min, int max){

		int mid = (max + min)/2;
		
		if ( min > max ){
			return -1;
		}
			
		if( arr[mid] == val ){
			return mid;
		} else if( arr[mid] > val ){
			return Bsearch(arr, val, min, mid-1);
		} else {
			return Bsearch(arr, val, mid+1, max);
		}

	}
}
