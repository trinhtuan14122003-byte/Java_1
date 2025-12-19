package VTI.Frontend;

import java.time.LocalDate;
import java.util.Scanner;

import VTI.entity.Account;
import VTI.entity.Department;
import VTI.entity.Group;
import VTI.entity.Position;
import VTI.entity.PositionName;

public class Testing_2 {
	public static void main(String[] args) {
		// tạo ra các đối tượng deparmetn
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Makering";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Sale";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "BOD";

//		tạo ra các position
		Position Position1 = new Position();
		Position1.id = 1;
		Position1.name = PositionName.DEV;

		Position Position2 = new Position();
		Position2.id = 2;
		Position2.name = PositionName.Test;

		Position Position3 = new Position();
		Position3.id = 3;
		Position3.name = PositionName.Scrum_Master;

		Position Position4 = new Position();
		Position4.id = 4;
		Position4.name = PositionName.PM;

//		taok account
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "daonq1";
		acc1.userName = "daonq1";
		acc1.fullName = "Dao Nguyen 1";
		acc1.department = department1;
		acc1.position = Position2;
		acc1.createDate = LocalDate.now();

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "daonq2";
		acc2.userName = "daonq2";
		acc2.fullName = "Dao Nguyen 2";
		acc2.department = department2;
		acc2.position = Position2;
		acc2.createDate = LocalDate.of(2021, 03, 17);

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "daonq3";
		acc3.userName = "daonq3";
		acc3.fullName = "Dao Nguyen 3";
		acc3.department = department3;
		acc3.position = Position3;
		acc3.createDate = LocalDate.now();

//		Tọa group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "daonq";
		group1.creator = acc1;
		group1.createDate = LocalDate.of(2020, 9, 30);

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "FooTball";
		group2.creator = acc2;
		group2.createDate = LocalDate.now();

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "mentor";
		group3.creator = acc3;
		group3.createDate = LocalDate.of(2024, 9, 30);

// khai bao các gr mà acc 1 tham gia
		Group[] gr_acc1 = { group1, group2 };
		acc1.groups = gr_acc1;

		Group[] gr_acc2 = { group2, group3 };
		acc2.groups = gr_acc2;

		Group[] gr_acc3 = { group1, group2, group3 };
		acc3.groups = gr_acc3;

		// in ra hệ thống
//		System.out.println("----Department----");
//		System.out.println("Department :" + department1.id + " " + department1.name);
//		System.out.println("Department :" + department2.id + " " + department2.name);
//		System.out.println("Department :" + department3.id + " " + department3.name);
//
//		System.out.println("toString():" + department1.toString());
//		System.out.println("Group:" + group1.toString());
//		System.out.println("account: " + acc1.toString());
//
//		System.out.println("thông tin acoount");
//		System.out.println("Position:" + acc1.position.name + "group : " + acc1.groups[0].name);
		// Question 1:
		System.out.println("---------Question 1 Check acc2:---------");
		if (acc2.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban.");
		} else {
			System.out.println("Phòng ban của nv này là: " + acc2.department.name);
		}
//		Question 2:
//			Kiểm tra account thứ 2
//			Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//			Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên
//			này là Java Fresher, C# Fresher"
//			Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người
//			quan trọng, tham gia nhiều group"
//			Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
//			người hóng chuyện, tham gia tất cả các group"
		System.out.println("---------Question 2: Làm theo IF ---------");
		if (acc2.groups == null) {
			System.out.println("Nhân viên này chưa có group");
		} else {
			int countGroup = acc2.groups.length;
			if (countGroup == 1 || countGroup == 2) {
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			}

			if (countGroup == 3) {
				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			}
			if (countGroup >= 4) {
				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			}

		}
		System.out.println("---------Question 3: Sử dụng toán tử ternary để làm Question 1---------");
		System.out.println(acc2.department == null ? "Nhân viên này chưa có phòng ban."
				: "Phòng của nhân viên này là: " + acc2.department.name);
		System.out.println("---------Question 4: sử dụng Terry cho Position--------- ");
		System.out.println(
				acc1.position.name.toString() == "Dev" ? "Đây là Developer" : "Người này không phải là Developer");

//		Question 5:
//			Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
//			Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
//			Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//			Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
//			Còn lại in ra "Nhóm có nhiều thành viên"

		System.out.println("Question 5");
		group1.accounts = new Account[] { acc1, acc2, acc3 };
		if (group1.accounts == null) {
			System.out.println("Group chưa có thành viên nào tham gia");
		} else {
			int coungAccInGroup = group1.accounts.length;
			switch (coungAccInGroup) {
			case 1:
				System.out.println("Nhóm có một thành viên");
				break;
			case 2:
				System.out.println("Nhóm có hai thành viên");
				break;
			case 3:
				System.out.println("Nhóm có ba thành viên");
				break;

			default:
				System.out.println("Nhóm có nhiều thành viên");
				break;
			}
//			Question 6:
//				Sử dụng switch case để làm lại Question 

			System.out.println("Question 6");
			if (acc2.groups == null) {
				System.out.println("Group chưa có nhân viên");
			} else {
				switch (acc2.groups.length) {
				case 1:
					System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
					break;

				case 2:
					System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
					break;

				case 3:
					System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
					break;
				}
			}
		}
//		Question 7:
//			Sử dụng switch case để làm lại Question 4
		System.out.println("Question 7");
		String positionName = acc1.position.name.toString();
		switch (positionName) {
		case "Dev":
			System.out.println("đây là developer");
			break;
		default:
			System.out.println("đay không phải developer");
			break;
		}

//		Question 8:
//			In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
//			họ

		System.out.println("---------FOREACH Question 8:---------");
		Account[] accArray = { acc1, acc2, acc3 };
		for (Account account : accArray) {
			// System.out.println(account.toString()); ko chạy được do bị lỗi 2 chiều của
			// accout với group
			String info = String.format("AccountID: %d | Email: %s | Name: %s", account.id, account.email,
					account.fullName);
			System.out.println(info);
		}

//		Question 9:
//			In ra tất cả các group "Java"
		String[] groupNames = { "Java", "C#", "C++" };
		for (String groupName : groupNames) {
			if (groupName.equals("Java")) {
				System.out.println("GroupName:");
			}
		}

//		Question 10 (Optional):
//			Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
//			Nếu có xuất ra “OK” ngược lại “KO”.
//			Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.

		Scanner scanner = new Scanner(System.in);
		String line1, line2, Daonguoc = "";
		System.out.println("Nhập chuỗi 1");
		line1 = scanner.nextLine();

		System.out.println("Nhập chuỗi 2");
		line2 = scanner.nextLine();

		scanner.close();

		for (int i = line1.length() - 1; i >= 0; i--) {

			if (line2.equals(Daonguoc)) {
				System.out.println("Đây là chuỗi đảo ngược !");
			} else {
				System.out.println("Đây không phải chuỗi đảo ngược");
			}

		}
//		Question 11 (Optional): Count special Character
//		Tìm số lần xuất hiện ký tự "a" trong chuỗi
		String str;
		System.out.println("Mời bạn nhập vào một chuỗi: ");
		str = scanner.nextLine();
		scanner.close();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if ('a' == str.charAt(i)) {
				count++;
			}
			System.out.println(" số lần a xuất hiện: ");
		}

	}
}