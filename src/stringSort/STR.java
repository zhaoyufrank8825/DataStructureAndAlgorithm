package stringSort;

public class STR implements Comparable<STR> {
	private char[] value;
	private int offset;
	private int length;
	
	public int length(){
		return length;
	}
	
	public char charAt(int i){
		return value[i+offset];
	}
	
	public STR(int offset, int length, char[] value){
		this.offset = offset;
		this.length = length;
		this.value = value;
	}
	
	public STR subString(int from, int to, char[] value){
		return new STR(from, to - from, value);
	}
	
	public int compareTo(STR o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static String reverse(String s){
		int N = s.length();
		String str = "";
		for(int i=N-1; i>=0; i--){
			str += s.charAt(i);
		}
		return str;
	}
	
	public static StringBuilder reverse2(String s){
		int N = s.length();
		StringBuilder str = new StringBuilder();
		for(int i=N-1; i>=0; i--){
			str.append(s.charAt(i));
		}
		return str;
	}
	
	
	public static void suffixes(String s){
		int N = s.length();
		String[] str = new String[N];
		for(int i=0; i<N; i++){
			str[i] = s.substring(i, N);
			System.out.println(str[i]);
		}
	}
	
	public static void suffixes2(String s){
		int N = s.length();
		StringBuilder st = new StringBuilder(s);
		String[] str = new String[N];
		for(int i=0; i<N; i++){
			str[i] = st.substring(i, N);
			System.out.println(str[i]);
		}
	}
	
	public static int prefix(String s, String t){
		int N = Math.min(s.length(), t.length());
		for(int i=0; i<N; i++){
			if( s.charAt(i) != t.charAt(i) ){
				return i;
			}
		}
		return N;
		
	}
	
}
