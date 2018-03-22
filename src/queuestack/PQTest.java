package queuestack;

public class PQTest {
	public static void main(String[] args){
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	
		pq.insert(10); 
		pq.insert(9); 
		pq.insert(20); 
		pq.insert(4); 
		pq.insert(7); 
		pq.insert(8); 
		pq.insert(21); 
		pq.insert(18); 
		pq.insert(6); 
	
		pq.display();
	}
}
