package stringSort;

public class TEST {
	public static void main(String[] args){
		
		String s = "i am frank!";
		String t = "i am";
		
		
		System.out.println(STR.reverse(s));
		System.out.println();
		
		System.out.println(STR.reverse2(s));
		
		STR.suffixes(s);
		STR.suffixes2(s);
		
		System.out.println(STR.prefix(s, t));
		
	}
}
