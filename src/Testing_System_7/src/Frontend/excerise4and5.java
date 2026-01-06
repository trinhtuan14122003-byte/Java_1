package Frontend;

import java.util.Scanner;

import Entity.Student;

public class excerise4and5 {
	public static void main(String[] args) {

		Student[] st = new Student[3];

		System.out.println("Demo Get Set Collect:");
		System.out.println("Collect là: " + Student.getNameSchool());

		System.out.println("Thay đổi Collect: Đại học Hà Nội");
		Student.setNameSchool("Đại học Hà Nội");

		System.out.println("Collect là: " + Student.getNameSchool());
		System.out.println("--------------------------------");

		Scanner scanner = new Scanner(System.in); // ✅ tạo 1 lần

		// question 5
		for (int i = 0; i < 3; i++) {
			System.out.println("Nhập tên học sinh" + (i + 1) + ":");
			String name = scanner.next();
			Student s = new Student();
			s.setName(name);
			System.out.println("Tên học viên" + " " + (i + 1) + ":" + name);
			// tổng số học sinh sau khi tạo
			int tong = i++;
			s.setCount(tong);
			System.out.println("tổng số học viên hiện tại: " + tong);
		}
	}
}