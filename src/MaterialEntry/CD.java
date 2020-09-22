package MaterialEntry;

import Accession_Classes.C_CDAccession;
import Classes.C_LibraryMaterialCD;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CD extends javax.swing.JFrame {

    Statement st = null;
    ResultSet rs;
    dbConn con = new dbConn();

    private Vector<Vector<String>> data;
    private Vector<String> header;

    private Vector<Vector<String>> datas;
    private Vector<String> headers;

    public CD() throws Exception {

        Conn connection = new Conn();
        data = connection.getCD();
        header = new Vector<String>();

        Conn connections = new Conn();

        datas = connections.getCDAccession();
        headers = new Vector<String>();

        header.add("id");
        header.add("Barcode");
        header.add("CD Title"); 
        header.add("Copies");
        header.add("Status");
        header.add("Availability");

        headers.add("id");
        headers.add("accession");
        headers.add("ISBNBarcode");
        initComponents();

        txtBarcode.setEnabled(true);
        dateCD.setEnabled(false);
        txtCdTitle.setEnabled(false);
        txtednum.setEnabled(false);
        txtplace.setEnabled(false);
        txtproducer.setEnabled(false);
        comboGenre.setEnabled(false);
        days.setEnabled(false);
        available.setEnabled(false);
        status.setEnabled(false);
        updateCD.hide();
        accession.setEnabled(false);
        total.setEditable(false);
        Year.setEnabled(false);
        total.setText("0");

        tble_cd.removeColumn(tble_cd.getColumnModel().getColumn(0));
        tbl_access.removeColumn(tbl_access.getColumnModel().getColumn(0));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    } 
    //for cd query
    public void executeSQlquery(String query, String message) {
        try {
            st = null;
            st = con.dbconn().createStatement();
            if ((st.executeUpdate(query)) == 1) {
                Conn connecting = new Conn();
                data = connecting.getCD();
                //for setting the table for model
                tble_cd.setModel(new javax.swing.table.DefaultTableModel(data, header));

                tble_cd.removeColumn(tble_cd.getColumnModel().getColumn(0));

                Conn connectn = new Conn();
                datas = connectn.getCDAccession();
                //for setting the table for model
                tbl_access.setModel(new javax.swing.table.DefaultTableModel(datas, headers));

                tbl_access.removeColumn(tbl_access.getColumnModel().getColumn(0));
                JOptionPane.showMessageDialog(null, message + " successfully");

            } else {
                JOptionPane.showMessageDialog(null, message + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        btnsave = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tble_cd = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_access = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtBarcode = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        dateCD = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        txtCdTitle = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtplace = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        Year = new com.toedter.calendar.JYearChooser();
        jLabel24 = new javax.swing.JLabel();
        comboGenre = new javax.swing.JComboBox();
        jLabel52 = new javax.swing.JLabel();
        txtednum = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtproducer = new javax.swing.JTextField();
        label3 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        updateCD = new javax.swing.JTextField();
        status = new javax.swing.JComboBox();
        days = new javax.swing.JComboBox();
        available = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        accession = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        searchAccess = new javax.swing.JTextField();
        book = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel5.setLayout(null);

        jLabel57.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_search.png"))); // NOI18N
        jPanel5.add(jLabel57);
        jLabel57.setBounds(1190, 470, 50, 30);

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setLayout(null);

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
        jPanel11.add(btnsave);
        btnsave.setBounds(60, 20, 90, 40);

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
        jPanel11.add(btnedit);
        btnedit.setBounds(170, 20, 90, 40);

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
        jPanel11.add(btndelete);
        btndelete.setBounds(280, 20, 110, 40);

        btnclear.setFont(new java.awt.Font("Lucida Fax", 1, 11)); // NOI18N
        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_drop.png"))); // NOI18N
        btnclear.setText("Clear");
        btnclear.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnclear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        jPanel11.add(btnclear);
        btnclear.setBounds(410, 20, 90, 40);

        jPanel5.add(jPanel11);
        jPanel11.setBounds(230, 580, 560, 80);

        tble_cd.setModel(new javax.swing.table.DefaultTableModel(data,header));
        tble_cd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tble_cdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tble_cd);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(920, 170, 830, 130);

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
        jPanel5.add(txtsearch);
        txtsearch.setBounds(1180, 130, 300, 30);

        tbl_access.setModel(new javax.swing.table.DefaultTableModel(datas,headers));
        jScrollPane2.setViewportView(tbl_access);

        jPanel5.add(jScrollPane2);
        jScrollPane2.setBounds(960, 510, 740, 160);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        txtBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarcodeActionPerformed(evt);
            }
        });
        txtBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyTyped(evt);
            }
        });
        jPanel2.add(txtBarcode);
        txtBarcode.setBounds(200, 60, 270, 30);

        jLabel25.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel25.setText("ISBN Barcode:");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(100, 60, 100, 40);

        jLabel26.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel26.setText("Date of Acquisition:");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(60, 100, 150, 20);

        dateCD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        dateCD.setDateFormatString("MM-dd-yyyy");
        dateCD.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jPanel2.add(dateCD);
        dateCD.setBounds(200, 90, 270, 30);

        jLabel23.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel23.setText("CD Title:");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(120, 120, 70, 40);

        txtCdTitle.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtCdTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtCdTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCdTitleActionPerformed(evt);
            }
        });
        txtCdTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCdTitleKeyTyped(evt);
            }
        });
        jPanel2.add(txtCdTitle);
        txtCdTitle.setBounds(200, 120, 270, 30);

        jLabel54.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel54.setText("Place:");
        jPanel2.add(jLabel54);
        jLabel54.setBounds(150, 160, 50, 20);

        txtplace.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtplace.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtplace.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtplaceKeyTyped(evt);
            }
        });
        jPanel2.add(txtplace);
        txtplace.setBounds(200, 150, 270, 30);

        jLabel56.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel56.setText("Year:");
        jPanel2.add(jLabel56);
        jLabel56.setBounds(150, 190, 60, 20);

        Year.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(Year);
        Year.setBounds(200, 180, 130, 30);

        jLabel24.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel24.setText("Genre:");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(140, 220, 50, 20);

        comboGenre.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        comboGenre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Filipino", "Science and Technology", "English", "Math", "Arts", "History", " " }));
        comboGenre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        comboGenre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                comboGenreKeyTyped(evt);
            }
        });
        jPanel2.add(comboGenre);
        comboGenre.setBounds(200, 210, 270, 30);

        jLabel52.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel52.setText("Edition Number:");
        jPanel2.add(jLabel52);
        jLabel52.setBounds(80, 250, 130, 20);

        txtednum.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtednum.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtednum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtednumActionPerformed(evt);
            }
        });
        txtednum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtednumKeyTyped(evt);
            }
        });
        jPanel2.add(txtednum);
        txtednum.setBounds(200, 240, 130, 30);

        jLabel59.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel59.setText("Producer:");
        jPanel2.add(jLabel59);
        jLabel59.setBounds(120, 280, 70, 20);

        txtproducer.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtproducer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtproducer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtproducerKeyTyped(evt);
            }
        });
        jPanel2.add(txtproducer);
        txtproducer.setBounds(200, 270, 260, 30);

        label3.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        label3.setText("Status:");
        jPanel2.add(label3);
        label3.setBounds(140, 300, 70, 30);

        label1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        label1.setText("No of days:");
        jPanel2.add(label1);
        label1.setBounds(110, 330, 80, 30);

        jLabel62.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel62.setText("Availability to be borrow outside:");
        jPanel2.add(jLabel62);
        jLabel62.setBounds(60, 360, 240, 30);

        updateCD.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        updateCD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        updateCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCDActionPerformed(evt);
            }
        });
        updateCD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                updateCDKeyReleased(evt);
            }
        });
        jPanel2.add(updateCD);
        updateCD.setBounds(200, 90, 270, 30);

        status.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Damaged", "Lost" }));
        status.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        status.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statusItemStateChanged(evt);
            }
        });
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel2.add(status);
        status.setBounds(200, 300, 300, 30);

        days.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        days.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---", "5", "4", "3", "2", "1" }));
        days.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(days);
        days.setBounds(200, 330, 90, 30);

        available.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        available.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YES", "NO" }));
        available.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(available);
        available.setBounds(270, 360, 70, 30);

        jPanel5.add(jPanel2);
        jPanel2.setBounds(230, 80, 560, 450);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        jLabel60.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel60.setText("Accession Number:");
        jPanel3.add(jLabel60);
        jLabel60.setBounds(20, 10, 140, 30);

        jLabel55.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel55.setText("Total:");
        jPanel3.add(jLabel55);
        jLabel55.setBounds(100, 50, 60, 30);

        total.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        total.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(total);
        total.setBounds(150, 50, 60, 30);

        accession.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        accession.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        accession.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                accessionKeyReleased(evt);
            }
        });
        jPanel3.add(accession);
        accession.setBounds(150, 10, 140, 30);

        jButton1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(330, 30, 80, 30);

        jPanel5.add(jPanel3);
        jPanel3.setBounds(1120, 360, 450, 90);

        jLabel58.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_search.png"))); // NOI18N
        jPanel5.add(jLabel58);
        jLabel58.setBounds(1150, 130, 30, 30);

        searchAccess.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        searchAccess.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        searchAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAccessActionPerformed(evt);
            }
        });
        searchAccess.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchAccessKeyReleased(evt);
            }
        });
        jPanel5.add(searchAccess);
        searchAccess.setBounds(1220, 470, 260, 30);

        book.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        book.setText("CD");
        jPanel5.add(book);
        book.setBounds(70, 10, 70, 40);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(90, 0, 1860, 890);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-140, 0, 1960, 890);

        setSize(new java.awt.Dimension(1833, 942));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCdTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCdTitleActionPerformed

    }//GEN-LAST:event_txtCdTitleActionPerformed

    private void txtCdTitleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCdTitleKeyTyped

    }//GEN-LAST:event_txtCdTitleKeyTyped

    private void comboGenreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboGenreKeyTyped

    }//GEN-LAST:event_comboGenreKeyTyped

    private void txtBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBarcodeActionPerformed

    private void txtBarcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyTyped

    }//GEN-LAST:event_txtBarcodeKeyTyped

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed

        if (txtBarcode.getText().trim().isEmpty() || dateCD.getDateFormatString().trim().isEmpty() || txtCdTitle.getText().trim().isEmpty() || txtednum.getText().trim().isEmpty() || txtplace.getText().trim().isEmpty() || txtproducer.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty");
        } else {

            SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
            String datecd = s.format(dateCD.getDate());
            String tempcdBarcode = txtBarcode.getText();
            String query = "INSERT INTO `tbl_cd` VALUES ('" + Global_Variable.CdId + "','" + tempcdBarcode + "','" + datecd + "','" + txtCdTitle.getText() + "','" + txtednum.getText() + "','" + txtplace.getText() + "','" + txtproducer.getText() + "','" + Year.getYear() + "','" + comboGenre.getSelectedItem()+ "','" + total.getText() + "','" + status.getSelectedItem() + "','" + days.getSelectedItem() + "','" + available.getSelectedItem() + "')";
            executeSQlquery(query, txtCdTitle.getText()+" added");

            dateCD.setDateFormatString("");
            txtCdTitle.setText("");
            txtednum.setText("");
            txtplace.setText("");
            txtproducer.setText("");
            comboGenre.setSelectedItem("");
            txtBarcode.setText("");
            accession.setText("");

            txtBarcode.setEnabled(true);
            dateCD.setEnabled(false);
            updateCD.setEnabled(false);
            txtCdTitle.setEnabled(false);
            txtednum.setEnabled(false);
            txtplace.setEnabled(false);
            txtproducer.setEnabled(false);
            comboGenre.setEnabled(false);
            days.setEnabled(false);
            available.setEnabled(false);
            status.setEnabled(false);
            Year.setEnabled(false); 
        }
       
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        dateCD.setEnabled(true);
        txtCdTitle.setEnabled(true);
        txtednum.setEnabled(true);
        txtplace.setEnabled(true);
        txtproducer.setEnabled(true);
        comboGenre.setEnabled(true);
        txtBarcode.setEnabled(true);
        updateCD.setEnabled(true);
        try {
            String query = "UPDATE `tbl_cd` SET `cd_Barcode`='" + txtBarcode.getText() + "',`cd_DateAcquisition`='" + updateCD.getText() + "',`cd_Title`='" + txtCdTitle.getText() + "',`cd_EditionNumber`='" + txtednum.getText() + "',`cd_Place`='" + txtplace.getText() + "',`cd_Producer`='" + txtproducer.getText() + "',`cd_Year`='" + Year.getYear() + "',`cd_Genre`='" + comboGenre.getSelectedItem() + "' WHERE cd_Barcode=" + txtBarcode.getText();
            executeSQlquery(query, txtCdTitle.getText()+" updated");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }//GEN-LAST:event_btneditActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        String query = "DELETE FROM `tbl_cd` WHERE `cd_Barcode`='" + txtBarcode.getText() + "'";
        executeSQlquery(query, txtCdTitle.getText()+" deleted");
        dateCD.setDateFormatString("");
        txtCdTitle.setText("");
        txtednum.setText("");
        txtplace.setText("");
        txtproducer.setText("");
        comboGenre.setSelectedItem("");
        txtBarcode.setText(""); 
         accession.setText("");
        total.setText("");
        
        dateCD.setEnabled(false);
        txtCdTitle.setEnabled(false);
        txtednum.setEnabled(false);
        txtplace.setEnabled(false);
        txtproducer.setEnabled(false);
        comboGenre.setEnabled(false);
        txtBarcode.setEnabled(true);
        updateCD.setEnabled(false);
        Year.setEnabled(false);
        status.setEnabled(false);
        days.setEnabled(false);
        available.setEnabled(false);
        dateCD.show();
        updateCD.hide();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        dateCD.show();
        updateCD.hide();
        dateCD.setDateFormatString("");
        txtCdTitle.setText("");
        txtednum.setText("");
        txtplace.setText("");
        txtproducer.setText("");
        comboGenre.setSelectedItem("");
        txtBarcode.setText(""); 
    }//GEN-LAST:event_btnclearActionPerformed

    private void txtednumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtednumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtednumActionPerformed

    private void txtednumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtednumKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            getToolkit().beep();
            evt.consume(); 
        }
    }//GEN-LAST:event_txtednumKeyTyped

    private void txtplaceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtplaceKeyTyped

    }//GEN-LAST:event_txtplaceKeyTyped

    private void txtproducerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtproducerKeyTyped

    }//GEN-LAST:event_txtproducerKeyTyped

    private void txtBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyPressed

    }//GEN-LAST:event_txtBarcodeKeyPressed

    private void tble_cdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tble_cdMouseClicked
        updateCD.show();
        dateCD.hide();
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        btnedit.setEnabled(true);
        btndelete.setEnabled(true);
        dateCD.setEnabled(true);
        txtCdTitle.setEnabled(true);
        txtednum.setEnabled(true);
        txtplace.setEnabled(true);
        txtproducer.setEnabled(true);
        comboGenre.setEnabled(true);
        txtBarcode.setEnabled(true);
        status.setEnabled(true);
        days.setEnabled(true);
        available.setEnabled(true);
        Year.setEnabled(true);
        updateCD.setEnabled(true);
        try {
            
            int row = tble_cd.getSelectedRow();
            String cell_click = (tble_cd.getModel().getValueAt(row, 1).toString());

            String query = "Select * from tbl_cd where cd_Barcode = '" + cell_click + "'"; 
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.prepareStatement(query);
            rs = st.executeQuery(query);  
            if (rs.next()) {
                //to display the data inside the txtfields
                String barcode = rs.getString("cd_Barcode");
                txtBarcode.setText(barcode);

                String date = rs.getString("cd_DateAcquisition");
                updateCD.setText(date);

                String title = rs.getString("cd_Title");
                txtCdTitle.setText(title);

                String edition = rs.getString("cd_EditionNumber");
                txtednum.setText(edition);

                String place = rs.getString("cd_Place");
                txtplace.setText(place);

                String producer = rs.getString("cd_Producer");
                txtproducer.setText(producer);

                int year = rs.getInt("cd_Year");
                Year.setYear(year);

                String genre = rs.getString("cd_Genre");
                comboGenre.setSelectedItem(genre);

                String statuss = rs.getString("Status");
                status.setSelectedItem(statuss);

                String  day = rs.getString("days");
                days.setSelectedItem(day);

                String availa = rs.getString("Availability");
                available.setSelectedItem(availa); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
         
        int choice;
        choice = JOptionPane.showConfirmDialog(null, "Add accession number?"); 
        if (choice == JOptionPane.YES_OPTION) {
            CountCD();  
            
            accession.setEnabled(true);
            tbl_access.setEnabled(false); 
            accession.getText(); 
        }  
         Connection cnn = null;
        Statement stt = null;
        ResultSet rss = null;
        
        try { 
            String query = "Select * from tbl_cdaccession"; 
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            stt = cnn.prepareStatement(query);
            rss = stt.executeQuery(query); 
            if (rss.next()) {  
                int a;
                a = Integer.parseInt(total.getText());
                if (a == 0){
                    accession.setText("");
                } 
                else{
                    String accessnum = rss.getString("accession");
                    accession.setText(accessnum); 
                } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tble_cdMouseClicked

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String a = accession.getText();
            int access = Integer.valueOf(a);
            a = Integer.toString(++access);

            String queries = "Insert into tbl_cdaccession values ('" + Global_Variable.acccdId + "','" + accession.getText() + "','" + txtBarcode.getText() + "','"+txtCdTitle.getText()+"','"+comboGenre.getSelectedItem()+"')";
            executeSQlquery(queries, "Accession number for " +txtCdTitle.getText()+" added");
            accession.setText(a);
            CountCD();
            status.setSelectedItem(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String query = "UPDATE  `tbl_cd` SET  `Copies` ='" + total.getText() + "' WHERE  `cd_Barcode` =" + txtBarcode.getText();
            executeSQlquery(query, "Number of copies for "+txtCdTitle.getText()+" updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        String temp1 = txtsearch.getText() + "%"; 
        data = theSearch("Select * from tbl_cd where cd_Barcode like '" + temp1 + "' || cd_Title like '" + temp1 + "'|| Status like '"+temp1+"'");
        tble_cd.setModel(new javax.swing.table.DefaultTableModel(data, header)); 
        tble_cd.removeColumn(tble_cd.getColumnModel().getColumn(0));
    }//GEN-LAST:event_txtsearchKeyReleased

    private void searchAccessKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchAccessKeyReleased
        String temp1 = searchAccess.getText() + "%";
        datas = SearchAccession("Select * from tbl_cdaccession where accession like '" + temp1 + "' || ISBNBarcode like '" + temp1 + "'");

        tbl_access.setModel(new javax.swing.table.DefaultTableModel(datas, headers));

        tbl_access.removeColumn(tbl_access.getColumnModel().getColumn(0));
    }//GEN-LAST:event_searchAccessKeyReleased

    private void searchAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAccessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchAccessActionPerformed

    private void updateCDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateCDKeyReleased
        updateCD.hide();
        dateCD.show();
    }//GEN-LAST:event_updateCDKeyReleased

    private void txtBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyReleased
        txtBarcode.setEnabled(true);
        dateCD.setEnabled(true);
        txtCdTitle.setEnabled(true);
        txtednum.setEnabled(true);
        txtplace.setEnabled(true);
        txtproducer.setEnabled(true);
        comboGenre.setEnabled(true);
        days.setEnabled(true);
        available.setEnabled(true);
        status.setEnabled(true);
        Year.setEnabled(true);
    }//GEN-LAST:event_txtBarcodeKeyReleased

    private void accessionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accessionKeyReleased
     if(validateBarcode(accession.getText())){
         JOptionPane.showMessageDialog(null, "Duplicate accession number");
     }
    }//GEN-LAST:event_accessionKeyReleased

    private void updateCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateCDActionPerformed

    private void statusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statusItemStateChanged
        switch (status.getSelectedItem().toString()) {
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
            status.setEnabled(false);
            break;
        }
    }//GEN-LAST:event_statusItemStateChanged

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    //to get the cd type for the database
    private String validatecdType() {
        Statement st;
        String id = "";
        ResultSet rs;
        String query;
        try {
            query = "select id from `tbl_booktype` where booktype='" + comboGenre.getSelectedItem().toString() + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    private void CountCD() {
        try {
            String q = "SELECT COUNT(ISBNBarcode) AS ISBNBarcode FROM tbl_cdaccession where ISBNBarcode =" + txtBarcode.getText();

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
        String query;
        try {
            query = "select id from `tbl_cdaccession` where accession='" + Barcode + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                queue = true; 
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queue;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser Year;
    private javax.swing.JTextField accession;
    private javax.swing.JComboBox available;
    private javax.swing.JLabel book;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox comboGenre;
    private com.toedter.calendar.JDateChooser dateCD;
    private javax.swing.JComboBox days;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JTextField searchAccess;
    private javax.swing.JComboBox status;
    private javax.swing.JTable tbl_access;
    private javax.swing.JTable tble_cd;
    private javax.swing.JTextField total;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtCdTitle;
    private javax.swing.JTextField txtednum;
    private javax.swing.JTextField txtplace;
    private javax.swing.JTextField txtproducer;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField updateCD;
    // End of variables declaration//GEN-END:variables
   
     private Vector<Vector<String>> theSearch(String sqlSearch) {
        Vector<Vector<String>> cd = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null; 
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> cds = new Vector<String>();
                cds.add(rs.getString(1));
                cds.add(rs.getString(2));
                cds.add(rs.getString(4));
                cds.add(rs.getString(10));
                cds.add(rs.getString(11));
                cds.add(rs.getString(12));
                cds.add(rs.getString(13));
                cd.add(cds); 
            }
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return cd;
    }

    private Vector<Vector<String>> SearchAccession(String sqlSearch) {
        Vector<Vector<String>> cdaccess = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> cdAccess = new Vector<String>();
                cdAccess.add(rs.getString(1));
                cdAccess.add(rs.getString(2));
                cdAccess.add(rs.getString(3));
                cdaccess.add(cdAccess);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return cdaccess;
    }
}
