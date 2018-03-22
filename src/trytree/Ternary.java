package trytree;

public class Ternary<Value> {
	
	private class Node{
		private Value val;
		private char c;
		private Node left, mid, right;
	}
	
	private Node root;
	
	public void put(String s, Value val){
		root = put(root, s, val, 0);
	}
	
	private Node put(Node x, String s, Value val, int d){
		char c = s.charAt(d);
		if( x == null ){
			x = new Node();
			x.c = c;
		}
		
		if( c > x.c ) x.right = put(x.right, s, val, d);
		else if( c < x.c ) x.left = put(x.left, s, val, d);
		else if( d < s.length()-1 ) x.mid = put(x.mid, s, val, d+1);
		else x.val = val;
		return x;	
	}
	
	public boolean contains(String key){
		return get(key) != null;
	}
	
	public Value get(String key){
		Node x = get(root, key, 0);
		if( x==null ) return null;
		return x.val;
	}
	
	private Node get(Node x, String key, int d){
		char k = key.charAt(d);
		if( x == null ) return null;
		
		if( k > x.c ) return get(x.right, key, d);
		else if( k < x.c ) return get(x.left, key, d);
		else if (d < key.length()-1 ) return get(x.mid, key, d+1);
		else return x;
	}
}






