package sort;

import java.util.Comparator;

public class Year implements Comparator<Person> {  
    @Override  
    public int compare(Person arg0, Person arg1) {  
        Person a = (Person) arg0;  
        Person b = (Person) arg1;  
        if (a.getAge() < b.getAge())  
            return -1;  
        else if (a.getAge() > b.getAge())  
            return 1;  
        else return 0;    
    }  
}  
