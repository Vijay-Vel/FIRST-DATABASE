import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException; 

public class select_movies {
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
	public void selectactor(String actor_name){  
        String sql = "SELECT movie_name "
        		+ "FROM movies WHERE actor_name = ?";  
          
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt  = conn.prepareStatement(sql); 
            pstmt.setString(1, actor_name);
            ResultSet rs    = pstmt.executeQuery();  
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getString("movie_name")); 
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    } 


	public static void main(String[] args) {
		select_movies app = new select_movies();  
        app.selectactor("Andrew Garfield"); 

	}

}
