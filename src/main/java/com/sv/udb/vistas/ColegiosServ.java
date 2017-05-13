/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.controlador.ColegiosCtrl;
import com.sv.udb.modelo.Colegios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bernardo
 */
@WebServlet(name = "ColegiosServ", urlPatterns = {"/ColegiosServ"})
public class ColegiosServ extends HttpServlet {

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
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        else {
            try{
                String CRUD = request.getParameter("btonCole");
                if (CRUD.equals("Consultar"))
                {
                    //El operador unario sirve como if para validar que el radio buton este selecionado, si no lo esta devuelve -1
                    int codi = Integer.parseInt(request.getParameter("codiColeRadi").isEmpty() ? "-1" : request.getParameter("codiColeRadi"));
                    Colegios obje = new ColegiosCtrl().consUno(codi);
                    if (obje != null)
                    {
                        try {
                            request.setAttribute("codi", obje.getCodiCole());
                            request.setAttribute("nomb", obje.getNombCole());
                            request.setAttribute("dire", obje.getDireCole());
                            request.setAttribute("infr", obje.getInfrCole());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        mens = "Error al consultar";
                    }
                }
                else if  (CRUD.equals("Eliminar"))
                {
                    int codi = Integer.parseInt(request.getParameter("codiColeRadi").isEmpty() ? "-1" : request.getParameter("codiColeRadi"));
                    if (codi != -1)
                    {
                        Colegios obje = new Colegios();
                        obje.setCodiCole(codi);
                        if (new ColegiosCtrl().dele(obje))
                        {
                            mens = "Datos eliminados";
                            request.removeAttribute("codi");
                            request.removeAttribute("nomb");
                            request.removeAttribute("dire");
                            request.removeAttribute("infr");
                        }
                        else
                        {
                            request.removeAttribute("codi");
                            request.removeAttribute("nomb");
                            request.removeAttribute("dire");
                            request.removeAttribute("infr");
                            mens = "Error al eliminar";
                        }
                    }
                }
                else if (CRUD.equals("Modificar"))
                {
                    int codi = Integer.parseInt(request.getParameter("codi").isEmpty() ? "-1" : request.getParameter("codi"));
                    if (codi != -1)
                    {
                        Colegios obje = new Colegios();
                        obje.setCodiCole(codi);
                        obje.setNombCole(request.getParameter("nomb"));
                        obje.setDireCole(request.getParameter("dire"));
                        obje.setInfrCole(Integer.parseInt(request.getParameter("infr")));
                        if (new ColegiosCtrl().upda(obje))
                        {
                            mens = "Datos modificados";
                            request.removeAttribute("codi");
                            request.removeAttribute("nomb");
                            request.removeAttribute("dire");
                            request.removeAttribute("infr");
                        }
                        else
                        {
                            request.removeAttribute("codi");
                            request.removeAttribute("nomb");
                            request.removeAttribute("dire");
                            request.removeAttribute("infr");
                            mens = "Error al modificar";
                        }
                    }                   
                }
                request.setAttribute("mensAler", mens);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                
            }
            catch (Exception ex){
                System.err.println(ex.getMessage());
                ex.printStackTrace();
                request.getRequestDispatcher("/index.jsp").forward(request, response);
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
