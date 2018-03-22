//package tree;
//
//
//public class Symbol {
//
//	public int N;
//	public Node[] arr ;
//
//	public Symbol(){
//		this.N = 0;
//		this.arr = new Node[100];
//	}
//	
//	public boolean contains(String k){
//		return get(k) != -1;
//	}
//	
//	public void delete (String k){
//		put(k, -1);
//	}
//	
//	public void put(String k, int data){
//		int i;
//		for( i=0; i<N; i++ ){
//			if(arr[i].k == k){
//				arr[i].data = data;
//				break;
//			}
//		}
//		if( i == N ){
//			Node node = new Node();
//			node.k = k;
//			node.data = data;
//			arr[N++] = node;
//		}
//	}
//	
//	public int get(String k){
//		for(int i=0; i<N; i++){
//			if( arr[i].k == k){
//				return arr[i].data;
//			}
//		}
//		return -1;
//	}
//	
//	public boolean contain(String k){
//		return get(k) != -1;
//	}
//	
//	public Value get(key key){
//		if(isEmpty()) return null;
//		int i = rank(key);
//		if( i<N && keys[i].compareTo(key) == 0) return vals[i];
//		else return null;
//	}
//	
//	private int rank(key key){
//		int lo = 0, hi = N-1;
//		
//		while(lo<=hi){
//			int mid = (lo + hi) /2;
//			if(arr[mid].k = key){
//				return mid;
//			} else if(arr[mid].k > key){
//				hi = mid - 1 ;
//			} else {
//				lo = mid + 1 ;
//			}
//		}
//		return lo;
//	}
//	
//	
//}
//
//
//
//
//
//
//
//
//
//
