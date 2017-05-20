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
public class UserLogin {
    private String idUser;
    private String namaUser;
    private String kataKunci;
    private String kewenangan;
    
    public UserLogin(String idUser, String namaUser, String kataKunci, String kewenangan){
        this.idUser = idUser;
        this.namaUser = namaUser;
        this.kataKunci = kataKunci;
        this.kewenangan = kewenangan;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getKataKunci() {
        return kataKunci;
    }

    public void setKataKunci(String kataKunci) {
        this.kataKunci = kataKunci;
    }

    public String getKewenangan() {
        return kewenangan;
    }

    public void setKewenangan(String kewenangan) {
        this.kewenangan = kewenangan;
    }
}
