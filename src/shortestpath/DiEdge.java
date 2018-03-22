package shortestpath;

public class DiEdge implements Comparable<DiEdge>{
	private int from, to;
	private double weight;
	
	public DiEdge(int from, int to, double weight){
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	public int from(){
		return from;
	}
	
	public int to(){
		return to;
	}
	
	public double weight(){
		return weight;
	}
	
	public String toString(){
		return from + " -> " + to + "  " + weight;
	}

	public int compareTo(DiEdge that) {
		if( this.weight > that.weight ) return 1;
		else if (this.weight < that.weight ) return -1;
		else return 0;
	}
}
