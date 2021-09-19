import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
public class insert_records {
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
	   
	  
	    public void insert(String actor_name, String movie_name, String actress_name, int year) {  
	        String sql = "INSERT INTO movies(actor_name,movie_name,actress_name,year ) VALUES(?,?,?,?)";  
	   
	        try{  
	            Connection conn = this.connect();  
	            PreparedStatement pstmt = conn.prepareStatement(sql);  
	            pstmt.setString(1, actor_name);  
	            pstmt.setString(2, movie_name);
	            pstmt.setString(3, actress_name);
	            pstmt.setInt(4, year);
	            pstmt.executeUpdate();
	            System.out.println("Value Inserted...");
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }  


	public static void main(String[] args) {
		 insert_records app = new insert_records();  
		 app.insert("Tobey Maguire","SpiderMan1","      Kirsten Dunst",2002);  
		 app.insert("Tobey Maguire","SpiderMan2","      Kirsten Dunst",2004);
		 app.insert("Tobey Maguire","SpiderMan3","      Kirsten Dunst",2007);
		 app.insert("Andrew Garfield","Amazing SpiderMan","Emma Stone",2012);
		 app.insert("Andrew Garfield","Amazing SpiderMan2","Emma Stone",2014);
		 app.insert("Tom Holland","SpiderMan-Homecomming","   Zendaya",2017);
		 app.insert("Tom Holland","SpiderMan-far From Home"," Zendaya",2019);
		 app.insert("Tom Holland","SpiderMan-No Way Home","   Zendaya",2021);
         

	}

}
