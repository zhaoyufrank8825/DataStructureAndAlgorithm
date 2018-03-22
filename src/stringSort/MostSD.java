package stringSort;

public class MostSD {
	public static void main(String[] args){
		String st = "0134,210"
				+ ",3130,52321,0223,2345200,1232,"
				+ "100,200,1001,1002,1003,1001";
		sort(st);
	}
	
	public static void sort(String s){	
		String[] str = s.split(",");
		String[] aux1 = new String[str.length];
		sort(str, aux1, 0, str.length, 0);
		
		for(int i=0; i<str.length; i++)
			System.out.println(str[i]);
	}
	
	private static void sort(String[] s, String[] aux, int lo, int hi, int d){
		if(lo >= hi) return;
		int R = 255;
		int[] count = new int[R+2];
		
		for(int i=lo; i<hi; i++){
			for(int j=i; j>lo && less(s[j], s[j-1], d); j--){
				exchange(s, j, j-1);
			}
		}
		
		for(int i=lo; i<hi; i++){
			count[charAt(s[i], d)+2]++;
		}
		for(int i=0; i<R+1; i++){
			count[i+1] += count[i];
		}
		for(int i=lo; i<hi; i++){
			aux[count[charAt(s[i], d)+1]++] = s[i];
		}
		for(int i=lo; i<hi; i++){
			s[i] = aux[i-lo];
		}
		
		for(int i=0; i<R; i++){
			sort(s, aux, lo+count[i], lo+count[i+1], d+1);
		}
	}
	
	public static boolean less(String a, String b, int d){
		return a.substring(d).compareTo(b.substring(d)) < 0 ;
	}
	
	public static void exchange(String[] a, int i, int j){
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static int charAt(String s, int d){
		if(d < s.length()) return s.charAt(d);
		else return -1;
	}
}
