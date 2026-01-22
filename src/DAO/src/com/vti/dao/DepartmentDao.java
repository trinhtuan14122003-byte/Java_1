package com.vti.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.enity.Department;
import com.vti.ulitis.JdbcUtils;

public class DepartmentDao {
	private JdbcUtils jdbcUtils;
	public Department getDepartmentByID;

	public DepartmentDao() throws FileNotFoundException, IOException {
		jdbcUtils = new JdbcUtils();
	}

	public List<Department> getListDepartment() throws ClassNotFoundException, SQLException {
//			Tạo kết nối tới DB Server
		String sql_SelectDepartment = "SELECT * FROM Department ORDER BY DepartmentID;";
//			Chạy lệnh SQL 
		ResultSet resultSet = jdbcUtils.executeQuery(sql_SelectDepartment);

		List<Department> listdeDepartments = new ArrayList<Department>();
		while (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt(1));
			department.setName(resultSet.getString(2));

			listdeDepartments.add(department);
		}
		return listdeDepartments;

	}

	public Department getDepartmentByID(int idfind) throws ClassNotFoundException, SQLException {
		String sql_SelectDepartmentbyID = "SELECT * FROM department WHERE DepartmentID=?;";
		PreparedStatement preparedStatement = jdbcUtils.createPrepareStatement(sql_SelectDepartmentbyID);
		preparedStatement.setInt(1, idfind);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt(1));
			department.setName(resultSet.getString(2));

			return department;
		}

		return null;
	}

	public boolean insertnewdep(String newdep) throws ClassNotFoundException, SQLException {
		String sqlinsert = "insert into department(departmentname) value (?);";
		PreparedStatement preinsert = jdbcUtils.createPrepareStatement(sqlinsert);
		preinsert.setString(1, newdep);
		int resultinsert = preinsert.executeUpdate();

		if (resultinsert == 1) {
			return true;
		}
		return false;
	}
}
