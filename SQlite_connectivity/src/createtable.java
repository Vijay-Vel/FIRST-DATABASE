import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Statement;  
public class createtable {
	 public static void createNewTable() {  
	        // SQLite connection string  
	        String url = "jdbc:sqlite:C://sqlite/MDB.db";  
	          
	        // SQL statement for creating a new table  
	        String sql = "CREATE TABLE IF NOT EXISTS movies" +
	                "(movie_no integer PRIMARY KEY NOT NULL,\n"+
	                "actor_name text NOT NULL,\n"+
	                "movie_name text NOT NULL,\n"+
	                "actress_name text NOT NULL,\n"+
	                "year integer\n )";  
	          
	        try{  
	            Connection conn = DriverManager.getConnection(url);  
	            Statement stmt = conn.createStatement();  
	            stmt.execute(sql);  
	            System.out.println("Table Created!!!");
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }

	public static void main(String[] args) {
		 createNewTable();

	}

}
