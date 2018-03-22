package sort;

public class BinaryHeap< key extends Comparable<key>>{
	private key[] pq;
	private int N;
	
	public BinaryHeap(int capacity){
		pq = (key[]) new Comparable[capacity + 1];
	}
	
	public key delMax(){
		key max = pq[1];
		exchange(1, N--);
		sink(1);
		pq[N+1] = null;
		return max;
	}
	
	public void insert(key x){
		pq[++N] = x;
		swimup( N );
	}
	
	public void swimup(int k){
		while( k > 1 && less(k/2, k) ){
			exchange(k/2, k);
			k = k/2;
		}
	}
	
	public void sink(int k){
		while( 2*k <= N){
			int j = 2*k;
			if( j < N && less(j, j+1)){
				j++;
			}
			if( !less(k, j) ){
				break;
			}
			exchange(k , j);
			k *= 2;
		}
	}

	public boolean less(int a, int b){
		return  pq[a].compareTo(pq[b]) < 0;
	}
	
	public void exchange(int a, int b){
		key temp = pq[a];
		pq[a] = pq[b];
		pq[b] = temp;
	}
	
	public void display(){
		for(int i=1; i <= N; i++){
			System.out.print(pq[i] + " ");
		}
	}
}
