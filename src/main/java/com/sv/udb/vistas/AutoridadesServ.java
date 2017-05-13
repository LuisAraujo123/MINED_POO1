/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.AutoridadesCtrl;
import com.sv.udb.modelo.Autoridades;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Jose Lira
 */
@MultipartConfig
@WebServlet(name = "AutoridadesServ", urlPatterns = {"/AutoridadesServ"})
public class AutoridadesServ extends HttpServlet {

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
        if(!esValido)
        {
            response.sendRedirect(request.getContextPath()+"/Autoridades.jsp");
        }
        else
        {
            String CRUD = request.getParameter("btonAuto");
            if(CRUD.equals("Guardar"))
            {
            Autoridades obje = new Autoridades();
            obje.setNombAuto(request.getParameter("nomb"));
            obje.setDireAuto(request.getParameter("dire"));
            obje.setExtrAuto(request.getParameter("extr"));
            obje.setNumeAuto(request.getParameter("nume"));
            if(new AutoridadesCtrl().guar(obje))
            {
                
                mens = "Datos Guardados";
            }
            else
            {
                mens = "Error al guardar";
            }
            }
            else if(CRUD.equals("Consultar"))
            {
                int codi= Integer.parseInt(request.getParameter("codiAutRadi").isEmpty() ? "-1" : request.getParameter("codiAutRadi"));
                Autoridades obje  = new AutoridadesCtrl().consUno(codi);
                if(obje != null)
                {
                request.setAttribute("codi", obje.getCodiAuto());                
                request.setAttribute("nomb", obje.getNombAuto());                
                request.setAttribute("dire", obje.getDireAuto()); 
                request.setAttribute("extr", obje.getExtrAuto()); 
                request.setAttribute("nume", obje.getNumeAuto()); 
                mens = "Información consultada";
                }
                else 
                {
                    mens= "Error al consultar";
                }
            }
            else if (CRUD.equals("Eliminar"))
            {
             Autoridades obje = new Autoridades();
             obje.setCodiAuto(Integer.parseInt(request.getParameter("codi")));
            if(new AutoridadesCtrl().elim(obje))
            {
                mens = "Dato Eliminado";
            }
            else
            {
                mens = "Error al Eliminar";
            }
            }
            else if (CRUD.equals("Modificar"))
            {
                Autoridades obje = new Autoridades();
                //int codi= Integer.parseInt(request.getParameter("codi").isEmpty() ? "-1" : request.getParameter("codi"));
                //obje.setCodiEqui(codi);
                obje.setCodiAuto(Integer.parseInt(request.getParameter("codi")));
                obje.setNombAuto(request.getParameter("nomb"));
                obje.setDireAuto(request.getParameter("dire"));
                obje.setExtrAuto(request.getParameter("extr"));
                obje.setNumeAuto(request.getParameter("nume"));
                
                if(new AutoridadesCtrl().modi(obje))
                {
                    mens = "Datos Modificados";
                }
                else
                {
                    mens = "Error al Modificar";
                }
            }
            else if(CRUD.equals("Nuevo"))
            {
                request.setAttribute("codi", null);
                request.setAttribute("nomb", "");
                request.setAttribute("dire", "");
                request.setAttribute("extr", "");
                request.setAttribute("nume", "");
            }
            
            request.setAttribute("mensAler",mens);
            request.getRequestDispatcher("/Autoridades.jsp").forward(request, response);
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
