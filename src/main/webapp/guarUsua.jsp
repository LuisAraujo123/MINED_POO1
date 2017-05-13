<%-- 
    Document   : guarUsua
    Created on : 05-12-2017, 11:58:45 PM
    Author     : leyes
--%>

<%@page import="com.sv.udb.controlador.UsuariosCtrl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="objeCole" class="com.sv.udb.modelo.Usuarios"/>
<jsp:setProperty property="*" name="objeCole"/>
<%
    session = request.getSession(true);
    Object usuaActu = session.getAttribute("usuaActu");
    if (usuaActu == null)
    {
        response.sendRedirect("login.jsp");
    }
    if(new UsuariosCtrl().guar(objeCole))
    {
        response.sendRedirect("index.jsp");
    }
    else
    {
        System.err.println("No se guardó");
    }
%> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>

