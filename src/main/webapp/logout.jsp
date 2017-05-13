<%-- 
    Document   : logout
    Created on : May 13, 2017, 2:00:41 AM
    Author     : bernardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        session = request.getSession(true);
        session.removeAttribute("usuaActu");
        response.sendRedirect("login.jsp");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
