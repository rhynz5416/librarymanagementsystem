package Borrowing;

import Classes.C_LibraryMaterialCD;
import Global_Variable.Global_Variable;
import Module.dbConn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import mainframe.RENEWALFORM;

public class CDBORROW extends javax.swing.JFrame {

    dbConn con = new dbConn();
    Statement st;
    ResultSet rs;

    public CDBORROW() {
        initComponents();
        showCdDate();
        showCdTime();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        txtBorrow_cdBarcode.setEnabled(false);
        txtBorrow_cdAccNo.setEnabled(true);

        txt_Borrow_cdRCBarcode.setEnabled(false);
        txt_Borrow_cdBorrowerName.setEnabled(false);
        txt_Borrow_cdBorrowerGender.setEnabled(false);
        txt_Borrow_cdBorrowerAddress.setEnabled(false);
        txtBorrow_cdBorrowerType.setEnabled(false);
        copies.setEnabled(false);
        txtBorrow_cdTitle.setEnabled(false);
        txt_Borrow_cdGenre.setEnabled(false);

    }

    void showCdDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
        labelDate.setText(s.format(d));
    }

    void showCdTime() {
        new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm");
                labelTime.setText(s.format(d));
            }

        }).start();
    }

    public ArrayList<C_LibraryMaterialCD> getcdList() {
        ArrayList<C_LibraryMaterialCD> CD = new ArrayList<C_LibraryMaterialCD>();

        String query = "select * from `tbl_cd` where cd_Barcode=" + Global_Variable.CdId;

        ResultSet sr;

        try {
            st = null;
            st = con.dbconn().createStatement();
            sr = st.executeQuery(query);

            C_LibraryMaterialCD Cd;
            while (sr.next()) {
                Cd = new C_LibraryMaterialCD(sr.getInt("id"), sr.getString("cd_Barcode"), sr.getString("DateAcquisition"), sr.getString("cd_Title"), sr.getInt("EditionNumber"), sr.getString("Place"), sr.getString("Producer"), sr.getInt("Year"), sr.getString("cd_Genre"));
                CD.add(Cd);
            }

        } catch (Exception a) {
            a.printStackTrace();
        }
        return CD;
    }

    public void executeSQlquery(String query, String message) {
        try {
            st = con.dbconn().createStatement();
            if ((st.executeUpdate(query)) == 1) {
                JOptionPane.showMessageDialog(null, "Data " + message + " successfully");

            } else {
                JOptionPane.showMessageDialog(null, "Data " + message + " successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtBorrow_cdAccNo = new javax.swing.JTextField();
        txtBorrow_cdBarcode = new javax.swing.JTextField();
        txtBorrow_cdTitle = new javax.swing.JTextField();
        txt_Borrow_cdGenre = new javax.swing.JTextField();
        copies = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        datereq = new com.toedter.calendar.JDateChooser();
        txtBorrow_cdBorrowerType = new javax.swing.JTextField();
        txt_Borrow_cdBorrowerAddress = new javax.swing.JTextField();
        txt_Borrow_cdBorrowerGender = new javax.swing.JTextField();
        txt_Borrow_cdBorrowerName = new javax.swing.JTextField();
        txt_Borrow_cdRCBarcode = new javax.swing.JTextField();
        btninisdesave = new javax.swing.JButton();
        borrowinside = new javax.swing.JCheckBox();
        borrowoutside = new javax.swing.JCheckBox();
        btnoutsidesave = new javax.swing.JButton();
        labelDate = new javax.swing.JLabel();
        labelTime = new javax.swing.JLabel();
        cd = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel56.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel56.setText("Accession Number: ");
        jPanel2.add(jLabel56);
        jLabel56.setBounds(10, 10, 140, 40);

        jLabel55.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel55.setText("ISBN Barcode:");
        jPanel2.add(jLabel55);
        jLabel55.setBounds(40, 70, 100, 20);

        jLabel57.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel57.setText("Cd Title:");
        jPanel2.add(jLabel57);
        jLabel57.setBounds(70, 110, 80, 30);

        jLabel61.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel61.setText("Genre:");
        jPanel2.add(jLabel61);
        jLabel61.setBounds(80, 160, 50, 30);

        jLabel58.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel58.setText("No of Copies Available :");
        jPanel2.add(jLabel58);
        jLabel58.setBounds(50, 200, 150, 50);

        txtBorrow_cdAccNo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtBorrow_cdAccNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBorrow_cdAccNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBorrow_cdAccNoActionPerformed(evt);
            }
        });
        txtBorrow_cdAccNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBorrow_cdAccNoKeyReleased(evt);
            }
        });
        jPanel2.add(txtBorrow_cdAccNo);
        txtBorrow_cdAccNo.setBounds(150, 20, 150, 30);

        txtBorrow_cdBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtBorrow_cdBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBorrow_cdBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBorrow_cdBarcodeActionPerformed(evt);
            }
        });
        txtBorrow_cdBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBorrow_cdBarcodeKeyReleased(evt);
            }
        });
        jPanel2.add(txtBorrow_cdBarcode);
        txtBorrow_cdBarcode.setBounds(150, 60, 230, 30);

        txtBorrow_cdTitle.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtBorrow_cdTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBorrow_cdTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBorrow_cdTitleActionPerformed(evt);
            }
        });
        jPanel2.add(txtBorrow_cdTitle);
        txtBorrow_cdTitle.setBounds(150, 110, 230, 30);

        txt_Borrow_cdGenre.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_cdGenre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_Borrow_cdGenre);
        txt_Borrow_cdGenre.setBounds(150, 160, 230, 30);

        copies.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        copies.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(copies);
        copies.setBounds(210, 210, 80, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(430, 240, 450, 300);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        jLabel59.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel59.setText("Reader's Card Barcode:");
        jPanel3.add(jLabel59);
        jLabel59.setBounds(20, 90, 160, 30);

        jLabel60.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel60.setText("Name:");
        jPanel3.add(jLabel60);
        jLabel60.setBounds(120, 130, 50, 30);

        jLabel62.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel62.setText("Gender:");
        jPanel3.add(jLabel62);
        jLabel62.setBounds(120, 170, 60, 30);

        jLabel63.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel63.setText("Address:");
        jPanel3.add(jLabel63);
        jLabel63.setBounds(110, 210, 70, 20);

        jLabel65.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel65.setText("Borrowe Type:");
        jPanel3.add(jLabel65);
        jLabel65.setBounds(80, 250, 110, 20);

        jLabel64.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel64.setText("Date Return:");
        jPanel3.add(jLabel64);
        jLabel64.setBounds(90, 290, 100, 20);

        datereq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        datereq.setDateFormatString("MM-dd-yyyy");
        datereq.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jPanel3.add(datereq);
        datereq.setBounds(190, 290, 240, 30);

        txtBorrow_cdBorrowerType.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtBorrow_cdBorrowerType.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txtBorrow_cdBorrowerType);
        txtBorrow_cdBorrowerType.setBounds(190, 250, 240, 30);

        txt_Borrow_cdBorrowerAddress.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_cdBorrowerAddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txt_Borrow_cdBorrowerAddress);
        txt_Borrow_cdBorrowerAddress.setBounds(190, 210, 240, 30);

        txt_Borrow_cdBorrowerGender.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_cdBorrowerGender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txt_Borrow_cdBorrowerGender);
        txt_Borrow_cdBorrowerGender.setBounds(190, 170, 110, 30);

        txt_Borrow_cdBorrowerName.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_cdBorrowerName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txt_Borrow_cdBorrowerName);
        txt_Borrow_cdBorrowerName.setBounds(190, 130, 240, 30);

        txt_Borrow_cdRCBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_cdRCBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Borrow_cdRCBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Borrow_cdRCBarcodeActionPerformed(evt);
            }
        });
        txt_Borrow_cdRCBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Borrow_cdRCBarcodeKeyReleased(evt);
            }
        });
        jPanel3.add(txt_Borrow_cdRCBarcode);
        txt_Borrow_cdRCBarcode.setBounds(190, 90, 240, 30);

        btninisdesave.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btninisdesave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        btninisdesave.setText("SAVE");
        btninisdesave.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btninisdesave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninisdesaveActionPerformed(evt);
            }
        });
        jPanel3.add(btninisdesave);
        btninisdesave.setBounds(70, 40, 90, 30);

        borrowinside.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        borrowinside.setText("BORROW INSIDE");
        borrowinside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowinsideActionPerformed(evt);
            }
        });
        jPanel3.add(borrowinside);
        borrowinside.setBounds(40, 10, 149, 30);

        borrowoutside.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        borrowoutside.setText("BORROW OUTSIDE");
        borrowoutside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowoutsideActionPerformed(evt);
            }
        });
        jPanel3.add(borrowoutside);
        borrowoutside.setBounds(250, 10, 161, 30);

        btnoutsidesave.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnoutsidesave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        btnoutsidesave.setText("SAVE");
        btnoutsidesave.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnoutsidesave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnoutsidesave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoutsidesaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnoutsidesave);
        btnoutsidesave.setBounds(290, 40, 90, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(990, 240, 550, 340);

        labelDate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelDate.setText("Date:");
        jPanel1.add(labelDate);
        labelDate.setBounds(1420, 20, 120, 30);

        labelTime.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelTime.setText("Time:");
        jPanel1.add(labelTime);
        labelTime.setBounds(1600, 20, 60, 30);

        cd.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        cd.setText("CD");
        jPanel1.add(cd);
        cd.setBounds(20, 20, 50, 20);

        labelStatus.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelStatus.setText("Status:");
        jPanel1.add(labelStatus);
        labelStatus.setBounds(430, 570, 340, 20);

        status.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        status.setText("-----------");
        jPanel1.add(status);
        status.setBounds(770, 570, 70, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1700, 860);

        setSize(new java.awt.Dimension(1704, 919));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBorrow_cdAccNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBorrow_cdAccNoKeyReleased
        try {

         txtBorrow_cdBarcode.setEnabled(true);
         if (validateBarcode(txtBorrow_cdBarcode.getText())) {
         try {
         ResultSet rs = null;

         String tempbarcode = txtBorrow_cdBarcode.getText();

         String query = "SELECT * FROM `tbl_cd` WHERE cd_Barcode='"+tempbarcode+"'";
         SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

         st = con.dbconn().createStatement();
         rs = st.executeQuery(query);
         try {
         if (rs.next()) {
         //to display the data inside the txtfields
         String barcode = rs.getString("cd_Barcode");
         txtBorrow_cdBarcode.setText(barcode);

         String title = rs.getString("cd_Title");
         txtBorrow_cdTitle.setText(title);

         String author = rs.getString("cd_Genre");
         txt_Borrow_cdGenre.setText(author);

         String copy = rs.getString("NoOfCopies");
         copies.setText(copy);

         String a = copies.getText();
         int accesss = Integer.valueOf(a);

         if (accesss == 0) {
         JOptionPane.showMessageDialog(null, "Oppss.. The cd copies are already borrowed");
         txtBorrow_cdBarcode.setText("");
         txtBorrow_cdTitle.setText("");
         txt_Borrow_cdGenre.setText("");

         txt_Borrow_cdRCBarcode.setText("");
         txt_Borrow_cdBorrowerName.setText("");
         txt_Borrow_cdBorrowerGender.setText("");
         txt_Borrow_cdBorrowerAddress.setText("");
         txtBorrow_cdBorrowerType.setText(" ");
         copies.setText("");

         } else {
         a = Integer.toString(--accesss);
         copy = a;
         copies.setText(copy);
         }
         }
         } catch (Exception ex) {
         ex.printStackTrace();
         }
         txtBorrow_cdBarcode.getText();
         txtBorrow_cdAccNo.getText();
         txtBorrow_cdTitle.getText();
         txt_Borrow_cdGenre.getText();
         copies.getText();

         } catch (Exception ex) {
         ex.printStackTrace();
         }
         } else {
         txtBorrow_cdBarcode.setText("");
         JOptionPane.showMessageDialog(null, "Book barcode doesn't exist!");
         }

         } catch (Exception e) {
         e.printStackTrace();
         } 
    }//GEN-LAST:event_txtBorrow_cdAccNoKeyReleased

    private void txtBorrow_cdBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBorrow_cdBarcodeActionPerformed
        try {

            txtBorrow_cdBarcode.setEnabled(true);
            if (validateBarcode(txtBorrow_cdBarcode.getText())) {
                try {
                    ResultSet rs = null;

                    String tempbarcode = txtBorrow_cdBarcode.getText();

                    String query = "SELECT * FROM `tbl_cd` WHERE cd_Barcode='" + tempbarcode + "'";
                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

                    st = con.dbconn().createStatement();
                    rs = st.executeQuery(query);
                    try {
                        if (rs.next()) {
                            //to display the data inside the txtfields
                            String barcode = rs.getString("cd_Barcode");
                            txtBorrow_cdBarcode.setText(barcode);

                            String title = rs.getString("cd_Title");
                            txtBorrow_cdTitle.setText(title);

                            String author = rs.getString("cd_Genre");
                            txt_Borrow_cdGenre.setText(author);

                            String copy = rs.getString("NoOfCopies");
                            copies.setText(copy);

                            String a = copies.getText();
                            int accesss = Integer.valueOf(a);

                            if (accesss == 0) {
                                JOptionPane.showMessageDialog(null, "Oppss.. The cd copies are already borrowed");
                                txtBorrow_cdBarcode.setText("");
                                txtBorrow_cdTitle.setText("");
                                txt_Borrow_cdGenre.setText("");

                                txt_Borrow_cdRCBarcode.setText("");
                                txt_Borrow_cdBorrowerName.setText("");
                                txt_Borrow_cdBorrowerGender.setText("");
                                txt_Borrow_cdBorrowerAddress.setText("");
                                txtBorrow_cdBorrowerType.setText(" ");
                                copies.setText("");

                            } else {
                                a = Integer.toString(--accesss);
                                copy = a;
                                copies.setText(copy);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    txtBorrow_cdBarcode.getText();
                    txtBorrow_cdAccNo.getText();
                    txtBorrow_cdTitle.getText();
                    txt_Borrow_cdGenre.getText();
                    copies.getText();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                txtBorrow_cdBarcode.setText("");
                JOptionPane.showMessageDialog(null, "Book barcode doesn't exist!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtBorrow_cdBarcodeActionPerformed

    private void txtBorrow_cdTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBorrow_cdTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBorrow_cdTitleActionPerformed

    private void borrowinsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowinsideActionPerformed
        txt_Borrow_cdRCBarcode.setEnabled(true);

        datereq.setEnabled(false);

        labelStatus.setText(txtBorrow_cdBarcode.getText() + " with accession number " + txtBorrow_cdAccNo.getText() + " is now: ");
        status.setText("borrowed");

        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txtBorrow_cdAccNo.getText() + "','" + txtBorrow_cdBarcode.getText() + "','" + status.getText() + "')";
        executeSQlquery(quer, "Monitored");

    }//GEN-LAST:event_borrowinsideActionPerformed

    private void borrowoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowoutsideActionPerformed
        txt_Borrow_cdRCBarcode.setEnabled(true);

        datereq.setEnabled(true);

        labelStatus.setText(txtBorrow_cdBarcode.getText() + " with accession number " + txtBorrow_cdAccNo.getText() + " is now: ");
        status.setText("borrowed");

        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txtBorrow_cdAccNo.getText() + "','" + txtBorrow_cdBarcode.getText() + "','" + status.getText() + "')";
        executeSQlquery(quer, "Monitored");

    }//GEN-LAST:event_borrowoutsideActionPerformed

    private void txt_Borrow_cdRCBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Borrow_cdRCBarcodeActionPerformed
        datereq.setEnabled(true);
        Date d = new Date();
        SimpleDateFormat dds = new SimpleDateFormat("MM-dd-yyyy");
        String barcode = "", name = "", gender = "", address = "", type = "", dateregis = "", dateexpire = "";
        dateregis = dds.format(d);
        dateexpire = dds.format(d);
        // String barcode="",name="",age="",gender="",address="",type="",dateregis="",dateexpire="";
        long a = 0;
        SimpleDateFormat s = new SimpleDateFormat("MM-d-yyyy");

        if (validateRCBarcode(txt_Borrow_cdRCBarcode.getText())) {
            try {
                Connection cn = null;
                Statement st = null;
                ResultSet rs = null;

                String tempbarcode = txt_Borrow_cdRCBarcode.getText();

                String query = "SELECT * FROM `tbl_clientregistration` WHERE ClientBarcode= " + tempbarcode;
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM d");

                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
                st = cn.prepareStatement(query);
                rs = st.executeQuery(query);

                try {
                    if (rs.next()) {
                        //to display the data inside the txtfields
                        barcode = rs.getString("ClientBarcode");
                        txt_Borrow_cdRCBarcode.setText(barcode);

                        name = rs.getString("Name");
                        txt_Borrow_cdBorrowerName.setText(name);

                        gender = rs.getString("Gender");
                        txt_Borrow_cdBorrowerGender.setText(gender);

                        address = rs.getString("Address");
                        txt_Borrow_cdBorrowerAddress.setText(address);

                        String types = rs.getString("ClientType");
                        txtBorrow_cdBorrowerType.setText(types);

                        dateregis = rs.getString("DateIssued");
                        dateexpire = rs.getString("DateExpired");
                    }

                } catch (Exception ex) {

                    if (a > 0) {
                        txt_Borrow_cdRCBarcode.setText(barcode);
                        txt_Borrow_cdBorrowerName.setText(name);
                        txt_Borrow_cdBorrowerGender.setText(gender);
                        txt_Borrow_cdBorrowerAddress.setText(address);
                        txtBorrow_cdBorrowerType.setText(type);
                    } else {
                        JOptionPane.showMessageDialog(null, "Your account has already expired!!!");
                    }

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            txt_Borrow_cdRCBarcode.setText("");
            JOptionPane.showMessageDialog(null, "Readers Card Barcode doesn't exist");
        }
    }//GEN-LAST:event_txt_Borrow_cdRCBarcodeActionPerformed

    private void txt_Borrow_cdRCBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Borrow_cdRCBarcodeKeyReleased

    }//GEN-LAST:event_txt_Borrow_cdRCBarcodeKeyReleased

    private void btninisdesaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninisdesaveActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txt_Borrow_cdRCBarcode.getText();
        SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
        Calendar now = Calendar.getInstance();
        Date l = null, a = null, b = null;
        try {
            st = con.dbconn().prepareStatement(query);
            rs = st.executeQuery(query);

            if (rs.next()) {
                //gkan sa db
                String dates = rs.getString("DateExpired");
                String datereturns = rs.getString("DateExpired");
                //karon
                String dateafter = now.get(Calendar.MONTH) + 1 + "-" + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR);
                try {
                    b = s.parse(dates);
                    l = s.parse(datereturns);
                    a = s.parse(dateafter);
                    now.add(Calendar.DATE, -1);
                    long answer = l.getTime() - a.getTime();
                    String answers = Long.toString(answer);
                    // JOptionPane.showMessageDialog(null, dateafter);
                    if (l.getTime() < a.getTime()) {
                        JOptionPane.showMessageDialog(null, "Your account is Expired , Please Renew");
                        //   JOptionPane.showMessageDialog(null, "Your expected date to return is" + datereturns);

                        RENEWALFORM Lib = new RENEWALFORM();
                        Lib.setVisible(true);
                        Lib.setLocationRelativeTo(null);
                    } else {
                        if (txtBorrow_cdBarcode.getText().trim().isEmpty() || txt_Borrow_cdRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {

                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txtBorrow_cdAccNo.getText() + "','" + txtBorrow_cdBarcode.getText() + "','" + txt_Borrow_cdRCBarcode.getText() + "','" + borrowinside.getText() + "')";
                            executeSQlquery(queries, "Transaction Added");
                            try {
                                String queri = "UPDATE `tbl_cd` SET  `NoOfCopies` ='" + copies.getText() + "' WHERE  `cd_Barcode` =" + txtBorrow_cdBarcode.getText();
                                executeSQlquery(queri, "No of Copies Updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                String querys = "INSERT INTO `tbl_borrowinside` VALUES ('" + Global_Variable.incdId + "','" + cd.getText() + "','" + txtBorrow_cdAccNo.getText() + "','" + txtBorrow_cdBarcode.getText() + "','" + copies.getText() + "','" + txt_Borrow_cdRCBarcode.getText() + "','" + labelDate.getText() + "','" + labelTime.getText() + "')";
                                executeSQlquery(querys, "CD Borrowed");
                                txtBorrow_cdAccNo.setText("");

                                txtBorrow_cdBarcode.setText("");
                                txtBorrow_cdTitle.setText("");
                                txt_Borrow_cdGenre.setText("");

                                txt_Borrow_cdRCBarcode.setText("");
                                txt_Borrow_cdBorrowerName.setText("");
                                txt_Borrow_cdBorrowerGender.setText("");
                                txt_Borrow_cdBorrowerAddress.setText("");
                                txtBorrow_cdBorrowerType.setText("");
                                copies.setText("");
                                txtBorrow_cdBarcode.setEnabled(false);

                                txt_Borrow_cdRCBarcode.setEnabled(false);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {

        }


    }//GEN-LAST:event_btninisdesaveActionPerformed

    private void btnoutsidesaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoutsidesaveActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txt_Borrow_cdRCBarcode.getText();
        SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
        Calendar now = Calendar.getInstance();
        Date l = null, a = null, b = null;
        try {
            st = con.dbconn().prepareStatement(query);
            rs = st.executeQuery(query);

            if (rs.next()) {
                //gkan sa db
                String dates = rs.getString("DateExpired");
                String datereturns = rs.getString("DateExpired");
                //karon
                String dateafter = now.get(Calendar.MONTH) + 1 + "-" + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR);
                try {
                    b = s.parse(dates);
                    l = s.parse(datereturns);
                    a = s.parse(dateafter);
                    now.add(Calendar.DATE, -1);
                    long answer = l.getTime() - a.getTime();
                    String answers = Long.toString(answer);
                    // JOptionPane.showMessageDialog(null, dateafter);
                    if (l.getTime() < a.getTime()) {
                        JOptionPane.showMessageDialog(null, "Your account is Expired , Please Renew");
                        //   JOptionPane.showMessageDialog(null, "Your expected date to return is" + datereturns);

                        RENEWALFORM Lib = new RENEWALFORM();
                        Lib.setVisible(true);
                        Lib.setLocationRelativeTo(null);
                    } else {
                        if (txtBorrow_cdBarcode.getText().trim().isEmpty() || txt_Borrow_cdRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {

                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txtBorrow_cdAccNo.getText() + "','" + txtBorrow_cdBarcode.getText() + "','" + txt_Borrow_cdRCBarcode.getText() + "','" + borrowoutside.getText() + "')";
                            executeSQlquery(queries, "Transaction Added");
                            try {
                                String queri = "UPDATE `tbl_cd` SET  `NoOfCopies` ='" + copies.getText() + "' WHERE  `cd_Barcode` =" + txtBorrow_cdBarcode.getText();
                                executeSQlquery(queri, "No of Copies Updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {

                                String dated = s.format(datereq.getDate());
                                String querys = "INSERT INTO `tbl_borrowoutside` VALUES ('" + Global_Variable.outbookId + "','" + cd.getText() + "','" + txtBorrow_cdAccNo.getText() + "','" + txtBorrow_cdBarcode.getText() + "','" + txt_Borrow_cdRCBarcode.getText() + "','" + dated + "','" + labelDate.getText() + "','" + labelTime.getText() + "')";
                                executeSQlquery(querys, "CD Borrowed");

                                txtBorrow_cdBarcode.setText("");
                                txtBorrow_cdAccNo.setText("");
                                txtBorrow_cdTitle.setText("");
                                txt_Borrow_cdGenre.setText("");

                                txt_Borrow_cdRCBarcode.setText("");
                                txt_Borrow_cdBorrowerName.setText("");
                                txt_Borrow_cdBorrowerGender.setText("");
                                txt_Borrow_cdBorrowerAddress.setText("");
                                txtBorrow_cdBorrowerType.setText("");

                                txtBorrow_cdBarcode.setEnabled(false);

                                txt_Borrow_cdRCBarcode.setEnabled(false);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_btnoutsidesaveActionPerformed

    private void txtBorrow_cdBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBorrow_cdBarcodeKeyReleased
        status();
        availability();
        copies.setEnabled(true);
        txtBorrow_cdTitle.setEnabled(true);
        txt_Borrow_cdGenre.setEnabled(true);
    }//GEN-LAST:event_txtBorrow_cdBarcodeKeyReleased

    private void txtBorrow_cdAccNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBorrow_cdAccNoActionPerformed
       txtBorrow_cdBarcode.setEnabled(true);
        txtBorrow_cdTitle.setEnabled(true);
        txt_Borrow_cdGenre.setEnabled(true);
        copies.setEnabled(true);

        String accession = txtBorrow_cdAccNo.getText();
        try {
            String query = "SELECT * FROM `tbl_cdaccession` WHERE accession= '"+accession+"'";
            ResultSet rs;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                    String access = rs.getString("accession");
                    txtBorrow_cdAccNo.setText(access);

                    String barc = rs.getString("ISBNBarcode");
                    txtBorrow_cdBarcode.setText(barc);

                    String title = rs.getString("Title");
                    txtBorrow_cdTitle.setText(title);

                    String gen = rs.getString("Genre");
                    txt_Borrow_cdGenre.setText(gen);

                    String copy = rs.getString("Copies");
                    copies.setText(copy);

                    String a = copies.getText();
                    int accesss = Integer.valueOf(a);

                    if (accesss == 0) {
                        JOptionPane.showMessageDialog(null, "Oppss.. The cd copies are already borrowed");
                        txtBorrow_cdBarcode.setText("");
                        txtBorrow_cdTitle.setText("");
                        txt_Borrow_cdGenre.setText("");

                        txt_Borrow_cdRCBarcode.setText("");
                        txt_Borrow_cdBorrowerName.setText("");
                        txt_Borrow_cdBorrowerGender.setText("");
                        txt_Borrow_cdBorrowerAddress.setText("");
                        txtBorrow_cdBorrowerType.setText(" ");
                        copies.setText("");

                    } else {
                        a = Integer.toString(--accesss);
                        copy = a;
                        copies.setText(copy);
                    }
                }
            } catch (Exception e) {

            }
            txtBorrow_cdAccNo.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtBorrow_cdAccNoActionPerformed

    private int validatematerialType() {
        Statement st;
        int id = 2;
        ResultSet rs;
        String query;
        try {
            query = "select id from `tbl_borrow` where material_id ='" + Global_Variable.material_id + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    private String validateType() {
        Statement st;
        String id = "";
        ResultSet rs;
        String query;
        try {
            query = "select id from `tbl_logintypeclient` where type='" + txtBorrow_cdBorrowerType.getText() + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("id");
                txtBorrow_cdBorrowerType.setText("type");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox borrowinside;
    private javax.swing.JCheckBox borrowoutside;
    private javax.swing.JButton btninisdesave;
    private javax.swing.JButton btnoutsidesave;
    private javax.swing.JLabel cd;
    private javax.swing.JTextField copies;
    private com.toedter.calendar.JDateChooser datereq;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelTime;
    private javax.swing.JLabel status;
    private javax.swing.JTextField txtBorrow_cdAccNo;
    private javax.swing.JTextField txtBorrow_cdBarcode;
    private javax.swing.JTextField txtBorrow_cdBorrowerType;
    private javax.swing.JTextField txtBorrow_cdTitle;
    private javax.swing.JTextField txt_Borrow_cdBorrowerAddress;
    private javax.swing.JTextField txt_Borrow_cdBorrowerGender;
    private javax.swing.JTextField txt_Borrow_cdBorrowerName;
    private javax.swing.JTextField txt_Borrow_cdGenre;
    private javax.swing.JTextField txt_Borrow_cdRCBarcode;
    // End of variables declaration//GEN-END:variables
     //to validate if barcode doen't exist 

    private boolean validateBarcode(String Barcode) {
        boolean queue = false;
        ResultSet rs;
        String query;
        try {
            query = "select * from `tbl_cd` where cd_Barcode='" + Barcode + "'";
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

    private boolean validateRCBarcode(String Barcode) {
        boolean queue = false;
        ResultSet rs;
        String query;
        try {
            query = "select * from `tbl_clientregistration` where ClientBarcode='" + Barcode + "'";
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

    private String availability() {
        Statement st;
        String available = "";
        ResultSet rs;
        String query;
        boolean active = true;
        try {
            query = "select * from `tbl_cd` where cd_Barcode='" + txtBorrow_cdBarcode.getText() + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                available = rs.getString("Availability");
                if (active == available.equals("YES")) {
                    txtBorrow_cdBarcode.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "This cd is cannot be borrowed outside");
                    txtBorrow_cdAccNo.setText("");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return available;
    }

    private String status() {
        String id = "";
        ResultSet rs;

        try {
            String query = "select * from tbl_cd where cd_Barcode =" + txtBorrow_cdBarcode.getText();
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("Status");
                switch (id) {
                    case "Available":
                        txt_Borrow_cdRCBarcode.setEditable(true);
                        break;
                    case "Damaged":
                        JOptionPane.showMessageDialog(null, "Opps.. this cd is damaged and cannot be borrowed");
                        txtBorrow_cdBarcode.setText("");
                        txtBorrow_cdAccNo.setText("");
                        txtBorrow_cdTitle.setText("");
                        txt_Borrow_cdGenre.setText("");

                        break;
                    case "Lost":
                        JOptionPane.showMessageDialog(null, "Its lost!!!");
                        txtBorrow_cdBarcode.setText("");
                        txtBorrow_cdAccNo.setText("");
                        txtBorrow_cdTitle.setText("");
                        txt_Borrow_cdGenre.setText(" ");
                        break;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

}
