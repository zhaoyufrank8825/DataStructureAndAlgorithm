package sort;

public class QuickSort {
	
	public static void sort(int[] arr){
		sort(arr, 0, arr.length -1);
	}
	
	public static void sort(int[] arr, int lo, int hi){
		if(hi <= lo ){
			return;
		}
		int i =lo+1, lt = lo, gt = hi;
		int key = arr[lo];
		while( i<=gt ){
			if(arr[i] < key) {
				exchange(arr, lt++, i++);
			} else if (arr[i] > key ){
				exchange(arr, i, gt--);
			} else{
				i++;
			}
		}
		sort(arr, lo, lt-1);
		sort(arr, gt+1, hi);
		
	}
	
	public static boolean less(int v, int w){
		return v < w ;
	}
	
	public static void exchange(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void display(int[] a){
		for(int i=0; i<a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
	
	public static boolean isSorted(int[] arr, int lo, int hi){
		for(int i=lo; i< hi; i++){
			if(arr[i] > arr[i+1]){
				return false;
			}
		}
		return true;
	}
}
