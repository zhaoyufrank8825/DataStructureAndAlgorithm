package binarysearch;

public class Iteration {

	public static int itSearch(int[] arr, int val){
		int max = arr.length - 1;
		int min = 0;
		
		while( min <= max ){
			int mid = (max + min)/2;
			if( arr[mid] == val ){
				return mid;
			} else if( arr[mid] > val ){
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return -1;	
	}
}
