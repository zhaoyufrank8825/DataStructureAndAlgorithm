package shortestpath;

public class Test {

	public static void main(String[] args) {
		WeightedDiGraph g = new WeightedDiGraph(8);
		g.addEdge(new DiEdge(0, 1, 5.0));
		g.addEdge(new DiEdge(0, 4, 9.0));
		g.addEdge(new DiEdge(0, 7, 8.0));
		g.addEdge(new DiEdge(1, 2, 12.0));
		g.addEdge(new DiEdge(1, 3, 15.0));
		g.addEdge(new DiEdge(1, 7, 4.0));
		g.addEdge(new DiEdge(2, 3, 3.0));
		g.addEdge(new DiEdge(2, 6, 11.0));
		g.addEdge(new DiEdge(3, 6, 9.0));
		g.addEdge(new DiEdge(4, 5, 4.0));
		g.addEdge(new DiEdge(4, 6, 20.0));
		g.addEdge(new DiEdge(4, 7, 5.0));
		g.addEdge(new DiEdge(5, 2, 1.0));
		g.addEdge(new DiEdge(5, 6, 13.0));
		g.addEdge(new DiEdge(7, 5, 6.0));
		g.addEdge(new DiEdge(7, 2, 7.0));
		
		
		SP sp = new SP(g);
//		sp.topological(g, 0);
//		sp.topshorted(g);
		
//		sp.Dijkstra(g, 0);
		sp.ford(g, 0);
		
		for(int i=0; i<g.V; i++){
			System.out.printf("%d -> %d,  (%.2f)", 0, i, sp.dist(i));
			System.out.println();
			sp.path(i);
			sp.pathdisplay();
			System.out.println();
		}
	}
}
