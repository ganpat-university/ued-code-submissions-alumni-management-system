package project;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class check extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5863033665065899356L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		//PrintWriter pw= response.getWriter();
		//String n=request.getParameter("Email");
		//pw.println("<h1 align='center' style=\"color:green\">"+"Welcome "+n+"</h1></centre>");
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
	}

}
