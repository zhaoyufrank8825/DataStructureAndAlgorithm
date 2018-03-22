package queuestack;

public class StackLink<Item> {
		
	public class Node{
		Item item;
		Node next;
	}
	
	private Node first = null;
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void push(Item item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	public Item pop(){
		Item item = first.item;
		first = first.next;
		return item;
	}

}
