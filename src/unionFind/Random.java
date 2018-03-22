package unionFind;

public class Random {
	private int maxSize = 80;
	private int[] arr;
	
	public Random(){
		arr = new int[maxSize];
	}
	
	public void rand(){
		int count = 0;
		while( count < maxSize){
			int val = (int) (Math.random()*80);
			if( noEqualVal(val, arr, count) ){
				arr[count++] = val;
			}
		}
	}
	
	public boolean noEqualVal( int val, int[] arr, int count ){
		for(int i=0; i<count; i++){
			if(val == arr[i]){
				return false;
			}
		}
		return true;
	}
	
	public void display(){
		for(int i=0; i<arr.length; i++){
			if(i>0 && i%10 == 0 ){
				System.out.println();
			}
			System.out.print(arr[i] + "\t");
			
		}
	}
}
