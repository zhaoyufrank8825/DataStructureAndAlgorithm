package substringSearch;

public class Rabinkarp {
	private long pathash, texthash;
	private int Q = 997;
	private int R = 255, RM=1;
	
	private long hash(String pat, int M){
		for(int i=0; i<M; i++){
			pathash = (pathash*R + pat.charAt(i) ) % Q;
		}

		return pathash;
	}
	
	public int search(String pat, String text){
		int M = pat.length();
		int N = text.length();
		texthash = hash(text, M);
		System.out.print(texthash+"  ");
		pathash = hash(pat, M);
		System.out.println(pathash+" ");
		if(pathash == texthash ) return 0;
		
		for(int i=1; i<M; i++){
			RM = (RM*R)%Q;
		}
		for(int i=M; i<N; i++){
			texthash = (texthash  + Q - (RM*text.charAt(i-M))%Q ) %Q;
			texthash = (texthash*R + text.charAt(i)) % Q;
			if( texthash == pathash ) return i-M+1;
		}
		return N;
	}
}
