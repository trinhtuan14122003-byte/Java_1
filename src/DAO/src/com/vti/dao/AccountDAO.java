package com.vti.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vti.enity.Account;
import com.vti.enity.Department;
import com.vti.enity.Position;
import com.vti.ulitis.JdbcUtils;

public class AccountDAO {
	private JdbcUtils jdbcUtils;

	public AccountDAO() throws Exception {
		jdbcUtils = new JdbcUtils();
	}

	public List<Account> getlistAccounts()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sqlaccount = "select * from account;";
		ResultSet resultSet = jdbcUtils.executeQuery(sqlaccount);
		List<Account> listAccounts = new ArrayList<Account>();
		while (resultSet.next()) {
			Account acc = new Account();
			acc.setId(resultSet.getInt(1));
			acc.setEmail(resultSet.getString(2));
			acc.setUsername(resultSet.getString(3));
			acc.setFullName(resultSet.getString(4));

			DepartmentDao depDao = new DepartmentDao();
			Department dep = depDao.getDepartmentByID(resultSet.getInt(5));
			acc.setDepartment(dep);

			PositionDao posDao = new PositionDao();
			Position pos = posDao.getPosByID(resultSet.getInt(6));
			acc.setPosition(pos);

			Date date = resultSet.getDate(7);
			if (date != null) {
				acc.setCreateDate(date.toLocalDate());
			} else {
				acc.setCreateDate(null);
			}
			listAccounts.add(acc);

		}
		return listAccounts;
	}

	public Account getid(int idfind) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sqlgetid = "select * from account where accountid = ?;";
		PreparedStatement preparedStatement = jdbcUtils.createPrepareStatement(sqlgetid);
		preparedStatement.setInt(1, idfind);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Account account = new Account();
			account.setId(resultSet.getInt(1));
			account.setEmail(resultSet.getString(2));
			account.setUsername(resultSet.getString(3));
			account.setFullName(resultSet.getString(4));

			DepartmentDao depDao = new DepartmentDao();
			Department dep = depDao.getDepartmentByID(resultSet.getInt(5));
			account.setDepartment(dep);

			PositionDao posDao = new PositionDao();
			Position pos = posDao.getPosByID(resultSet.getInt(6));
			account.setPosition(pos);

			LocalDate lcd = resultSet.getDate(7).toLocalDate();
			account.setCreateDate(lcd);

			return account;
		}
		return null;
	}

	public Account getbyname(String namefind)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sqlgetbyname = "select * from account where Username  = ?;";
		PreparedStatement preparedStatement = jdbcUtils.createPrepareStatement(sqlgetbyname);
		preparedStatement.setString(1, namefind);
		ResultSet resultSet2 = preparedStatement.executeQuery();
		if (resultSet2.next()) {
			Account account2 = new Account();
			account2.setId(resultSet2.getInt(1));
			account2.setEmail(resultSet2.getString(2));
			account2.setUsername(resultSet2.getString(3));
			account2.setFullName(resultSet2.getString(4));

			DepartmentDao depDao = new DepartmentDao();
			Department dep = depDao.getDepartmentByID(resultSet2.getInt(5));
			account2.setDepartment(dep);

			PositionDao posDao = new PositionDao();
			Position pos = posDao.getPosByID(resultSet2.getInt(6));
			account2.setPosition(pos);

			LocalDate lcd = resultSet2.getDate(7).toLocalDate();
			account2.setCreateDate(lcd);

			return account2;
		} else {
			return null;
		}
	}

	public boolean creatnew(Account acc, int depid, int posid) throws ClassNotFoundException, SQLException {
		String sqlinsert = "INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) VALUES (?, ?, ?,?,?,now());";
		PreparedStatement preparedStatement = jdbcUtils.createPrepareStatement(sqlinsert);
		preparedStatement.setNString(1, acc.getEmail());
		preparedStatement.setNString(2, acc.getUsername());
		preparedStatement.setNString(3, acc.getFullName());
		preparedStatement.setInt(4, depid);
		preparedStatement.setInt(5, posid);

		int result3 = preparedStatement.executeUpdate();
		if (result3 == 1) {

			return true;
		} else {
			return false;
		}
	}

	public boolean updateByEmai(int id, String newEmail) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE account SET Email = ? WHERE (AccountID = ?);";
		PreparedStatement preStatement = jdbcUtils.createPrepareStatement(sql);
		preStatement.setString(1, newEmail);
		preStatement.setInt(2, id);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbcUtils.disConnection();
			return true;
		} else {
			jdbcUtils.disConnection();
			return false;
		}
	}

	public boolean updateByUsername(int id, String newUsername) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE account SET Username = ? WHERE (AccountID = ?);";
		PreparedStatement preStatement = jdbcUtils.createPrepareStatement(sql);
		preStatement.setString(1, newUsername);
		preStatement.setInt(2, id);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbcUtils.disConnection();
			return true;
		} else {
			jdbcUtils.disConnection();
			return false;
		}

	}

	public boolean updateByFullname(int id, String newFullName) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE account SET FullName = ? WHERE (AccountID = ?);";
		PreparedStatement preStatement = jdbcUtils.createPrepareStatement(sql);
		preStatement.setString(1, newFullName);
		preStatement.setInt(2, id);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbcUtils.disConnection();
			return true;
		} else {
			jdbcUtils.disConnection();
			return false;
		}

	}

	public boolean updateByPosition(int id, int newPosId) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE account SET PositionID = ? WHERE (AccountID = ?);";
		PreparedStatement preStatement = jdbcUtils.createPrepareStatement(sql);
		preStatement.setInt(1, newPosId);
		preStatement.setInt(2, id);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbcUtils.disConnection();
			return true;
		} else {
			jdbcUtils.disConnection();
			return false;
		}

	}

	public boolean updateByDepartment(int id, int newDepId) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE account SET DepartmentID = ? WHERE (AccountID = ?);";
		PreparedStatement preStatement = jdbcUtils.createPrepareStatement(sql);
		preStatement.setInt(1, newDepId);
		preStatement.setInt(2, id);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbcUtils.disConnection();
			return true;
		} else {
			jdbcUtils.disConnection();
			return false;
		}

	}

}