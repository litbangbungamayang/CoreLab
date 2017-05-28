/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.dao;

import id.buma.cl.model.SampelTebu;
import id.buma.cl.model.TrukTebu;
import java.util.List;

/**
 *
 * @author Bayu Anandavi Muhardika
 */
public interface TrukTebuDAO {
    
    public List<TrukTebu> getDataTimbangan(String numerator);
    
    public boolean konversiNumerator(String numerator);
    
    public boolean setRafaksi(String numerator, double jenisRafaksi, java.sql.Date periodeAnalisa);
    
    public boolean getNettoTruk(java.sql.Date periode, List<SampelTebu> st);
    
    public int getNettoTruk(String numerator);
        
}
