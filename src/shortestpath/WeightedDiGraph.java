package shortestpath;

import java.util.LinkedList;

public class WeightedDiGraph {

	public final int V;
	private final LinkedList<DiEdge>[] adj;
	
	public WeightedDiGraph(int V){
		this.V = V;
		adj =  ( LinkedList<DiEdge>[] ) new LinkedList[V];
		for(int i=0; i<V; i++){
			adj[i] =  new LinkedList<DiEdge>();
		}
	}
	
	public void addEdge( DiEdge e ){
		int v = e.from();
		adj[v].add(e);
	}
	
	public Iterable<DiEdge> adj(int v){
		return adj[v];
	}
	
	
}
