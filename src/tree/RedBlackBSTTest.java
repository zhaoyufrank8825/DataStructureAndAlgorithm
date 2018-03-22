package tree;

public class RedBlackBSTTest {
	public static void main(String[] args){
		RedBlackBST<String, Integer> bst = new RedBlackBST<String, Integer>();
		
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

		System.out.println();
		for(String s :bst.keys()){
			System.out.println(s+" ");
		}
		
		
		System.out.println(bst.getcolor("S"));
		System.out.println(bst.getcolor("E"));
		System.out.println(bst.getcolor("A"));
		System.out.println(bst.getcolor("R"));
		System.out.println(bst.getcolor("C"));
		System.out.println(bst.getcolor("H"));
		System.out.println(bst.getcolor("E"));
		System.out.println(bst.getcolor("X"));
		System.out.println(bst.getcolor("A"));
		System.out.println(bst.getcolor("M"));
		System.out.println(bst.getcolor("P"));
		System.out.println(bst.getcolor("L"));
		
	}
}
