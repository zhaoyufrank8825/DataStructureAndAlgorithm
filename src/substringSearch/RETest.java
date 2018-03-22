package substringSearch;

public class RETest {
	public static void main(String[] args){
		String text = "BD";
		String reg = "((A*B|AC)D)";
		
		regularExpress re = new regularExpress(reg);
		System.out.println(re.recognize(text));
	}
}
