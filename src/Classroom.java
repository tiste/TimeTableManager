import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Classroom {
	private int id;
	private String lib;
	
	/**
	 * Instanciate a classroom
	 * @param id
	 */
	public Classroom(int id) {
		MySQL m = new MySQL();
		ResultSet rs = m.query("SELECT id, lib FROM Classrooms WHERE id = " + id + ";");
		
		try {
			while (rs.next()) {
				this.id = rs.getInt("id");
				lib = rs.getString("lib");
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
	 * Get lib
	 * @return string lib
	 */
	public String getLib() {
		return lib;
	}
	
	/**
	 * To string
	 */
	public String toString() {
		return this.lib;
	}
	
	/**
	 * Find all classrooms
	 * @return array Classrooms
	 */
	public static List<Classroom> findAll() {
		List<Classroom> cs = new ArrayList<Classroom>();
		MySQL m = new MySQL();
		ResultSet rs = m.query("SELECT id FROM Classrooms;");
		
		try {
			while (rs.next()) {
				cs.add(new Classroom(rs.getInt("id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cs;
	}
}
