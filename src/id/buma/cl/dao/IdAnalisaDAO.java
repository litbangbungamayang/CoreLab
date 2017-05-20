/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.dao;

/**
 *
 * @author Bayu Anandavi Muhardika
 */
public interface IdAnalisaDAO {
    
    public String getLastId();
    
    public Boolean updateId();
    
    public int cekDuplikatSampel(String numerator);
    
    public java.sql.Date getPeriodeAnalisa();
    
    public boolean setPeriodeAnalisa(java.sql.Date tglPeriodeBaru);
    
    public boolean resetNumeratorAnalisa();
    
    public int getBypassStatus();
    
}
