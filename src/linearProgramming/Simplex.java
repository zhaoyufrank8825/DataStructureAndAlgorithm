package linearProgramming;

public class Simplex {
	private double[][] a;
	private int M, N;
	
	public Simplex(double[][] A, double[] b, double[] c){
		this.M = b.length;
		this.N = c.length;
		a = new double[M+1][M+N+1];
		
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				a[i][j] = A[i][j];
			}
		}
		
		for(int i=N; i<M+N; i++){
			a[i-N][i] = 1.0;
		}
		
		for(int i=0; i<N; i++){
			a[M][i] = c[i];
		}
		
		for(int i=0; i<M; i++){
			a[i][N+M] = b[i];
		}
	}
	
	public int bland(){
		for(int i=0; i<M+N; i++){
			if ( a[M][i] >0 )
				return i;
		}
		return -1;
	}
	
	public int minfactor(int k){
		int key=0;
		
		for(int i=1; i<M; i++){
			if( k == -1 ) k = i;
			else if( a[i][k] <= 0 ) continue;
			else if( (a[i][M+N] / a[i][k]) < a[key][M+N] / a[key][k] ){
				key = i;
			}
		}
		
		return key;
	}
	
	public void pivot(int p, int q){
		for(int i=0; i<=M; i++){
			for(int j=0; j<=M+N; j++){
				if( i!=p && j!=q ){
					a[i][j] -= a[p][j]*a[i][q]/a[p][q];
				}
			}
		}
		
		for(int i=0; i<=M; i++){
			if( i!=p ){
				a[i][q] = 0.0;
			}
		}
		
		for(int j=0; j<=M+N; j++){
			if( j!= q ) {
				a[p][j] /= a[p][q];
			}
		}
		
		a[p][q] = 1.0;
	}
	
	public double solve(){
		while( true ){
			int q = bland();
			if(q == -1) break;
			
			int p = minfactor(q);
			
			pivot(p,q);
		}
		System.out.println(a[0][M+N]+" "+ a[1][M+N]);
		return Math.abs( a[M][M+N] );
	}
}














