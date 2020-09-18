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

public class NEWSPAPERRETURN extends javax.swing.JFrame {

    dbConn con = new dbConn();
    Global_Variable global_var = new Global_Variable();
    Statement st;

    public NEWSPAPERRETURN() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
        
        txt_Return_newspaperAccNo.setEnabled(true);
        txtbarcode.setEnabled(false);
        txt_Return_newspaperHeading.setEnabled(false);
        txt_Return_newspaperVolume.setEnabled(false);
        txt_Return_newspaperRCBarcode.setEnabled(false);
        txt_Return_newspaperBorrowerName.setEnabled(false);
        txt_Return_newspaperBorrowerGender.setEnabled(false);
        txt_Return_newspaperBorrowerAddress.setEnabled(false);
        txt_Return_newspaperBorrowerType.setEnabled(false);

    }

    void showBookDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
        redate.setText(s.format(d));
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
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_Return_newspaperVolume = new javax.swing.JTextField();
        txt_Return_newspaperHeading = new javax.swing.JTextField();
        txt_Return_newspaperAccNo = new javax.swing.JTextField();
        txtbarcode = new javax.swing.JTextField();
        copy = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txt_Return_newspaperBorrowerType = new javax.swing.JTextField();
        txt_Return_newspaperBorrowerAddress = new javax.swing.JTextField();
        txt_Return_newspaperBorrowerGender = new javax.swing.JTextField();
        txt_Return_newspaperBorrowerName = new javax.swing.JTextField();
        txt_Return_newspaperRCBarcode = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnoutside = new javax.swing.JButton();
        checkoutside = new javax.swing.JCheckBox();
        checkinside = new javax.swing.JCheckBox();
        labelstatus = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        labeltime = new javax.swing.JLabel();
        redate = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel18.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel18.setText("ISBNBarcode:");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(50, 70, 90, 15);

        jLabel21.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel21.setText("Accession Number: ");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(10, 30, 140, 15);

        jLabel19.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel19.setText("Heading:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(80, 120, 70, 14);

        jLabel20.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel20.setText("No of Copies Available:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(20, 205, 160, 40);

        txt_Return_newspaperVolume.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_newspaperVolume.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txt_Return_newspaperVolume);
        txt_Return_newspaperVolume.setBounds(150, 160, 200, 30);

        txt_Return_newspaperHeading.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_newspaperHeading.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Return_newspaperHeading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Return_newspaperHeadingActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Return_newspaperHeading);
        txt_Return_newspaperHeading.setBounds(150, 110, 200, 30);

        txt_Return_newspaperAccNo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_newspaperAccNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Return_newspaperAccNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Return_newspaperAccNoActionPerformed(evt);
            }
        });
        txt_Return_newspaperAccNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Return_newspaperAccNoKeyReleased(evt);
            }
        });
        jPanel1.add(txt_Return_newspaperAccNo);
        txt_Return_newspaperAccNo.setBounds(150, 20, 120, 30);

        txtbarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtbarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtbarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbarcodeActionPerformed(evt);
            }
        });
        jPanel1.add(txtbarcode);
        txtbarcode.setBounds(150, 60, 200, 30);

        copy.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        copy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(copy);
        copy.setBounds(170, 210, 90, 30);

        jLabel22.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel22.setText("Volume:");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(80, 170, 60, 15);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(580, 230, 380, 280);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel23.setText("Reader's Card Barcode:");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(10, 170, 150, 30);

        jLabel24.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel24.setText("Name:");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(120, 210, 50, 20);

        jLabel26.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel26.setText("Gender:");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(120, 250, 60, 30);

        jLabel27.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel27.setText("Address:");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(110, 290, 60, 30);

        jLabel28.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel28.setText("Borrowe Type:");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(70, 320, 100, 40);

        txt_Return_newspaperBorrowerType.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_newspaperBorrowerType.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_Return_newspaperBorrowerType);
        txt_Return_newspaperBorrowerType.setBounds(180, 330, 230, 30);

        txt_Return_newspaperBorrowerAddress.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_newspaperBorrowerAddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_Return_newspaperBorrowerAddress);
        txt_Return_newspaperBorrowerAddress.setBounds(180, 290, 230, 30);

        txt_Return_newspaperBorrowerGender.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_newspaperBorrowerGender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_Return_newspaperBorrowerGender);
        txt_Return_newspaperBorrowerGender.setBounds(180, 250, 110, 30);

        txt_Return_newspaperBorrowerName.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_newspaperBorrowerName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_Return_newspaperBorrowerName);
        txt_Return_newspaperBorrowerName.setBounds(180, 210, 220, 30);

        txt_Return_newspaperRCBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_newspaperRCBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Return_newspaperRCBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Return_newspaperRCBarcodeActionPerformed(evt);
            }
        });
        txt_Return_newspaperRCBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Return_newspaperRCBarcodeKeyReleased(evt);
            }
        });
        jPanel2.add(txt_Return_newspaperRCBarcode);
        txt_Return_newspaperRCBarcode.setBounds(180, 170, 220, 30);

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
        btnsave.setBounds(87, 83, 90, 30);

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
        btnoutside.setBounds(270, 83, 90, 30);

        checkoutside.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        checkoutside.setText("RETURN FROM OUTSIDE");
        checkoutside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutsideActionPerformed(evt);
            }
        });
        jPanel2.add(checkoutside);
        checkoutside.setBounds(220, 40, 210, 24);

        checkinside.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        checkinside.setText("RETURN FROM INSIDE");
        checkinside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinsideActionPerformed(evt);
            }
        });
        jPanel2.add(checkinside);
        checkinside.setBounds(40, 40, 180, 24);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(980, 230, 440, 390);

        labelstatus.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelstatus.setText("Status:");
        getContentPane().add(labelstatus);
        labelstatus.setBounds(580, 540, 300, 30);

        status.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        status.setText("----------");
        getContentPane().add(status);
        status.setBounds(880, 540, 80, 30);

        labeltime.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labeltime.setText("Time:");
        getContentPane().add(labeltime);
        labeltime.setBounds(1420, 20, 70, 30);

        redate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        redate.setText("Date:");
        getContentPane().add(redate);
        redate.setBounds(1230, 20, 100, 30);

        jLabel25.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        jLabel25.setText("NEWSPAPER");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(40, 25, 220, 40);

        setSize(new java.awt.Dimension(1609, 888));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Return_newspaperHeadingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Return_newspaperHeadingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Return_newspaperHeadingActionPerformed

    private void txt_Return_newspaperAccNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Return_newspaperAccNoKeyReleased
        txtbarcode.setEnabled(true);
    }//GEN-LAST:event_txt_Return_newspaperAccNoKeyReleased

    private void txtbarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbarcodeActionPerformed
       
    }//GEN-LAST:event_txtbarcodeActionPerformed

    private void txt_Return_newspaperRCBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Return_newspaperRCBarcodeActionPerformed


    }//GEN-LAST:event_txt_Return_newspaperRCBarcodeActionPerformed

    private void txt_Return_newspaperRCBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Return_newspaperRCBarcodeKeyReleased
        try {
            ResultSet rs = null;

            String tempbarcode = txt_Return_newspaperRCBarcode.getText();

            String query = "SELECT * FROM `tbl_clientregistration` WHERE ClientBarcode= " + tempbarcode;
            st = con.dbconn().prepareStatement(query);
            rs = st.executeQuery(query);

            try {
                if (rs.next()) {
                    //to display the data inside the txtfields
                    String barcode = rs.getString("ClientBarcode");
                    txt_Return_newspaperRCBarcode.setText(barcode);

                    String name = rs.getString("Name");
                    txt_Return_newspaperBorrowerName.setText(name);

                    String gender = rs.getString("Gender");
                    txt_Return_newspaperBorrowerGender.setText(gender);

                    String address = rs.getString("Address");
                    txt_Return_newspaperBorrowerAddress.setText(address);

                    String type = rs.getString("ClientType");
                    txt_Return_newspaperBorrowerType.setText(type);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            txt_Return_newspaperRCBarcode.getText();
            txt_Return_newspaperBorrowerName.getText();

            txt_Return_newspaperBorrowerGender.getText();
            txt_Return_newspaperBorrowerAddress.getText();
            txt_Return_newspaperBorrowerType.getText();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txt_Return_newspaperRCBarcodeKeyReleased

    private void checkinsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinsideActionPerformed
        txt_Return_newspaperRCBarcode.setEnabled(true);
        labelstatus.setText(txtbarcode.getText() + " with accession number " + txt_Return_newspaperAccNo.getText() + " is now: ");
        status.setText("available");

        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_Return_newspaperAccNo.getText() + "','" + txtbarcode.getText() + "','" + status.getText() + "')";
        executesqlQuery(quer, "Monitored");
    }//GEN-LAST:event_checkinsideActionPerformed

    private void checkoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutsideActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //  dbConn con = new dbConn();
        String query = "SELECT date_to_return FROM `tbl_borrowoutside` where ISBNBarcode = " + txtbarcode.getText();

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

            String tempbarcode = txtbarcode.getText();
            String querys = "SELECT * FROM `tbl_borrowoutside` WHERE ISBNBarcode= " + tempbarcode;

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.prepareStatement(querys);
            rs = st.executeQuery(querys);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_checkoutsideActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txt_Return_newspaperRCBarcode.getText();
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
                        if (txtbarcode.getText().trim().isEmpty() || txt_Return_newspaperRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {
                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txt_Return_newspaperAccNo.getText() + "','" + txtbarcode.getText() + "','" + txt_Return_newspaperRCBarcode.getText() + "','" + checkinside.getText() + "')";
                            executesqlQuery(queries, "Added");

                            try {
                                String queri = "UPDATE `tbl_librarynewspaper` SET  `NoOfCopies` ='" + copy.getText() + "' WHERE  `ISBNBarcode` =" + txtbarcode.getText();
                                executesqlQuery(queri, "updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {

                                String q = "INSERT INTO `tbl_returninside` VALUES ('" + Global_Variable.inrebookId + "','" + getBorrowid() + "','" + labeltime.getText() + "','" + redate.getText() + "')";
                                executesqlQuery(q, "Return");

                                txtbarcode.setText("");
                                txt_Return_newspaperAccNo.setText("");
                                txt_Return_newspaperHeading.setText("");
                                txt_Return_newspaperVolume.setText("");
                                txt_Return_newspaperRCBarcode.setText("");
                                txt_Return_newspaperBorrowerName.setText("");
                                txt_Return_newspaperBorrowerGender.setText("");
                                txt_Return_newspaperBorrowerAddress.setText("");
                                txt_Return_newspaperBorrowerType.setText(" ");

                                txtbarcode.setEnabled(false);
                                txt_Return_newspaperRCBarcode.setEnabled(false);

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
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txt_Return_newspaperRCBarcode.getText();
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
                        if (txtbarcode.getText().trim().isEmpty() || txt_Return_newspaperRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {
                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txt_Return_newspaperAccNo.getText() + "','" + txtbarcode.getText() + "','" + txt_Return_newspaperRCBarcode.getText() + "','" + checkinside.getText() + "')";
                            executesqlQuery(queries, "Added");

                            try {
                                String queri = "UPDATE `tbl_librarynewspaper` SET  `NoOfCopies` ='" + copy.getText() + "' WHERE  `ISBNBarcode` =" + txtbarcode.getText();
                                executesqlQuery(queri, "updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {
                                String q = "INSERT INTO `tbl_returnoutside` VALUES ('" + Global_Variable.inrebookId + "','" + getBorrowid() + "','" + labeltime.getText() + "','" + redate.getText() + "')";
                                executesqlQuery(q, "Return");

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                String qa = "INSERT INTO `tbl_penalty`(`id`, `accession`, `barcode`, `rcbarcode`, `name`, `datereturn`) VALUES ('" + Global_Variable.penalty + "','" + txt_Return_newspaperAccNo.getText() + "','" + txtbarcode.getText() + "','" + txt_Return_newspaperRCBarcode.getText() + "','" + txt_Return_newspaperBorrowerName.getText() + "','" + redate.getText() + "')";
                                executesqlQuery(qa, "Penalty");
                                txtbarcode.setText("");
                                txt_Return_newspaperAccNo.setText("");
                                txt_Return_newspaperHeading.setText("");
                                txt_Return_newspaperVolume.setText("");
                                txt_Return_newspaperRCBarcode.setText("");
                                txt_Return_newspaperBorrowerName.setText("");
                                txt_Return_newspaperBorrowerGender.setText("");
                                txt_Return_newspaperBorrowerAddress.setText("");
                                txt_Return_newspaperBorrowerType.setText(" ");
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

    private void txt_Return_newspaperAccNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Return_newspaperAccNoActionPerformed
         try {
                ResultSet rs = null;

                String tempbarcode = txt_Return_newspaperAccNo.getText();

                String query = "SELECT * FROM `tbl_newsaccession` WHERE accession = '"+tempbarcode+"'";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM d");

                st = con.dbconn().prepareStatement(query);
                rs = st.executeQuery(query);

                try {
                    if (rs.next()) {
                        //to display the data inside the txtfields
                        String barcode = rs.getString("ISBNBarcode");
                        txtbarcode.setText(barcode);

                        String heading = rs.getString("title");
                        txt_Return_newspaperHeading.setText(heading);

                        String volume = rs.getString("volume");
                        txt_Return_newspaperVolume.setText(volume);

                        String copii = rs.getString("copies");
                        copy.setText(copii);

                        String a = copy.getText();
                        int access = Integer.valueOf(a);
                        a = Integer.toString(++access);
                        copii = a;
                        copy.setText(copii);

                      
                        int choice;
                        choice = JOptionPane.showConfirmDialog(null, "Return from outside?");

                        if (choice == JOptionPane.YES_OPTION) {
                            txt_Return_newspaperRCBarcode.setEnabled(true);
                            labelstatus.setText(txtbarcode.getText() + " with accession number " + txt_Return_newspaperAccNo.getText() + " is now: ");
                            status.setText("available");

                            String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_Return_newspaperAccNo.getText() + "','" + txtbarcode.getText() + "','" + status.getText() + "')";
                            executesqlQuery(quer, "Monitored");
                        } else if (choice == JOptionPane.NO_OPTION) {
                            txt_Return_newspaperRCBarcode.setEnabled(true);
                            labelstatus.setText(txtbarcode.getText() + " with accession number " + txt_Return_newspaperAccNo.getText() + " is now: ");
                            status.setText("available");

                            String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_Return_newspaperAccNo.getText() + "','" + txtbarcode.getText() + "','" + status.getText() + "')";
                            executesqlQuery(quer, "Monitored");
                        } else if (choice == JOptionPane.CANCEL_OPTION) {
                            this.setVisible(true);
                        }

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                txtbarcode.getText();
                txt_Return_newspaperAccNo.getText();
                txt_Return_newspaperHeading.getText();
                txt_Return_newspaperVolume.getText();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_txt_Return_newspaperAccNoActionPerformed

    private boolean validateBarcode(String Barcode) {
        boolean queue = false;
        ResultSet rs;
        String query;
        try {
            query = "select * from `tbl_librarynewspaper` where ISBNBarcode='" + Barcode + "'";
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

            txtbarcode.setText("");
            txt_Return_newspaperAccNo.setText("");
            txt_Return_newspaperHeading.setText("");
            txt_Return_newspaperVolume.setText("");
            txt_Return_newspaperRCBarcode.setText("");
            txt_Return_newspaperBorrowerName.setText("");
            txt_Return_newspaperBorrowerGender.setText("");
            txt_Return_newspaperBorrowerAddress.setText("");
            txt_Return_newspaperBorrowerType.setText(" ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnoutside;
    private javax.swing.JButton btnsave;
    private javax.swing.JCheckBox checkinside;
    private javax.swing.JCheckBox checkoutside;
    private javax.swing.JTextField copy;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelstatus;
    private javax.swing.JLabel labeltime;
    private javax.swing.JLabel redate;
    private javax.swing.JLabel status;
    private javax.swing.JTextField txt_Return_newspaperAccNo;
    private javax.swing.JTextField txt_Return_newspaperBorrowerAddress;
    private javax.swing.JTextField txt_Return_newspaperBorrowerGender;
    private javax.swing.JTextField txt_Return_newspaperBorrowerName;
    private javax.swing.JTextField txt_Return_newspaperBorrowerType;
    private javax.swing.JTextField txt_Return_newspaperHeading;
    private javax.swing.JTextField txt_Return_newspaperRCBarcode;
    private javax.swing.JTextField txt_Return_newspaperVolume;
    private javax.swing.JTextField txtbarcode;
    // End of variables declaration//GEN-END:variables
     private String getBorrowid() {
        Statement st;
        String id = "";
        ResultSet rs;
        String query;
        try {
            query = "SELECT `id` FROM `tbl_borrowinside` WHERE `accession_number` ='" + txt_Return_newspaperAccNo.getText() + "'";
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
