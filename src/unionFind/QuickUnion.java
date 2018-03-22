package unionFind;

public class QuickUnion {
	private int[] arr;
	private int[] weight;

	public QuickUnion(int maxSize) {
		arr = new int[maxSize];
		weight = new int[maxSize];
		for(int i=0; i<arr.length; i++){
			arr[i] = i;
			weight[i] = 1;
		}
	}
	
	public int root(int i){
		while( i != arr[i] ){
			i = arr[arr[arr[i]]];
			
		}
		return i;
	}
	
	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		arr[j] = i;
	}
	
	public void weightUnion(int p, int q){
		int i = root(p);
		int j = root(q);
		if(weight[i] >= weight[j]){
			arr[j] = i;
			weight[i] += weight[j];
		}else{
			arr[i] = j;
			weight[j] += weight[i];
		}
	}
	
	public boolean connected(int p, int q){
		return root(p) == root(q);
	}
	
	public void display(){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
			
		}
	}
	
}
