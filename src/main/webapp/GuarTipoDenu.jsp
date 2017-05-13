<%-- 
    Document   : guardarTipoDenu
    Created on : 05-12-2017, 11:29:20 PM
    Author     : DanielWilfredo
--%>
<%@page import="com.sv.udb.controlador.TipoDenunciasCtrl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="objeDenu" class="com.sv.udb.modelo.TipoDenuncias"/>
<jsp:setProperty property="*" name="objeDenu"/>
<%
    session = request.getSession(true);
    Object usuaActu = session.getAttribute("usuaActu");
    if (usuaActu == null)
    {
        response.sendRedirect("login.jsp");
    }
    if(new TipoDenunciasCtrl().guar(objeDenu))
    {
        response.sendRedirect("indexTipoDenu.jsp");
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
