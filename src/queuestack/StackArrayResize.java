package queuestack;

public class StackArrayResize {
	
	private String[] arr;
	private int N=0;
	
	public StackArrayResize(){
		arr = new String[16];
	}
	
	public void push(String item){
		if(N==arr.length){
			resize(2*arr.length);
		}
		arr[N++] = item;
	}
	
	public String pop(){
		String item = arr[--N];
		arr[N] = null;
		if(N>0 && N==(arr.length/4)){
			resize(arr.length/2);
		}
		return item;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public void resize(int size){
		String[] copy = new String[size];
		for(int i=0; i<N; i++){
			copy[i] = arr[i];
		}
		arr = copy;
	}
	
}
