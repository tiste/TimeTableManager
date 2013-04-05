import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Lesson {
	private int id;
	private String lib;
	
	/**
	 * Instanciate a lesson
	 * @param id
	 */
	public Lesson(int id) {
		MySQL m = new MySQL();
		ResultSet rs = m.query("SELECT id, lib FROM Lessons WHERE id = " + id + ";");
		
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
	 * Find all lessons
	 * @return array Lessons
	 */
	public static List<Lesson> findAll() {
		List<Lesson> ls = new ArrayList<Lesson>();
		MySQL m = new MySQL();
		ResultSet rs = m.query("SELECT id FROM Lessons;");
		
		try {
			while (rs.next()) {
				ls.add(new Lesson(rs.getInt("id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ls;
	}
	
	/**
	 * Find lessons with timestamp
	 * @param idClassroom
	 * @param start
	 * @param end
	 * @return array Lessons
	 */
	public static List<Lesson> findWith(int idClassroom, String start, String end) {
		List<Lesson> ls = new ArrayList<Lesson>();
		MySQL m = new MySQL();
		ResultSet rs = m.query("SELECT Lessons.id AS id, DATE_FORMAT(Plans.start, '%W') FROM Lessons INNER JOIN Plans ON Plans.idLesson = Lessons.id WHERE Plans.start > '"+ start +"' AND Plans.end < '"+ end +"' AND Plans.idClassroom = "+ idClassroom +";");
		
		try {
			while (rs.next()) {
				ls.add(new Lesson(rs.getInt("id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ls;
	}
}
