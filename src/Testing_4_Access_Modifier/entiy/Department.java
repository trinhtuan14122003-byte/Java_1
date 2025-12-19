package Testing_4_Access_Modifier.entiy;

public class Department {
	public int id;
	public String name;

//	@Override
//	public String toString() {
//		return "Department [id=" + id + ", name=" + name + "]";
//	}

	// Constructor
	public Department(int i, String name) {
		this.id = id; // ✅ dùng tham số id
		this.name = name;
	}

	// Method
	public void showInfo() {
		System.out.println("id: " + this.id + " | name: " + this.name);
	}
}
