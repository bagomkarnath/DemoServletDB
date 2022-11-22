package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.dao.EmployeeDAO;

/**
 * Servlet implementation class ListEmployeeController
 */
@WebServlet("/employee/list")
public class ListEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeDAO employeeDao;
       
    public ListEmployeeController() {
        super();
    }

	@Override
	public void init() throws ServletException {
		super.init();
		employeeDao = new EmployeeDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Map<String, Object>> employeeList = employeeDao.getAllEmployee();
			
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			response.getWriter().print("<table border='1'>");
			employeeList.forEach(employee -> {
				pw.print("<tr>");
				employee.forEach((k,v) ->{
					pw.print("<td>" + v.toString() + "</td>" );
					
				});
				pw.print("</tr>");
			});
			response.getWriter().print("</table>");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}

}
