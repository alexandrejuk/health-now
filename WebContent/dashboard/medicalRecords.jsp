<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    if((session.getAttribute("employee") == null)||(session.getAttribute("employee") == "")) {
    	response.sendRedirect("/prova/index.html");
} else {
%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>helth Now - dashboard empregados</title>
  <link href="https://fonts.googleapis.com/css?family=Cantarell:700" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
  <style type="text/css">
    * {
      margin: 0;
      padding: 0;
      font-family: arial;
    }

    a,
    a:hover,
    a:focus,
    a:active {
      text-decoration: none;
      color: #334747;
    }

    body {
      background: #EEEEEE;
    }

    .toolbar-logo {
      height: 130px;
      padding: 0 40px
    }

    .toolbarHeader {
      padding: 0 40px
    }

    .logo-image {
      height: 100%;
    }

    .toolbar {
      max-width: 320px;
      border: 1px solid #3333;
      min-height: 100vh;
      background: #fff;
      color: #334747;
    }

    .toolbarSummary {
      display: flex;
      justify-content: space-between;
      flex-wrap: wrap;
      padding: 0 40px
    }

    .summaryItem {
      font-family: arial;
      width: 95px;
      padding: 14px 0;
    }

    i.fa {
      margin: 10px 0;
      display: block;
      color: #d64416 !important;
    }

    .menu {
      list-style: none;
    }

    .menu-item {
      font-size: 16px;
      cursor: pointer;
      border-top: 1px solid transparent;
      border-bottom: 1px solid transparent;
    }

    .menu-item>a {
      display: block;
      width: 100%;
      padding: 24px 40px;
    }

    .menu-item:hover,
    .menu-item:hover>* {
      color: #d64416;
      border-color: #d64416;
    }

    .summaryItem-title {
      font-size: .8em;
    }

    .bd-bottom {
      display: block;
      width: 100%;
      content: "";
      border-bottom: 1px solid #c7c7c7;
      margin: 10px 0;
    }

    .container {
      display: flex;
    }

    .navbar {
      background: #fff;
      height: 25px;
      width: calc(100vw - 350px);
      padding: 25px;
    }

    .navbar-page {
      /*   margin: 25px; */
      font-weight: normal;
      color: #d64416;
    }

    .mb-40 {
      margin-bottom: 40px;
    }

    .card {
      padding: 25px;
      background: #fff;
      margin: 20px 25px;
      border-radius: 4px;
      box-shadow: 2px 2px 2px 0 rgba(0, 0, 0, .07);
    }

    .card-body {
      display: flex;
      align-items: center;
    }

    .pacientStatus {
      color: #fff;
      background: #334747;
      border-radius: 3px;
      padding: 5px 10px;
      font-weight: bold;
      cursor: pointer;
      font-size: .9em;
      margin: 0 10px 0 0;
      text-align: center;
      ;
    }

    .pacientDocument {
      flex: 1;
      margin: 0 20px;
    }

    .pacientAction {
      cursor: pointer;
      transition: .5 all;
    }

    .pacientAction>a:hover {
      color: #d64416;
    }

    .btn-primary {
      margin: 0 25px;
      border: 1px solid #d64416;
      padding: 10px 20px;
      background: transparent;
      border-radius: 4px;
      font-weight: 600;
      color: #d64416;
      cursor: pointer;
    }

    .content-action {
      width: 100%;
      text-align: right;
    }


    .btn-primary:hover,
    .btn-primary:hover>* {
      background: #d64416;
      color: #fff !important;
    }

    .btn-block {
      width: 100%;
      margin: 0;
    }

    .form {
      margin: auto;
      width: 50%;
    }

    .formInput {
      display: block;
      width: calc(100% - 30px);
      border: 1px solid #c7c7c7;
      padding: 10px;
      border-radius: 3px;
    }

    .formLabel {
      font-size: .8em;
      color: #334747;

    }

    .required {
      color: red;
    }

    .formGroup {
      margin: 10px;
    }

    .formTitleNew {
      color: #334747;
      margin: 20px 10px;
    }

    .formGroupButton {
      margin: 10px;
    }
    .mt-20 {
    	margin: 20px 0 !important;
    	display: block;
    	width: 200px;
    }
    .mt-10 {
    margin: 10px 0 !important;
    }
  </style>
  <%@page import="java.util.List, Model.Pacient, Model.MedicalRecords, Controller.MainController" %>

</head>

<body>
  <div class="container">

    <%@ include file="toolbar.jsp" %>

    <div class="content-main">
      <div class="navbar mb-40">
        <h3 class="navbar-page">Consultas</h3>
      </div>
      <div class="content-action">
        <a href="/prova/dashboard/newMedicalRecords.jsp">
          <button class="btn-primary">
            Adicionar +
          </button>
        </a>
      </div>
      <% 
  	MainController schedulesController = new MainController();
  	List<MedicalRecords> shedules = schedulesController.getAllShedule();
  	
   for(int i = 0; i < shedules.size(); i++) {
	   MedicalRecords schedule = shedules.get(i);
	  
   %>
      <div class="card">
        <div class="card-body">
          <div class="pacientDocument">
            <h3 class="mt-10">
             <% out.print(controller.getPacientById(schedule.getPacientId()).getName()); %>
            </h3>
            <p class="mt-10">
              Data do Atendimento: <% out.print(schedule.getExamDate()); %>
            </p>
             <p class="mt-10">
              Médico: <%out.print(controller.getEmployeeById(schedule.getDoctorId()).getName());%>
            </p>
            <span class="pacientStatus mt-20" title="ativo">
              <% 
              	if(schedule.getStatus().equals("waiting_doctor")) {  
            	  out.print("Aguardando Atendimento");
              	}
              
				if(schedule.getStatus().equals("finished")) {  
					out.print("Finalizado");
				}
              %>
            </span>
          </div>
          <div class="pacientAction">
            <a href="/prova/dashboard/detailMedicalRecords.jsp?id=<%out.print(schedule.getId());%>">
              Detalhes
            </a>
          </div>
        </div>
      </div>
      <% } %>

    </div>
  </div>

</body>
</html>

<%
    }
%>