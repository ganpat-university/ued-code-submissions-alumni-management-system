package project;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/validate")

public class validate extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 740667093906745095L;

	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		if(student.checkUser(email, password))
		{
			HttpSession session = req.getSession();
			session.setAttribute("email", email);
			RequestDispatcher rs = req.getRequestDispatcher("index.jsp");	
			rs.forward(req, res);
		}
		else
		{
			out.println("<center><h3>Username or Password is incorrect!!!<h3></center>");
			out.println("<center><h3>Please Try Again!!!</h3></center>");
			RequestDispatcher rs =req.getRequestDispatcher("login.html");
			rs.include(req, res);
		}
	}

}
