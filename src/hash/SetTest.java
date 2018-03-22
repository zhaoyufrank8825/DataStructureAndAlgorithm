package hash;

import java.util.Map;
import java.util.Random;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Collection;

public class SetTest {

    public static void main(String[] args) {
        int val = 0;
        String key = null;
        Integer value = null;
        Random r = new Random();
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (int i=0; i<12; i++) {
            // 随机获取一个[0,100)之间的数字
            val = r.nextInt(100);
            
            key = String.valueOf(val);
            value = r.nextInt(5);
            // 添加到HashMap中
            map.put(key, value);
            System.out.println(" key:"+key+" value:"+value);
        }
        // 通过entrySet()遍历HashMap的key-value
        iteratorHashMapByEntryset(map) ;
        
        // 通过keySet()遍历HashMap的key-value
        iteratorHashMapByKeyset(map) ;
        
        // 单单遍历HashMap的value
        iteratorHashMapJustValues(map);        
    }
    
    /*
     * 通过entry set遍历HashMap
     * 效率高!
     */
    private static void iteratorHashMapByEntryset(HashMap<String, Integer> map) {
        if (map == null)
            return ;

        System.out.println("\niterator HashMap By entryset");
        String key = null;
        Integer integ = null;
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry)iter.next();
            
            key = (String)entry.getKey();
            integ = (Integer)entry.getValue();
            System.out.println(key+" -- "+integ.intValue());
        }
    }

    /*
     * 通过key set来遍历HashMap
     * 效率低!
     */
    private static void iteratorHashMapByKeyset(HashMap<String, Integer> map) {
        if (map == null)
            return ;

        System.out.println("\niterator HashMap By keyset");
        String key = null;
        Integer integ = null;
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            key = (String)iter.next();
            integ = (Integer)map.get(key);
            System.out.println(key+" -- "+integ.intValue());
        }
    }
    

    /*
     * 遍历HashMap的values
     */
    private static void iteratorHashMapJustValues(HashMap<String, Integer> map) {
        if (map == null)
            return ;
        
        System.out.println("\niterator HashMap By Valueset");
        Collection<Integer> c = map.values();
        Iterator<Integer> iter= c.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
       }
    }
}