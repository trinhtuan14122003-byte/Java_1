package Entity;

import java.util.ArrayList;

public class Student {
	private int id;
	private String name;
	public static String NameSchool = "Đại học bách khoa";
	public static int codeid = 1;
	private static ArrayList<Student> studentlist;
	public int nopquylop;
	public static int sotien = 100;
	public static int count = 0;

	public Student() {
		super();
		this.id = codeid++;
		this.nopquylop = sotien;
	}

	public int getId() {
		return id;

	}

	public static String getNameSchool() {
		return NameSchool;
	}

	public static void setNameSchool(String nameSchool) {
		NameSchool = nameSchool;
	}

	public Student(int id, String name, int nopquylop) {
		super();
		this.id = id;
		this.name = name;
		this.nopquylop = nopquylop;
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

	public static ArrayList<Student> getStudentlist() {
		return studentlist;
	}

	public static void setStudentlist(ArrayList<Student> studentlist) {
		Student.studentlist = studentlist;
	}

	public void nopquylop(int sotien) {
		this.sotien = sotien;

	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "," + "NameSchool:" + NameSchool + ", đóng góp:" + nopquylop
				+ "]";
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Student.count = count;
	}

}
