<%-- 
    Document   : index
    Created on : May 13, 2017, 3:58:27 AM
    Author     : bernardo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/Materialize/0.96.0/dist/css/materialize.min.css'>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/Materialize/0.96.0/dist/js/materialize.min.js"></script>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
        <title>Inicio</title>
    </head>
    <body>
    <%
        session = request.getSession(true);
        Object usuaActu = session.getAttribute("usuaActu");
        if (usuaActu == null)
        {
            response.sendRedirect("login.jsp");
        }
    %>
    <header class='navbar-fixed'>
        <nav class='brown'>
            <div class='nav-wrapper'>
                <a href='index.jsp' class='brand-logo'><i class='material-icons left hide-on-med-and-down'>menu</i></a>
                <a href='index.jsp' data-activates='mobile' class='button-collapse'><i class='material-icons'>menu</i></a>
                <ul class='right hide-on-med-and-down'>
                    <li>
                        <a class='dropdown-button' href='#' data-activates='reportes'>
                            <i class='material-icons left'>perm_media</i>
                            Reportes
                        </a>
                    </li>
                    <li><a href='indexColegios.jsp'><i class='material-icons left'>settings_input_antenna</i>Colegios</a></li>
                    <li><a href='Autoridades.jsp'><i class='material-icons left'>supervisor_account</i>Autoridades</a></li>
                    <li><a href='indexDenuncias.jsp'><i class='material-icons left'>perm_media</i>Denuncias</a></li>
                    <li><a href='indexTipoDenu.jsp'><i class='material-icons left'>note_add</i>Tipo de denuncias</a></li>
                    <li><a href='usuarios.jsp'><i class='material-icons left'>perm_identity</i>Usuarios</a></li>
                    <li><a href='logout.jsp'><i class='material-icons left'>assignment_ind</i>Cerrar Sesión</a></li>
                </ul>
                <ul id="reportes" class="dropdown-content">
                    <li><a href='repoColeServ'><i class='material-icons left'>perm_media</i>Reporte colegios</a></li>
                    <li><a href='RepoDenuServ'><i class='material-icons left'>perm_media</i>Reporte Denuncias</a></li>
                    <li><a href='repoUsuaServ'><i class='material-icons left'>perm_media</i>Reporte Usuarios</a></li>
                    <li><a href='repoServAutoridades'><i class='material-icons left'>perm_media</i>Reporte Autoridades</a></li>
                </ul>
            </div>
        </nav>
    </header>
    <ul class='side-nav' id='mobile'>
        <li><a href='repoColeServ'><i class='material-icons left'>perm_media</i>Reporte colegios</a></li>
        <li><a href='RepoDenuServ'><i class='material-icons left'>perm_media</i>Reporte Denuncias</a></li>
        <li><a href='repoUsuaServ'><i class='material-icons left'>perm_media</i>Reporte Usuarios</a></li>
        <li><a href='repoServAutoridades'><i class='material-icons left'>perm_media</i>Reporte Autoridades</a></li>
        <li><a href='indexColegios.jsp'><i class='material-icons left'>settings_input_antenna</i>Colegios</a></li>
        <li><a href='Autoridades.jsp'><i class='material-icons left'>supervisor_account</i>Autoridades</a></li>
        <li><a href='indexDenuncias.jsp'><i class='material-icons left'>perm_media</i>Denuncias</a></li>
        <li><a href='indexTipoDenu.jsp'><i class='material-icons left'>note_add</i>Tipo de denuncias</a></li>
        <li><a href='usuarios.jsp'><i class='material-icons left'>perm_identity</i>Usuarios</a></li>
        <li><a href='logout.jsp'><i class='material-icons left'>assignment_ind</i>Cerrar Sesión</a></li>
    </ul>
    <main class='container'>
    </main>
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
