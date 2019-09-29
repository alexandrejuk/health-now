package webServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.MainController;
import Model.Employee;
import Model.Pacient;

@WebServlet (urlPatterns = "/auth")
public class WebMainServlet extends HttpServlet {

	private static final long serialVersionUID = 2325899079213785146L;
	private MainController controller = new MainController();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Employee employee = controller.loginEmployee(userName, password);
		Pacient pacient = controller.loginPacient(userName, password);
		
		if(employee != null) 
			out.println(employee.getName());
		
		if(pacient != null) 
			out.println(pacient.getName());
		
		if(employee == null && pacient == null)
			out.println("Usuário não encontrado, login ou senha inválidos!");		
		
	}
}
