package graph;

import java.util.LinkedList;
import java.util.Stack;

public class DiGraph {
	LinkedList<Integer>[]  vert;
	private int Vsize;
	private boolean[] marked;
	private int[] edgeTo;
	private int[] path;
//	private int[] distTo;
	int count = 0;
	
	public DiGraph(int n){
		vert = (LinkedList<Integer>[]) new LinkedList[n];
		marked = new boolean[n];
		edgeTo = new int[n];
		path = new int[n];
//		distTo= new int[n];
		Vsize = n;
		for(int i=0; i<n; i++){
			vert[i] = new LinkedList<Integer>();
			edgeTo[i] = -1;
			path[i] = -1;
		}
	}
	
	public void addEdge(int from, int to){
		vert[from].addLast(to);
	}
	
	public Iterable<Integer> adj(int n){
		return vert[n];
	}
	
	public DiGraph reverse(){
        DiGraph r=new DiGraph(Vsize);   
        for (int i=0;i<Vsize;i++){
            for (int x:adj(i)){
                r.addEdge(x,i);
//              System.out.println(x+" -> "+ i);
            }
        }
        return r;
    }
	
	public void marked(){
		for(int i=0; i<Vsize; i++){
			marked[i] = false;
		}
	}
	
	
//	public void dfs(int n){
//		for(int i=0; i<Vsize; i++){
//			marked[n] = true;
//			System.out.print(n + " ");
//			for(int w : adj(n)){
//				if( !marked[w] ){
//					dfs(w);
//					edgeTo[w] = n;
//				}
//			}
//		}
//	}
//	
//	public boolean hasPath(int v){
//		return marked[v];
//	}
//	
//	public Iterable<Integer> dfspathTo(int w){
//		if( !hasPath(w) ) return null;
//		Stack<Integer> stack = new Stack<Integer>();
//		for(int x=w;  x!=-1;  x=edgeTo[x]){
//			stack.push(x);
//			System.out.print(x + " ");
//		}
//		return stack;
//	}
//	
//	public void dfspathTo(int w){
//		for(int x = w; x != -1 ; x = edgeTo[x]){
//			System.out.print(x + " ");
//		}
//	}
//	
//	public void bfs(int n){
//		for(int i=0; i<Vsize; i++){
//			marked[i] = false;
//		}
//		
//		LinkedList<Integer>  queue = new LinkedList<Integer>();
//		marked[n] = true;
//		queue.addLast(n);
//		while(!queue.isEmpty()){
//			int v = queue.removeFirst();
//			System.out.print(v + " ");
//			for(int w : adj(v)){
//				if(!marked[w]){
//					marked[w] = true;
//					path[w] = v;
//					distTo[w] = distTo[v]+1;
//					queue.addLast(w);
//				}
//			}
//		}
//		
//		for(int i=0; i<Vsize; i++){
//			marked[i] = false;
//		}
//	}
//	
//	public void bfspathTo(int w){
//		for(int x = w; x != -1 ; x = path[x]){
//			System.out.print(x + " ");
//		}
//	}
//	
//	public void bfsdistTo(){
//		for(int i = 0; i<Vsize; i++){
//			System.out.print(distTo[i] + " ");
//		}
//	}
//	
	Stack<Integer> postOrder = new Stack<Integer>();
	public void topological(int n){
		marked[n] = true;
		for(int w : adj(n)){
			if( !marked[w] ){
				topological(w);
			}
		}
		postOrder.push(n);
		System.out.print( n + " ");
	}

	public void DepthFS(){
		for(int i=0; i<Vsize; i++){
			marked[i] = false;
		}
		
		for(int i=0; i<Vsize; i++){
			if( !marked[i] ){
				topological(i);
			}
		}
	}
	
	
	public void Connect(Stack<Integer> postOrder){
		for(int i=0; i<Vsize; i++){
			marked[i] = false;
		}
		
		for(int i=0; i<Vsize; i++){
			int j = (int) postOrder.pop();
			if( !marked[j] ){
				topological(j);
				System.out.print(" [");
				System.out.print(count++);
				System.out.print("] ");
			}
		}
	}
	
	public Iterable<Integer> toporder(){
		return postOrder;
	}
	
//	public void topDisplay(){
//		for(int i=0; i<Vsize; i++){
//			System.out.print(postOrder.pop() + " ");
//		}
//	}
	
}

