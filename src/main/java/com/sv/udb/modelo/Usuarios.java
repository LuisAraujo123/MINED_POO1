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
    private String nombreE;
    private String contraE;
    private String Correo;
    private int codiPreE;

    @Override
    public String toString() {
        return this.nombreE ;
    }

    public Usuarios(int codiE, String nombreE, String contraE, String Correo, int codiPreE, String respuestaE) {
        this.codiE = codiE;
        this.nombreE = nombreE;
        this.contraE = contraE;
        this.Correo = Correo;
        this.codiPreE = codiPreE;
        this.respuestaE = respuestaE;
    }

    public Usuarios() {
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

    public String getContraE() {
        return contraE;
    }

    public void setContraE(String contraE) {
        this.contraE = contraE;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
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
    private String respuestaE;

    
}
