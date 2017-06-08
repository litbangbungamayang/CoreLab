/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.controller;

import javax.swing.SwingWorker;
import id.buma.cl.dao.SampelTebuDAO;
import id.buma.cl.dao.TrukTebuDAO;
import id.buma.cl.model.SampelTebu;
import id.buma.cl.view.MainWindow;
import java.util.List;

/**
 *
 * @author Bayu Anandavi Muhardika
 */
public class NettoInput extends SwingWorker<Void, Void>{
    private CommonController cc;
    private MainWindow mw;
    private SampelTebuDAO sampelTebuDao;
    private List<SampelTebu> totalSampel;
    private TrukTebuDAO trukTebuDao;
    
    @Override
    public Void doInBackground() throws Exception {
        java.sql.Date tglPeriode = cc.getPeriodeAnalisa();
        totalSampel = sampelTebuDao.getAllSampelTebu(tglPeriode, "Y");
        int progress = 0;
        setProgress(0);
        for (SampelTebu st : totalSampel){
            sampelTebuDao.updateNetto(st.getNumerator(), trukTebuDao.getNettoTruk(st.getNumerator()));
            setProgress(progress++);
            
        }
        return null;
    }
    
}
