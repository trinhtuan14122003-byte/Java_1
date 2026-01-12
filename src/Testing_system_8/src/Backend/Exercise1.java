package Backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import entity.Student;

public class Exercise1 {
	private ArrayList<Student> listStudent;
	private int chose;

	public Exercise1() {
		listStudent = new ArrayList<Student>();
		System.out.println("sinh viên ");
		listStudent.add(new Student("hiếu"));
		listStudent.add(new Student("Lan"));
		listStudent.add(new Student("Nam"));
		listStudent.add(new Student("hiếu"));
		listStudent.add(new Student("Hùng"));

		System.out.println(listStudent);
		System.out.println("-------------");
	}

	public void question1() {
		Scanner sca = new Scanner(System.in);

		while (true) {
			System.out.println("Mời bạn chọn câu hỏi số:");
			System.out.println("\n===== MENU =====");
			System.out.println("1. In ra tổng số student");
			System.out.println("2. Lấy phần tử thứ 4");
			System.out.println("3. In phần tử đầu và cuối");
			System.out.println("4. Thêm student vào đầu");
			System.out.println("5. Thêm student vào cuối");
			System.out.println("6. Đảo ngược danh sách");
			System.out.println("7. Tìm student theo id");
			System.out.println("8. Tìm student theo name");
			System.out.println("9. In student trùng tên");
			System.out.println("10. Xóa name student có id = 2");
			System.out.println("11. Xóa student có id = 5");
			System.out.println("12. Tạo studentCopies và đổi name thành số thứ tự");
			System.out.println("0. Thoát");
			System.out.print("Chọn: ");
			chose = sca.nextInt();

			switch (chose) {
			case 1:
				System.out.println("Tổng số các sinh viên là: " + listStudent.size());
				return;
			case 2:
				System.out.println("Phần tử thứ 4 là : " + listStudent.get(3));
				return;

			case 3:
				System.out.println("Phần tử đầu là : " + listStudent.get(0));
				System.out.println("Phần tử cuối là : " + listStudent.get(listStudent.size() - 1));
				return;
			case 4:
				while (true) {
					System.out.println("\n--- THÊM STUDENT VÀO ĐẦU ---");
					System.out.println("1. Thêm student");
					System.out.println("0. Quay lại MENU");
					System.out.print("Chọn: ");
					int sub = sca.nextInt();
					sca.nextLine();
					if (sub == 0) {
						break; // quay về menu chính
					}

					System.out.print("Nhập tên student: ");
					String name = sca.nextLine();

					listStudent.add(0, new Student(name));

					System.out.println("Đã thêm thành công!");
					System.out.println("Danh sách hiện tại:");
					for (Student s : listStudent) {
						System.out.println(s);
					}
				}
				break;
			case 5:
				while (true) {
					System.out.println("\n--- THÊM STUDENT VÀO cuối ---");
					System.out.println("1. Thêm student");
					System.out.println("0. Quay lại MENU");
					System.out.print("Chọn: ");
					int sub = sca.nextInt();
					sca.nextLine();
					if (sub == 1) {
						System.out.println("Tên học sinh:");
						String name1 = sca.next();
						sca.nextLine();
						listStudent.add(new Student(name1));

						System.out.println("Đã thêm sinh viên vào đầu danh sách!");
						System.out.println("Danh sách hiện tại:");
						for (Student list : listStudent) {
							System.out.println(list);
						}
					}
				}

			case 6:
				System.out.println(" Đảo ngược vị trí của students");
				System.out.println("Danh sách trước khi đảo");
				for (Student list : listStudent) {
					System.out.println(list);
				}
				System.out.println("danh scah sau khi đảo ");
				Collections.reverse(listStudent); // hàm đảo danh sach
				for (Student list : listStudent) {
					System.out.println(list);
				}
				break;
			case 7:
				System.out.println("Nhập id cần tìm:");
				int id7 = sca.nextInt();
//				Student student = new Student();// sẽ hiều là biến mới
				for (Student student : listStudent) {
					if (student.getId() == id7) {
						System.out.println(student);
					}
					break;
				}
			case 8:
				System.out.println("Nhập vào name cần tìm kiếm:");
				String name8 = sca.next();
				for (Student student : listStudent) {
					if (student.getName().equals(name8)) {
						System.out.println(student);
					}
				}
				break;

			}
		}
	}
}
