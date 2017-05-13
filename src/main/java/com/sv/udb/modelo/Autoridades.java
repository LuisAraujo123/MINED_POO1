/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author DanielWilfredo
 */
public class Autoridades {
    
    private int codiAuto;
    private String nombAuto;
    private String direAuto;
    private String extrAuto;
    private String numeAuto;

    public String getNumeAuto() {
        return numeAuto;
    }

    public void setNumeAuto(String numeAuto) {
        this.numeAuto = numeAuto;
    }

    public int getCodiAuto() {
        return codiAuto;
    }

    public void setCodiAuto(int codiAuto) {
        this.codiAuto = codiAuto;
    }

    public String getNombAuto() {
        return nombAuto;
    }

    public void setNombAuto(String nombAuto) {
        this.nombAuto = nombAuto;
    }

    public String getDireAuto() {
        return direAuto;
    }

    public void setDireAuto(String direAuto) {
        this.direAuto = direAuto;
    }

    public String getExtrAuto() {
        return extrAuto;
    }

    public void setExtrAuto(String extrAuto) {
        this.extrAuto = extrAuto;
    }
    
    public Autoridades()
    {
    }

    public Autoridades(int codiAuto, String nombAuto, String direAuto, String extrAuto, String numeAuto) {
        this.codiAuto = codiAuto;
        this.nombAuto = nombAuto;
        this.direAuto = direAuto;
        this.extrAuto = extrAuto;
        this.numeAuto = numeAuto;
    }

     @Override
    public String toString() {
        return this.nombAuto;
    }
    
    
}
