package Borrowing;

import Classes.C_LibraryMaterialNewspaper;
import Global_Variable.Global_Variable;
import Module.dbConn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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

public class NEWSPAPERBORROWS extends javax.swing.JFrame {

    dbConn con = new dbConn();

    Statement st;

    public NEWSPAPERBORROWS() {
        initComponents();
        showNewspaperDate();
        showNewspaperTime();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        txt_Borrow_newspaperAccNo.setEnabled(true);
        txtborrowBarcode.setEnabled(false);
        txt_Borrow_newspaperRCBarcode.setEnabled(false);
        txt_Borrow_newspaperBorrowerName.setEnabled(false);
        txt_Borrow_newspaperBorrowerGender.setEnabled(false);
        txt_Borrow_newspaperBorrowerAddress.setEnabled(false);
        txt_Borrow_newspaperBorrowerType.setEnabled(false);
        copys.setEnabled(false);

        txt_Borrow_newspaperHeading.setEnabled(false);
        txt_Borrow_newspaperVolume.setEnabled(false);
    }

    void showNewspaperDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
        labelDate.setText(s.format(d));
    }

    void showNewspaperTime() {
        new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm");
                labelTime.setText(s.format(d));
            }

        }).start();
    }

    public ArrayList<C_LibraryMaterialNewspaper> getnewspaperList() {
        ArrayList<C_LibraryMaterialNewspaper> papernews = new ArrayList<C_LibraryMaterialNewspaper>();

        String query = "select * from `tbl_librarynewspaper` where ISBNBarcode=" + Global_Variable.NewspaperId;
        ResultSet rs;

        try {
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);

            C_LibraryMaterialNewspaper newspaper;
            while (rs.next()) {
                newspaper = new C_LibraryMaterialNewspaper(rs.getInt("id"), rs.getString("ISBNBarcode"), rs.getString("NType"), rs.getString("NHeading"), rs.getInt("NVolume"), rs.getString("NDateReceive"));
                papernews.add(newspaper);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return papernews;
    }

    public void executeSqLQuery(String query, String message) {
        try {
            st = null;
            st = con.dbconn().createStatement();
            if ((st.executeUpdate(query)) == 1) {
                JOptionPane.showMessageDialog(null, "Data" + message + "successfully");

            } else {
                JOptionPane.showMessageDialog(null, "Data" + message + "successfully");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        copys = new javax.swing.JTextField();
        txt_Borrow_newspaperVolume = new javax.swing.JTextField();
        txt_Borrow_newspaperHeading = new javax.swing.JTextField();
        txtborrowBarcode = new javax.swing.JTextField();
        txt_Borrow_newspaperAccNo = new javax.swing.JTextField();
        newspaper = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txt_Borrow_newspaperRCBarcode = new javax.swing.JTextField();
        txt_Borrow_newspaperBorrowerName = new javax.swing.JTextField();
        txt_Borrow_newspaperBorrowerGender = new javax.swing.JTextField();
        txt_Borrow_newspaperBorrowerAddress = new javax.swing.JTextField();
        txt_Borrow_newspaperBorrowerType = new javax.swing.JTextField();
        datereq = new com.toedter.calendar.JDateChooser();
        btnSave = new javax.swing.JButton();
        btnoutside = new javax.swing.JButton();
        borrowoutside = new javax.swing.JCheckBox();
        borrowinside = new javax.swing.JCheckBox();
        labelDate = new javax.swing.JLabel();
        labelTime = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel21.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel21.setText("Accession Number: ");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(30, 20, 140, 30);

        jLabel18.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel18.setText("ISBN Barcode:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(60, 70, 90, 30);

        jLabel19.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel19.setText("Heading:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(90, 120, 70, 30);

        jLabel22.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel22.setText("Volume:");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(100, 190, 60, 15);

        jLabel20.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel20.setText("No of Copies:");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(60, 230, 90, 30);

        copys.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        copys.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(copys);
        copys.setBounds(170, 230, 80, 30);

        txt_Borrow_newspaperVolume.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_newspaperVolume.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_Borrow_newspaperVolume);
        txt_Borrow_newspaperVolume.setBounds(170, 180, 100, 30);

        txt_Borrow_newspaperHeading.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_newspaperHeading.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Borrow_newspaperHeading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Borrow_newspaperHeadingActionPerformed(evt);
            }
        });
        jPanel2.add(txt_Borrow_newspaperHeading);
        txt_Borrow_newspaperHeading.setBounds(170, 120, 210, 30);

        txtborrowBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtborrowBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtborrowBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtborrowBarcodeActionPerformed(evt);
            }
        });
        txtborrowBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtborrowBarcodeKeyReleased(evt);
            }
        });
        jPanel2.add(txtborrowBarcode);
        txtborrowBarcode.setBounds(170, 70, 210, 30);

        txt_Borrow_newspaperAccNo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_newspaperAccNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Borrow_newspaperAccNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Borrow_newspaperAccNoActionPerformed(evt);
            }
        });
        txt_Borrow_newspaperAccNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Borrow_newspaperAccNoKeyReleased(evt);
            }
        });
        jPanel2.add(txt_Borrow_newspaperAccNo);
        txt_Borrow_newspaperAccNo.setBounds(170, 20, 210, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(470, 230, 430, 290);

        newspaper.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        newspaper.setText("NEWSPAPER");
        jPanel1.add(newspaper);
        newspaper.setBounds(20, 10, 200, 40);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel23.setText("Reader's Card Barcode:");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(10, 130, 150, 20);

        jLabel24.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel24.setText("Name:");
        jPanel3.add(jLabel24);
        jLabel24.setBounds(120, 170, 50, 14);

        jLabel26.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel26.setText("Gender:");
        jPanel3.add(jLabel26);
        jLabel26.setBounds(110, 200, 60, 30);

        jLabel27.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel27.setText("Address:");
        jPanel3.add(jLabel27);
        jLabel27.setBounds(100, 250, 60, 14);

        jLabel29.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel29.setText("Borrowe Type:");
        jPanel3.add(jLabel29);
        jLabel29.setBounds(70, 280, 100, 30);

        jLabel28.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel28.setText("Date Return:");
        jPanel3.add(jLabel28);
        jLabel28.setBounds(80, 330, 100, 30);

        txt_Borrow_newspaperRCBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_newspaperRCBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Borrow_newspaperRCBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Borrow_newspaperRCBarcodeActionPerformed(evt);
            }
        });
        txt_Borrow_newspaperRCBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Borrow_newspaperRCBarcodeKeyReleased(evt);
            }
        });
        jPanel3.add(txt_Borrow_newspaperRCBarcode);
        txt_Borrow_newspaperRCBarcode.setBounds(180, 120, 220, 30);

        txt_Borrow_newspaperBorrowerName.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_newspaperBorrowerName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txt_Borrow_newspaperBorrowerName);
        txt_Borrow_newspaperBorrowerName.setBounds(180, 160, 220, 30);

        txt_Borrow_newspaperBorrowerGender.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_newspaperBorrowerGender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txt_Borrow_newspaperBorrowerGender);
        txt_Borrow_newspaperBorrowerGender.setBounds(180, 200, 130, 30);

        txt_Borrow_newspaperBorrowerAddress.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_newspaperBorrowerAddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txt_Borrow_newspaperBorrowerAddress);
        txt_Borrow_newspaperBorrowerAddress.setBounds(180, 240, 220, 30);

        txt_Borrow_newspaperBorrowerType.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_newspaperBorrowerType.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txt_Borrow_newspaperBorrowerType);
        txt_Borrow_newspaperBorrowerType.setBounds(180, 280, 220, 30);

        datereq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        datereq.setDateFormatString("MM-dd-yyyy");
        datereq.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jPanel3.add(datereq);
        datereq.setBounds(180, 330, 220, 30);

        btnSave.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
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
        btnSave.setBounds(70, 50, 110, 30);

        btnoutside.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnoutside.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        btnoutside.setText("SAVE");
        btnoutside.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnoutside.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnoutside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoutsideActionPerformed(evt);
            }
        });
        jPanel3.add(btnoutside);
        btnoutside.setBounds(280, 50, 100, 30);

        borrowoutside.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        borrowoutside.setText("BORROW OUTSIDE");
        borrowoutside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowoutsideActionPerformed(evt);
            }
        });
        jPanel3.add(borrowoutside);
        borrowoutside.setBounds(250, 20, 160, 29);

        borrowinside.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        borrowinside.setText("BORROW INSIDE");
        borrowinside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowinsideActionPerformed(evt);
            }
        });
        jPanel3.add(borrowinside);
        borrowinside.setBounds(50, 20, 170, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(1010, 220, 450, 380);

        labelDate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelDate.setText("Date:");
        jPanel1.add(labelDate);
        labelDate.setBounds(1300, 20, 120, 15);

        labelTime.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelTime.setText("Time:");
        jPanel1.add(labelTime);
        labelTime.setBounds(1480, 20, 80, 15);

        labelStatus.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelStatus.setText("Status:");
        jPanel1.add(labelStatus);
        labelStatus.setBounds(470, 550, 300, 20);

        status.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        status.setText("-----------");
        jPanel1.add(status);
        status.setBounds(800, 550, 80, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1640, 830);

        setSize(new java.awt.Dimension(1658, 875));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void borrowinsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowinsideActionPerformed
        txt_Borrow_newspaperRCBarcode.setEnabled(true);
        datereq.setEnabled(false);

        labelStatus.setText(txtborrowBarcode.getText() + " with accession number " + txt_Borrow_newspaperAccNo.getText() + " is now: ");
        status.setText("borrowed");

        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_Borrow_newspaperAccNo.getText() + "','" + txtborrowBarcode.getText() + "','" + status.getText() + "')";
        executeSqLQuery(quer, "Monitored");
    }//GEN-LAST:event_borrowinsideActionPerformed

    private void borrowoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowoutsideActionPerformed
        txt_Borrow_newspaperRCBarcode.setEnabled(true);
        datereq.setEnabled(true);
        labelStatus.setText(txtborrowBarcode.getText() + " with accession number " + txt_Borrow_newspaperAccNo.getText() + " is now: ");
        status.setText("borrowed");

        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_Borrow_newspaperAccNo.getText() + "','" + txtborrowBarcode.getText() + "','" + status.getText() + "')";
        executeSqLQuery(quer, "Monitored");

    }//GEN-LAST:event_borrowoutsideActionPerformed

    private void txt_Borrow_newspaperHeadingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Borrow_newspaperHeadingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Borrow_newspaperHeadingActionPerformed

    private void txtborrowBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtborrowBarcodeActionPerformed
        txtborrowBarcode.setEnabled(true);
       
            try {

                try {
                    ResultSet rs = null;
                    String tempbarcode = txtborrowBarcode.getText();

                    String query = "SELECT * FROM `tbl_librarynewspaper` WHERE ISBNBarcode= '"+tempbarcode+"'";

                    st = con.dbconn().prepareStatement(query);
                    rs = st.executeQuery(query);

                    try {
                        if (rs.next()) {
                            //to display the data inside the txtfields
                            String barcode = rs.getString("ISBNBarcode");
                            txtborrowBarcode.setText(barcode);

                            String heading = rs.getString("NHeading");
                            txt_Borrow_newspaperHeading.setText(heading);

                            String volume = rs.getString("NVolume");
                            txt_Borrow_newspaperVolume.setText(volume);

                            String copies = rs.getString("NoofCopies");
                            copys.setText(copies);

                            String a = copys.getText();
                            int accesss = Integer.valueOf(a);

                            if (accesss == 0) {
                                JOptionPane.showMessageDialog(null, "Oppss.. The newspaper copies are already borrowed");
                                txt_Borrow_newspaperAccNo.setText("");
                                txtborrowBarcode.setText("");
                                txt_Borrow_newspaperHeading.setText("");
                                txt_Borrow_newspaperVolume.setText("");
                                txt_Borrow_newspaperRCBarcode.setText("");
                                txt_Borrow_newspaperBorrowerName.setText("");
                                txt_Borrow_newspaperBorrowerGender.setText("");
                                txt_Borrow_newspaperBorrowerAddress.setText("");
                                txt_Borrow_newspaperBorrowerType.setText(" ");

                            } else {
                                a = Integer.toString(--accesss);
                                copies = a;
                                copys.setText(copies);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    txtborrowBarcode.getText();
                    txt_Borrow_newspaperAccNo.getText();
                    txt_Borrow_newspaperHeading.getText();
                    txt_Borrow_newspaperVolume.getText();
                    copys.getText();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
       
    }//GEN-LAST:event_txtborrowBarcodeActionPerformed

    private void txt_Borrow_newspaperAccNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Borrow_newspaperAccNoKeyReleased
         txtborrowBarcode.setEnabled(false);
        String accession = txt_Borrow_newspaperAccNo.getText();
        try {
            String query = "SELECT * FROM `tbl_newsaccession` WHERE accession='"+accession+"'";
            ResultSet rs;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                    String access = rs.getString("accession");
                    txt_Borrow_newspaperAccNo.setText(access);
                    
                     String bar = rs.getString("ISBNBarcode");
                    txtborrowBarcode.setText(bar);
                    
                     String head = rs.getString("title");
                    txt_Borrow_newspaperHeading.setText(head);
                    
                     String vol = rs.getString("volume");
                    txt_Borrow_newspaperVolume.setText(vol);
                    
                     String cop = rs.getString("copies");
                    copys.setText(cop);
                     String copies = rs.getString("copies");
                            copys.setText(copies);
                     String a = copys.getText();
                            int accesss = Integer.valueOf(a);

                            if (accesss == 0) {
                                JOptionPane.showMessageDialog(null, "Oppss.. The newspaper copies are already borrowed");
                                txt_Borrow_newspaperAccNo.setText("");
                                txtborrowBarcode.setText("");
                                txt_Borrow_newspaperHeading.setText("");
                                txt_Borrow_newspaperVolume.setText("");
                                txt_Borrow_newspaperRCBarcode.setText("");
                                txt_Borrow_newspaperBorrowerName.setText("");
                                txt_Borrow_newspaperBorrowerGender.setText("");
                                txt_Borrow_newspaperBorrowerAddress.setText("");
                                txt_Borrow_newspaperBorrowerType.setText(" ");

                            } else {
                                a = Integer.toString(--accesss);
                                copies = a;
                                copys.setText(copies);
                            }
                }
            } catch (Exception e) {

            }
            txt_Borrow_newspaperAccNo.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txt_Borrow_newspaperAccNoKeyReleased

    private void txt_Borrow_newspaperRCBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Borrow_newspaperRCBarcodeActionPerformed
        datereq.setEnabled(true);
        Date d = new Date();
        SimpleDateFormat dds = new SimpleDateFormat("MM-dd-yyyy");
        String barcode = "", name = "", gender = "", address = "", type = "", dateregis = "", dateexpire = "";
        dateregis = dds.format(d);
        dateexpire = dds.format(d);
        long a = 0;
        SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");

        if (validateRCBarcode(txt_Borrow_newspaperRCBarcode.getText())) {
            try {
                Connection cn = null;
                Statement st = null;
                ResultSet rs = null;

                String tempbarcode = txt_Borrow_newspaperRCBarcode.getText();

                String query = "SELECT * FROM `tbl_clientregistration` WHERE ClientBarcode= " + tempbarcode;

                st = con.dbconn().prepareStatement(query);
                rs = st.executeQuery(query);

                try {
                    if (rs.next()) {
                        //to display the data inside the txtfields
                        barcode = rs.getString("ClientBarcode");
                        txt_Borrow_newspaperRCBarcode.setText(barcode);

                        name = rs.getString("Name");
                        txt_Borrow_newspaperBorrowerName.setText(name);

                        gender = rs.getString("Gender");
                        txt_Borrow_newspaperBorrowerGender.setText(gender);

                        address = rs.getString("Address");
                        txt_Borrow_newspaperBorrowerAddress.setText(address);
                        type = rs.getString("ClientType");
                        txt_Borrow_newspaperBorrowerType.setText(type);
                    }

                } catch (Exception ex) {
                    if (a > 0) {
                        txt_Borrow_newspaperRCBarcode.setText(barcode);
                        txt_Borrow_newspaperBorrowerName.setText(name);
                        txt_Borrow_newspaperBorrowerGender.setText(gender);
                        txt_Borrow_newspaperBorrowerAddress.setText(address);
                        txt_Borrow_newspaperBorrowerType.setText(type);

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
            txt_Borrow_newspaperRCBarcode.setText("");
            JOptionPane.showMessageDialog(null, "Readers Card Barcode doesn't exist");
        }
    }//GEN-LAST:event_txt_Borrow_newspaperRCBarcodeActionPerformed

    private void txt_Borrow_newspaperRCBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Borrow_newspaperRCBarcodeKeyReleased
        datereq.setEnabled(true);
        Date d = new Date();
        SimpleDateFormat dds = new SimpleDateFormat("MM-dd-yyyy");
        String barcode = "", name = "", gender = "", address = "", type = "", dateregis = "", dateexpire = "";
        dateregis = dds.format(d);
        dateexpire = dds.format(d);
        long a = 0;
        SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");

        if (validateRCBarcode(txt_Borrow_newspaperRCBarcode.getText())) {
            try {
                Connection cn = null;
                Statement st = null;
                ResultSet rs = null;

                String tempbarcode = txt_Borrow_newspaperRCBarcode.getText();

                String query = "SELECT * FROM `tbl_clientregistration` WHERE ClientBarcode= " + tempbarcode;

                st = con.dbconn().prepareStatement(query);
                rs = st.executeQuery(query);

                try {
                    if (rs.next()) {
                        //to display the data inside the txtfields
                        barcode = rs.getString("ClientBarcode");
                        txt_Borrow_newspaperRCBarcode.setText(barcode);

                        name = rs.getString("Name");
                        txt_Borrow_newspaperBorrowerName.setText(name);

                        gender = rs.getString("Gender");
                        txt_Borrow_newspaperBorrowerGender.setText(gender);

                        address = rs.getString("Address");
                        txt_Borrow_newspaperBorrowerAddress.setText(address);
                        type = rs.getString("ClientType");
                        txt_Borrow_newspaperBorrowerType.setText(type);
                    }

                } catch (Exception ex) {
                    if (a > 0) {
                        txt_Borrow_newspaperRCBarcode.setText(barcode);
                        txt_Borrow_newspaperBorrowerName.setText(name);
                        txt_Borrow_newspaperBorrowerGender.setText(gender);
                        txt_Borrow_newspaperBorrowerAddress.setText(address);
                        txt_Borrow_newspaperBorrowerType.setText(type);

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
            txt_Borrow_newspaperRCBarcode.setText("");
            JOptionPane.showMessageDialog(null, "Readers Card Barcode doesn't exist");
        }
    }//GEN-LAST:event_txt_Borrow_newspaperRCBarcodeKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txt_Borrow_newspaperRCBarcode.getText();
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
                        if (txt_Borrow_newspaperAccNo.getText().trim().isEmpty() || txt_Borrow_newspaperRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {
                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txt_Borrow_newspaperAccNo.getText() + "','" + txtborrowBarcode.getText() + "','" + txt_Borrow_newspaperRCBarcode.getText() + "','" + borrowinside.getText() + "')";
                            executeSqLQuery(queries, "Transaction Added");

                            try {
                                String queri = "UPDATE `tbl_librarynewspaper` SET  `NoOfCopies` ='" + copys.getText() + "' WHERE  `ISBNBarcode` =" + txtborrowBarcode.getText();
                                executeSqLQuery(queri, "No. of Copies Updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {

                                String querys = "INSERT INTO `tbl_borrowinside` VALUES ('" + Global_Variable.innewspaperId + "','" + newspaper.getText() + "','" + txt_Borrow_newspaperAccNo.getText() + "','" + txtborrowBarcode.getText() + "','" + copys.getText() + "','" + txt_Borrow_newspaperRCBarcode.getText() + "','" + labelDate.getText() + "','" + labelTime.getText() + "')";
                                executeSqLQuery(querys, "Newspaper Borrowed");
                                txt_Borrow_newspaperAccNo.setText("");
                                txtborrowBarcode.setText("");
                                txt_Borrow_newspaperHeading.setText("");
                                txt_Borrow_newspaperVolume.setText("");
                                txt_Borrow_newspaperRCBarcode.setText("");
                                txt_Borrow_newspaperBorrowerName.setText("");
                                txt_Borrow_newspaperBorrowerGender.setText("");
                                txt_Borrow_newspaperBorrowerAddress.setText("");
                                txt_Borrow_newspaperBorrowerType.setText(" ");

                                txt_Borrow_newspaperRCBarcode.setEnabled(false);
                                txtborrowBarcode.setEnabled(false);

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

    private void btnoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoutsideActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txt_Borrow_newspaperRCBarcode.getText();
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
                        if (txt_Borrow_newspaperAccNo.getText().trim().isEmpty() || txt_Borrow_newspaperRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {
                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txt_Borrow_newspaperAccNo.getText() + "','" + txtborrowBarcode.getText() + "','" + txt_Borrow_newspaperRCBarcode.getText() + "','" + borrowoutside.getText() + "')";
                            executeSqLQuery(queries, "Transaction Added");

                            try {
                                String queri = "UPDATE `tbl_librarynewspaper` SET  `NoOfCopies` ='" + copys.getText() + "' WHERE  `ISBNBarcode` =" + txtborrowBarcode.getText();
                                executeSqLQuery(queri, "No of copies updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {

                                //    SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
                                String dating = s.format(datereq.getDate());

                                String querys = "INSERT INTO `tbl_borrowoutside` VALUES ('" + Global_Variable.outrenewspaperId + "','" + newspaper.getText() + "','" + txt_Borrow_newspaperAccNo.getText() + "','" + txtborrowBarcode.getText() + "','" + txt_Borrow_newspaperRCBarcode.getText() + "','" + dating + "','" + labelDate.getText() + "','" + labelTime.getText() + "')";
                                executeSqLQuery(querys, "Newspaper Borrowed");
                                txtborrowBarcode.setText("");
                                txt_Borrow_newspaperAccNo.setText("");
                                txt_Borrow_newspaperHeading.setText("");
                                txt_Borrow_newspaperVolume.setText("");
                                txt_Borrow_newspaperRCBarcode.setText("");
                                txt_Borrow_newspaperBorrowerName.setText("");
                                txt_Borrow_newspaperBorrowerGender.setText("");
                                txt_Borrow_newspaperBorrowerAddress.setText("");
                                txt_Borrow_newspaperBorrowerType.setText(" ");

                                txt_Borrow_newspaperRCBarcode.setEnabled(false);
                                txtborrowBarcode.setEnabled(false);

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


    }//GEN-LAST:event_btnoutsideActionPerformed

    private void txtborrowBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtborrowBarcodeKeyReleased
        availablity();
        status();
        copys.setEnabled(false);

        txt_Borrow_newspaperHeading.setEnabled(false);
        txt_Borrow_newspaperVolume.setEnabled(false);
    }//GEN-LAST:event_txtborrowBarcodeKeyReleased

    private void txt_Borrow_newspaperAccNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Borrow_newspaperAccNoActionPerformed
        txtborrowBarcode.setEnabled(false);
        String accession = txt_Borrow_newspaperAccNo.getText();
        try {
            String query = "SELECT * FROM `tbl_newsaccession` WHERE accession='"+accession+"'";
            ResultSet rs;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                    String access = rs.getString("accession");
                    txt_Borrow_newspaperAccNo.setText(access);
                    
                     String bar = rs.getString("ISBNBarcode");
                    txtborrowBarcode.setText(bar);
                    
                     String head = rs.getString("title");
                    txt_Borrow_newspaperHeading.setText(head);
                    
                     String vol = rs.getString("volume");
                    txt_Borrow_newspaperVolume.setText(vol);
                    
                     String cop = rs.getString("copies");
                    copys.setText(cop);
                     String copies = rs.getString("copies");
                            copys.setText(copies);
                     String a = copys.getText();
                            int accesss = Integer.valueOf(a);

                            if (accesss == 0) {
                                JOptionPane.showMessageDialog(null, "Oppss.. The newspaper copies are already borrowed");
                                txt_Borrow_newspaperAccNo.setText("");
                                txtborrowBarcode.setText("");
                                txt_Borrow_newspaperHeading.setText("");
                                txt_Borrow_newspaperVolume.setText("");
                                txt_Borrow_newspaperRCBarcode.setText("");
                                txt_Borrow_newspaperBorrowerName.setText("");
                                txt_Borrow_newspaperBorrowerGender.setText("");
                                txt_Borrow_newspaperBorrowerAddress.setText("");
                                txt_Borrow_newspaperBorrowerType.setText(" ");

                            } else {
                                a = Integer.toString(--accesss);
                                copies = a;
                                copys.setText(copies);
                            }
                }
            } catch (Exception e) {

            }
            txt_Borrow_newspaperAccNo.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txt_Borrow_newspaperAccNoActionPerformed
    private String validateType() {
        Statement st;
        String id = "";
        ResultSet rs;
        String query;
        try {
            query = "select id from `tbl_logintypeclient` where type='" + txt_Borrow_newspaperBorrowerType.getText() + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("id");
                txt_Borrow_newspaperBorrowerType.setText("type");
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
    private javax.swing.JButton btnoutside;
    private javax.swing.JTextField copys;
    private com.toedter.calendar.JDateChooser datereq;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelTime;
    private javax.swing.JLabel newspaper;
    private javax.swing.JLabel status;
    private javax.swing.JTextField txt_Borrow_newspaperAccNo;
    private javax.swing.JTextField txt_Borrow_newspaperBorrowerAddress;
    private javax.swing.JTextField txt_Borrow_newspaperBorrowerGender;
    private javax.swing.JTextField txt_Borrow_newspaperBorrowerName;
    private javax.swing.JTextField txt_Borrow_newspaperBorrowerType;
    private javax.swing.JTextField txt_Borrow_newspaperHeading;
    private javax.swing.JTextField txt_Borrow_newspaperRCBarcode;
    private javax.swing.JTextField txt_Borrow_newspaperVolume;
    private javax.swing.JTextField txtborrowBarcode;
    // End of variables declaration//GEN-END:variables
     //to validate if barcode doen't exist 

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

    private String availablity() {
        String id = "";
        ResultSet rs;

        try {
            String query = "select * from tbl_librarynewspaper where ISBNBarcode =" + txtborrowBarcode.getText();
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("Status");
                switch (id) {
                    case "Available":
                        txtborrowBarcode.setEditable(true);
                        break;
                    case "Damaged":
                        JOptionPane.showMessageDialog(null, "Opps.. this book is damaged and cannot be borrowed");
                        txt_Borrow_newspaperAccNo.setText("");
                        txtborrowBarcode.setText("");

                        break;
                    case "Lost":
                        JOptionPane.showMessageDialog(null, "Its lost!!!");
                        txt_Borrow_newspaperAccNo.setText("");
                        txtborrowBarcode.setText("");
                        break;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    private String status() {
        String available = "";
        ResultSet rs;
        try {
            String query = "select * from tbl_librarynewspaper where ISBNBarcode =" + txtborrowBarcode.getText();
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                available = rs.getString("Availability");
                switch (available) {
                    case "YES":
                        txtborrowBarcode.setEditable(true);
                        break;
                    case "NO":
                        JOptionPane.showMessageDialog(null, "Opps.. this book is cannot be borrowed");
                        txt_Borrow_newspaperAccNo.setText("");
                        txtborrowBarcode.setText("");

                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return available;
    }

}
