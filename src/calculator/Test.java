package calculator;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Student[] stu = new Student[6];
		
		stu[0] = new Student("zhaoyu", 1, 80, "xiangtan");
		stu[1] = new Student("yingying", 4, 90, "yiyang");
		stu[2] = new Student("caolin", 5, 60, "yiyang");
		stu[3] = new Student("chenli", 2, 95, "jilin");
		stu[4] = new Student("huiyu", 3, 80, "jiangxi");
		stu[5] = new Student("xiaoming", 6, 85, "shandong");
		
		Arrays.sort(stu);
		System.out.println(Arrays.toString(stu));
		System.out.println();
		Arrays.sort(stu, new Score());
		System.out.println(Arrays.toString(stu));
		System.out.println();
		Arrays.sort(stu, new Name());
		System.out.println(Arrays.toString(stu));
		System.out.println();
	}
}
