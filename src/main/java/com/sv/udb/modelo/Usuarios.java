/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author leyes
 */
public class Usuarios {
    private int codiE;
    private String nombrEmple;
    private String nombreE;
    private String contraE;
    private String correo;
    private String dui_emple;
    private int codiPreE;
    private String respuestaE;

    public Usuarios(int codiE, String nombrEmple, String nombreE, String contraE, String Correo, String dui_emple, int codiPreE, String respuestaE) {
        this.codiE = codiE;
        this.nombrEmple = nombrEmple;
        this.nombreE = nombreE;
        this.contraE = contraE;
        this.correo = Correo;
        this.dui_emple = dui_emple;
        this.codiPreE = codiPreE;
        this.respuestaE = respuestaE;
    }

    @Override
    public String toString() {
        return this.nombreE;
    }

    public int getCodiE() {
        return codiE;
    }

    public void setCodiE(int codiE) {
        this.codiE = codiE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getNombrEmple() {
        return nombrEmple;
    }

    public void setNombrEmple(String nombrEmple) {
        this.nombrEmple = nombrEmple;
    }

    public String getDui_emple() {
        return dui_emple;
    }

    public void setDui_emple(String dui_emple) {
        this.dui_emple = dui_emple;
    }

    public String getContraE() {
        return contraE;
    }

    public void setContraE(String contraE) {
        this.contraE = contraE;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String Correo) {
        this.correo = Correo;
    }

    public int getCodiPreE() {
        return codiPreE;
    }

    public void setCodiPreE(int codiPreE) {
        this.codiPreE = codiPreE;
    }

    public String getRespuestaE() {
        return respuestaE;
    }

    public void setRespuestaE(String respuestaE) {
        this.respuestaE = respuestaE;
    }

    public Usuarios() {
    }

    
    

    
    
}
