package queuestack;

public class PriorityQueue<key extends Comparable<key>> {
	private key[] pq;
	private int N ;

	
	public PriorityQueue(){
		pq =(key[]) new Comparable[5];
	}
	
	public PriorityQueue(int capacity){
		pq =(key[]) new Comparable[capacity];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public void insert(key x){
		int M = pq.length-1;
		pq[N++] = x;
		if( N > M ){
			System.out.println(delMax() + " is deleted!");
		}
	}
	
	public key delMax(){
		int Max = 0;
		for( int i=1; i<N; i++){
			if(less(pq[Max], pq[i])){
				Max = i;
			}
		}
		exchange(pq, Max, N-1);
		
		return pq[--N];
	}
	
	public boolean less(key v, key w){
		return (v.compareTo(w) < 0) ;
	}
	
	public void exchange(key[] a, int i, int j){
		key temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void display(){
		int M = pq.length-1;
		for(int i=0; i<M; i++){
			System.out.print(pq[i] + " ");
		}
	}
}
