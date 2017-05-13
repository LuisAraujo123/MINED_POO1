<%-- 
    Document   : ingrDenuncia
    Created on : May 13, 2017, 3:16:59 AM
    Author     : bernardo
--%>

<%@page import="com.sv.udb.controlador.ColegiosCtrl"%>
<%@page import="com.sv.udb.modelo.Colegios"%>
<%@page import="com.sv.udb.controlador.TipoDenunciasCtrl"%>
<%@page import="com.sv.udb.modelo.TipoDenuncias"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        session = request.getSession(true);
        Object corrDenu = session.getAttribute("corrDenu");
        if (corrDenu == null)
        {
            response.sendRedirect("hacerDenuncia.jsp");
        }
    %>
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
        <div class="teal lighten-2">
            <br>
            <div class='row'>
                <h5 class='center-align col s8 offset-s2'>Ingrese toda la información.</h5>
            </div>
        <div class="row ">
            <div class="teal lighten-2 col s8 offset-s2">
                <form method="post" action='guarDenuncia.jsp' class="col card-panel s12 grey lighten-5" name='Demo'>
                    <div class="row">
                        <div class="input-field col s12 center-align">
                            <select id="codiTipo" name="codiTipo" required> 
                            <option value="" disabled selected>Seleccione un tipo de denuncia</option>
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
                            <select id="codiCole" name="codiCole" required> 
                            <option value="" disabled selected>Seleccione el colegio para la denuncia</option>
                            <%
                                for(Colegios temp : new ColegiosCtrl().consTodo())
                                {

                            %> 
                            <option value="<%=temp.getCodiCole()%>"><%=temp.getNombCole()%></option>
                            <%
                                }
                            %>
                            </select>
                        </div>
                        <div class="input-field col s12 center-align">
                            <i class="material-icons prefix">comment</i>
                            <textarea id="descDenu" name="descDenu" class="materialize-textarea"></textarea>
                            <label for="descDenu">Descripción</label>
                        </div>
                        <div class="center-align">
                            <button class="btn waves-effect waves-light" type="submit" value="Crear" name="btonDenu">Ingresar<i class="material-icons right">send</i></button>
                        </div>
                        <div class="center-align">
                            <h5 class='red-text'>${mensAler}</h5>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
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
