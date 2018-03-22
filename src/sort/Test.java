package sort;

public class Test {
	public static void main(String[] args){
		
		int[] arr = new int[30];
		
		for(int i=0; i<arr.length; i++){
			arr[i] = (int)(Math.random()*100);
			System.out.print(arr[i] + " ");
		}

		System.out.println();

		HeapSort.sort(arr);
		System.out.println();
	}
}
