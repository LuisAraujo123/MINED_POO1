/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Jose Lira
 */
public class TipoDenuncia {
    private int codiTipo;
    private String nombTipo;
    
    public TipoDenuncia(){
    }

    public TipoDenuncia(int codiTipo, String nombTipo) {
        this.codiTipo = codiTipo;
        this.nombTipo = nombTipo;
    }

    public int getCodiTipo() {
        return codiTipo;
    }

    public void setCodiTipo(int codiTipo) {
        this.codiTipo = codiTipo;
    }

    public String getNombTipo() {
        return nombTipo;
    }

    public void setNombTipo(String nombTipo) {
        this.nombTipo = nombTipo;
    }

    @Override
    public String toString() {
        return nombTipo;
    }
    
    
}
