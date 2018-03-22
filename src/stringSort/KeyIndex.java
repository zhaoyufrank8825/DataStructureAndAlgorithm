package stringSort;

public class KeyIndex {
	public static void main(String[] args){
		String s = "013210310231023200";
		KeyInd(s, 8);
		System.out.println();
		
		String st = "013,210,310,231,023,200";
		LSD(st, 3);
//		System.out.println(sort(s, 3));
	}
	
	public static void KeyInd(String s, int R){
		int N = s.length();
		int[] str = new int[N];
		int[] aux = new int[N];
		for(int i=0; i<N; i++){
			str[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
		}
		int[] count = new int[R+1];
		
		for(int i=0; i<N; i++){
			count[str[i]+1]++;
		}
		
		for(int i=0; i<R; i++){
			count[i+1] += count[i];
		}
		
		for(int i=0; i<N; i++){
			aux[count[str[i]]++] = str[i];
		}
		
		for(int i=0; i<N; i++){
			str[i] = aux[i];
			System.out.print(str[i]);
		}
	}
	
	
	public static void LSD(String s, int W){
		String[] str = s.split(",");
		int N = str.length;
		int R= 255;
		String[] aux = new String[N];
		
		for(int d=W-1; d>=0; d--){
			int[] count = new int[R+1];
			
			for(int i=0; i<N; i++){
				count[str[i].charAt(d)+1]++;
			}
			for(int i=0; i<R; i++){
				count[i+1] += count[i];
			}
			for(int i=0; i<N; i++){
				aux[count[str[i].charAt(d)]++] = str[i];
			}
			for(int i=0; i<N; i++){
				str[i] = aux[i];
				System.out.println(str[i]);
			}
			System.out.println();
		}
	}
}















