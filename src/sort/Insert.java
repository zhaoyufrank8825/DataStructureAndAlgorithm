package sort;

public class Insert {

	public static void sort(int[] arr){
		for(int i=1; i<arr.length; i++){
			for(int j=i; j>0 && less(arr[j], arr[j-1]); j--){
				exchange(arr, j, j-1);
			}
		}
	}

	public static void sort1(int[] arr, int lo, int hi){
		for(int i=lo + 1; i<=hi; i++){
			for(int j=i; j>lo && less(arr[j], arr[j-1]); j--){
				exchange(arr, j, j-1);
			}
		}
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
}
