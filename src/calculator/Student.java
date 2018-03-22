package calculator;

public class Student implements Comparable<Student>{
	public String name;
	public int number;
	public int score;
	public String hometowm;
	
	public Student(String name, int number, int score, String hometown){
		this.name = name;
		this.number = number;
		this.score = score;
		this.hometowm = hometown;
	}

	@Override
	public int compareTo(Student o) {
		if(this.name.compareTo(o.name) > 0) return -1;
		else if (this.name.compareTo(o.name) < 0) return 1;
		else return 0;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", number=" + number + ", score=" + score + ", hometowm=" + hometowm + "]";
	}
	
}
