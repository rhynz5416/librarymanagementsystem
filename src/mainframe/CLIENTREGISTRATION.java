package mainframe;

import Module.dbConn;
import connection.Conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import Global_Variable.Global_Variable; 
import java.text.MessageFormat;
import javax.swing.JFrame;
import javax.swing.JTable; 

public class CLIENTREGISTRATION extends javax.swing.JFrame {

    Global_Variable global = new Global_Variable();
    private Vector<Vector<String>> data;
    private Vector<String> header; 
    dbConn con = new dbConn();
    Statement st;

    public CLIENTREGISTRATION() throws Exception {

        Conn connection = new Conn();
        data = connection.getClient();
        header = new Vector<String>();

        header.add("id");
        header.add("ClientBarcode");
        header.add("Name");
        header.add("Gender");
        header.add("ClientType");
        header.add("DateIssued");
        header.add("DateExpired");
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
        txtdateissue.setText(s.format(d));
        SimpleDateFormat sss = new SimpleDateFormat("yyyy/MM/d");
        String dateissue = sss.format(d);
        String data[] = dateissue.split("/");
        int a = Integer.parseInt(data[0]) + 1;
        SimpleDateFormat ss = new SimpleDateFormat("MM-dd-");

        txtexpirydate.setText(ss.format(d) + " " + a);
        tbl_reg.removeColumn(tbl_reg.getColumnModel().getColumn(0));

        txtBarcode.setEnabled(true);
        txtName.setEnabled(false);
        updateDate.setEnabled(false);
        dateofBirth.setEnabled(false);
        comboxGender.setEnabled(false);
        txtAddress.setEnabled(false);
        comboxBorrowType.setEnabled(false);
        comboxCourse.setEnabled(false);
        txtexpirydate.setEnabled(false);
        txtusername.setEnabled(false);
        txtpassword.setEnabled(false);
        txtdateissue.setEnabled(false);
        txtpaymentfee.setEnabled(false);
        txtchange.setEnabled(false);
        txtpaymentReceived.setEnabled(false); 
    }  
    private void executesqlQuery(String query, String message) {
        try {
            st = null;
            st = con.dbconn().createStatement();
            if ((st.executeUpdate(query)) == 1) { 
                Conn connecting = new Conn();
                data = connecting.getClient(); 
                tbl_reg.setModel(new javax.swing.table.DefaultTableModel(data, header));
                tbl_reg.removeColumn(tbl_reg.getColumnModel().getColumn(0));
                JOptionPane.showMessageDialog(null, "Data " + message + " successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Data " + message + ".");
            }
        } catch (Exception ex) { 
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboxBorrowType = new javax.swing.JComboBox();
        txtAddress = new javax.swing.JTextField();
        comboxGender = new javax.swing.JComboBox();
        dateofBirth = new com.toedter.calendar.JDateChooser();
        txtName = new javax.swing.JTextField();
        txtBarcode = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtchange = new javax.swing.JTextField();
        txtpaymentReceived = new javax.swing.JTextField();
        txtpaymentfee = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        txtusername = new javax.swing.JTextField();
        txtexpirydate = new javax.swing.JTextField();
        txtdateissue = new javax.swing.JTextField();
        comboxCourse = new javax.swing.JComboBox();
        updateDate = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnsave = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_reg = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        book = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel2.setText("Client Barcode:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 20, 140, 50);

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel7.setText("Name:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(80, 50, 40, 50);

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel3.setText("Date of Birth:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 90, 100, 30);

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel4.setText("Gender:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 120, 60, 30);

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel5.setText("Address:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 150, 60, 30);

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel6.setText("Client Type:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 180, 110, 30);

        comboxBorrowType.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        comboxBorrowType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BISU Balilihan Student", "Other School Student", "Bisu Balilihan Teacher", "Other School Teacher" }));
        comboxBorrowType.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        comboxBorrowType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboxBorrowTypeItemStateChanged(evt);
            }
        });
        jPanel1.add(comboxBorrowType);
        comboxBorrowType.setBounds(130, 180, 290, 30);

        txtAddress.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtAddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddressKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAddressKeyTyped(evt);
            }
        });
        jPanel1.add(txtAddress);
        txtAddress.setBounds(130, 150, 290, 30);

        comboxGender.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        comboxGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        comboxGender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(comboxGender);
        comboxGender.setBounds(130, 120, 100, 30);

        dateofBirth.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        dateofBirth.setDateFormatString("MM-dd-yyyy");
        dateofBirth.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        dateofBirth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateofBirthKeyReleased(evt);
            }
        });
        jPanel1.add(dateofBirth);
        dateofBirth.setBounds(130, 90, 290, 30);

        txtName.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });
        jPanel1.add(txtName);
        txtName.setBounds(130, 60, 290, 30);

        txtBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBarcode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBarcodeFocusLost(evt);
            }
        });
        txtBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarcodeActionPerformed(evt);
            }
        });
        txtBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyTyped(evt);
            }
        });
        jPanel1.add(txtBarcode);
        txtBarcode.setBounds(130, 30, 290, 30);

        jLabel8.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel8.setText("Course:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(70, 210, 60, 30);

        jLabel9.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel9.setText("Date Issued:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(40, 240, 90, 30);

        jLabel10.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel10.setText("Date Expired:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(30, 270, 100, 30);

        jLabel17.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel17.setText("Username:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(50, 300, 80, 30);

        jLabel12.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel12.setText("Password:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(50, 330, 80, 30);

        jLabel16.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel16.setText("Registration Fee:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(40, 350, 110, 50);

        jLabel13.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel13.setText("Payment Received:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(30, 390, 130, 40);

        jLabel15.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel15.setText("Change:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(100, 420, 60, 30);

        txtchange.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtchange.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtchangeActionPerformed(evt);
            }
        });
        jPanel1.add(txtchange);
        txtchange.setBounds(160, 420, 130, 30);

        txtpaymentReceived.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtpaymentReceived.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtpaymentReceived.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpaymentReceivedKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpaymentReceivedKeyTyped(evt);
            }
        });
        jPanel1.add(txtpaymentReceived);
        txtpaymentReceived.setBounds(160, 390, 130, 30);

        txtpaymentfee.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtpaymentfee.setText("10.00");
        txtpaymentfee.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtpaymentfee);
        txtpaymentfee.setBounds(160, 360, 130, 30);

        txtpassword.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtpassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtpassword);
        txtpassword.setBounds(130, 330, 290, 30);

        txtusername.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtusername.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtusername);
        txtusername.setBounds(130, 300, 290, 30);

        txtexpirydate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtexpirydate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtexpirydate);
        txtexpirydate.setBounds(130, 270, 290, 30);

        txtdateissue.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtdateissue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtdateissue);
        txtdateissue.setBounds(130, 240, 290, 30);

        comboxCourse.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        comboxCourse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----", "BS Information Technology", "BS Computer Science", "BS Electrical", "BS Electronix", "BS Food Technology", "Grade 11", "Grade 12" }));
        comboxCourse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(comboxCourse);
        comboxCourse.setBounds(130, 210, 290, 30);

        updateDate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        updateDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        updateDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateDateMouseClicked(evt);
            }
        });
        updateDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                updateDateKeyReleased(evt);
            }
        });
        jPanel1.add(updateDate);
        updateDate.setBounds(130, 90, 190, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(220, 120, 480, 490);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

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
        btnsave.setBounds(30, 20, 90, 40);

        btnedit.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_b_edit.png"))); // NOI18N
        btnedit.setText("EDIT");
        btnedit.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneditMouseClicked(evt);
            }
        });
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        btnedit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btneditKeyReleased(evt);
            }
        });
        jPanel2.add(btnedit);
        btnedit.setBounds(140, 20, 90, 40);

        btndelete.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_b_empty.png"))); // NOI18N
        btndelete.setText("DELETE");
        btndelete.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btndelete);
        btndelete.setBounds(250, 20, 90, 40);

        btnclear.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_drop.png"))); // NOI18N
        btnclear.setText("CLEAR");
        btnclear.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        jPanel2.add(btnclear);
        btnclear.setBounds(360, 20, 90, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(220, 650, 480, 80);

        tbl_reg.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        tbl_reg.setModel(new javax.swing.table.DefaultTableModel(data,header));
        tbl_reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_regMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_reg);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(840, 220, 790, 390);

        jLabel14.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_search.png"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(1030, 170, 40, 30);

        txtSearch.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch);
        txtSearch.setBounds(1060, 170, 200, 30);

        btnPrint.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrint);
        btnPrint.setBounds(1280, 170, 100, 30);

        book.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        book.setText("Client Registration");
        getContentPane().add(book);
        book.setBounds(20, 10, 300, 40);

        setSize(new java.awt.Dimension(1684, 875));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboxBorrowTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboxBorrowTypeItemStateChanged
        switch (comboxBorrowType.getSelectedItem().toString()) {
            case "BISU Balilihan Student":
                comboxCourse.setEnabled(true);
                break;
            case "Bisu Balilihan Teacher":
                comboxCourse.setEnabled(false);
                break; 
            case "Other School Student":
                OUTSIDE_STUDENT student = new OUTSIDE_STUDENT();
                student.setVisible(true);
                break;
            case "Other School Teacher":
                OUTSIDE_TEACHER teacher = new OUTSIDE_TEACHER();
                teacher.setVisible(true);
                break;
            default:
                comboxCourse.setEnabled(false);
                break;
        } 
    }//GEN-LAST:event_comboxBorrowTypeItemStateChanged

    private void txtAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyReleased

    }//GEN-LAST:event_txtAddressKeyReleased

    private void txtAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyTyped

    }//GEN-LAST:event_txtAddressKeyTyped

    private void dateofBirthKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateofBirthKeyReleased

    }//GEN-LAST:event_dateofBirthKeyReleased

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        int i = evt.getKeyChar();
        if (!(i < '0' || i > '9')) {
            txtName.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");
        }
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped

    }//GEN-LAST:event_txtNameKeyTyped

    private void txtBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarcodeActionPerformed
        if (validateRCBarcode(txtBarcode.getText())) {
            JOptionPane.showMessageDialog(null, "This barcode is cannot be used for registration.");
            txtBarcode.setText("");
        } else {
            txtName.setEnabled(true);
            dateofBirth.setEnabled(true);
            comboxGender.setEnabled(true);
            txtAddress.setEnabled(true);
            comboxBorrowType.setEnabled(true);
            comboxCourse.setEnabled(true);
            txtdateissue.setEditable(false);
            txtexpirydate.setEditable(false); 
        }
    }//GEN-LAST:event_txtBarcodeActionPerformed

    private void txtBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyReleased
        if (validateBarcode(txtBarcode.getText())) {
            JOptionPane.showMessageDialog(null, "Duplicate barcode!");
        } 
        txtBarcode.setEnabled(true);
        txtName.setEnabled(true);
        dateofBirth.setEnabled(true);
        comboxGender.setEnabled(true);
        txtAddress.setEnabled(true);
        comboxBorrowType.setEnabled(true);
        comboxCourse.setEnabled(true);
        txtdateissue.setEnabled(true);
        txtexpirydate.setEnabled(true);
        txtusername.setEnabled(true);
        txtpassword.setEnabled(true);
        txtpaymentfee.setEnabled(true);
        txtchange.setEnabled(true);
        txtpaymentReceived.setEnabled(true);
    }//GEN-LAST:event_txtBarcodeKeyReleased

    private void txtBarcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyTyped

    }//GEN-LAST:event_txtBarcodeKeyTyped

    private void txtchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtchangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtchangeActionPerformed

    private void txtpaymentReceivedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpaymentReceivedKeyReleased
        //for the payment
        double pay, fee, changed;
        pay = Double.parseDouble(txtpaymentReceived.getText());
        fee = Double.parseDouble(txtpaymentfee.getText());
        if (pay > 9) {
            changed = pay - fee;
            String ch;
            ch = changed + "";
            txtchange.setText(ch);
        } else {
            txtchange.setText("");
        }
    }//GEN-LAST:event_txtpaymentReceivedKeyReleased

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String temp1 = txtSearch.getText() + "%";
        data = theSearch("Select * from tbl_clientregistration where ClientBarcode like '" + temp1 + "' || Name like '" + temp1 + "'|| ClientType like '" + temp1 + "'|| Gender like '" + temp1 + "'|| Course like '" + temp1 + "'");
        tbl_reg.setModel(new javax.swing.table.DefaultTableModel(data, header));
    tbl_reg.removeColumn(tbl_reg.getColumnModel().getColumn(0));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        if (txtBarcode.getText().trim().isEmpty() || txtName.getText().trim().isEmpty() || dateofBirth.getDateFormatString().trim().isEmpty() || txtAddress.getText().trim().isEmpty() || txtdateissue.getText().trim().isEmpty() || txtexpirydate.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty");
        } else { 
            String tempisbn = txtBarcode.getText();
            SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
            String birthday = s.format(dateofBirth.getDate());

            String q = "INSERT INTO `tbl_clientregistration` VALUES ('" + Global_Variable.client_id + "','" + tempisbn + "','" + txtName.getText() + "','" + birthday + "','" + comboxGender.getSelectedItem() + "','" + txtAddress.getText() + "','" + comboxBorrowType.getSelectedItem() + "','" + comboxCourse.getSelectedItem() + "','" + txtdateissue.getText() + "','" + txtexpirydate.getText() + "','" + txtusername.getText() + "','" + txtpassword.getText() + "')";
            executesqlQuery(q, "added");

            txtBarcode.setText("");
            txtName.setText("");
            dateofBirth.setDateFormatString("");
            comboxGender.setSelectedItem("");
            txtAddress.setText("");
            comboxBorrowType.setSelectedItem("");
            comboxCourse.setSelectedItem("");
            txtexpirydate.setText("");
            txtusername.setText("");
            txtpassword.setText("");
            txtdateissue.setText("");
            txtpaymentReceived.setText("");
            txtchange.setText("");

            txtBarcode.setEnabled(true);
            txtName.setEnabled(false);
            updateDate.setEnabled(false);
            dateofBirth.setEnabled(false);
            comboxGender.setEnabled(false);
            txtAddress.setEnabled(false);
            comboxBorrowType.setEnabled(false);
            comboxCourse.setEnabled(false);
            txtexpirydate.setEnabled(false);
            txtusername.setEnabled(false);
            txtpassword.setEnabled(false);
            txtdateissue.setEnabled(false);
            txtpaymentReceived.setEnabled(false);
            txtchange.setEnabled(false);
            txtpaymentfee.setEnabled(false);
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed

        dateofBirth.hide();
        txtBarcode.setEnabled(false);
        txtName.setEnabled(true);
        updateDate.setEnabled(true);
        comboxGender.setEnabled(true);
        txtAddress.setEnabled(true);
        comboxBorrowType.setEnabled(true);
        comboxCourse.setEnabled(true);
        txtexpirydate.setEnabled(true);
        txtusername.setEnabled(true);
        txtpassword.setEnabled(true);

        try {
            String query = "UPDATE `tbl_clientregistration` SET `ClientBarcode`='" + txtBarcode.getText() + "', `Name`='" + txtName.getText() + "',`DateofBirth`='" + updateDate.getText() + "',`Gender`='" + comboxGender.getSelectedItem() + "',`Address`='" + txtAddress.getText() + "',`ClientType`='" + comboxBorrowType.getSelectedItem() + "',`Course`='" + comboxCourse.getSelectedItem() + "',`DateIssued`='" + txtdateissue.getText() + "',`DateExpired`='" + txtexpirydate.getText() + "' WHERE ClientBarcode =" + txtBarcode.getText();
            executesqlQuery(query, "Updated");
            btnsave.setEnabled(true);
            btndelete.setEnabled(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        String query = "DELETE FROM `tbl_clientregistration` WHERE ClientBarcode = " + txtBarcode.getText();
        executesqlQuery(query, "Deleted");
        txtBarcode.setText("");
        txtName.setText("");
        dateofBirth.setDateFormatString("");
        comboxGender.setSelectedItem("");
        txtAddress.setText("");
        comboxBorrowType.setSelectedItem("");
        comboxCourse.setSelectedItem("");
        txtexpirydate.setText("");
        txtusername.setText("");
        txtpassword.setText("");
        txtdateissue.setText("");
        txtpaymentReceived.setText("");
        txtchange.setText("");
        updateDate.setText("");
        
        comboxCourse.setEnabled(false);
        updateDate.setEnabled(false);
         txtBarcode.setEnabled(true);
        txtName.setEnabled(false);
        updateDate.setEnabled(false);
        comboxGender.setEnabled(false);
        txtAddress.setEnabled(false);
        comboxBorrowType.setEnabled(false);
        comboxCourse.setEnabled(false);
        txtexpirydate.setEnabled(false);
        txtusername.setEnabled(false);
        txtpassword.setEnabled(false);
        txtdateissue.setEnabled(false);
        comboxCourse.setEnabled(false);
        txtpaymentfee.setEnabled(false);
        txtpaymentReceived.setEnabled(false);
        txtchange.setEnabled(false);
        
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        txtBarcode.setText("");
        txtName.setText("");
        dateofBirth.setDateFormatString("");
        comboxGender.setSelectedItem("");
        txtAddress.setText("");
        comboxBorrowType.setSelectedItem("");
        comboxCourse.setSelectedItem("");
        txtexpirydate.setText("");
        updateDate.setText("");
        txtusername.setText("");
        txtpassword.setText("");
        txtdateissue.setText("");
        txtpaymentReceived.setText("");
        txtchange.setText("");
    }//GEN-LAST:event_btnclearActionPerformed

    private void tbl_regMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_regMouseClicked
        
        updateDate.show();
        dateofBirth.hide();

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        
        updateDate.setEnabled(true);
        comboxCourse.setEnabled(true);
        txtBarcode.setEnabled(true);
        txtName.setEnabled(true);
        updateDate.setEnabled(true);
        comboxGender.setEnabled(true);
        txtAddress.setEnabled(true);
        comboxBorrowType.setEnabled(true);
        comboxCourse.setEnabled(true);
        txtexpirydate.setEnabled(true);
        txtusername.setEnabled(true);
        txtpassword.setEnabled(true);
        txtdateissue.setEnabled(true);
        comboxCourse.setEnabled(true);
        txtpaymentfee.setEnabled(true);
        txtpaymentReceived.setEnabled(true);
        txtchange.setEnabled(true); 
        
        try {
            int row = tbl_reg.getSelectedRow();
            String cell_click = (tbl_reg.getModel().getValueAt(row, 1).toString());

            String query = "Select * from tbl_clientregistration where ClientBarcode = '" + cell_click + "'";

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.prepareStatement(query);
            rs = st.executeQuery(query);

            // SimpleDateFormat s = new SimpleDateFormat("yyyy MMM d");
            if (rs.next()) {
                //to display the data inside the txtfields
                String barcode = rs.getString("ClientBarcode");
                txtBarcode.setText(barcode);

                String name = rs.getString("Name");
                txtName.setText(name);

                String bday = rs.getString("DateOfBirth");
                updateDate.setText(bday);

                String gender = rs.getString("Gender");
                comboxGender.setSelectedItem(gender);

                String address = rs.getString("Address");
                txtAddress.setText(address); 
                
                String type = rs.getString("ClientType");
                comboxBorrowType.setSelectedItem(type);
                if(type == "Other School Student"){
                    OUTSIDE_STUDENT student = new OUTSIDE_STUDENT();
                    student.hide();
                }else if(type == "Other School Teacher"){
                    OUTSIDE_TEACHER teacher = new OUTSIDE_TEACHER();
                    teacher.hide();
                }  

                String issued = rs.getString("DateIssued");
                txtdateissue.setText(issued);

                String expired = rs.getString("DateExpired");
                txtexpirydate.setText(expired);

                String username = rs.getString("Username");
                txtusername.setText(username);

                String pass = rs.getString("Password");
                txtpassword.setText(pass);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbl_regMouseClicked

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        MessageFormat header = new MessageFormat("Client Registration Reports");
        MessageFormat footer = new MessageFormat("page{0,number,integer}"); 
        try {
            tbl_reg.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("can not print %s %n", e.getMessage());
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void updateDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateDateKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_updateDateKeyReleased

    private void updateDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateDateMouseClicked
        dateofBirth.show();
        updateDate.hide();
        dateofBirth.setEnabled(true);
    }//GEN-LAST:event_updateDateMouseClicked

    private void txtBarcodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBarcodeFocusLost

    }//GEN-LAST:event_txtBarcodeFocusLost

    private void btneditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseClicked


    }//GEN-LAST:event_btneditMouseClicked

    private void btneditKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btneditKeyReleased

    }//GEN-LAST:event_btneditKeyReleased

    private void txtpaymentReceivedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpaymentReceivedKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Cannot input letters");

        }
    }//GEN-LAST:event_txtpaymentReceivedKeyTyped

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    /*  private void theQuery(String query) {
     Connection con;
     Statement st;

     try {

     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagesystem?zeroDateTimeBehavior=convertToNull", "root", "");
     st = con.createStatement();
     st.executeUpdate(query);
     // JOptionPane.showMessageDialog(this,"Data added Successfully");

     txtName.setText("");
     dateofBirth.setDateFormatString("");
     comboxGender.setSelectedItem("");
     txtAddress.setText("");
     comboxBorrowType.setSelectedItem("");
     comboxCourse.setSelectedItem("");
     txtusername.setText("");
     txtpassword.setText(" ");
     txtBarcode.setText("");

     Conn connecting = new Conn();
     data = connecting.getUser();
     //for setting the table for model
     tbl_reg.setModel(new javax.swing.table.DefaultTableModel(data, header));

     tbl_reg.removeColumn(tbl_reg.getColumnModel().getColumn(0));

     } catch (Exception e) {
     JOptionPane.showMessageDialog(this, e.getMessage());
     }
     }*/
    private boolean validateBarcode(String Barcode) {
        boolean queue = false;
        ResultSet rs;
        //String barcode = adminbarcode.getText();
        String query;
        try {
            query = "select id from `tbl_clientregistration` where ClientBarcode='" + Barcode + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                queue = true;
                //rs.getString("adminBarcode");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return queue;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel book;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox comboxBorrowType;
    private javax.swing.JComboBox comboxCourse;
    private javax.swing.JComboBox comboxGender;
    private com.toedter.calendar.JDateChooser dateofBirth;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_reg;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtchange;
    private javax.swing.JTextField txtdateissue;
    private javax.swing.JTextField txtexpirydate;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtpaymentReceived;
    private javax.swing.JTextField txtpaymentfee;
    private javax.swing.JTextField txtusername;
    private javax.swing.JTextField updateDate;
    // End of variables declaration//GEN-END:variables
 
    private Vector<Vector<String>> theSearch(String sqlSearch) {
        Vector<Vector<String>> client = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> Client = new Vector<String>();
                Client.add(rs.getString(1));
                Client.add(rs.getString(2));
                Client.add(rs.getString(3));
                Client.add(rs.getString(5));
                Client.add(rs.getString(7));
                Client.add(rs.getString(9));
                Client.add(rs.getString(10));
                client.add(Client);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return client;
    }

    //to validateRC Barcode
    private boolean validateRCBarcode(String Barcode) {
        boolean queue = false;
        ResultSet rs;
        String query;

        try {
            query = "select * from `tbl_librarybook` where ISBNBarcode='" + Barcode + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                queue = true;
            }
            query = "select * from `tbl_cd` where cd_Barcode='" + Barcode + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                queue = true;
            }
            query = "select * from `tbl_journal` where ISBNBarcode='" + Barcode + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                queue = true;
            }
            query = "select * from `tbl_magazine` where ISBNBarcode='" + Barcode + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                queue = true;
            }
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
}
