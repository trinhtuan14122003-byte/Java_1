package VTI.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Account {
	public int id;
	public String email;
	public String userName;
	public String fullName;
	public Department department; // do cái này da khái bai beb
	public Position position;
	public LocalDate createDate;
	public Group[] groups; // lưu rty nhiều dữ liểu danh cho trường hơp account có thể tham gia nhiều gr

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName
				+ ", department=" + department + ", position=" + position + ", createDate=" + createDate + ", groups="
				+ Arrays.toString(groups) + "]";
	}

}
