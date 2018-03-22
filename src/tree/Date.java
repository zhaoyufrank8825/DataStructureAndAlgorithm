package tree;

public class Date implements Comparable<Date>{
	private int month;
	private int day;
	private int year;
	
	public boolean equals(Date y){
		if( y == this ) return true;
		if( y == null ) return false;
		if( y.getClass() != this.getClass() ) return false;
		
		if(this.month !=  y.month) return false;
		if(this.day != y.day) return false;
		if(this.year != y.year) return false;
		
		return true;
	}
	
	
	
	
	
	
	@Override
	public int compareTo(Date o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
