package compression;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException{
		File file = new File("C:\\java\\java "
				+ "practice\\algorithms\\src\\java.txt");  
		FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader); 
        String line = "";  
        String s = "";
        
        while (line != null) {  
            line = br.readLine();
            s += line;
        }  
		br.close();
		
		String test = "i am frank";
		
		Huffman huff = new Huffman(s);
		huff.tree();
		huff.display();
		String t = huff.compress(test);
		System.out.println(huff.expand(t));
	}
}
