package Front;

import java.util.Scanner;

import Backend.StaffManagement;
import enity.HighSchoolStudent;

public class Exercise_5 {
	public static void main(String[] args) {
		while (true) { // vòng lặp thực hiện liên tục
			// hiển thị menu
			System.out.println("======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");
			System.out.println("===              1. Thêm mới cán bộ.                               ===");
			System.out.println("===              2. Tìm kiếm theo họ tên.                          ===");
			System.out.println("===              3. Hiện thị thông tin về danh sách các cán bộ.    ===");
			System.out.println("===              4. Nhập vào tên của cán bộ và delete cán bộ đó    ===");
			System.out.println("===              5. Thoát khỏi chương trình.                       ===");
			System.out.println("======================================================================");

			// dưng chương trình cho nguywf dùng chọn
			Scanner scanner = new Scanner(System.in);
			StaffManagement staffm = new StaffManagement();
			int menu = scanner.nextInt();
			// cahy chương trình menu

			switch (menu) {
			case 1:
				staffm.addNewStaff();
//				System.out.println("===              1. Thêm mới cán bộ.                               ===");
				break;
			case 2:
				staffm.findByName();
//				System.out.println("===              2. Tìm kiếm theo họ tên.                          ===");
				break;
			case 3:
				staffm.showListStaff();
//				System.out.println("===              3. Hiện thị thông tin về danh sách các cán bộ.    ===");
				break;
			case 4:
				staffm.deleteStaffByName();
//				System.out.println("===              4. Nhập vào tên của cán bộ và delete cán bộ đó    ===");
				break;
			case 5:
				System.out.println("===              5. Thoát khỏi chương trình.                       ===");
				return; // dừng hàm mà nó đang chạy
			default:
				System.out.println("Nhập lại"); // nếu sai thì nó sẽ in nhập lại
				break;
			}
			
		}
	}
	
	public void question3() {
		HighSchoolStudent highSchoolStudent = new HighSchoolStudent("Nam", 1, "Chuyên Văn", "Đại học công nghệ");
		System.out.println(highSchoolStudent);
}
}