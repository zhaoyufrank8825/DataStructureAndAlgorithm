package sort;

public class Selection {
	
	public static void sort(int[] arr){
		for(int i=0; i<arr.length; i++){
			int min = i;
			for(int j=i+1; j<arr.length; j++){
				if(less(arr[j], arr[min])){
					min = j;
				}
			}
			exchange(arr, i, min);
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
