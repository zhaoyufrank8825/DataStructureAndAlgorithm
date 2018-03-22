package substringSearch;

public class Test {
	public static void main(String[] args){
		String text = "i am frank, i love my life! i am very good";
		String p = "i love";
		
		int j =bruteforce.brute1(p, text);
		System.out.println(j);
		System.out.println(text.substring(j, j+p.length()));
		
//		int k =bruteforce.knuthMorrisPratt(p, text);
//		System.out.println(k);
//		System.out.println(text.substring(k, k+p.length()));
		
		Rabinkarp rk = new Rabinkarp();
		int k = rk.search(p, text);
		System.out.println(k);
		System.out.println(text.substring(k, k+p.length()));
	}
}
