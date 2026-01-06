package Backend;

import java.util.ArrayList;
import java.util.Scanner;

import Entity.Student;

public class Excersie1 {
	Scanner scan = new Scanner(System.in);
	Student[] students = new Student[3];
	ArrayList<Student> stulist = new ArrayList<>();
	int quy = 0;

	public void Question1() {
		ArrayList<Student> stulist = new ArrayList<>();

		for (int i = 0; i < students.length; i++) {
			System.out.println("nhập thông tin sinh viên" + (i + 1 + ":"));
			String nhaptenhocsinh = scan.next();
			quy += 100;
			System.out.println("Các sinh viên nộp quỹ, mỗi bạn 100K: ");
			System.out.println("quỹ lớp: " + quy);
			Student stu = new Student();
			stu.setName(nhaptenhocsinh);
			students[i] = stu;
			stulist.add(stu);

			// mỗi học sinh nopoj 100
//			stu.nopquylop(200);
//			quy += 100;
//			System.out.println("Các sinh viên nộp quỹ, mỗi bạn 100K: ");
//			System.out.println("quỹ lớp: " + quy);

		}

		System.out.println("\nThông tin sinh viên (mảng):");
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}

		System.out.println("\nThông tin sinh viên (ArrayList):");
		System.out.println(stulist);

		System.out.println("Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan: ");
		System.out.println("Tổng quỹ: " + (quy -= 50));

		System.out.println("Student thứ 2 lấy 20k đi mua bánh mì: ");
		System.out.println("Tổng quỹ: " + (quy -= 20));

		System.out.println("Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm: ");
		System.out.println("Tổng quỹ: " + (quy -= 150));

		System.out.println("Cả nhóm mỗi người lại đóng quỹ mỗi người 50k: ");
		System.out.println("Tổng quỹ: " + (quy += 150));
	}

}
