package substringSearch;

import java.util.Stack;
import java.util.LinkedList;

public class regularExpress {
	
	private char[] re;
	private DiGraph g;
	private int M;
	
	public regularExpress(String regexp){
		this.M = regexp.length();
		re = regexp.toCharArray();
		g = regularDiGraph( regexp );
	}
	
	public boolean recognize(String text){
		LinkedList<Integer> pc = new LinkedList<Integer>();
		g.dfs(0);
		for(int i=0; i<M+1; i++){
			if( g.marked[i] ){
				pc.add(i);
			}
		}
		
		for(int i=0; i<text.length(); i++){
			LinkedList<Integer> match = new LinkedList<Integer>();
			for( int v : pc ){
				if( v == M ) continue;
				if( re[v] == text.charAt(i) || re[v] == '.'){
					match.add(v+1);
					System.out.println(v+"=="+i);
				}
			}
			System.out.println();
			pc =  new LinkedList<Integer>();
			while( !match.isEmpty()){
				int k = match.removeFirst();
				g.dfs( k );
				
				for(int j=0; j<M+1; j++){
					if( g.marked[j] ){
						pc.add(j);
					}
				}
			}
			
//			for(int w : match){
//			System.out.println(w);
//			g.dfs( w );
//			
//			for(int j=0; j<M+1; j++){
//				if( g.marked[j] ){
//					pc.add(j);
//				}
//			}
//			match.removeFirst();
//		}
		}
		
		for( int v : pc ){
			if ( v == M ) return true;
		}
		return false;
	}
	
	private DiGraph regularDiGraph(String re){
		int M = re.length();
		char[] reg = re.toCharArray();
		DiGraph g = new DiGraph(M+1);
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<M; i++){
			int lp = i;
			if( reg[i] == '(' || reg[i] == '|' ){
				stack.push(i);
			}
			
			if( reg[i] == ')' ){
				int or = stack.pop();
				if( reg[or] == '|' ){
					lp = stack.pop();
					g.addEdge(lp, or+1);
					g.addEdge(or, i);
				}else lp = or;	
			}
			
			if( i<M-1 && reg[i+1] == '*'){
				g.addEdge(lp, i+1);
				g.addEdge(i+1, lp);
			}
			
			if( reg[i]=='(' || reg[i]==')' || reg[i]=='*'){
				g.addEdge(i, i+1);
			}
		}
		return g;
	}
}
