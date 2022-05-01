package project;

import java.sql.*;
import jakarta.servlet.jsp.*;
import jakarta.servlet.jsp.tagext.TagSupport;

public class display extends TagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2434521526790127888L;
	//private String id;
	public void setId(String id) 
	{
		this.id = id;
	}
	public int doStartTag() throws JspException{
		try 
		{
			JspWriter out = pageContext.getOut();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Vishu@10");
			PreparedStatement stmt = con.prepareStatement("select * from student" );
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int n = rsmd.getColumnCount();
			out.print("<table border=1>");
			out.print("<tr>");
			for (int i=1;i<=n;i++)
			{	
				out.print("<th>" + rsmd.getColumnName(i) + "</th>");
			}
			out.print("</tr>");
			while (rs.next())
			{
				out.print("<tr>");
				for (int i=1;i<=n;i++)
				{
					out.print("<td>" + rs.getString(i) + "</td>");
				}
				out.print("</tr>");
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return SKIP_BODY;
	}


}
