/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Informes;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bernardo
 */
public class InformesCtrl {
    public boolean guar(Informes obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("INSERT INTO informes VALUES(NULL, ?, ?, now(), ?, ?)");
            cmd.setInt(1, obje.getCodiAuto());
            cmd.setInt(2, obje.getCodiDenu());
            cmd.setBoolean(3, obje.isChlaInfo());
            cmd.setString(4, obje.getDescInfo());
            cmd.executeUpdate();
            resp = true;
            
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        finally 
        {
            try 
            {
                if (cn!=null)
                {
                    if (!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } 
            catch (Exception e) 
            {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return resp;
    }
    
    public boolean upda(Informes obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("update informes set codi_auto = ?, chla_info = ?, desc_info = ? where codi_info = ?;");
            cmd.setInt(1, obje.getCodiAuto());
            cmd.setBoolean(2, obje.isChlaInfo());
            cmd.setString(3, obje.getDescInfo());
            cmd.setInt(4, obje.getCodiInfo());
            cmd.executeUpdate();
            resp = true;
            
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        finally 
        {
            try 
            {
                if (cn!=null)
                {
                    if (!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } 
            catch (Exception e) 
            {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return resp;
    }
    
    public boolean dele(Informes obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("delete from Informes where codi_info = ?");
            cmd.setInt(1, obje.getCodiDenu());
            cmd.executeUpdate();
            resp = true;
            
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        finally 
        {
            try 
            {
                if (cn!=null)
                {
                    if (!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } 
            catch (Exception e) 
            {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return resp;
    }
    
    
    
    public List<Informes> consTodo(){
        List<Informes> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select codi_info, informes.codi_auto, informes.codi_denu, desc_denu, nomb_auto, fech_info, chla_info, desc_info from informes inner join denuncias on informes.codi_denu = denuncias.codi_denu inner join autoridades on informes.codi_auto = autoridades.codi_auto;");
            ResultSet rs = cmd.executeQuery();
            while (rs.next())
            {
                resp.add(new Informes(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getBoolean(7), rs.getString(8)));
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        finally 
        {
            try 
            {
                if (cn!=null)
                {
                    if (!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } 
            catch (Exception e) 
            {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return resp;
    }
    
    public Informes consUno(int id){
        Informes resp = null;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select codi_info, informes.codi_auto, informes.codi_denu, desc_denu, nomb_auto, fech_info, chla_info, desc_info from informes inner join denuncias on informes.codi_denu = denuncias.codi_denu inner join autoridades on informes.codi_auto = autoridades.codi_auto and informes.codi_info = ?;");
            cmd.setInt(1, id);
            ResultSet rs = cmd.executeQuery();
            if (rs.next())
            {
                resp = (new Informes(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getBoolean(7), rs.getString(8)));
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        finally 
        {
            try 
            {
                if (cn!=null)
                {
                    if (!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } 
            catch (Exception e) 
            {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return resp;
    }
}
