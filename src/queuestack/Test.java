package queuestack;

import java.util.Scanner;

public class Test {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		StackArray<String> link = new StackArray<String>();
		System.out.println("please input the words:");

		while( true ){
			String x = scanner.next();
			if(x.equals("#")){
				break;
			}else if(x.equals("-") ){
				System.out.print(" "+link.pop()+" ");
			} else {
				link.push(x);
			}
		}
		scanner.close();
	}
}
