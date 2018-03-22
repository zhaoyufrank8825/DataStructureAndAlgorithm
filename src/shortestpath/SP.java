package shortestpath;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SP {
	private boolean[] marked;
	private double[] distTo;
	private DiEdge[] pathTo;
	private TreeMap<Double, Integer> pq = new TreeMap<Double, Integer>();
	private Stack<Integer> postOrder = new Stack<Integer>();
	
	public SP(WeightedDiGraph g){
		distTo = new double[g.V];
		pathTo = new DiEdge[g.V];
		marked = new boolean[g.V];
		for(int i=0 ; i<g.V; i++){
			distTo[i] = Double.POSITIVE_INFINITY;
		}
	}
	
	public double dist(int v){
		return distTo[v];
	}

	LinkedList<DiEdge> list = new LinkedList<DiEdge>();
	public Iterable<DiEdge> path(int v){
		for(DiEdge e = pathTo[v]; e != null; e = pathTo[e.from()]){
			list.add(e);
		}
		return list;
	}
	
	public void pathdisplay(){
		while(!list.isEmpty()){
			System.out.print(list.removeLast() + " " );
		}
	}
	
	private void relax(DiEdge e){
		int v = e.from(), w = e.to();
		if( distTo[w] > distTo[v] + e.weight()){
			distTo[w] = distTo[v] + e.weight();
			pathTo[w] = e;
			if( pq.containsValue(w) ) pq.replace(distTo[w], w);
			else pq.put(distTo[w], w);
		}
	}
	
	public void Dijkstra(WeightedDiGraph g, int s){	
		distTo[s] = 0;
		pq.put(0.0, s);
		
		while( !pq.isEmpty() ){
			Entry<Double, Integer> pair = pq.pollFirstEntry();
			for( DiEdge e : g.adj(pair.getValue()) ){
				relax(e);
			}
		}
	}
	
	public void topological(WeightedDiGraph g, int n){
		marked[n] = true;
		for(DiEdge e : g.adj(n)){
			int w = e.to();
			if( !marked[w] ){
				topological(g, w);
			}
		}
		postOrder.push(n);
	}
	
	public void topshorted(WeightedDiGraph g){
		int s = postOrder.peek();
		distTo[s] = 0;
		pq.put(0.0, s);
		while( !postOrder.isEmpty() ){
			int i = postOrder.pop();
			for( DiEdge e : g.adj(i) ){
				relax(e);
			}					
		}
	}
	
	public void ford(WeightedDiGraph g, int s){	
		distTo[s] = 0;
		pq.put(0.0, s);
		
		for(int i=0; i<g.V; i++){
			for(int v=0; v<g.V; v++){
				for( DiEdge e : g.adj(v) ){
					relax(e);
				}
			}
		}
	}
}






