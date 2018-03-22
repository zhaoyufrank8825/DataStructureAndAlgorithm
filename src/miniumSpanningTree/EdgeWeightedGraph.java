package miniumSpanningTree;

import java.util.LinkedList;

public class EdgeWeightedGraph {
	public final int V;
	private final LinkedList<Edge>[] adj;
	
	public EdgeWeightedGraph(int V){
		this.V = V;
		adj = (LinkedList<Edge>[]) new LinkedList[V];
		for(int i=0; i<V; i++){
			adj[i] = new LinkedList<Edge>();
		}
	}
	
	public void addEdge(Edge e){
		int v = e.either(), w = e.other(v);
		adj[v].addLast(e);
		adj[w].addLast(e);
	}
	
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
}
