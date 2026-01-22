package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.dao.DepartmentDao;
import com.vti.enity.Department;
import com.vti.ulitis.ScannerUtils;

public class DepartmentManagement {
	private DepartmentDao departmentDAO;

	// Hàm xử lý hiển thị danh sách phòng ban
	public DepartmentManagement() throws FileNotFoundException, IOException {
		departmentDAO = new DepartmentDao();
	}

	public void showListDepartment() throws ClassNotFoundException, SQLException {

		List<Department> listDepartments = departmentDAO.getListDepartment();
		System.out.println("+--------+--------------------------------------+");
		System.out.format("|%-8s|%-38s|%n", "ID", "Department Name");
		System.out.println("+--------+--------------------------------------+");
		for (Department department : listDepartments) {
			System.out.format("|%-8s|%-38s|%n", department.getId(), department.getName());

		}
		System.out.println("+--------+--------------------------------------+");
	}

//		Hàm hiển thị danh sách phòng ban theo id
	public void showDepartmentByID() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn tìm phòng ban theo ID");
		System.out.println("Mời bạn nhập id:");
		int idfind = ScannerUtils.inputInt();
		Department department = departmentDAO.getDepartmentByID(idfind);
		if (department != null) {
			System.out.println("+-----------+--------------------------------------+");
			System.out.format("|    %-7s|      %-32s|%n", "ID", "Department Name");
			System.out.println("+-----------+--------------------------------------+");
			System.out.format("|    %-7d|      %-32s|%n", department.getId(), department.getName());
			System.out.println("+-----------+--------------------------------------+");
		} else {
			System.out.println("Không có phòng ban cần tìm kiếm!!!");
		}
	}

//		Hàm Thêm mới phòng ban
	public void createNewDepartment() throws ClassNotFoundException, SQLException {
		System.out.println("thêm mới phòng ban theo yêu câu");
		System.out.println("Mời bạn thêm phòng ban:");
		String newdep = ScannerUtils.inputString();
		boolean department = departmentDAO.insertnewdep(newdep);
		if (department) {
			System.out.println("đã thêm thành công");
		} else {
			System.out.println("Kiểm tra lại");

		}
		List<Department> listDepartments = departmentDAO.getListDepartment();
		System.out.println("+--------+--------------------------------------+");
		System.out.format("|%-8s|%-38s|%n", "ID", "Department Name");
		System.out.println("+--------+--------------------------------------+");
		for (Department department1 : listDepartments) {
			System.out.format("|%-8s|%-38s|%n", department1.getId(), department1.getName());

		}
		System.out.println("+--------+--------------------------------------+");
	}

	public void DSPB() {
		// TODO Auto-generated method stub

	}
}
