package hash;

import java.util.LinkedList;

public class Set<Key extends Comparable<Key>> {
	
	LinkedList<Key> set = new LinkedList<Key>();
	
	public void add(Key key){
		set.add(key);
	}
	
	public Key deleteFirst(){
		return set.removeFirst();
	}
	
	public Key delete(Key key){
		int k = set.indexOf(key);
		return set.remove(k);
	}
	
	public boolean contains(Key key){
		return set.contains(key);
	}
	
	public int size(){
		return set.size();
	}

	@Override
	public String toString() {
		return "set=" + set ;
	}
	
	
}
