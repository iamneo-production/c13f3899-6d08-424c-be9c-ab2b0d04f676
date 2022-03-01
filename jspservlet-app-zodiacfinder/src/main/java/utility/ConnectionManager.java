package utility;
import java.sql.*;
import service.ZodiacDao;
import model.User;
import java.util.*;

public class ConnectionManager {
    public static Connection con;
	public Statement dbstat;
	public ResultSet dbRst;
	
	public Connection getConnection() throws SQLException{
        Connection con = null;
		try {
			String url="jdbc:mysql://localhost:3306/zodiacfinder?" + "autoReconnect=true&useSSL=false";
			String uname="root";
			String pwd="examly";
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, uname, pwd);
		}catch (ClassNotFoundException e)
		{
			System.out.println(e);
		}
		finally {
			
		}
		return con;
		
	}
	
	public ResultSet getResultSet(String sqlQuery, Connection conn) throws SQLException{
		try {
			//System.out.println(sqlQuery);
			dbstat=conn.createStatement();
			dbRst=dbstat.executeQuery(sqlQuery);
			
			}
		catch (SQLException se)
		{
			System.out.println(se);
		}
		return dbRst;
	}
	public static void main(String[] args) throws SQLException {
		ConnectionManager o = new ConnectionManager();
		Connection con= o.getConnection();
		System.out.println("*************"+con);
try {
        PreparedStatement ps = con.prepareStatement("update user set userName='gana',userBirthDate='4343',userBirthTime='4343',userDistrict='4343' where userId=1 ");
        }
        catch(Exception e){
           e.printStackTrace();
        }

	 List<User> list =  ZodiacDao.list();
	 for(User li:list) {
	 System.out.println(li.getUserId());
	 System.out.println(li.getUserName());
	 System.out.println(li.getUserDistrict());
	 }

	}
	
}