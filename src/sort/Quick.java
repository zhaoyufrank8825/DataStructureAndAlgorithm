package sort;

public class Quick {
	public static int partition(int[] arr, int lo, int hi){
		int i = lo, j = hi+1;
		while(true){
			while(less(arr[++i], arr[lo])){
				if(i == hi) break;
			}
			while(less(arr[lo], arr[--j]));
			if(i>=j) break;
			exchange(arr, i, j);
		}
		exchange(arr, j, lo);
		return j;
	}
	
	public static int select(int[] arr, int k){
		int lo = 0, hi = arr.length-1;
		return select(arr, k, lo, hi);
	}
	
	public static int select(int[] arr, int k, int lo, int hi){
		while(hi > lo ){
			int j = partition(arr, lo, hi);
			if( j > k ){
				hi = j-1;
			}else if ( j < k ){
				lo = j+1;
			}else {
				return arr[j];
			}
		}
		return arr[k];
	}
	
	public static void sort(int[] arr){
		int lo = 0, hi = arr.length-1;
		sort(arr, lo, hi);
	}
	
	public static void sort(int[] arr, int lo, int hi){
//		if(lo+6 >= hi ){
//			Insert.sort1(arr, lo, hi);
//			return;
//		} 
		if(lo>= hi ){
		return;
		} 
		int j = partition(arr, lo, hi);
		sort(arr, lo, j-1);
		sort(arr, j+1, hi);
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
