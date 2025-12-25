package enity;

public class Staff {
	protected String name;
	private int age;
	private Gender gender;
	private String address;

	public enum Gender {
		MALE, FEMALE, UNKNOWN
	}

	// dùng chung

	public Staff(String name, int age, Gender gender, String address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Staff [name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address + "]";
	}
}