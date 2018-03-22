package miniumSpanningTree;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MST {
	
	public double wei ;
	private int N;
	private int Size;
	private LinkedList<Edge> link = new LinkedList<Edge>();
	private PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	private QuickUnion qu;
	
	public MST(EdgeWeightedGraph g){
		this.qu = new QuickUnion(g.V);
		this.N = g.V;
		for(int i=0; i<g.V; i++){
			for( Edge w : g.adj(i)){
				pq.add(w);
			}
		}
	}
	
	public Iterable<Edge> edges(){
		return link;
	}
	
	public void display(){
		while( !link.isEmpty() ){
			System.out.println(link.removeFirst() + " ");
		}
	}
	
	public void Kruskal(){
		while( !pq.isEmpty() && Size < N - 1 ){
			Edge e = pq.remove();
			int v = e.either(), w = e.other(v);
			if( !qu.connected(v, w) ){
				qu.union(v, w);
				link.add(e);
				wei += e.weight;
			}
		}
	}
}
