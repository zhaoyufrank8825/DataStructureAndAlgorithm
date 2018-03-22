package tree;

public class STTest {
	public static void main(String[] args){
		SymbolTable<String, Integer> st = new SymbolTable<String, Integer>();
		
		st.put("S", 0);
		st.put("E", 1);
		st.put("A", 2);
		st.put("R", 3);
		st.put("C", 4);
		st.put("H", 5);
		st.put("E", 6);
		st.put("X", 7);
		st.put("A", 8);
		st.put("M", 9);
		st.put("P", 10);
		st.put("L", 11);
		st.put("E", 12);
	
//		st.display();
//		System.out.println(st.get("L"));


		st.display();
		System.out.println();
		System.out.println(st.rank(""));
		st.display("H","P");

		System.out.println();
		st.put("Z", 13);
		st.put("Y", 14);
		st.display();
	}
}
