//package compression;
//
//import trytree.Ternary;
//
//public class LZW {
//	
//	String input = StdIn.input;
//	Ternary<Integer> st = new Ternary<Integer>();
//	private final int R = 255;
//	int W, L;
//
//	for(int i=0; i<R; i++){
//		st.put(""+(char)i, i);
//	}
//	int code = R+1;
//	
//	while( input.length()>0 ){
//		String s = st.longestprefixof(input);
//		wirte(st.gets(s), W);
//		int t = s.length();
//		
//		if( t<input.length() && code<L){
//			st.put(input.substring(0, t+1), code++);
//		}
//		
//		input = input.substring(t);
//	}
//	
//	write(R, W);
//	close();
//	
//}
