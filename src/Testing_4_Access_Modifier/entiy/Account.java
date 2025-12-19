package Testing_4_Access_Modifier.entiy;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Account {
	public int id;
	public String email;
	public String userName;
	public String fullName;
	public Department department; // do cái này da khái bai beb
	public Position position;
	public LocalDate createDate;
	public Group[] groups; // lưu rty nhiều dữ liểu danh cho trường hơp account có thể tham gia nhiều gr

//	@Override
//	public String toString() {
//		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName
//				+ ", department=" + department + ", position=" + position + ", createDate=" + createDate + ", groups="
//				+ Arrays.toString(groups) + "]";
//	}

	// a) Không có parameters
	public Account(String usernames) {
	}

	// b) Có các parameter là id, Email, Username, FirstName,
	// LastName (với FullName = FirstName + LastName)

	public Account(int id, String email, String userName) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
	}

	public void Showinfo_2() {
		System.out.println("Id: " + this.id + " | Email: " + this.email + " | Username: " + this.userName
				+ " | FullName: " + this.fullName);
	}

	// c) Có các parameter là id, Email, Username, FirstName,
	// LastName (với FullName = FirstName + LastName) và
	// Position của User, default createDate = now
	public Account(int id, String email, String userName, String fullName, Position position) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.position = position;
		this.createDate = LocalDate.now();
	}

	// d) Có các parameter là id, Email, Username, FirstName,
	// LastName (với FullName = FirstName + LastName) và
	// Position của User, createDate
	public Account(int id, String email, String userName, String fullName, Position position, LocalDate createDate) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.position = position;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition=() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Group[] getGroups() {
		return groups;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

}