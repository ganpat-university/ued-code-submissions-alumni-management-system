package project;

import java.sql.*;
import jakarta.servlet.jsp.*;
import jakarta.servlet.jsp.tagext.TagSupport;

public class view  extends TagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2942025518540279504L;
	private String table;
	public void setTable(String table)
	{
		this.table = table;
	}
	public int doStartTag() throws JspException
	{
		try
		{
			JspWriter out = pageContext.getOut();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Ganpat123#");
			PreparedStatement stmt = con.prepareStatement("SELECT name,enrollment_number,email FROM " + table + " ORDER BY id DESC");
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int n = rsmd.getColumnCount();
			out.print("<table border=5 style=\"margin-top:20px; border-collapse:collapse;\">");
			out.print("<tr>");
			for (int i=1;i<=n;i++)
			{
				out.print("<th style=\"text-align:center; padding:5px;\">" + rsmd.getColumnName(i) + "</th>");
			}
			out.print("</tr>");
			while (rs.next())
			{
				out.print("<tr>");
				for (int i = 1; i <= n; i++)
				{
					out.print("<td style=\"text-align:center; padding:5px;\">" + rs.getString(i) + "</td>");
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
