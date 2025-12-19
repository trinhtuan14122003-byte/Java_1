package VTI.Frontend;

import java.time.LocalDate;

import VTI.entity.Account;
import VTI.entity.Department;
import VTI.entity.Group;

public class Testing_4 {
	public static void main(String[] args) {
//	Question 1:
//		Tạo constructor cho department:
//		a) Không có parameters
//		b) Có 1 parameter là nameDepartment và default id của
//		Department = 0
//		Khởi tạo 1 Object với mỗi constructor ở trên
		System.out.println("Question 1");
		Department Name_1 = new Department(1, "Hiếu");
		Name_1.showInfo();

		System.out.println("Quetstion 2");
		Account Name_2 = new Account(1, "Ntringtuna@gmail.com", "tuan");
		Name_2.Showinfo_2();

		System.out.println("question 3");
		Group testing = new Group(1, "cầu lòng", "hiếu", 12 - 12 - 2012, 1);
		testing.showinfo_3();

		System.out.println("question 4");
		Account creator = new Account("thiếu");

		Group testing_4 = new Group(1, "cầu lồng", creator, new String[] { "tuấn", "trung", "hoàng" },
				LocalDate.of(2003, 12, 12));
		testing_4.showinfo_4();
	}
}
