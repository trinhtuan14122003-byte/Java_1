package entity;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex1Manager {

	private ArrayList<News> newslist;
	private Scanner scanner;
	private String title;
	private String publishDate;
	private String author;

	public Ex1Manager() {
		newslist = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	public void insert() {
		String title = "";
		String publishDate = "";
		String author = "";
		String content = "";

		int rate1 = 0, rate2 = 0, rate3 = 0;

		while (true) {
			System.out.println("===== INSERT NEWS =====");
			System.out.println("1. Nhập Title");
			System.out.println("2. Nhập PublishDate");
			System.out.println("3. Nhập Author");
			System.out.println("4. Nhập Content");
			System.out.println("5. Nhập Rate & Lưu");
			System.out.println("6. Thoát");
			System.out.print("Chọn: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // xóa bộ nhớ đệm

			switch (choice) {
			case 1:
				System.out.print("Nhập Title: ");
				title = scanner.nextLine();
				break;

			case 2:
				System.out.print("Nhập PublishDate: ");
				publishDate = scanner.nextLine();
				break;

			case 3:
				System.out.print("Nhập Author: ");
				author = scanner.nextLine();
				break;

			case 4:
				System.out.print("Nhập Content: ");
				content = scanner.nextLine();
				break;

			case 5:
				System.out.print("Nhập rate 1: ");
				rate1 = scanner.nextInt();
				System.out.print("Nhập rate 2: ");
				rate2 = scanner.nextInt();
				System.out.print("Nhập rate 3: ");
				rate3 = scanner.nextInt();
				scanner.nextLine();

				int[] rates = { rate1, rate2, rate3 };
				News news = new News(title, publishDate, author, content, rates);
				newslist.add(news);

				System.out.println("✔ Thêm News thành công");
				return; // thoát insert

			case 6:
				System.out.println("Thoát nhập");
				return;

			default:
				System.out.println("Chọn sai!");
			}
		}
	}

	public void View() {
		for (News news : newslist) {
			news.display();
		}
	}

	public void Average() {
		System.out.println("Đánh giá trung bình Rate");
		for (News news1 : newslist) {

			System.out.println("Title: " + news1.getTitle() + " RateAVG: " + news1.calculate());
		}

	}
}
