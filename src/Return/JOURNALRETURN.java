package Return;

import Global_Variable.Global_Variable;
import Module.dbConn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import mainframe.RENEWALFORM;

public class JOURNALRETURN extends javax.swing.JFrame {

    dbConn con = new dbConn();
    Global_Variable global_var = new Global_Variable();
    Statement st;

    public JOURNALRETURN() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);  

        txt_return_journalAccNo.setEnabled(true);
        txt_Return_journalBarcode.setEnabled(false);
        txt_return_journalTitle.setEnabled(false);
        txt_return_journalAuthor.setEnabled(false);
        txt_return_journalPublisher.setEnabled(false);
        txt_return_journalRCBarcode.setEnabled(false);
        txt_return_journalBorrowerName.setEnabled(false);
        txt_return_journalBorrowerGender.setEnabled(false);
        txt_return_journalBorrowerAddress.setEnabled(false);
        txt_return_journalBorrowerType.setEnabled(false);
        status.setText("----");
    }

    void showBookDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
        labelDate.setText(s.format(d));
    }

    void showBookTime() {
        new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm");
                labeltime.setText(s.format(d));
            }

        }).start();
    }

    private void executesqlQuery(String query, String message) {
        try {
            st = null;
            st = con.dbconn().createStatement();
            if ((st.executeUpdate(query)) == 1) {
                JOptionPane.showMessageDialog(null, "Data " + message + " successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Data " + message + ".");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txt_return_journalPublisher = new javax.swing.JTextField();
        txt_return_journalAuthor = new javax.swing.JTextField();
        txt_return_journalTitle = new javax.swing.JTextField();
        txt_return_journalAccNo = new javax.swing.JTextField();
        txt_Return_journalBarcode = new javax.swing.JTextField();
        copy = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txt_return_journalRCBarcode = new javax.swing.JTextField();
        txt_return_journalBorrowerName = new javax.swing.JTextField();
        txt_return_journalBorrowerGender = new javax.swing.JTextField();
        txt_return_journalBorrowerAddress = new javax.swing.JTextField();
        txt_return_journalBorrowerType = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnoutside = new javax.swing.JButton();
        checkoutside = new javax.swing.JCheckBox();
        checkinside = new javax.swing.JCheckBox();
        labelDate = new javax.swing.JLabel();
        labeltime = new javax.swing.JLabel();
        journal = new javax.swing.JLabel();
        labelstatus = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel34.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel34.setText("ISBN Barcode:");
        jPanel1.add(jLabel34);
        jLabel34.setBounds(50, 70, 90, 30);

        jLabel43.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel43.setText("Accession Number: ");
        jPanel1.add(jLabel43);
        jLabel43.setBounds(20, 20, 130, 30);

        jLabel44.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel44.setText("Journal Title:");
        jPanel1.add(jLabel44);
        jLabel44.setBounds(60, 110, 90, 40);

        jLabel45.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel45.setText("Author:");
        jPanel1.add(jLabel45);
        jLabel45.setBounds(90, 170, 50, 30);

        jLabel46.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel46.setText("No of Copies Available:");
        jPanel1.add(jLabel46);
        jLabel46.setBounds(30, 260, 160, 30);

        txt_return_journalPublisher.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_journalPublisher.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_return_journalPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_return_journalPublisherActionPerformed(evt);
            }
        });
        jPanel1.add(txt_return_journalPublisher);
        txt_return_journalPublisher.setBounds(160, 220, 230, 30);

        txt_return_journalAuthor.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_journalAuthor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txt_return_journalAuthor);
        txt_return_journalAuthor.setBounds(160, 170, 230, 30);

        txt_return_journalTitle.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_journalTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_return_journalTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_return_journalTitleActionPerformed(evt);
            }
        });
        jPanel1.add(txt_return_journalTitle);
        txt_return_journalTitle.setBounds(160, 120, 230, 30);

        txt_return_journalAccNo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_journalAccNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_return_journalAccNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_return_journalAccNoActionPerformed(evt);
            }
        });
        txt_return_journalAccNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_return_journalAccNoKeyReleased(evt);
            }
        });
        jPanel1.add(txt_return_journalAccNo);
        txt_return_journalAccNo.setBounds(160, 20, 220, 30);

        txt_Return_journalBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_journalBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Return_journalBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Return_journalBarcodeActionPerformed(evt);
            }
        });
        txt_Return_journalBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Return_journalBarcodeKeyReleased(evt);
            }
        });
        jPanel1.add(txt_Return_journalBarcode);
        txt_Return_journalBarcode.setBounds(160, 70, 220, 30);

        copy.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        copy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(copy);
        copy.setBounds(180, 260, 80, 30);

        jLabel49.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel49.setText("Publisher:");
        jPanel1.add(jLabel49);
        jLabel49.setBounds(80, 220, 70, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(440, 230, 460, 300);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel47.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel47.setText("Reader's Card Barcode:");
        jPanel2.add(jLabel47);
        jLabel47.setBounds(10, 90, 160, 30);

        jLabel48.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel48.setText("Name:");
        jPanel2.add(jLabel48);
        jLabel48.setBounds(120, 130, 50, 50);

        jLabel50.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel50.setText("Gender:");
        jPanel2.add(jLabel50);
        jLabel50.setBounds(110, 190, 60, 30);

        jLabel51.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel51.setText("Address:");
        jPanel2.add(jLabel51);
        jLabel51.setBounds(100, 250, 70, 15);

        jLabel52.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel52.setText("Borrowe Type:");
        jPanel2.add(jLabel52);
        jLabel52.setBounds(70, 300, 110, 15);

        txt_return_journalRCBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_journalRCBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_return_journalRCBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_return_journalRCBarcodeActionPerformed(evt);
            }
        });
        txt_return_journalRCBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_return_journalRCBarcodeKeyReleased(evt);
            }
        });
        jPanel2.add(txt_return_journalRCBarcode);
        txt_return_journalRCBarcode.setBounds(180, 90, 170, 30);

        txt_return_journalBorrowerName.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_journalBorrowerName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_return_journalBorrowerName);
        txt_return_journalBorrowerName.setBounds(180, 140, 210, 30);

        txt_return_journalBorrowerGender.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_journalBorrowerGender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_return_journalBorrowerGender);
        txt_return_journalBorrowerGender.setBounds(180, 190, 150, 30);

        txt_return_journalBorrowerAddress.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_journalBorrowerAddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_return_journalBorrowerAddress);
        txt_return_journalBorrowerAddress.setBounds(180, 240, 220, 30);

        txt_return_journalBorrowerType.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_journalBorrowerType.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_return_journalBorrowerType);
        txt_return_journalBorrowerType.setBounds(180, 290, 220, 30);

        btnsave.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        btnsave.setText("SAVE");
        btnsave.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnsave);
        btnsave.setBounds(70, 50, 90, 30);

        btnoutside.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnoutside.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        btnoutside.setText("SAVE");
        btnoutside.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnoutside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoutsideActionPerformed(evt);
            }
        });
        jPanel2.add(btnoutside);
        btnoutside.setBounds(280, 50, 90, 30);

        checkoutside.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        checkoutside.setText("RETURN FROM OUTSIDE");
        checkoutside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutsideActionPerformed(evt);
            }
        });
        jPanel2.add(checkoutside);
        checkoutside.setBounds(210, 20, 195, 29);

        checkinside.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        checkinside.setText("RETURN FROM INSIDE");
        checkinside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinsideActionPerformed(evt);
            }
        });
        jPanel2.add(checkinside);
        checkinside.setBounds(20, 20, 183, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(970, 230, 440, 350);

        labelDate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelDate.setText("Date:");
        getContentPane().add(labelDate);
        labelDate.setBounds(1230, 30, 100, 30);

        labeltime.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labeltime.setText("Time:");
        getContentPane().add(labeltime);
        labeltime.setBounds(1420, 30, 70, 30);

        journal.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        journal.setText("JOURNAL");
        getContentPane().add(journal);
        journal.setBounds(40, 20, 150, 30);

        labelstatus.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelstatus.setText("Status:");
        getContentPane().add(labelstatus);
        labelstatus.setBounds(450, 540, 320, 30);

        status.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        status.setText("----------");
        getContentPane().add(status);
        status.setBounds(770, 540, 130, 30);

        setSize(new java.awt.Dimension(1607, 915));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_return_journalPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_return_journalPublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_return_journalPublisherActionPerformed

    private void txt_return_journalTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_return_journalTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_return_journalTitleActionPerformed

    private void txt_Return_journalBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Return_journalBarcodeActionPerformed
      
    }//GEN-LAST:event_txt_Return_journalBarcodeActionPerformed

    private void txt_Return_journalBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Return_journalBarcodeKeyReleased

    }//GEN-LAST:event_txt_Return_journalBarcodeKeyReleased

    private void txt_return_journalRCBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_return_journalRCBarcodeActionPerformed


    }//GEN-LAST:event_txt_return_journalRCBarcodeActionPerformed

    private void txt_return_journalRCBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_return_journalRCBarcodeKeyReleased
        try {

            ResultSet rs = null;

            String tempbarcode = txt_return_journalRCBarcode.getText();

            String query = "SELECT * FROM `tbl_clientregistration` WHERE ClientBarcode= " + tempbarcode;
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM d");
            st = con.dbconn().prepareStatement(query);
            rs = st.executeQuery(query);

            try {
                if (rs.next()) {
                    //to display the data inside the txtfields
                    String barcode = rs.getString("ClientBarcode");
                    txt_return_journalRCBarcode.setText(barcode);

                    String name = rs.getString("Name");
                    txt_return_journalBorrowerName.setText(name);

                    String gender = rs.getString("Gender");
                    txt_return_journalBorrowerGender.setText(gender);

                    String address = rs.getString("Address");
                    txt_return_journalBorrowerAddress.setText(address);

                    String type = rs.getString("ClientType");
                    txt_return_journalBorrowerType.setText(type);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            txt_return_journalRCBarcode.getText();
            txt_return_journalBorrowerName.getText();
            txt_return_journalBorrowerGender.getText();
            txt_return_journalBorrowerAddress.getText();
            txt_return_journalBorrowerType.getText();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txt_return_journalRCBarcodeKeyReleased

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txt_return_journalRCBarcode.getText();
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
                        if (txt_Return_journalBarcode.getText().trim().isEmpty() || txt_return_journalRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {
                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txt_return_journalAccNo.getText() + "','" + txt_Return_journalBarcode.getText() + "','" + txt_return_journalRCBarcode.getText() + "','" + checkinside.getText() + "','"+Global_Variable.category_id+"')";
                            executesqlQuery(queries, "trasaction added");

                            try {
                                String queri = "UPDATE `tbl_journal` SET  `NoOfCopies` ='" + copy.getText() + "' WHERE  `ISBNBarcode` =" + txt_Return_journalBarcode.getText();
                                executesqlQuery(queri, "updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {
                                String querys = "INSERT INTO `tbl_returninside` VALUES ('" + txt_return_journalAccNo.getText() + "','" + getBorrowid() + "','" + labelDate.getText() + "','" + labeltime.getText() + "')";
                                executesqlQuery(querys, "added");
                                txt_Return_journalBarcode.setText("");
                                txt_return_journalAccNo.setText("");
                                txt_return_journalTitle.setText("");
                                txt_return_journalAuthor.setText("");
                                txt_return_journalPublisher.setText("");
                                copy.setText("");

                                txt_return_journalRCBarcode.setText("");
                                txt_return_journalBorrowerName.setText("");
                                txt_return_journalBorrowerGender.setText("");
                                txt_return_journalBorrowerAddress.setText("");
                                txt_return_journalBorrowerType.setText("");

                                txt_Return_journalBarcode.setEnabled(false);
                                txt_return_journalRCBarcode.setEnabled(false);
                                copy.setEnabled(false);

                                //to deduct the no of copies from the database
                                String aa = copy.getText();
                                int access = Integer.valueOf(aa);
                                aa = Integer.toString(--access);
                                copy.setText(aa);

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
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoutsideActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txt_return_journalRCBarcode.getText();
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
                        if (txt_Return_journalBarcode.getText().trim().isEmpty() || txt_return_journalRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {
                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txt_return_journalAccNo.getText() + "','" + txt_Return_journalBarcode.getText() + "','" + txt_return_journalRCBarcode.getText() + "','" + checkoutside.getText() + "')";
                            executesqlQuery(queries, "trasaction added");

                            try {
                                String queri = "UPDATE `tbl_journal` SET  `NoOfCopies` ='" + copy.getText() + "' WHERE  `ISBNBarcode` =" + txt_Return_journalBarcode.getText();
                                executesqlQuery(queri, "updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                String querya = "INSERT INTO `tbl_returnoutside` VALUES ('" + txt_return_journalAccNo.getText() + "','" + getBorrowid() + "','" + labelDate.getText() + "','" + labeltime.getText() + "')";
                                executesqlQuery(querya, "added");

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                String qa = "INSERT INTO `tbl_penalty`(`id`, `accession`, `barcode`, `rcbarcode`, `name`, `datereturn`) VALUES ('" + Global_Variable.penalty + "','" + txt_return_journalAccNo.getText() + "','" + txt_Return_journalBarcode.getText() + "','" + txt_return_journalRCBarcode.getText() + "','" + txt_return_journalBorrowerName.getText() + "','" + labelDate.getText() + "')";
                                executesqlQuery(qa, "Penalty");
                                txt_Return_journalBarcode.setText("");
                                txt_return_journalAccNo.setText("");
                                txt_return_journalTitle.setText("");
                                txt_return_journalAuthor.setText("");
                                txt_return_journalPublisher.setText("");

                                txt_return_journalRCBarcode.setText("");
                                txt_return_journalBorrowerName.setText("");
                                txt_return_journalBorrowerGender.setText("");
                                txt_return_journalBorrowerAddress.setText("");
                                txt_return_journalBorrowerType.setText("");

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
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnoutsideActionPerformed

    private void txt_return_journalAccNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_return_journalAccNoActionPerformed
          try {

                ResultSet rs = null;
                String tempbarcode = txt_return_journalAccNo.getText();

                String query = "SELECT * FROM `tbl_journalaccession` WHERE accession= '"+tempbarcode+"' and category_id='"+Global_Variable.category_id+"'";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM d");
                st = con.dbconn().prepareStatement(query);
                rs = st.executeQuery(query);

                try {
                    if (rs.next()) {
                        //to display the data inside the txtfields
                        String barcode = rs.getString("ISBNBarcode");
                        txt_Return_journalBarcode.setText(barcode);

                        String title = rs.getString("Title");
                        txt_return_journalTitle.setText(title);

                        String author = rs.getString("Author");
                        txt_return_journalAuthor.setText(author);

                        String publisher = rs.getString("Publisher");
                        txt_return_journalPublisher.setText(publisher);

                        String copii = rs.getString("Copies");
                        copy.setText(copii);

                        String a = copy.getText();
                        int access = Integer.valueOf(a);
                        a = Integer.toString(++access);
                        copii = a;
                        copy.setText(copii);

                    
                        int choice;
                        choice = JOptionPane.showConfirmDialog(null, "Return from outside?");

                        if (choice == JOptionPane.YES_OPTION) {
                            labelstatus.setText(txt_Return_journalBarcode.getText() + " with accession number " + txt_return_journalAccNo.getText() + " is now: ");
                            status.setText("available");

                            String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_return_journalAccNo.getText() + "','" + txt_Return_journalBarcode.getText() + "','" + status.getText() + "')";
                            executesqlQuery(quer, "Monitored");
                        } else if (choice == JOptionPane.NO_OPTION) {
                            labelstatus.setText(txt_Return_journalBarcode.getText() + " with accession number " + txt_return_journalAccNo.getText() + " is now: ");
                            status.setText("available");

                            String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_return_journalAccNo.getText() + "','" + txt_Return_journalBarcode.getText() + "','" + status.getText() + "')";
                            executesqlQuery(quer, "Monitored");
                        } else if (choice == JOptionPane.CANCEL_OPTION) {
                            this.setVisible(true);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                txt_Return_journalBarcode.getText();
                txt_return_journalAccNo.getText();
                txt_return_journalTitle.getText();
                txt_return_journalAuthor.getText();
                txt_return_journalPublisher.getText();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_txt_return_journalAccNoActionPerformed

    private void checkinsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinsideActionPerformed
        txt_return_journalRCBarcode.setEnabled(true);
        labelstatus.setText(txt_Return_journalBarcode.getText() + " with accession number " + txt_return_journalAccNo.getText() + " is now: ");
        status.setText("available");

        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_return_journalAccNo.getText() + "','" + txt_Return_journalBarcode.getText() + "','" + status.getText() + "')";
        executesqlQuery(quer, "Monitored");
    }//GEN-LAST:event_checkinsideActionPerformed

    private void checkoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutsideActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //  dbConn con = new dbConn();
        String query = "SELECT date_to_return FROM `tbl_borrowoutside` where ISBNBarcode = " + txt_Return_journalBarcode.getText();

        SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
        Calendar now = Calendar.getInstance();
        Date l = null, a = null, b = null;
        try {
            st = con.dbconn().prepareStatement(query);
            rs = st.executeQuery(query);

            if (rs.next()) {
                //gkan sa db
                String dates = rs.getString("date_to_return");
                String datereturns = rs.getString("date_to_return");
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
                    JOptionPane.showMessageDialog(null, datereturns);
                    if (l.getTime() < a.getTime()) {
                        JOptionPane.showMessageDialog(null, "Opps you overdue");
                        PENALTY_FORM Lib = new PENALTY_FORM();
                        Lib.setVisible(true);
                        Lib.setLocationRelativeTo(null);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Connection cn = null;

            String tempbarcode = txt_Return_journalBarcode.getText();
            String querys = "SELECT * FROM `tbl_borrowoutside` WHERE ISBNBarcode= " + tempbarcode;

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.prepareStatement(querys);
            rs = st.executeQuery(querys);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }//GEN-LAST:event_checkoutsideActionPerformed

    private void txt_return_journalAccNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_return_journalAccNoKeyReleased
      try {

                ResultSet rs = null;
                String tempbarcode = txt_return_journalAccNo.getText();

                String query = "SELECT * FROM `tbl_journalaccession` WHERE accession= '"+tempbarcode+"' and category_id='"+Global_Variable.category_id+"'";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM d");
                st = con.dbconn().prepareStatement(query);
                rs = st.executeQuery(query);

                try {
                    if (rs.next()) {
                        //to display the data inside the txtfields
                        String barcode = rs.getString("ISBNBarcode");
                        txt_Return_journalBarcode.setText(barcode);

                        String title = rs.getString("Title");
                        txt_return_journalTitle.setText(title);

                        String author = rs.getString("Author");
                        txt_return_journalAuthor.setText(author);

                        String publisher = rs.getString("Publisher");
                        txt_return_journalPublisher.setText(publisher);

                        String copii = rs.getString("Copies");
                        copy.setText(copii);

                        String a = copy.getText();
                        int access = Integer.valueOf(a);
                        a = Integer.toString(++access);
                        copii = a;
                        copy.setText(copii);

                    
                        int choice;
                        choice = JOptionPane.showConfirmDialog(null, "Return from outside?");

                        if (choice == JOptionPane.YES_OPTION) {
                            labelstatus.setText(txt_Return_journalBarcode.getText() + " with accession number " + txt_return_journalAccNo.getText() + " is now: ");
                            status.setText("available");

                            String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_return_journalAccNo.getText() + "','" + txt_Return_journalBarcode.getText() + "','" + status.getText() + "')";
                            executesqlQuery(quer, "Monitored");
                        } else if (choice == JOptionPane.NO_OPTION) {
                            labelstatus.setText(txt_Return_journalBarcode.getText() + " with accession number " + txt_return_journalAccNo.getText() + " is now: ");
                            status.setText("available");

                            String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_return_journalAccNo.getText() + "','" + txt_Return_journalBarcode.getText() + "','" + status.getText() + "')";
                            executesqlQuery(quer, "Monitored");
                        } else if (choice == JOptionPane.CANCEL_OPTION) {
                            this.setVisible(true);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                txt_Return_journalBarcode.getText();
                txt_return_journalAccNo.getText();
                txt_return_journalTitle.getText();
                txt_return_journalAuthor.getText();
                txt_return_journalPublisher.getText();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_txt_return_journalAccNoKeyReleased

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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnoutside;
    private javax.swing.JButton btnsave;
    private javax.swing.JCheckBox checkinside;
    private javax.swing.JCheckBox checkoutside;
    private javax.swing.JTextField copy;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel journal;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelstatus;
    private javax.swing.JLabel labeltime;
    private javax.swing.JLabel status;
    private javax.swing.JTextField txt_Return_journalBarcode;
    private javax.swing.JTextField txt_return_journalAccNo;
    private javax.swing.JTextField txt_return_journalAuthor;
    private javax.swing.JTextField txt_return_journalBorrowerAddress;
    private javax.swing.JTextField txt_return_journalBorrowerGender;
    private javax.swing.JTextField txt_return_journalBorrowerName;
    private javax.swing.JTextField txt_return_journalBorrowerType;
    private javax.swing.JTextField txt_return_journalPublisher;
    private javax.swing.JTextField txt_return_journalRCBarcode;
    private javax.swing.JTextField txt_return_journalTitle;
    // End of variables declaration//GEN-END:variables
        private String getBorrowid() {
        Statement st;
        String id = "";
        ResultSet rs;
        String query;
        try {
            query = "SELECT `id` FROM `tbl_borrowinside` WHERE `accession_number` ='" + txt_return_journalAccNo.getText() + "'";
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
}
