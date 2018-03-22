package queuestack;

public class StackArray<Item> {
	
	private Item[] arr;
	private int N=0;
	
	public StackArray(){
		arr = (Item[]) (new Object[100]);
	}
	
	public void push(Item item){
		arr[N++] = item;
	}
	
	public Item pop(){
		Item item = arr[--N];
		arr[N] = null;
		return item;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
}
