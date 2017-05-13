<%-- 
    Document   : login
    Created on : May 13, 2017, 12:47:58 AM
    Author     : bernardo
--%>
<%@page import="com.sv.udb.modelo.Usuarios"%>
<%@page import="com.sv.udb.controlador.UsuariosCtrl"%>
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
        <title>Login</title>
    </head>
    <body>
    <header class='navbar-fixed'>
        <nav class='brown'>
            <div class='nav-wrapper'>
            </div>
        </nav>
    </header>
    <%
        UsuariosCtrl obje = new UsuariosCtrl();
        if (obje.consTodo().isEmpty())
        {   
            Usuarios nuev = new Usuarios();
            nuev.setCodiPreE(1);
            nuev.setContraE("root");
            nuev.setCorreo("correo@correo.com");
            nuev.setDui_emple("00000000-0");
            nuev.setNombreE("Nombre");
            nuev.setNombrEmple("root");
            nuev.setRespuestaE("Admin");
            if (obje.guar(nuev)){
                request.setAttribute("mensAler", "Ingrese el usuario inicial");
            }
        }
    %>
    <main class='container'>
        <h3 class='center-align'>Login</h3>
        <form method='post' action="LoginServ" name='Demo'>
        <div class='row'>
            <div class='input-field col s12 m6 offset-m3'>
                <i class='material-icons prefix'>person_pin</i>
                <input id='usua' type='text' name='usua' class='validate' required/>
                <label for='usua'>Usuario</label>
            </div>
            <div class='input-field col s12 m6 offset-m3'>
                <i class='material-icons prefix'>security</i>
                <input id='pass' type='password' name='pass' class="validate" required/>
                <label for='pass'>Contraseña</label>
            </div>
            <div class='input-field col s12 m6 offset-m3'>
                <h5 class='center-align red-text'>${mensAler}</h5>
            </div>
        </div>
        <div class='row center-align'>
            <button class="btn waves-effect waves-light" type="submit" value='Loguear' name="btonLogi">Iniciar Sesión<i class="material-icons right">send</i></button>
        </div>
        </form>
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
