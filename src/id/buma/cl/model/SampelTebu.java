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
public class SampelTebu {
    private String idAnalisa;
    private int seqNo;
    private String numerator;
    private String noTarra;
    private String noAnalisa;
    private String noPolisi;
    private String idPetani;
    private String noKebun;
    private java.util.Date periode;
    private String rayon;
    private String tstr;
    private java.util.Date tgl_input;
    private java.util.Date jam_input;
    private java.util.Date tgl_press;
    private java.util.Date jam_press;
    private java.util.Date tgl_xds;
    private java.util.Date jam_xds;
    private Double brix;
    private Double pol;
    private Double hk;
    private Double ampasBasah;
    private Double ampasKering;
    private Double nira;
    private Double knpp;
    private Double nnpp;
    private Integer netto;
    private String idUserInput;
    private String idUserPress;
    private String idUserXds;
    private String versiSistem;
    private String cetakHasil;
    
    public SampelTebu( String idAnalisa,int seqNo,String numerator,String noTarra,
            String noAnalisa,String noPolisi,String idPetani,String noKebun,
            java.util.Date periode,String rayon,String tstr,java.util.Date tgl_input,java.util.Date jam_input,
            java.util.Date tgl_press,java.util.Date jam_press,
            java.util.Date tgl_xds,java.util.Date jam_xds,
            Double brix,Double pol,Double hk,
            Double ampasBasah,Double ampasKering,Double nira,
            Double knpp,Double nnpp,Integer netto,String idUserInput,
            String idUserPress,String idUserXds,String versiSistem, String cetakHasil){
        this.idAnalisa = idAnalisa;
        this.seqNo = seqNo;
        this.numerator = numerator;
        this.noTarra = noTarra;
        this.noAnalisa = noAnalisa;
        this.noPolisi = noPolisi;
        this.idPetani = idPetani;
        this.noKebun = noKebun;
        this.periode = periode;
        this.rayon = rayon;
        this.tstr = tstr;
        this.tgl_input = tgl_input;
        this.jam_input = jam_input;
        this.tgl_press = tgl_press;
        this.jam_press = jam_press;
        this.tgl_xds = tgl_xds;
        this.jam_xds = jam_xds;
        this.brix = brix;
        this.pol = pol;
        this.hk = hk;
        this.ampasBasah = ampasBasah;
        this.ampasKering = ampasKering;
        this.nira = nira;
        this.knpp = knpp;
        this.nnpp = nnpp;
        this.netto = netto;
        this.idUserInput = idUserInput;
        this.idUserPress = idUserPress;
        this.idUserXds = idUserXds;
        this.versiSistem = versiSistem;
        this.cetakHasil = cetakHasil;
    }

    public String getIdAnalisa() {
        return idAnalisa;
    }

    public void setIdAnalisa(String idAnalisa) {
        this.idAnalisa = idAnalisa;
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

    public String getNoAnalisa() {
        return noAnalisa;
    }

    public void setNoAnalisa(String noAnalisa) {
        this.noAnalisa = noAnalisa;
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

    public Double getBrix() {
        return brix;
    }

    public void setBrix(Double brix) {
        this.brix = brix;
    }

    public Double getPol() {
        return pol;
    }

    public void setPol(Double pol) {
        this.pol = pol;
    }

    public Double getHk() {
        return hk;
    }

    public void setHk(Double hk) {
        this.hk = hk;
    }

    public Double getAmpasBasah() {
        return ampasBasah;
    }

    public void setAmpasBasah(Double ampasBasah) {
        this.ampasBasah = ampasBasah;
    }

    public Double getAmpasKering() {
        return ampasKering;
    }

    public void setAmpasKering(Double ampasKering) {
        this.ampasKering = ampasKering;
    }

    public Double getNira() {
        return nira;
    }

    public void setNira(Double nira) {
        this.nira = nira;
    }

    public Double getKnpp() {
        return knpp;
    }

    public void setKnpp(Double knpp) {
        this.knpp = knpp;
    }

    public Double getNnpp() {
        return nnpp;
    }

    public void setNnpp(Double nnpp) {
        this.nnpp = nnpp;
    }

    public Integer getNetto() {
        return netto;
    }

    public void setNetto(Integer netto) {
        this.netto = netto;
    }

    public String getIdUserInput() {
        return idUserInput;
    }

    public void setIdUserInput(String idUserInput) {
        this.idUserInput = idUserInput;
    }

    public String getIdUserPress() {
        return idUserPress;
    }

    public void setIdUserPress(String idUserPress) {
        this.idUserPress = idUserPress;
    }

    public String getIdUserXds() {
        return idUserXds;
    }

    public void setIdUserXds(String idUserXds) {
        this.idUserXds = idUserXds;
    }

    public String getVersiSistem() {
        return versiSistem;
    }

    public void setVersiSistem(String versiSistem) {
        this.versiSistem = versiSistem;
    }

    public java.util.Date getPeriode() {
        return periode;
    }

    public java.util.Date getTgl_input() {
        return tgl_input;
    }

    public java.util.Date getJam_input() {
        return jam_input;
    }

    public java.util.Date getTgl_press() {
        return tgl_press;
    }

    public java.util.Date getJam_press() {
        return jam_press;
    }

    public java.util.Date getTgl_xds() {
        return tgl_xds;
    }

    public java.util.Date getJam_xds() {
        return jam_xds;
    }

    public String getCetakHasil() {
        return cetakHasil;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public void setPeriode(java.util.Date periode) {
        this.periode = periode;
    }

    public void setTgl_input(java.util.Date tgl_input) {
        this.tgl_input = tgl_input;
    }

    public void setJam_input(java.util.Date jam_input) {
        this.jam_input = jam_input;
    }

    public void setTgl_press(java.util.Date tgl_press) {
        this.tgl_press = tgl_press;
    }

    public void setJam_press(java.util.Date jam_press) {
        this.jam_press = jam_press;
    }

    public void setTgl_xds(java.util.Date tgl_xds) {
        this.tgl_xds = tgl_xds;
    }

    public void setJam_xds(java.util.Date jam_xds) {
        this.jam_xds = jam_xds;
    }

    public void setCetakHasil(String cetakHasil) {
        this.cetakHasil = cetakHasil;
    }

    public String getRayon() {
        return rayon;
    }

    public void setRayon(String rayon) {
        this.rayon = rayon;
    }

    public String getTstr() {
        return tstr;
    }

    public void setTstr(String tstr) {
        this.tstr = tstr;
    }
}
