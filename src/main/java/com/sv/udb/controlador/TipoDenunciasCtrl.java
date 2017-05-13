/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.TipoDenuncias;
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
public class TipoDenunciasCtrl {
    public boolean guar(TipoDenuncias obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("INSERT INTO tipo_denuncias VALUES(NULL, ?)");
            cmd.setString(1, obje.getNombTipo());
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
    
    public boolean upda(TipoDenuncias obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("update tipo_denuncias set nomb_tipo = ? where codi_tipo = ?");
            cmd.setString(1, obje.getNombTipo());
            cmd.setInt(2, obje.getCodiTipo());
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
    
    public boolean dele(TipoDenuncias obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("delete from tipo_denuncias where codi_tipo = ?");
            cmd.setInt(1, obje.getCodiTipo());
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
    
    
    
    public List<TipoDenuncias> consTodo(){
        List<TipoDenuncias> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("Select * from tipo_denuncias");
            ResultSet rs = cmd.executeQuery();
            while (rs.next())
            {
                resp.add(new TipoDenuncias(rs.getInt(1), rs.getString(2)));
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
    
    public TipoDenuncias consUno(int id){
        TipoDenuncias resp = null;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("Select * from tipo_denuncias where codi_tipo = ?");
            cmd.setInt(1, id);
            ResultSet rs = cmd.executeQuery();
            if (rs.next())
            {
                resp = (new TipoDenuncias(rs.getInt(1), rs.getString(2)));
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
