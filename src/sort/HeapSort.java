package sort;

public class HeapSort{
	
	public static void sort(int[] a){
		int[] arr = new int[a.length+1];
		for( int i=0; i<a.length; i++){
			arr[i+1] = a[i];
		}
		sort(arr, 1);
	}
	
	public static void sort(int[] arr, int lo){
		int N = arr.length-1;
		for(int i = N/2; i>=1; i-- ){
			sink(arr, i, N);
		}
		while(N>1){
			exchange(arr, 1, N--);
			sink(arr, 1, N);
		}
		display(arr);
	}
	
	public static void sink(int[] arr, int k, int b){
		int N = b;
		while( 2*k <= N){
			int j = 2*k;
			if( j < N && less(arr, j, j+1)){
				j++;
			}
			if( !less(arr, k, j) ){
				break;
			}
			exchange(arr, k, j);
			k = j;
		}
	}
	
	public static boolean less(int[] arr, int a, int b){
		return  arr[a] < arr[b];
	}
	
	public static void exchange(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void display(int[] arr){
		for(int i=1; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
	
	public boolean isSorted(int[] arr){
		for(int i=1; i< arr.length; i++){
			if( arr[i]< arr[i+1] ){
				return false;
			}
		}
		return true;
	}
}
