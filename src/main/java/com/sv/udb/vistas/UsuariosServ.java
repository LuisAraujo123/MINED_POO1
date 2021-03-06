/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.controlador.UsuariosCtrl;
import com.sv.udb.modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leyes
 */
@WebServlet(name = "UsuariosServ", urlPatterns = {"/UsuariosServ"})
public class UsuariosServ extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        boolean esValido = request.getMethod().equals("POST");
            String mens = "";
            if(!esValido){
                response.sendRedirect(request.getContextPath() + "/usuarios.jsp");
            }
            else{
                String CRUD = request.getParameter("btnConsulUsu");
                if(CRUD.equals("Consultar"))
                { 
                    int codi = Integer.parseInt(request.getParameter("codiLibrRadi").isEmpty() ? "-1" : request.getParameter("codiLibrRadi"));
                    Usuarios obje = new UsuariosCtrl().consI(codi);
                    if(obje != null)
                    {
                        request.setAttribute("codi", obje.getCodiE());
                        request.setAttribute("nombusu", obje.getNombrEmple());
                        request.setAttribute("nombEmpe", obje.getNombreE());
                        request.setAttribute("correo", obje.getCorreo());
                        request.setAttribute("dui", obje.getDui_emple());
                    }
                    else
                    {
                        mens = "Error al consultar";
                    }
                } 
                if(CRUD.equals("Modificar"))
                {
                    Usuarios obje = new Usuarios();
                    obje.setCodiE(Integer.parseInt(request.getParameter("codi")));
                    obje.setNombrEmple(request.getParameter("nombUsua"));
                    obje.setNombreE(request.getParameter("nombEmp"));
                    obje.setDui_emple(request.getParameter("duiEmple"));
                    obje.setCorreo(request.getParameter("corre"));
                    if(new UsuariosCtrl().updaDa(obje))
                    {mens = "Datos modifcados";

                    }
                    else
                    {
                        mens = "Error al modificar";
                    }
                }
                if(CRUD.equals("Eliminar"))
                {
                    Usuarios obje = new Usuarios();
                    int codi = Integer.parseInt(request.getParameter("codiLibrRadi").isEmpty() ? "-1" : request.getParameter("codiLibrRadi"));
                    obje.setCodiE(codi);
                    if(new UsuariosCtrl().elim(obje))
                    {
                        mens = "Datos eliminados";
                    }
                    else
                    {
                        mens = "Error al consultar";
                    }
                }
                
                request.setAttribute("mensAler",mens);
                request.getRequestDispatcher("/usuarios.jsp").forward(request, response);

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
