package webServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.MainController;
import Model.MedicalRecords;

@WebServlet (urlPatterns = "/dashboard/medicalRecords")
public class MedicalRecordsServlet extends HttpServlet {
	
	private static final long serialVersionUID = -869644688587871518L;
	private MainController controller = new MainController();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");		
		String pacientId = req.getParameter("pacientId");
		String doctorId = req.getParameter("doctorId");
		String bloodType = req.getParameter("bloodType");
		String symptoms = req.getParameter("symptoms");
		String examDate = req.getParameter("examDate");
		String status = req.getParameter("status");
		String treatment = req.getParameter("treatment");
				
			if(id != null) {
				MedicalRecords schedule = controller.getScheduleById(id);
				controller.updateShedule(
						id,
						schedule.getPacientId(), 
						schedule.getDoctorId(), 
						schedule.getSymptoms(),
						schedule.getBloodType(), 
						schedule.getExamDate(),
						status,
						treatment
				);
				req.getRequestDispatcher("/dashboard/schedule.jsp").forward(req, resp);
			}else {			
				controller.newShedule(
						pacientId, 
						doctorId, 
						symptoms,
						bloodType, 
						examDate,
						status
				);
				req.getRequestDispatcher("/dashboard/medicalRecords.jsp").forward(req, resp);
			}		
		
	}
	
}
