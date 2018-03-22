package trytree;

import java.util.LinkedList;

public class Try<Value> {
	
	private final static int R = 255;
	Node root = new Node();
	
	private static class Node{
		public Object value;
		public Node[] next = new Node[R];
	}
	
	public void put(String key, Value value){
		root = put(root, key, value, 0);
	}
	
	private Node put(Node x, String key, Value val, int d){
		if( x==null ) x = new Node();
		if( d == key.length() ) {
			x.value = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d+1);
		return x;
	}
	
	public boolean contains(String key){
		return get(key) != null;
	}

	public Value get(String key){
		Node x = get(root, key, 0);
		if( x == null ) return null;
		return (Value) x.value;
	}
	
	private Node get(Node x, String key, int d){
		if( d == key.length()) return x;
		if( x == null) return null;
		char c = key.charAt(d);
		return get(x.next[c], key, d+1);
	}
	
	public Iterable<String> keys(){
		LinkedList<String> queue = new LinkedList<String>();
		collect(root, "", queue);
		return queue;
	}
	
	public void collect(Node x, String prefix, LinkedList<String> queue){
		if( x == null ) return;
		if( x.value != null ) queue.addLast(prefix);
		for(char c=0; c<R; c++){
			collect(x.next[c], prefix+c, queue);
		}
	}
	
	public Iterable<String> prefix(String s){
		LinkedList<String> queue = new LinkedList<String>();
		Node x = get(root, s, 0);
		collect(x, s, queue);
		return queue;
	}
	
	public String longpre(String st){
		int len = longpre(root, st, 0, 0);
		return st.substring(0, len);
	}
	
	private int longpre(Node x, String s, int d, int length){
		if( x==null ) return length;
		if( x.value != null ) length = d;
		if( d == s.length() ) return length;
		char c = s.charAt(d);
		return longpre(x.next[c], s, d+1, length);	
	}
	
}










