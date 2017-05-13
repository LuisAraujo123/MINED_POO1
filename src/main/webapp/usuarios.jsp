<%@page import="com.sv.udb.modelo.Usuarios"%>
<%@page import="com.sv.udb.controlador.UsuariosCtrl"%>
<%@page import="com.sv.udb.modelo.Colegios"%>
<%@page import="java.util.List"%>
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
        <h3 class='center-align'>Agregar usuarios</h3>
        <div class="row">
            <div class="col s12 m6">
                <h5 class='center-align'>Agregar usuarios</h5>
                <form method="POST" action="guarUsua.jsp" name="Demo">
                    <div class="row">
                        <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>perm_identity</i>
                            <input id='nombrEmple' type='text' name='nombrEmple'/>
                            <label for='nombrEmple'>Nombre Usurario</label>
                        </div>
                        <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>swap_calls</i>
                            <input id='nombreE' type='text' name='nombreE'/>
                            <label for='nombreE'>Nombre Empleado</label>
                        </div>
                        <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>vpn_key</i>
                            <input id='contraE' type="password" name='contraE'/>
                            <label for='contraE'>Contraseña</label>
                        </div>
                        <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>vpn_key</i>
                            <input id='correo' type='text' name='correo'/>
                            <label for='Correo'>Correo</label>
                        </div>
                         <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>vpn_key</i>
                            <input id='dui_emple' type='text' name='dui_emple'/>
                            <label for='dui_emple'>DUI</label>
                        </div>
                         <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>vpn_key</i>
                            <input id='respuestaE' type='text' name='respuestaE'/>
                            <label for='respuestaE'>Respuesta</label>
                        </div>
                          <div id="codiPreE" class="input-field col s12 m12" name='codiPreE'>
                            <select>
                              <option value="" disabled selected>Choose your option</option>
                              <option value="1">¿Como se llama tu mama?</option>
                              <option value="2">¿Cual es el nombre de tu mascota?</option>
                              <option value="3">¿Cual es tu comida favorita?</option>
                              <option value="4">¿Cuanto es 2+2?</option>
                            </select>
                            <label>Materialize Select</label>
                          </div>
                    </div>
                    <div class='row center-align'>
                        <button class="btn waves-effect waves-light" ${estGuar} type="submit" name="btonLibr">Guardar<i class="material-icons right">send</i></button>
                    </div>
                </form>
            </div>
            <div class="col s12 m6">
                <form method="POST" action="UsuariosServ" name="Demo">
                    <h5 class='center-align'>Modificar colegios</h5>
                    <div class="row">
                        <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>note_add</i>
                            <input id='codi' type='text' name='codi' value="${codi}"/>
                            <label for='codi'>Codigo</label>
                        </div>
                         <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>perm_identity</i>
                            <input id='nombUsua' type='text' name='nombUsua' value="${nombusu}"/>
                            <label for='nombUsua'>Nombre Usurario</label>
                        </div>
                        <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>swap_calls</i>
                            <input id='nombEmp' type='text' name='nombEmp' value="${nombEmpe}"/>
                            <label for='nombEmp'>Nombre Empleado</label>
                        </div>
                        <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>vpn_key</i>
                            <input id='corre' type='text' name='corre' value="${correo}"/>
                            <label for='corre'>Correo</label>
                        </div>
                         <div class="input-field col s12 m6">
                            <i class='material-icons prefix'>vpn_key</i>
                            <input id='duiEmple' type='text' name='duiEmple' value="${dui}"/>
                            <label for='duiEmple'>DUI</label>
                        </div>
                    </div>
                    <div class='row center-align'>
                        <button class="btn waves-effect waves-light"  type="submit" name="btnConsulUsu" value="Modificar">Modificar<i class="material-icons right">send</i></button>
                    </div>
                </form>
            </div>
        </div>
        <h3>Lista de Colegios</h3>
        <form method="POST" action="UsuariosServ" name="Tabl">
            <table class="highlight" border="2">
            <tr>
                <th></th>
                <th>Nombre usuario:</th>
                <th>Nombre Empleado</th>
                <th>Correo</th>
                <th>Dui</th>
            </tr>
            <%
                List<Usuarios> listCole  = new UsuariosCtrl().consTodo();
                pageContext.setAttribute("listEquiJSTL", listCole);
            %>
            <c:forEach items="${listEquiJSTL}" var="temp">
                <tr>
                    <td><p><input type="radio" name="codiLibrRadi" class='with-gap' id="${temp.getCodiE()}" value="${temp.getCodiE()}"><label for="${temp.getCodiE()}"></label></p></td>
                    <td>${temp.getNombreE()}</td>
                    <td>${temp.getNombrEmple()}</td>
                    <td>${temp.getCorreo()}</td>
                    <td>${temp.getDui_emple()}</td>
                </tr>
            </c:forEach>
            </table>
            <input type="submit" name="btnConsulUsu" value="Consultar">
            <input type="submit" onclick="return confirm('¿Esta seguro de eliminar este registro?');" name="btnConsulUsu" value="Eliminar">
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
                    <a class='white-text' href='' target='_blank'><i class='material-icons left'>store</i>Java web</a>
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
