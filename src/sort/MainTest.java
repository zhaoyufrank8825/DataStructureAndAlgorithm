package sort;

import java.util.Arrays;

public class MainTest {  
    public static void main(String[] args) {  
        Person[] p = new Person[6];  
        p[0] = new Person("ZZZ",19);  
        p[1] = new Person("AA", 109);  
        p[2] = new Person("AA", 19);  
        p[3] = new Person("YYY",100);  
        p[4] = new Person("AA", 180);  
        p[5] = new Person("YCC",100); 
        Arrays.sort(p);//调用自有的排序  
        System.out.println(Arrays.toString(p));
        System.out.println();
        Arrays.sort(p, new Cmp());//调用Comparator定义的排序  
        System.out.println(Arrays.toString(p));  
        System.out.println();
        Arrays.sort(p, new Year());//调用Comparator定义的排序  
        System.out.println(Arrays.toString(p));  
        System.out.println();
        Arrays.sort(p, new Name());//调用Comparator定义的排序  
        System.out.println(Arrays.toString(p));  
    }  
}  
