package backend;

import java.util.Scanner;

import entity.Ex1Manager;

public class Exercise1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Ex1Manager manager = new Ex1Manager();

		while (true) {
			System.out.println("=======================================================================");
			System.out.println("================= Lựa chọn chức năng bạn muốn sử dụng ==================");
			System.out.println("===              1. Insert news.                                    ===");
			System.out.println("===              2. View list news.                                 ===");
			System.out.println("===              3. Average rate.                                   ===");
			System.out.println("===              4. Exit.                                           ===");
			System.out.println("=======================================================================");
			System.out.print("Chọn chức năng: ");

			int menuChoose = sc.nextInt();

			switch (menuChoose) {
			case 1:
				manager.insert();
				break;

			case 2:
				manager.View();
				break;

			case 3:
				manager.Average();
				break;

			case 4:
				System.out.println("Thoát khỏi chương trình.");
				return;

			default:
				System.out.println("Chọn sai, vui lòng nhập lại!");
			}
		}
	}
}
