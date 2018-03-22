package sort;

import java.util.Comparator;  

public class Person implements Comparable<Person>{  
    private String name;  
    private int age;  
    public Person(String name, int age) {  
        this.name = name;  
        this.age = age;  
    }  
    public String getName() {  
        return this.name;  
    }  
    public int getAge() {  
        return this.age;  
    }  
    @Override  
    public String toString() {  
        return ""+this.name+" "+this.age;  
    }  
    @Override  
    public int compareTo(Person o) {  
          
    	 if (this.getName().compareTo(o.getName()) != 0)  
             return this.getName().compareTo(o.getName());  
         else {  
            if (this.getAge() < o.getAge())  
                return -1;  
            else if (this.getAge() > o.getAge())  
                return 1;  
            else return 0;  
         }
    }  
}  

class Cmp implements Comparator<Object> {  
    @Override  
    public int compare(Object arg0, Object arg1) {  
        Person a = (Person) arg0;  
        Person b = (Person) arg1;  
        if (a.getName().compareTo(b.getName()) != 0)  
            return a.getName().compareTo(b.getName());  
        else {  
            if (a.getAge() < b.getAge())  
                return -1;  
            else if (a.getAge() > b.getAge())  
                return 1;  
            else return 0;  
        }  
    }  
}  






