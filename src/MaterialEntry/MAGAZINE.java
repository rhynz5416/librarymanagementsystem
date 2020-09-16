package MaterialEntry;

import Accession_Classes.C_MagazineAccession;
import Classes.C_LibraryMaterialMagazine;
import Global_Variable.Global_Variable;
import Module.dbConn;
import connection.Conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class MAGAZINE extends javax.swing.JFrame {

    Statement st;
    ResultSet rs;
    dbConn con = new dbConn();
    private Vector<Vector<String>> data;
    private Vector<String> header;

    private Vector<Vector<String>> datas;
    private Vector<String> headers;

    public MAGAZINE() throws Exception {
        Conn connection = new Conn();
        data = connection.getMagazine();
        header = new Vector<String>();

        Conn connections = new Conn();
        datas = connections.getMagazineAccession();
        headers = new Vector<String>();

        header.add("id");
        header.add("ISBNBarcode");
        header.add("M_Title");
        header.add("Lib_Id");
        header.add("Copies");
        header.add("Status");
        header.add("Availability");

        headers.add("id");
        headers.add("accession");
        headers.add("ISBNBarcode");
        initComponents();

        txtBarcode.setEnabled(true);
        magazineDate.setEnabled(false);
        txtMagazineTitle.setEnabled(false);
        txtPublisher.setEnabled(false);
        txtedNum.setEnabled(false);
        txtpageVol.setEnabled(false);
        txtplace.setEnabled(false);
        yearMagazine.setEnabled(false);
        status1.setEnabled(false);
        days.setEnabled(false);
        available.setEnabled(false);
        accession.setEnabled(false);
        total.setEditable(false);
        updateDate.hide();
        total.setText("0");

        tbl_mag.removeColumn(tbl_mag.getColumnModel().getColumn(0));
        tbl_searchMag.removeColumn(tbl_searchMag.getColumnModel().getColumn(0));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public ArrayList<C_LibraryMaterialMagazine> getMagazineList() {
        ArrayList<C_LibraryMaterialMagazine> Mags = new ArrayList<C_LibraryMaterialMagazine>();
        String query = "select * from `tbl_magazine` where category_id ='" + Global_Variable.category_id + "'";
        ResultSet rs;
        try {
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);

            C_LibraryMaterialMagazine magazine;
            while (rs.next()) {
                magazine = new C_LibraryMaterialMagazine(rs.getInt("id"), rs.getString("ISBNBarcode"), rs.getString("DateAcquisition"), rs.getString("M_Title"), rs.getString("M_Publisher"), rs.getInt("EditionNumber"), rs.getInt("PageVolume"), rs.getString("Place"), rs.getInt("Year"));
                Mags.add(magazine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Mags;
    }

    //for magazine table
    public void LibraryMagazine() {
        ArrayList<C_LibraryMaterialMagazine> maGazine = getMagazineList();
        DefaultTableModel model = (DefaultTableModel) tbl_mag.getModel();
        Object[] row = new Object[2];
        for (int i = 0; i < maGazine.size(); i++) {
            row[0] = maGazine.get(i).getisbnBarcode();
            row[2] = maGazine.get(i).getmagazineTitle();

            model.addRow(row);
        }

    }

    public ArrayList<C_MagazineAccession> getmagazineAccess() {
        ArrayList<C_MagazineAccession> access = new ArrayList<C_MagazineAccession>();
        String query = "select * from `tbl_magazineaccession`";
        ResultSet rs;
        try {
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);

            C_MagazineAccession accession;
            while (rs.next()) {
                accession = new C_MagazineAccession(rs.getInt("id"), rs.getInt("accession"));
                access.add(accession);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return access;
    }

    public void MagazineAccession() {
        ArrayList<C_MagazineAccession> maGazine = getmagazineAccess();
        DefaultTableModel model = (DefaultTableModel) tbl_mag.getModel();
        Object[] row = new Object[2];
        for (int i = 0; i < maGazine.size(); i++) {
            row[0] = maGazine.get(i).getaccession();

            model.addRow(row);
        }

    }
    //for magazine query

    public void executeSqlQuery(String query, String message) {
        try {
            st = null;
            st = con.dbconn().createStatement();
            if ((st.executeUpdate(query)) == 1) {

                Conn connecting = new Conn();
                data = connecting.getMagazine();
                //for setting the table for model
                tbl_mag.setModel(new javax.swing.table.DefaultTableModel(data, header));

                tbl_mag.removeColumn(tbl_mag.getColumnModel().getColumn(0));

                Conn connectn = new Conn();
                datas = connectn.getMagazineAccession();
                //for setting the table for model
                tbl_searchMag.setModel(new javax.swing.table.DefaultTableModel(datas, headers));

                tbl_searchMag.removeColumn(tbl_searchMag.getColumnModel().getColumn(0));

                JOptionPane.showMessageDialog(null, "Data " + message + " successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Data" + message + ".");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnsave = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_mag = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_searchMag = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        status1 = new javax.swing.JComboBox();
        available = new javax.swing.JComboBox();
        label1 = new javax.swing.JLabel();
        days = new javax.swing.JComboBox();
        yearMagazine = new com.toedter.calendar.JYearChooser();
        txtplace = new javax.swing.JTextField();
        txtpageVol = new javax.swing.JTextField();
        txtedNum = new javax.swing.JTextField();
        txtPublisher = new javax.swing.JTextField();
        txtMagazineTitle = new javax.swing.JTextField();
        magazineDate = new com.toedter.calendar.JDateChooser();
        txtBarcode = new javax.swing.JTextField();
        updateDate = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        btnAcccess = new javax.swing.JButton();
        accession = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        accessSearch = new javax.swing.JTextField();
        btnPrintmaga = new javax.swing.JButton();
        btnAccessprint = new javax.swing.JButton();
        book = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel3.setLayout(null);

        jLabel45.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_search.png"))); // NOI18N
        jPanel3.add(jLabel45);
        jLabel45.setBounds(1090, 520, 60, 50);

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setLayout(null);

        btnsave.setFont(new java.awt.Font("Lucida Fax", 1, 11)); // NOI18N
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        btnsave.setText("Save");
        btnsave.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnsave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel10.add(btnsave);
        btnsave.setBounds(70, 20, 80, 40);

        btnedit.setFont(new java.awt.Font("Lucida Fax", 1, 11)); // NOI18N
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_b_edit.png"))); // NOI18N
        btnedit.setText("Edit");
        btnedit.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnedit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel10.add(btnedit);
        btnedit.setBounds(170, 20, 80, 40);

        btndelete.setFont(new java.awt.Font("Lucida Fax", 1, 11)); // NOI18N
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_b_empty.png"))); // NOI18N
        btndelete.setText("Delete");
        btndelete.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btndelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel10.add(btndelete);
        btndelete.setBounds(270, 20, 90, 40);

        btnclear.setFont(new java.awt.Font("Lucida Fax", 1, 11)); // NOI18N
        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_drop.png"))); // NOI18N
        btnclear.setText("Clear");
        btnclear.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnclear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnclearMouseClicked(evt);
            }
        });
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        jPanel10.add(btnclear);
        btnclear.setBounds(380, 20, 80, 40);

        jPanel3.add(jPanel10);
        jPanel10.setBounds(220, 650, 530, 90);

        tbl_mag.setModel(new javax.swing.table.DefaultTableModel(data,header));
        tbl_mag.setColumnSelectionAllowed(true);
        tbl_mag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_magMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_mag);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(890, 190, 730, 160);

        txtsearch.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtsearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        jPanel3.add(txtsearch);
        txtsearch.setBounds(1120, 140, 210, 30);

        tbl_searchMag.setModel(new javax.swing.table.DefaultTableModel(datas,headers));
        jScrollPane2.setViewportView(tbl_searchMag);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(1000, 570, 550, 150);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel17.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel17.setText("ISBN Barcode:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(90, 80, 100, 50);

        jLabel16.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel16.setText("Date of Acquisition:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(50, 120, 150, 30);

        jLabel13.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel13.setText("Magazine Title:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(80, 150, 100, 30);

        jLabel14.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel14.setText("Publisher:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(110, 180, 70, 30);

        jLabel41.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel41.setText("Edition Number:");
        jPanel2.add(jLabel41);
        jLabel41.setBounds(70, 210, 130, 30);

        jLabel42.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel42.setText("Page Volume:");
        jPanel2.add(jLabel42);
        jLabel42.setBounds(90, 240, 100, 30);

        jLabel43.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel43.setText("Place:");
        jPanel2.add(jLabel43);
        jLabel43.setBounds(130, 260, 50, 50);

        jLabel44.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel44.setText("Year:");
        jPanel2.add(jLabel44);
        jLabel44.setBounds(140, 300, 40, 30);

        label3.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        label3.setText("Status:");
        jPanel2.add(label3);
        label3.setBounds(130, 330, 70, 30);

        jLabel62.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel62.setText("Availability to be borrow outside:");
        jPanel2.add(jLabel62);
        jLabel62.setBounds(50, 390, 240, 30);

        status1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        status1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Damaged", "Lost" }));
        status1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        status1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                status1ItemStateChanged(evt);
            }
        });
        status1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                status1ActionPerformed(evt);
            }
        });
        jPanel2.add(status1);
        status1.setBounds(190, 330, 170, 30);

        available.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        available.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YES", "NO" }));
        available.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(available);
        available.setBounds(270, 390, 90, 30);

        label1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        label1.setText("No of days:");
        jPanel2.add(label1);
        label1.setBounds(100, 360, 80, 30);

        days.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        days.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----", "3", "2", "1" }));
        days.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(days);
        days.setBounds(190, 360, 90, 30);

        yearMagazine.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(yearMagazine);
        yearMagazine.setBounds(190, 300, 80, 30);

        txtplace.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtplace.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplaceActionPerformed(evt);
            }
        });
        txtplace.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtplaceKeyTyped(evt);
            }
        });
        jPanel2.add(txtplace);
        txtplace.setBounds(190, 270, 240, 30);

        txtpageVol.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtpageVol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtpageVol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpageVolKeyTyped(evt);
            }
        });
        jPanel2.add(txtpageVol);
        txtpageVol.setBounds(190, 240, 90, 30);

        txtedNum.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtedNum.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtedNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtedNumActionPerformed(evt);
            }
        });
        txtedNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtedNumKeyTyped(evt);
            }
        });
        jPanel2.add(txtedNum);
        txtedNum.setBounds(190, 210, 90, 30);

        txtPublisher.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtPublisher.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtPublisher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPublisherKeyTyped(evt);
            }
        });
        jPanel2.add(txtPublisher);
        txtPublisher.setBounds(190, 180, 240, 30);

        txtMagazineTitle.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtMagazineTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtMagazineTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMagazineTitleActionPerformed(evt);
            }
        });
        txtMagazineTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMagazineTitleKeyTyped(evt);
            }
        });
        jPanel2.add(txtMagazineTitle);
        txtMagazineTitle.setBounds(190, 150, 238, 30);

        magazineDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        magazineDate.setDateFormatString("MM-dd-yyyy");
        magazineDate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jPanel2.add(magazineDate);
        magazineDate.setBounds(190, 120, 240, 30);

        txtBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarcodeActionPerformed(evt);
            }
        });
        txtBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyTyped(evt);
            }
        });
        jPanel2.add(txtBarcode);
        txtBarcode.setBounds(190, 90, 240, 30);

        updateDate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        updateDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(updateDate);
        updateDate.setBounds(190, 120, 180, 30);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(220, 90, 530, 510);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(null);

        jLabel46.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel46.setText("Total:");
        jPanel4.add(jLabel46);
        jLabel46.setBounds(110, 50, 50, 30);

        total.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        total.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.add(total);
        total.setBounds(150, 50, 60, 30);

        btnAcccess.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnAcccess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        btnAcccess.setText("Save");
        btnAcccess.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnAcccess.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAcccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcccessActionPerformed(evt);
            }
        });
        jPanel4.add(btnAcccess);
        btnAcccess.setBounds(270, 50, 70, 30);

        accession.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        accession.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        accession.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                accessionKeyReleased(evt);
            }
        });
        jPanel4.add(accession);
        accession.setBounds(150, 10, 140, 30);

        jLabel48.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel48.setText("Accession Number:");
        jPanel4.add(jLabel48);
        jLabel48.setBounds(20, 10, 150, 30);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(1070, 420, 370, 100);

        jLabel47.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_search.png"))); // NOI18N
        jPanel3.add(jLabel47);
        jLabel47.setBounds(1090, 140, 30, 30);

        accessSearch.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        accessSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        accessSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessSearchActionPerformed(evt);
            }
        });
        accessSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                accessSearchKeyReleased(evt);
            }
        });
        jPanel3.add(accessSearch);
        accessSearch.setBounds(1120, 530, 200, 30);

        btnPrintmaga.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnPrintmaga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        btnPrintmaga.setText("Print");
        btnPrintmaga.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnPrintmaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintmagaActionPerformed(evt);
            }
        });
        jPanel3.add(btnPrintmaga);
        btnPrintmaga.setBounds(1340, 140, 90, 30);

        btnAccessprint.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnAccessprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        btnAccessprint.setText("Print");
        btnAccessprint.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnAccessprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccessprintActionPerformed(evt);
            }
        });
        jPanel3.add(btnAccessprint);
        btnAccessprint.setBounds(1340, 530, 90, 30);

        book.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        book.setText("Magazine");
        jPanel3.add(book);
        book.setBounds(20, 10, 150, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 1660, 930);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1690, 920);

        setSize(new java.awt.Dimension(1705, 980));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMagazineTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMagazineTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMagazineTitleActionPerformed

    private void txtMagazineTitleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMagazineTitleKeyTyped

    }//GEN-LAST:event_txtMagazineTitleKeyTyped

    private void txtPublisherKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPublisherKeyTyped

    }//GEN-LAST:event_txtPublisherKeyTyped

    private void txtBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBarcodeActionPerformed

    private void txtBarcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtBarcodeKeyTyped

    private void txtedNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtedNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtedNumActionPerformed

    private void txtedNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtedNumKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtedNumKeyTyped

    private void txtpageVolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpageVolKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtpageVolKeyTyped

    private void txtplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtplaceActionPerformed

    private void txtplaceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtplaceKeyTyped

    }//GEN-LAST:event_txtplaceKeyTyped

    private void btnclearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclearMouseClicked

        magazineDate.setDateFormatString("");
        txtMagazineTitle.setText("");
        txtPublisher.setText("");
        txtedNum.setText("");
        txtpageVol.setText("");
        txtplace.setText("");
        txtBarcode.setText("");
    }//GEN-LAST:event_btnclearMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        String query = "DELETE FROM `tbl_magazine` WHERE ISBNBarcode = " + txtBarcode.getText();
        executeSqlQuery(query, "Deleted");

        txtBarcode.setText("");
        magazineDate.setDateFormatString("");
        txtMagazineTitle.setText("");
        txtPublisher.setText("");
        txtedNum.setText("");
        txtpageVol.setText("");
        txtplace.setText("");
        updateDate.setText("");
        
        txtBarcode.setEnabled(true);
        magazineDate.setEnabled(false);
        txtMagazineTitle.setEnabled(false);
        txtPublisher.setEnabled(false);
        txtedNum.setEnabled(false);
        txtpageVol.setEnabled(false);
        txtplace.setEnabled(false);
        days.setEnabled(false);
        status1.setEnabled(false);
        available.setEnabled(false);
        yearMagazine.setEnabled(false);
        updateDate.setEnabled(false);
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        txtBarcode.setEnabled(true);
        magazineDate.setEnabled(false);
        txtMagazineTitle.setEnabled(false);
        txtPublisher.setEnabled(false);
        txtedNum.setEnabled(false);
        txtpageVol.setEnabled(false);
        txtplace.setEnabled(false);
        days.setEnabled(false);
        status1.setEnabled(false);
        available.setEnabled(false);
        yearMagazine.setEnabled(false);
        updateDate.setEnabled(false);

        try {
            String query = "UPDATE `tbl_magazine` SET `ISBNBarcode`='" + txtBarcode.getText() + "',`DateAcquisition`='" + updateDate.getText() + "',`M_Title`='" + txtMagazineTitle.getText() + "',`M_Publisher`='" + txtPublisher.getText() + "',`EditionNumber`='" + txtedNum.getText() + "',`PageVolume`='" + txtpageVol.getText() + "',`Place`='" + txtplace.getText() + "',`Year`='" + yearMagazine.getYear() + "'WHERE ISBNBarcode =" + txtBarcode.getText();
            executeSqlQuery(query, "Update");
            
            txtBarcode.setText("");
            magazineDate.setDateFormatString("");
            txtMagazineTitle.setText("");
            txtPublisher.setText("");
            txtedNum.setText("");
            txtpageVol.setText("");
            txtplace.setText("");
            updateDate.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btneditActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed

        if (txtBarcode.getText().trim().isEmpty() || txtMagazineTitle.getText().trim().isEmpty() || txtPublisher.getText().trim().isEmpty() || txtedNum.getText().trim().isEmpty() || txtpageVol.getText().trim().isEmpty() || txtplace.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty");
        } else {

            SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
            String dateBook = s.format(magazineDate.getDate());
            String tempisbnBarcode = txtBarcode.getText();
            String query = "INSERT INTO `tbl_magazine` VALUES ('" + Global_Variable.mat_id + "','" + tempisbnBarcode + "','" + dateBook + "','" + txtMagazineTitle.getText() + "','" + txtPublisher.getText() + "','" + txtedNum.getText() + "','" + txtpageVol.getText() + "','" + txtplace.getText() + "','" + yearMagazine.getYear() + "','" + Global_Variable.category_id + "','" + total.getText() + "','" + status1.getSelectedItem() + "','" + days.getSelectedItem() + "','" + available.getSelectedItem() + "')";
            executeSqlQuery(query, "Added");

            txtBarcode.setText("");
            magazineDate.setDateFormatString("");
            txtMagazineTitle.setText("");
            txtPublisher.setText("");
            txtedNum.setText("");
            txtpageVol.setText("");
            txtplace.setText("");

          /*  txtBarcode.setEnabled(true);
            updateDate.setEnabled(false);
            magazineDate.setEnabled(false);
            txtMagazineTitle.setEnabled(false);
            txtPublisher.setEnabled(false);
            txtedNum.setEnabled(false);
            txtpageVol.setEnabled(false);
            txtplace.setEnabled(false);
            yearMagazine.setEnabled(false);
            status1.setEnabled(false);
            days.setEnabled(false);
            available.setEnabled(false);*/

        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void tbl_magMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_magMouseClicked
        updateDate.show();
        magazineDate.hide();
        
        txtBarcode.setEnabled(true);
        updateDate.setEnabled(true);
        magazineDate.setEnabled(true);
        txtMagazineTitle.setEnabled(true);
        txtPublisher.setEnabled(true);
        txtedNum.setEnabled(true);
        txtpageVol.setEnabled(true);
        txtplace.setEnabled(true);
        yearMagazine.setEnabled(true);
        status1.setEnabled(true);
        days.setEnabled(true);
        available.setEnabled(true);
        
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        btnedit.setEnabled(true);
        btndelete.setEnabled(true);

        try {
            int row = tbl_mag.getSelectedRow();
            String cell_click = (tbl_mag.getModel().getValueAt(row, 1).toString());

            String query = "Select * from tbl_magazine where ISBNBarcode = '" + cell_click + "'";

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.prepareStatement(query);
            rs = st.executeQuery(query); 
             
            if (rs.next()) {
                String barcode = rs.getString("ISBNBarcode");
                txtBarcode.setText(barcode);

                String date = rs.getString("DateAcquisition");
                updateDate.setText(date);

                String title = rs.getString("M_Title");
                txtMagazineTitle.setText(title);

                String publisher = rs.getString("M_Publisher");
                txtPublisher.setText(publisher);

                String edition = rs.getString("EditionNumber");
                txtedNum.setText(edition);

                String page = rs.getString("PageVolume");
                txtpageVol.setText(page);
                
                String placemag = rs.getString("Place");
                txtplace.setText(placemag);

                int year = rs.getInt("Year");
                yearMagazine.setYear(year);

                String status = rs.getString("Status");
                status1.setSelectedItem(status);

                String day = rs.getString("days");
                days.setSelectedItem(day);

                String avail = rs.getString("Availability");
                available.setSelectedItem(avail);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        CountMagazine();
        int choice;
        choice = JOptionPane.showConfirmDialog(null, "Add accession number?");

        if (choice == JOptionPane.YES_OPTION) {
            accession.setEnabled(true);
            tbl_searchMag.setEnabled(false);

            accession.getText();

        }
    }//GEN-LAST:event_tbl_magMouseClicked

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void btnAcccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcccessActionPerformed
        try {
            String a = accession.getText();
            int access = Integer.valueOf(a);
            a = Integer.toString(++access);

            String query = "Insert into tbl_magazineaccession values ('" + Global_Variable.accmagazineId + "','" + accession.getText() + "','" + txtBarcode.getText() + "','"+txtMagazineTitle.getText()+"','"+txtedNum.getText()+"','"+txtPublisher.getText()+"','"+total.getText()+"','"+Global_Variable.category_id+"')";
            executeSqlQuery(query, "Successfully Added");
            accession.setText(a);
            CountMagazine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String queries = "UPDATE `tbl_magazine` SET  `NoofCopies` ='" + total.getText() + "' WHERE  `ISBNBarcode` =" + txtBarcode.getText();
            executeSqlQuery(queries, "updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAcccessActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        txtBarcode.setText("");
        magazineDate.setDateFormatString("");
        txtMagazineTitle.setText("");
        txtPublisher.setText("");
        txtedNum.setText("");
        txtpageVol.setText("");
        txtplace.setText("");
    }//GEN-LAST:event_btnclearActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        String temp1 = txtsearch.getText() + "%";

        data = theSearch("Select * from tbl_magazine where ISBNBarcode like '" + temp1 + "' || M_Title like '" + temp1 + "'");

        tbl_mag.setModel(new javax.swing.table.DefaultTableModel(data, header));

        tbl_mag.removeColumn(tbl_mag.getColumnModel().getColumn(0));
    }//GEN-LAST:event_txtsearchKeyReleased

    private void accessSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accessSearchKeyReleased
        String temp1 = accessSearch.getText() + "%";
        datas = SearchAccession("Select * from tbl_magazineaccession where accession like '" + temp1 + "' || ISBNBarcode like '" + temp1 + "'");

        tbl_searchMag.setModel(new javax.swing.table.DefaultTableModel(datas, headers));

        tbl_searchMag.removeColumn(tbl_searchMag.getColumnModel().getColumn(0));
    }//GEN-LAST:event_accessSearchKeyReleased

    private void btnPrintmagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintmagaActionPerformed
        MessageFormat header = new MessageFormat("Magazine Reports");
        MessageFormat footer = new MessageFormat("page{0,number,integer}");
        try {

            tbl_mag.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("can not print %s %n", e.getMessage());
        }
    }//GEN-LAST:event_btnPrintmagaActionPerformed

    private void btnAccessprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccessprintActionPerformed
        MessageFormat header = new MessageFormat("Magazine accessions with ISBNBarcode Reports");
        MessageFormat footer = new MessageFormat("page{0,number,integer}");
        try {

            tbl_searchMag.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("can not print %s %n", e.getMessage());
        }
    }//GEN-LAST:event_btnAccessprintActionPerformed

    private void status1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_status1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_status1ActionPerformed

    private void accessSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accessSearchActionPerformed

    private void txtBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyReleased
        txtBarcode.setEnabled(true);
        magazineDate.setEnabled(true);
        txtMagazineTitle.setEnabled(true);
        txtPublisher.setEnabled(true);
        txtedNum.setEnabled(true);
        txtpageVol.setEnabled(true);
        txtplace.setEnabled(true);
        yearMagazine.setEnabled(true);
        status1.setEnabled(true);
        days.setEnabled(true);
        available.setEnabled(true);
    }//GEN-LAST:event_txtBarcodeKeyReleased

    private void accessionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accessionKeyReleased
      if(validateBarcode(accession.getText())){
          JOptionPane.showMessageDialog(null,"Duplicate Accession Number!");
      }
    }//GEN-LAST:event_accessionKeyReleased

    private void status1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_status1ItemStateChanged
       switch (status1.getSelectedItem().toString()) {
            case "Available":
                days.setEnabled(true);
                available.setEnabled(true);
                break;
            case "Damaged":
                days.setEnabled(false);
                available.setEnabled(false);
                break;
            case "Lost":
                days.setEnabled(false);
                available.setEnabled(false);
                break;
            default:
                status1.setEnabled(false);
                break;
        }
    }//GEN-LAST:event_status1ItemStateChanged

    private void CountMagazine() {
        try {
            String q = "SELECT COUNT(ISBNBarcode) AS ISBNBarcode FROM tbl_magazineaccession where ISBNBarcode =" + txtBarcode.getText();

            ResultSet rs;
            PreparedStatement ps = con.dbconn().prepareStatement(q);
            rs = ps.executeQuery();
            if (rs.next()) {
                total.setText(rs.getString("ISBNBarcode"));
            }
        } catch (Exception e) {

        }
    }
    
      private boolean validateBarcode(String Barcode) {
        boolean queue = false;
        ResultSet rs;
        //String barcode = adminbarcode.getText();
        String query;
        try {
            query = "select id from `tbl_magazineaccession` where accession='" + Barcode + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                queue = true;
                //rs.getString("adminBarcode");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return queue;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accessSearch;
    private javax.swing.JTextField accession;
    private javax.swing.JComboBox available;
    private javax.swing.JLabel book;
    private javax.swing.JButton btnAcccess;
    private javax.swing.JButton btnAccessprint;
    private javax.swing.JButton btnPrintmaga;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox days;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private com.toedter.calendar.JDateChooser magazineDate;
    private javax.swing.JComboBox status1;
    private javax.swing.JTable tbl_mag;
    private javax.swing.JTable tbl_searchMag;
    private javax.swing.JTextField total;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtMagazineTitle;
    private javax.swing.JTextField txtPublisher;
    private javax.swing.JTextField txtedNum;
    private javax.swing.JTextField txtpageVol;
    private javax.swing.JTextField txtplace;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField updateDate;
    private com.toedter.calendar.JYearChooser yearMagazine;
    // End of variables declaration//GEN-END:variables

    private Vector<Vector<String>> theSearch(String sqlSearch) {
        Vector<Vector<String>> magazine = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> magz = new Vector<String>();
                magz.add(rs.getString(1));
                magz.add(rs.getString(2));
                magz.add(rs.getString(4));
                magz.add(rs.getString(10));
                magz.add(rs.getString(11));
                magz.add(rs.getString(12));
                magz.add(rs.getString(14));

                magazine.add(magz);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return magazine;
    }

    private Vector<Vector<String>> SearchAccession(String sqlSearch) {
        Vector<Vector<String>> magazineaccess = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> MagazineAccess = new Vector<String>();
                MagazineAccess.add(rs.getString(1));
                MagazineAccess.add(rs.getString(2));
                MagazineAccess.add(rs.getString(3));
                magazineaccess.add(MagazineAccess);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return magazineaccess;
    }
}
