import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MySQL {
	
	public List<String> query(String sql) {
		List<String> rs = new ArrayList<String>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/Ypnose", "root", "");
			Statement stat = cnx.createStatement();
			ResultSet res = stat.executeQuery(sql);
			
			while (res.next()) {
				System.out.println(res);
			}
			
			cnx.close();
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
		
		//System.out.println(rs);
		
		return rs;
	}
}
