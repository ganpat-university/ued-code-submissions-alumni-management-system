package project;

import java.io.*;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet(urlPatterns = "/authentication")
public class Register extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3608952334555430550L;

	public void init() throws ServletException{
		try
		{	
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try
		{
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			String Name = req.getParameter("Name");
			String Enrollment_number = req.getParameter("Enrollment_number");
			String Email = req.getParameter("Email");
			String Password = req.getParameter("Password");
			


			String query="INSERT INTO student VALUES(?,?,?,?)";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Ganpat123#");
			PreparedStatement p=con.prepareStatement(query);
			p.setString(1,Name);
			p.setString(2,Enrollment_number);
			p.setString(3,Email);
			p.setString(4,Password);
			
			int x = p.executeUpdate();
			//System.out.println(x);
			if(x>0)
			{
				PrintWriter out =res.getWriter();
				res.setContentType("text/HTML");
				out.println("<script type=\"text/javascript\">");
				out.println("alert(\"Your Account Created Successfully\")");
				out.println("window.location.href = \"login.html\";");
				out.println("</script>");
			}
			/*else 
			{
				PrintWriter out1 =res.getWriter();
				res.setContentType("text/HTML");
				out1.println("<script type=\"text/javascript\">");
				out1.println("alert(\"Your Registration Failed..!\")");
				out1.println("window.location.href = \"login.html\";");
				out1.println("</script>");
			
			}*/
			//RequestDispatcher rd = req.getRequestDispatcher("Successful.html");
			//rd.forward(req, res);
			p.close();
			con.close();
			pw.close();
		} 
		catch(Exception e) 
		{
			System.out.println("Exception : "+e);
			//RequestDispatcher rd = req.getRequestDispatcher("Failed.html");
			//rd.forward(req, res);
		}
	}
	
	public void destroy()
	{	
	}

}
