package Backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import enity.Employee;
import enity.Engineer;
import enity.Staff;
import enity.Staff.Gender;
import enity.Worker;

public class StaffManagement {

	private Scanner scanner; // xem lại đoạn natf
	private ArrayList<Staff> staffArrayList;

	public StaffManagement() {
		super();
		scanner = new Scanner(System.in);
		staffArrayList = new ArrayList<Staff>();
	}

	// Thêm mới cán bộ
	public void addNewStaff() {
		System.out.println("Thêm mới cán bộ");
		System.out.println("1. Thêm Engineer");
		System.out.println("2. Thêm Worker");
		System.out.println("3. Thêm Employee");

		Gender genderEngineer = null;
		Gender genderWorker = null;
		Gender genderEmployee = null;

		int choose = scanner.nextInt();
		int genderchoose = scanner.nextInt();
		switch (choose) {
		case 1:
//			Lấy thông tin của đối tương Engineer
			System.out.println("Thêm mới Engineer");
			System.out.println("Nhập vào tên:");
			String nameEngineer = scanner.next();

			System.out.println("Nhập vào tuổi Engineer: ");
			int ageEngineer = scanner.nextInt();

			System.out.println("Lựa chọn giới tính: 1.MALE, 2.FEMALE, 3.UNKNOWN");
//			int genderchoose1 = scanner.nextInt();

			switch (genderchoose) {
			case 1:
				genderEngineer = Gender.MALE;
				break;
			case 2:
				genderEngineer = Gender.FEMALE;
				break;
			case 3:
				genderEngineer = Gender.UNKNOWN;
				break;
			}

			System.out.println("Nhập vào địa chỉ Engineer: ");
			String addressEngineer = scanner.next();

			System.out.println("Nhập vào chuyên ngành Engineer: ");
			String specializedEngineer = scanner.next();

//			Tạo ra đối tượng Engineer
//			Engineer engineer = new Engineer();
//			engineer.setName(nameEngineer);
//			engineer.setAge(ageEngineer);
//			engineer.setGender(genderEngineer);
//			engineer.setAddress(addressEngineer);
//			engineer.setSpecialized(specializedEngineer);
			Engineer engineer = new Engineer(nameEngineer, ageEngineer, genderEngineer, addressEngineer,
					specializedEngineer);

//			Lưu trữ 1 mảng để quản lý	
//			String[] nameRailway98 = { "Thủy", "Tiến", "Sơn", "Mạnh" };
//			mảng tĩnh==> Số phần tử trong mảng cố định

			staffArrayList.add(engineer);
			break;

		// worker
		case 2:
			System.out.println("Thêm mới Worker");
			System.out.println("Nhập vào tên:");
			String nameWorker = scanner.next();

			System.out.println("Nhập vào tuổi Worker: ");
			int ageWorker = scanner.nextInt();

			switch (genderchoose) {
			case 1:
				genderWorker = Gender.MALE;
				break;
			case 2:
				genderWorker = Gender.FEMALE;
				break;
			case 3:
				genderWorker = Gender.UNKNOWN;
				break;
			}

			System.out.println("Nhập vào địa chỉ Worker: ");
			String addressWorker = scanner.next();

			System.out.println("Nhập vào chuyên ngành Worker: ");
			int rankWorker = scanner.nextInt();
			Worker worker = new Worker(nameWorker, ageWorker, genderWorker, addressWorker, rankWorker);
			staffArrayList.add(worker);

//			
			break;

		// Employee
		case 3:
			System.out.println("Thêm mới Employee");
//						System.out.println("Thêm mới Worker");
			System.out.println("Nhập vào tên:");
			String nameEmployee = scanner.next();

			System.out.println("Nhập vào tuổi Worker: ");
			int ageEmployee = scanner.nextInt();

			switch (genderchoose) {
			case 1:
				genderEmployee = Gender.MALE;
				break;
			case 2:
				genderEmployee = Gender.FEMALE;
				break;
			case 3:
				genderEmployee = Gender.UNKNOWN;
				break;
			}

			System.out.println("Nhập vào địa chỉ Worker: ");
			String addressEmployee = scanner.next();

			System.out.println("Nhập vào chuyên ngành Worker: ");
			String taskEmployee = scanner.nextLine();
			Employee employee = new Employee(nameEmployee, ageEmployee, genderEmployee, addressEmployee, taskEmployee);
			staffArrayList.add(employee);
			break;

		}
	}

//	Tìm kiếm theo họ tên
	public void findByName() {
		System.out.println("Tìm kiếm theo họ tên");
		String Findname = scanner.next();
		for (Staff staff : staffArrayList) {
			if (staff.getName().equals(Findname)) {
				System.out.println(staff.toString());
			}
		}
	}

//	Hiển thị danh sách cán bộ
	public void showListStaff() {
		System.out.println("Hiển thị thông tin danh sách cán bộ đang có trên hệ thống");
		for (Staff staff : staffArrayList) {
			System.out.println(staff.toString());
		}
	}

//	Xóa cán bộ theo họ tên
	public void deleteStaffByName() {
		System.out.println("Nhập tên cần xóa");
		String Delname = scanner.next();
		boolean found = false;

		Iterator<Staff> iterator = staffArrayList.iterator();
		while (iterator.hasNext()) {
			Staff staff = iterator.next(); // (Staff) là ép keieur
			if (staff.getName().equals(Delname)) {
				iterator.remove();
				found = true;
				if (found) {
					System.out.println("Đã xóa");
				} else {
					System.out.println("Không tìm thấy cán bộ");
				}
			}
		}
	}
}