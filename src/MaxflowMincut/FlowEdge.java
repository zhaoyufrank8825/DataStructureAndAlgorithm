package MaxflowMincut;

public class FlowEdge {
	
	private int from;
	private int to;
	private double capacity;
	private double flow=0;
	
	public FlowEdge(int from, int to, double capacity){
		this.from = from;
		this.to= to;
		this.capacity = capacity;
	}
	
	public int from(){
		return from;
	}
	
	public int to(){
		return to;
	}
	
	public int other(int v ){
		if( v == from ) return to;
		else return from;
	}
	
	public double capacity(){
		return capacity;
	}
	
	public double flow(){
		return flow;
	}
	
	public double residualCapacityTo(int v){
		if( v == from ) return flow;
		else return capacity - flow;
	}
	
	public void addResidualFlowTo(int v, double delta){
		if( v == from )  flow -= delta;
		else flow += delta;
	}
	
	public String toString(){
		return from +" -> " + to + " " + capacity +" " + flow;
	}
	
}
