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

public class CDRETURN extends javax.swing.JFrame {

    dbConn con = new dbConn();
    Global_Variable global_var = new Global_Variable();
    Statement st;

    public CDRETURN() {
        initComponents();
        showCdDate();
        showCdTime();
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
        txt_return_cdAccNo.setEnabled(true);
        txt_Return_cdBarcode.setEnabled(false);
        txt_return_cdTitle.setEnabled(false);
        txt_return_cdGenre.setEnabled(false);
        txt_return_cdRCBarcode.setEnabled(false);
        txt_return_cdBorrowerName.setEnabled(false);
        txt_return_cdBorrowerGender.setEnabled(false);
        txt_return_cdBorrowerAddress.setEnabled(false);
        txt_return_cdBorrowerType.setEnabled(false);
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
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txt_Return_cdBarcode = new javax.swing.JTextField();
        txt_return_cdAccNo = new javax.swing.JTextField();
        txt_return_cdTitle = new javax.swing.JTextField();
        txt_return_cdGenre = new javax.swing.JTextField();
        copy = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        txt_return_cdBorrowerType = new javax.swing.JTextField();
        txt_return_cdBorrowerAddress = new javax.swing.JTextField();
        txt_return_cdBorrowerGender = new javax.swing.JTextField();
        txt_return_cdBorrowerName = new javax.swing.JTextField();
        txt_return_cdRCBarcode = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnoutside = new javax.swing.JButton();
        checkoutside = new javax.swing.JCheckBox();
        checkinside = new javax.swing.JCheckBox();
        labelDate = new javax.swing.JLabel();
        labeltime = new javax.swing.JLabel();
        cd = new javax.swing.JLabel();
        labelstatus = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel55.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel55.setText("ISBN Barcode:");
        jPanel1.add(jLabel55);
        jLabel55.setBounds(50, 70, 100, 40);

        jLabel56.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel56.setText("Accession Number: ");
        jPanel1.add(jLabel56);
        jLabel56.setBounds(20, 30, 140, 15);

        jLabel57.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel57.setText("Cd Title:");
        jPanel1.add(jLabel57);
        jLabel57.setBounds(80, 130, 70, 15);

        jLabel58.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel58.setText("No of Copies Available:");
        jPanel1.add(jLabel58);
        jLabel58.setBounds(20, 210, 160, 30);

        txt_Return_cdBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_cdBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Return_cdBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Return_cdBarcodeActionPerformed(evt);
            }
        });
        txt_Return_cdBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Return_cdBarcodeKeyReleased(evt);
            }
        });
        jPanel1.add(txt_Return_cdBarcode);
        txt_Return_cdBarcode.setBounds(150, 70, 230, 30);

        txt_return_cdAccNo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_cdAccNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_return_cdAccNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_return_cdAccNoActionPerformed(evt);
            }
        });
        txt_return_cdAccNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_return_cdAccNoKeyReleased(evt);
            }
        });
        jPanel1.add(txt_return_cdAccNo);
        txt_return_cdAccNo.setBounds(150, 20, 130, 30);

        txt_return_cdTitle.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_cdTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_return_cdTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_return_cdTitleActionPerformed(evt);
            }
        });
        jPanel1.add(txt_return_cdTitle);
        txt_return_cdTitle.setBounds(150, 120, 230, 30);

        txt_return_cdGenre.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_return_cdGenre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txt_return_cdGenre);
        txt_return_cdGenre.setBounds(150, 170, 230, 30);

        copy.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        copy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(copy);
        copy.setBounds(170, 210, 120, 30);

        jLabel61.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel61.setText("Genre:");
        jPanel1.add(jLabel61);
        jLabel61.setBounds(90, 180, 50, 15);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(560, 290, 420, 260);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel59.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel59.setText("Reader's Card Barcode:");
        jPanel2.add(jLabel59);
        jLabel59.setBounds(10, 100, 160, 30);

        jLabel60.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel60.setText("Name:");
        jPanel2.add(jLabel60);
        jLabel60.setBounds(120, 150, 50, 30);

        jLabel62.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel62.setText("Gender:");
        jPanel2.add(jLabel62);
        jLabel62.setBounds(110, 200, 60, 30);

        jLabel63.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel63.setText("Address:");
        jPanel2.add(jLabel63);
        jLabel63.setBounds(110, 260, 70, 15);

        jLabel64.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel64.setText("Borrowe Type:");
        jPanel2.add(jLabel64);
        jLabel64.setBounds(70, 300, 110, 30);

        txt_return_cdBorrowerType.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_return_cdBorrowerType);
        txt_return_cdBorrowerType.setBounds(180, 300, 220, 30);

        txt_return_cdBorrowerAddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_return_cdBorrowerAddress);
        txt_return_cdBorrowerAddress.setBounds(180, 250, 220, 30);

        txt_return_cdBorrowerGender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_return_cdBorrowerGender);
        txt_return_cdBorrowerGender.setBounds(180, 200, 130, 30);

        txt_return_cdBorrowerName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_return_cdBorrowerName);
        txt_return_cdBorrowerName.setBounds(180, 150, 220, 30);

        txt_return_cdRCBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_return_cdRCBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_return_cdRCBarcodeActionPerformed(evt);
            }
        });
        txt_return_cdRCBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_return_cdRCBarcodeKeyReleased(evt);
            }
        });
        jPanel2.add(txt_return_cdRCBarcode);
        txt_return_cdRCBarcode.setBounds(180, 100, 220, 30);

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
        btnsave.setBounds(70, 60, 90, 30);

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
        btnoutside.setBounds(270, 60, 100, 30);

        checkoutside.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        checkoutside.setText("RETURN FROM OUTSIDE");
        checkoutside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutsideActionPerformed(evt);
            }
        });
        jPanel2.add(checkoutside);
        checkoutside.setBounds(210, 20, 210, 30);

        checkinside.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        checkinside.setText("RETURN FROM INSIDE");
        checkinside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinsideActionPerformed(evt);
            }
        });
        jPanel2.add(checkinside);
        checkinside.setBounds(20, 10, 180, 50);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(1030, 290, 450, 350);

        labelDate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelDate.setText("Date:");
        getContentPane().add(labelDate);
        labelDate.setBounds(1230, 20, 100, 30);

        labeltime.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labeltime.setText("Time:");
        getContentPane().add(labeltime);
        labeltime.setBounds(1440, 20, 70, 30);

        cd.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        cd.setText("CD");
        getContentPane().add(cd);
        cd.setBounds(40, 30, 50, 20);

        labelstatus.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelstatus.setText("Status");
        getContentPane().add(labelstatus);
        labelstatus.setBounds(580, 580, 310, 30);

        status.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        status.setText("---------");
        getContentPane().add(status);
        status.setBounds(890, 580, 40, 30);

        setSize(new java.awt.Dimension(1609, 854));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Return_cdBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Return_cdBarcodeActionPerformed

     

    }//GEN-LAST:event_txt_Return_cdBarcodeActionPerformed

    private void txt_Return_cdBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Return_cdBarcodeKeyReleased

    }//GEN-LAST:event_txt_Return_cdBarcodeKeyReleased

    private void txt_return_cdTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_return_cdTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_return_cdTitleActionPerformed

    private void txt_return_cdRCBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_return_cdRCBarcodeActionPerformed


    }//GEN-LAST:event_txt_return_cdRCBarcodeActionPerformed

    private void txt_return_cdRCBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_return_cdRCBarcodeKeyReleased
        try {
            ResultSet rs = null;

            String tempbarcode = txt_return_cdRCBarcode.getText();

            String query = "SELECT * FROM `tbl_clientregistration` WHERE ClientBarcode= " + tempbarcode;
            st = con.dbconn().prepareStatement(query);
            rs = st.executeQuery(query);

            try {
                if (rs.next()) {
                    //to display the data inside the txtfields
                    String barcode = rs.getString("ClientBarcode");
                    txt_return_cdRCBarcode.setText(barcode);

                    String name = rs.getString("Name");
                    txt_return_cdBorrowerName.setText(name);

                    String gender = rs.getString("Gender");
                    txt_return_cdBorrowerGender.setText(gender);

                    String address = rs.getString("Address");
                    txt_return_cdBorrowerAddress.setText(address);

                    String type = rs.getString("Type");
                    txt_return_cdBorrowerType.setText(type);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            txt_return_cdRCBarcode.getText();
            txt_return_cdBorrowerName.getText();
            txt_return_cdBorrowerGender.getText();
            txt_return_cdBorrowerAddress.getText();
            txt_return_cdBorrowerType.getText();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_txt_return_cdRCBarcodeKeyReleased

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txt_return_cdRCBarcode.getText();
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
                        if (txt_Return_cdBarcode.getText().trim().isEmpty() || txt_return_cdRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {
                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txt_return_cdAccNo.getText() + "','" + txt_Return_cdBarcode.getText() + "','" + txt_return_cdRCBarcode.getText() + "','" + checkinside.getText() + "')";
                            executesqlQuery(queries, "Added");

                            try {
                                String queri = "UPDATE `tbl_cd` SET  `NoOfCopies` ='" + copy.getText() + "' WHERE  `cd_Barcode` =" + txt_Return_cdBarcode.getText();
                                executesqlQuery(queri, "updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {
                                String quer = "INSERT INTO `tbl_returninside` VALUES ('" + Global_Variable.inrecdId + "','" + getBorrowid() + "','" + labelDate + "','" + labeltime + "')";
                                executesqlQuery(quer, "added");
                                txt_Return_cdBarcode.setText("");
                                txt_return_cdAccNo.setText("");
                                txt_return_cdTitle.setText("");
                                txt_return_cdGenre.setText("");

                                txt_return_cdRCBarcode.setText("");
                                txt_return_cdBorrowerName.setText("");
                                txt_return_cdBorrowerGender.setText("");
                                txt_return_cdBorrowerAddress.setText("");
                                txt_return_cdBorrowerType.setText(" ");

                                txt_Return_cdBarcode.setEnabled(false);
                                txt_return_cdRCBarcode.setEnabled(false);
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
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txt_return_cdRCBarcode.getText();
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
                        if (txt_Return_cdBarcode.getText().trim().isEmpty() || txt_return_cdRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {
                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txt_return_cdAccNo.getText() + "','" + txt_Return_cdBarcode.getText() + "','" + txt_return_cdRCBarcode.getText() + "','" + checkoutside.getText() + "')";
                            executesqlQuery(queries, "Added");

                            try {
                                String queri = "UPDATE `tbl_cd` SET  `NoOfCopies` ='" + copy.getText() + "' WHERE  `cd_Barcode` =" + txt_Return_cdBarcode.getText();
                                executesqlQuery(queri, "updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {
                                String quer = "INSERT INTO `tbl_returnoutside` VALUES ('" + Global_Variable.outrecdId + "','" + getBorrowid() + "','" + labelDate + "','" + labeltime + "')";
                                executesqlQuery(quer, "added");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                String qa = "INSERT INTO `tbl_penalty`(`id`, `accession`, `barcode`, `rcbarcode`, `name`, `datereturn`) VALUES ('" + Global_Variable.penalty + "','" + txt_return_cdAccNo.getText() + "','" + txt_Return_cdBarcode.getText() + "','" + txt_return_cdRCBarcode.getText() + "','" + txt_return_cdBorrowerName.getText() + "','" + labelDate.getText() + "')";
                                executesqlQuery(qa, "Penalty");
                                txt_Return_cdBarcode.setText("");
                                txt_return_cdAccNo.setText("");
                                txt_return_cdTitle.setText("");
                                txt_return_cdGenre.setText("");

                                txt_return_cdRCBarcode.setText("");
                                txt_return_cdBorrowerName.setText("");
                                txt_return_cdBorrowerGender.setText("");
                                txt_return_cdBorrowerAddress.setText("");
                                txt_return_cdBorrowerType.setText(" ");
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

    private void checkinsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinsideActionPerformed

    }//GEN-LAST:event_checkinsideActionPerformed

    private void checkoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutsideActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //  dbConn con = new dbConn();
        String query = "SELECT date_to_return FROM `tbl_borrowoutside` where ISBNBarcode = " + txt_Return_cdBarcode.getText();

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

        Connection cn = null;

        String tempbarcode = txt_Return_cdBarcode.getText();
        String querys = "SELECT * FROM `tbl_borrowoutside` WHERE ISBNBarcode= " + tempbarcode;
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.prepareStatement(querys);
            rs = st.executeQuery(querys);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }//GEN-LAST:event_checkoutsideActionPerformed

    private void txt_return_cdAccNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_return_cdAccNoKeyReleased
        txt_Return_cdBarcode.setEnabled(true);
    }//GEN-LAST:event_txt_return_cdAccNoKeyReleased

    private void txt_return_cdAccNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_return_cdAccNoActionPerformed
        try {

            ResultSet rs = null;

            String tempbarcode = txt_return_cdAccNo.getText();

            String query = "SELECT * FROM `tbl_cdaccession` WHERE accession ='"+tempbarcode+"' and category_id='"+Global_Variable.category_id+"' ";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM d");

            st = con.dbconn().prepareStatement(query);
            rs = st.executeQuery(query);

            try {
                if (rs.next()) {
                    //to display the data inside the txtfields
                    String barcode = rs.getString("ISBNBarcode");
                    txt_Return_cdBarcode.setText(barcode);

                    String title = rs.getString("Title");
                    txt_return_cdTitle.setText(title);

                    String author = rs.getString("Genre");
                    txt_return_cdGenre.setText(author);

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

                        txt_return_cdRCBarcode.setEnabled(true);
                        labelstatus.setText(txt_Return_cdBarcode.getText() + " with accession number " + txt_return_cdAccNo.getText() + " is now: ");
                        status.setText("available");

                        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_return_cdAccNo.getText() + "','" + txt_Return_cdBarcode.getText() + "','" + status.getText() + "')";
                        executesqlQuery(quer, "Monitored");
                    } else if (choice == JOptionPane.NO_OPTION) {

                        txt_return_cdRCBarcode.setEnabled(true);
                        labelstatus.setText(txt_Return_cdBarcode.getText() + " with accession number " + txt_return_cdAccNo.getText() + " is now: ");
                        status.setText("available");

                        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_return_cdAccNo.getText() + "','" + txt_Return_cdBarcode.getText() + "','" + status.getText() + "')";
                        executesqlQuery(quer, "Monitored");
                    } else if (choice == JOptionPane.CANCEL_OPTION) {
                        this.setVisible(true);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            txt_Return_cdBarcode.getText();
            txt_return_cdAccNo.getText();
            txt_return_cdTitle.getText();
            txt_return_cdGenre.getText();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txt_return_cdAccNoActionPerformed

    private boolean validateBarcode(String Barcode) {
        boolean queue = false;
        ResultSet rs;
        String query;
        try {
            query = "select * from `tbl_librarybook` where ISBNBarcode ='" + Barcode + "' and category_id=" + Global_Variable.category_id;
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

    //RC Barcode
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

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            st.executeUpdate(query);
            // JOptionPane.showMessageDialog(this,"Data added Successfully");

            txt_Return_cdBarcode.setText("");
            txt_return_cdAccNo.setText("");
            txt_return_cdTitle.setText("");
            txt_return_cdGenre.setText("");

            txt_return_cdRCBarcode.setText("");
            txt_return_cdBorrowerName.setText("");
            txt_return_cdBorrowerGender.setText("");
            txt_return_cdBorrowerAddress.setText("");
            txt_return_cdBorrowerType.setText(" ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnoutside;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel cd;
    private javax.swing.JCheckBox checkinside;
    private javax.swing.JCheckBox checkoutside;
    private javax.swing.JTextField copy;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelstatus;
    private javax.swing.JLabel labeltime;
    private javax.swing.JLabel status;
    private javax.swing.JTextField txt_Return_cdBarcode;
    private javax.swing.JTextField txt_return_cdAccNo;
    private javax.swing.JTextField txt_return_cdBorrowerAddress;
    private javax.swing.JTextField txt_return_cdBorrowerGender;
    private javax.swing.JTextField txt_return_cdBorrowerName;
    private javax.swing.JTextField txt_return_cdBorrowerType;
    private javax.swing.JTextField txt_return_cdGenre;
    private javax.swing.JTextField txt_return_cdRCBarcode;
    private javax.swing.JTextField txt_return_cdTitle;
    // End of variables declaration//GEN-END:variables
      private String getBorrowid() {
        Statement st;
        String id = "";
        ResultSet rs;
        String query;
        try {
            query = "SELECT `id` FROM `tbl_borrowinside` WHERE `accession_number` ='" + txt_return_cdAccNo.getText() + "'";
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
