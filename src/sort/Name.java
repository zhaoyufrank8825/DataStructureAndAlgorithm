package sort;

import java.util.Comparator;

public class Name implements Comparator<Object> {  
    @Override  
    public int compare(Object arg0, Object arg1) {  
        Person a = (Person) arg0;  
        Person b = (Person) arg1;  
        if (a.getName().compareTo( b.getName())<0 ) 
            return -1;  
        else if (a.getName().compareTo( b.getName())>0)  
            return 1;  
        else return 0;    
    }  
}  

