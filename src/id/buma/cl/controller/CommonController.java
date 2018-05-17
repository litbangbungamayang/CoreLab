/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.controller;

import com.fazecast.jSerialComm.SerialPort;
import id.buma.cl.dao.IdAnalisaDAO;
import id.buma.cl.dao.IdAnalisaDAOSQL;
import id.buma.cl.dao.SampelTebuDAO;
import id.buma.cl.dao.SampelTebuDAOSQL;
import id.buma.cl.dao.TrukTebuDAO;
import id.buma.cl.dao.TrukTebuDAOSQL;
import id.buma.cl.dao.UserLoginDAO;
import id.buma.cl.dao.UserLoginDAOSQL;
import id.buma.cl.model.SampelTebu;
import id.buma.cl.model.TrukTebu;
import id.buma.cl.model.UserLogin;
import id.buma.cl.view.MainWindow;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.PrinterName;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */
public class CommonController implements MouseListener {

    static SerialPort chosenPort;
    private static SerialPort[] portNames = SerialPort.getCommPorts();
    private MainWindow mw;
    private SampelTebuDAO sampelTebuDao = new SampelTebuDAOSQL();
    private IdAnalisaDAO idAnalisaDao = new IdAnalisaDAOSQL();
    private TrukTebuDAO trukTebuDao = new TrukTebuDAOSQL();
    private UserLoginDAO userLoginDao = new UserLoginDAOSQL();
    public double hkBatasBawah = 70.0;
    public double hkBatasAtas = 74.0;
    public double rafaksi1 = 0.15;
    public double rafaksi2 = 0.30;
    public List<TrukTebu> arTrukTebu = new ArrayList<>();
    public List<SampelTebu> totalSampel;
    public List<SampelTebu> arCetakSampel;
    public TrukTebu trukTebu;
    public SampelTebu sampelBaru;
    public UserLogin userBaru;
    public java.util.Date periodeAnalisa;
    public DefaultListModel<String> listSampel = new DefaultListModel<>();
    /*****************************/
    /*      VARIABLE UMUM        */
    public int jmlSampel,jmlSampelNira,jmlSampelXds,jmlSampelHasil,seqNo; //variabel umum, nilainya berubah2
    public double hkPertama,hkKedua,hkRataan; //variabel umum, nilainya berubah2
    public String statusSampel; //variabel umum, nilainya berubah2
    public String statusNira; //variabel umum, nilainya berubah2
    public String systemOverrideStatus = "N"; //variabel umum, nilainya berubah2
    public String pathXds;
    public String idAnalisaSampelCake;
    public String versiSistem = "Corelab v.1.01.17052018.1428";
    /*
    * Corelab v.1.00.21052017.2015
    *   + Perubahan status TEBU DITOLAK, tercetak menjadi RAFAKSI 50%
    *   + Perubahan ukuran huruf untuk cetak DO dari semula 12 menjadi 14
    * Corelab v.1.00.23052017.1634
    *   + Perbaikan alur penerimaan HK tebu ulangan, sebelumnya apabila HK rata2 diatas HK batas atas, tetap kena rafaksi
    *     Setelah perbaikan tidak kena rafaksi
    *   + Pengamanan duplikasi ID Sampel Analisa
    * Corelab v.1.00.25052017.2107
    *   + Penambahan fitur insert ke tabel rafaksi di database timbangan
    *   + Setting ulang simpan status sampel
    * Corelab v.1.00.27052017.0637
    *   + Perbaikan monitoring sampel
    *   + Setting ulang simpan status sampel
    *   + Tambahkan insert untuk TBL_RAFAKSI_CS di database Timbangan
    * Corelab v.1.00.28052017.1558
    *   + Penambahan fitur cetak laporan harian (rakpitulasi)
    *   + Perbaikan monitoring sampel
    *   + Ganti icon untuk refresh data di monitoring sampel
    * Corelab v.1.00.04062017.2246
    *   + Penambahan fitur cetak laporan periodik
    *   + Penambahan fitur export ke excel
    * Corelab v.1.00.07062017.0445
    *   + Perbaikan status sampel DITOLAK menjadi RAFAKSI 50%
    *   + Tambahan notifikasi apabila set periode analisa dilakukan dua kali
    * Corelab v.1.00.09062017.0129
    *   + Perbaikan login user
    *   + Penambahan fitur cetak detail laporan harian
    * Corelab v.1.00.16062017.0533
    *   + Penambahan numerator saat cetak hasil analisa
    * Corelab v.1.00.21062017.0351
    *   + Penambahan laporan rafaksi hari ini
    * Corelab v.1.01.02072017.2318
    *   + REVISI MAYOR
    *   + Perubahan aturan rafaksi, HK < 70 rafaksi 30%, 70<= HK < 74 rafaksi 15% tidak perlu diulang
    * Corelab v.1.01.06072017.0423
    *   + Perubahan pencetakan hasil analisa, semula dicetak di DO, sekarang ditiadakan
    * Corelab v.1.01.08072017.0606
    *   + Rencana penambahan override sistem (blm selesai)
    *   + Penghapusan tampilan HK di layar monitor sampel
    * Corelab v.1.01.24082017.0309
    *   + Penambahan fungsi rekap rafaksi per petani
    *   + Penambahan fungsi pembatasan sampel nira
    * Corelab v.1.01.26092017.0924
    *   + Pengubahan data timbangan, inner join ke tabel rayon utk ambil data rayon
    * Corelab v.1.01.17052018.0826
    *   + Penambahan koneksi untuk SIMPG
    * Corelab v.1.01.17052018.1428
    *   + Perubahan pengambilan data truk tebu ke SIMPG
    */
    
    public void setVersiSistem(){
        mw.getLblVersiSistem().setText(versiSistem);
    }
    
    public void uploadNettoTimbangan(java.sql.Date tglPeriode){
        totalSampel = sampelTebuDao.getAllSampelTebu(tglPeriode,"Y");
        mw.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        for (SampelTebu st : totalSampel) {
            sampelTebuDao.updateNetto(st.getNumerator(), trukTebuDao.getNettoTruk(st.getNumerator()));
        }
        mw.setCursor(null);
        JOptionPane.showMessageDialog(mw, "Netto sudah terupdate!", "", JOptionPane.INFORMATION_MESSAGE);
        mw.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (sampelTebuDao.getAllRafaksi(tglPeriode) == true){
            JOptionPane.showMessageDialog(mw, "Data rafaksi sudah diupdate!");
        } else {
            JOptionPane.showMessageDialog(mw, "Data rafaksi gagal diupdate!");
        }
        mw.setCursor(null);
    }
    
    public void setProgressValue(int progressValue){
        mw.getPgbNetto().setValue(progressValue);
    }
    
    public void loginUser(){
        if (!mw.getTxtUsername().equals("") && !mw.getFtxtPassword().equals("")){
            userBaru = userLoginDao.getByUsername(mw.getTxtUsername().getText());
            if (userBaru != null){
                if (mw.getFtxtPassword().getText().equals(userBaru.getKataKunci())){
                    pageSwitcher(mw.getPnlMainWindowBawah(), "crdMainMenu");
                    mw.getLblUsername().setText(userBaru.getNamaUser());
                } else {
                    JOptionPane.showMessageDialog(mw, "Username atau password salah!", "", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(mw, "Username atau password salah!", "", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(mw, "Username atau password belum terisi!", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void setPeriodeAnalisa(){
        java.sql.Date periodeBaru = new java.sql.Date(mw.getDtpTglSetPeriode().getDate().getTime());
        java.sql.Date tglSekarang = new java.sql.Date(new Date().getTime());
        if (getPeriodeAnalisa().compareTo(periodeBaru) != 0){
            if (idAnalisaDao.setPeriodeAnalisa(periodeBaru) && idAnalisaDao.resetNumeratorAnalisa()){
                mw.getDtpTglMasuk().setDate(getPeriodeAnalisa());
                mw.getDtpTglPeriode().setDate(getPeriodeAnalisa());
                mw.getDtpTglSetPeriode().setDate(getPeriodeAnalisa());
                JOptionPane.showMessageDialog(mw, "Periode Analisa berhasil diubah!", "", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(mw, "Periode analisa sudah diganti!", "", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void bacaFileXds(String xdsFileName){
        int barisSampelId = 15;
        int kolomSampelId = 3;
        int kolomPol = 14;
        int kolomBrix = 11;
        try {
            FileInputStream inputStream = new FileInputStream(new File(xdsFileName));
            try {
                Workbook workbook = new HSSFWorkbook(inputStream);
                Sheet resultXds = workbook.getSheet("Results");
                HSSFRow row = (HSSFRow) resultXds.getRow(barisSampelId);
                while (row != null){
                    String idSampel = "";
                    HSSFCell cell = row.getCell(kolomSampelId);
                    idSampel = cell.getStringCellValue();
                    cell = row.getCell(kolomPol);
                    Double nilaiPol = cell.getNumericCellValue();
                    cell = row.getCell(kolomBrix);
                    Double nilaiBrix = cell.getNumericCellValue();
                    barisSampelId ++;
                    if (!idSampel.equals("")){
                        sampelTebuDao.updateDataXds(idSampel, nilaiBrix, nilaiPol, userBaru.getIdUser());
                    }                  
                    row = (HSSFRow) resultXds.getRow(barisSampelId);
                }
                File oldFile = new File(xdsFileName);
                File newFile = new File(xdsFileName+"saved");
                oldFile.delete();
            } catch (IOException ex){
                JOptionPane.showMessageDialog(mw, "Error baca file XDS! Error code : " + 
                        ex.toString(), "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (FileNotFoundException ex){
            JOptionPane.showMessageDialog(mw, "File tidak ditemukan!", "", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void cariFileXds(){
        File curDir = new File(getFolderXds());
        File[] filesList = curDir.listFiles();
        if (filesList.length > 0){
            for (File f : filesList){
                if (f.isFile() && f.getName().endsWith(".xls")){
                    bacaFileXds(f.getAbsolutePath());
                }
            }
        }
    }
        
    public String getFolderXds(){
        try {
            List<String> isiFile = new ArrayList<>();
            FileReader reader = new FileReader("Settings.txt");
            BufferedReader buffreader = new BufferedReader(reader);
            String line;
            while ((line = buffreader.readLine()) != null){
                isiFile.add(line);
            }
            int i = 0;
            while (i < isiFile.size()){
                if (isiFile.get(i).equals("XDS")){
                    return isiFile.get(i+1);
                }
                i++;
            }
        } catch (IOException ex){
            System.out.println(ex.toString());
        }
        return "";
    }
    
    public String bacaFileSetting(String settingParam){
        try {
            List<String> isiFile = new ArrayList<>();
            FileReader reader = new FileReader("Settings.txt");
            BufferedReader buffreader = new BufferedReader(reader);
            String line;
            while ((line = buffreader.readLine()) != null){
                isiFile.add(line);
            }
            int i = 0;
            while (i < isiFile.size()){
                if (isiFile.get(i).equals(settingParam)){
                    return isiFile.get(i+1);
                }
                i++;
            }
        } catch (IOException ex){
            JOptionPane.showMessageDialog(mw, "File settings.txt tidak ditemukan! Program akan shut-down!",
                    "", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return null;
    }
    
    public void simpanBeratAmpas(){
        int beratAmpas = 0;
        try {
            beratAmpas = Integer.parseInt(mw.getFtxtBeratSampel().getText().trim());
            if ((statusNira.equals("PRESS") && beratAmpas < sampelBaru.getAmpasBasah()) || statusNira.equals("CACAH")){
                if (sampelTebuDao.updateBeratAmpas(statusNira, sampelBaru.getIdAnalisa(),
                        beratAmpas, userBaru.getIdUser()) == true){
                    JOptionPane.showMessageDialog(mw, "Data berat ampas tersimpan!", "", JOptionPane.INFORMATION_MESSAGE);
                    resetLabel();
                }
            } else {
                JOptionPane.showMessageDialog(mw, "Cek kembali berat CAKE! \nBerat ampas CAKE diinput = " + 
                        beratAmpas+", Berat ampas SHREDDER = " + sampelBaru.getAmpasBasah(), "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(mw, "Error getAngkaTimbang! Error code : " +
                    ex.toString(), "", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cekComPort(){
        SerialPort comPort = SerialPort.getCommPort("COM7");
        comPort.openPort();
        InputStream in = comPort.getInputStream();
        comPort.closePort();
    }
    
    public void cekStatusTimbang(String idAnalisa){
        statusNira = "";
        sampelBaru = sampelTebuDao.getSampelByIdAnalisa(idAnalisa);
        if (sampelBaru != null){
            Double ampasBasah = sampelBaru.getAmpasBasah();
            Double ampasKering = sampelBaru.getAmpasKering();
            if ((ampasKering == 0.0) && (ampasBasah == 0.0)){
                mw.getLblStatusTimbang().setText("AMPAS SHREDDER");
                statusNira = "CACAH";
            } else {
                if ((ampasBasah != 0.0) && (ampasKering == 0.0)){
                    mw.getLblStatusTimbang().setText("CAKE");
                    statusNira = "PRESS";
                } else {
                    if ((ampasBasah != 0.0) && (ampasKering != 0.0)){
                        JOptionPane.showMessageDialog(mw, "Sampel ini sudah ditimbang!", "", JOptionPane.ERROR_MESSAGE);
                        resetLabel();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(mw, "Sampel tidak ditemukan!", "", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void setStatusTimbang(String statusTimbang){
        switch (statusTimbang){
            case "CACAH":
                mw.getLblStatusTimbang().setText("AMPAS SHREDDER");
                mw.getLblStatusTimbang().setBackground(Color.black);
                statusNira = "CACAH";
                break;
            case "PRESS":
                mw.getLblStatusTimbang().setText("CAKE");
                mw.getLblStatusTimbang().setBackground(Color.BLACK);
                mw.getLblStatusTimbang().setForeground(Color.WHITE);
                statusNira = "PRESS";
                break;
            case "TARRA":
                mw.getLblStatusTimbang().setText("TARRA TERLEBIH DAHULU!");
                mw.getLblStatusTimbang().setBackground(Color.red);
                statusNira = "TARRA";
                break;
        }
    }
    
    public void testPrinter(){
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String []fonts = g.getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++) {
            if(fonts[i].equals("Archon Code 39 Barcode")){
                System.out.println("Found!");
            }
        }
    }
    
    public void simpanStatusSampel(String numerator, String statSampel){
        switch (statSampel){
            case "LOLOS":
                trukTebuDao.konversiNumerator(numerator);
                sampelTebuDao.setCetakHasil(numerator);
                break;
            case "RAFAKSI":
                trukTebuDao.konversiNumerator(numerator);
                trukTebuDao.setRafaksi(numerator,rafaksi1,getPeriodeAnalisa());
                sampelTebuDao.setCetakHasil(numerator);
                break;
            case "TOLAK":
                trukTebuDao.konversiNumerator(numerator);
                trukTebuDao.setRafaksi(numerator, rafaksi2,getPeriodeAnalisa());
                sampelTebuDao.setCetakHasil(numerator);                
                break;
            case "BELUM ULANG":
                break;
        }
    }
    
    public boolean cetakLabel(String namaPrinter) throws PrinterException, ParseException{
        HashAttributeSet attributes = new HashAttributeSet();
        attributes.add(new PrinterName(namaPrinter,null));
        DocFlavor format = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        PrintService[] services = PrintServiceLookup.lookupPrintServices(format,attributes);
        if (services.length > 0 ){
            return mw.getTxpBarcode().print(null,null,false,services[0],null,false);
        } else {
            JOptionPane.showMessageDialog(mw, "Printer tidak ditemukan!", "Error Cetak ID", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public void simpanDataBaru(String idAnalisa) throws ParseException{
        if (idAnalisaDao.updateId() == true){
            if (simpanSampelBaru(idAnalisa) == true){
                refreshStatusPanel("TRUK");
                resetLabel();
                JOptionPane.showMessageDialog(mw, "Data berhasil disimpan!",
                        "Input Data",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(mw, "Data GAGAL disimpan!",
                        "Error Input Data",JOptionPane.ERROR_MESSAGE);
                resetLabel();
            }
        } else {
            JOptionPane.showMessageDialog(mw, "ID Analisa GAGAL diupdate!",
                "Error Input Data",JOptionPane.ERROR_MESSAGE);
            resetLabel();
        }    
    }
    
    public void preCekHasilAnalisa(String numerator) throws ParseException{
        statusSampel = "";
        String hasil = "";
        Double jmlHk = 0.0;
        Double hk1 = 0.0;
        Double hk2 = 0.0;
        Double hk = 0.0;
        java.util.Date kompTgl = mw.sqlDateFormat.parse("1900/01/01");
        java.util.Date tglData = null;
        arCetakSampel = sampelTebuDao.getSampelByNumeratorArray(numerator);
        if (arCetakSampel.size() == 1){
            tglData = arCetakSampel.get(0).getTgl_xds();
            if (tglData.compareTo(kompTgl) != 0){
                hk = arCetakSampel.get(0).getHk();
                if (hk >= hkBatasAtas){
                    hasil = numerator + "; CORE SAMPLER : OK";
                    statusSampel = "LOLOS";
                } else {
                    if ((hk < hkBatasAtas) && (hk >= hkBatasBawah)){
                        hasil = numerator + "; CORE SAMPLER : HK="+ hk + "; RAFAKSI 15%";
                        statusSampel = "RAFAKSI";
                    } else if (hk < hkBatasBawah){
                        hasil = numerator + "; CORE SAMPLER : HK="+ hk + "; RAFAKSI 30%";
                        statusSampel = "TOLAK";
                    }
                }
                simpanStatusSampel(numerator, statusSampel);
                refreshStatusPanel("TRUK");
            } else {
                JOptionPane.showMessageDialog(mw, "Hasil analisa belum tersedia!", "Error Update Hasil", JOptionPane.ERROR_MESSAGE);
                mw.getTxpBarcode().setText("");
                statusSampel = "BELUM";
            }
        }
    }
    
    public void overrideHasilAnalisa(String idAnalisa){
        
    }
    
    public void generateIdAnalisa() throws ParseException {
        DateFormat tglPeriode = new SimpleDateFormat("ddMMyyyy");
        String tglPeriodeId = tglPeriode.format(getPeriodeAnalisa());
        String idAnalisa = tglPeriodeId + idAnalisaDao.getLastId();
        DateFormat tglSkr = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String timeStampSkr = tglSkr.format(new Date());
        mw.getTxpBarcode().setText("");
        
        /* Barcode Settings */
        StyledDocument doc = mw.getTxpBarcode().getStyledDocument();
        Style style = mw.getTxpBarcode().addStyle("dualText", null);
        
        try {
            if (idAnalisaDao.cekDuplikatIdSampel(idAnalisa)){
                if (cekBatasSampel("NIRA") == true){
                    barcoding(idAnalisa, timeStampSkr, doc, style);
                    if (cetakLabel("PRINTER ID") == true){
                        simpanDataBaru(idAnalisa);
                    } else {
                        JOptionPane.showMessageDialog(mw, "Cetak ID Analisa gagal! ID belum tersimpan.",
                                "Error Cetak ID", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(mw, "Sampel nira tidak boleh lebih dari " +
                            sampelTebuDao.getBatasSampelNira() + " !");
                }
            } else {
                JOptionPane.showMessageDialog(mw, "Data ID Analisa sudah ada! Duplikasi sampel!");
            }
        } catch (HeadlessException | PrinterException | ParseException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void resetLabel(){
        mw.getTxtNumerator().setText("");
        mw.getLblNumerator().setText("");
        mw.getLblNoTarra().setText("");
        mw.getLblNopol().setText("");
        mw.getLblRayon().setText("");
        mw.getLblTsTr().setText("");
        mw.getTxpBarcode().setText("");
        mw.getLblAngkaTimbang().setText("");
        mw.getLblStatusTimbang().setText("");
        mw.getLblStatusTimbang().setBackground(Color.BLACK);
        mw.getFtxtKodeSampel().setText("");
        mw.getFtxtBeratSampel().setText("");
    }   
    
    public CommonController(MainWindow mw){
        this.mw = mw;
    }
    
    public void pageSwitcher(JPanel containerName,String cardName){
        CardLayout cl = (CardLayout) containerName.getLayout();
        cl.show(containerName, cardName);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        JPanel menuPanel = (JPanel) e.getSource();
        String menuName = menuPanel.getName();
        switch (menuName){
            case "pnlMenuIdTruk":
                if (userBaru.getKewenangan().equals("truk") ||
                    userBaru.getKewenangan().equals("admin") ||
                    userBaru.getKewenangan().equals("mandor"))
                {
                    pageSwitcher(mw.getPnlMainWindowBawah(), "crdIdTruk");
                    pageSwitcher(mw.getnPnlMultiFunctionIdTruk(), "crdSampleMonitor");
                    mw.getDtpTglMasuk().setDate(getPeriodeAnalisa());
                }
                break;
            case "pnlMenuNira":
                if (userBaru.getKewenangan().equals("nira") ||
                    userBaru.getKewenangan().equals("admin") ||
                    userBaru.getKewenangan().equals("mandor"))
                {
                    pageSwitcher(mw.getPnlMainWindowBawah(), "crdNira");
                }
                break;
            case "pnlMenuNir":
                if (userBaru.getKewenangan().equals("xds") ||
                    userBaru.getKewenangan().equals("admin") ||
                    userBaru.getKewenangan().equals("mandor"))
                {
                    pageSwitcher(mw.getPnlMainWindowBawah(), "crdXds");
                    mw.setTimerXds();
                }
                break;
            case "pnlMenuAdmin":
                if (userBaru.getKewenangan().equals("admin") ||
                    userBaru.getKewenangan().equals("mandor"))
                {
                    pageSwitcher(mw.getPnlMainWindowBawah(), "crdAdmin");
                }
                break;
            case "pnlMenuKeluar":
                System.exit(0);
                break;
            case "pnlHomeIdTruk":
                pageSwitcher(mw.getPnlMainWindowBawah(), "crdMainMenu");
                resetLabel();
                break;
            case "pnlHomeNira":
                pageSwitcher(mw.getPnlMainWindowBawah(), "crdMainMenu");
                break;
            case "pnlHomeXds":
                pageSwitcher(mw.getPnlMainWindowBawah(), "crdMainMenu");
                if (mw.tmrMonitoringXds.isRunning() == true){
                    mw.tmrMonitoringXds.stop();
                }
                break;
            case "pnlHomeAdmin":
                pageSwitcher(mw.getPnlMainWindowBawah(), "crdMainMenu");
                mw.getDtpTglPeriode().setDate(getPeriodeAnalisa());
                mw.getDtpTglSetPeriode().setDate(getPeriodeAnalisa());
                break;
            case "pnlMenuKeluarLogin":
                System.exit(0);
                break;
        }    
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JPanel menuPanel = (JPanel) e.getSource();
        String menuName = menuPanel.getName();
        switch (menuName){
            case "pnlMenuIdTruk":
                menuPanel.setBackground(new Color(1,155,155));
                break;
            case "pnlMenuNira":
                menuPanel.setBackground(new Color(191,142,12));
                break;
            case "pnlMenuNir":
                menuPanel.setBackground(new Color(100,221,23));
                break;
            case "pnlMenuAdmin":
                menuPanel.setBackground(new Color(230,196,0));
                break;
            case "pnlMenuKeluar":
                menuPanel.setBackground(new Color(230,196,0));
                break;
            case "pnlHomeIdTruk":
                menuPanel.setBackground(new Color(0,220,255));
                break;
            case "pnlHomeNira":
                menuPanel.setBackground(new Color(0,220,255));
                break;
            case "pnlHomeXds":
                menuPanel.setBackground(new Color(0,220,255));
                break;
            case "pnlHomeAdmin":
                menuPanel.setBackground(new Color(0,220,255));
                break;
            case "pnlMenuKeluarLogin":
                menuPanel.setBackground(new Color(230,196,0));
                break;
        }
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        JPanel menuPanel = (JPanel) e.getSource();
        String menuName = menuPanel.getName();
        switch (menuName){
            case "pnlMenuIdTruk":
                menuPanel.setBackground(new Color(1,87,155));
                break;
            case "pnlMenuNira":
                menuPanel.setBackground(new Color(191,54,12));
                break;
            case "pnlMenuNir":
                menuPanel.setBackground(new Color(100,137,23));
                break;
            case "pnlMenuAdmin":
                menuPanel.setBackground(new Color(230,81,0));
                break;
            case "pnlMenuKeluar":
                menuPanel.setBackground(new Color(230,81,0));
                break;
            case "pnlHomeIdTruk":
                menuPanel.setBackground(new Color(2,79,20));
                break;
            case "pnlHomeNira":
                menuPanel.setBackground(new Color(2,79,20));
                break;
            case "pnlHomeXds":
                menuPanel.setBackground(new Color(2,79,20));
                break;
            case "pnlHomeAdmin":
                menuPanel.setBackground(new Color(206,6,6));
                break;
            case "pnlMenuKeluarLogin":
                menuPanel.setBackground(new Color(230,81,0));
                break;
        }        
    }
    
    public KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            //e.setKeyChar(Character.toUpperCase(e.getKeyChar())); -> UPPERCASE
        }

        @Override
        public void keyPressed(KeyEvent e) {
            JFormattedTextField txtObj = (JFormattedTextField) e.getSource();
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_ENTER){
                try {
                    textFieldActionEnter(txtObj);
                } catch (ParseException ex) {
                    Logger.getLogger(CommonController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    };
    
    public KeyListener klTxt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            JTextField txtObj = (JTextField) e.getSource();
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_ENTER){
                try {
                    textFieldActionEnter(txtObj);
                } catch (ParseException ex) {
                    Logger.getLogger(CommonController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    };
    
    public void cekNumerator(int inputLen, String parsingTgl, 
            String inputText) throws ParseException{
        /*
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
        */
        //seqNo = idAnalisaDao.cekDuplikatSampel(numeratorSearch);
        seqNo = idAnalisaDao.cekDuplikatSampel(inputText);
        /****************** BY PASS SISTEM ***********************************/
        if (idAnalisaDao.getBypassStatus() == 1){
            //trukTebuDao.konversiNumerator(inputText);
        }
        /*===================================================================*/
        if (seqNo == 0){
            getTrukDetail(inputText);
        } else {
            JOptionPane.showMessageDialog(mw, "Sampel TIDAK PERLU DIULANG!", 
                    "Error Input", JOptionPane.ERROR_MESSAGE);
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
            }
            mw.getLblNumerator().setText(trukTebu.getNumerator());
            mw.getLblTsTr().setText(tstrTxt + "/" + trukTebu.getIdPetani());
            mw.getLblNoTarra().setText(trukTebu.getNoTarra());
            mw.getLblNopol().setText(trukTebu.getNoPolisi());
            mw.getLblRayon().setText(trukTebu.getRayon()+" / "+trukTebu.getAfd());
        } else {
            JOptionPane.showMessageDialog(mw, "Numerator " + numerator +
                    " tidak ditemukan!", "Error Input Data", JOptionPane.ERROR_MESSAGE);
            resetLabel();
        }
    }
    
    public void textFieldActionEnter(JTextField txt) throws ParseException{
        String txtName = txt.getName();
        String txtText = txt.getText().trim();
        if (txtName.equals("ftxtNumerator")){
            String parsingTgl = mw.numeratorFormat.format(mw.getDtpTglMasuk().getDate());
            cekNumerator(txtText.length(),parsingTgl,txtText);            
        }
        if (txtName.equals("txtNumerator")){
            String parsingTgl = mw.numeratorFormat.format(mw.getDtpTglMasuk().getDate());
            cekNumerator(txtText.length(),parsingTgl,txtText);            
        }
        if (txtName.equals("ftxtKodeSampel")){
            idAnalisaSampelCake = txtText;
            cekStatusTimbang(idAnalisaSampelCake);
        }
    }
    
    
    public ActionListener actCheckBox(JCheckBox ckb){
        String ckbName = ckb.getName();
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ckbName.equals("ckbSampaiDengan")){
                    if (ckb.isSelected()){
                        mw.getDtpCetakLaporan2().setEnabled(true);
                    } else {
                        mw.getDtpCetakLaporan2().setEnabled(false);
                    }
                } else
                if (ckbName.equals("ckbSystemOverride")){
                    if (userBaru.getKewenangan().equals("admin")){
                        if (ckb.isSelected()){
                            systemOverrideStatus = "Y";
                        } else {
                            systemOverrideStatus = "N";
                        }
                    }
                }
            }
        };
    }
    
    public ActionListener actButton(JButton btn){
        String btnName = btn.getName();
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnName.equals("btnManualId")){
                    pageSwitcher(mw.getnPnlMultiFunctionIdTruk(), "crdManualInput");
                }
                if (btnName.equals("btnBatalManualInput")){
                    pageSwitcher(mw.getnPnlMultiFunctionIdTruk(), "crdSampleMonitor");
                }
                if (btnName.equals("btnCetakId")){
                    if (!mw.getLblNumerator().getText().equals("")){
                        try {
                            generateIdAnalisa();
                        } catch (ParseException ex) {
                            JOptionPane.showMessageDialog(mw, "Error generateIdAnalisa!" +
                                    '\n' + "Error code : " + ex.toString(), "Error Input Data", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(mw, "Data numerator belum dimasukkan!", "Error Input", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (btnName.equals("btnCetakHasil")){
                    if (mw.getLstMonitoringSampel().getSelectedIndex() != -1){
                        try {
                            String numeratorHasil = totalSampel.get(mw.getLstMonitoringSampel().getSelectedIndex()).getNumerator();
                            preCekHasilAnalisa(numeratorHasil);
                        } catch (ParseException ex) {
                            Logger.getLogger(CommonController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if (btnName.equals("cekPrinter")){
                    
                }
                if (btnName.equals("btnLapHar")){
                    java.sql.Date tglLaporan1 = new java.sql.Date(mw.getDtpCetakLaporan1().getDate().getTime());                   
                    if (userBaru.getKewenangan().equals("admin")){
                        String detailStatus;
                        if (mw.getCkbRincian().isSelected()){
                            detailStatus = "YES";
                        } else {
                            detailStatus = "NO";
                        }
                        if (mw.getCkbRafaksi().isSelected()){
                            sampelTebuDao.cetakLaporanRafaksi(tglLaporan1);
                        } else {
                            if (mw.getCkbSampaiDengan().isSelected()){                           
                                java.sql.Date tglLaporan2 = new java.sql.Date(mw.getDtpCetakLaporan2().getDate().getTime());
                                sampelTebuDao.cetakLaporanPeriode(tglLaporan1, tglLaporan2);                    
                            } else {
                                sampelTebuDao.cetakLaporanHarian(tglLaporan1, detailStatus, sampelTebuDao.getTotalRafaksi(tglLaporan1));
                                //sampelTebuDao.cetakLaporanHarian(tglLaporan1, detailStatus, 100.0);
                            }
                        }
                    }
                }
                if (btnName.equals("btnSimpanAmpas")){
                    if (sampelBaru != null){
                        simpanBeratAmpas();
                    } else {
                        JOptionPane.showMessageDialog(mw, "Sampel tidak ditemukan!", "", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (btnName.equals("btnUploadNetto")){
                    if (userBaru.getKewenangan().equals("admin")){
                        java.sql.Date tglNetto = new java.sql.Date(mw.getDtpTglPeriode().getDate().getTime());
                        uploadNettoTimbangan(tglNetto);
                    }
                }
                if (btnName.equals("btnGantiPeriode")){
                    setPeriodeAnalisa();
                }
                if (btnName.equals("btnTesBasah")){
                    cekComPort();
                }
                if (btnName.equals("btnTesKering")){
                    mw.getLblAngkaTimbang().setText("675");
                }
                if (btnName.equals("btnLogin")){
                    loginUser();
                }
                if (btnName.equals("btnRefreshData")){
                    refreshStatusPanel("TRUK");
                }
            }
        };
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
                seqNo+1,
                mw.getLblNumerator().getText(),
                mw.getLblNoTarra().getText(),
                idAnalisa,
                mw.getLblNopol().getText(),
                trukTebu.getIdPetani(),
                trukTebu.getNoKebun(),
                getPeriodeAnalisa(),//periodeAnalisa
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
                versiSistem,
                "N"
            );
        return sampelTebuDao.insertInputData(sampelBaru);
    }
    
    public java.sql.Date getPeriodeAnalisa(){
        return idAnalisaDao.getPeriodeAnalisa();
    }
    
    public String cekStatusSampel(SampelTebu st) throws ParseException{
        java.util.Date komparasiTgl = mw.sqlDateFormat.parse("1900/01/01");
        if (st.getTgl_press().compareTo(komparasiTgl) == 0){
            return st.getNoAnalisa() + " [" + st.getNumerator() + "] [" + st.getNoTarra() + "] " + " [NIRA]";
        } else {
            if (st.getTgl_xds().compareTo(komparasiTgl) == 0){
                return st.getNoAnalisa() + " [" + st.getNumerator() + "] [" + st.getNoTarra() + "] " + " [XDS]";
            } else {
                if (st.getSeqNo() == 1){
                    hkPertama = st.getHk();
                    if ((hkPertama >= hkBatasBawah) && (hkPertama < hkBatasAtas)){
                        return st.getNoAnalisa() + " [" + st.getNumerator() + "] [" +
                                st.getNoTarra() + "] " + " BELUM DIUPDATE!";
                    } else {
                        if (hkPertama >= hkBatasAtas){
                            return st.getNoAnalisa() + " [" + st.getNumerator() + "] [" +
                                    st.getNoTarra() + "] " + " BELUM DIUPDATE!";
                        } else {
                            return st.getNoAnalisa() + " [" + st.getNumerator() + "] [" +
                                    st.getNoTarra() + "] " + " BELUM DIUPDATE!";
                        }
                    }
                }
            }
        }
        return "";
    }
    
    public int cekStatusNira(List<SampelTebu> semuaSampel) throws ParseException{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        int jml = 0;
        java.util.Date komparasiTgl = df.parse("1900-01-01");
        for (SampelTebu sampelTebu : semuaSampel){
            if (sampelTebu.getTgl_press().compareTo(komparasiTgl) == 0){
                jml ++;
            }
        }
        return jml;
    }
    
    public int cekStatusXds(List<SampelTebu> totalSampel) throws ParseException{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        int jml = 0;
        java.util.Date komparasiTgl = df.parse("1900-01-01");
        for (SampelTebu sampelTebu : totalSampel){
            if (sampelTebu.getTgl_xds().compareTo(komparasiTgl) == 0){
                jml ++;
            }
        }
        return jml;
    }
    
    public int cekStatusHasil(SampelTebu st) throws ParseException{
        int jml = 0;
        java.util.Date komparasiTgl = mw.sqlDateFormat.parse("1900/01/01");
        if (st.getTgl_xds().compareTo(komparasiTgl) != 0){
            jml ++;
        }
        return jml;
    }
    
    public void refreshStatusPanel(String namaPanel){
        int jmlSampelSkr,jmlSampelNiraSkr,jmlSampelXdsSkr;
        totalSampel = sampelTebuDao.getAllSampelTebu(getPeriodeAnalisa());
        jmlSampelNiraSkr = 0;
        jmlSampelXdsSkr = 0;
        jmlSampelSkr = totalSampel.size();
        listSampel = new DefaultListModel<>();
        for (SampelTebu sampelTebu : totalSampel) {
            try {
                listSampel.addElement(cekStatusSampel(sampelTebu));
                //jmlSampelNiraSkr = cekStatusNira(sampelTebu); //sampel yang sudah diinput di press
                //jmlSampelXdsSkr = cekStatusXds(sampelTebu); //sampel yang sudah dianalisa XDS
            } catch (ParseException ex) {
                Logger.getLogger(CommonController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (namaPanel.equals("TRUK")){
            mw.getLstMonitoringSampel().setModel(listSampel);
        } else {
            if (namaPanel.equals("NIRA")){
                mw.getLstMonitoringSampelNira().setModel(listSampel);
            }
        }
    }
    
    public boolean cekBatasSampel(String namaSampel) throws ParseException{
        totalSampel = sampelTebuDao.getAllSampelTebu(getPeriodeAnalisa());
        int batasSampelNira = sampelTebuDao.getBatasSampelNira();
        int batasSampelXds = sampelTebuDao.getBatasSampelXds();
        int sampelNira = cekStatusNira(totalSampel);
        int sampelXds = cekStatusXds(totalSampel);
        switch(namaSampel){
            case "NIRA" :
                if (sampelNira < batasSampelNira){return true;}
                break;
            case "XDS" :
                if (sampelXds < batasSampelXds){return true;}
                break;
        }
        return false;
    }
    
    public void barcoding(String idAnalisa, String timeStampSkr, StyledDocument doc, Style style){
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
    }
    
}
