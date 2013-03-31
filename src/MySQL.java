import java.sql.*;


public class MySQL {
	
	public ResultSet query(String sql) {
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/TimeTable", "root", "");
			Statement stat = cnx.createStatement();
			rs = stat.executeQuery(sql);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
}
