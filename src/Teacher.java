
public class Teacher {
	int id;
	String firstName;
	String lastName;
	

	/**
	 * Get id
	 * @return int id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Get first name
	 * @return string name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Get last name
	 * @return string last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/*public Teacher getTeacher(int id) {
		
	}*/
	
	public static void main(String[] args) {
		MySQL m = new MySQL();
		m.query("SELECT * FROM News");
	}
}
