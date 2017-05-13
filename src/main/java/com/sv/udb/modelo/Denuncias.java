/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.sql.Date;

/**
 *
 * @author bernardo
 */
public class Denuncias {
    private int codiDenu;
    private String corrDenu;
    private int codiTipo;
    private String nombTipo;
    private int codiCole;
    private String nombCole;
    private String descDenu;
    private boolean viabDenu;
    private Date fechDenu;  
    private boolean estaDenu;  
    
    public Denuncias() {
        
    }

    public Denuncias(int codiDenu, String corrDenu, int codiTipo, String nombTipo, int codiCole, String nombCole, String descDenu, boolean viabDenu, Date fechDenu, boolean estaDenu) {
        this.codiDenu = codiDenu;
        this.corrDenu = corrDenu;
        this.codiTipo = codiTipo;
        this.nombTipo = nombTipo;
        this.codiCole = codiCole;
        this.nombCole = nombCole;
        this.descDenu = descDenu;
        this.viabDenu = viabDenu;
        this.fechDenu = fechDenu;
        this.estaDenu = estaDenu;
    }

    public String getCorrDenu() {
        return corrDenu;
    }

    public void setCorrDenu(String corrDenu) {
        this.corrDenu = corrDenu;
    }
    
    public int getCodiCole() {
        return codiCole;
    }

    public void setCodiCole(int codiCole) {
        this.codiCole = codiCole;
    }

    public String getNombCole() {
        return nombCole;
    }

    public void setNombCole(String nombCole) {
        this.nombCole = nombCole;
    }
    
    public String getNombTipo() {
        return nombTipo;
    }

    public void setNombTipo(String nombTipo) {
        this.nombTipo = nombTipo;
    }

    public int getCodiDenu() {
        return codiDenu;
    }

    public void setCodiDenu(int codiDenu) {
        this.codiDenu = codiDenu;
    }

    public int getCodiTipo() {
        return codiTipo;
    }

    public void setCodiTipo(int codiTipo) {
        this.codiTipo = codiTipo;
    }

    public String getDescDenu() {
        return descDenu;
    }

    public void setDescDenu(String descDenu) {
        this.descDenu = descDenu;
    }

    public boolean isViabDenu() {
        return viabDenu;
    }

    public void setViabDenu(boolean viabDenu) {
        this.viabDenu = viabDenu;
    }

    public Date getFechDenu() {
        return fechDenu;
    }

    public void setFechDenu(Date fechDenu) {
        this.fechDenu = fechDenu;
    }

    public boolean isEstaDenu() {
        return estaDenu;
    }

    public void setEstaDenu(boolean estaDenu) {
        this.estaDenu = estaDenu;
    }
    
    @Override
    public String toString() {
        return this.descDenu;
    }
}
