package hash;

import java.util.HashMap;

public class SparseVector {
	private HashMap<Integer, Integer> v;
	
	public SparseVector(){
		v = new HashMap<Integer, Integer>();
	}
	
	public void put(Integer key, Integer value){
		v.put(key, value);
	}
	
	public int get(Integer key){
		if(!v.containsKey(key)) return 0;
		return v.get(key);
	}
	
	public Iterable<Integer> keys(){
		return v.keySet();
	}
	
	public int dot(int[] that){
		int sum = 0 ;
		for(int i : keys()){
			sum += this.get(i)*that[i];
		}
		
		return sum;
	}
	
}
