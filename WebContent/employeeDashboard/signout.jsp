<%
	session.setAttribute("employee", null);
	session.invalidate();

	Cookie[] cookies = request.getCookies();
	for (Cookie cookie: cookies) {
		cookie.setMaxAge(0);
	   	response.addCookie(cookie);
  	}
	
	response.sendRedirect("/prova/index.html");
	
%>