package tree;

import java.util.LinkedList;

public class BinarySearchTree <KEY extends Comparable<KEY>, VALUE>{
	private Node root;
	private class Node{
		private KEY key;
		private VALUE value;
		private Node left, right;
		private int count;
		public Node(KEY key, VALUE value){
			this.key = key;
			this.value = value;
			this.count = 1;
		}
	}
	
	
	public VALUE get(KEY key){
		Node x = root;
		while( x!=null ){
			if(key.compareTo(x.key) == 0 ){
				return x.value;
			}else if(key.compareTo(x.key) > 0){
				x = x.right;
			}else {
				x = x.left;
			}
		}
		return null;
	}
	
	
	public int size(){
		return size(root);
	}
	public int size(Node x){
		if( x == null) return 0;
		return x.count;
	}
	
	
	public void put(KEY key, VALUE value){
		root = put(root, key, value);
	}	
	public Node put(Node x, KEY key, VALUE value){
		if( x == null ) return new Node(key, value);
		if( key.compareTo(x.key) > 0 ){
			x.right = put(x.right, key, value);
		} else if( key.compareTo(x.key) < 0 ){
			x.left = put(x.left, key, value);
		} else{
			x.value = value;
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	

	public KEY max(){
		Node x = root;
		while( x.right != null ){
			x = x.right;
		}
		return x.key;
	}
	public KEY min(){
		Node x = root;
		while( x.left != null ){
			x = x.left;
		}
		return x.key;
	}
	public Node max(Node x){
		while( x.right != null ){
			x = x.right;
		}
		return x;
	}
	public Node min(Node x){
		while( x.left != null ){
			x = x.left;
		}
		return x;
	}
	
	
	public KEY floor(KEY key){
		Node t = floor(root, key);
		if( t == null ) return null;
		return t.key;
	}
	public Node floor(Node x, KEY key){
		if( x== null) return null;
		
		if(key.compareTo(x.key) == 0) return x;
		
		if(key.compareTo(x.key) < 0){
			return floor(x.left, key);
		}

		Node t = floor(x.right, key);
		if( t == null ) return x;
		else return t;
	}
	
	
	public KEY ceiling(KEY key){
		Node t = ceiling(root, key);
		if( t == null ) return null;
		return t.key;
	}
	public Node ceiling(Node x, KEY key){
		if( x== null) return null;
		
		if(key.compareTo(x.key) == 0) return x;
		
		if(key.compareTo(x.key) > 0){
			return ceiling(x.right, key);
		}

		Node t = ceiling(x.left, key);
		if( t == null ) return x;
		else return t;
	}
	
	
	public int rank(KEY key){
		return rank(key, root);
	}
	public int rank(KEY key, Node x){
		if( x == null ) return 0;
		if(key.compareTo(x.key) == 0) return size(x.left);
		else if (key.compareTo(x.key) < 0){
			return rank(key, x.left);
		}else{
			return 1 + rank(key, x.right) + size(x.left);
		}
	}
	
	
	public Iterable<KEY> keys(){
		LinkedList<KEY> q = new LinkedList<KEY>();
		inorder(root, q);
		return q;
	}
	public void inorder(Node x, LinkedList<KEY> q){
		if(x == null) return;
		inorder(x.left, q);
		q.add( x.key );
		inorder(x.right, q);
	}
	
	
	public void deleteMin(){
		root = deleteMin(root);
	}
	private Node deleteMin(Node x){
		if( x.left == null ) return x.right;
		if(x.left != null) x.left = deleteMin(x.left);
		x.count = 1 + size(x.right) + size(x.left);
		return x;	
	}
	
	public void deleteMax(){
		root = deleteMax(root);
	}
	private Node deleteMax(Node x){
		if( x.right == null ) return x.left;
		if(x.right != null) x.right = deleteMax(x.right);
		x.count = 1 + size(x.right) + size(x.left);
		return x;	
	}
	
	public void delete(KEY key){
		root = delete(root, key);
	}
	public Node delete(Node x, KEY key){
		if( x == null) return null;
		if( key.compareTo(x.key) >0 ){
			x.right = delete(x.right, key);
		} else if ( key.compareTo(x.key)<0 ){
			x.left = delete(x.left, key);
		} else{
			if( x.right == null ) return x.left;
			Node t = x;
			x = min(x.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.count = 1+size(x.right)+size(x.left);
		return x;
	}
	
	public void delete1(KEY key){
		root = delete(root, key);
	}
	public Node delete1(Node x, KEY key){
		if( x == null) return null;
		if( key.compareTo(x.key) > 0 ){
			x.right = delete1(x.right, key);
		} else if ( key.compareTo(x.key)<0 ){
			x.left = delete1(x.left, key);
		} else{
			if( x.left == null ) return x.right;
			Node t = x;
			x = max(x.left);
			x.left = deleteMin(t.left);
			x.right = t.right;
		}
		x.count = 1+size(x.right)+size(x.left);
		return x;
	}

	public boolean contains(KEY key){
		if( get(key) == null ){
			return false;
		}
		return  true;
	}
	
	public int range(KEY key1, KEY key2){
		if( contains(key2) ){
			return rank(key2) - rank(key1) + 1;
		} 
		return  rank(key2) - rank(key1);
	}
	
}
