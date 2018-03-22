package calculator;

import java.util.Comparator;

public class Name implements Comparator<Student> {

	@Override
	public int compare(Student a, Student b) {
		if(a.name.compareTo(b.name) > 0) return -1;
		else if (a.name.compareTo(b.name) < 0) return 1;
		else return 0;
	}

}
