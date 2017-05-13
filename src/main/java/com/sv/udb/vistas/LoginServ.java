/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.controlador.UsuariosCtrl;
import com.sv.udb.modelo.Usuarios;
import com.sv.udb.utilidades.Encriptadora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bernardo
 */
@WebServlet(name = "LoginServ", urlPatterns = {"/LoginServ"})
public class LoginServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean esValido = request.getMethod().equals("POST");
        String mens = "";
        System.err.println("Entra al process");
        if(!esValido)
        {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
        else {
            try{
                String CRUD = request.getParameter("btonLogi");
                if (CRUD.equals("Loguear"))
                {
                    //El operador unario sirve como if para validar que el radio buton este selecionado, si no lo esta devuelve -1
                    String usua = request.getParameter("usua").isEmpty() ? "" : request.getParameter("usua");
                    String contra = request.getParameter("pass").isEmpty() ? "" : request.getParameter("pass");
                    Usuarios obje = new UsuariosCtrl().cons(usua);
                    if (obje != null)
                    {
                        try {
                            Encriptadora encr = new Encriptadora();
                            contra = encr.encrypt(contra);
                            if(contra.equals(obje.getContraE()))
                            {
                                HttpSession session = request.getSession(true);
                                session.setAttribute("usuaActu", usua);
                                request.getRequestDispatcher("/index.jsp").forward(request, response);
                            }
                            else    
                            {
                                mens = "Contraseña incorrecta";
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        mens = "El usuario no existe";
                    }
                }
                else if  (CRUD.equals("Recuperar"))
                {
                    
                }
                else
                {
                    request.setAttribute("mensAler", mens);
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            }
            catch (Exception ex){
                System.err.println(ex.getMessage());
                ex.printStackTrace();
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
