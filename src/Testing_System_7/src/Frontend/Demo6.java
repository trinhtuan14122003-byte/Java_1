package Frontend;

import Entity.PrimaryStudent;
import Entity.SecondaryStudent;

public class Demo6 {
	public static void main(String[] args) {
		System.out.println("Tạo 2 Primary Student: ");
		PrimaryStudent pSt1 = new PrimaryStudent(1, "hiếu", 100);
		PrimaryStudent pSt2 = new PrimaryStudent(2, "chung", 100);

		PrimaryStudent[] primaryStudents = { pSt1, pSt2 };
		PrimaryStudent pr = new PrimaryStudent();
		System.out.println("Danh sách Primary Student:");
		for (int i = 0; i < primaryStudents.length; i++) {
			System.out.println(primaryStudents[i]);
//			System.out.println("Tổng số học sinh pr:" + pr.getCountpr());
		}

		System.out.println("Tạo 6 Secondary Student: ");
//		SecondaryStudent sST1 = new SecondaryStudent(1, "Hiếu", 100);
//		SecondaryStudent sST2 = new SecondaryStudent(2, "An", 100);
//		SecondaryStudent sST3 = new SecondaryStudent(3, "Bình", 100);
//		SecondaryStudent sST4 = new SecondaryStudent(4, "Chi", 100);
//		SecondaryStudent sST5 = new SecondaryStudent(5, "Dũng", 100);
//		SecondaryStudent sST6 = new SecondaryStudent(6, "Lan", 100);

		SecondaryStudent[] secstu = SecondaryStudent.secondaryStudents;
		System.out.println("Danh sách Secondary Student:");
		for (int u = 0; u < secstu.length; u++) {
			System.out.println(secstu[u]);
		}
		System.out.println("Tổng số học sinh pr:" + primaryStudents.length);
		System.out.println("Thông tin số lượng sinh viên Second Student:" + SecondaryStudent.getCOUNTSecond());
	}
}