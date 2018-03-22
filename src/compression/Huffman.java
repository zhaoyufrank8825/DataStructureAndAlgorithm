package compression;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Huffman {
	private int N;
	private String s;
	private final int R = 255;
	private int[] freq = new int[R];
	private PriorityQueue<Node> pq = new PriorityQueue<Node>();
	private Node root;
	private String[] path = new String[R];
	private LinkedList<Integer> list;
	
	public Huffman(String s){
		this.N = s.length();
		this.s = s;
	}

	public Node tree(){
		freq = freqs();
		
		for(int i=0; i<R; i++){
			path[i] = "";
			if( freq[i]>0 ){
				pq.add(new Node( (char)i, freq[i], null, null ));
			}
		}
		
		while( pq.size() > 1 ){
			Node x = pq.remove();
			Node y = pq.remove();
			Node parent = new Node('\0', x.getfreq()+y.getfreq(), x, y);
			pq.add(parent);
			
			list = new LinkedList<Integer>();
			traversal(x);
			for(int k : list){
				path[k] = "0"+path[k];
			}
			
			list = new LinkedList<Integer>();
			traversal(y);
			for(int w : list){
				path[w] = "1"+path[w];
			}
		}
		
		return root = pq.peek();
	}
	
	private int[] freqs(){
		for(int i=0; i<N; i++){
			char c = s.charAt(i);
			freq[c]++;
		}
		return freq;
	}
	
	private void traversal(Node x){
		if( x.isleaf() ){
			list.add( (int)x.getchar() );
			return;
		}
		traversal(x.left);
		traversal(x.right);
	}
	
	public void display(){
		for(int i=0; i<R; i++){
			if( freq[i]>0 ){
				System.out.println((char)i + " "+freq[i] + " "+path[i]);
			}
		}
	}
	
	public String compress(String text){
		String encode = "";
		for(int i=0; i<text.length(); i++){
			encode += path[(int)text.charAt(i)];
		}
		System.out.println(encode);
		return encode;
	}
	
	public String expand(String t){
		Node x = root;
		String text = "";
		
		for(int i=0; i<t.length()+1; i++){
			if( !x.isleaf() ){
				if ( i<t.length() && t.charAt(i) == '0' ){
					x = x.left;
				}else{
					x = x.right;
				}
			}else{
				text += x.getchar();
				x = root;
				i--;
			}
		}
		return text;
   	}

}
