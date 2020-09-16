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

public class MAGAZINERETURN extends javax.swing.JFrame {

    dbConn con = new dbConn();
    Global_Variable global_var = new Global_Variable();
    Statement st;

    public MAGAZINERETURN() {
        initComponents();
        showMagazineDate();
        showMagazineTime();
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
        txt_return_magazineAccNo.setEnabled(true);
        txt_Return_magazineBarcode.setEnabled(false);
        txt_return_magazineTitle.setEnabled(false);
        txt_return_magazineedition.setEnabled(false);
        txt_return_magazinePublisher.setEnabled(false);
        txt_return_magazineRCBarcode.setEnabled(false);
        txt_return_magazineBorrowerName.setEnabled(false);
        txt_return_magazineBorrowerGender.setEnabled(false);
        txt_return_magazineBorrowerAddress.setEnabled(false);
        txt_return_magazineBorrowerType.setEnabled(false);
    }

    void showMagazineDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
        labelDate.setText(s.format(d));
    }

    void showMagazineTime() {
        new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm");
                maltime.setText(s.format(d));
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
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txt_return_magazinePublisher = new javax.swing.JTextField();
        txt_return_magazineedition = new javax.swing.JTextField();
        txt_return_magazineTitle = new javax.swing.JTextField();
        txt_return_magazineAccNo = new javax.swing.JTextField();
        txt_Return_magazineBarcode = new javax.swing.JTextField();
        copy = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txt_return_magazineRCBarcode = new javax.swing.JTextField();
        txt_return_magazineBorrowerName = new javax.swing.JTextField();
        txt_return_magazineBorrowerGender = new javax.swing.JTextField();
        txt_return_magazineBorrowerAddress = new javax.swing.JTextField();
        txt_return_magazineBorrowerType = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnoutsidse = new javax.swing.JButton();
        checkoutside = new javax.swing.JCheckBox();
        checkinside = new javax.swing.JCheckBox();
        labelDate = new javax.swing.JLabel();
        maltime = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelstatus = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel21.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel21.setText("ISBN Barcode:");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(50, 60, 100, 30);

        jLabel22.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel22.setText("Accession Number: ");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(20, 20, 140, 20);

        jLabel31.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel31.setText("Magazine Title:");
        jPanel1.add(jLabel31);
        jLabel31.setBounds(50, 110, 100, 20);

        jLabel32.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel32.setText("Edition Number:");
        jPanel1.add(jLabel32);
        jLabel32.setBounds(40, 150, 120, 30);

        jLabel33.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel33.setText("No of copies Available:");
        jPanel1.add(jLabel33);
        jLabel33.setBounds(10, 240, 160, 40);

        txt_return_magazinePublisher.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_magazinePublisher.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_return_magazinePublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_return_magazinePublisherActionPerformed(evt);
            }
        });
        jPanel1.add(txt_return_magazinePublisher);
        txt_return_magazinePublisher.setBounds(160, 200, 210, 30);

        txt_return_magazineedition.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_magazineedition.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txt_return_magazineedition);
        txt_return_magazineedition.setBounds(160, 150, 130, 30);

        txt_return_magazineTitle.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_magazineTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_return_magazineTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_return_magazineTitleActionPerformed(evt);
            }
        });
        jPanel1.add(txt_return_magazineTitle);
        txt_return_magazineTitle.setBounds(160, 100, 210, 30);

        txt_return_magazineAccNo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_magazineAccNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_return_magazineAccNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_return_magazineAccNoActionPerformed(evt);
            }
        });
        txt_return_magazineAccNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_return_magazineAccNoKeyReleased(evt);
            }
        });
        jPanel1.add(txt_return_magazineAccNo);
        txt_return_magazineAccNo.setBounds(160, 10, 120, 30);

        txt_Return_magazineBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_magazineBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Return_magazineBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Return_magazineBarcodeActionPerformed(evt);
            }
        });
        txt_Return_magazineBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Return_magazineBarcodeKeyReleased(evt);
            }
        });
        jPanel1.add(txt_Return_magazineBarcode);
        txt_Return_magazineBarcode.setBounds(160, 60, 210, 30);

        copy.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        copy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(copy);
        copy.setBounds(160, 240, 70, 30);

        jLabel34.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel34.setText("Publisher:");
        jPanel1.add(jLabel34);
        jLabel34.setBounds(80, 190, 90, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(550, 270, 400, 320);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel40.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel40.setText("Borrower Type:");
        jPanel2.add(jLabel40);
        jLabel40.setBounds(70, 300, 100, 14);

        jLabel39.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel39.setText("Address:");
        jPanel2.add(jLabel39);
        jLabel39.setBounds(100, 250, 80, 15);

        jLabel38.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel38.setText("Gender:");
        jPanel2.add(jLabel38);
        jLabel38.setBounds(110, 190, 60, 30);

        jLabel36.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel36.setText("Name:");
        jPanel2.add(jLabel36);
        jLabel36.setBounds(120, 150, 50, 14);

        jLabel35.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel35.setText("Reader's Card Barcode:");
        jPanel2.add(jLabel35);
        jLabel35.setBounds(20, 90, 160, 20);

        txt_return_magazineRCBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_magazineRCBarcode.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_return_magazineRCBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_return_magazineRCBarcodeActionPerformed(evt);
            }
        });
        txt_return_magazineRCBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_return_magazineRCBarcodeKeyReleased(evt);
            }
        });
        jPanel2.add(txt_return_magazineRCBarcode);
        txt_return_magazineRCBarcode.setBounds(180, 90, 200, 30);

        txt_return_magazineBorrowerName.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_magazineBorrowerName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_return_magazineBorrowerName);
        txt_return_magazineBorrowerName.setBounds(180, 140, 210, 30);

        txt_return_magazineBorrowerGender.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_magazineBorrowerGender.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_return_magazineBorrowerGender);
        txt_return_magazineBorrowerGender.setBounds(180, 190, 140, 30);

        txt_return_magazineBorrowerAddress.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_magazineBorrowerAddress.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_return_magazineBorrowerAddress);
        txt_return_magazineBorrowerAddress.setBounds(180, 240, 200, 30);

        txt_return_magazineBorrowerType.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_magazineBorrowerType.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_return_magazineBorrowerType);
        txt_return_magazineBorrowerType.setBounds(180, 290, 200, 30);

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
        btnsave.setBounds(70, 40, 90, 30);

        btnoutsidse.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnoutsidse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        btnoutsidse.setText("SAVE");
        btnoutsidse.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnoutsidse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoutsidseActionPerformed(evt);
            }
        });
        jPanel2.add(btnoutsidse);
        btnoutsidse.setBounds(250, 40, 90, 30);

        checkoutside.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        checkoutside.setText("RETURN FROM OUTSIDE");
        checkoutside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutsideActionPerformed(evt);
            }
        });
        jPanel2.add(checkoutside);
        checkoutside.setBounds(200, 10, 180, 30);

        checkinside.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        checkinside.setText("RETURN FROM INSIDE");
        checkinside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinsideActionPerformed(evt);
            }
        });
        jPanel2.add(checkinside);
        checkinside.setBounds(30, 10, 159, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(990, 270, 420, 340);

        labelDate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelDate.setText("Date:");
        getContentPane().add(labelDate);
        labelDate.setBounds(1290, 30, 100, 30);

        maltime.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        maltime.setText("Time:");
        getContentPane().add(maltime);
        maltime.setBounds(1460, 30, 70, 30);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        jLabel1.setText("MAGAZINE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 30, 210, 30);

        labelstatus.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelstatus.setText("Status:");
        getContentPane().add(labelstatus);
        labelstatus.setBounds(560, 600, 290, 30);

        status.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        status.setText("----------");
        getContentPane().add(status);
        status.setBounds(850, 600, 80, 30);

        setSize(new java.awt.Dimension(1588, 896));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_return_magazinePublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_return_magazinePublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_return_magazinePublisherActionPerformed

    private void txt_return_magazineTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_return_magazineTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_return_magazineTitleActionPerformed

    private void txt_Return_magazineBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Return_magazineBarcodeActionPerformed
       
    }//GEN-LAST:event_txt_Return_magazineBarcodeActionPerformed

    private void txt_Return_magazineBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Return_magazineBarcodeKeyReleased

    }//GEN-LAST:event_txt_Return_magazineBarcodeKeyReleased

    private void txt_return_magazineRCBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_return_magazineRCBarcodeActionPerformed


    }//GEN-LAST:event_txt_return_magazineRCBarcodeActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txt_return_magazineRCBarcode.getText();
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
                        if (txt_Return_magazineBarcode.getText().trim().isEmpty() || txt_return_magazineRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {
                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txt_return_magazineAccNo.getText() + "','" + txt_Return_magazineBarcode.getText() + "','" + txt_return_magazineRCBarcode.getText() + "','" + checkinside.getText() + "', '"+Global_Variable.category_id+"')";
                            executesqlQuery(queries, "Added");

                            try {
                                String queri = "UPDATE `tbl_magazine` SET  `NoofCopies` ='" + copy.getText() + "' WHERE  `ISBNBarcode` =" + txt_Return_magazineBarcode.getText();
                                executesqlQuery(queri, "updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {
                                String querya = "INSERT INTO `tbl_returninside` VALUES('" + Global_Variable.inremagazineId + "','" + getBorrowid() + "','" + labelDate.getText() + "','" + maltime.getText() + "')";
                                executesqlQuery(querya, "Return");

                                txt_Return_magazineBarcode.setText("");
                                txt_return_magazineAccNo.setText("");
                                txt_return_magazineTitle.setText("");
                                txt_return_magazineedition.setText("");
                                txt_return_magazinePublisher.setText("");

                                txt_return_magazineRCBarcode.setText("");
                                txt_return_magazineBorrowerName.setText("");
                                txt_return_magazineBorrowerGender.setText("");
                                txt_return_magazineBorrowerAddress.setText("");
                                txt_return_magazineBorrowerType.setText("");
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

    private void btnoutsidseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoutsidseActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txt_return_magazineRCBarcode.getText();
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
                        if (txt_Return_magazineBarcode.getText().trim().isEmpty() || txt_return_magazineRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {
                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txt_return_magazineAccNo.getText() + "','" + txt_Return_magazineBarcode.getText() + "','" + txt_return_magazineRCBarcode.getText() + "','" + checkinside.getText() + "')";
                            executesqlQuery(queries, "Added");

                            try {
                                String queri = "UPDATE `tbl_magazine` SET  `NoofCopies` ='" + copy.getText() + "' WHERE  `ISBNBarcode` =" + txt_Return_magazineBarcode.getText();
                                executesqlQuery(queri, "updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {
                                String querya = "INSERT INTO `tbl_returnoutside` VALUES('" + Global_Variable.inremagazineId + "','" + getBorrowid() + "','" + labelDate.getText() + "','" + maltime.getText() + "')";
                                executesqlQuery(querya, "Return");

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                String qa = "INSERT INTO `tbl_penalty`(`id`, `accession`, `barcode`, `rcbarcode`, `name`, `datereturn`) VALUES ('" + Global_Variable.penalty + "','" + txt_return_magazineAccNo.getText() + "','" + txt_Return_magazineBarcode.getText() + "','" + txt_return_magazineRCBarcode.getText() + "','" + txt_return_magazineBorrowerName.getText() + "','" + labelDate.getText() + "')";
                                executesqlQuery(qa, "Penalty");
                                txt_Return_magazineBarcode.setText("");
                                txt_return_magazineAccNo.setText("");
                                txt_return_magazineTitle.setText("");
                                txt_return_magazineedition.setText("");
                                txt_return_magazinePublisher.setText("");

                                txt_return_magazineRCBarcode.setText("");
                                txt_return_magazineBorrowerName.setText("");
                                txt_return_magazineBorrowerGender.setText("");
                                txt_return_magazineBorrowerAddress.setText("");
                                txt_return_magazineBorrowerType.setText("");
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


    }//GEN-LAST:event_btnoutsidseActionPerformed

    private void checkinsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinsideActionPerformed
        txt_return_magazineRCBarcode.setEnabled(true);
        labelstatus.setText(txt_Return_magazineBarcode.getText() + " with accession number " + txt_return_magazineAccNo.getText() + " is now: ");
        status.setText("available");

        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_return_magazineAccNo.getText() + "','" + txt_Return_magazineBarcode.getText() + "','" + status.getText() + "','"+Global_Variable.category_id+"')";
        executesqlQuery(quer, "Monitored");
    }//GEN-LAST:event_checkinsideActionPerformed

    private void checkoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutsideActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //  dbConn con = new dbConn();
        String query = "SELECT date_to_return FROM `tbl_borrowoutside` where ISBNBarcode = " + txt_Return_magazineBarcode.getText();

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

            String tempbarcode = txt_Return_magazineBarcode.getText();
            String querys = "SELECT * FROM `tbl_borrowoutside` WHERE ISBNBarcode= " + tempbarcode;

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.prepareStatement(querys);
            rs = st.executeQuery(querys);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_checkoutsideActionPerformed

    private void txt_return_magazineAccNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_return_magazineAccNoKeyReleased
        txt_Return_magazineBarcode.setEnabled(false);
        try {
                ResultSet rs = null;
                String tempbarcode = txt_return_magazineAccNo.getText();

                String query = "SELECT * FROM `tbl_magazineaccession` WHERE accession= '"+tempbarcode+"' and category_id ='"+Global_Variable.category_id+"'" ;
            //    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM d");
                st = con.dbconn().prepareStatement(query);
                rs = st.executeQuery(query);

                try {
                    if (rs.next()) {
                        //to display the data inside the txtfields
                        String barcode = rs.getString("ISBNBarcode");
                        txt_Return_magazineBarcode.setText(barcode);

                        String title = rs.getString("Title");
                        txt_return_magazineTitle.setText(title);

                        String author = rs.getString("EdNum");
                        txt_return_magazineedition.setText(author);

                        String publisher = rs.getString("Publisher");
                        txt_return_magazinePublisher.setText(publisher);

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
                            txt_return_magazineRCBarcode.setEnabled(true);
                            labelstatus.setText(txt_Return_magazineBarcode.getText() + " with accession number " + txt_return_magazineAccNo.getText() + " is now: ");
                            status.setText("available");

                            String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_return_magazineAccNo.getText() + "','" + txt_Return_magazineBarcode.getText() + "','" + status.getText() + "','"+Global_Variable.category_id+"')";
                            executesqlQuery(quer, "Monitored");
                        } else if (choice == JOptionPane.NO_OPTION) {
                            txt_return_magazineRCBarcode.setEnabled(true);
                            labelstatus.setText(txt_Return_magazineBarcode.getText() + " with accession number " + txt_return_magazineAccNo.getText() + " is now: ");
                            status.setText("available");

                            String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_return_magazineAccNo.getText() + "','" + txt_Return_magazineBarcode.getText() + "','" + status.getText() + "', '"+Global_Variable.category_id+"')";
                            executesqlQuery(quer, "Monitored");
                        } else if (choice == JOptionPane.CANCEL_OPTION) {
                            this.setVisible(true);
                        }

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                txt_Return_magazineBarcode.getText();
                txt_return_magazineAccNo.getText();
                txt_return_magazineTitle.getText();
                txt_return_magazineedition.getText();
                txt_return_magazinePublisher.getText();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_txt_return_magazineAccNoKeyReleased

    private void txt_return_magazineRCBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_return_magazineRCBarcodeKeyReleased
        try {
            ResultSet rs = null;

            String tempbarcode = txt_return_magazineRCBarcode.getText();

            String query = "SELECT * FROM `tbl_clientregistration` WHERE ClientBarcode= " + tempbarcode;
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM d");

            st = con.dbconn().prepareStatement(query);
            rs = st.executeQuery(query);

            try {
                if (rs.next()) {
                    //to display the data inside the txtfields
                    String barcode = rs.getString("ClientBarcode");
                    txt_return_magazineRCBarcode.setText(barcode);

                    String name = rs.getString("Name");
                    txt_return_magazineBorrowerName.setText(name);

                    String gender = rs.getString("Gender");
                    txt_return_magazineBorrowerGender.setText(gender);

                    String address = rs.getString("Address");
                    txt_return_magazineBorrowerAddress.setText(address);

                    String type = rs.getString("ClientType");
                    txt_return_magazineBorrowerType.setText(type);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            txt_return_magazineRCBarcode.getText();
            txt_return_magazineBorrowerName.getText();
            txt_return_magazineBorrowerGender.getText();
            txt_return_magazineBorrowerAddress.getText();
            txt_return_magazineBorrowerType.getText();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txt_return_magazineRCBarcodeKeyReleased

    private void txt_return_magazineAccNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_return_magazineAccNoActionPerformed
       try {
                ResultSet rs = null;
                String tempbarcode = txt_return_magazineAccNo.getText();

                String query = "SELECT * FROM `tbl_magazineaccession` WHERE accession= '"+tempbarcode+"' and category_id ='"+Global_Variable.category_id+"'" ;
            //    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM d");
                st = con.dbconn().prepareStatement(query);
                rs = st.executeQuery(query);

                try {
                    if (rs.next()) {
                        //to display the data inside the txtfields
                        String barcode = rs.getString("ISBNBarcode");
                        txt_Return_magazineBarcode.setText(barcode);

                        String title = rs.getString("Title");
                        txt_return_magazineTitle.setText(title);

                        String author = rs.getString("EdNum");
                        txt_return_magazineedition.setText(author);

                        String publisher = rs.getString("Publisher");
                        txt_return_magazinePublisher.setText(publisher);

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
                            txt_return_magazineRCBarcode.setEnabled(true);
                            labelstatus.setText(txt_Return_magazineBarcode.getText() + " with accession number " + txt_return_magazineAccNo.getText() + " is now: ");
                            status.setText("available");

                            String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_return_magazineAccNo.getText() + "','" + txt_Return_magazineBarcode.getText() + "','" + status.getText() + "')";
                            executesqlQuery(quer, "Monitored");
                        } else if (choice == JOptionPane.NO_OPTION) {
                            txt_return_magazineRCBarcode.setEnabled(true);
                            labelstatus.setText(txt_Return_magazineBarcode.getText() + " with accession number " + txt_return_magazineAccNo.getText() + " is now: ");
                            status.setText("available");

                            String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_return_magazineAccNo.getText() + "','" + txt_Return_magazineBarcode.getText() + "','" + status.getText() + "')";
                            executesqlQuery(quer, "Monitored");
                        } else if (choice == JOptionPane.CANCEL_OPTION) {
                            this.setVisible(true);
                        }

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                txt_Return_magazineBarcode.getText();
                txt_return_magazineAccNo.getText();
                txt_return_magazineTitle.getText();
                txt_return_magazineedition.getText();
                txt_return_magazinePublisher.getText();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_txt_return_magazineAccNoActionPerformed

    private boolean validateBarcode(String Barcode) {
        boolean queue = false;
        ResultSet rs;
        String query;
        try {
            query = "select * from `tbl_magazine` where ISBNBarcode='" + Barcode + "' and category_id=" + Global_Variable.category_id;
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

    private void theQuery(String query) {
        Connection con;
        Statement st;

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagesystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            st.executeUpdate(query);
            // JOptionPane.showMessageDialog(this,"Data added Successfully");

            txt_Return_magazineBarcode.setText("");
            txt_return_magazineAccNo.setText("");
            txt_return_magazineTitle.setText("");
            txt_return_magazineedition.setText("");
            txt_return_magazinePublisher.setText("");

            txt_return_magazineRCBarcode.setText("");
            txt_return_magazineBorrowerName.setText("");
            txt_return_magazineBorrowerGender.setText("");
            txt_return_magazineBorrowerAddress.setText("");
            txt_return_magazineBorrowerType.setText(" ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnoutsidse;
    private javax.swing.JButton btnsave;
    private javax.swing.JCheckBox checkinside;
    private javax.swing.JCheckBox checkoutside;
    private javax.swing.JTextField copy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelstatus;
    private javax.swing.JLabel maltime;
    private javax.swing.JLabel status;
    private javax.swing.JTextField txt_Return_magazineBarcode;
    private javax.swing.JTextField txt_return_magazineAccNo;
    private javax.swing.JTextField txt_return_magazineBorrowerAddress;
    private javax.swing.JTextField txt_return_magazineBorrowerGender;
    private javax.swing.JTextField txt_return_magazineBorrowerName;
    private javax.swing.JTextField txt_return_magazineBorrowerType;
    private javax.swing.JTextField txt_return_magazinePublisher;
    private javax.swing.JTextField txt_return_magazineRCBarcode;
    private javax.swing.JTextField txt_return_magazineTitle;
    private javax.swing.JTextField txt_return_magazineedition;
    // End of variables declaration//GEN-END:variables
     private String getBorrowid() {
        Statement st;
        String id = "";
        ResultSet rs;
        String query;
        try {
            query = "SELECT `id` FROM `tbl_borrowinside` WHERE `accession_number` ='" + txt_return_magazineAccNo.getText() + "'";
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
