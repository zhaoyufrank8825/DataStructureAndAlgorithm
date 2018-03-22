package trytree;

public class TryTest {
	public static void main(String[] args){
		Try<Integer> t = new Try<Integer>();
		
		t.put("she", 0);
		t.put("sells", 1);
		t.put("sea", 2);
		t.put("shells", 3);
		t.put("by", 4);
		t.put("the", 5);
		t.put("sea", 6);
		t.put("shore", 7);
		
		for(String key : t.keys()){
			System.out.println(key);
		}
		
		for(String key : t.prefix("sh")){
			System.out.println(key);
		}
		
		System.out.println();
		System.out.println(t.longpre("theapple"));
		
		System.out.println();
		System.out.println(t.get("sell"));
		System.out.println(t.contains("sell"));
		
		
		
//		Ternary<Integer> t = new Ternary<Integer>();
//		
//		t.put("she", 0);
//		t.put("sells", 1);
//		t.put("sea", 2);
//		t.put("shells", 3);
//		t.put("by", 4);
//		t.put("the", 5);
//		t.put("sea", 6);
//		t.put("shore", 7);
//		
//		System.out.println(t.get("shells"));
//		System.out.println(t.contains("shells"));
		
	}
}
