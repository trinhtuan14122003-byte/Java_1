package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.dao.AccountDAO;
import com.vti.dao.DepartmentDao;
import com.vti.dao.PositionDao;
import com.vti.enity.Account;
import com.vti.enity.Department;
import com.vti.enity.Position;
import com.vti.ulitis.ScannerUtils;

public class AccountManagement {
	private AccountDAO accountDAO;

	public AccountManagement() throws Exception {
		accountDAO = new AccountDAO();
	}

	public void DSPB() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		List<Account> listAccounts = accountDAO.getlistAccounts();

		System.out.println(
				"+----+----------------------+------------+----------------+--------------+-------------+---------------------+");
		System.out.format("|%-4s|%-22s|%-12s|%-16s|%-14s|%-13s|%-21s|%n", "ID", "Email", "Username", "Fullname",
				"Department ID", "Position ID", "Create Date");
		System.out.println(
				"+----+----------------------+------------+----------------+--------------+-------------+---------------------+");

		for (Account a : listAccounts) {
			System.out.format("|%-4d|%-22s|%-12s|%-16s|%-14d|%-13d|%-21s|%n", a.getId(), a.getEmail(), a.getUsername(),
					a.getFullName(), a.getDepartment().getId(), a.getPosition().getId(), a.getCreateDate());
		}

		System.out.println(
				"+----+----------------------+------------+----------------+--------------+-------------+---------------------+");
	}

	public void getbyid() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("mời bạn nhập id:");
		int idfind = ScannerUtils.inputInt();
		Account account = accountDAO.getid(idfind);
		if (account != null) {
			System.out.println(
					"+----+----------------------+------------+----------------+--------------+-------------+---------------------+");
			System.out.format("|%-4s|%-22s|%-12s|%-16s|%-14s|%-13s|%-21s|%n", "ID", "Email", "Username", "Fullname",
					"Department ID", "Position ID", "Create Date");
			System.out.println(
					"+----+----------------------+------------+----------------+--------------+-------------+---------------------+");
			System.out.format("|%-4d|%-22s|%-12s|%-16s|%-14d|%-13ds|%n", account.getId(), account.getEmail(),
					account.getUsername(), account.getFullName(), account.getDepartment().getId(),
					account.getPosition().getId(), account.getCreateDate());
			System.out.println(
					"+----+----------------------+------------+----------------+--------------+-------------+---------------------+");

		} else {
			System.out.println("Không tồn tại phòng này trên HT");
		}
	}

	public void checkname() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Mời bạn nhập tên người cần tìm");
		String namefind = ScannerUtils.inputString();
		Account account = accountDAO.getbyname(namefind);
		if (account != null) {
			System.out.println(
					"+----+----------------------+------------+----------------+--------------+-------------+---------------------+");
			System.out.format("|%-4s|%-22s|%-12s|%-16s|%-14s|%-13s|%-21s|%n", "ID", "Email", "Username", "Fullname",
					"Department ID", "Position ID", "Create Date");
			System.out.println(
					"+----+----------------------+------------+----------------+--------------+-------------+---------------------+");
			System.out.format("|%-4d|%-22s|%-12s|%-16s|%-14d|%-13ds|%n", account.getId(), account.getEmail(),
					account.getUsername(), account.getFullName(), account.getDepartment().getId(),
					account.getPosition().getId(), account.getCreateDate());
			System.out.println(
					"+----+----------------------+------------+----------------+--------------+-------------+---------------------+");
		} else {
			System.out.println("Không có kết quả nào");
		}
	}

	public void createnewaccount() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		DepartmentDao depdao = new DepartmentDao();

		Account acc = new Account();
		System.out.println("Nhập vào Email: ");
		acc.setEmail(ScannerUtils.inputString());
		System.out.println("Nhập vào UserName: ");
		acc.setUsername(ScannerUtils.inputString());
		System.out.println("Nhập vào FullName: : ");
		acc.setFullName(ScannerUtils.inputString());
		System.out.println("Hãy chọn phòng nhân viên: ");
		int depid = getDep();
		System.out.println("Hãy chọn Position nhân viên: ");
		int posid = getPos();

		boolean accdao = accountDAO.creatnew(acc, depid, posid);
		if (accdao) {
			System.out.println("Tạo thành công: ");
			DSPB();
		} else {
			System.out.println("Tạo không thành công, hãy kiểm tra lại");
		}
	}

	private int getPos() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		while (true) {
			PositionDao podao = new PositionDao();
			List<Position> listposi = podao.getListPosition();

			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Position Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Position position : listposi) {
				System.out.format(leftAlignFormat, position.getId(), position.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn Position theo ID:");
			int choosePos = ScannerUtils.inputIntPositive();
			if (podao.getPosByID(choosePos) != null) {
				return choosePos;
			} else {
				System.out.println("Không có Position này, hãy chọn lại: ");
			}
		}
	}

	private int getDep() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			DepartmentDao depdao = new DepartmentDao();
			List<Department> listdepDaos = depdao.getListDepartment();
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Depament Name         |%n");
			System.out.format("+--------+-----------------------+%n");
			for (Department department : listdepDaos) {
				System.out.format(leftAlignFormat, department.getId(), department.getName());
			}
			System.out.format("+--------+-----------------------+%n");
			System.out.println("Chọn phòng theo ID:");
			int chooseDep = ScannerUtils.inputIntPositive();
			if (depdao.getDepartmentByID(chooseDep) != null) {
				return chooseDep;
			} else {
				System.out.println("Không có phòng này, hãy chọn lại: ");

			}
		}
	}

	public int update() throws Exception {
		while (true) {
			AccountDAO accDAO = new AccountDAO();
			System.out.println("Bạn muốn update trường nào??");
			System.out.println("1.Email, 2.UserName, 3.FullName, 4.Department, 5.Position, 6.Exit ");
			int i = ScannerUtils.inputIntPositive();
			while (true) {
				switch (i) {
				case 1:
					System.out.println("Nhập vào ID của account cần update: ");
					int id = ScannerUtils.inputIntPositive();

					System.out.println("Nhập vào New Email: ");
					String newEmail = ScannerUtils.inputString();
					boolean updatedEmail = accDAO.updateByEmai(id, newEmail);
					if (updatedEmail) {
						System.out.println("Cập nhật Email thành công!");
						DSPB();
					} else {
						System.out.println("Cập nhật Email thất bại!");
					}
					break;

				case 2:
					System.out.println("Nhập vào ID của account cần update: ");
					id = ScannerUtils.inputIntPositive();

					System.out.println("Nhập vào New Username: ");
					String newUsername = ScannerUtils.inputString();

					boolean updatedUsername = accDAO.updateByUsername(id, newUsername);
					if (updatedUsername) {
						System.out.println("Cập nhật Username thành công!");
					} else {
						System.out.println("Cập nhật Username thất bại!");
					}
					break;

				case 3:
					System.out.println("Nhập vào ID của account cần update: ");
					id = ScannerUtils.inputIntPositive();

					System.out.println("Nhập vào New FullName: ");
					String newFullName = ScannerUtils.inputString();

					boolean updatedFullname = accDAO.updateByFullname(id, newFullName);
					if (updatedFullname) {
						System.out.println("Cập nhật FullName thành công!");
					} else {
						System.out.println("Cập nhật FullName thất bại!");
					}
					break;
				case 4:
					System.out.println("Nhập vào ID của account cần update: ");
					id = ScannerUtils.inputIntPositive();

					System.out.println("Nhập vào DepartmentID mới: ");
					int newDepId = ScannerUtils.inputIntPositive();

					boolean updatedDep = accDAO.updateByDepartment(id, newDepId);
					if (updatedDep) {
						System.out.println("Cập nhật Department thành công!");
					} else {
						System.out.println("Cập nhật Department thất bại!");
					}
					break;

				case 5:
					System.out.println("Nhập vào ID của account cần update: ");
					id = ScannerUtils.inputIntPositive();

					System.out.println("Nhập vào PositionID mới: ");
					int newPosId = ScannerUtils.inputIntPositive();

					boolean updatedPos = accDAO.updateByPosition(id, newPosId);
					if (updatedPos) {
						System.out.println("Cập nhật Position thành công!");
					} else {
						System.out.println("Cập nhật Position thất bại!");
					}
					break;
				case 6:
					System.out.println("Thoát menu update.");
					return i; // hoặc break while
				default:
					System.out.println("Lựa chọn không hợp lệ, mời chọn lại!");
				}
			}
		}
	}
}
