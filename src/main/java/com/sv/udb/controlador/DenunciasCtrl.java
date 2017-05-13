/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Denuncias;
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
public class DenunciasCtrl {
    public boolean guar(Denuncias obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("INSERT INTO denuncias VALUES(NULL, ?, ?, ?, ?, ?, now(), default)");
            cmd.setString(1, obje.getCorrDenu());
            cmd.setInt(2, obje.getCodiTipo());
            cmd.setInt(3, obje.getCodiCole());
            cmd.setString(4, obje.getDescDenu());
            cmd.setBoolean(5, false);
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
    
    public boolean upda(Denuncias obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("update denuncias set corr_denu = ?, codi_tipo = ?, codi_cole = ?, desc_denu = ?, viab_denu = ? where codi_denu = ?;");
            cmd.setString(1, obje.getCorrDenu());
            cmd.setInt(2, obje.getCodiTipo());
            cmd.setInt(3, obje.getCodiCole());
            cmd.setString(4, obje.getDescDenu());
            cmd.setBoolean(5, obje.isViabDenu());
            cmd.setInt(6, obje.getCodiDenu());
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
    
    public boolean dele(Denuncias obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("delete from denuncias where codi_denu = ?");
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
    
    
    
    public List<Denuncias> consTodo(){
        List<Denuncias> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("Select codi_denu, denuncias.codi_tipo, nomb_tipo, denuncias.codi_cole, nomb_cole, desc_denu, viab_denu, fech_denu, esta_denu from denuncias inner join tipo_denuncias on denuncias.codi_tipo = tipo_denuncias.codi_tipo inner join colegios on denuncias.codi_cole = colegios.codi_cole;");
            ResultSet rs = cmd.executeQuery();
            while (rs.next())
            {
                resp.add(new Denuncias(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getBoolean(8), rs.getDate(9), rs.getBoolean(10)));
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
    
    public Denuncias consUno(int id){
        Denuncias resp = null;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("Select codi_denu, denuncias.codi_tipo, nomb_tipo, denuncias.codi_cole, nomb_cole, desc_denu, viab_denu, fech_denu, esta_denu from denuncias inner join tipo_denuncias on denuncias.codi_tipo = tipo_denuncias.codi_tipo inner join colegios on denuncias.codi_cole = colegios.codi_cole and denuncias.codi_denu = ?;");
            cmd.setInt(1, id);
            ResultSet rs = cmd.executeQuery();
            if (rs.next())
            {
                resp = new Denuncias(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getBoolean(8), rs.getDate(9), rs.getBoolean(10));
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
