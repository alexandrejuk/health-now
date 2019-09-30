<%@page import="Model.Employee, Model.Pacient"%>
<%@page import="java.util.List, Controller.MainController" %>
<% 
 	MainController controller = new MainController();
	int totalPacient = controller.totalPacient();
	int totalDoctor = controller.totalDoctor();
	Cookie[] cookies = request.getCookies();
	String employeeId = null;
	
	 for (Cookie cookie : cookies) {
	   if (cookie.getName().equals("employee")) {
		   employeeId = cookie.getValue();
	    }
	  }

	Employee employeeLogged = controller.getEmployeeByDocumentId(employeeId);
	String doctorId = employeeLogged.getId();
	int totalShedule = controller.totalSchedule(doctorId);
	int totalSheduleFinished = controller.totalScheduleFinish(doctorId);;
 %>

<div class="toolbar">
  <div class="toolbar-logo">
    <img class="logo-image" alt="logo health now"
      src="https://www.freelogodesign.org/file/app/client/thumb/cd30edb4-f0c4-4c9b-b48c-b314103eb541_200x200.png?1569774881972">
  </div>
  <div class="toolbarHeader">
    <h4> Olá </h4>
    <h3><% 
    	if(employeeLogged.getRole().equals("doctor")) {
    		out.print("Dr. " + employeeLogged.getName());
    	}else {
    		out.print(employeeLogged.getName());
    	}
    %>!</h3>
  </div>
  <div class="toolbarSummary">
    <div class="summaryItem">
      <i class="fa fa-heart-o" aria-hidden="true"></i>
      <span class="summaryItem-title">Pacientes</span>
      <h3><% out.print(totalPacient); %></h3>
    </div>
    <div class="summaryItem">
      <i class="fa fa-book" aria-hidden="true"></i>
      <span class="summaryItem-title">Consultas</span>
      <h3><% out.print(totalSheduleFinished); %></h3>
    </div>
    <div class="summaryItem">
      <i class="fa fa-briefcase" aria-hidden="true"></i>
      <span class="summaryItem-title">Médicos</span>
      <h3><% out.print(totalDoctor); %></h3>
    </div>
    <div class="summaryItem">
      <i class="fa fa-calendar-plus-o" aria-hidden="true"></i>
      <span class="summaryItem-title">Agenda</span>
      <h3><% out.print(totalShedule); %></h3>
    </div>
    <div class="bd-bottom"></div>
  </div>
  <div class="toolbar-menu">
    <ul class="menu">
      <%
      	if(employeeLogged.getRole().equals("doctor")) {
      %>
      	<li class="menu-item"><a href="/prova/dashboard/schedule.jsp">Agenda</a></li>
      
      <%}else { %>
      	<li class="menu-item"><a href="/prova/dashboard/medicalRecords.jsp">Consultas</a></li>
      <% } %>
      <li class="menu-item"><a href="/prova/dashboard/pacient.jsp">Pacientes</a></li>
      <li class="menu-item"><a href="/prova/dashboard/employee.jsp">Funcionários</a></li>
      <li class="menu-item"><a href="/prova/dashboard/signout.jsp">Sair</a></li>

    </ul>
  </div>
</div>