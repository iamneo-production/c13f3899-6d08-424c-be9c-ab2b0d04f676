package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import model.User;
import utility.ConnectionManager;

public class ZodiacDao {

    static ConnectionManager cm = new ConnectionManager();

    private static final String DELETE_USER = "delete from user where userId =?;";

    public static void addUser(User user) throws SQLException{
        try {
            
            Connection conn = cm.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into user(userName,userBirthDate,userBirthTime,userDistrict) values('"+user.getUserName()+"','"+user.getUserBirthDate()+"','"+user.getUserBirthTime()+"','"+user.getUserDistrict()+"')");      
           ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
            
        }

        public static boolean updateUser(User user) throws SQLException{
            boolean updated=false;
            try { 
                Connection conn = cm.getConnection();
                PreparedStatement ps = conn.prepareStatement("update user set userName='"+user.getUserName()+"',userBirthDate='"+user.getUserBirthDate()+"',userBirthTime='"+user.getUserBirthTime()+"',userDistrict='"+user.getUserDistrict()+"' where userId='"+user.getUserId()+"' ");

                updated = ps.executeUpdate()>0;
             }
            catch(Exception e){
               e.printStackTrace();
            }
            return updated;
               
            }
        
        public static boolean deleteUser(int userId ) throws SQLException{
            boolean flag;
            try(Connection conn = cm.getConnection();
            PreparedStatement ps = conn.prepareStatement(DELETE_USER)){
            ps.setInt(1, userId);
            flag = ps.executeUpdate() > 0;
            }
            return flag;
            
           
        }

        public static int findUser(User user) throws SQLException 
        {
            int id=0;
            String query = "select * from user where userName='"+user.getUserName() +"' or userBirthDate='"+ user.getUserBirthDate() +"' or userBirthTime ='"+user.getUserBirthTime()
            +"' or userDistrict ='"+user.getUserDistrict()+"'";
            ConnectionManager tc=new ConnectionManager();
          
            try {
                
                Connection conn = tc.getConnection();
                ResultSet rs=tc.getResultSet(query, conn);
                while(rs.next())
                {   id = rs.getInt(1);   				
                }	
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
             return id;
                
        }
    

    public static User viewUserById(int userId) throws SQLException 
	{
		String query = "select * from user where userId = "+ userId;
		ConnectionManager tc=new ConnectionManager();
		User userList = new User();
		try {
			String username,userbirthdate,userbirthtime,userdistrict;
            int id;
			
			Connection conn = tc.getConnection();
			ResultSet rs=tc.getResultSet(query, conn);
			while(rs.next())
			{   id = rs.getInt(1);
				username=rs.getString(2);
				userbirthdate=rs.getString(3);
				userbirthtime=rs.getString(4);
				userdistrict=rs.getString(5);
				 userList=new User(username,userbirthdate,userbirthtime,userdistrict);
				userList.setUserId(id);
               				
			}	
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return userList;
			
	}

    public static List<User> list() throws SQLException 
	{
		String query = "select * from user";
		ConnectionManager tc=new ConnectionManager();
		List<User> userList = new ArrayList<User>();
		try {
			String username,userbirthdate,userbirthtime,userdistrict;
            int id;
			
			Connection conn = tc.getConnection();
			ResultSet rs=tc.getResultSet(query, conn);
			while(rs.next())
			{   id = rs.getInt(1);
				username=rs.getString(2);
				userbirthdate=rs.getString(3);
				userbirthtime=rs.getString(4);
				userdistrict=rs.getString(5);
				User us=new User(username,userbirthdate,userbirthtime,userdistrict);
				us.setUserId(id);
                userList.add(us);   				
			}	
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		return userList;
			
	}


}
