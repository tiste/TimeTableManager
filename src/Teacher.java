import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Teacher {
	int id;
	String firstName;
	String lastName;
	
	/**
	 * Instanciate a teacher
	 * @param id
	 */
	public Teacher(int id) {
		MySQL m = new MySQL();
		ResultSet rs = m.query("SELECT id, firstName, lastName FROM Teachers WHERE id = " + id + ";");
		
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
	
	/**
	 * To string
	 */
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
	
	/**
	 * Find all teachers
	 * @return array Teachers
	 */
	public static List<Teacher> findAll() {
		List<Teacher> ts = new ArrayList<Teacher>();
		MySQL m = new MySQL();
		ResultSet rs = m.query("SELECT id FROM Teachers;");
		
		try {
			while (rs.next()) {
				ts.add(new Teacher(rs.getInt("id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ts;
	}
}
