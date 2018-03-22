package sort;

public class Merge {

	public static void merge1(int[] arr, int lo, int mid, int hi){
		int[] aux = new int[arr.length];
		for(int i=lo; i<=hi; i++){
			aux[i] = arr[i];
		}
		
		int i = lo, j = mid+1;
		for( int k =lo; k<=hi; k++){
			if( i > mid ){
				arr[k] = aux[j++];
			} else if( j > hi ){
				arr[k] = aux[i++];
			} else if( less(aux[j], aux[i]) ){
				arr[k] = aux[j++];
			} else {
				arr[k] = aux[i++];
			}
		}
	}
	
	public static void sort1(int[] arr){
		for(int sz=1; sz < arr.length; sz *= 2){
			for(int i = 0; i<arr.length-sz; i += sz+sz){
				merge1(arr,  i, i+sz-1, Math.min(i+sz+sz-1, arr.length-1));
			}
		}
	}
	
	
	
	public static void merge(int[] arr,int[] aux,int lo,int hi){
		for(int i=lo; i<=hi; i++){
			aux[i] = arr[i];
		}
		
		int mid = (lo + hi) /2 ;
		int i = lo, j = mid+1;
		for( int k =lo; k<=hi; k++){
			if( i > mid ){
				arr[k] = aux[j++];
			} else if( j > hi ){
				arr[k] = aux[i++];
			} else if( less(aux[j], aux[i]) ){
				arr[k] = aux[j++];
			} else {
				arr[k] = aux[i++];
			}
		}
	}
	
	public static void sort(int[] arr, int[] aux, int lo, int hi){
		if(lo+6 >= hi ){
			Insert.sort1(arr, lo, hi);
			return;
		} 
		int mid = (lo + hi) /2 ;
		sort(arr, aux, lo, mid);
		sort(arr, aux, mid+1, hi);
		if( arr[mid] <= arr[mid+1] ){
			return;
		}
		merge(arr, aux, lo, hi);
	}
	
	public static void sort(int[] arr){
		int[] aux = new int[arr.length];
		sort(arr, aux, 0, arr.length-1);
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
