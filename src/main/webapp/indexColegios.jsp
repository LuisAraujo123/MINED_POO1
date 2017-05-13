<%@page import="com.sv.udb.modelo.Colegios"%>
<%@page import="java.util.List"%>
<%@page import="com.sv.udb.controlador.ColegiosCtrl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/Materialize/0.96.0/dist/css/materialize.min.css'>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/Materialize/0.96.0/dist/js/materialize.min.js"></script>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
        <title>JSP Page</title>
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
        <h3 class='center-align'>Administración de colegios</h3>
        <h4 class="center-align red-text">${mensAler}</h4>
        <div class="row">
            <div class="col s12 m6">
                <h5 class='center-align'>Agregar colegios</h5>
                <form method="POST" action="guarCole.jsp" name="Demo">
                    <div class="row">
                        <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>perm_identity</i>
                            <input id='nombCole' type='text' name='nombCole' required/>
                            <label for='nombCole'>Nombre del colegio</label>
                        </div>
                        <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>swap_calls</i>
                            <input id='direCole' type='text' name='direCole' required/>
                            <label for='direCole'>Dirección del colegio</label>
                        </div>
                        <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>vpn_key</i>
                            <input id='infrCole' type='text' name='infrCole' maxlength="5" class='validate' pattern='^[\d]5}$' required/>
                            <label for='infrCole'>Código de infraestructura</label>
                        </div>
                    </div>
                    <div class='row center-align'>
                        <button class="btn waves-effect waves-light" type="submit" name="btonCole">Guardar<i class="material-icons right">send</i></button>
                    </div>
                </form>
            </div>
            <div class="col s12 m6">
                <form method="POST" action="ColegiosServ" name="Demo">
                    <h5 class='center-align'>Modificar colegios</h5>
                    <div class="row">
                        <div class="input-field col s12 m6">
                            <i class='material-icons red-text prefix'>note_add</i>
                            <input id='codi' readonly class='red-text' type='text' name='codi' value="${codi}" required/>
                            <label for='codi'>Codigo</label>
                        </div>
                        <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>perm_identity</i>
                            <input id='nomb' type='text' name='nomb' value="${nomb}" required/>
                            <label for='nomb'>Nombre del colegio</label>
                        </div>
                        <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>swap_calls</i>
                            <input id='dire' type='text' name='dire' value="${dire}" required/>
                            <label for='dire'>Dirección del colegio</label>
                        </div>
                        <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>vpn_key</i>
                            <input id='infr' type='text' name='infr' maxlength="5" class='validate' pattern='^[\d]5}$' value="${infr}" required/>
                            <label for='infr'>Código de infraestructura</label>
                        </div>
                    </div>
                    <div class='row center-align'>
                        <button class="btn waves-effect waves-light" type="submit" value="Modificar" name="btonCole">Modificar<i class="material-icons right">send</i></button>
                    </div>
                </form>
            </div>
        </div>
        <h3>Lista de Colegios</h3>
        <form method="POST" action="ColegiosServ" name="Tabl">
            <table class="highlight" border="2">
            <tr>
                <th>Cons</th>
                <th>Nombre</th>
                <th>Direccion</th>
                <th>Infraestructura</th>
            </tr>
            <%
                List<Colegios> listCole  = new ColegiosCtrl().consTodo();
                pageContext.setAttribute("listEquiJSTL", listCole);
            %>
            <c:forEach items="${listEquiJSTL}" var="temp">
                <tr>
                    <td><p><input type="radio" name="codiColeRadi" class='with-gap' id="${temp.getCodiCole()}" value="${temp.getCodiCole()}"><label for="${temp.getCodiCole()}"></label></p></td>
                    <td>${temp.getNombCole()}</td>
                    <td>${temp.getDireCole()}</td>
                    <td>${temp.getInfrCole()}</td>
                </tr>
            </c:forEach>
            </table>
            <input type="submit" name="btonCole" value="Consultar">
            <input type="submit" onclick="return confirm('¿Esta seguro de eliminar este registro?');" name="btonCole" value="Eliminar">
            <input type="submit" name="btonCole" value="Nuevo">
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
