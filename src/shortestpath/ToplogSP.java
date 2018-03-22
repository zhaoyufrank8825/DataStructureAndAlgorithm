package shortestpath;

import java.util.LinkedList;

public class ToplogSP {
	private boolean[] marked;
	private double[] distTo;
	private DiEdge[] edgeTo;
	private LinkedList<Integer> order = new LinkedList<Integer>();
	
	public ToplogSP(WeightedDiGraph g,int n){
		marked = new boolean[g.V];
		edgeTo = new DiEdge[g.V];
		for(int i=0; i<g.V; i++){
			distTo[i] = Double.POSITIVE_INFINITY;
		}
	}
	
	public void toplogical(WeightedDiGraph g,int n){
		marked[n] = true;
		
	}
	
}
