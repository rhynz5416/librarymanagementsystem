package Borrowing;

import Classes.C_LibraryMaterialJournal;
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

public class JOURNALBORROW extends javax.swing.JFrame {

    dbConn con = new dbConn();
    Statement st;

    public JOURNALBORROW() {
        initComponents();
        showJournalDate();
        showJournalTime();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        txtjournalBarcode.setEnabled(false);
        txtjournalAccNo.setEnabled(true);

        txtjournalRCBarcode.setEnabled(false);
        txtjournalBorrowerName.setEnabled(false);
        txtjournalGender.setEnabled(false);
        txtjournalAddress.setEnabled(false);
        txtjournalBorrowerType.setEnabled(false);
        copies.setEnabled(false);
        txtjournalTitle.setEnabled(false);
        txtjournalAuthor.setEnabled(false);
        txtjournalPublisher.setEnabled(false);
    }

    void showJournalDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
        labelDate.setText(s.format(d));
    }

    void showJournalTime() {
        new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm");
                labeltime.setText(s.format(d));
            }

        }).start();
    }

    public ArrayList<C_LibraryMaterialJournal> getJournalList() {
        ArrayList<C_LibraryMaterialJournal> journal = new ArrayList<C_LibraryMaterialJournal>();

        String query = "select * from `tbl_journal` where category_id=" + Global_Variable.category_id;
        ResultSet sr;
        try {
            st = con.dbconn().createStatement();
            sr = st.executeQuery(query);

            C_LibraryMaterialJournal jour;
            while (sr.next()) {
                jour = new C_LibraryMaterialJournal(sr.getInt("id"), sr.getString("ISBNBarcode"), sr.getString("DateAcquisition"), sr.getString("J_Title"), sr.getString("J_Author"), sr.getString("J_Publisher"), sr.getInt("EditionNumber"), sr.getInt("Pagevol"), sr.getString("Place"), sr.getInt("Year"), sr.getString("Source"));
                journal.add(jour);
            }
        } catch (Exception a) {
            a.printStackTrace();
        }
        return journal;
    }

    public void executeSqlquery(String query, String message) {

        Statement ts;
        try {
            ts = con.dbconn().createStatement();
            if ((ts.executeUpdate(query)) == 1) {
                JOptionPane.showMessageDialog(null, "Data " + message + " successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Data " + message + ".");
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
        jLabel43 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtjournalAccNo = new javax.swing.JTextField();
        txtjournalBarcode = new javax.swing.JTextField();
        txtjournalTitle = new javax.swing.JTextField();
        txtjournalAuthor = new javax.swing.JTextField();
        txtjournalPublisher = new javax.swing.JTextField();
        copies = new javax.swing.JTextField();
        journal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txtjournalRCBarcode = new javax.swing.JTextField();
        txtjournalBorrowerName = new javax.swing.JTextField();
        txtjournalGender = new javax.swing.JTextField();
        txtjournalAddress = new javax.swing.JTextField();
        txtjournalBorrowerType = new javax.swing.JTextField();
        datereq = new com.toedter.calendar.JDateChooser();
        btnSave = new javax.swing.JButton();
        borrowinside = new javax.swing.JCheckBox();
        borrowoutside = new javax.swing.JCheckBox();
        btnsaveoutside = new javax.swing.JButton();
        labelDate = new javax.swing.JLabel();
        labeltime = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel43.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel43.setText("Accession Number: ");
        jPanel2.add(jLabel43);
        jLabel43.setBounds(30, 20, 130, 30);

        jLabel34.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel34.setText("ISBN Barcode:");
        jPanel2.add(jLabel34);
        jLabel34.setBounds(70, 50, 90, 50);

        jLabel44.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel44.setText("Journal Title:");
        jPanel2.add(jLabel44);
        jLabel44.setBounds(70, 110, 90, 30);

        jLabel45.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel45.setText("Author:");
        jPanel2.add(jLabel45);
        jLabel45.setBounds(110, 160, 60, 30);

        jLabel49.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel49.setText("Publisher:");
        jPanel2.add(jLabel49);
        jLabel49.setBounds(90, 220, 70, 20);

        jLabel46.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel46.setText("No of Copies Available:");
        jPanel2.add(jLabel46);
        jLabel46.setBounds(70, 260, 170, 30);

        txtjournalAccNo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtjournalAccNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtjournalAccNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjournalAccNoActionPerformed(evt);
            }
        });
        txtjournalAccNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtjournalAccNoKeyReleased(evt);
            }
        });
        jPanel2.add(txtjournalAccNo);
        txtjournalAccNo.setBounds(170, 20, 110, 30);

        txtjournalBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtjournalBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtjournalBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjournalBarcodeActionPerformed(evt);
            }
        });
        txtjournalBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtjournalBarcodeKeyReleased(evt);
            }
        });
        jPanel2.add(txtjournalBarcode);
        txtjournalBarcode.setBounds(170, 60, 220, 30);

        txtjournalTitle.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtjournalTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtjournalTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjournalTitleActionPerformed(evt);
            }
        });
        jPanel2.add(txtjournalTitle);
        txtjournalTitle.setBounds(170, 110, 220, 30);

        txtjournalAuthor.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtjournalAuthor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txtjournalAuthor);
        txtjournalAuthor.setBounds(170, 160, 220, 30);

        txtjournalPublisher.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtjournalPublisher.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtjournalPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjournalPublisherActionPerformed(evt);
            }
        });
        jPanel2.add(txtjournalPublisher);
        txtjournalPublisher.setBounds(170, 210, 220, 30);

        copies.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        copies.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(copies);
        copies.setBounds(220, 260, 90, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(490, 210, 450, 320);

        journal.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        journal.setText("JOURNAL");
        jPanel1.add(journal);
        journal.setBounds(20, 10, 160, 40);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        jLabel47.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel47.setText("Reader's Card Barcode:");
        jPanel3.add(jLabel47);
        jLabel47.setBounds(10, 100, 170, 30);

        jLabel48.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel48.setText("Name:");
        jPanel3.add(jLabel48);
        jLabel48.setBounds(120, 150, 60, 30);

        jLabel50.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel50.setText("Gender:");
        jPanel3.add(jLabel50);
        jLabel50.setBounds(110, 200, 70, 30);

        jLabel51.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel51.setText("Address:");
        jPanel3.add(jLabel51);
        jLabel51.setBounds(100, 260, 80, 15);

        jLabel53.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel53.setText("Borrowe Type:");
        jPanel3.add(jLabel53);
        jLabel53.setBounds(70, 300, 110, 30);

        jLabel52.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel52.setText("Date Return:");
        jPanel3.add(jLabel52);
        jLabel52.setBounds(80, 350, 110, 30);

        txtjournalRCBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtjournalRCBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtjournalRCBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjournalRCBarcodeActionPerformed(evt);
            }
        });
        txtjournalRCBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtjournalRCBarcodeKeyReleased(evt);
            }
        });
        jPanel3.add(txtjournalRCBarcode);
        txtjournalRCBarcode.setBounds(170, 100, 240, 30);

        txtjournalBorrowerName.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtjournalBorrowerName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txtjournalBorrowerName);
        txtjournalBorrowerName.setBounds(170, 150, 240, 30);

        txtjournalGender.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtjournalGender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txtjournalGender);
        txtjournalGender.setBounds(170, 200, 140, 30);

        txtjournalAddress.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtjournalAddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txtjournalAddress);
        txtjournalAddress.setBounds(170, 250, 240, 30);

        txtjournalBorrowerType.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtjournalBorrowerType.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txtjournalBorrowerType);
        txtjournalBorrowerType.setBounds(170, 300, 240, 30);

        datereq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        datereq.setDateFormatString("MM-dd-yyyy");
        datereq.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jPanel3.add(datereq);
        datereq.setBounds(170, 350, 240, 30);

        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        btnSave.setText("SAVE");
        btnSave.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave);
        btnSave.setBounds(100, 40, 100, 30);

        borrowinside.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        borrowinside.setText("BORROW INSIDE");
        borrowinside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowinsideActionPerformed(evt);
            }
        });
        jPanel3.add(borrowinside);
        borrowinside.setBounds(70, 10, 149, 40);

        borrowoutside.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        borrowoutside.setText("BORROW OUTSIDE");
        borrowoutside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowoutsideActionPerformed(evt);
            }
        });
        jPanel3.add(borrowoutside);
        borrowoutside.setBounds(280, 20, 190, 20);

        btnsaveoutside.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnsaveoutside.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        btnsaveoutside.setText("SAVE");
        btnsaveoutside.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnsaveoutside.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsaveoutside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveoutsideActionPerformed(evt);
            }
        });
        jPanel3.add(btnsaveoutside);
        btnsaveoutside.setBounds(320, 40, 90, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(1050, 210, 510, 420);

        labelDate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelDate.setText("Date:");
        jPanel1.add(labelDate);
        labelDate.setBounds(1260, 10, 100, 30);

        labeltime.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labeltime.setText("Time:");
        jPanel1.add(labeltime);
        labeltime.setBounds(1440, 10, 70, 30);

        labelStatus.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelStatus.setText("Status:");
        jPanel1.add(labelStatus);
        labelStatus.setBounds(520, 570, 300, 20);

        status.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        status.setText("-----------");
        jPanel1.add(status);
        status.setBounds(830, 570, 70, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1590, 950);

        setSize(new java.awt.Dimension(1614, 1009));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtjournalAccNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjournalAccNoKeyReleased
  txtjournalBarcode.setEnabled(true);
        String accession = txtjournalAccNo.getText();
        try {
            String query = "SELECT * FROM `tbl_journalaccession` WHERE accession= '"+accession+"' and category_id ='"+Global_Variable.category_id+"'";
            ResultSet rs;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                    String access = rs.getString("accession");
                    txtjournalAccNo.setText(access);
                    String bar = rs.getString("ISBNBarcode");
                    txtjournalBarcode.setText(bar);
                    String title = rs.getString("Title");
                    txtjournalTitle.setText(title);
                    String authoe = rs.getString("Author");
                    txtjournalAuthor.setText(authoe);
                    String publisher = rs.getString("Publisher");
                    txtjournalPublisher.setText(publisher);
                    String copy = rs.getString("Copies");
                    copies.setText(copy);
                    
                     String a = copies.getText();
                        int accesss = Integer.valueOf(a);

                        if (accesss == 0) {
                            JOptionPane.showMessageDialog(null, "Oppss.. The journal copies are already borrowed");
                            txtjournalBarcode.setText("");
                            txtjournalAccNo.setText("");
                            txtjournalTitle.setText("");
                            txtjournalAuthor.setText("");
                            txtjournalPublisher.setText("");

                            txtjournalRCBarcode.setText("");
                            txtjournalBorrowerName.setText("");
                            txtjournalGender.setText("");
                            txtjournalAddress.setText("");
                            txtjournalBorrowerType.setText(" ");
                            copies.setText("");

                        } else {
                            a = Integer.toString(--accesss);
                            copy = a;
                            copies.setText(copy);
                        }
                            
                }
            } catch (Exception e) {

            }
            txtjournalAccNo.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtjournalAccNoKeyReleased

    private void txtjournalBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjournalBarcodeActionPerformed

        try {

            try {
                ResultSet rs = null;
                String tempbarcode = txtjournalBarcode.getText();
                String query = "SELECT * FROM `tbl_journal` WHERE ISBNBarcode='" + tempbarcode + "' and category_id='" + Global_Variable.category_id + "' ";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM d");

                st = con.dbconn().createStatement();
                rs = st.executeQuery(query);
                try {
                    if (rs.next()) {

                        //to display the data inside the txtfields
                        String barcode = rs.getString("ISBNBarcode");
                        txtjournalBarcode.setText(barcode);
                        String title = rs.getString("J_Title");
                        txtjournalTitle.setText(title);

                        String author = rs.getString("J_Author");
                        txtjournalAuthor.setText(author);

                        String publisher = rs.getString("J_Publisher");
                        txtjournalPublisher.setText(publisher);

                        String copy = rs.getString("NoOfCopies");
                        copies.setText(copy);

                        String a = copies.getText();
                        int accesss = Integer.valueOf(a);

                        if (accesss == 0) {
                            JOptionPane.showMessageDialog(null, "Oppss.. The journal copies are already borrowed");
                            txtjournalBarcode.setText("");
                            txtjournalAccNo.setText("");
                            txtjournalTitle.setText("");
                            txtjournalAuthor.setText("");
                            txtjournalPublisher.setText("");

                            txtjournalRCBarcode.setText("");
                            txtjournalBorrowerName.setText("");
                            txtjournalGender.setText("");
                            txtjournalAddress.setText("");
                            txtjournalBorrowerType.setText(" ");
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
                txtjournalBarcode.getText();

                txtjournalTitle.getText();
                txtjournalAuthor.getText();
                txtjournalPublisher.getText();
                copies.getText();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_txtjournalBarcodeActionPerformed

    private void txtjournalBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjournalBarcodeKeyReleased
        availability();
        status();
        copies.setEnabled(true);
        txtjournalTitle.setEnabled(true);
        txtjournalAuthor.setEnabled(true);
        txtjournalPublisher.setEnabled(true);
    }//GEN-LAST:event_txtjournalBarcodeKeyReleased

    private void txtjournalTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjournalTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjournalTitleActionPerformed

    private void txtjournalPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjournalPublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjournalPublisherActionPerformed

    private void borrowinsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowinsideActionPerformed
        txtjournalRCBarcode.setEnabled(true);
        datereq.setEnabled(false);

        labelStatus.setText(txtjournalBarcode.getText() + " with accession number " + txtjournalAccNo.getText() + " is now: ");
        status.setText("borrowed");

        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txtjournalAccNo.getText() + "','" + txtjournalBarcode.getText() + "','" + status.getText() + "','"+Global_Variable.category_id+"')";
        executeSqlquery(quer, "Monitored");
    }//GEN-LAST:event_borrowinsideActionPerformed

    private void borrowoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowoutsideActionPerformed
        txtjournalRCBarcode.setEnabled(true);
        datereq.setEnabled(true);

        labelStatus.setText(txtjournalBarcode.getText() + " with accession number " + txtjournalAccNo.getText() + " is now: ");
        status.setText("borrowed");

        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txtjournalAccNo.getText() + "','" + txtjournalBarcode.getText() + "','" + status.getText() + "','"+Global_Variable.category_id+"')";
        executeSqlquery(quer, "Monitored");
    }//GEN-LAST:event_borrowoutsideActionPerformed

    private void txtjournalRCBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjournalRCBarcodeActionPerformed
        datereq.setEnabled(true);
        Date d = new Date();
        SimpleDateFormat dds = new SimpleDateFormat("MMM d, yyyy");
        String barcode = "", name = "", gender = "", address = "", type = "", dateregis = "", dateexpire = "";
        dateregis = dds.format(d);
        dateexpire = dds.format(d);

        long a = 0;
        SimpleDateFormat s = new SimpleDateFormat("MMM d, yyyy");

        if (validateRCBarcode(txtjournalRCBarcode.getText())) {
            try {
                Connection cn = null;
                Statement st = null;
                ResultSet rs = null;

                String tempbarcode = txtjournalRCBarcode.getText();

                String query = "SELECT * FROM `tbl_clientregistration` WHERE ClientBarcode= " + tempbarcode;
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM d");

                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
                st = cn.prepareStatement(query);
                rs = st.executeQuery(query);

                try {
                    if (rs.next()) {

                        //to display the data inside the txtfields
                        barcode = rs.getString("ClientBarcode");
                        txtjournalRCBarcode.setText(barcode);

                        name = rs.getString("Name");
                        txtjournalBorrowerName.setText(name);

                        gender = rs.getString("Gender");
                        txtjournalGender.setText(gender);

                        address = rs.getString("Address");
                        txtjournalAddress.setText(address);

                        type = rs.getString("ClientType");
                        txtjournalBorrowerType.setText(type);

                        dateregis = rs.getString("DateIssued");
                        dateexpire = rs.getString("DateExpired");
                    }

                } catch (Exception ex) {
                    //Logger.getLogger(E_BORROWbookform.class.getName()).log(Level.SEVERE, null
                    if (a > 0) {
                        txtjournalRCBarcode.setText(barcode);
                        txtjournalBorrowerName.setText(name);
                        txtjournalGender.setText(gender);
                        txtjournalAddress.setText(address);
                        txtjournalBorrowerType.setText(type);
                        a = s.parse(dateexpire).getTime() - s.parse(dateregis).getTime();
                        JOptionPane.showMessageDialog(null, a + "");
                    } else {
                        JOptionPane.showMessageDialog(null, "Your account has already expired!!!");
                    }

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            txtjournalRCBarcode.setText("");
            JOptionPane.showMessageDialog(null, "Readers Card Barcode doesn't exist");
        }
    }//GEN-LAST:event_txtjournalRCBarcodeActionPerformed

    private void txtjournalRCBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjournalRCBarcodeKeyReleased
 datereq.setEnabled(true);
        Date d = new Date();
        SimpleDateFormat dds = new SimpleDateFormat("MMM d, yyyy");
        String barcode = "", name = "", gender = "", address = "", type = "", dateregis = "", dateexpire = "";
        dateregis = dds.format(d);
        dateexpire = dds.format(d);

        long a = 0;
        SimpleDateFormat s = new SimpleDateFormat("MMM d, yyyy");

        if (validateRCBarcode(txtjournalRCBarcode.getText())) {
            try {
                Connection cn = null;
                Statement st = null;
                ResultSet rs = null;

                String tempbarcode = txtjournalRCBarcode.getText();

                String query = "SELECT * FROM `tbl_clientregistration` WHERE ClientBarcode= " + tempbarcode;
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM d");

                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
                st = cn.prepareStatement(query);
                rs = st.executeQuery(query);

                try {
                    if (rs.next()) {

                        //to display the data inside the txtfields
                        barcode = rs.getString("ClientBarcode");
                        txtjournalRCBarcode.setText(barcode);

                        name = rs.getString("Name");
                        txtjournalBorrowerName.setText(name);

                        gender = rs.getString("Gender");
                        txtjournalGender.setText(gender);

                        address = rs.getString("Address");
                        txtjournalAddress.setText(address);

                        type = rs.getString("ClientType");
                        txtjournalBorrowerType.setText(type);

                        dateregis = rs.getString("DateIssued");
                        dateexpire = rs.getString("DateExpired");
                    }

                } catch (Exception ex) {
                    //Logger.getLogger(E_BORROWbookform.class.getName()).log(Level.SEVERE, null
                    if (a > 0) {
                        txtjournalRCBarcode.setText(barcode);
                        txtjournalBorrowerName.setText(name);
                        txtjournalGender.setText(gender);
                        txtjournalAddress.setText(address);
                        txtjournalBorrowerType.setText(type);
                        a = s.parse(dateexpire).getTime() - s.parse(dateregis).getTime();
                        JOptionPane.showMessageDialog(null, a + "");
                    } else {
                        JOptionPane.showMessageDialog(null, "Your account has already expired!!!");
                    }

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            txtjournalRCBarcode.setText("");
            JOptionPane.showMessageDialog(null, "Readers Card Barcode doesn't exist");
        }
    }//GEN-LAST:event_txtjournalRCBarcodeKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txtjournalRCBarcode.getText();
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
                        if (txtjournalBarcode.getText().trim().isEmpty() || txtjournalRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {

                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txtjournalAccNo.getText() + "','" + txtjournalBarcode.getText() + "','" + txtjournalRCBarcode.getText() + "','" + borrowinside.getText() + "','"+Global_Variable.category_id+"')";
                            executeSqlquery(queries, "Transaction Added");

                            try {
                                String queri = "UPDATE `tbl_journal` SET  `NoOfCopies` ='" + copies.getText() + "' WHERE  `ISBNBarcode` =" + txtjournalBarcode.getText();
                                executeSqlquery(queri, "No of copies Updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {

                                String queryz = "INSERT INTO `tbl_borrowinside` VALUES ('" + Global_Variable.injournalId + "','" + journal.getText() + "','" + txtjournalAccNo.getText() + "','" + txtjournalBarcode.getText() + "','"+copies.getText()+"','" + txtjournalRCBarcode.getText() + "','" + Global_Variable.category_id + "','" + labelDate.getText() + "','" + labeltime.getText() + "')";
                                executeSqlquery(queryz, "Journal Borrowed");

                                txtjournalBarcode.setText("");
                                txtjournalAccNo.setText("");
                                txtjournalTitle.setText("");
                                txtjournalAuthor.setText("");
                                txtjournalPublisher.setText("");

                                txtjournalRCBarcode.setText("");
                                txtjournalBorrowerName.setText("");
                                txtjournalGender.setText("");
                                txtjournalAddress.setText("");
                                txtjournalBorrowerType.setText(" ");

                                txtjournalBarcode.setEnabled(false);

                                txtjournalRCBarcode.setEnabled(false);

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

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnsaveoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveoutsideActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txtjournalRCBarcode.getText();
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
                        if (txtjournalBarcode.getText().trim().isEmpty() || txtjournalRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {

                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txtjournalAccNo.getText() + "','" + txtjournalBarcode.getText() + "','" + txtjournalRCBarcode.getText() + "','" + borrowoutside.getText() + "','"+Global_Variable.category_id+"')";
                            executeSqlquery(queries, "Transaction Added");

                            try {
                                String queri = "UPDATE `tbl_journal` SET  `NoOfCopies` ='" + copies.getText() + "' WHERE  `ISBNBarcode` =" + txtjournalBarcode.getText();
                                executeSqlquery(queri, "No of Copies Updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {
                                //SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
                                String dated = s.format(datereq.getDate());
                                String querys = "INSERT INTO `tbl_borrowoutside`VALUES ('" + Global_Variable.outjournalId + "','" + journal.getText() + "','" + txtjournalAccNo.getText() + "','" + txtjournalBarcode.getText() + "','" + txtjournalRCBarcode.getText() + "','" + dated + "','" + Global_Variable.category_id + "','" + labelDate.getText() + "','" + labeltime.getText() + "')";
                                executeSqlquery(querys, "Journal Borrowed");
                                txtjournalAccNo.setText("");

                                txtjournalBarcode.setText("");
                                txtjournalTitle.setText("");
                                txtjournalAuthor.setText("");
                                txtjournalPublisher.setText("");

                                txtjournalRCBarcode.setText("");
                                txtjournalBorrowerName.setText("");
                                txtjournalGender.setText("");
                                txtjournalAddress.setText("");
                                txtjournalBorrowerType.setText(" ");

                                txtjournalBarcode.setEnabled(false);

                                txtjournalRCBarcode.setEnabled(false);

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


    }//GEN-LAST:event_btnsaveoutsideActionPerformed

    private void txtjournalAccNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjournalAccNoActionPerformed
        txtjournalBarcode.setEnabled(true);
        String accession = txtjournalAccNo.getText();
        try {
            String query = "SELECT * FROM `tbl_journalaccession` WHERE accession= '"+accession+"' and category_id ='"+Global_Variable.category_id+"'";
            ResultSet rs;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                    String access = rs.getString("accession");
                    txtjournalAccNo.setText(access);
                    String bar = rs.getString("ISBNBarcode");
                    txtjournalBarcode.setText(bar);
                    String title = rs.getString("Title");
                    txtjournalTitle.setText(title);
                    String authoe = rs.getString("Author");
                    txtjournalAuthor.setText(authoe);
                    String publisher = rs.getString("Publisher");
                    txtjournalPublisher.setText(publisher);
                    String copy = rs.getString("Copies");
                    copies.setText(copy);
                    
                     String a = copies.getText();
                        int accesss = Integer.valueOf(a);

                        if (accesss == 0) {
                            JOptionPane.showMessageDialog(null, "Oppss.. The journal copies are already borrowed");
                            txtjournalBarcode.setText("");
                            txtjournalAccNo.setText("");
                            txtjournalTitle.setText("");
                            txtjournalAuthor.setText("");
                            txtjournalPublisher.setText("");

                            txtjournalRCBarcode.setText("");
                            txtjournalBorrowerName.setText("");
                            txtjournalGender.setText("");
                            txtjournalAddress.setText("");
                            txtjournalBorrowerType.setText(" ");
                            copies.setText("");

                        } else {
                            a = Integer.toString(--accesss);
                            copy = a;
                            copies.setText(copy);
                        }
                            
                }
            } catch (Exception e) {

            }
            txtjournalAccNo.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtjournalAccNoActionPerformed

    private int validatematerialType() {
        Statement st;
        int count = 3;
        ResultSet rs;
        String query;
        try {
            query = "select id from `tbl_borrow` where material_id ='" + Global_Variable.material_id + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                count = rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count++;
    }

    private String validateType() {
        Statement st;
        String id = "";
        ResultSet rs;
        String query;
        try {
            query = "select id from `tbl_logintypeclient` where type='" + txtjournalBorrowerType.getText() + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("id");
                txtjournalBorrowerType.setText("type");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox borrowinside;
    private javax.swing.JCheckBox borrowoutside;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnsaveoutside;
    private javax.swing.JTextField copies;
    private com.toedter.calendar.JDateChooser datereq;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel journal;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labeltime;
    private javax.swing.JLabel status;
    private javax.swing.JTextField txtjournalAccNo;
    private javax.swing.JTextField txtjournalAddress;
    private javax.swing.JTextField txtjournalAuthor;
    private javax.swing.JTextField txtjournalBarcode;
    private javax.swing.JTextField txtjournalBorrowerName;
    private javax.swing.JTextField txtjournalBorrowerType;
    private javax.swing.JTextField txtjournalGender;
    private javax.swing.JTextField txtjournalPublisher;
    private javax.swing.JTextField txtjournalRCBarcode;
    private javax.swing.JTextField txtjournalTitle;
    // End of variables declaration//GEN-END:variables
      //to validate if barcode doen't exist 

    private boolean validateBarcode(String Barcode) {
        boolean queue = false;
        ResultSet rs;
        String query;
        try {
            query = "select * from `tbl_journal` where ISBNBarcode='" + Barcode + "' and category_id=" + Global_Variable.category_id;
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
            query = "select * from `tbl_journal` where ISBNBarcode='" + txtjournalBarcode.getText() + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                available = rs.getString("Availability");
                if (active == available.equals("YES")) {
                    txtjournalBarcode.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "This book is cannot be borrowed outside");
                    txtjournalAccNo.setText("");
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
            String query = "select * from tbl_librarybook where ISBNBarcode =" + txtjournalBarcode.getText();
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("Status");
                switch (id) {
                    case "Available":
                        txtjournalRCBarcode.setEditable(true);
                        break;
                    case "Damaged":
                        JOptionPane.showMessageDialog(null, "Opps.. this book is damaged and cannot be borrowed");
                        txtjournalBarcode.setText("");
                        txtjournalAccNo.setText("");
                        txtjournalTitle.setText("");
                        txtjournalAuthor.setText("");
                        txtjournalPublisher.setText(" ");

                        break;
                    case "Lost":
                        JOptionPane.showMessageDialog(null, "Its lost!!!");
                        txtjournalBarcode.setText("");
                        txtjournalAccNo.setText("");
                        txtjournalTitle.setText("");
                        txtjournalAuthor.setText("");
                        txtjournalPublisher.setText("");

                        txtjournalRCBarcode.setText("");
                        txtjournalBorrowerName.setText("");
                        txtjournalGender.setText("");
                        txtjournalAddress.setText("");
                        txtjournalBorrowerType.setText(" ");
                        break;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

}
