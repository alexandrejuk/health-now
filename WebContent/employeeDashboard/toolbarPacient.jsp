<%@page import="Model.Employee, Model.Pacient"%>
<%@page import="java.util.List, Controller.MainController" %>
<% 
 	MainController controller = new MainController();
	int totalPacient = controller.totalPacient();
	int totalDoctor = controller.totalDoctor();
	Cookie[] cookies = request.getCookies();
	String pacientId = null;
	
	 for (Cookie cookie : cookies) {
	   if(cookie.getName().equals("pacient")) {
		   pacientId = cookie.getValue();
	   }   
	  }

	
	Pacient pacientLogged = controller.getPacientByDocumentId(pacientId);
 %>

<div class="toolbar">
  <div class="toolbar-logo">
    <img class="logo-image" alt="logo health now"
      src="https://www.freelogodesign.org/file/app/client/thumb/cd30edb4-f0c4-4c9b-b48c-b314103eb541_200x200.png?1569774881972">
  </div>
  <div class="toolbarHeader">
    <h4> Olá </h4>
    <h3><% out.print(pacientLogged.getName());%>!</h3>
  </div>
  
  <div class="toolbar-menu mt-30">
    <ul class="menu">
      <li class="menu-item"><a href="/prova/employeeDashboard/medicalRecordsPacient.jsp">Consultas</a></li>
      <li class="menu-item"><a href="/prova/employeeDashboard/signout.jsp">Sair</a></li>
    </ul>
  </div>
</div>