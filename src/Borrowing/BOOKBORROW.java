package Borrowing;

import Classes.C_LibraryMaterialBook;
import Global_Variable.Global_Variable;
import Module.dbConn;
import Return.PENALTY_FORM;
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
import mainframe.CLIENTREGISTRATION;
import mainframe.RENEWALFORM;

public class BOOKBORROW extends javax.swing.JFrame {

    Global_Variable global_var = new Global_Variable();
    dbConn con = new dbConn();
    Statement st;
    ResultSet rs;

    public BOOKBORROW() {
        initComponents();
        showBookDate();
        showBookTime();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
       
        txtborrowBookAccNo.setEnabled(true);
        txtborrowBookBarcode.setEnabled(false);
        txtborrowBookTitle.setEnabled(false);
        txtborrowBookAuthor.setEnabled(false);
        txtborrowBookPublisher.setEnabled(false);
        txtborrowBookSection.setEnabled(false); 
        txtBorrowRCBarcode.setEnabled(false);
        txtbookBorrowName.setEnabled(false);
        txtbookBorrowGender.setEnabled(false);
        txtbookBorrowAddress.setEnabled(false);
        txtbookBorrowType.setEnabled(false);
        copies.setEnabled(false); 
    }

    //this is for getting a current date
    void showBookDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
        labelDate.setText(s.format(d));
    }

    //this is for geeting a current time  
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

    //to get the query of book from the database
    public ArrayList<C_LibraryMaterialBook> getBookList() {
        ArrayList<C_LibraryMaterialBook> Material = new ArrayList<C_LibraryMaterialBook>();
        String query = "select * from `tbl_librarybook` where ISBNBarcode='" + Global_Variable.BookId + "'";
        ResultSet rs;

        try {
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);

            C_LibraryMaterialBook book;
            while (rs.next()) {
                book = new C_LibraryMaterialBook(rs.getInt("id"), rs.getString("ISBNBarcode"), rs.getString("DateAcquisition"), rs.getString("BookTitle"), rs.getString("BookAuthor"), rs.getInt("EditionNumber"), rs.getInt("PagesVolume"), rs.getString("Place"), rs.getString("BookPublisher"), rs.getInt("Year"), rs.getString("Binding"), rs.getDouble("Price"), rs.getString("BookType"));
                Material.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Material;
    }

    //borrowQuery
    public void executesqlQuery(String query, String message) {
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
        book = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cops = new javax.swing.JLabel();
        txtborrowBookAccNo = new javax.swing.JTextField();
        txtborrowBookBarcode = new javax.swing.JTextField();
        txtborrowBookTitle = new javax.swing.JTextField();
        txtborrowBookAuthor = new javax.swing.JTextField();
        txtborrowBookPublisher = new javax.swing.JTextField();
        txtborrowBookSection = new javax.swing.JTextField();
        copies = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtbookBorrowType = new javax.swing.JTextField();
        txtbookBorrowAddress = new javax.swing.JTextField();
        txtbookBorrowGender = new javax.swing.JTextField();
        txtbookBorrowName = new javax.swing.JTextField();
        txtBorrowRCBarcode = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        borrowinside = new javax.swing.JCheckBox();
        borrowoutside = new javax.swing.JCheckBox();
        btnsaveinside = new javax.swing.JButton();
        daterequired = new com.toedter.calendar.JDateChooser();
        status = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        books = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        labeltime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("bookframe"); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        book.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel4.setText("Accession Number: ");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(50, 20, 130, 30);

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel3.setText("ISBN Barcode:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(90, 60, 90, 30);

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel5.setText("Book  Title:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(100, 100, 90, 30);

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel6.setText("Author:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(130, 140, 60, 30);

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel7.setText("Publisher:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(110, 180, 70, 30);

        jLabel11.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel11.setText("Book Section: ");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(90, 220, 90, 30);

        cops.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        cops.setText("No of Copies Available:");
        jPanel2.add(cops);
        cops.setBounds(40, 260, 160, 30);

        txtborrowBookAccNo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtborrowBookAccNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtborrowBookAccNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtborrowBookAccNoFocusLost(evt);
            }
        });
        txtborrowBookAccNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtborrowBookAccNoActionPerformed(evt);
            }
        });
        txtborrowBookAccNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtborrowBookAccNoKeyReleased(evt);
            }
        });
        jPanel2.add(txtborrowBookAccNo);
        txtborrowBookAccNo.setBounds(190, 20, 100, 30);

        txtborrowBookBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtborrowBookBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtborrowBookBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtborrowBookBarcodeActionPerformed(evt);
            }
        });
        txtborrowBookBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtborrowBookBarcodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtborrowBookBarcodeKeyReleased(evt);
            }
        });
        jPanel2.add(txtborrowBookBarcode);
        txtborrowBookBarcode.setBounds(190, 60, 220, 30);

        txtborrowBookTitle.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtborrowBookTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtborrowBookTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtborrowBookTitleActionPerformed(evt);
            }
        });
        jPanel2.add(txtborrowBookTitle);
        txtborrowBookTitle.setBounds(190, 100, 220, 30);

        txtborrowBookAuthor.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtborrowBookAuthor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txtborrowBookAuthor);
        txtborrowBookAuthor.setBounds(190, 140, 220, 30);

        txtborrowBookPublisher.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtborrowBookPublisher.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtborrowBookPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtborrowBookPublisherActionPerformed(evt);
            }
        });
        jPanel2.add(txtborrowBookPublisher);
        txtborrowBookPublisher.setBounds(190, 180, 220, 30);

        txtborrowBookSection.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtborrowBookSection.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txtborrowBookSection);
        txtborrowBookSection.setBounds(190, 220, 220, 30);

        copies.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        copies.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(copies);
        copies.setBounds(190, 260, 60, 30);

        book.add(jPanel2);
        jPanel2.setBounds(410, 210, 470, 360);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel9.setText("Reader's Card Barcode:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(60, 110, 160, 30);

        jLabel10.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel10.setText("Name:");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(160, 160, 50, 20);

        jLabel12.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel12.setText("Gender:");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(150, 190, 60, 30);

        jLabel13.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel13.setText("Address:");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(150, 240, 60, 15);

        jLabel15.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel15.setText("Borrower Type:");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(100, 270, 110, 30);

        jLabel14.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel14.setText("Date Return:");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(120, 310, 110, 30);

        txtbookBorrowType.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtbookBorrowType.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txtbookBorrowType);
        txtbookBorrowType.setBounds(220, 270, 210, 30);

        txtbookBorrowAddress.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtbookBorrowAddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txtbookBorrowAddress);
        txtbookBorrowAddress.setBounds(220, 230, 250, 30);

        txtbookBorrowGender.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtbookBorrowGender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txtbookBorrowGender);
        txtbookBorrowGender.setBounds(220, 190, 140, 30);

        txtbookBorrowName.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtbookBorrowName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txtbookBorrowName);
        txtbookBorrowName.setBounds(220, 150, 250, 30);

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
        jPanel3.add(txtBorrowRCBarcode);
        txtBorrowRCBarcode.setBounds(220, 110, 190, 30);

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
        btnSave.setBounds(290, 40, 80, 30);

        borrowinside.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        borrowinside.setText("BORROW INSIDE");
        borrowinside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowinsideActionPerformed(evt);
            }
        });
        jPanel3.add(borrowinside);
        borrowinside.setBounds(40, 10, 150, 20);

        borrowoutside.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        borrowoutside.setText("BORROW OUTSIDE");
        borrowoutside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowoutsideActionPerformed(evt);
            }
        });
        jPanel3.add(borrowoutside);
        borrowoutside.setBounds(250, 10, 161, 20);

        btnsaveinside.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnsaveinside.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        btnsaveinside.setText("SAVE");
        btnsaveinside.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnsaveinside.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsaveinside.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveinsideActionPerformed(evt);
            }
        });
        jPanel3.add(btnsaveinside);
        btnsaveinside.setBounds(70, 40, 90, 30);

        daterequired.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        daterequired.setDateFormatString("MM-dd-yyyy");
        jPanel3.add(daterequired);
        daterequired.setBounds(220, 310, 210, 30);

        book.add(jPanel3);
        jPanel3.setBounds(1030, 210, 530, 360);

        status.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        status.setText("-----------");
        book.add(status);
        status.setBounds(800, 600, 70, 20);

        labelStatus.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelStatus.setText("Status:");
        book.add(labelStatus);
        labelStatus.setBounds(410, 600, 390, 20);

        books.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        books.setText("BOOK");
        book.add(books);
        books.setBounds(20, 20, 150, 40);

        labelDate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labelDate.setText("Date:");
        book.add(labelDate);
        labelDate.setBounds(1540, 30, 160, 30);

        labeltime.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        labeltime.setText("Time:");
        book.add(labeltime);
        labeltime.setBounds(1750, 30, 70, 30);

        jPanel1.add(book);
        book.setBounds(0, 0, 1870, 890);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1870, 890);

        setSize(new java.awt.Dimension(1889, 938));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
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
                        if (txtborrowBookBarcode.getText().trim().isEmpty() || txtBorrowRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {

                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txtborrowBookAccNo.getText() + "','" + txtborrowBookBarcode.getText() + "','" + txtBorrowRCBarcode.getText() + "','" + borrowoutside.getText() + "')";
                            executesqlQuery(queries, "Transaction Added");

                            try {
                                String queri = "UPDATE `tbl_librarybook` SET  `NoOfCopies` ='" + copies.getText() + "' WHERE  `ISBNBarcode` =" + txtborrowBookBarcode.getText();
                                executesqlQuery(queri, "No of Copies Updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                //   SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
                                String dated = s.format(daterequired.getDate());

                                String querys = "INSERT INTO `tbl_borrowoutside` VALUES ('" + Global_Variable.outbookId + "','" + books.getText() + "','" + txtborrowBookAccNo.getText() + "','" + txtborrowBookBarcode.getText() + "','" + txtBorrowRCBarcode.getText() + "','" + dated + "','" + labelDate.getText() + "','" + labeltime.getText() + "')";
                                executesqlQuery(querys, "Book Borrowed");
                                txtborrowBookAccNo.setText("");

                                txtborrowBookBarcode.setText("");
                                txtborrowBookTitle.setText("");
                                txtborrowBookAuthor.setText("");
                                txtborrowBookPublisher.setText("");
                                txtborrowBookSection.setText("");
                                txtBorrowRCBarcode.setText("");
                                txtbookBorrowName.setText("");
                                txtbookBorrowGender.setText("");
                                txtbookBorrowAddress.setText("");
                                txtbookBorrowType.setText("");
                                daterequired.setDateFormatString("");

                                txtborrowBookBarcode.setEnabled(false);
                                txtBorrowRCBarcode.setEnabled(false);

                                //to deduct the no of copies from the database
                                String aa = copies.getText();
                                int access = Integer.valueOf(aa);
                                aa = Integer.toString(--access);
                                copies.setText(aa);

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
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtBorrowRCBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBorrowRCBarcodeKeyReleased
        daterequired.setEnabled(true);
        Date d = new Date();
        SimpleDateFormat dds = new SimpleDateFormat("MM-dd-yyyy");
        String barcode = "", name = "", gender = "", address = "", type = "", dateregis = "", dateexpire = "";
        dateregis = dds.format(d);
        dateexpire = dds.format(d); 
        long a = 0;
        SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");

        if (validateRCBarcode(txtBorrowRCBarcode.getText())) {
            try {
                Connection cn = null;
                Statement st = null;
                ResultSet rs = null;
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
                    if (a > 0) {
                        txtBorrowRCBarcode.setText(barcode);
                        txtbookBorrowName.setText(name);
                        txtbookBorrowGender.setText(gender);
                        txtbookBorrowAddress.setText(address);
                        txtbookBorrowType.setText(type);

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
            txtBorrowRCBarcode.setText("");
            JOptionPane.showMessageDialog(null, "Readers Card Barcode doesn't exist");
        }
    }//GEN-LAST:event_txtBorrowRCBarcodeKeyReleased

    private void txtBorrowRCBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBorrowRCBarcodeActionPerformed
     
    }//GEN-LAST:event_txtBorrowRCBarcodeActionPerformed

    private void borrowoutsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowoutsideActionPerformed
        txtBorrowRCBarcode.setEnabled(true);
        daterequired.setEnabled(true);

        labelStatus.setText(txtborrowBookBarcode.getText() + " with accession number " + txtborrowBookAccNo.getText() + " is now: ");
        status.setText("borrowed");

        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txtborrowBookAccNo.getText() + "','" + txtborrowBookBarcode.getText() + "','" + status.getText() + "')";
        executesqlQuery(quer, "Monitored");


    }//GEN-LAST:event_borrowoutsideActionPerformed

    private void borrowinsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowinsideActionPerformed

        daterequired.setEnabled(false);
        txtBorrowRCBarcode.setEnabled(true);
        labelStatus.setText(txtborrowBookBarcode.getText() + " with accession number " + txtborrowBookAccNo.getText() + " is now: ");
        status.setText("borrowed");

        String quer = "INSERT INTO `tbl_matmonitoring` VALUES ('" + Global_Variable.monitoring_id + "','" + txtborrowBookAccNo.getText() + "','" + txtborrowBookBarcode.getText() + "','" + status.getText() + "')";
        executesqlQuery(quer, "Monitored");

    }//GEN-LAST:event_borrowinsideActionPerformed

    private void txtborrowBookPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtborrowBookPublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtborrowBookPublisherActionPerformed

    private void txtborrowBookTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtborrowBookTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtborrowBookTitleActionPerformed

    private void txtborrowBookBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtborrowBookBarcodeKeyReleased
        try {
            availability();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            status();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        txtborrowBookTitle.setEditable(false);
        txtborrowBookAuthor.setEditable(false);
        txtborrowBookPublisher.setEditable(false);
        txtborrowBookSection.setEditable(false);
        copies.setEditable(false);

    }//GEN-LAST:event_txtborrowBookBarcodeKeyReleased

    private void txtborrowBookBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtborrowBookBarcodeKeyPressed

    }//GEN-LAST:event_txtborrowBookBarcodeKeyPressed

    private void txtborrowBookBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtborrowBookBarcodeActionPerformed

        try {

            ResultSet rs = null;
            String tempbarcode = txtborrowBookBarcode.getText();
            String query = "SELECT * FROM `tbl_librarybook` WHERE ISBNBarcode ='" + tempbarcode + "'";

            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {

                    //to display the data inside the txtfields
                    String barcode = rs.getString("ISBNBarcode");
                    txtborrowBookBarcode.setText(barcode);

                    validatebookType();

                    String title = rs.getString("BookTitle");
                    txtborrowBookTitle.setText(title);

                    String author = rs.getString("BookAuthor");
                    txtborrowBookAuthor.setText(author);

                    String pubisher = rs.getString("BookPublisher");
                    txtborrowBookPublisher.setText(pubisher);

                    String section = rs.getString("BookType");
                    txtborrowBookSection.setText(section);

                    String copy = rs.getString("NoOfCopies");
                    copies.setText(copy);

                    String a = copies.getText();
                    int access = Integer.valueOf(a);

                    if (access == 0) {
                        JOptionPane.showMessageDialog(null, "Oppss.. The book copies are already borrowed");
                        txtborrowBookBarcode.setText("");
                        txtborrowBookAccNo.setText("");
                        txtborrowBookTitle.setText("");
                        txtborrowBookAuthor.setText("");
                        txtborrowBookPublisher.setText("");
                        txtborrowBookSection.setText("");
                        txtBorrowRCBarcode.setText("");
                        txtbookBorrowName.setText("");
                        txtbookBorrowGender.setText("");
                        txtbookBorrowAddress.setText("");
                        txtbookBorrowType.setText("");
                        daterequired.setDateFormatString("");
                        copies.setText("");
                    } else {
                        a = Integer.toString(--access);
                        copy = a;
                        copies.setText(copy);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            txtborrowBookBarcode.getText();
            txtborrowBookTitle.getText();
            txtborrowBookAuthor.getText();
            txtborrowBookPublisher.getText();
            txtborrowBookSection.getText();
            copies.getText();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_txtborrowBookBarcodeActionPerformed

    private void txtborrowBookAccNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtborrowBookAccNoKeyReleased
         String accession = txtborrowBookAccNo.getText();
        try {
            String query = "SELECT * FROM `tbl_bookaccessions` WHERE accessID='" + accession + "'";
            ResultSet rs;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                    String access = rs.getString("accessID");
                    txtborrowBookAccNo.setText(access);

                    String barcode = rs.getString("ISBNBarcode");
                    txtborrowBookBarcode.setText(barcode);

                    String title = rs.getString("BookTitle");
                    txtborrowBookTitle.setText(title);

                    String author = rs.getString("BookAuthor");
                    txtborrowBookAuthor.setText(author);

                    String pubisher = rs.getString("BookPublisher");
                    txtborrowBookPublisher.setText(pubisher);

                    String bindings = rs.getString("BookType");
                    txtborrowBookSection.setText(bindings);

                    String copy = rs.getString("NoCopies");
                    copies.setText(copy);

                    String a = copies.getText();
                    int accesss = Integer.valueOf(a);

                    if (accesss == 0) {
                        JOptionPane.showMessageDialog(null, "Oppss.. The book copies are already borrowed");
                        txtborrowBookBarcode.setText("");
                        txtborrowBookAccNo.setText("");
                        txtborrowBookTitle.setText("");
                        txtborrowBookAuthor.setText("");
                        txtborrowBookPublisher.setText("");
                        txtborrowBookSection.setText("");
                        txtBorrowRCBarcode.setText("");
                        txtbookBorrowName.setText("");
                        txtbookBorrowGender.setText("");
                        txtbookBorrowAddress.setText("");
                        txtbookBorrowType.setText("");
                        daterequired.setDateFormatString("");
                        copies.setText("");
                    } else {
                        a = Integer.toString(--accesss);
                        copy = a;
                        copies.setText(copy);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            txtborrowBookAccNo.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_txtborrowBookAccNoKeyReleased

    private void txtborrowBookAccNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtborrowBookAccNoActionPerformed
        String accession = txtborrowBookAccNo.getText();
        try {
            String query = "SELECT * FROM `tbl_bookaccessions` WHERE accessID='" + accession + "'";
            ResultSet rs;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                    String access = rs.getString("accessID");
                    txtborrowBookAccNo.setText(access);

                    String barcode = rs.getString("ISBNBarcode");
                    txtborrowBookBarcode.setText(barcode);

                    String title = rs.getString("Title");
                    txtborrowBookTitle.setText(title);

                    String author = rs.getString("Author");
                    txtborrowBookAuthor.setText(author);

                    String pubisher = rs.getString("Publisher");
                    txtborrowBookPublisher.setText(pubisher);

                    String bindings = rs.getString("BookSection");
                    txtborrowBookSection.setText(bindings);

                    String copy = rs.getString("NoCopies");
                    copies.setText(copy);

                    String a = copies.getText();
                    int accesss = Integer.valueOf(a);

                    if (accesss == 0) {
                        JOptionPane.showMessageDialog(null, "Oppss.. The book copies are already borrowed");
                        txtborrowBookBarcode.setText("");
                        txtborrowBookAccNo.setText("");
                        txtborrowBookTitle.setText("");
                        txtborrowBookAuthor.setText("");
                        txtborrowBookPublisher.setText("");
                        txtborrowBookSection.setText("");
                        txtBorrowRCBarcode.setText("");
                        txtbookBorrowName.setText("");
                        txtbookBorrowGender.setText("");
                        txtbookBorrowAddress.setText("");
                        txtbookBorrowType.setText("");
                        daterequired.setDateFormatString("");
                        copies.setText("");
                    } else {
                        a = Integer.toString(--accesss);
                        copy = a;
                        copies.setText(copy);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            txtborrowBookAccNo.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }//GEN-LAST:event_txtborrowBookAccNoActionPerformed

    private void txtborrowBookAccNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtborrowBookAccNoFocusLost
        availability();
    }//GEN-LAST:event_txtborrowBookAccNoFocusLost

    private void btnsaveinsideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveinsideActionPerformed
        String in = borrowinside.getText();
        String out = borrowoutside.getText();
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
                        if (txtborrowBookBarcode.getText().trim().isEmpty() || txtBorrowRCBarcode.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please Scan the Barcode");
                        } else {

                            String queries = "INSERT INTO `tbl_transaction` VALUES ('" + Global_Variable.transact_id + "','" + txtborrowBookAccNo.getText() + "','" + txtborrowBookBarcode.getText() + "','" + txtBorrowRCBarcode.getText() + "','" + borrowinside.getText() + "')";
                            executesqlQuery(queries, "Transaction Added");

                            try {
                                String queri = "UPDATE `tbl_librarybook` SET  `NoOfCopies` ='" + copies.getText() + "' WHERE  `ISBNBarcode` =" + txtborrowBookBarcode.getText();
                                executesqlQuery(queri, "No of Copies Updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                             try {
                                String queri = "UPDATE `tbl_bookaccessions` SET  `NoOfCopies` ='" + copies.getText() + "' WHERE  `ISBNBarcode` =" + txtborrowBookBarcode.getText();
                                executesqlQuery(queri, "No of Copies Updated");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            try {
                                String querya = "INSERT INTO `tbl_borrowinside` VALUES ('" + Global_Variable.inbookId + "','" + books.getText() + "','" + txtborrowBookAccNo.getText() + "','" + txtborrowBookBarcode.getText() + "','" + copies.getText() + "','" + txtBorrowRCBarcode.getText() + "','" + labelDate.getText() + "','" + labeltime.getText() + "')";
                                executesqlQuery(querya, "Book Borrowed");

                                txtborrowBookBarcode.setText("");
                                txtborrowBookAccNo.setText("");
                                txtborrowBookTitle.setText("");
                                txtborrowBookAuthor.setText("");
                                txtborrowBookPublisher.setText("");
                                txtborrowBookSection.setText("");
                                txtBorrowRCBarcode.setText("");
                                txtbookBorrowName.setText("");
                                txtbookBorrowGender.setText("");
                                txtbookBorrowAddress.setText("");
                                txtbookBorrowType.setText("");
                                daterequired.setDateFormatString("");
                                copies.setText("");

                                txtborrowBookBarcode.setEnabled(false);
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


    }//GEN-LAST:event_btnsaveinsideActionPerformed

    private String validatebookType() {
        Statement st;
        String id = "";
        ResultSet rs;
        String query;
        try {
            query = "select * from `tbl_bookaccessions` where accessID='" + txtborrowBookAccNo.getText() + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("accessID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel book;
    private javax.swing.JLabel books;
    private javax.swing.JCheckBox borrowinside;
    private javax.swing.JCheckBox borrowoutside;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnsaveinside;
    private javax.swing.JTextField copies;
    private javax.swing.JLabel cops;
    private com.toedter.calendar.JDateChooser daterequired;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labeltime;
    private javax.swing.JLabel status;
    private javax.swing.JTextField txtBorrowRCBarcode;
    private javax.swing.JTextField txtbookBorrowAddress;
    private javax.swing.JTextField txtbookBorrowGender;
    private javax.swing.JTextField txtbookBorrowName;
    private javax.swing.JTextField txtbookBorrowType;
    private javax.swing.JTextField txtborrowBookAccNo;
    private javax.swing.JTextField txtborrowBookAuthor;
    private javax.swing.JTextField txtborrowBookBarcode;
    private javax.swing.JTextField txtborrowBookPublisher;
    private javax.swing.JTextField txtborrowBookSection;
    private javax.swing.JTextField txtborrowBookTitle;
    // End of variables declaration//GEN-END:variables
    //to validate if barcode doen't exist 
    //Bookbarcode

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

    private String status() {
        String id = "";
        ResultSet rs;

        try {
            String query = "select * from tbl_librarybook where ISBNBarcode =" + txtborrowBookBarcode.getText();
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("Status");
                switch (id) {
                    case "Available":
                        txtBorrowRCBarcode.setEnabled(true);
                        break;
                    case "Damaged":
                        JOptionPane.showMessageDialog(null, "Opps.. this book is damaged and cannot be borrowed");
                        txtborrowBookBarcode.setText("");
                        txtborrowBookAccNo.setText("");
                        txtborrowBookTitle.setText("");
                        txtborrowBookAuthor.setText("");
                        txtborrowBookPublisher.setText("");
                        txtborrowBookSection.setText("");

                        break;
                    case "Lost":
                        JOptionPane.showMessageDialog(null, "Its lost!!!");
                        txtborrowBookAccNo.setText("");
                        txtborrowBookBarcode.setText("");
                        txtborrowBookBarcode.setText("");
                        txtborrowBookAccNo.setText("");
                        txtborrowBookTitle.setText("");
                        txtborrowBookAuthor.setText("");
                        txtborrowBookPublisher.setText("");
                        txtborrowBookSection.setText("");
                        break;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    private String availability() {
        Statement st;
        String available = "";
        ResultSet rs;
        String query;
        boolean active = true;
        try {
            query = "select * from `tbl_librarybook` where ISBNBarcode='" + txtborrowBookBarcode.getText() + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                available = rs.getString("Availability");
                if (active == available.equals("YES")) {
                   
                } else {
                    JOptionPane.showMessageDialog(null, "This book is cannot be borrowed outside");
                    txtborrowBookAccNo.setText("");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return available;
    }

    private String getReserved() {
        String reserved = "";

        try {
            String query = "select * from tbl_librarybook where ISBNBarcode =" + txtborrowBookBarcode.getText();
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                reserved = rs.getString("BookType");
                switch (reserved) {
                    case "Reserved":
                        JOptionPane.showMessageDialog(null, "Opps.. this book is reserved");
                        break;
                    case "Thesis":
                        JOptionPane.showMessageDialog(null, "Opps.. this book is a thesis, cannot be borrowed outside");
                        txtborrowBookBarcode.setText("");
                        txtborrowBookAccNo.setText("");
                        txtborrowBookTitle.setText("");
                        txtborrowBookAuthor.setText("");
                        txtborrowBookPublisher.setText("");
                        txtborrowBookSection.setText("");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reserved;
    }

}
