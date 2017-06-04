/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.dao;

import id.buma.cl.model.SampelTebu;
import java.util.List;

/**
 *
 * @author Bayu Anandavi Muhardika
 */
public interface SampelTebuDAO {
        
    public boolean insertInputData (SampelTebu st);
    
    public boolean insertDataPress (SampelTebu st);
    
    public boolean insertDataXds (SampelTebu st);
    
    public List<SampelTebu> getAllSampelTebu(java.util.Date periode);
    
    public List<SampelTebu> getAllSampelTebu(java.util.Date periode, String cetakHasil);
           
    public List<SampelTebu> getAllSampelTebu();
    
    public List<SampelTebu> getByIdAnalisa(String idAnalisa);
    
    public List<SampelTebu> getByIdPetani(String idPetani);
    
    public List<SampelTebu> getByIdKebun(String idKebun);
    
    public double getHkSampelByNumerator(String numerator);
    
    public double getHkSampelByIdAnalisa(String idAnalisa);
    
    public double getHkSampelKeduaByNumerator(String numerator);
    
    public SampelTebu getSampelByNumerator(String numerator);
    
    public List<SampelTebu> getSampelByNumeratorArray(String numerator);
    
    public boolean setCetakHasil(String numerator);
    
    public SampelTebu getSampelByIdAnalisa(String idAnalisa);
    
    public boolean updateBeratAmpas(String statusNira,String idAnalisa,int beratAmpas, String idUser);
    
    public boolean updateDataXds(String idAnalisa, Double nilaiBrix, Double nilaiPol, String idUser);
    
    public boolean updateNetto(String numerator,int netto);
    
    public void cetakLaporanHarian(java.sql.Date tglLaporan);
    
    public void cetakLaporanHarianXls(java.sql.Date tglLaporan);
    
    public void cetakLaporanPeriode(java.sql.Date tglAwal, java.sql.Date tglAkhir);
    
}
