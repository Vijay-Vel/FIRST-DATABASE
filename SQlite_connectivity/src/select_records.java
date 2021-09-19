import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  

public class select_records {
	 private Connection connect() {  
	        // SQLite connection string  
	        String url = "jdbc:sqlite:C://sqlite/MDB.db";  
	        Connection conn = null;  
	        try {  
	            conn = DriverManager.getConnection(url);  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	        return conn;  
	    }  
	   
	  
	    public void selectAll(){  
	        String sql = "SELECT * FROM movies";  
	          
	        try {  
	            Connection conn = this.connect();  
	            Statement stmt  = conn.createStatement();  
	            ResultSet rs    = stmt.executeQuery(sql);  
	              
	            // loop through the result set  
	            while (rs.next()) {  
	                System.out.println(rs.getInt("movie_no") +  "\t\t" +   
	                                   rs.getString("actor_name") + "\t\t" +
	                                   rs.getString("movie_name") + "\t\t\t" +
	                                   rs.getString("actress_name") + "\t\t\t" +
	                                   rs.getInt("year"));  
	            }  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    } 

	public static void main(String[] args) {
		select_records app = new select_records();  
        app.selectAll();  

	}

}
