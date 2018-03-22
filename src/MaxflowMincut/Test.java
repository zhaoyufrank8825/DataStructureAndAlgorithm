package MaxflowMincut;

public class Test {
	public static void main(String[] args){
		FlowNetwork g = new FlowNetwork(6);
		g.addEdge(new FlowEdge(0, 1, 10));
		g.addEdge(new FlowEdge(0, 2, 10));
		g.addEdge(new FlowEdge(2, 1, 4));
		g.addEdge(new FlowEdge(1, 3, 9));
		g.addEdge(new FlowEdge(1, 4, 4));
		g.addEdge(new FlowEdge(2, 4, 8));
		g.addEdge(new FlowEdge(3, 4, 15));
		g.addEdge(new FlowEdge(3, 5, 10));
		g.addEdge(new FlowEdge(4, 5, 10));
	
		FoldFulkerson fold = new FoldFulkerson(g, 0 , 5);
		fold.value();
		fold.cutDisplay(g);
		
		
	}
}
