package Entity;

public class SecondaryStudent extends Student {
	public static int COUNTSecond = 0;

	static SecondaryStudent sST1 = new SecondaryStudent(1, "Hiếu", 100);
	static SecondaryStudent sST2 = new SecondaryStudent(2, "An", 100);
	static SecondaryStudent sST3 = new SecondaryStudent(3, "Bình", 100);
	static SecondaryStudent sST4 = new SecondaryStudent(4, "Chi", 100);
	static SecondaryStudent sST5 = new SecondaryStudent(5, "Dũng", 100);
	static SecondaryStudent sST6 = new SecondaryStudent(6, "Lan", 100);
	public static SecondaryStudent[] secondaryStudents = { sST1, sST2, sST3, sST4, sST5, sST6 };

	public SecondaryStudent() {
		super();
		COUNTSecond++;
	}

	public SecondaryStudent(int id, String name, int nopquylop) {
		super(id, name, nopquylop);

	}

	@Override
	public String toString() {
		return "SecondaryStudent [ " + getId() + ", " + getName() + "," + COUNTSecond++ + "]";
	}

	public static int getCOUNTSecond() {
		return COUNTSecond;
	}

	public static void setCOUNTSecond(int cOUNTSecond) {
		COUNTSecond = cOUNTSecond;
	}

}
