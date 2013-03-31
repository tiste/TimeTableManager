import java.sql.*;


public class Teacher {
	int id;
	String firstName;
	String lastName;
	
	
	public Teacher(int id) {
		MySQL m = new MySQL();
		ResultSet rs = m.query("SELECT id, firstName, lastName FROM Teachers WHERE id = " + id);
		
		try {
			while (rs.next()) {
				id = rs.getInt("id");
				firstName = rs.getString("firstName");
				lastName = rs.getString("lastName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

	
	public static void main(String[] args) {
		Teacher t = new Teacher(1);
		System.out.println(t.getFirstName());
	}
}
