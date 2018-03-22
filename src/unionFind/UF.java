package unionFind;

public class UF {
	private int[] arr;

	public UF(int maxSize) {
		arr = new int[maxSize];
		for(int i=0; i<arr.length; i++){
			arr[i] = i;
		}
	}
	
	public void union(int p, int q){
		if(arr[p] != arr[q]){
			int key = arr[p];
			int key2 = arr[q];
			for(int i=0; i<arr.length; i++){
				if(arr[i] == key2){
					arr[i] = key;
				}
			}
		}
	}
	
	public boolean connected(int p, int q){
		return arr[p] == arr[q];
	}
	
	public void display(){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
	}
	
}
