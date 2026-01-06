package Entity;

public class PrimaryStudent extends Student {
	public static int countpr = 0;

	public PrimaryStudent() {
		super();
		countpr++;
	}

	public PrimaryStudent(int id, String name, int nopquylop) {
		super(id, name, nopquylop);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PrimaryStudent [ " + getId() + ", " + getName() + "," + countpr++ + "]";
	}

	public static int getCountpr() {
		return countpr++;
	}

	public static void setCountpr(int countpr) {
		PrimaryStudent.countpr = countpr;
	}

}
