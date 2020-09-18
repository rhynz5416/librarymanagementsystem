package Return;

import Global_Variable.Global_Variable;
import Module.dbConn;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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
import mainframe.LibraryMainFrame;
import mainframe.RENEWALFORM;

public class BOOKRETURN extends javax.swing.JFrame {

    dbConn con = new dbConn();
    Statement st;

    public BOOKRETURN() {
        initComponents();
        showBookDate();
        showBookTime();
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
        
        txt_Return_BookAccNo.setEnabled(true);
        txt_Return_BookBarcode.setEnabled(false);
        txt_Return_BookTitle.setEnabled(false);
        txt_Return_BookAuthor.setEnabled(false);
        txt_Return_BookPublisher.setEnabled(false);
        txt_Return_BookSection.setEnabled(false);
        txtBorrowRCBarcode.setEnabled(false);
        txtbookBorrowName.setEnabled(false);
        txtbookBorrowGender.setEnabled(false);
        txtbookBorrowAddress.setEnabled(false);
        txtbookBorrowType.setEnabled(false);
        copy.setEnabled(false);
        status.setText("----");
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
                JOptionPane.showMessageDialog(null, "" + message + " successfully");
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_Return_BookBarcode = new javax.swing.JTextField();
        txt_Return_BookAccNo = new javax.swing.JTextField();
        txt_Return_BookTitle = new javax.swing.JTextField();
        txt_Return_BookAuthor = new javax.swing.JTextField();
        txt_Return_BookPublisher = new javax.swing.JTextField();
        txt_Return_BookSection = new javax.swing.JTextField();
        copy = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_return_bookRCBarcode = new javax.swing.JTextField();
        txt_return_bookBorrowerName = new javax.swing.JTextField();
        txt_return_bookBorrowerGender = new javax.swing.JTextField();
        txt_return_bookBorrowerAddress = new javax.swing.JTextField();
        txt_return_bookBorrowerType = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtBorrowRCBarcode = new javax.swing.JTextField();
        txtbookBorrowName = new javax.swing.JTextField();
        txtbookBorrowGender = new javax.swing.JTextField();
        txtbookBorrowAddress = new javax.swing.JTextField();
        txtbookBorrowType = new javax.swing.JTextField();
        btninside = new javax.swing.JButton();
        returninside = new javax.swing.JCheckBox();
        borrowoutside = new javax.swing.JCheckBox();
        btnoutside = new javax.swing.JButton();
        redate = new javax.swing.JLabel();
        labeltime = new javax.swing.JLabel();
        book = new javax.swing.JLabel();
        labelstatus = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel3.setText("ISBN Barcode:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 60, 90, 30);

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel4.setText("Accession Number: ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 20, 130, 30);

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel5.setText("Book  Title:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 100, 90, 30);

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel6.setText("Author:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(100, 150, 60, 30);

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel7.setText("Publisher:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(80, 200, 70, 40);

        jLabel8.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel8.setText("No of Copies Available:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 285, 160, 40);

        txt_Return_BookBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_BookBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Return_BookBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Return_BookBarcodeActionPerformed(evt);
            }
        });
        txt_Return_BookBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_Return_BookBarcodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Return_BookBarcodeKeyReleased(evt);
            }
        });
        jPanel1.add(txt_Return_BookBarcode);
        txt_Return_BookBarcode.setBounds(160, 60, 250, 30);

        txt_Return_BookAccNo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_BookAccNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Return_BookAccNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Return_BookAccNoActionPerformed(evt);
            }
        });
        txt_Return_BookAccNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_Return_BookAccNoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Return_BookAccNoKeyReleased(evt);
            }
        });
        jPanel1.add(txt_Return_BookAccNo);
        txt_Return_BookAccNo.setBounds(160, 20, 250, 30);

        txt_Return_BookTitle.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_BookTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Return_BookTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Return_BookTitleActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Return_BookTitle);
        txt_Return_BookTitle.setBounds(160, 100, 250, 30);

        txt_Return_BookAuthor.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_BookAuthor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txt_Return_BookAuthor);
        txt_Return_BookAuthor.setBounds(160, 150, 250, 30);

        txt_Return_BookPublisher.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_BookPublisher.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_Return_BookPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Return_BookPublisherActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Return_BookPublisher);
        txt_Return_BookPublisher.setBounds(160, 200, 250, 30);

        txt_Return_BookSection.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txt_Return_BookSection.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txt_Return_BookSection);
        txt_Return_BookSection.setBounds(160, 250, 250, 30);

        copy.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        copy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(copy);
        copy.setBounds(160, 290, 140, 30);

        jLabel9.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel9.setText("Book Section: ");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(60, 260, 90, 15);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(510, 260, 440, 350);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Name:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(480, 170, 50, 30);

        jLabel12.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Gender:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(470, 230, 60, 20);

        jLabel13.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Address:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(470, 280, 60, 15);

        jLabel14.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Borrower Type:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(430, 320, 110, 30);

        txt_return_bookRCBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_return_bookRCBarcodeActionPerformed(evt);
            }
        });
        txt_return_bookRCBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_return_bookRCBarcodeKeyReleased(evt);
            }
        });
        jPanel2.add(txt_return_bookRCBarcode);
        txt_return_bookRCBarcode.setBounds(540, 120, 210, 30);
        jPanel2.add(txt_return_bookBorrowerName);
        txt_return_bookBorrowerName.setBounds(540, 170, 260, 30);
        jPanel2.add(txt_return_bookBorrowerGender);
        txt_return_bookBorrowerGender.setBounds(540, 220, 130, 30);
        jPanel2.add(txt_return_bookBorrowerAddress);
        txt_return_bookBorrowerAddress.setBounds(540, 270, 240, 30);
        jPanel2.add(txt_return_bookBorrowerType);
        txt_return_bookBorrowerType.setBounds(540, 320, 180, 30);

        jLabel11.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel11.setText("Reader's Card Barcode:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(20, 120, 160, 40);

        jLabel15.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel15.setText("Name:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(120, 170, 50, 30);

        jLabel16.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel16.setText("Gender:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(110, 210, 60, 20);

        jLabel17.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel17.setText("Address:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(110, 250, 60, 30);

        jLabel18.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel18.setText("Borrower Type:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(70, 290, 110, 30);

        txtBorrowRCBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtBorrowRCBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBorrowRCBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBorrowRCBarcodeActionPerformed(evt);
            }
        });
        txtBorrowRCBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBorrowRCBarcodeKeyReleased(evt);
            }
        });
        jPanel2.add(txtBorrowRCBarcode);
        txtBorrowRCBarcode.setBounds(170, 130, 210, 30);

        txtbookBorrowName.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtbookBorrowName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txtbookBorrowName);
        txtbookBorrowName.setBounds(170, 170, 210, 30);

        txtbookBorrowGender.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtbookBorrowGender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txtbookBorrowGender);
        txtbookBorrowGender.setBounds(170, 210, 140, 30);

        txtbookBorrowAddress.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtbookBorrowAddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txtbookBorrowAddress);
        txtbookBorrowAddress.setBounds(170, 250, 210, 30);

        txtbookBorrowType.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtbookBorrowType.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txtbookBorrowType);
        txtbookBorrowType.setBounds(170, 290, 210, 30);

        btninside.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btninside.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        btninside.setText("SAVE");
        btninside.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btninside.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btninside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsideActionPerformed(evt);
            }
        });
        jPanel2.add(btninside);
        btninside.setBounds(50, 50, 90, 30);

        returninside.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        returninside.setText("RETURN FROM INSIDE");
        returninside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returninsideActionPerformed(evt);
            }
        });
        jPanel2.add(returninside);
        returninside.setBounds(30, 20, 180, 30);

        borrowoutside.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        borrowoutside.setText("RETURN FROM OUTSIDE");
        borrowoutside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowoutsideActionPerformed(evt);
            }
        });
        jPanel2.add(borrowoutside);
        borrowoutside.setBounds(220, 20, 200, 30);

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
        jPanel2.add(btnoutside);
        btnoutside.setBounds(251, 53, 100, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(1020, 260, 420, 350);

        redate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        redate.setText("Date:");
        getContentPane().add(redate);
        redate.setBounds(1230, 20, 100, 30);

        labeltime.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labeltime.setText("Time:");
        getContentPane().add(labeltime);
        labeltime.setBounds(1430, 20, 70, 30);

        book.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        book.setText("BOOK");
        getContentPane().add(book);
        book.setBounds(30, 10, 170, 40);

        labelstatus.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelstatus.setText("Status: ");
        getContentPane().add(labelstatus);
        labelstatus.setBounds(520, 630, 330, 20);

        status.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        status.setText("-------");
        getContentPane().add(status);
        status.setBounds(850, 630, 100, 20);

        setSize(new java.awt.Dimension(1664, 947));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Return_BookBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Return_BookBarcodeActionPerformed

    }//GEN-LAST:event_txt_Return_BookBarcodeActionPerformed

    private void txt_Return_BookBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Return_BookBarcodeKeyPressed

    }//GEN-LAST:event_txt_Return_BookBarcodeKeyPressed

    private void txt_Return_BookBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Return_BookBarcodeKeyReleased

    }//GEN-LAST:event_txt_Return_BookBarcodeKeyReleased

    private void txt_Return_BookTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Return_BookTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Return_BookTitleActionPerformed

    private void txt_Return_BookPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Return_BookPublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Return_BookPublisherActionPerformed

    private void txt_return_bookRCBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_return_bookRCBarcodeActionPerformed
        if (validateRCBarcode(txt_return_bookRCBarcode.getText())) {
            String barcode = "", name = "", gender = "", address = "", type = "", dateregis = "", dateexpire = "";
            try {

                ResultSet rs = null;
                String tempbarcode = txt_return_bookRCBarcode.getText();

                String query = "SELECT * FROM `tbl_clientregistration` WHERE ClientBarcode= " + tempbarcode;
                st = con.dbconn().prepareStatement(query);
                rs = st.executeQuery(query);

                try {
                    if (rs.next()) {
                        //to display the data inside the txtfields
                        barcode = rs.getString("ClientBarcode");
                        txt_return_bookRCBarcode.setText(barcode);

                        name = rs.getString("Name");
                        txt_return_bookBorrowerName.setText(name);

                        gender = rs.getString("Gender");
                        txt_return_bookBorrowerGender.setText(gender);

                        address = rs.getString("Address");
                        txt_return_bookBorrowerAddress.setText(address);

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                txt_return_bookRCBarcode.getText();
                txt_return_bookBorrowerName.getText();
                txt_return_bookBorrowerGender.getText();
                txt_return_bookBorrowerAddress.getText();
                txt_return_bookBorrowerType.getText();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "This Readers card Barcode doesn't exists");
            txt_return_bookRCBarcode.setText("");
        }
    }//GEN-LAST:event_txt_return_bookRCBarcodeActionPerformed

    private void txt_return_bookRCBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_return_bookRCBarcodeKeyReleased

    }//GEN-LAST:event_txt_return_bookRCBarcodeKeyReleased

    private void txtBorrowRCBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBorrowRCBarcodeActionPerformed


    }//GEN-LAST:event_txtBorrowRCBarcodeActionPerformed

    private void txtBorrowRCBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBorrowRCBarcodeKeyReleased
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String barcode = "", name = "", gender = "", address = "", type = "", dateregis = "", dateexpire = "";
        try {

            String tempbarcode = txtBorrowRCBarcode.getText();
            String query = "SELECT * FROM `tbl_clientregistration` WHERE ClientBarcode= " + tempbarcode;

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.prepareStatement(query);
            rs = st.executeQuery(query);

            try {
                if (rs.next()) {
                    //to display the data inside the txtfields
                    barcode = rs.getString("ClientBarcode");
                    txtBorrowRCBarcode.setText(barcode);

                    name = rs.getString("Name");
                    txtbookBorrowName.setText(name);

                    gender = rs.getString("Gender");
                    txtbookBorrowGender.setText(gender);

                    address = rs.getString("Address");
                    txtbookBorrowAddress.setText(address);

                    type = rs.getString("ClientType");
                    txtbookBorrowType.setText(type);

                    dateregis = rs.getString("DateIssued");
                    dateexpire = rs.getString("DateExpired");

                }
            } catch (Exception ex) {

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_txtBorrowRCBarcodeKeyReleased

    private void borrowoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowoutsideActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //  dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_borrowoutside` where ISBNBarcode =" + txt_Return_BookBarcode.getText();

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
                    if (l.getTime() < a.getTime()) {
                        JOptionPane.showMessageDialog(null, "Opps you overdue");
                        JOptionPane.showMessageDialog(null, "Your expected date to return is" + datereturns);

                        PENALTY_FORM Lib = new PENALTY_FORM();
                        Lib.setVisible(true);
                        Lib.setLocationRelativeTo(null);
                    } else {
                        Connection cn = null;

                        try {

                            String tempbarcode = txt_Return_BookBarcode.getText();
                            String querys = "SELECT * FROM `tbl_borrowoutside` WHERE ISBNBarcode= " + tempbarcode;
                            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
                            st = cn.prepareStatement(querys);
                            rs = st.executeQuery(querys);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_borrowoutsideActionPerformed

    private void btninsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsideActionPerformed
        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode = '"+txtBorrowRCBarcode.getText()+"'" ;
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
                        if (txt_Return_BookBarcode.getText().trim().isEmpty() || txtBorrowRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {
                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txt_Return_BookAccNo.getText() + "','" + txt_Return_BookBarcode.getText() + "','" + txtBorrowRCBarcode.getText() + "','" + returninside.getText() + "')";
                            executesqlQuery(queries, "Transaction Added");

                            try {
                                String queri = "UPDATE `tbl_librarybook` SET  `NoOfCopies` ='" + copy.getText() + "' WHERE  `ISBNBarcode` =" + txt_Return_BookBarcode.getText();
                                executesqlQuery(queri, "No of Copies Updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            try {
                                //  String id = "select id from `tbl_borrowinside` where id='" + Global_Variable.inbookId+ "'";
                                String q = "INSERT INTO `tbl_returninside` VALUES ('" + Global_Variable.inrebookId + "','" + getBorrowid() + "','" + labeltime.getText() + "','" + redate.getText() + "')";
                                executesqlQuery(q, "Book Returned");

                                txt_Return_BookBarcode.setText("");
                                txt_Return_BookAccNo.setText("");
                                txt_Return_BookTitle.setText("");
                                txt_Return_BookAuthor.setText("");
                                txt_Return_BookPublisher.setText("");
                                txt_Return_BookSection.setText("");
                                txtBorrowRCBarcode.setText("");
                                txtbookBorrowName.setText("");
                                txtbookBorrowGender.setText("");
                                txtbookBorrowAddress.setText("");
                                txtbookBorrowType.setText("");

                                txt_Return_BookBarcode.setEnabled(false);
                                txtBorrowRCBarcode.setEnabled(false);

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


    }//GEN-LAST:event_btninsideActionPerformed

    private void returninsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returninsideActionPerformed
        txtBorrowRCBarcode.setEnabled(true);


    }//GEN-LAST:event_returninsideActionPerformed

    private void txt_Return_BookAccNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Return_BookAccNoKeyPressed
        txt_Return_BookBarcode.setEnabled(true);
    }//GEN-LAST:event_txt_Return_BookAccNoKeyPressed

    private void btnoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoutsideActionPerformed

        ResultSet rs = null;
        Statement st = null;
        //dbConn con = new dbConn();
        String query = "SELECT * FROM `tbl_clientregistration` where ClientBarcode = '"+txtBorrowRCBarcode.getText()+"'" ;
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
                        if (txt_Return_BookBarcode.getText().trim().isEmpty() || txtBorrowRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {
                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txt_Return_BookAccNo.getText() + "','" + txt_Return_BookBarcode.getText() + "','" + txtBorrowRCBarcode.getText() + "','" + borrowoutside.getText() + "')";
                            executesqlQuery(queries, "Transaction Added");

                            try {
                                String queri = "UPDATE `tbl_librarybook` SET  `NoOfCopies` ='" + copy.getText() + "' WHERE  `ISBNBarcode` =" + txt_Return_BookBarcode.getText();
                                executesqlQuery(queri, "No of Copies updated");
                            } catch (Exception es) {
                                es.printStackTrace();
                            }
                            try {
                                String q = "INSERT INTO `tbl_returnoutside` VALUES ('" + Global_Variable.outrebookId + "','" + getBorrowid() + "','" + redate.getText() + "','" + labeltime.getText() + "')";
                                executesqlQuery(q, "Book Return");

                            } catch (Exception es) {
                                es.printStackTrace();
                            }
                            try {
                                String qa = "INSERT INTO `tbl_penalty`(`id`, `accession`, `barcode`, `rcbarcode`, `name`, `datereturn`) VALUES ('" + Global_Variable.penalty + "','" + txt_Return_BookAccNo.getText() + "','" + txt_Return_BookBarcode.getText() + "','" + txtBorrowRCBarcode.getText() + "','" + txtbookBorrowName.getText() + "','" + redate.getText() + "')";
                                executesqlQuery(qa, "Penalty");
                                txt_Return_BookBarcode.setText("");
                                txt_Return_BookAccNo.setText("");
                                txt_Return_BookTitle.setText("");
                                txt_Return_BookAuthor.setText("");
                                txt_Return_BookPublisher.setText("");
                                txt_Return_BookSection.setText("");
                                txtBorrowRCBarcode.setText("");
                                txtbookBorrowName.setText("");
                                txtbookBorrowGender.setText("");
                                txtbookBorrowAddress.setText("");
                                txtbookBorrowType.setText("");
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

    private void txt_Return_BookAccNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Return_BookAccNoActionPerformed
        try {
            ResultSet rs = null;
            String tempbarcode = txt_Return_BookAccNo.getText();
            String query = "SELECT * FROM `tbl_bookaccessions` WHERE accessID='" + tempbarcode + "' ";

            st = con.dbconn().prepareStatement(query);
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                    //to display the data inside the txtfields
                    String barcode = rs.getString("ISBNBarcode");
                    txt_Return_BookBarcode.setText(barcode);

                    String title = rs.getString("Title");
                    txt_Return_BookTitle.setText(title);

                    String author = rs.getString("Author");
                    txt_Return_BookAuthor.setText(author);

                    String publisher = rs.getString("Publisher");
                    txt_Return_BookPublisher.setText(publisher);

                    String type = rs.getString("BookSection");
                    txt_Return_BookSection.setText(type);

                    String copii = rs.getString("NoCopies");
                    copy.setText(copii);

                    String a = copy.getText();
                    int access = Integer.valueOf(a);
                    a = Integer.toString(++access);
                    copii = a;
                    copy.setText(copii);

                    int choice;
                    choice = JOptionPane.showConfirmDialog(null, "Return from outside?");

                    if (choice == JOptionPane.YES_OPTION) {
                        txtBorrowRCBarcode.setEnabled(true);
                        labelstatus.setText(txt_Return_BookBarcode.getText() + " with accession number " + txt_Return_BookAccNo.getText() + " is now: ");
                        status.setText("available");

                        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_Return_BookAccNo.getText() + "','" + txt_Return_BookBarcode.getText() + "','" + status.getText() + "')";
                        executesqlQuery(quer, "Material Monitored");
                    } else if (choice == JOptionPane.NO_OPTION) {
                        txtBorrowRCBarcode.setEnabled(true);
                        labelstatus.setText(txt_Return_BookBarcode.getText() + " with accession number " + txt_Return_BookAccNo.getText() + " is now: ");
                        status.setText("available");

                        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_Return_BookAccNo.getText() + "','" + txt_Return_BookBarcode.getText() + "','" + status.getText() + "')";
                        executesqlQuery(quer, "Material Monitored");
                    } else if (choice == JOptionPane.CANCEL_OPTION) {
                        this.setVisible(true);
                    }

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            txt_Return_BookBarcode.getText();
            txt_Return_BookAccNo.getText();
            txt_Return_BookTitle.getText();
            txt_Return_BookAuthor.getText();
            txt_Return_BookPublisher.getText();
            txt_Return_BookSection.getText();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txt_Return_BookAccNoActionPerformed

    private void txt_Return_BookAccNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Return_BookAccNoKeyReleased
       try {
            ResultSet rs = null;
            String tempbarcode = txt_Return_BookAccNo.getText();
            String query = "SELECT * FROM `tbl_bookaccessions` WHERE accessID='" + tempbarcode + "'";

            st = con.dbconn().prepareStatement(query);
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                    //to display the data inside the txtfields
                    String barcode = rs.getString("ISBNBarcode");
                    txt_Return_BookBarcode.setText(barcode);

                    String title = rs.getString("BookTitle");
                    txt_Return_BookTitle.setText(title);

                    String author = rs.getString("BookAuthor");
                    txt_Return_BookAuthor.setText(author);

                    String publisher = rs.getString("BookPublisher");
                    txt_Return_BookPublisher.setText(publisher);

                    String type = rs.getString("BookType");
                    txt_Return_BookSection.setText(type);

                    String copii = rs.getString("NoCopies");
                    copy.setText(copii);

                    String a = copy.getText();
                    int access = Integer.valueOf(a);
                    a = Integer.toString(++access);
                    copii = a;
                    copy.setText(copii);

                    int choice;
                    choice = JOptionPane.showConfirmDialog(null, "Return from outside?");

                    if (choice == JOptionPane.YES_OPTION) {
                        txtBorrowRCBarcode.setEnabled(true);
                        labelstatus.setText(txt_Return_BookBarcode.getText() + " with accession number " + txt_Return_BookAccNo.getText() + " is now: ");
                        status.setText("available");

                        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_Return_BookAccNo.getText() + "','" + txt_Return_BookBarcode.getText() + "','" + status.getText() + "')";
                        executesqlQuery(quer, "Material Monitored");
                    } else if (choice == JOptionPane.NO_OPTION) {
                        txtBorrowRCBarcode.setEnabled(true);
                        labelstatus.setText(txt_Return_BookBarcode.getText() + " with accession number " + txt_Return_BookAccNo.getText() + " is now: ");
                        status.setText("available");

                        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txt_Return_BookAccNo.getText() + "','" + txt_Return_BookBarcode.getText() + "','" + status.getText() + "')";
                        executesqlQuery(quer, "Material Monitored");
                    } else if (choice == JOptionPane.CANCEL_OPTION) {
                        this.setVisible(true);
                    }

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            txt_Return_BookBarcode.getText();
            txt_Return_BookAccNo.getText();
            txt_Return_BookTitle.getText();
            txt_Return_BookAuthor.getText();
            txt_Return_BookPublisher.getText();
            txt_Return_BookSection.getText();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txt_Return_BookAccNoKeyReleased

    private boolean validateBarcode(String Barcode) {
        boolean queue = false;
        ResultSet rs;
        String query;
        try {
            query = "select * from `tbl_librarybook` where ISBNBarcode ='" + Barcode + "'";
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel book;
    private javax.swing.JCheckBox borrowoutside;
    private javax.swing.JButton btninside;
    private javax.swing.JButton btnoutside;
    private javax.swing.JTextField copy;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelstatus;
    private javax.swing.JLabel labeltime;
    private javax.swing.JLabel redate;
    private javax.swing.JCheckBox returninside;
    private javax.swing.JLabel status;
    private javax.swing.JTextField txtBorrowRCBarcode;
    private javax.swing.JTextField txt_Return_BookAccNo;
    private javax.swing.JTextField txt_Return_BookAuthor;
    private javax.swing.JTextField txt_Return_BookBarcode;
    private javax.swing.JTextField txt_Return_BookPublisher;
    private javax.swing.JTextField txt_Return_BookSection;
    private javax.swing.JTextField txt_Return_BookTitle;
    private javax.swing.JTextField txt_return_bookBorrowerAddress;
    private javax.swing.JTextField txt_return_bookBorrowerGender;
    private javax.swing.JTextField txt_return_bookBorrowerName;
    private javax.swing.JTextField txt_return_bookBorrowerType;
    private javax.swing.JTextField txt_return_bookRCBarcode;
    private javax.swing.JTextField txtbookBorrowAddress;
    private javax.swing.JTextField txtbookBorrowGender;
    private javax.swing.JTextField txtbookBorrowName;
    private javax.swing.JTextField txtbookBorrowType;
    // End of variables declaration//GEN-END:variables
      private String getBorrowid() {
        Statement st;
        String id = "";
        ResultSet rs;
        String query;
        try {
            query = "SELECT `id` FROM `tbl_borrowinside`";
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

    private String getDateborrowed() {
        Statement st;
        String id = "";
        ResultSet rs;
        String query;
        try {
            query = "SELECT `date_to_return` FROM `tbl_borrowoutside` WHERE `ISBNBarcode`=" + txt_Return_BookBarcode.getText();
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("date_to_return");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
