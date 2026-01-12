package entity;

public class Student {
	public static int COUNT = 0;
	private static int id;
	private String name;

	public Student(String name) {
		super();
		this.id = ++COUNT;
		this.name = name;
	}

	public Student() {
		super();
	}

	public static int getCOUNT() {
		return COUNT;
	}

	public static void setCOUNT(int cOUNT) {
		COUNT = cOUNT;
	}

	public static int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
