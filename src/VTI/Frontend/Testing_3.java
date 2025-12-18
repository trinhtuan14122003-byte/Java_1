package VTI.Frontend;

import java.time.LocalDate;
import java.util.Scanner;

import VTI.entity.Account;

public class Testing_3 {
	public static void main(String[] args) {
//	Khai báo 2 số lương có kiểu dữ liệu là float.
//	Khởi tạo Lương của Account 1 là 5240.5 $
//	Khởi tạo Lương của Account 2 là 10970.055$
//	Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
//	Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra

		float Lương_acc1 = 5240.5f;
		float Lương_acc2 = 10970.055f;

		int Account1_i = (int) Lương_acc1;
		int Account2_i = (int) Lương_acc2;

		System.out.printf("Lương của Account 1: %d\n", Account1_i);
		System.out.printf("Lương của Account 2: %d\n", Account2_i);

//		
//		Question 2:
//			Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm
//			có số 0 ở đầu cho đủ 5 chữ số)
//		int min = 0;
//		int max = 99999;
//		int a = (int) (Math.random() * max) + min; //  Math.random() → số double từ 0.0 đến < 1.0	
//		while (a < 10000) {
//			a = a * 10;
//		}
		System.out.println("Question 2 : Số ngẫu nhiên");
		int a = (int) (Math.random() * 10000);
		String result = String.format("%05d", a);
		System.out.println("Số ngẫu nhiên: " + result);

//		
//		Question 3:
//			Lấy 2 số cuối của số ở Question 2 và in ra.
//			Gợi ý:
//			Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
//			Cách 2: chia lấy dư số đó cho 100
		System.out.println("Question 3: Hai số cuối");
		String b = String.valueOf(result);
		System.out.println("2 só cuối của Quétion 2: " + b.substring(3));

//		Question 4:
//			Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng

		int c, d;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập c = ");
		c = scanner.nextInt();
		do {
			System.out.println("Nhập d = ");
			d = scanner.nextInt();
			if (d == 0) {
				System.out.println("Vui lòng nhập b khác 0 !");
			}
		} while (c == 0);

		scanner.close();

		System.out.println("Thương: " + (float) c / (float) d);

//		Exercise 2 (Optional): Default value
//		Question 1:
//		Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi
//		tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):

		System.out.println("Khởi tạo mảng Account gồm 5 phần tử sử dụng For");
		Account[] accArray = new Account[5];
		for (int i = 0; i < accArray.length; i++) {
			Account acc = new Account();
			acc.email = "Email " + i;
			acc.userName = "User name " + i;
			acc.fullName = "Full name " + i;
			acc.createDate = LocalDate.now();
			accArray[i] = acc;
			System.out.println(
					"Thông tin Account " + i + " Email: " + accArray[i].email + " UserName: " + accArray[i].userName
							+ " FullName: " + accArray[i].fullName + " CreateDate: " + accArray[i].createDate);
		}
//		Exercise 3(Optional): Boxing & Unboxing
//		Question 1:
//		Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//		Sau đó convert lương ra float và hiển thị lương lên màn hình (với số
//		float có 2 số sau dấu thập phân)

	}

}
