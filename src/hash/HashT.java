package hash;

import java.util.Arrays;

public class HashT {

	public Node[] st = new Node[10];
	
	private static class Node{
		private Object key;
		private Object value;
		Node next;
		
		public Node(Object key, Object value, Node x){
			this.key = key;
			this.value = value;
			this.next = x;
		}
	}
	
	private int hashCode(Object key){
		return  (int) key % 10;
	}
	
	public void put(Object key, Object value){
		int k = hashCode(key);
		for(Node x = st[k]; x != null; x = x.next){
			if( key.equals(x.key) ){
				x.value = value;
				return;
			}
		}
		st[k] = new Node(key, value, st[k]);
	}
	
	public Object get(Object key){
		int k = hashCode(key);
		for(Node x = st[k]; x != null; x = x.next){
			if( key.equals(x.key) ){
				return x.value;
			}
		}
		return null;
	}
	
	public Object delete(Object key){
		int k = hashCode(key);
		Node x = st[k];
		if( key.equals(x.key) ){
			Object val = x.value ;
			st[k] = x.next;
			return val;
		}
		for(x = st[k]; x != null; x = x.next){
			Node t = x.next;
			if( key.equals(t.key) ){
				Object val = t.value ;
				x.next = t.next;
				return val;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "HashT [st=" + Arrays.toString(st) + "]";
	}
	
	
}
