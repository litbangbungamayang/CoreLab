/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.model;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */
public class TrukRafaksi {
    private String numerator;
    private Double jenisRafaksi;
    private java.util.Date periode;
    
    public TrukRafaksi(String numerator, Double jenisRafaksi, java.util.Date periode){
        this.numerator = numerator;
        this.jenisRafaksi = jenisRafaksi;
        this.periode = periode;
    }

    public String getNumerator() {
        return numerator;
    }

    public void setNumerator(String numerator) {
        this.numerator = numerator;
    }

    public Double getJenisRafaksi() {
        return jenisRafaksi;
    }

    public void setJenisRafaksi(Double jenisRafaksi) {
        this.jenisRafaksi = jenisRafaksi;
    }

    public java.util.Date getPeriode() {
        return periode;
    }

    public void setPeriode(java.util.Date periode) {
        this.periode = periode;
    }
    
}
