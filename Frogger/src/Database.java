import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	private String PlayerName = "";
	private int Score;
	
	public void setScore(int Score) {
		this.Score = Score;
	}
	
	public void setName(String PlayerName) {
		this.PlayerName = PlayerName;
	}
	
	
	public void CreateDatabase() {
		
		Connection conn = null;
		Statement stmt = null;
		
		
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Driver Loaded");
			
			//connection sting to connect to Database
			String dbURL = "jdbc:sqlite:FroggerDatabase.db";
			conn = DriverManager.getConnection(dbURL);
			
			if(conn != null) {
				
				System.out.println("Connected to database");
				conn.setAutoCommit(false);
				
				stmt = conn.createStatement();
				
				String sql = "CREATE TABLE IF NOT EXISTS GAME " +
						 "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
						 " NAME TEXT NOT NULL, " + 
						 " SCORE INT NOT NULL)";
				
				stmt.executeUpdate(sql);
				conn.commit();
				
				sql = "INSERT INTO GAME (NAME, SCORE) VALUES " + 
						 "('"+ PlayerName + "'," + Score +")";
				stmt.executeUpdate(sql);
				conn.commit();
				
				stmt.executeUpdate(sql);
				sql = "SELECT * FROM GAME";
				ResultSet rs = stmt.executeQuery(sql);
				DisplayDatabase(rs);
				rs.close();
				conn.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DisplayDatabase(ResultSet rs) throws SQLException {
		
		while (rs.next() ) {
			
		int id = rs.getInt("id");
		String name = rs.getString("name");
		int score = rs.getInt("score");
		
		 System.out.println("ID = " + id);
		 System.out.println("Name = " + name);
		 System.out.println("Score = " + score);
		}
		
	}
}
