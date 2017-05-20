/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.model;

/**
 *
 * @author Bayu Anandavi Muhardika
 */
public class TrukTebu {
    private String numerator;
    private String noTarra;
    private String noPolisi;
    private String idPetani;
    private String noKebun;
    private Integer netto;
    private java.util.Date periode;
    private int tstr;
    private String rayon;
    private String afd;
    
    public TrukTebu(String numerator,String noTarra,String noPolisi,
            String idPetani,String noKebun,Integer netto,java.util.Date periode,
            int tstr,String rayon,String afd){
        this.numerator = numerator;
        this.noTarra = noTarra;
        this.noPolisi = noPolisi;
        this.idPetani = idPetani;
        this.noKebun = noKebun;
        this.netto = netto;
        this.periode = periode;
        this.tstr = tstr;
        this.rayon = rayon;
        this.afd = afd;
    }

    public String getNumerator() {
        return numerator;
    }

    public void setNumerator(String numerator) {
        this.numerator = numerator;
    }

    public String getNoTarra() {
        return noTarra;
    }

    public void setNoTarra(String noTarra) {
        this.noTarra = noTarra;
    }

    public String getNoPolisi() {
        return noPolisi;
    }

    public void setNoPolisi(String noPolisi) {
        this.noPolisi = noPolisi;
    }

    public String getIdPetani() {
        return idPetani;
    }

    public void setIdPetani(String idPetani) {
        this.idPetani = idPetani;
    }

    public String getNoKebun() {
        return noKebun;
    }

    public void setNoKebun(String noKebun) {
        this.noKebun = noKebun;
    }

    public Integer getNetto() {
        return netto;
    }

    public void setNetto(Integer netto) {
        this.netto = netto;
    }

    public java.util.Date getPeriode() {
        return periode;
    }

    public void setPeriode(java.util.Date periode) {
        this.periode = periode;
    }

    public int getTstr() {
        return tstr;
    }

    public void setTstr(int tstr) {
        this.tstr = tstr;
    }

    public String getRayon() {
        return rayon;
    }

    public void setRayon(String rayon) {
        this.rayon = rayon;
    }

    public String getAfd() {
        return afd;
    }

    public void setAfd(String afd) {
        this.afd = afd;
    }
    
}
