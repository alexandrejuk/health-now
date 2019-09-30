<%@page import="Model.Employee"%>
<%@page import="java.util.List, Controller.MainController" %>
<% 
 	MainController controller = new MainController();
	int totalPacient = controller.totalPacient();
	int totalDoctor = controller.totalDoctor();
	
	Cookie[] cookies = request.getCookies();
	String cookieEmployee = null;
	
	if (cookies != null) {
	 for (Cookie cookie : cookies) {
	   if (cookie.getName().equals("employee")) {
		   cookieEmployee = cookie.getValue();
	    }
	  }
	}
	
	Employee doctor = controller.getEmployeeByDocumentId(cookieEmployee);
 %>

<div class="toolbar">
  <div class="toolbar-logo">
    <img 
         class="logo-image"
         alt="logo health now" 
         src="https://www.freelogodesign.org/file/app/client/thumb/cd30edb4-f0c4-4c9b-b48c-b314103eb541_200x200.png?1569774881972"
         >
  </div>
  <div class="toolbarHeader">
    <h4> Olá </h4>
    <h3>Dr. <% out.print(doctor.getName()); %>!</h3>
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
       <h3>2500</h3>        
    </div>
    <div class="summaryItem">
      <i class="fa fa-briefcase" aria-hidden="true"></i>
      <span class="summaryItem-title">Médicos</span>
      <h3><% out.print(totalDoctor); %></h3>      
    </div>
    <div class="summaryItem">
      <i class="fa fa-calendar-plus-o" aria-hidden="true"></i>
      <span class="summaryItem-title">Agendamentos</span>
      <h3>2500</h3>      
    </div>
    <div class="bd-bottom"></div>
  </div>
  <div class="toolbar-menu">
    <ul class="menu">
      <li class="menu-item">Agendamento</li>
      <li class="menu-item">Consulta</li>
      <li class="menu-item"><a href="/prova/employeeDashboard/pacient.jsp">Paciente</a></li>
      <li class="menu-item"><a href="/prova/employeeDashboard/employee.jsp">Funcionário</a></li>
    </ul>
  </div>
</div>