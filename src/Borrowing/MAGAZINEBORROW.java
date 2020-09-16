package Borrowing;

import Classes.C_LibraryMaterialMagazine;
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

public class MAGAZINEBORROW extends javax.swing.JFrame {

    dbConn con = new dbConn();

    Statement st;

    public MAGAZINEBORROW() {
        initComponents();
        showMagazineDate();
        showMagazineTime();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        txt_Borrow_magazineBarcode.setEnabled(false);
        txt_Borrow_magazineAccNo.setEnabled(true);
        txt_Borrow_magazineRCBarcode.setEnabled(false);
        txt_Borrow_magazineBorrowerName.setEnabled(false);
        txt_Borrow_magazineBorrowerGender.setEnabled(false);
        txt_Borrow_magazineBorrowerAddress.setEnabled(false);
        txt_Borrow_magazineBorrowerType.setEnabled(false);
        copyIES.setEnabled(false);

        txt_Borrow_magazineTitle.setEnabled(false);
        txt_Borrow_magazineedition.setEnabled(false);
        txt_Borrow_magazinePublisher.setEnabled(false);
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
                labelTime.setText(s.format(d));
            }

        }).start();
    }

    public ArrayList<C_LibraryMaterialMagazine> getMagazineList() {
        ArrayList<C_LibraryMaterialMagazine> Mags = new ArrayList<C_LibraryMaterialMagazine>();
        String query = "select * from `tbl_magazine` where category_id=" + Global_Variable.category_id;
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

    public void executeSqlQuery(String query, String message) {

        try {
            st = null;
            st = con.dbconn().createStatement();
            if ((st.executeUpdate(query)) == 1) {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        copyIES = new javax.swing.JTextField();
        txt_Borrow_magazinePublisher = new javax.swing.JTextField();
        txt_Borrow_magazineedition = new javax.swing.JTextField();
        txt_Borrow_magazineTitle = new javax.swing.JTextField();
        txt_Borrow_magazineBarcode = new javax.swing.JTextField();
        txt_Borrow_magazineAccNo = new javax.swing.JTextField();
        magazine = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        datereq = new com.toedter.calendar.JDateChooser();
        txt_Borrow_magazineBorrowerType = new javax.swing.JTextField();
        txt_Borrow_magazineBorrowerAddress = new javax.swing.JTextField();
        txt_Borrow_magazineBorrowerGender = new javax.swing.JTextField();
        txt_Borrow_magazineBorrowerName = new javax.swing.JTextField();
        txt_Borrow_magazineRCBarcode = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        borrowoutside = new javax.swing.JCheckBox();
        borrowinside = new javax.swing.JCheckBox();
        btnoutside = new javax.swing.JButton();
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
        jLabel21.setText("ISBN Barcode:");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(70, 60, 100, 30);

        jLabel22.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel22.setText("Accession Number: ");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(30, 20, 140, 30);

        jLabel31.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel31.setText("Magazine Title:");
        jPanel2.add(jLabel31);
        jLabel31.setBounds(60, 120, 100, 15);

        jLabel32.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel32.setText("Edition Number:");
        jPanel2.add(jLabel32);
        jLabel32.setBounds(50, 160, 120, 30);

        jLabel34.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel34.setText("Publisher:");
        jPanel2.add(jLabel34);
        jLabel34.setBounds(90, 220, 80, 15);

        jLabel33.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel33.setText("No of Copies Available:");
        jPanel2.add(jLabel33);
        jLabel33.setBounds(10, 260, 170, 30);

        copyIES.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        copyIES.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(copyIES);
        copyIES.setBounds(170, 260, 80, 30);

        txt_Borrow_magazinePublisher.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_magazinePublisher.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Borrow_magazinePublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Borrow_magazinePublisherActionPerformed(evt);
            }
        });
        jPanel2.add(txt_Borrow_magazinePublisher);
        txt_Borrow_magazinePublisher.setBounds(170, 210, 220, 30);

        txt_Borrow_magazineedition.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_magazineedition.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_Borrow_magazineedition);
        txt_Borrow_magazineedition.setBounds(170, 160, 100, 30);

        txt_Borrow_magazineTitle.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_magazineTitle.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Borrow_magazineTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Borrow_magazineTitleActionPerformed(evt);
            }
        });
        jPanel2.add(txt_Borrow_magazineTitle);
        txt_Borrow_magazineTitle.setBounds(170, 110, 220, 30);

        txt_Borrow_magazineBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_magazineBarcode.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Borrow_magazineBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Borrow_magazineBarcodeActionPerformed(evt);
            }
        });
        txt_Borrow_magazineBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Borrow_magazineBarcodeKeyReleased(evt);
            }
        });
        jPanel2.add(txt_Borrow_magazineBarcode);
        txt_Borrow_magazineBarcode.setBounds(170, 60, 220, 30);

        txt_Borrow_magazineAccNo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_magazineAccNo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Borrow_magazineAccNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Borrow_magazineAccNoActionPerformed(evt);
            }
        });
        txt_Borrow_magazineAccNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Borrow_magazineAccNoKeyReleased(evt);
            }
        });
        jPanel2.add(txt_Borrow_magazineAccNo);
        txt_Borrow_magazineAccNo.setBounds(170, 20, 220, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(510, 220, 450, 310);

        magazine.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        magazine.setText("MAGAZINE");
        jPanel1.add(magazine);
        magazine.setBounds(20, 10, 190, 40);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        jLabel35.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel35.setText("Reader's Card Barcode:");
        jPanel3.add(jLabel35);
        jLabel35.setBounds(10, 110, 170, 30);

        jLabel36.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel36.setText("Name:");
        jPanel3.add(jLabel36);
        jLabel36.setBounds(120, 160, 60, 30);

        jLabel38.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel38.setText("Gender:");
        jPanel3.add(jLabel38);
        jLabel38.setBounds(110, 210, 70, 30);

        jLabel39.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel39.setText("Address:");
        jPanel3.add(jLabel39);
        jLabel39.setBounds(100, 270, 90, 15);

        jLabel41.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel41.setText("Borrowe Type:");
        jPanel3.add(jLabel41);
        jLabel41.setBounds(70, 320, 110, 14);

        jLabel40.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel40.setText("Date Return:");
        jPanel3.add(jLabel40);
        jLabel40.setBounds(80, 370, 110, 20);

        datereq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        datereq.setDateFormatString("MM-dd-yyyy");
        datereq.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jPanel3.add(datereq);
        datereq.setBounds(180, 360, 210, 30);

        txt_Borrow_magazineBorrowerType.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_magazineBorrowerType.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txt_Borrow_magazineBorrowerType);
        txt_Borrow_magazineBorrowerType.setBounds(180, 310, 210, 30);

        txt_Borrow_magazineBorrowerAddress.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_magazineBorrowerAddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txt_Borrow_magazineBorrowerAddress);
        txt_Borrow_magazineBorrowerAddress.setBounds(180, 260, 210, 30);

        txt_Borrow_magazineBorrowerGender.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_magazineBorrowerGender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txt_Borrow_magazineBorrowerGender);
        txt_Borrow_magazineBorrowerGender.setBounds(180, 210, 140, 30);

        txt_Borrow_magazineBorrowerName.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_magazineBorrowerName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txt_Borrow_magazineBorrowerName);
        txt_Borrow_magazineBorrowerName.setBounds(180, 160, 200, 30);

        txt_Borrow_magazineRCBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Borrow_magazineRCBarcode.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Borrow_magazineRCBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Borrow_magazineRCBarcodeActionPerformed(evt);
            }
        });
        jPanel3.add(txt_Borrow_magazineRCBarcode);
        txt_Borrow_magazineRCBarcode.setBounds(180, 110, 200, 30);

        btnsave.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        btnsave.setText("SAVE");
        btnsave.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnsave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnsave);
        btnsave.setBounds(80, 50, 100, 30);

        borrowoutside.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        borrowoutside.setText("BORROW OUTSIDE");
        borrowoutside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowoutsideActionPerformed(evt);
            }
        });
        jPanel3.add(borrowoutside);
        borrowoutside.setBounds(260, 20, 161, 30);

        borrowinside.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        borrowinside.setText("BORRROW INSIDE");
        borrowinside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowinsideActionPerformed(evt);
            }
        });
        jPanel3.add(borrowinside);
        borrowinside.setBounds(50, 20, 159, 30);

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
        btnoutside.setBounds(300, 50, 90, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(1040, 220, 460, 410);

        labelDate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelDate.setText("Date:");
        jPanel1.add(labelDate);
        labelDate.setBounds(1190, 20, 120, 30);

        labelTime.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelTime.setText("Time:");
        jPanel1.add(labelTime);
        labelTime.setBounds(1400, 20, 80, 30);

        labelStatus.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelStatus.setText("Status:");
        jPanel1.add(labelStatus);
        labelStatus.setBounds(520, 560, 300, 20);

        status.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        status.setText("-----------");
        jPanel1.add(status);
        status.setBounds(830, 560, 70, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1580, 990);

        setSize(new java.awt.Dimension(1594, 1037));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Borrow_magazinePublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Borrow_magazinePublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Borrow_magazinePublisherActionPerformed

    private void txt_Borrow_magazineTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Borrow_magazineTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Borrow_magazineTitleActionPerformed

    private void txt_Borrow_magazineBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Borrow_magazineBarcodeActionPerformed


    }//GEN-LAST:event_txt_Borrow_magazineBarcodeActionPerformed

    private void txt_Borrow_magazineBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Borrow_magazineBarcodeKeyReleased
        availability();
        status();
        copyIES.setEnabled(true);

        txt_Borrow_magazineTitle.setEnabled(true);
        txt_Borrow_magazineedition.setEnabled(true);
        txt_Borrow_magazinePublisher.setEnabled(true);
    }//GEN-LAST:event_txt_Borrow_magazineBarcodeKeyReleased

    private void txt_Borrow_magazineAccNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Borrow_magazineAccNoKeyReleased

         try {

            try {
            ResultSet rs = null;

            String tempbarcode = txt_Borrow_magazineAccNo.getText();

            String query = "SELECT * FROM `tbl_magazineaccession` WHERE accession= '"+tempbarcode+"' and category_id='"+Global_Variable.category_id+"'" ;
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                //to display the data inside the txtfields
                String barcode = rs.getString("ISBNBarcode");
                txt_Borrow_magazineBarcode.setText(barcode);

                String title = rs.getString("Title");
                txt_Borrow_magazineTitle.setText(title);

                String author = rs.getString("EdNum");
                txt_Borrow_magazineedition.setText(author);

                String publisher = rs.getString("Publisher");
                txt_Borrow_magazinePublisher.setText(publisher); 
                
                String copies = rs.getString("Copies"); 
                copyIES.setText(copies);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            txt_Borrow_magazineBarcode.getText();
            txt_Borrow_magazineTitle.getText();
            txt_Borrow_magazineedition.getText();
            txt_Borrow_magazinePublisher.getText();

            } catch (Exception ex) {
                 ex.printStackTrace();
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
        
    }//GEN-LAST:event_txt_Borrow_magazineAccNoKeyReleased

    private void borrowinsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowinsideActionPerformed
        txt_Borrow_magazineRCBarcode.setEnabled(true);
        datereq.setEnabled(false);

        labelStatus.setText(txt_Borrow_magazineBarcode.getText() + " with accession number " + txt_Borrow_magazineAccNo.getText() + " is now: ");
        status.setText("borrowed");

        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_Borrow_magazineAccNo.getText() + "','" + txt_Borrow_magazineBarcode.getText() + "','" + status.getText() + "')";
        executeSqlQuery(quer, "Monitored");

    }//GEN-LAST:event_borrowinsideActionPerformed

    private void borrowoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowoutsideActionPerformed
        txt_Borrow_magazineRCBarcode.setEnabled(true);
        datereq.setEnabled(true);

        labelStatus.setText(txt_Borrow_magazineBarcode.getText() + " with accession number " + txt_Borrow_magazineAccNo.getText() + " is now: ");
        status.setText("borrowed");

        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_Borrow_magazineAccNo.getText() + "','" + txt_Borrow_magazineBarcode.getText() + "','" + status.getText() + "')";
        executeSqlQuery(quer, "Monitored");
    }//GEN-LAST:event_borrowoutsideActionPerformed

    private void txt_Borrow_magazineRCBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Borrow_magazineRCBarcodeActionPerformed
        datereq.setEnabled(true);
        Date d = new Date();
        SimpleDateFormat dds = new SimpleDateFormat("MM-dd-yyyy");
        String barcode = "", name = "", gender = "", address = "", type = "", dateregis = "", dateexpire = "";
        dateregis = dds.format(d);
        dateexpire = dds.format(d);
        long a = 0;
        SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");

        if (validateRCBarcode(txt_Borrow_magazineRCBarcode.getText())) {
            try {
                Connection cn = null;
                Statement st = null;
                ResultSet rs = null;

                String tempbarcode = txt_Borrow_magazineRCBarcode.getText();

                String query = "SELECT * FROM `tbl_clientregistration` WHERE ClientBarcode= " + tempbarcode;
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM d");

                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
                st = cn.prepareStatement(query);
                rs = st.executeQuery(query);

                try {
                    if (rs.next()) {
                        //to display the data inside the txtfields
                        barcode = rs.getString("ClientBarcode");
                        txt_Borrow_magazineRCBarcode.setText(barcode);

                        name = rs.getString("Name");
                        txt_Borrow_magazineBorrowerName.setText(name);

                        gender = rs.getString("Gender");
                        txt_Borrow_magazineBorrowerGender.setText(gender);

                        address = rs.getString("Address");
                        txt_Borrow_magazineBorrowerAddress.setText(address);

                        type = rs.getString("ClientType");
                        txt_Borrow_magazineBorrowerType.setText(type);

                        dateregis = rs.getString("DateIssued");
                        dateexpire = rs.getString("DateExpired");
                    }
                } catch (Exception ex) {
                    if (a > 0) {
                        txt_Borrow_magazineRCBarcode.setText(barcode);
                        txt_Borrow_magazineBorrowerName.setText(name);
                        txt_Borrow_magazineBorrowerGender.setText(gender);
                        txt_Borrow_magazineBorrowerAddress.setText(address);
                        txt_Borrow_magazineBorrowerType.setText(type);
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
            txt_Borrow_magazineRCBarcode.setText("");
            JOptionPane.showMessageDialog(null, "Readers Card Barcode doesn't exist");
        }
    }//GEN-LAST:event_txt_Borrow_magazineRCBarcodeActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txt_Borrow_magazineRCBarcode.getText();
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
                        if (txt_Borrow_magazineBarcode.getText().trim().isEmpty() || txt_Borrow_magazineRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {
                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txt_Borrow_magazineAccNo.getText() + "','" + txt_Borrow_magazineBarcode.getText() + "','" + txt_Borrow_magazineRCBarcode.getText() + "','" + borrowinside.getText() + "','"+Global_Variable.category_id+"')";
                            executeSqlQuery(queries, "Transaction Added");

                            try {
                                String queri = "UPDATE `tbl_magazine` SET  `NoofCopies` ='" + copyIES.getText() + "' WHERE  `ISBNBarcode` =" + txt_Borrow_magazineBarcode.getText();
                                executeSqlQuery(queri, "No of Copies Updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {

                                String querys = "INSERT INTO `tbl_borrowinside` VALUES ('" + Global_Variable.inmagazineId + "','" + magazine.getText() + "','" + txt_Borrow_magazineAccNo.getText() + "','" + txt_Borrow_magazineBarcode.getText() + "','" + copyIES.getText() + "','" + txt_Borrow_magazineRCBarcode.getText() + "','" + Global_Variable.category_id + "','" + labelDate.getText() + "','" + labelTime.getText() + "')";
                                executeSqlQuery(querys, "Magazine Borrowed");
                                txt_Borrow_magazineAccNo.setText("");
                                txt_Borrow_magazineBarcode.setText("");
                                txt_Borrow_magazineTitle.setText("");
                                txt_Borrow_magazineedition.setText("");
                                txt_Borrow_magazinePublisher.setText("");

                                txt_Borrow_magazineRCBarcode.setText("");
                                txt_Borrow_magazineBorrowerName.setText("");
                                txt_Borrow_magazineBorrowerGender.setText("");
                                txt_Borrow_magazineBorrowerAddress.setText(" ");
                                copyIES.setText("");

                                txt_Borrow_magazineBarcode.setEnabled(false);

                                txt_Borrow_magazineRCBarcode.setEnabled(false);

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

    }//GEN-LAST:event_btnsaveActionPerformed

    private void txt_Borrow_magazineAccNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Borrow_magazineAccNoActionPerformed
        txt_Borrow_magazineBarcode.setEnabled(true);
        String accession = txt_Borrow_magazineAccNo.getText();
        try {
            String query = "SELECT * FROM `tbl_magazineaccession` WHERE accession ='"+accession+"' and category_id='"+Global_Variable.category_id+"' ";
            ResultSet rs;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                    String access = rs.getString("accessID");
                    txt_Borrow_magazineAccNo.setText(access);

                    String bar = rs.getString("ISBNBarcode");
                    txt_Borrow_magazineBarcode.setText(bar);

                    String title = rs.getString("Title");
                    txt_Borrow_magazineTitle.setText(title);

                    String ed = rs.getString("EdNum");
                    txt_Borrow_magazineedition.setText(ed);

                    String publisher = rs.getString("Publisher");
                    txt_Borrow_magazineAccNo.setText(publisher);

                    String copiess = rs.getString("Copies");
                    txt_Borrow_magazineAccNo.setText(copiess);
                    String copys = rs.getString("Copies");
                    copyIES.setText(copys);

                    String a = copyIES.getText();
                    int accesss = Integer.valueOf(a);

                    if (accesss == 0) {
                        JOptionPane.showMessageDialog(null, "Oppss.. The magazine copies are already borrowed");
                        txt_Borrow_magazineAccNo.setText("");
                        txt_Borrow_magazineBarcode.setText("");
                        txt_Borrow_magazineTitle.setText("");
                        txt_Borrow_magazineedition.setText("");
                        txt_Borrow_magazinePublisher.setText("");

                        txt_Borrow_magazineRCBarcode.setText("");
                        txt_Borrow_magazineBorrowerName.setText("");
                        txt_Borrow_magazineBorrowerGender.setText("");
                        txt_Borrow_magazineBorrowerAddress.setText(" ");
                        copyIES.setText("");

                    } else {
                        a = Integer.toString(--accesss);
                        copys = a;
                        copyIES.setText(copys);
                    }
                }
            } catch (Exception e) {

            }
            txt_Borrow_magazineAccNo.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txt_Borrow_magazineAccNoActionPerformed

    private void btnoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoutsideActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode =" + txt_Borrow_magazineRCBarcode.getText();
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
                        if (txt_Borrow_magazineBarcode.getText().trim().isEmpty() || txt_Borrow_magazineRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {
                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txt_Borrow_magazineAccNo.getText() + "','" + txt_Borrow_magazineBarcode.getText() + "','" + txt_Borrow_magazineRCBarcode.getText() + "','" + borrowinside.getText() + "','"+Global_Variable.category_id+"')";
                            executeSqlQuery(queries, "Transaction Added");

                            try {
                                String queri = "UPDATE `tbl_magazine` SET  `NoofCopies` ='" + copyIES.getText() + "' WHERE  `ISBNBarcode` =" + txt_Borrow_magazineBarcode.getText();
                                executeSqlQuery(queri, "No of Copies Updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {
                                SimpleDateFormat ss = new SimpleDateFormat("MM-dd-yyyy");
                                String dated = ss.format(datereq.getDate());
                                String querys = "INSERT INTO `tbl_borrowoutside` VALUES ('" + Global_Variable.outremagazineId + "','" + magazine.getText() + "','" + txt_Borrow_magazineAccNo.getText() + "','" + txt_Borrow_magazineBarcode.getText() + "','" + txt_Borrow_magazineRCBarcode.getText() + "','" + dated + "','" + Global_Variable.category_id + "','" + labelDate.getText() + "','" + labelTime.getText() + "')";
                                executeSqlQuery(querys, "Magazine Borrowed");
                                txt_Borrow_magazineBarcode.setText("");
                                txt_Borrow_magazineAccNo.setText("");
                                txt_Borrow_magazineTitle.setText("");
                                txt_Borrow_magazineedition.setText("");
                                txt_Borrow_magazinePublisher.setText("");

                                txt_Borrow_magazineRCBarcode.setText("");
                                txt_Borrow_magazineBorrowerName.setText("");
                                txt_Borrow_magazineBorrowerGender.setText("");
                                txt_Borrow_magazineBorrowerAddress.setText(" ");
                                copyIES.setText("");

                                txt_Borrow_magazineBarcode.setEnabled(false);

                                txt_Borrow_magazineRCBarcode.setEnabled(false);

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
    private int validatematerialType() {
        Statement st;
        int id = 4;
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
            query = "select id from `tbl_logintypeclient` where type='" + txt_Borrow_magazineBorrowerType.getText() + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("id");
                txt_Borrow_magazineBorrowerType.setText("type");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox borrowinside;
    private javax.swing.JCheckBox borrowoutside;
    private javax.swing.JButton btnoutside;
    private javax.swing.JButton btnsave;
    private javax.swing.JTextField copyIES;
    private com.toedter.calendar.JDateChooser datereq;
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
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelTime;
    private javax.swing.JLabel magazine;
    private javax.swing.JLabel status;
    private javax.swing.JTextField txt_Borrow_magazineAccNo;
    private javax.swing.JTextField txt_Borrow_magazineBarcode;
    private javax.swing.JTextField txt_Borrow_magazineBorrowerAddress;
    private javax.swing.JTextField txt_Borrow_magazineBorrowerGender;
    private javax.swing.JTextField txt_Borrow_magazineBorrowerName;
    private javax.swing.JTextField txt_Borrow_magazineBorrowerType;
    private javax.swing.JTextField txt_Borrow_magazinePublisher;
    private javax.swing.JTextField txt_Borrow_magazineRCBarcode;
    private javax.swing.JTextField txt_Borrow_magazineTitle;
    private javax.swing.JTextField txt_Borrow_magazineedition;
    // End of variables declaration//GEN-END:variables
     //to validate if barcode doen't exist 

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

    private String availability() {
        String id = "";
        ResultSet rs;

        try {
            String query = "select * from tbl_magazine where ISBNBarcode =" + txt_Borrow_magazineBarcode.getText();
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("Status");
                switch (id) {
                    case "Available":
                        txt_Borrow_magazineBarcode.setEditable(true);
                        break;
                    case "Damaged":
                        JOptionPane.showMessageDialog(null, "Opps.. this book is damaged and cannot be borrowed");
                        txt_Borrow_magazineAccNo.setText("");
                        txt_Borrow_magazineBarcode.setText("");

                        break;
                    case "Lost":
                        JOptionPane.showMessageDialog(null, "Its lost!!!");
                        txt_Borrow_magazineAccNo.setText("");
                        txt_Borrow_magazineBarcode.setText("");
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
            String query = "select * from tbl_magazine where ISBNBarcode =" + txt_Borrow_magazineBarcode.getText();
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                available = rs.getString("Availability");
                switch (available) {
                    case "YES":
                        txt_Borrow_magazineBarcode.setEditable(true);
                        break;
                    case "NO":
                        JOptionPane.showMessageDialog(null, "Opps.. this book is cannot be borrowed");
                        txt_Borrow_magazineAccNo.setText("");
                        txt_Borrow_magazineBarcode.setText("");

                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return available;
    }
}
