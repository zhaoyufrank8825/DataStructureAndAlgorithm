package tree;

public class SymbolTable <KEY extends Comparable<KEY>, VALUE> {
	private KEY[] keys;
	private VALUE[] values;
	private int N;
	
	public SymbolTable(){
		this.N = 0;
		this.keys = (KEY[]) new Comparable[100];
		this.values = (VALUE[]) new Comparable[100];
	}
	
	public void put(KEY key, VALUE value){
		for(int i=0; i<N; i++){
			if(keys[i] == key){
				values[i] = value;
				return ;
			}
		}
		int i;
		for(i=N-1; i>=0 &&( keys[i].compareTo(key)>0 ); i--){
			keys[i+1] = keys[i];
			values[i+1] = values[i];
		}
		keys[i+1] = key;
		values[i+1] = value;
		N++;
	}
	
	public VALUE get(KEY key){
		for(int i=0; i<N; i++){
			if(keys[i] == key){
				return values[i];
			}
		}
		return null;
	}
	
	public void delete(KEY key){
		int i;
		for(i=0; i<N; i++){
			if(keys[i] == key){
				break;
			}
		}
		if(i == N) return;
		for(int j=i; j<N ; j++){
			keys[j] = keys[j+1];
			values[j] = values[j+1];
		}
		N--;
	}
	
	public void deleteMin(){
		for(int j=0; j<N-1 ; j++){
			keys[j] = keys[j+1];
			values[j] = values[j+1];
		}
		N--;
	}
	
	public void deleteMax(){
		keys[N-1] = null;
		values[N-1] = null;
		N--;
	}
	
	public int size(KEY lo, KEY hi){
		int i = rank(lo);
		int j = rank(hi);
		return j-i+1;
	}
	
	public KEY floor(KEY key){
		for(int i=0; i<N; i++){
			if(keys[i].compareTo(key) == 0 ){
				return keys[i];
			}
			if(keys[i].compareTo(key) > 0 ){
				return keys[i-1];
			}
		}
		return null;
	}
	
	public int rank(KEY key){
		for(int i=0; i<N; i++){
			if(keys[i] == key){
				return i;
			}
		}
		return -1;
	}
	
	public KEY select(int k){
		return keys[k];
	}
	
	public KEY ceiling(KEY key){
		for(int i=0; i<N; i++){
			if(keys[i].compareTo(key) == 0 ){
				return keys[i];
			}
			if(keys[i].compareTo(key) > 0 ){
				return keys[i];
			}
		}
		return null;
	}
	
	public boolean contains(KEY key){
		return get(key) != null ;
	}
	
	public int size(){
		return N;
	}
	
	public KEY min(){
		return keys[0];
	}
	
	public KEY max(){
		return keys[N-1];
	}
	
	public void display(){
		for(int i=0; i< N; i++){
			System.out.println(keys[i] + " "+ values[i]);
		}
	}
	
	public void display(KEY lo, KEY hi){
		int k = rank(lo);
		int j = rank(hi);
		for(int i=k; i<= j; i++){
			System.out.println(keys[i] + " "+ values[i]);
		}
	}
	
}
