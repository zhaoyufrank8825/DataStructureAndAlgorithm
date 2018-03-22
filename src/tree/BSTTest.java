package tree;

public class BSTTest {
	public static void main(String[] args){
		BinarySearchTree<String, Integer> bst = new BinarySearchTree<String, Integer>();
		
		bst.put("S", 0);
		bst.put("E", 1);
		bst.put("A", 2);
		bst.put("R", 3);
		bst.put("C", 4); 
		bst.put("H", 5);
		bst.put("E", 6);
		bst.put("X", 7);
		bst.put("A", 8);
		bst.put("M", 9);
		bst.put("P", 10);
		bst.put("L", 11);
		bst.put("E", 12);
	
//		System.out.println(bst.get("E"));
//		System.out.println(bst.min());
//		System.out.println(bst.max());
//		System.out.println(bst.floor("F"));
//		System.out.println(bst.ceiling("F"));
		
//		System.out.println(bst.size());
//		System.out.println(bst.rank("A"));
//		bst.deleteMin();
//		System.out.println();
//		for(String s :bst.keys()){
//			System.out.println(s);
//		}
//		System.out.println(bst.size());
//		
//		bst.deleteMax();
//		System.out.println();
//		for(String s :bst.keys()){
//			System.out.println(s);
//		}
//		System.out.println(bst.size());
//		bst.delete1("R");
//		System.out.println();
//		for(String s :bst.keys()){
//			System.out.println(s);
//		}
//		System.out.println(bst.size());
		
		bst.delete("C");
		System.out.println();
		for(String s :bst.keys()){
			System.out.println(s);
		}
		System.out.println(bst.size());
		
		System.out.println();
		int k = bst.range("A", "T");
		System.out.println(k);
		
		System.out.println(bst.contains("B"));
		System.out.println(bst.contains("A"));
		
	}
}
