package MaxflowMincut;

import java.util.LinkedList;

public class FoldFulkerson {
	private boolean[] marked;
	private FlowEdge[] edgeTo;
	private double value;
	
	public FoldFulkerson(FlowNetwork g, int s, int t){
		value = 0;
		while( hasAugmentingPath(g, s, t) ){
			double bottle = Double.POSITIVE_INFINITY;
			for(int v = t; v!=s; v = edgeTo[v].other(v)){
				bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
			}
			
			for(int v = t; v!=s; v = edgeTo[v].other(v)){
				edgeTo[v].addResidualFlowTo(v, bottle);
			}
			
			value += bottle;
		}
	}
	
	public boolean hasAugmentingPath(FlowNetwork g, int s, int t){
		marked = new boolean[g.Vsize()];
		edgeTo = new FlowEdge[g.Vsize()];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		marked[s] = true;
		queue.add(s);
		while( !queue.isEmpty() ){
			int v = queue.removeFirst();
			for( FlowEdge e : g.adj(v)){
				int w = e.to();
				if( e.residualCapacityTo(w) > 0 && !marked[w] ){
					marked[w] = true;
					queue.addLast(w);
					edgeTo[w] = e;
				}
			}
		}
		return marked[t];
	}
	
	public double value(){
		System.out.println(value);
		return value;
	}
	
	public boolean inCut(int v){
		return marked[v];
	}
	
	public void cutDisplay(FlowNetwork g){
		for(int i=0; i<g.Vsize(); i++){
			System.out.println(i + " " + marked[i]);
		}
	}
}
