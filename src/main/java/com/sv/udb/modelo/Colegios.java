/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author bernardo
 */
public class Colegios {
    private int codiCole;
    private String nombCole;
    private String direCole;
    private int infrCole;

    public Colegios() {
    }

    public Colegios(int codiCole, String nombCole, String direCole, int infrCole) {
        this.codiCole = codiCole;
        this.nombCole = nombCole;
        this.direCole = direCole;
        this.infrCole = infrCole;
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

    public String getDireCole() {
        return direCole;
    }

    public void setDireCole(String direCole) {
        this.direCole = direCole;
    }

    public int getInfrCole() {
        return infrCole;
    }

    public void setInfrCole(int infrCole) {
        this.infrCole = infrCole;
    }

    @Override
    public String toString() {
        return this.nombCole;
    }

}
