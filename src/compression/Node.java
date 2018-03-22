package compression;

import java.util.PriorityQueue;

public class Node implements Comparable<Node>{
	private char c;
	private int freq;
	public Node left, right;
	
	PriorityQueue<Node> pq = new PriorityQueue<Node>();
	private final int R = 255;
	int[] freqs = new int[R];
	
	public Node(){
		
	}
	
	public Node(char c, int freq, Node left, Node right){
		this.c = c;
		this.freq = freq;
		this.left = left;
		this.right = right;
	}
	
	public char getchar(){
		return c;
	}
	
	public int getfreq(){
		return freq;
	}
	
	public boolean isleaf(){
		return left == null && right == null;
	}

	public int compareTo(Node that) {
		if( this.freq > that.freq ) return 1;
		else if ( this.freq < that.freq ) return -1;
		else return 0;
	}

//	public void expand(String s){
//		Node root = readTrie();
//		int N = s.length();
//		
//		for(int i=0; i<N; i++){
//			Node x = root;
//			while( !x.isleaf() ){
//				if( x.left != null ){
//					x = x.left;
//				}else {
//					 x = x.right;
//				}
//			}
//			System.out.println(x.c);
//		}
//	}
//	
//	public static void wirteTrie(Node x){
//		if( x.isleaf() ){
//			System.out.println(true);
//		}
//		System.out.println(false);
//		wirteTrie( x.left );
//		wirteTrie( x.right );
//	}
//	
//	public static Node readTrie(){
//		if()
//		
//		return x;
//	}
//	
//	public Node huffman(){	
//		for(int i=0 ; i<R; i++){
//			if( freqs[i] > 0 ){
//				pq.add(new Node((char)i, freqs[i], null, null));
//			}
//		}
//		
//		while( pq.size() > 1 ){
//			Node x = pq.remove();
//			Node y = pq.remove();
//			Node parent = new Node('\0', x.getfreq() + y.getfreq(), x, y);
//			pq.add(parent);
//		}
//		
//		return pq.remove();
//	}
	
}









