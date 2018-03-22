package hash;

import java.util.HashMap;

public class Test {
	public static void main(String[] args){
		HashOpen<Integer, String> hash = new HashOpen<Integer, String>();
		
		hash.put(2, "two");
		hash.put(5, "five");
		hash.put(10, "ten");
		hash.put(3, "three");
		hash.put(11, "eleven");
		hash.put(1, "one");
		hash.put(20, "twenty");
		hash.put(31, "thityone");
		

		System.out.println(hash.delete(31));
		System.out.println(hash.get(31));
		
		HashMap hp = new HashMap();
	}
}
