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
public class Informes {
    private int codiInfo;
    private int codiDenu;
    private int codiAuto;
    private String descDenu;
    private String nombAuto;
    private Date fechInfo;
    private boolean chlaInfo;
    private String descInfo;

    public Informes() {
    }

    public Informes(int codiInfo, int codiDenu, int codiAuto, String descDenu, String nombAuto, Date fechInfo, boolean chlaInfo, String descInfo) {
        this.codiInfo = codiInfo;
        this.codiDenu = codiDenu;
        this.codiAuto = codiAuto;
        this.descDenu = descDenu;
        this.nombAuto = nombAuto;
        this.fechInfo = fechInfo;
        this.chlaInfo = chlaInfo;
        this.descInfo = descInfo;
    }

    public int getCodiInfo() {
        return codiInfo;
    }

    public void setCodiInfo(int codiInfo) {
        this.codiInfo = codiInfo;
    }

    public int getCodiDenu() {
        return codiDenu;
    }

    public void setCodiDenu(int codiDenu) {
        this.codiDenu = codiDenu;
    }

    public int getCodiAuto() {
        return codiAuto;
    }

    public void setCodiAuto(int codiAuto) {
        this.codiAuto = codiAuto;
    }

    public String getDescDenu() {
        return descDenu;
    }

    public void setDescDenu(String descDenu) {
        this.descDenu = descDenu;
    }

    public String getNombAuto() {
        return nombAuto;
    }

    public void setNombAuto(String nombAuto) {
        this.nombAuto = nombAuto;
    }

    public Date getFechInfo() {
        return fechInfo;
    }

    public void setFechInfo(Date fechInfo) {
        this.fechInfo = fechInfo;
    }

    public boolean isChlaInfo() {
        return chlaInfo;
    }

    public void setChlaInfo(boolean chlaInfo) {
        this.chlaInfo = chlaInfo;
    }

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo;
    }

    @Override
    public String toString() {
        return this.descInfo;
    }
    
}
