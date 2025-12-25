package Backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import enity.Article;
import enity.Book;
import enity.Document;
import enity.Magazine;

public class QLTV {
	private Scanner scanner;
	private ArrayList<Document> documentList;
	public static int id = 0;

	public QLTV() {
		super();
		scanner = new Scanner(System.in);
		documentList = new ArrayList<Document>();

	}

	// add doc
	public void addDoc() {
		System.out.println("Thêm mới tài liêu: Sách, tạp chí, báo.");
		System.out.println("1.Thêm mới tài liêu: Sách");
		System.out.println("2.Thêm mới tài liêu: tạp chí");
		System.out.println("3.Thêm mới tài liêu: báo.");

		int chose = scanner.nextInt();

		// điều kiện
		while (true) {
			switch (chose) {
			case 1:
				System.out.println("Sách");
				System.out.println("Nhập vào tên nhà xuất bản: ");
				String publisher = scanner.next();
				System.out.println("Nhập vào số bản phát hành: ");
				int numRelease = scanner.nextInt();
				System.out.println("Nhập vào tên tác giả: ");
				String authorName = scanner.next();
				System.out.println("Nhập vào số trang: ");
				int numPage = scanner.nextInt();
				id++;
				Book book = new Book(id, publisher, numRelease, authorName, numPage);
				documentList.add(book);

				break;
			case 2:
				System.out.println("Tạp chí");
				System.out.println("Nhập vào tên nhà xuất bản: ");
				String publisherArticle = scanner.next();
				System.out.println("Nhập vào số bản phát hành: ");
				int numReleaseArticle = scanner.nextInt();
				System.out.println("Nhập vào ngày phát hành: ");
				int day = scanner.nextInt();
				System.out.println("Nhập vào tháng phát hành: ");
				int month = scanner.nextInt();
				System.out.println("Nhập vào năm phát hành: ");
				int year = scanner.nextInt();
				LocalDate dayReleaseArticle = LocalDate.of(year, month, day);
				id++;
				Document artice = new Article(id, publisherArticle, numReleaseArticle, dayReleaseArticle);
				documentList.add(artice);
				break;

			case 3:
				System.out.println("Báo");
				System.out.println("Nhập vào tên nhà xuất bản: ");
				String publisherMagazine = scanner.next();
				System.out.println("Nhập vào số bản phát hành: ");
				int numReleaseMagazine = scanner.nextInt();
				System.out.println("Nhập vào số phát hành: ");
				int idReleaseMagazine = scanner.nextInt();
				System.out.println("Nhập vào ngày phát hành: ");
				int day1 = scanner.nextInt();
				System.out.println("Nhập vào tháng phát hành: ");
				int month1 = scanner.nextInt();
				System.out.println("Nhập vào năm phát hành: ");
				int year1 = scanner.nextInt();
				LocalDate monthReleaseMagazine = LocalDate.of(year1, month1, day1);
				id++;
				Document magazine = new Magazine(id, publisherMagazine, numReleaseMagazine, idReleaseMagazine,
						monthReleaseMagazine);
				documentList.add(magazine);
				return;

			default:
				System.out.println("Nhập lại"); // nếu sai thì nó sẽ in nhập lại
				return;
			}
		}
	}

	public void Del() {
		System.out.println("Nhập vào mã tài liệu muốn xóa: ");
		int idDel = scanner.nextInt();
		Boolean flagCheckExists = false;
		for (Document document : documentList) {
			if (document.getId() == idDel) {
				flagCheckExists = true;
			}
		}
		if (flagCheckExists) {
			Iterator<Document> iterator = documentList.iterator();
			while (iterator.hasNext()) {
				Document document = iterator.next();
				if (document.getId() == idDel) {
					iterator.remove();
				}
			}
			System.out.println("Xóa tài liệu thành công, danh sách tài liệu còn lại:");
			printListDocument();
		} else {
			System.out.println("Mã tài liệu bạn nhập không có trên hệ thống.");
		}

	}

	private void printListDocument() {
		for (Document document : documentList) {
			System.out.println(document);
		}

	}

	private void findByCategory() {
		System.out.println("Nhập vào loại tài liệu cần tìm kiếm 1.Sách, 2.Báo, 3.Tạp chí: ");
		int chooseCategory = scanner.nextInt();
		switch (chooseCategory) {
		case 1:
			for (Document document : documentList) {
				if (document instanceof Book) {
					System.out.println(document);
				}
			}
			break;
		case 2:
			for (Document document : documentList) {
				if (document instanceof Article) { // bằng == nma dùng cho line
					System.out.println(document);
				}
			}
			break;
		case 3:
			for (Document document : documentList) {
				if (document instanceof Magazine) {
					System.out.println(document);
				}
			}
			break;
		default:
			System.out.println("Nhập không đúng.!!");
			break;
		}
	}

	private void printListDocument1() {
		for (Document document : documentList) {
			System.out.println(document);
		}

	}

}
