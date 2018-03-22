package sort;

public class Shell {
	
	public static void sort(int[] arr){
		int h=1;
		while(h < arr.length/3 ){
			h = 3*h + 1;
		}
		
		while(h>0){
			for(int i=h; i<arr.length; i++){
				for(int j=i; j>=h && less(arr[j], arr[j-h]); j-=h){
					exchange(arr, j, j-h);
				}
			}
			h = h/3 ;
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
