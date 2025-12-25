package VTI.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Group {
	public int id;
	public String name;
	public Account creator;
	public LocalDate createDate;
	public Account[] accounts;

//	@Override
//	public String toString() {
//		return "Group [id=" + id + ", name=" + name + ", creator=" + creator + ", createDate=" + createDate + "]";
//	}

	// khon có paramater

	// b
	// ) Có các parameter là GroupName, Creator, array Account[]
	// accounts, CreateDate

	public Group(int i, String string, String string2, int j, int k) {
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.createDate = createDate;
		this.accounts = accounts;

	}

//	@Override
	public void showinfo_3() {
		System.out.println("Group [id=" + id + ", name=" + name + ", creator=" + creator + ", createDate=" + createDate
				+ ", accounts=" + Arrays.toString(accounts) + "]");
	}

//	c) Có các parameter là GroupName, Creator, array String[]
//			usernames , CreateDate
//			Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin
//			username, các thông tin còn lại = null).
//			Khởi tạo 1 Object với mỗi constructor ở trên 
	public Group(int id, String name, Account creator, String[] usernames, LocalDate createDate) {
		this.id = id;
		this.name = name;
		this.creator = creator;
		// account
		Account[] accounts = new Account[usernames.length];
		for (int i = 0; i < usernames.length; i++) {
			accounts[i] = new Account(usernames[i]);
		}
		this.createDate = createDate;

	}

	public void showinfo_4() {
		System.out.println("Group [id=" + id + ", name=" + name + ", creator=" + creator + ",Account "
				+ Arrays.toString(accounts) + ", createDate=" + createDate);
	}
}
