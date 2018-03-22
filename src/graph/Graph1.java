package graph;

import java.util.LinkedList;
import java.util.Stack;

public class Graph1 {
	LinkedList<Integer>[] vertexes;
	private boolean[] marked;
	private int[] pathTo;
	private int Vsize;
	private int[] id;
	private int count = 0;
	
	public Graph1(int n){
		vertexes = (LinkedList<Integer>[]) new LinkedList[n];
		marked = new boolean[n];
		pathTo = new int[n];
		id = new int[n];
		for(int i=0; i<n; i++){
			vertexes[i] = new LinkedList<Integer>();
			pathTo[i] = -1;
		}
		this.Vsize = n;
	}
	
	public void addEdge(int n, int m){
		vertexes[n].add(m);
		vertexes[m].add(n);
	}
	
	public void display(int i){
		System.out.print(i+" ");
	}
	
	public Iterable<Integer> adj(int i){
		return vertexes[i];
	}
	
	public void DepthFS(){
		for(int i=0; i<Vsize; i++){
			if( !marked[i] ){
				dfs(i);
				count++;
			}
		}
	}
	
	public void dfs(int v){
		marked[v] = true;
		display(v);
		id[v] = count;
		System.out.print(" \""+id[v]+ "\" ");
		for(int w : adj(v)){
			if (marked[w]==false){
				dfs(w);
				pathTo[w] = v;				
			}
		}
	}
	
	public boolean hasPath(int v){
		return marked[v];
	}
	
	public Iterable<Integer> path(int v){
		if( !hasPath(v) ) return null;
		Stack<Integer> stack = new Stack<Integer>();
		for(int x=v; x!=-1; x = pathTo[x] ){
			stack.push(x);
			display(x);
		}
		return stack;
	}
	
	public void bfs(int v){
		for(int i=0; i<Vsize; i++){
			marked[i] = false;
			pathTo[i] = -1;
		}
		LinkedList<Integer> queue = new LinkedList<Integer>();
		marked[v] = true;
		queue.addLast(v);
		
		while( !queue.isEmpty() ){
			int k = queue.removeFirst();
			display(k);
			for( int w : adj(k)){
				if( !marked[w] ){
					marked[w] = true;
					queue.addLast(w);
					pathTo[w] = k;
				}
			}
		}
	}
	
}










