import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Plan {
	private Teacher teacher;
	private Lesson lesson;
	private Classroom classroom;
	private String start;
	private String end;
	
	
	public Plan(Teacher t, Lesson l, Classroom c, String s, String e) {
		teacher = t;
		lesson = l;
		classroom = c;
		start = s;
		end = e;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}

	public Lesson getLesson() {
		return lesson;
	}
	
	public Classroom getClassroom() {
		return classroom;
	}
	
	public String getStart() {
		return start;
	}
	
	public String getEnd() {
		return end;
	}

	public static List<Plan> findWith(Classroom c, String week) {
		List<Plan> lp = new ArrayList<Plan>();
		MySQL m = new MySQL();
		ResultSet rs = m.query("SELECT idTeacher, idLesson, idClassroom, DATE_FORMAT(start, '%w/%H') AS start, DATE_FORMAT(end, '%w/%H') AS end FROM Plans WHERE idClassroom = " + c.getId() + " AND WEEK(start) = '"+ week.split(" ")[1] +"';");
		
		try {
			while (rs.next()) {
				Plan p = new Plan(new Teacher(rs.getInt("idTeacher")),
						new Lesson(rs.getInt("idLesson")),
						new Classroom(rs.getInt("idClassroom")),
						rs.getString("start"),
						rs.getString("end"));
				lp.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lp;
	}
}
