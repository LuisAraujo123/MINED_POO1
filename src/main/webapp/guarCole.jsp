<%-- 
    Document   : guarCole
    Created on : May 12, 2017, 11:17:39 PM
    Author     : bernardo
--%>
<%@page import="com.sv.udb.controlador.ColegiosCtrl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="objeCole" class="com.sv.udb.modelo.Colegios"/>
<jsp:setProperty property="*" name="objeCole"/>
<%
    if(new ColegiosCtrl().guar(objeCole))
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
