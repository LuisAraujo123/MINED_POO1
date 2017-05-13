<%-- 
    Document   : guarDenuncia
    Created on : May 13, 2017, 3:36:03 AM
    Author     : bernardo
--%>

<%@page import="com.sv.udb.utilidades.Correos"%>
<%@page import="com.sv.udb.controlador.DenunciasCtrl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="objeDenu" class="com.sv.udb.modelo.Denuncias"/>
<jsp:setProperty property="*" name="objeDenu"/>
<%
    session = request.getSession(true);
    Object corrDenu = session.getAttribute("corrDenu");
    if (corrDenu == null)
    {
        response.sendRedirect("hacerDenuncia.jsp");
    }
    else
    {
        objeDenu.setCorrDenu((String)corrDenu);
    }
    if(new DenunciasCtrl().guar(objeDenu))
    {
        Correos envi = new Correos("Su denuncia esta siendo procesada, los operadores van a recibirla", (String)corrDenu, "Informe de denuncia");
        if (envi.SendMail())
        {
            request.setAttribute("mensAler", "Denuncia ingresada! Este pendiente de su correo electrónico.");
        }
        else
        {
            request.setAttribute("mensAler", "Denuncia ingresada! Pero no se podra enviar notificaciones porque hubo problemas al enviarle el correo electrónico :(");
        }        
    }
    else
    {
        request.setAttribute("mensAler", "Error. Hubo problemas al crear la denuncia, intente de nuevo más tarde.");
    }
    session.removeAttribute("corrDenu");
%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/Materialize/0.96.0/dist/css/materialize.min.css'>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/Materialize/0.96.0/dist/js/materialize.min.js"></script>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
        <title>Crea tu denuncia</title>
    </head>
    <body>
    <header class='navbar-fixed'>
    <nav class='brown'>
        <div class='nav-wrapper'>
        </div>
    </nav>
    </header>
    <br>
    <br>
    <main class='container'>
        <h3 class="center-align">${mensAler}</h3>
    </main>
    <br>
    <footer class='page-footer brown'>
        <div class='container'>
            <div class='row'>
                <div class='col s12 m6'>
                    <h5 class='white-text'>Dashboard</h5>
                    <a class='white-text' href='mailto:dacasoft@outlook.com'><i class='material-icons left'>help</i>Ayuda</a>
                </div>
                <div class='col s12 m6'>
                    <h5 class='white-text'>Enlaces</h5>
                    <a class='white-text' href='hacerDenuncia.jsp' target='_blank'><i class='material-icons left'>visibility</i>Hacer una denuncia</a>
                </div>
            </div>
        </div>
        <div class='footer-copyright'>
            <div class='container'>
                <span>©ITR, todos los derechos reservados.</span>
                <span class='white-text right'>Diseñado con <a class='red-text text-accent-1' href='http://materializecss.com/' target='_blank'><b>Materialize</b></a></span>
            </div>
        </div>
    </footer>        
    <script>
        $(document).ready(function(){
            $('.button-collapse').sideNav();
            $('.materialboxed').materialbox();
            $('select').material_select();
        });
        </script>
    </body>
</html>
