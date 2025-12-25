package Front;

import java.util.Scanner;

import Backend.QLTV;

public class Exercise5_Ques4 {
	public static void main(String[] args) {
		while (true) {
			// hiển thị menu
			System.out.println("======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");
			System.out.println("   1. Thêm mới tài liêu: Sách, tạp chí, báo.                              ===");
			System.out.println("===              2. Xoá tài liệu theo mã tài liệu.                         ===");
			System.out.println("===              3. Hiện thị thông tin về tài liệu.    ===");
			System.out.println("===              4. Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.   ===");
			System.out.println("===              5. Thoát khỏi chương trình.                       ===");
			System.out.println("======================================================================");

			// chạy chưog trình cho người dùng chọn
			Scanner scanner = new Scanner(System.in);
			int menu = scanner.nextInt();
			QLTV qltv = new QLTV();
			// chạy chương trình lặp
			switch (menu) {
			case 1:
				qltv.addDoc();// System.out.println("=== 1. Thêm mới cán bộ. ===");
				break;
			case 2:
				qltv.Del();// System.out.println("=== 2. Tìm kiếm theo họ tên. ===");
				break;
			case 3:
				qltv.printListDocument();// System.out.println("=== 3. Hiện thị thông tin về danh sách các cán bộ.
											// ===");
				break;
			case 4:
				qltv.findByCategory();// System.out.println("=== 4. Nhập vào tên của cán bộ và delete cán bộ đó ===");
				break;
			case 5:
				System.out.println("===              5. Thoát khỏi chương trình.                       ===");
				return;

			default:
				System.out.println("Alarm: Lựa chọn đúng số trên menu");
				break;

			}
		}
	}
}
