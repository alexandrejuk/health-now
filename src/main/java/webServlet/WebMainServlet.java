package webServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.MainController;
import Model.Employee;
import Model.Pacient;

@WebServlet (urlPatterns = "/auth")
public class WebMainServlet extends HttpServlet {

	private static final long serialVersionUID = 2325899079213785146L;
	private MainController controller = new MainController();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie;
		HttpSession session = req.getSession();
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Employee employee = controller.loginEmployee(userName, password);
		Pacient pacient = controller.loginPacient(userName, password);
		
		if(employee != null) {			
			cookie = new Cookie("employee", employee.getDocumentId());
			session.setAttribute("employee", employee.getName());
			resp.addCookie(cookie);
			req.getRequestDispatcher("/employeeDashboard/pacient.jsp").forward(req, resp);
		}
		
		if(pacient != null) {
			cookie = new Cookie("pacient", pacient.getDocumentId());
			session.setAttribute("pacient", pacient.getName());
			resp.addCookie(cookie);
			req.getRequestDispatcher("/employeeDashboard/medicalRecordsPacient.jsp").forward(req, resp);
		}
		
		if(employee == null && pacient == null)
			req.getRequestDispatcher("/403.html").forward(req, resp);
	
		out.flush();
		out.close();
		
	}

}
