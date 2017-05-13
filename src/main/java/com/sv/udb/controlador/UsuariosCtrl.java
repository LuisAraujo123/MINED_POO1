/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Usuarios;
import com.sv.udb.recursos.Conexion;
import com.sv.udb.utilidades.Encriptadora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leyes
 */
public class UsuariosCtrl {
    public boolean guar(Usuarios obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            Encriptadora gg = new Encriptadora();
            PreparedStatement cmd = cn.prepareStatement("INSERT INTO usuarios VALUES(NULL,?,?,?,?,?,?,?)");
            cmd.setString(1, obje.getNombreE());
            cmd.setString(2, obje.getNombrEmple());
            cmd.setString(3, String.valueOf(gg.encrypt(obje.getContraE())));
            cmd.setString(4, obje.getCorreo());
            cmd.setString(5, obje.getDui_emple());
            cmd.setString(6, String.valueOf(obje.getCodiPreE()));
            cmd.setString(7, obje.getRespuestaE());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al guardar Equipos: " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
    public List<Usuarios> consTodo()
    {
       List<Usuarios> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Usuarios(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
            }
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    } 
    
      public boolean elim(Usuarios obje)
    {
         boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("Delete from usuarios where codi_usua = ?");
            cmd.setString(1, String.valueOf(obje.getCodiE()));
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al eliminar el usuario " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
      
      public Usuarios cons(String codi)
    {
       Usuarios resp = null;
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("SELECT * FROM usuarios WHERE nomb_usua = ?");
            cmd.setString(1, codi);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
                resp = new Usuarios(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
            }
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    } 
      public Usuarios consI(int codi)
    {
       Usuarios resp = null;
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("SELECT * FROM usuarios WHERE codi_usua = ?");
            cmd.setInt(1, codi);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
                resp = new Usuarios(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
            }
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    } 
      
      
      
       public Usuarios consP(int codi)
    {
       Usuarios resp = null;
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("SELECT * FROM usuarios WHERE codi_preg = ?");
            cmd.setString(1, String.valueOf(codi));
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
                resp = new Usuarios(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
            }
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    } 
       
        public boolean upda(Usuarios obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("update usuarios set cont_usua = ? where codi_usua = ?");
            cmd.setString(1, obje.getContraE());
            cmd.setInt(2, obje.getCodiE());
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
        public Usuarios inicioSecion(String usu, String contra)
    {
       Usuarios resp = null;
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("SELECT * FROM usuarios WHERE nomb_usua = ? and cont_usua = ?");
            cmd.setString(1, usu);
            cmd.setString(2, contra);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
                resp = new Usuarios(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
            }
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    } 

        public boolean updaDa(Usuarios obje){
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("update usuarios set nomb_empl = ?,nomb_usua=?,	corr_usua=?,dui_empl=? where codi_usua = ?");
            cmd.setString(1, obje.getNombrEmple());
            cmd.setString(2, obje.getNombreE());
            cmd.setString(3, obje.getCorreo());
            cmd.setString(4, obje.getDui_emple());
            cmd.setInt(5, obje.getCodiE());
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
}
