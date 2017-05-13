<%-- 
    Document   : indexDenuncias
    Created on : May 13, 2017, 4:36:15 AM
    Author     : bernardo
--%>

<%@page import="com.sv.udb.controlador.TipoDenunciasCtrl"%>
<%@page import="com.sv.udb.modelo.TipoDenuncias"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.sv.udb.controlador.DenunciasCtrl"%>
<%@page import="com.sv.udb.modelo.Denuncias"%>
<%@page import="com.sv.udb.modelo.Denuncias"%>
<%@page import="java.util.List"%>
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
        <title>Denuncias</title>
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
                    <li><a href='indexColegios.jsp'><i class='material-icons left'>settings_input_antenna</i>Colegios</a></li>
                    <li><a href='indexTipoDenu.jsp'><i class='material-icons left'>note_add</i>Tipo de denuncias</a></li>
                    <li><a href='usuarios.jsp'><i class='material-icons left'>perm_identity</i>Usuarios</a></li>
                    <li><a href='logout.jsp'><i class='material-icons left'>assignment_ind</i>Cerrar Sesión</a></li>
                </ul>
            </div>
        </nav>
    </header>
    <ul class='side-nav' id='mobile'>
        <li><a href='indexColegios.jsp'><i class='material-icons left'>settings_input_antenna</i>Colegios</a></li>
        <li><a href='indexTipoDenu.jsp'><i class='material-icons left'>note_add</i>Autoridades</a></li>
        <li><a href='usuarios.jsp'><i class='material-icons left'>perm_identity</i>Usuarios</a></li>
        <li><a href='logout.jsp'><i class='material-icons left'>assignment_ind</i>Cerrar Sesión</a></li>
    </ul>
    <main class='container'>
        <form method="POST" action="DenunciasServ" name="Demo">
            <h5 class='center-align'>Juzgar denuncias</h5>
            <div class="row">
                <div class="input-field col s12 m6">
                    <i class='material-icons red-text prefix'>note_add</i>
                    <input id='codi' readonly class='red-text' type='text' name='codi' value="${codi}" required/>
                    <label for='codi'>Codigo</label>
                </div>
                <div class="input-field col s12 center-align">
                    <select id="codiTipo" name="codiTipo" required> 
                    <option value="" disabled selected>Tipo de denuncia</option>
                    <%
                        for(TipoDenuncias temp : new TipoDenunciasCtrl().consTodo())
                        {

                    %> 
                    <option value="<%=temp.getCodiTipo()%>"><%=temp.getNombTipo()%></option>
                    <%
                        }
                    %>
                    </select>
                </div>
                <div class="input-field col s12 center-align">
                    <i class="material-icons prefix">comment</i>
                    <textarea id="descDenu" name="descDenu" class="materialize-textarea">${descDenu}</textarea>
                    <label for="descDenu">Descripción</label>
                </div>
                <div class="input-field col s12 m6 right-align">
                    <span>Viable:</span>
                    <input id='si' type='radio' name='vali' class='with-gap' value='1' checked="${estaSi}" />
                    <label for='si'><i class='material-icons left'>thumb_up</i></label>
                    <input id='no' type='radio' name='vali' class='with-gap' value='0' checked="${estaNo}" />
                    <label for='no'><i class='material-icons left'>thumb_down</i></label>
                </div>
            </div>
            <div class='col center-align'>
                <br>
                <button class="btn waves-effect waves-light" type="submit" value="Juzgar" name="btonDenu">Juzgar<i class="material-icons right">send</i></button>
            </div>
        </form>
        <h3>Lista de Denucias</h3>
        <form method="POST" action="DenunciasServ" name="Tabl">
            <table class="highlight" border="2">
            <tr>
                <th>Cons</th>
                <th>Denunciante</th>
                <th>Tipo de denuncia</th>
                <th>Colegio</th>
                <th>Descripcion</th>
                <th>Fecha</th>
                <th>Viable</th>
            </tr>
            <%
                List<Denuncias> listDenu  = new DenunciasCtrl().consTodo();
                pageContext.setAttribute("listEquiJSTL", listDenu);
            %>
            <c:forEach items="${listEquiJSTL}" var="temp">
                <tr>
                    <td><p><input type="radio" name="codiDenuRadi" class='with-gap' id="${temp.getCodiDenu()}" value="${temp.getCodiCole()}"><label for="${temp.getCodiDenu()}"></label></p></td>
                    <td>${temp.getCorrDenu()}</td>
                    <td>${temp.getNombTipo()}</td>
                    <td>${temp.getNombCole()}</td>
                    <td>${temp.getDescDenu()}</td>
                    <td>${temp.getFechDenu()}</td>
                    <c:choose>
                        <c:when test="${temp.isViabDenu()}">
                            <td><i class='material-icons'>thumb_up</i></td>
                        </c:when>
                        <c:when test="${!temp.isViabDenu()}">
                            <td><i class='material-icons'>thumb_down</i></td>
                        </c:when>
                    </c:choose>
                </tr>
            </c:forEach>
            </table>
            <input type="submit" name="btonDenu" value="Consultar">
            <input type="submit" onclick="return confirm('¿Esta seguro de eliminar este registro?');" name="btonDenu" value="Eliminar">
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
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15 // Creates a dropdown of 15 years to control year
            });
        });
        </script>
    </body>
</html>
