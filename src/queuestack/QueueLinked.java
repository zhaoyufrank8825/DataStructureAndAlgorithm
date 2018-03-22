package queuestack;

public class QueueLinked {
	
	public class Node{
		String item;
		Node next;
	}
	
	private Node first = null;
	private Node last = null;
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void EnQueue(String item){
		Node node = new Node();
		node.item = item;
		node.next = null;
		if( isEmpty() ){
			first = node;
		}else{
			last.next = node;
		}
		last = node;
	}
	
	public String DeQueue(){
		String item = first.item;
		first = first.next;
		if( isEmpty() ){
			last = null;
		}
		return item;
	}
	
}
