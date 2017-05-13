/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.TipoDenuncia;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose Lira
 */
public class TipoDenunciaCtrl {
    public boolean guar(TipoDenuncia obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("insert into tipo_denuncias values (NULL, ?)");
            cmd.setString(1,obje.getNombTipo());
            cmd.executeUpdate();
            resp = true;
        } catch (Exception ex) {
            System.out.println("Error al guardar Tipo Denuncias: "+ex.getMessage() );
        }
        finally
        {
            try {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (SQLException err) {
                err.printStackTrace();
                        
            }
        }
        return resp;
    }
      public boolean modi(TipoDenuncia obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("update tipo_denuncias set nomb_tipo ='"+obje.getNombTipo()+"' where codi_tipo = "+obje.getCodiTipo()+"");
            cmd.executeUpdate();
            resp = true;
        } catch (Exception ex) {
            System.out.println("Error al modificar Tipo Denuncias: "+ex.getMessage() );
        }
        finally
        {
            try {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } catch (SQLException err) {
                err.printStackTrace();
                        
            }
        }
        return resp;
    }
    
    public List<TipoDenuncia>consTodo()
    {
        List<TipoDenuncia> resp = new ArrayList();
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("select * from tipo_denuncias");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new TipoDenuncia(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception err) {
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
    public boolean elim (TipoDenuncia obje)
    {
        boolean resp = false ;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("delete from tipo_denuncias where codi_tipo = ?");
            cmd.setString(1, String.valueOf(obje.getCodiTipo()));
            cmd.executeUpdate();
            resp = true;
        } catch (Exception ex) {
            System.out.println("Error al eliminar el tipo de denuncia "+ex.getMessage());
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
}
