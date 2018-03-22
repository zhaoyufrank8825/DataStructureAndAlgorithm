package substringSearch;

public class bruteforce {
	
	public static int brute(String pat, String text){
		int N = text.length();
		int M = pat.length();
		for(int i=0; i<=N-M; i++){
			int j = 0;
			for( j=0; j<M; j++){
				if( text.charAt(i+j) != pat.charAt(j) )	break;
			}
			if( j == M ) return i;
		}
		return N;
	}
	
	public static int brute1(String pat, String text){
		int i, N = text.length();
		int j, M = pat.length();
		for( i=0, j=0; i<N && j<M; i++ ){
			if( text.charAt(i) == pat.charAt(j) )	j++;
			else { i -= j; j = 0;}
		}
		if( j == M ) return i-j;
		return N;
	}
	
	
	public static int knuthMorrisPratt(String pat, String text){
		int[][] dfa = KMP(pat);
		int i, N=text.length();
		int j=0, M=pat.length();
		for( i=0; i<N && j<M; i++){
			j = dfa[text.charAt(i)][j];
		}
		if( j == M ) return i-M;
		return N;
	}
	
	public static int[][] KMP(String pat){
		int R = 255;
		int M = pat.length();
		int[][] dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;
		for(int X=0, i=1; i<M; i++){
			for(int c=0; c<R; c++){
				dfa[c][i] = dfa[c][X];
			}
			dfa[pat.charAt(i)][i] = i+1;
			X = dfa[pat.charAt(i)][X];
		}	
		return dfa;
	}
	
	public static int boyerMoore(String pat, String text){
		int N=text.length(), M=pat.length();
		int R = 255, skip=0;
		int[] right = new int[R];
		for( int i=0; i<R; i++){
			right[i] = -1;
		}
		for( int i=0; i<M; i++){
			right[pat.charAt(i)] = i;
		}
				
		for( int i=0; i<=N-M; i+=skip){
//			skip = 0;
			for(int j=M-1; j>=0; j--){
				if( pat.charAt(j) != text.charAt(i+j) ){
					skip = Math.max(1, j - right[text.charAt(i+j)] );
					break;
				}
			}
			if( skip == 0 ) return i;
		}
		return N;	
	}
}







