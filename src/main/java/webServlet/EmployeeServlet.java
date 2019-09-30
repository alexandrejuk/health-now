package webServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.MainController;

@WebServlet (urlPatterns = "/dashboard/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 4566138590620477262L;
	private MainController controller = new MainController();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");		
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String type = req.getParameter("type");
		String name = req.getParameter("name");
		String documentId = req.getParameter("documentId");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String role = req.getParameter("role");
		
		if(id != null) {
			controller.updateEmployee(id, userName, password, type, name, documentId, phone, address, role);
		}else {			
			controller.newEmployee(userName, password, type, name, documentId, phone, address, role);
		}
			
		req.getRequestDispatcher("/dashboard/employee.jsp").forward(req, resp);
	}
	
}
