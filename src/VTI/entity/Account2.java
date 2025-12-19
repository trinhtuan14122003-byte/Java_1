package VTI.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Account2 {
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
	public Account2() {
	}

	// b) Có các parameter là id, Email, Username, FirstName,
	// LastName (với FullName = FirstName + LastName)

	public Account2(int id, String email, String userName) {
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
	public Account2(int id, String email, String userName, String fullName, Position position) {
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
	public Account2(int id, String email, String userName, String fullName, Position position, LocalDate createDate) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.position = position;
		this.createDate = createDate;
	}

	// Question 3:
	// a không có
	public void Group() {
	}
	// b

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(groups);
		result = prime * result + Objects.hash(createDate, department, email, fullName, id, position, userName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Account2 other = (Account2) obj;
		return Objects.equals(createDate, other.createDate) && Objects.equals(department, other.department)
				&& Objects.equals(email, other.email) && Objects.equals(fullName, other.fullName)
				&& Arrays.equals(groups, other.groups) && id == other.id && Objects.equals(position, other.position)
				&& Objects.equals(userName, other.userName);
	}

	// b) Có các parameter là GroupName, Creator, array Account[]
	// accounts, CreateDate
}