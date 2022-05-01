package project;

import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/student")

public class student {
	public static boolean checkUser(String email,String password)
	{
		boolean st=false;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root" ,"Vishu@10");
			PreparedStatement ps=con.prepareStatement("select * from student where email=? and password=?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			st=rs.next();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return st;
	}

}
