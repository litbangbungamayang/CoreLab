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
public class IdAnalisa {
    private String idAnalisaLast;
    private String idAnalisaNew;
    
    public IdAnalisa(String idAnalisaLast,String idAnalisaNew){
        this.idAnalisaLast = idAnalisaLast;
        this.idAnalisaNew = idAnalisaNew;
    }

    public String getIdAnalisaLast() {
        return idAnalisaLast;
    }

    public void setIdAnalisaLast(String idAnalisaLast) {
        this.idAnalisaLast = idAnalisaLast;
    }

    public String getIdAnalisaNew() {
        return idAnalisaNew;
    }

    public void setIdAnalisaNew(String idAnalisaNew) {
        this.idAnalisaNew = idAnalisaNew;
    }
    
}
