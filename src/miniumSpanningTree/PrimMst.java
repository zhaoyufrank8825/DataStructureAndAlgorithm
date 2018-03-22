package miniumSpanningTree;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class PrimMst {
	private PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	private LinkedList<Edge> mst = new LinkedList<Edge>();
	private boolean[] marked;
	
	public PrimMst(EdgeWeightedGraph g){
		marked = new boolean[g.V];
		visit(g, 0);
		
		while( !pq.isEmpty() ){
			Edge e = pq.remove();
			int v = e.either(), w = e.other(v);
			if( marked[v] && marked[w] ) continue;
			mst.add(e);
			if( !marked[v] ) visit(g, v);
			if( !marked[w] ) visit(g, w);
		}
		
	}
	
	public void display(){
		while( !mst.isEmpty() ){
			System.out.println(mst.removeFirst() + " ");
		}
	}
	
	public void visit(EdgeWeightedGraph g, int n){
		marked[n] = true;
		for(Edge e : g.adj(n)){
			if(!marked[e.other(n)])
				pq.add(e);
		}
	}
}
