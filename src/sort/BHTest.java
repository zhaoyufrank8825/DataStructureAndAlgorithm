package sort;

public class BHTest {
	public static void main(String[] args){
		BinaryHeap<Integer> arr = new BinaryHeap<Integer>(100);
		
		arr.insert(50);
		arr.insert(40);
		arr.insert(30);
		arr.insert(55);
		arr.insert(60);
		arr.insert(25);
		arr.insert(10);
		arr.insert(5);
		arr.insert(75);
		arr.insert(15);
		arr.insert(78);
		
		for(int i=1; i< 12; i++){
			System.out.print( i + "  ");
		}
		System.out.println();
		arr.display();
		
		System.out.println();
		arr.delMax();
		arr.display();
		
		System.out.println();
		arr.delMax();
		arr.display();
	}
}
