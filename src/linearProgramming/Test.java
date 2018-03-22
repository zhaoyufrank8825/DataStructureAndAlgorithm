package linearProgramming;

public class Test {
	public static void main(String[] args){
		double[][] a = {{5,15},{4,4},{35,30}};
		double[] b = {480,160,1190};
		double[] c = {13, 23};
		
		Simplex sam = new Simplex(a, b, c);
		
		System.out.println( sam.solve() );
	}
}
