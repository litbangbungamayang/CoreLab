/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.view;

import id.buma.cl.controller.CommonController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Bayu Anandavi Muhardika
 */
public class MainWindow extends javax.swing.JFrame {

    
    private CommonController commonController = new CommonController(this);
    private KeyListener txtKl = commonController.kl;
    public DateFormat sqlDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    public DateFormat sqlTimeFormat = new SimpleDateFormat("HH:mm");
    public DateFormat numeratorFormat = new SimpleDateFormat("ddMMyy");
    public DateFormat displayDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public DateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public Timer tmrMonitoring, tmrMonitoringXds;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        /*
            SETTING MAIN WINDOW
        */
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        commonController.pageSwitcher(pnlMainWindowBawah, "crdLogin");
        dtpTglMasuk.setFormats(displayDateFormat);
        dtpTglPeriode.setFormats(displayDateFormat);
        dtpMasukManual.setFormats(displayDateFormat);
        dtpTglSetPeriode.setFormats(displayDateFormat);
        //dtpTglMasuk.setDate(new java.util.Date());/* NOTE : ganti dengan sistem */
        dtpTglMasuk.setDate(commonController.getPeriodeAnalisa());
        dtpTglPeriode.setDate(commonController.getPeriodeAnalisa());
        dtpTglSetPeriode.setDate(commonController.getPeriodeAnalisa());
        setMenuAction();
        setAction();
        setTimer();
        commonController.getPeriodeAnalisa();
        commonController.refreshStatusPanel("NIRA");
        commonController.refreshStatusPanel("TRUK");
        lblPathXds.setText(commonController.bacaFileSetting("XDS"));
        commonController.setVersiSistem();
        //lblPathXds.setText(commonController.getFolderXds());
        //JOptionPane.showMessageDialog(this, commonController.bacaFileSetting("Database"), "", JOptionPane.INFORMATION_MESSAGE);
        /************************* DISABLED ITEMS ****************************/
        btnManualId.setVisible(false);
        btnCrosscheckManual.setVisible(false);
        btnCekPrinter.setVisible(false);
        btnTesBasah.setVisible(false);
        btnTesKering.setVisible(false);
        lblAngkaTimbang.setVisible(false);
        pgbNetto.setVisible(false);
    }
    
    
    public void setTimerXds(){
        tmrMonitoringXds = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commonController.cariFileXds();
            }
        });
        tmrMonitoringXds.start();
    }
    
    public void setTimer(){
        tmrMonitoring = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commonController.refreshStatusPanel("NIRA");
            }
        });
        tmrMonitoring.start();
    }
    
    public void setMenuAction(){
        pnlMenuIdTruk.addMouseListener(commonController);
        pnlMenuNira.addMouseListener(commonController);
        pnlMenuNir.addMouseListener(commonController);
        pnlMenuAdmin.addMouseListener(commonController);
        pnlMenuKeluar.addMouseListener(commonController);
        pnlHomeIdTruk.addMouseListener(commonController);
        pnlHomeNira.addMouseListener(commonController);
        pnlHomeXds.addMouseListener(commonController);
        pnlHomeAdmin.addMouseListener(commonController);
        pnlMenuKeluarLogin.addMouseListener(commonController);
    }
    
    public void setAction(){
        ftxtNumerator.addKeyListener(txtKl);
        ftxtKodeSampel.addKeyListener(txtKl);
        btnManualId.addActionListener(commonController.actButton(btnManualId));
        btnBatalManualInput.addActionListener(commonController.actButton(btnBatalManualInput));
        btnCetakId.addActionListener(commonController.actButton(btnCetakId));
        btnCetakHasilAnalisa.addActionListener(commonController.actButton(btnCetakHasilAnalisa));
        btnCekPrinter.addActionListener(commonController.actButton(btnCekPrinter));
        btnSimpanAmpas.addActionListener(commonController.actButton(btnSimpanAmpas));
        btnUploadNetto.addActionListener(commonController.actButton(btnUploadNetto));
        btnGantiPeriode.addActionListener(commonController.actButton(btnGantiPeriode));
        btnTesBasah.addActionListener(commonController.actButton(btnTesBasah));
        btnTesKering.addActionListener(commonController.actButton(btnTesKering));
        btnLogin.addActionListener(commonController.actButton(btnLogin));
        btnRefreshData.addActionListener(commonController.actButton(btnRefreshData));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainWindowAtas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlMainWindowBawah = new javax.swing.JPanel();
        pnlMainMenu = new javax.swing.JPanel();
        pnlMenuIdTruk = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlMenuNira = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlMenuNir = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnlMenuAdmin = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pnlMenuKeluar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        lblVersiSistem = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        pnlIdTruk = new javax.swing.JPanel();
        pnlIdTrukMenuAtas = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pnlHomeIdTruk = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        pnlIdTrukContent = new javax.swing.JPanel();
        pnlMultiFunction = new javax.swing.JPanel();
        pnlManualInput = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtNoTarraManual = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        lblNopolManual = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        dtpMasukManual = new org.jdesktop.swingx.JXDatePicker();
        btnSimpanManualInput = new javax.swing.JButton();
        btnBatalManualInput = new javax.swing.JButton();
        pnlSampleMonitor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstMonitoringSample = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btnCetakHasilAnalisa = new javax.swing.JButton();
        btnCrosscheckManual = new javax.swing.JButton();
        btnCekPrinter = new javax.swing.JButton();
        btnRefreshData = new javax.swing.JButton();
        pnlIdTrukReg = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        ftxtNumerator = new javax.swing.JFormattedTextField();
        dtpTglMasuk = new org.jdesktop.swingx.JXDatePicker();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblNumerator = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblTsTr = new javax.swing.JLabel();
        lblNoTarra = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblNopol = new javax.swing.JLabel();
        lblRayon = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnCetakId = new javax.swing.JButton();
        btnManualId = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txpBarcode = new javax.swing.JTextPane();
        pnlNira = new javax.swing.JPanel();
        pnlNiraMenuAtas = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        pnlHomeNira = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        pnlNiraContent = new javax.swing.JPanel();
        pnlInputBerat = new javax.swing.JPanel();
        pnlInputKodeSampelNira = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        ftxtKodeSampel = new javax.swing.JFormattedTextField();
        lblStatusTimbang = new javax.swing.JLabel();
        btnSimpanAmpas = new javax.swing.JButton();
        pnlInputKodeSampelNira1 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        ftxtBeratSampel = new javax.swing.JFormattedTextField();
        btnTesBasah = new javax.swing.JButton();
        btnTesKering = new javax.swing.JButton();
        lblAngkaTimbang = new javax.swing.JLabel();
        pnlSampelMonitorNira = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstMonitoringSampelNira = new javax.swing.JList<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        pnlXds = new javax.swing.JPanel();
        pnlXdsMenuAtas = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        pnlHomeXds = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        lblPathXds = new javax.swing.JLabel();
        pnlAdmin = new javax.swing.JPanel();
        pnlIdTrukMenuAtas1 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        pnlHomeAdmin = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        dtpTglPeriode = new org.jdesktop.swingx.JXDatePicker();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        btnUploadNetto = new javax.swing.JButton();
        pgbNetto = new javax.swing.JProgressBar();
        jPanel6 = new javax.swing.JPanel();
        dtpTglSetPeriode = new org.jdesktop.swingx.JXDatePicker();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        btnGantiPeriode = new javax.swing.JButton();
        pnlLogin = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        ftxtPassword = new javax.swing.JPasswordField();
        pnlMenuKeluarLogin = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        setForeground(java.awt.Color.white);
        setLocationByPlatform(true);
        setName("frmUtama"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        pnlMainWindowAtas.setBackground(new java.awt.Color(5, 153, 39));
        pnlMainWindowAtas.setForeground(new java.awt.Color(5, 153, 39));
        pnlMainWindowAtas.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        pnlMainWindowAtas.setPreferredSize(new java.awt.Dimension(596, 100));

        jLabel2.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo putih atas.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/text_coresampler.png"))); // NOI18N
        jLabel3.setAlignmentY(0.0F);

        javax.swing.GroupLayout pnlMainWindowAtasLayout = new javax.swing.GroupLayout(pnlMainWindowAtas);
        pnlMainWindowAtas.setLayout(pnlMainWindowAtasLayout);
        pnlMainWindowAtasLayout.setHorizontalGroup(
            pnlMainWindowAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainWindowAtasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlMainWindowAtasLayout.setVerticalGroup(
            pnlMainWindowAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );

        pnlMainWindowBawah.setBackground(new java.awt.Color(255, 255, 255));
        pnlMainWindowBawah.setLayout(new java.awt.CardLayout());

        pnlMainMenu.setBackground(new java.awt.Color(250, 250, 250));

        pnlMenuIdTruk.setBackground(new java.awt.Color(1, 87, 155));
        pnlMenuIdTruk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuIdTruk.setName("pnlMenuIdTruk"); // NOI18N
        pnlMenuIdTruk.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlMenuIdTruk.setLayout(new javax.swing.BoxLayout(pnlMenuIdTruk, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img_truk.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuIdTruk.add(jLabel1);

        jLabel4.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("identitas truk tebu");
        jLabel4.setMaximumSize(new java.awt.Dimension(200, 26));
        jLabel4.setPreferredSize(new java.awt.Dimension(200, 26));
        pnlMenuIdTruk.add(jLabel4);

        pnlMenuNira.setBackground(new java.awt.Color(191, 54, 12));
        pnlMenuNira.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuNira.setName("pnlMenuNira"); // NOI18N
        pnlMenuNira.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlMenuNira.setLayout(new javax.swing.BoxLayout(pnlMenuNira, javax.swing.BoxLayout.Y_AXIS));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img_hydpress.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuNira.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("data nira");
        jLabel6.setMaximumSize(new java.awt.Dimension(200, 26));
        jLabel6.setPreferredSize(new java.awt.Dimension(200, 26));
        pnlMenuNira.add(jLabel6);

        pnlMenuNir.setBackground(new java.awt.Color(100, 137, 23));
        pnlMenuNir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuNir.setName("pnlMenuNir"); // NOI18N
        pnlMenuNir.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlMenuNir.setLayout(new javax.swing.BoxLayout(pnlMenuNir, javax.swing.BoxLayout.Y_AXIS));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/NIR.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuNir.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("data analisa NIR");
        jLabel8.setMaximumSize(new java.awt.Dimension(200, 26));
        jLabel8.setPreferredSize(new java.awt.Dimension(200, 26));
        pnlMenuNir.add(jLabel8);

        pnlMenuAdmin.setBackground(new java.awt.Color(230, 81, 0));
        pnlMenuAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuAdmin.setName("pnlMenuAdmin"); // NOI18N
        pnlMenuAdmin.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlMenuAdmin.setLayout(new javax.swing.BoxLayout(pnlMenuAdmin, javax.swing.BoxLayout.Y_AXIS));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img_admin.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuAdmin.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("administrator");
        jLabel10.setMaximumSize(new java.awt.Dimension(200, 26));
        jLabel10.setPreferredSize(new java.awt.Dimension(200, 26));
        pnlMenuAdmin.add(jLabel10);

        pnlMenuKeluar.setBackground(new java.awt.Color(230, 81, 0));
        pnlMenuKeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuKeluar.setName("pnlMenuKeluar"); // NOI18N
        pnlMenuKeluar.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlMenuKeluar.setLayout(new java.awt.BorderLayout());

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_logout_small.png"))); // NOI18N
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuKeluar.add(jLabel11, java.awt.BorderLayout.CENTER);

        jLabel44.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel44.setText("Login sebagai");

        lblUsername.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(0, 102, 102));
        lblUsername.setName("lblUsername"); // NOI18N

        jLabel47.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel47.setText("Versi Sistem");

        lblVersiSistem.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        lblVersiSistem.setForeground(new java.awt.Color(3, 100, 0));
        lblVersiSistem.setText("...");

        jLabel49.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel49.setText("Dikembangkan oleh Bagian Litbang Bungamayang - 2017");

        javax.swing.GroupLayout pnlMainMenuLayout = new javax.swing.GroupLayout(pnlMainMenu);
        pnlMainMenu.setLayout(pnlMainMenuLayout);
        pnlMainMenuLayout.setHorizontalGroup(
            pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainMenuLayout.createSequentialGroup()
                .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlMainMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVersiSistem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlMainMenuLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel44)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMainMenuLayout.createSequentialGroup()
                            .addGap(99, 99, 99)
                            .addComponent(pnlMenuIdTruk, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainMenuLayout.createSequentialGroup()
                        .addComponent(pnlMenuNira, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlMenuNir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlMenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlMenuKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel49))
                .addContainerGap(412, Short.MAX_VALUE))
        );
        pnlMainMenuLayout.setVerticalGroup(
            pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98)
                .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlMenuKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMenuAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMenuNir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMenuNira, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMenuIdTruk, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                .addGroup(pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(lblVersiSistem)
                    .addComponent(jLabel49))
                .addContainerGap())
        );

        pnlMainWindowBawah.add(pnlMainMenu, "crdMainMenu");

        pnlIdTrukMenuAtas.setBackground(new java.awt.Color(2, 79, 20));
        pnlIdTrukMenuAtas.setPreferredSize(new java.awt.Dimension(100, 40));

        jLabel12.setFont(new java.awt.Font("Open Sans", 0, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("registrasi truk tebu");

        pnlHomeIdTruk.setBackground(new java.awt.Color(2, 79, 20));
        pnlHomeIdTruk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlHomeIdTruk.setName("pnlHomeIdTruk"); // NOI18N
        pnlHomeIdTruk.setLayout(new javax.swing.BoxLayout(pnlHomeIdTruk, javax.swing.BoxLayout.X_AXIS));

        jLabel13.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_home_hot.png"))); // NOI18N
        jLabel13.setText("ke menu utama");
        jLabel13.setMaximumSize(new java.awt.Dimension(150, 26));
        jLabel13.setPreferredSize(new java.awt.Dimension(100, 26));
        pnlHomeIdTruk.add(jLabel13);

        javax.swing.GroupLayout pnlIdTrukMenuAtasLayout = new javax.swing.GroupLayout(pnlIdTrukMenuAtas);
        pnlIdTrukMenuAtas.setLayout(pnlIdTrukMenuAtasLayout);
        pnlIdTrukMenuAtasLayout.setHorizontalGroup(
            pnlIdTrukMenuAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIdTrukMenuAtasLayout.createSequentialGroup()
                .addComponent(pnlHomeIdTruk, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlIdTrukMenuAtasLayout.setVerticalGroup(
            pnlIdTrukMenuAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(pnlHomeIdTruk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlMultiFunction.setLayout(new java.awt.CardLayout());

        pnlManualInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel3.setBackground(new java.awt.Color(157, 0, 0));
        jPanel3.setRequestFocusEnabled(false);

        jLabel28.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Registrasi Truk - Offline");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        jLabel29.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel29.setText("No. Tarra");

        txtNoTarraManual.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtNoTarraManual.setName("txtNumerator"); // NOI18N

        jLabel30.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel30.setText("Nomor Polisi");

        lblNopolManual.setBackground(new java.awt.Color(0, 57, 149));
        lblNopolManual.setFont(new java.awt.Font("Open Sans", 1, 22)); // NOI18N
        lblNopolManual.setForeground(new java.awt.Color(255, 255, 255));
        lblNopolManual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNopolManual.setText("BE2837JG");
        lblNopolManual.setOpaque(true);

        jLabel32.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel32.setText("Tanggal Masuk");

        dtpMasukManual.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        dtpMasukManual.setName("dtpTglMasuk"); // NOI18N

        btnSimpanManualInput.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        btnSimpanManualInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_img_save.png"))); // NOI18N
        btnSimpanManualInput.setText("Simpan Data");
        btnSimpanManualInput.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSimpanManualInput.setIconTextGap(10);
        btnSimpanManualInput.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSimpanManualInput.setName("btnSimpanManualInput"); // NOI18N

        btnBatalManualInput.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        btnBatalManualInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_img_cancel.png"))); // NOI18N
        btnBatalManualInput.setText("Batal");
        btnBatalManualInput.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnBatalManualInput.setIconTextGap(10);
        btnBatalManualInput.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnBatalManualInput.setName("btnBatalManualInput"); // NOI18N

        javax.swing.GroupLayout pnlManualInputLayout = new javax.swing.GroupLayout(pnlManualInput);
        pnlManualInput.setLayout(pnlManualInputLayout);
        pnlManualInputLayout.setHorizontalGroup(
            pnlManualInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlManualInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlManualInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlManualInputLayout.createSequentialGroup()
                        .addGroup(pnlManualInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel29))
                        .addGap(34, 34, 34)
                        .addGroup(pnlManualInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNopolManual, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNoTarraManual, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlManualInputLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addComponent(dtpMasukManual, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlManualInputLayout.createSequentialGroup()
                        .addComponent(btnSimpanManualInput, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBatalManualInput, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        pnlManualInputLayout.setVerticalGroup(
            pnlManualInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManualInputLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlManualInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtNoTarraManual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManualInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNopolManual)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManualInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(dtpMasukManual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlManualInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpanManualInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatalManualInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 350, Short.MAX_VALUE))
        );

        pnlMultiFunction.add(pnlManualInput, "crdManualInput");

        pnlSampleMonitor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel1.setBackground(new java.awt.Color(157, 0, 0));
        jPanel1.setRequestFocusEnabled(false);

        jLabel26.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Status Sampel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        lstMonitoringSample.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        lstMonitoringSample.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstMonitoringSample);

        jPanel2.setBackground(new java.awt.Color(23, 0, 104));
        jPanel2.setRequestFocusEnabled(false);

        jLabel27.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("          ID Sampel               [Numerator/DO]                [Status]");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        btnCetakHasilAnalisa.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        btnCetakHasilAnalisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_img_printer.png"))); // NOI18N
        btnCetakHasilAnalisa.setText("Cetak hasil analisa");
        btnCetakHasilAnalisa.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCetakHasilAnalisa.setIconTextGap(10);
        btnCetakHasilAnalisa.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCetakHasilAnalisa.setMaximumSize(new java.awt.Dimension(180, 35));
        btnCetakHasilAnalisa.setMinimumSize(new java.awt.Dimension(180, 35));
        btnCetakHasilAnalisa.setName("btnCetakHasil"); // NOI18N
        btnCetakHasilAnalisa.setPreferredSize(new java.awt.Dimension(180, 35));

        btnCrosscheckManual.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        btnCrosscheckManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_img_pencil.png"))); // NOI18N
        btnCrosscheckManual.setText("Crosscheck reg. manual");
        btnCrosscheckManual.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCrosscheckManual.setIconTextGap(10);
        btnCrosscheckManual.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCrosscheckManual.setName("btnCetakId"); // NOI18N

        btnCekPrinter.setText("jButton1");
        btnCekPrinter.setName("cekPrinter"); // NOI18N

        btnRefreshData.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        btnRefreshData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_img_printer.png"))); // NOI18N
        btnRefreshData.setText("Refresh Data");
        btnRefreshData.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnRefreshData.setIconTextGap(10);
        btnRefreshData.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnRefreshData.setMaximumSize(new java.awt.Dimension(180, 35));
        btnRefreshData.setMinimumSize(new java.awt.Dimension(180, 35));
        btnRefreshData.setName("btnRefreshData"); // NOI18N
        btnRefreshData.setPreferredSize(new java.awt.Dimension(180, 35));

        javax.swing.GroupLayout pnlSampleMonitorLayout = new javax.swing.GroupLayout(pnlSampleMonitor);
        pnlSampleMonitor.setLayout(pnlSampleMonitorLayout);
        pnlSampleMonitorLayout.setHorizontalGroup(
            pnlSampleMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
            .addGroup(pnlSampleMonitorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSampleMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSampleMonitorLayout.createSequentialGroup()
                        .addComponent(btnCrosscheckManual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCekPrinter)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlSampleMonitorLayout.createSequentialGroup()
                        .addComponent(btnCetakHasilAnalisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefreshData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlSampleMonitorLayout.setVerticalGroup(
            pnlSampleMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSampleMonitorLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSampleMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCetakHasilAnalisa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshData, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSampleMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrosscheckManual, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCekPrinter))
                .addGap(13, 13, 13))
        );

        pnlMultiFunction.add(pnlSampleMonitor, "crdSampleMonitor");

        pnlIdTrukReg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel14.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel14.setText("Input Numerator");

        try {
            ftxtNumerator.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtNumerator.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        ftxtNumerator.setName("ftxtNumerator"); // NOI18N

        dtpTglMasuk.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        dtpTglMasuk.setName("dtpTglMasuk"); // NOI18N

        jLabel15.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel15.setText("Tanggal Masuk");

        lblNumerator.setBackground(new java.awt.Color(0, 57, 149));
        lblNumerator.setFont(new java.awt.Font("Open Sans", 1, 22)); // NOI18N
        lblNumerator.setForeground(new java.awt.Color(255, 255, 255));
        lblNumerator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumerator.setAlignmentY(0.0F);
        lblNumerator.setFocusable(false);
        lblNumerator.setMaximumSize(new java.awt.Dimension(171, 31));
        lblNumerator.setMinimumSize(new java.awt.Dimension(171, 31));
        lblNumerator.setOpaque(true);
        lblNumerator.setPreferredSize(new java.awt.Dimension(171, 31));

        jLabel17.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel17.setText("Numerator / DO");
        jLabel17.setAlignmentY(0.0F);
        jLabel17.setFocusable(false);
        jLabel17.setMaximumSize(new java.awt.Dimension(110, 31));
        jLabel17.setMinimumSize(new java.awt.Dimension(110, 31));
        jLabel17.setPreferredSize(new java.awt.Dimension(110, 31));

        jLabel18.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel18.setText("Kepemilikan");
        jLabel18.setAlignmentY(0.0F);
        jLabel18.setFocusable(false);
        jLabel18.setMaximumSize(new java.awt.Dimension(110, 31));
        jLabel18.setMinimumSize(new java.awt.Dimension(110, 31));
        jLabel18.setPreferredSize(new java.awt.Dimension(110, 31));

        lblTsTr.setBackground(new java.awt.Color(149, 0, 0));
        lblTsTr.setFont(new java.awt.Font("Open Sans", 1, 22)); // NOI18N
        lblTsTr.setForeground(new java.awt.Color(255, 255, 255));
        lblTsTr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTsTr.setAlignmentY(0.0F);
        lblTsTr.setFocusable(false);
        lblTsTr.setMaximumSize(new java.awt.Dimension(171, 31));
        lblTsTr.setMinimumSize(new java.awt.Dimension(171, 31));
        lblTsTr.setOpaque(true);
        lblTsTr.setPreferredSize(new java.awt.Dimension(171, 31));

        lblNoTarra.setBackground(new java.awt.Color(0, 57, 149));
        lblNoTarra.setFont(new java.awt.Font("Open Sans", 1, 22)); // NOI18N
        lblNoTarra.setForeground(new java.awt.Color(255, 255, 255));
        lblNoTarra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNoTarra.setAlignmentY(0.0F);
        lblNoTarra.setFocusable(false);
        lblNoTarra.setMaximumSize(new java.awt.Dimension(171, 31));
        lblNoTarra.setMinimumSize(new java.awt.Dimension(171, 31));
        lblNoTarra.setOpaque(true);
        lblNoTarra.setPreferredSize(new java.awt.Dimension(171, 31));

        jLabel20.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel20.setText("Nomor Tarra");
        jLabel20.setAlignmentY(0.0F);
        jLabel20.setFocusable(false);
        jLabel20.setMaximumSize(new java.awt.Dimension(110, 31));
        jLabel20.setMinimumSize(new java.awt.Dimension(110, 31));
        jLabel20.setPreferredSize(new java.awt.Dimension(110, 31));

        jLabel22.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel22.setText("Nomor Polisi");
        jLabel22.setAlignmentY(0.0F);
        jLabel22.setFocusable(false);
        jLabel22.setMaximumSize(new java.awt.Dimension(110, 31));
        jLabel22.setMinimumSize(new java.awt.Dimension(110, 31));
        jLabel22.setPreferredSize(new java.awt.Dimension(110, 31));

        lblNopol.setBackground(new java.awt.Color(0, 57, 149));
        lblNopol.setFont(new java.awt.Font("Open Sans", 1, 22)); // NOI18N
        lblNopol.setForeground(new java.awt.Color(255, 255, 255));
        lblNopol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNopol.setAlignmentY(0.0F);
        lblNopol.setFocusable(false);
        lblNopol.setMaximumSize(new java.awt.Dimension(171, 31));
        lblNopol.setMinimumSize(new java.awt.Dimension(171, 31));
        lblNopol.setOpaque(true);
        lblNopol.setPreferredSize(new java.awt.Dimension(171, 31));

        lblRayon.setBackground(new java.awt.Color(62, 149, 0));
        lblRayon.setFont(new java.awt.Font("Open Sans", 1, 22)); // NOI18N
        lblRayon.setForeground(new java.awt.Color(255, 255, 255));
        lblRayon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRayon.setAlignmentY(0.0F);
        lblRayon.setFocusable(false);
        lblRayon.setMaximumSize(new java.awt.Dimension(171, 31));
        lblRayon.setMinimumSize(new java.awt.Dimension(171, 31));
        lblRayon.setOpaque(true);
        lblRayon.setPreferredSize(new java.awt.Dimension(171, 31));

        jLabel24.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel24.setText("Rayon / Afdeling");
        jLabel24.setAlignmentY(0.0F);
        jLabel24.setFocusable(false);
        jLabel24.setMaximumSize(new java.awt.Dimension(110, 31));
        jLabel24.setMinimumSize(new java.awt.Dimension(110, 31));
        jLabel24.setPreferredSize(new java.awt.Dimension(110, 31));

        btnCetakId.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        btnCetakId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_img_printer.png"))); // NOI18N
        btnCetakId.setText("Cetak ID");
        btnCetakId.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCetakId.setIconTextGap(10);
        btnCetakId.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCetakId.setName("btnCetakId"); // NOI18N

        btnManualId.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        btnManualId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_img_pencil.png"))); // NOI18N
        btnManualId.setText("Reg. Offline");
        btnManualId.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnManualId.setIconTextGap(10);
        btnManualId.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnManualId.setName("btnManualId"); // NOI18N

        jScrollPane2.setMaximumSize(new java.awt.Dimension(98, 45));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(98, 45));

        txpBarcode.setEditable(false);
        txpBarcode.setFont(new java.awt.Font("Free 3 of 9", 0, 48)); // NOI18N
        txpBarcode.setDoubleBuffered(true);
        jScrollPane2.setViewportView(txpBarcode);

        javax.swing.GroupLayout pnlIdTrukRegLayout = new javax.swing.GroupLayout(pnlIdTrukReg);
        pnlIdTrukReg.setLayout(pnlIdTrukRegLayout);
        pnlIdTrukRegLayout.setHorizontalGroup(
            pnlIdTrukRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIdTrukRegLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlIdTrukRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRayon, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNopol, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNoTarra, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlIdTrukRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblTsTr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNumerator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(pnlIdTrukRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlIdTrukRegLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(pnlIdTrukRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlIdTrukRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addGroup(pnlIdTrukRegLayout.createSequentialGroup()
                                .addGroup(pnlIdTrukRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(pnlIdTrukRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dtpTglMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ftxtNumerator, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIdTrukRegLayout.createSequentialGroup()
                                .addGroup(pnlIdTrukRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(189, 189, 189)))
                        .addGroup(pnlIdTrukRegLayout.createSequentialGroup()
                            .addComponent(btnCetakId, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnManualId, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlIdTrukRegLayout.setVerticalGroup(
            pnlIdTrukRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIdTrukRegLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNumerator, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTsTr, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNoTarra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNopol, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRayon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlIdTrukRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlIdTrukRegLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addGroup(pnlIdTrukRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(ftxtNumerator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnlIdTrukRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(dtpTglMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pnlIdTrukRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCetakId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnManualId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(123, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlIdTrukContentLayout = new javax.swing.GroupLayout(pnlIdTrukContent);
        pnlIdTrukContent.setLayout(pnlIdTrukContentLayout);
        pnlIdTrukContentLayout.setHorizontalGroup(
            pnlIdTrukContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIdTrukContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlIdTrukReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(pnlMultiFunction, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(620, Short.MAX_VALUE))
        );
        pnlIdTrukContentLayout.setVerticalGroup(
            pnlIdTrukContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIdTrukContentLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlIdTrukContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlIdTrukReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMultiFunction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout pnlIdTrukLayout = new javax.swing.GroupLayout(pnlIdTruk);
        pnlIdTruk.setLayout(pnlIdTrukLayout);
        pnlIdTrukLayout.setHorizontalGroup(
            pnlIdTrukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlIdTrukMenuAtas, javax.swing.GroupLayout.DEFAULT_SIZE, 1448, Short.MAX_VALUE)
            .addComponent(pnlIdTrukContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlIdTrukLayout.setVerticalGroup(
            pnlIdTrukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIdTrukLayout.createSequentialGroup()
                .addComponent(pnlIdTrukMenuAtas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlIdTrukContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMainWindowBawah.add(pnlIdTruk, "crdIdTruk");

        pnlNira.setName("crdNira"); // NOI18N

        pnlNiraMenuAtas.setBackground(new java.awt.Color(2, 79, 20));
        pnlNiraMenuAtas.setPreferredSize(new java.awt.Dimension(100, 40));

        jLabel16.setFont(new java.awt.Font("Open Sans", 0, 22)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("data nira tebu");

        pnlHomeNira.setBackground(new java.awt.Color(2, 79, 20));
        pnlHomeNira.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlHomeNira.setName("pnlHomeNira"); // NOI18N
        pnlHomeNira.setLayout(new javax.swing.BoxLayout(pnlHomeNira, javax.swing.BoxLayout.X_AXIS));

        jLabel19.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_home_hot.png"))); // NOI18N
        jLabel19.setText("ke menu utama");
        jLabel19.setMaximumSize(new java.awt.Dimension(150, 26));
        jLabel19.setPreferredSize(new java.awt.Dimension(100, 26));
        pnlHomeNira.add(jLabel19);

        javax.swing.GroupLayout pnlNiraMenuAtasLayout = new javax.swing.GroupLayout(pnlNiraMenuAtas);
        pnlNiraMenuAtas.setLayout(pnlNiraMenuAtasLayout);
        pnlNiraMenuAtasLayout.setHorizontalGroup(
            pnlNiraMenuAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNiraMenuAtasLayout.createSequentialGroup()
                .addComponent(pnlHomeNira, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1126, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlNiraMenuAtasLayout.setVerticalGroup(
            pnlNiraMenuAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(pnlHomeNira, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlInputBerat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        pnlInputKodeSampelNira.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel21.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel21.setText("Input Kode Sampel");

        try {
            ftxtKodeSampel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtKodeSampel.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        ftxtKodeSampel.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        ftxtKodeSampel.setName("ftxtKodeSampel"); // NOI18N

        javax.swing.GroupLayout pnlInputKodeSampelNiraLayout = new javax.swing.GroupLayout(pnlInputKodeSampelNira);
        pnlInputKodeSampelNira.setLayout(pnlInputKodeSampelNiraLayout);
        pnlInputKodeSampelNiraLayout.setHorizontalGroup(
            pnlInputKodeSampelNiraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputKodeSampelNiraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(ftxtKodeSampel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInputKodeSampelNiraLayout.setVerticalGroup(
            pnlInputKodeSampelNiraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputKodeSampelNiraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputKodeSampelNiraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(ftxtKodeSampel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblStatusTimbang.setBackground(new java.awt.Color(0, 0, 0));
        lblStatusTimbang.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        lblStatusTimbang.setForeground(new java.awt.Color(255, 255, 255));
        lblStatusTimbang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatusTimbang.setName("lblStatusTimbang"); // NOI18N
        lblStatusTimbang.setOpaque(true);

        btnSimpanAmpas.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        btnSimpanAmpas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_img_timbang.png"))); // NOI18N
        btnSimpanAmpas.setText("Ambil Berat Ampas");
        btnSimpanAmpas.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSimpanAmpas.setIconTextGap(10);
        btnSimpanAmpas.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSimpanAmpas.setName("btnSimpanAmpas"); // NOI18N
        btnSimpanAmpas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanAmpasActionPerformed(evt);
            }
        });

        pnlInputKodeSampelNira1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel39.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel39.setText("Input Berat Sampel");

        try {
            ftxtBeratSampel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtBeratSampel.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        ftxtBeratSampel.setFont(new java.awt.Font("Open Sans", 0, 36)); // NOI18N
        ftxtBeratSampel.setName("ftxtBeratSampel"); // NOI18N

        javax.swing.GroupLayout pnlInputKodeSampelNira1Layout = new javax.swing.GroupLayout(pnlInputKodeSampelNira1);
        pnlInputKodeSampelNira1.setLayout(pnlInputKodeSampelNira1Layout);
        pnlInputKodeSampelNira1Layout.setHorizontalGroup(
            pnlInputKodeSampelNira1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputKodeSampelNira1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addGap(18, 18, 18)
                .addComponent(ftxtBeratSampel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInputKodeSampelNira1Layout.setVerticalGroup(
            pnlInputKodeSampelNira1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputKodeSampelNira1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputKodeSampelNira1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ftxtBeratSampel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnTesBasah.setText("Basah");
        btnTesBasah.setName("btnTesBasah"); // NOI18N

        btnTesKering.setText("Kering");
        btnTesKering.setName("btnTesKering"); // NOI18N

        lblAngkaTimbang.setBackground(new java.awt.Color(0, 51, 102));
        lblAngkaTimbang.setFont(new java.awt.Font("Open Sans", 1, 84)); // NOI18N
        lblAngkaTimbang.setForeground(new java.awt.Color(255, 255, 255));
        lblAngkaTimbang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAngkaTimbang.setName("lblAngkaTimbang"); // NOI18N
        lblAngkaTimbang.setOpaque(true);

        javax.swing.GroupLayout pnlInputBeratLayout = new javax.swing.GroupLayout(pnlInputBerat);
        pnlInputBerat.setLayout(pnlInputBeratLayout);
        pnlInputBeratLayout.setHorizontalGroup(
            pnlInputBeratLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputBeratLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputBeratLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInputBeratLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnSimpanAmpas, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInputBeratLayout.createSequentialGroup()
                        .addComponent(btnTesBasah, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTesKering, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblAngkaTimbang, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlInputKodeSampelNira1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlInputBeratLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlInputKodeSampelNira, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblStatusTimbang, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInputBeratLayout.setVerticalGroup(
            pnlInputBeratLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputBeratLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInputKodeSampelNira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatusTimbang, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlInputKodeSampelNira1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpanAmpas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInputBeratLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTesBasah)
                    .addComponent(btnTesKering))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAngkaTimbang, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        pnlSampelMonitorNira.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel8.setBackground(new java.awt.Color(157, 0, 0));
        jPanel8.setRequestFocusEnabled(false);

        jLabel45.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Status Sampel");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        lstMonitoringSampelNira.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        lstMonitoringSampelNira.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(lstMonitoringSampelNira);

        jPanel9.setBackground(new java.awt.Color(23, 0, 104));
        jPanel9.setRequestFocusEnabled(false);

        jLabel46.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("          ID Sampel               [Numerator/DO]                [Status]");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlSampelMonitorNiraLayout = new javax.swing.GroupLayout(pnlSampelMonitorNira);
        pnlSampelMonitorNira.setLayout(pnlSampelMonitorNiraLayout);
        pnlSampelMonitorNiraLayout.setHorizontalGroup(
            pnlSampelMonitorNiraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );
        pnlSampelMonitorNiraLayout.setVerticalGroup(
            pnlSampelMonitorNiraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSampelMonitorNiraLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3))
        );

        javax.swing.GroupLayout pnlNiraContentLayout = new javax.swing.GroupLayout(pnlNiraContent);
        pnlNiraContent.setLayout(pnlNiraContentLayout);
        pnlNiraContentLayout.setHorizontalGroup(
            pnlNiraContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNiraContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInputBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlSampelMonitorNira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNiraContentLayout.setVerticalGroup(
            pnlNiraContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNiraContentLayout.createSequentialGroup()
                .addGroup(pnlNiraContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlSampelMonitorNira, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlInputBerat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlNiraLayout = new javax.swing.GroupLayout(pnlNira);
        pnlNira.setLayout(pnlNiraLayout);
        pnlNiraLayout.setHorizontalGroup(
            pnlNiraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNiraMenuAtas, javax.swing.GroupLayout.DEFAULT_SIZE, 1448, Short.MAX_VALUE)
            .addComponent(pnlNiraContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlNiraLayout.setVerticalGroup(
            pnlNiraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNiraLayout.createSequentialGroup()
                .addComponent(pnlNiraMenuAtas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNiraContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMainWindowBawah.add(pnlNira, "crdNira");

        pnlXdsMenuAtas.setBackground(new java.awt.Color(2, 79, 20));
        pnlXdsMenuAtas.setPreferredSize(new java.awt.Dimension(100, 40));

        jLabel23.setFont(new java.awt.Font("Open Sans", 0, 22)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("data analisa NIR");

        pnlHomeXds.setBackground(new java.awt.Color(2, 79, 20));
        pnlHomeXds.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlHomeXds.setName("pnlHomeXds"); // NOI18N
        pnlHomeXds.setLayout(new javax.swing.BoxLayout(pnlHomeXds, javax.swing.BoxLayout.X_AXIS));

        jLabel25.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_home_hot.png"))); // NOI18N
        jLabel25.setText("ke menu utama");
        jLabel25.setMaximumSize(new java.awt.Dimension(150, 26));
        jLabel25.setPreferredSize(new java.awt.Dimension(100, 26));
        pnlHomeXds.add(jLabel25);

        javax.swing.GroupLayout pnlXdsMenuAtasLayout = new javax.swing.GroupLayout(pnlXdsMenuAtas);
        pnlXdsMenuAtas.setLayout(pnlXdsMenuAtasLayout);
        pnlXdsMenuAtasLayout.setHorizontalGroup(
            pnlXdsMenuAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlXdsMenuAtasLayout.createSequentialGroup()
                .addComponent(pnlHomeXds, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlXdsMenuAtasLayout.setVerticalGroup(
            pnlXdsMenuAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(pnlHomeXds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));

        jLabel31.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel31.setText("Folder Data XDS");

        lblPathXds.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        lblPathXds.setText("...");
        lblPathXds.setName("lblPathXds"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addComponent(lblPathXds, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(lblPathXds))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlXdsLayout = new javax.swing.GroupLayout(pnlXds);
        pnlXds.setLayout(pnlXdsLayout);
        pnlXdsLayout.setHorizontalGroup(
            pnlXdsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlXdsMenuAtas, javax.swing.GroupLayout.DEFAULT_SIZE, 1448, Short.MAX_VALUE)
            .addGroup(pnlXdsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(797, Short.MAX_VALUE))
        );
        pnlXdsLayout.setVerticalGroup(
            pnlXdsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlXdsLayout.createSequentialGroup()
                .addComponent(pnlXdsMenuAtas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 541, Short.MAX_VALUE))
        );

        pnlMainWindowBawah.add(pnlXds, "crdXds");

        pnlAdmin.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N

        pnlIdTrukMenuAtas1.setBackground(new java.awt.Color(206, 6, 6));
        pnlIdTrukMenuAtas1.setPreferredSize(new java.awt.Dimension(100, 40));

        jLabel33.setFont(new java.awt.Font("Open Sans", 0, 22)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("administrator sistem");

        pnlHomeAdmin.setBackground(new java.awt.Color(206, 6, 6));
        pnlHomeAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlHomeAdmin.setName("pnlHomeAdmin"); // NOI18N
        pnlHomeAdmin.setLayout(new javax.swing.BoxLayout(pnlHomeAdmin, javax.swing.BoxLayout.X_AXIS));

        jLabel34.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_home_hot.png"))); // NOI18N
        jLabel34.setText("ke menu utama");
        jLabel34.setMaximumSize(new java.awt.Dimension(150, 26));
        jLabel34.setPreferredSize(new java.awt.Dimension(100, 26));
        pnlHomeAdmin.add(jLabel34);

        javax.swing.GroupLayout pnlIdTrukMenuAtas1Layout = new javax.swing.GroupLayout(pnlIdTrukMenuAtas1);
        pnlIdTrukMenuAtas1.setLayout(pnlIdTrukMenuAtas1Layout);
        pnlIdTrukMenuAtas1Layout.setHorizontalGroup(
            pnlIdTrukMenuAtas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIdTrukMenuAtas1Layout.createSequentialGroup()
                .addComponent(pnlHomeAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlIdTrukMenuAtas1Layout.setVerticalGroup(
            pnlIdTrukMenuAtas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(pnlHomeAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        dtpTglPeriode.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        dtpTglPeriode.setName("dtpTglPeriode"); // NOI18N
        dtpTglPeriode.setPreferredSize(new java.awt.Dimension(186, 28));

        jLabel35.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel35.setText("Upload data netto truk");

        jLabel36.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel36.setText("Periode Analisa");

        btnUploadNetto.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        btnUploadNetto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_img_truk.png"))); // NOI18N
        btnUploadNetto.setText("Upload Netto");
        btnUploadNetto.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnUploadNetto.setIconTextGap(10);
        btnUploadNetto.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnUploadNetto.setName("btnUploadNetto"); // NOI18N

        pgbNetto.setDoubleBuffered(true);
        pgbNetto.setName("pgbNetto"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(34, 34, 34)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnUploadNetto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dtpTglPeriode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(pgbNetto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(dtpTglPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUploadNetto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pgbNetto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        dtpTglSetPeriode.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        dtpTglSetPeriode.setName("dtpTglSetPeriode"); // NOI18N
        dtpTglSetPeriode.setPreferredSize(new java.awt.Dimension(186, 28));

        jLabel37.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel37.setText("Ganti Periode Analisa");

        jLabel38.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel38.setText("Periode Analisa");

        btnGantiPeriode.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        btnGantiPeriode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_img_periode.png"))); // NOI18N
        btnGantiPeriode.setText("Ganti Periode");
        btnGantiPeriode.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnGantiPeriode.setIconTextGap(10);
        btnGantiPeriode.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnGantiPeriode.setName("btnGantiPeriode"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGantiPeriode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dtpTglSetPeriode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(dtpTglSetPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGantiPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlAdminLayout = new javax.swing.GroupLayout(pnlAdmin);
        pnlAdmin.setLayout(pnlAdminLayout);
        pnlAdminLayout.setHorizontalGroup(
            pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlIdTrukMenuAtas1, javax.swing.GroupLayout.DEFAULT_SIZE, 1448, Short.MAX_VALUE)
            .addGroup(pnlAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1015, Short.MAX_VALUE))
        );
        pnlAdminLayout.setVerticalGroup(
            pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminLayout.createSequentialGroup()
                .addComponent(pnlIdTrukMenuAtas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 301, Short.MAX_VALUE))
        );

        pnlMainWindowBawah.add(pnlAdmin, "crdAdmin");

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel40.setBackground(new java.awt.Color(0, 102, 102));
        jLabel40.setFont(new java.awt.Font("Open Sans", 1, 16)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText(" User Login");
        jLabel40.setOpaque(true);

        txtUsername.setBackground(new java.awt.Color(204, 204, 204));
        txtUsername.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        txtUsername.setName("txtUsername"); // NOI18N

        jLabel42.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel42.setText("Username");

        jLabel43.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel43.setText("Password");

        btnLogin.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_img_login.png"))); // NOI18N
        btnLogin.setText("LOGIN");
        btnLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnLogin.setIconTextGap(10);
        btnLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnLogin.setName("btnLogin"); // NOI18N

        ftxtPassword.setBackground(new java.awt.Color(204, 204, 204));
        ftxtPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ftxtPassword.setMaximumSize(new java.awt.Dimension(165, 23));
        ftxtPassword.setMinimumSize(new java.awt.Dimension(165, 23));
        ftxtPassword.setName("ftxtPassword"); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(ftxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(ftxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlMenuKeluarLogin.setBackground(new java.awt.Color(230, 81, 0));
        pnlMenuKeluarLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuKeluarLogin.setName("pnlMenuKeluar"); // NOI18N
        pnlMenuKeluarLogin.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlMenuKeluarLogin.setLayout(new java.awt.BorderLayout());

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_logout_small.png"))); // NOI18N
        jLabel41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMenuKeluarLogin.add(jLabel41, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMenuKeluarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(770, Short.MAX_VALUE))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMenuKeluarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(272, Short.MAX_VALUE))
        );

        pnlMainWindowBawah.add(pnlLogin, "crdLogin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainWindowAtas, javax.swing.GroupLayout.DEFAULT_SIZE, 1448, Short.MAX_VALUE)
            .addComponent(pnlMainWindowBawah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMainWindowAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMainWindowBawah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanAmpasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanAmpasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanAmpasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatalManualInput;
    private javax.swing.JButton btnCekPrinter;
    private javax.swing.JButton btnCetakHasilAnalisa;
    private javax.swing.JButton btnCetakId;
    private javax.swing.JButton btnCrosscheckManual;
    private javax.swing.JButton btnGantiPeriode;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnManualId;
    private javax.swing.JButton btnRefreshData;
    private javax.swing.JButton btnSimpanAmpas;
    private javax.swing.JButton btnSimpanManualInput;
    private javax.swing.JButton btnTesBasah;
    private javax.swing.JButton btnTesKering;
    private javax.swing.JButton btnUploadNetto;
    private org.jdesktop.swingx.JXDatePicker dtpMasukManual;
    private org.jdesktop.swingx.JXDatePicker dtpTglMasuk;
    private org.jdesktop.swingx.JXDatePicker dtpTglPeriode;
    private org.jdesktop.swingx.JXDatePicker dtpTglSetPeriode;
    private javax.swing.JFormattedTextField ftxtBeratSampel;
    private javax.swing.JFormattedTextField ftxtKodeSampel;
    private javax.swing.JFormattedTextField ftxtNumerator;
    private javax.swing.JPasswordField ftxtPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAngkaTimbang;
    private javax.swing.JLabel lblNoTarra;
    private javax.swing.JLabel lblNopol;
    private javax.swing.JLabel lblNopolManual;
    private javax.swing.JLabel lblNumerator;
    private javax.swing.JLabel lblPathXds;
    private javax.swing.JLabel lblRayon;
    private javax.swing.JLabel lblStatusTimbang;
    private javax.swing.JLabel lblTsTr;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblVersiSistem;
    private javax.swing.JList<String> lstMonitoringSampelNira;
    private javax.swing.JList<String> lstMonitoringSample;
    private javax.swing.JProgressBar pgbNetto;
    private javax.swing.JPanel pnlAdmin;
    private javax.swing.JPanel pnlHomeAdmin;
    private javax.swing.JPanel pnlHomeIdTruk;
    private javax.swing.JPanel pnlHomeNira;
    private javax.swing.JPanel pnlHomeXds;
    private javax.swing.JPanel pnlIdTruk;
    private javax.swing.JPanel pnlIdTrukContent;
    private javax.swing.JPanel pnlIdTrukMenuAtas;
    private javax.swing.JPanel pnlIdTrukMenuAtas1;
    private javax.swing.JPanel pnlIdTrukReg;
    private javax.swing.JPanel pnlInputBerat;
    private javax.swing.JPanel pnlInputKodeSampelNira;
    private javax.swing.JPanel pnlInputKodeSampelNira1;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlMainMenu;
    private javax.swing.JPanel pnlMainWindowAtas;
    private javax.swing.JPanel pnlMainWindowBawah;
    private javax.swing.JPanel pnlManualInput;
    private javax.swing.JPanel pnlMenuAdmin;
    private javax.swing.JPanel pnlMenuIdTruk;
    private javax.swing.JPanel pnlMenuKeluar;
    private javax.swing.JPanel pnlMenuKeluarLogin;
    private javax.swing.JPanel pnlMenuNir;
    private javax.swing.JPanel pnlMenuNira;
    private javax.swing.JPanel pnlMultiFunction;
    private javax.swing.JPanel pnlNira;
    private javax.swing.JPanel pnlNiraContent;
    private javax.swing.JPanel pnlNiraMenuAtas;
    private javax.swing.JPanel pnlSampelMonitorNira;
    private javax.swing.JPanel pnlSampleMonitor;
    private javax.swing.JPanel pnlXds;
    private javax.swing.JPanel pnlXdsMenuAtas;
    private javax.swing.JTextPane txpBarcode;
    private javax.swing.JTextField txtNoTarraManual;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
    
    public JPanel getPnlMainWindowBawah(){
        return pnlMainWindowBawah;
    }
    
    public JPanel getnPnlMultiFunctionIdTruk(){
        return pnlMultiFunction;
    }
    
    public JXDatePicker getDtpTglMasuk(){
        return dtpTglMasuk;
    }
    
    public JLabel getLblNumerator(){
        return lblNumerator;
    }

    public javax.swing.JLabel getLblNoTarra() {
        return lblNoTarra;
    }

    public javax.swing.JLabel getLblNopol() {
        return lblNopol;
    }

    public javax.swing.JLabel getLblNopolManual() {
        return lblNopolManual;
    }

    public javax.swing.JLabel getLblRayon() {
        return lblRayon;
    }

    public javax.swing.JLabel getLblTsTr() {
        return lblTsTr;
    }
    
    public JTextPane getTxpBarcode(){
        return txpBarcode;
    }
    
    public JTextField getFtxtNumerator(){
        return ftxtNumerator;
    }
    
    public JList getLstMonitoringSampel(){
        return lstMonitoringSample;
    }
    
    public JPanel getPnlNira(){
        return pnlNira;
    }
    
    public JLabel getLblStatusTimbang(){
        return lblStatusTimbang;
    }
    
    public JLabel getLblAngkaTimbang(){
        return lblAngkaTimbang;
    }
    
    public JTextField getFtxtKodeSampel(){
        return ftxtKodeSampel;
    }
    
    public JLabel getLblPathXds(){
        return lblPathXds;
    }

    public org.jdesktop.swingx.JXDatePicker getDtpMasukManual() {
        return dtpMasukManual;
    }

    public org.jdesktop.swingx.JXDatePicker getDtpTglPeriode() {
        return dtpTglPeriode;
    }

    public org.jdesktop.swingx.JXDatePicker getDtpTglSetPeriode() {
        return dtpTglSetPeriode;
    }
    
    public JTextField getFtxtBeratSampel(){
        return ftxtBeratSampel;
    }
    
    public JTextField getTxtUsername(){
        return txtUsername;
    }
    
    public JTextField getFtxtPassword(){
        return ftxtPassword;
    }
    
    public JLabel getLblUsername(){
        return lblUsername;
    }
    
    public JList getLstMonitoringSampelNira(){
        return lstMonitoringSampelNira;
    }
    
    public JProgressBar getPgbNetto(){
        return pgbNetto;
    }

    public JLabel getLblVersiSistem(){
        return lblVersiSistem;
    }
    
}
