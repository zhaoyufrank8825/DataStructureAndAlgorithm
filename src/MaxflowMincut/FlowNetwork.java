package MaxflowMincut;

import java.util.LinkedList;

public class FlowNetwork {
	private final int Vsize;
	private LinkedList<FlowEdge>[] adj;
	
	public FlowNetwork(int Vsize){
		this.Vsize = Vsize;
		adj = (LinkedList<FlowEdge>[]) new LinkedList[Vsize];
		for(int i=0; i<Vsize; i++){
			adj[i] = new LinkedList<FlowEdge>();
		}
	}
	
	public void addEdge(FlowEdge e){
		int v = e.from(), w = e.to();
		adj[v].add(e);
		adj[w].add(e);
	}
	
	public Iterable<FlowEdge> adj(int v){
		return adj[v];
	}
	
	public int Vsize(){
		return Vsize;
	}
	
}
