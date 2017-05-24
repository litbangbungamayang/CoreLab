/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.controller;

import id.buma.cl.dao.IdAnalisaDAOSQL;
import id.buma.cl.dao.IdAnalisaDAO;
import id.buma.cl.dao.SampelTebuDAO;
import id.buma.cl.dao.SampelTebuDAOSQL;
import id.buma.cl.dao.TrukTebuDAO;
import id.buma.cl.dao.TrukTebuDAOSQL;
import id.buma.cl.model.SampelTebu;
import id.buma.cl.model.TrukTebu;
import id.buma.cl.model.UserLogin;
import id.buma.cl.view.MainWindow;
import java.awt.HeadlessException;
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author  Bayu Anandavi Muhardika
 */
public class RegistrasiTruk {
    
    private MainWindow mw;
    private IdAnalisaDAO idAnalisaDao = new IdAnalisaDAOSQL();
    private SampelTebuDAO sampelTebuDao = new SampelTebuDAOSQL();
    private TrukTebuDAO trukTebuDao = new TrukTebuDAOSQL();
    private CommonController commonController;
    public TrukTebu trukTebu;
    public SampelTebu sampelBaru;
    public UserLogin userBaru;
    
    /* Variabel umum */
    private int seqNo;
    public double hkBatasAtas = 74.00;
    public double hkBatasBawah = 70.00;
    public List<TrukTebu> arTrukTebu = new ArrayList<>();
    /*===============*/
    
    public RegistrasiTruk(MainWindow mw){
        this.mw = mw;
    }
    
    public RegistrasiTruk(){
        
    }
    
    public boolean cekInputNumerator(){
        return !mw.getLblNumerator().getText().equals("");
    }
    
    public void generateIdAnalisa(){
        if (cekInputNumerator()){
            DateFormat tglPeriode = new SimpleDateFormat("ddMMyyyy");
            String tglPeriodeId;
            tglPeriodeId = tglPeriode.format(commonController.getPeriodeAnalisa());
            String idAnalisa = tglPeriodeId+idAnalisaDao.getLastId();
            DateFormat tglSkr = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            String timeStampSkr = tglSkr.format(new Date());
            mw.getTxpBarcode().setText("");

            /* BARCODING */
            StyledDocument doc = mw.getTxpBarcode().getStyledDocument();
            Style style = mw.getTxpBarcode().addStyle("dualText", null);

            StyleConstants.setFontFamily(style, "Calibri");
            StyleConstants.setFontSize(style, 16);
            try{
                doc.insertString(doc.getLength(), "Lab. Core Sampler" + '\n' + '\n', style);
            } catch (BadLocationException ex){}

            StyleConstants.setFontFamily(style, "Free 3 of 9");
            StyleConstants.setFontSize(style, 36);
            try{
                doc.insertString(doc.getLength(), "*"+idAnalisa+"*", style);
            } catch (BadLocationException ex){}

            StyleConstants.setFontFamily(style, "Consolas");
            StyleConstants.setFontSize(style, 18);
            try{
                doc.insertString(doc.getLength(),'\n'+idAnalisa+'\n', style);
            } catch (BadLocationException ex){}

            StyleConstants.setFontFamily(style, "Consolas");
            StyleConstants.setFontSize(style, 12);
            try{
                doc.insertString(doc.getLength(),timeStampSkr, style);
            } catch (BadLocationException ex){}
            try {
                if (idAnalisaDao.cekDuplikatIdSampel(idAnalisa)){
                    if (commonController.cetakLabel("PRINTER ID") == true){
                        simpanDataBaru(idAnalisa);
                    } else {
                        JOptionPane.showMessageDialog(mw, "Cetak ID Analisa gagal! ID belum tersimpan.",
                                "Error Cetak ID", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (HeadlessException | PrinterException | ParseException ex){
                System.out.println(ex.toString());
            }
        }
    }
    
    public void simpanDataBaru(String idAnalisa) throws ParseException{
        if (idAnalisaDao.updateId() == true){
            if (simpanSampelBaru(idAnalisa) == true){
                commonController.refreshStatusPanel("TRUK");
                commonController.resetLabel();
                JOptionPane.showMessageDialog(mw, "Data berhasil disimpan!",
                        "Input Data",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(mw, "Data GAGAL disimpan!",
                        "Error Input Data",JOptionPane.ERROR_MESSAGE);
                commonController.resetLabel();
            }
        } else {
            JOptionPane.showMessageDialog(mw, "ID Analisa GAGAL diupdate!",
                "Error Input Data",JOptionPane.ERROR_MESSAGE);
            commonController.resetLabel();
        }    
    }
    
    public boolean simpanSampelBaru(String idAnalisa) throws ParseException{
        String tstr = "";
        java.util.Date tglSkrg = new java.util.Date();
        java.util.Date tglKosong = mw.sqlDateFormat.parse("1900/01/01");
        java.util.Date jamKosong = mw.sqlTimeFormat.parse("00:00");
        switch (trukTebu.getTstr()){
            case 1:
                tstr = "TS";
                break;
            case 2:
                tstr = "TR";
                break;
            case 3:
                tstr = "TRB";
                break;
            case 4:
                tstr = "TSI";
                break;
        }
        sampelBaru = new SampelTebu(
                idAnalisa,
                seqNo + 1,
                mw.getLblNumerator().getText(),
                mw.getLblNoTarra().getText(),
                idAnalisa,
                mw.getLblNopol().getText(),
                trukTebu.getIdPetani(),
                trukTebu.getNoKebun(),
                commonController.getPeriodeAnalisa(),//periodeAnalisa
                trukTebu.getRayon(),//Afd
                tstr,
                tglSkrg,//tglInput
                tglSkrg,//jamInput
                tglKosong,//tglPress
                jamKosong,//jamPress
                tglKosong,//tglXds
                jamKosong,//jamXds
                null,//brix
                null,//pol
                null,//hk
                null,//ampasBasah
                null,//ampasKering
                null,//nira
                null,//knpp
                null,//nnpp
                null,//netto
                userBaru.getIdUser(),
                null,
                null,
                commonController.versiSistem,
                "N"
            );
        if (sampelTebuDao.insertInputData(sampelBaru) == true){
            return true;
        }
        return false;
    }
    
    public void cekNumerator(int inputLen, String parsingTgl, 
            String inputText) throws ParseException{
        String numeratorSearch = null;
        double hkNum;
        switch (inputText.length()){
            case 1:
                numeratorSearch = parsingTgl+"00000"+inputText;
                break;
            case 2:
                numeratorSearch = parsingTgl+"0000"+inputText;
                break;
            case 3:
                numeratorSearch = parsingTgl+"000"+inputText;
                break;
            case 4:
                numeratorSearch = parsingTgl+"00"+inputText;
                break;
            case 5:
                numeratorSearch = parsingTgl+"0"+inputText;
                break;
            case 6:
                numeratorSearch = parsingTgl+inputText;
                break;
        }
        seqNo = idAnalisaDao.cekDuplikatSampel(numeratorSearch);
        /****************** BY PASS SISTEM ***********************************/
        if (idAnalisaDao.getBypassStatus() == 1){
            trukTebuDao.konversiNumerator(numeratorSearch);
        }
        /*===================================================================*/
        if (seqNo == 0){
            getTrukDetail(numeratorSearch);
        } else {
            if (seqNo == 1){
                java.util.Date tglXds = sampelTebuDao.getSampelByNumerator(numeratorSearch).getTgl_xds();
                if (tglXds.compareTo(mw.sqlDateFormat.parse("1900/01/01")) != 0){
                hkNum = sampelTebuDao.getHkSampelByNumerator(numeratorSearch);
                    if ((hkNum >= hkBatasBawah) && (hkNum < hkBatasAtas)){
                        getTrukDetail(numeratorSearch);
                    } else {
                        if (hkNum < hkBatasBawah){
                            JOptionPane.showMessageDialog(mw, "Tebu DITOLAK!"+'\n'+
                                    "HK sampel sebelumnya KURANG DARI 70!", "",
                                    JOptionPane.WARNING_MESSAGE);
                            commonController.resetLabel();
                        }
                        if (hkNum >= hkBatasAtas){
                            JOptionPane.showMessageDialog(mw, "Sampel TIDAK PERLU DIULANG!", "",
                                    JOptionPane.WARNING_MESSAGE);
                            commonController.resetLabel();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(mw, "Hasil analisa belum tersedia!", "", JOptionPane.ERROR_MESSAGE);
                    commonController.resetLabel();
                }
            } else {
                JOptionPane.showMessageDialog(mw, "Sampel TIDAK BOLEH LEBIH DARI 2!", "", JOptionPane.WARNING_MESSAGE);
                commonController.resetLabel();
            }
        }
    }
    
    public void getTrukDetail(String numerator){
        arTrukTebu = trukTebuDao.getDataTimbangan(numerator);
        int recCount = arTrukTebu.size();
        if (recCount == 1){
            trukTebu = arTrukTebu.get(0);        
            int tstr = trukTebu.getTstr();
            String tstrTxt = null;
            switch (tstr){
                case 1:
                    tstrTxt = "TS";
                    break;
                case 2:
                    tstrTxt = "TR";
                    break;
                case 3:
                    tstrTxt = "KUT";
                    break;
                case 4:
                    tstrTxt = "TSI";
                    break;
            }
            mw.getLblTsTr().setText(tstrTxt);
            //mw.getLblNumerator().setText(trukTebu.getNumerator());     
            /*
            mw.getLblTsTr().setText(tstrTxt + "/" + trukTebu.getIdPetani());
            mw.getLblNoTarra().setText(trukTebu.getNoTarra());
            mw.getLblNopol().setText(trukTebu.getNoPolisi());
            mw.getLblRayon().setText(trukTebu.getRayon()+" / "+trukTebu.getAfd());
            */
        } else {
            JOptionPane.showMessageDialog(mw, "Numerator " + numerator +
                    " tidak ditemukan!", "Error Input Data", JOptionPane.ERROR_MESSAGE);
            commonController.resetLabel();
        }
    }
    
}
