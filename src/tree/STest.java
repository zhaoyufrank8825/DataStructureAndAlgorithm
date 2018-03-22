package tree;

import java.io.*;
import java.util.TreeMap;

public class STest {
	public static void main(String[] args) throws Exception{
		int min = 3;
		TreeMap<String, Integer> st = new TreeMap<String, Integer>();
		File file = new File("C:\\java\\java practice\\algorithms\\src\\java.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		
		while( (line = br.readLine()) != null){
			line.toLowerCase();
			String reg1 = "\\s+";
			String reg2 = "\\w+";
			
			String str[] = line.split(reg1);
			for(String word : str){
				if(word.matches(reg2)){
					if( word.length() < min) ;
					else if( !st.containsKey(word)){
						st.put(word, 1);
					}else{
						st.put(word, st.get(word)+1);
					}
				}
			}
		}
		br.close();
		
		String max = "";
		st.put(max, 0);
		for(String s: st.keySet() )
			if(st.get(s) > st.get(max))
				max = s;
		System.out.println(max+ " "+st.get(max));
		
	}
}
