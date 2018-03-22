package sort;

public class Shuffling {
	public static void main(String[] args){
		int[] arr = new int[20];
		
		for(int i=0; i<arr.length; i++){
			arr[i] = i;
		}
		
		shuffling(arr);
		display(arr);
		
	}
	

	public static void shuffling(int[] arr){
		for( int i=1; i<arr.length; i++){
			int j = (int) (Math.random()*(i+1));
			exchange(arr, i, j);
		}
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
