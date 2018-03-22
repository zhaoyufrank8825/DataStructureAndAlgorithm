package graph;

import java.util.Stack;

public class Test {
	public static void main(String[] args){
		DiGraph g = new DiGraph(13);
		Stack<Integer> reOrder = new Stack<Integer>();
		
		g.addEdge(4, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 2);
		g.addEdge(6, 0);
		g.addEdge(0, 1);
		g.addEdge(2, 0);
		g.addEdge(11, 12);
		g.addEdge(12, 9);
		g.addEdge(9, 10);
		g.addEdge(9, 11);
		g.addEdge(7, 9);
		g.addEdge(10, 12);
		g.addEdge(11, 4);
		g.addEdge(4, 3);
		g.addEdge(3, 5);
		g.addEdge(6, 8);
		g.addEdge(8, 6);
		g.addEdge(5, 4);
		g.addEdge(0, 5);
		g.addEdge(6, 4);
		g.addEdge(6, 9);
		g.addEdge(7, 6);

		DiGraph r = g.reverse();
		r.DepthFS();
		reOrder = (Stack<Integer>) r.toporder();
		System.out.println();
		g.Connect(reOrder);
		
		
		
		
	}
}

