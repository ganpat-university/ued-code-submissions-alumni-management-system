package project;

import java.io.*;

import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
//@WebServlet(urlPatterns = "/authentication1")
public class Login extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5244966487093192683L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		String n=request.getParameter("Email");
		String p=request.getParameter("pswd");
		
		if(n.equals("guni@gmail.com") && p.equals("gnu@1234"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("log");
			rd.forward(request, response);
		}
		else if(student.checkUser(n, p))
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", n);
			RequestDispatcher rs = request.getRequestDispatcher("profile.html");	
			rs.forward(request, response);
		}
		else if(alumni.checkUser(n, p))
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", n);
			RequestDispatcher rs = request.getRequestDispatcher("alumni_prof.html");	
			rs.forward(request, response);
		}
		else
		{
			pw.println("<h2 style=\"color:red\">"+"You are not an authenticated user!!!"+"</h2>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
	}
}
