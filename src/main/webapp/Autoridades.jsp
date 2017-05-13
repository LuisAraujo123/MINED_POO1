<%-- 
    Document   : Autoridades
    Created on : 05-12-2017, 11:45:10 PM
    Author     : Jose Lira
--%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.sv.udb.controlador.AutoridadesCtrl"%>
<%@page import="com.sv.udb.modelo.Autoridades"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/materialize/0.97.3/dist/css/materialize.min.css'>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/materialize/0.97.3/dist/js/materialize.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
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
         <main class="container">
        <h1>${mensAler}</h1>
        <form method="POST" action="AutoridadesServ" name="DEMO" enctype="multipart/form-data">
                    <label for="codi">Codigo:</label>
                    <input type="text" name="codi" id="codi" value="${codi}" readonly> <br>
                    <label for="nomb">Nombre:</label>
                    <input type="text" name="nomb" id="nomb" value="${nomb}" required> <br>
                    <label for="dire">Dirección</label>
                    <input type="text" name="dire" id="dire" value="${dire}" required> <br>
                    <label for="extr">Extr</label>
                    <input type="text" name="extr" id="extr" value="${extr}" required> <br>
                    <label for="nume">Numero</label>
                    <input type="text" name="nume" id="nume" value="${nume}" required> <br>
                       
                            <c:if test="${codi==null}">
                <button class="btn waves-effect waves-light" type="submit" name="btonAuto" value="Guardar"> Guardar
                <i class="material-icons right">send</i>
               
                </button>
                 </c:if>
                                <c:if test="${codi != '' and codi!=null}">
                <button class="btn waves-effect waves-light" type="submit" name="btonAuto" value="Modificar">Modificar
                <i class="material-icons right">send</i>
              
                </button>
                 
                            
                <button class="btn waves-effect waves-light" type="submit" name="btonAuto" value="Eliminar">Eliminar
                <i class="material-icons right">send</i>
                </button>
                </c:if>
                <button class="btn waves-effect waves-light" type="submit" name="btonAuto" value="Nuevo">Nuevo
                <i class="material-icons right">send</i>
                </button>
        <ul>
            <li><a href="index.jsp">Colegios</a></li>
            <li><a href="repoServAutoridades">Reporte</a></li>
            
        </ul>            
        </form>
        
        <h1>La Tabla</h1>
        <form method="POST" action="AutoridadesServ" name="TABLA">
        <table>
            <thead>
            <tr>
                <th>Cons</th>
                <th>Nombre</th>
                <th>Dirección</th>      
                <th>Extr</th>      
                <th>Número</th>      
            </tr>
            </thead>
            <tbody>  
             <%
                 pageContext.setAttribute("listAutJSTL", new AutoridadesCtrl().consTodo());
            %>
            <c:forEach items="${listAutJSTL}" var="temp">
             <tr>
                <td><p><input name="codiAutRadi" type="radio" id="${temp.codiAuto}" value="${temp.codiAuto}" />
                        <label for="${temp.codiAuto}"></label></p></td>
                <td>${temp.nombAuto}</td>
                <td>${temp.direAuto}</td>                
                <td>${temp.extrAuto}</td>                
                <td>${temp.numeAuto}</td>                
               
            </tr>
            </c:forEach>
         </tbody>
        </table>
            <button class="btn waves-effect waves-light" type="submit" name="btonAuto" value="Consultar">Consultar
            <i class="material-icons right">send</i>
            </button>
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
