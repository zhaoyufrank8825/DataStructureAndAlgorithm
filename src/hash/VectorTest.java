package hash;

import java.util.Random;

public class VectorTest {
	public static void main(String[] args){
		
		int M = 3;
		int[] b = new int[M];
		int[][] a = new int[M][M];
		Random r = new Random();
		
		for(int i=0; i<M; i++){
			for(int j=0; j<M; j++){
				System.out.print((a[i][j] = r.nextInt(10))+" ");
				
			}
			b[i] = r.nextInt(10);
			System.out.print("\t\t" + b[i]);
			System.out.println();
		}
		
		int[] sum = dotx(a, b);
		for(int i=0; i<sum.length; i++){
			System.out.print(sum[i] +" ");
		}
		
		System.out.println();	System.out.println();
		
		SparseVector[] arr = new SparseVector[M];
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a.length; j++){
				arr[i].put(j, a[i][j]);
			}
		}
		
		int[] add = new int[M];
		for(int i=0; i<arr.length; i++){
			add[i] = arr[i].dot(b);
			System.out.println(add[i]);
		}
		
		
	}
	
	public static int[] dotx(int[][] a, int[] b){
		int[] sum = new int[a.length];
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a.length; j++){
				sum[i] = a[i][j]*b[j];
				
			}
		}
		return sum;
	}
	
}
