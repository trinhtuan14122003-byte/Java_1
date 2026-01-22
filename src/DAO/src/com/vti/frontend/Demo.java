package com.vti.frontend;

import com.vti.backend.AccountManagement;
import com.vti.ulitis.ScannerUtils;

public class Demo {
	public static void main(String[] args) throws Exception {
		AccountManagement accountManagement = new AccountManagement();
		while (true) {
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("1. Question 1: Read data – get list account%n");
			System.out.format("2. Question 2: Read data – get account by id = 5%n");

			System.out.format("3. Question 4: Check data exists – check account name exists%n");
			System.out.format("4. Question 5: Create data – create account%n");
			System.out.format("5. Question 6: Update data – update account%n");
			System.out.format("6. Question 7: Delete by ID%n");
			System.out.format("7. Question 8: Exit%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			int choose = ScannerUtils.inputInt();
			switch (choose) {
			case 1:
				// 1. Xem danh sách phòng ban
				accountManagement.DSPB();
				break;
			case 2:
				//
				accountManagement.getbyid();
			case 3:
				// Kiểm tra tên account đã có trên hệ thông?1
				accountManagement.checkname();
			case 4:
				// thêm mới
				accountManagement.createnewaccount();
			case 5:
				// update
				accountManagement.update();
			}
		}
	}
}