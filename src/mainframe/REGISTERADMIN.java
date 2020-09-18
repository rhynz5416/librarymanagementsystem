package mainframe;

import Global_Variable.Global_Variable;
import Module.Data;
import Module.dbConn;
import connection.Conn;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class REGISTERADMIN extends javax.swing.JFrame {

    Statement st = null;
    dbConn con = new dbConn();

    private Vector<Vector<String>> data;
    private Vector<String> header;

    public REGISTERADMIN() throws Exception {

        Conn connectin = new Conn();
        data = connectin.getAdmin();
        header = new Vector<String>();

        header.add("id");
        header.add("Barcode");
        header.add("Firstname");
        header.add("Middlename");
        header.add("Lastname");
        header.add("Gender"); 

        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        tbl_adminReg.removeColumn(tbl_adminReg.getColumnModel().getColumn(0));
        adminBarcode.setEnabled(true);
        txtfname.setEnabled(false);
        txtmname.setEnabled(false);
        txtfuname.setEnabled(false);
        txtadd.setEnabled(false);
        txtage.setEnabled(false);
        gender.setEnabled(false);
        txtuser.setEnabled(false);
        pass.setEnabled(false);
        conpass.setEnabled(false); 
    } 
    
    private void executesqlQuery(String query, String message) {
        try {
            st = null;
            st = con.dbconn().createStatement();
            if ((st.executeUpdate(query)) == 1) {

                Conn connecti = new Conn();
                data = connecti.getAdmin();
                //for setting the table for model
                tbl_adminReg.setModel(new javax.swing.table.DefaultTableModel(data, header)); 
                tbl_adminReg.removeColumn(tbl_adminReg.getColumnModel().getColumn(0));

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        txtmname = new javax.swing.JTextField();
        txtadd = new javax.swing.JTextField();
        txtfuname = new javax.swing.JTextField();
        conpass = new javax.swing.JPasswordField();
        pass = new javax.swing.JPasswordField();
        btnsave = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        adminBarcode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtage = new javax.swing.JTextField();
        gender = new javax.swing.JComboBox();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_adminReg = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        book = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADMIN REGISTRATION");
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel2.setText("First Name:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 70, 110, 30);

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel3.setText("Middle Name:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 110, 170, 30);

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel4.setText("Fullname:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 150, 100, 30);

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel5.setText("Age:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(140, 190, 70, 30);

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel6.setText("Address:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(110, 270, 90, 30);

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel7.setText("Username:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(100, 310, 90, 30);

        txtfname.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtfname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfnameActionPerformed(evt);
            }
        });
        txtfname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfnameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfnameKeyTyped(evt);
            }
        });
        jPanel1.add(txtfname);
        txtfname.setBounds(180, 70, 250, 30);

        txtmname.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtmname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtmname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmnameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmnameKeyTyped(evt);
            }
        });
        jPanel1.add(txtmname);
        txtmname.setBounds(180, 110, 250, 30);

        txtadd.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtadd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddActionPerformed(evt);
            }
        });
        jPanel1.add(txtadd);
        txtadd.setBounds(180, 270, 250, 30);

        txtfuname.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtfuname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtfuname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfunameActionPerformed(evt);
            }
        });
        txtfuname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfunameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfunameKeyTyped(evt);
            }
        });
        jPanel1.add(txtfuname);
        txtfuname.setBounds(180, 150, 250, 30);

        conpass.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        conpass.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        conpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                conpassFocusLost(evt);
            }
        });
        conpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                conpassKeyReleased(evt);
            }
        });
        jPanel1.add(conpass);
        conpass.setBounds(180, 390, 190, 30);

        pass.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        pass.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(pass);
        pass.setBounds(180, 350, 190, 30);

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
        jPanel1.add(btnsave);
        btnsave.setBounds(30, 490, 90, 30);

        btnclear.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_drop.png"))); // NOI18N
        btnclear.setText("CLEAR");
        btnclear.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnclear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        jPanel1.add(btnclear);
        btnclear.setBounds(370, 490, 90, 30);

        jLabel8.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel8.setText("Password:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(100, 350, 80, 30);

        txtuser.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtuser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtuser);
        txtuser.setBounds(180, 310, 190, 30);

        jLabel9.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel9.setText("Confim Password:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(50, 390, 130, 30);

        jLabel10.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel10.setText("Admin Barcode:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(70, 30, 110, 30);

        adminBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        adminBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        adminBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adminBarcodeKeyReleased(evt);
            }
        });
        jPanel1.add(adminBarcode);
        adminBarcode.setBounds(180, 30, 180, 30);

        jLabel11.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel11.setText("Gender:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(120, 230, 70, 30);

        txtage.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtageKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtageKeyTyped(evt);
            }
        });
        jPanel1.add(txtage);
        txtage.setBounds(180, 190, 160, 30);

        gender.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FEMALE", "MALE" }));
        gender.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(gender);
        gender.setBounds(180, 230, 120, 30);

        btnDelete.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_b_empty.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);
        btnDelete.setBounds(260, 490, 90, 30);

        btnUpdate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_b_edit.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);
        btnUpdate.setBounds(140, 490, 100, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(310, 130, 490, 550);

        tbl_adminReg.setModel(new javax.swing.table.DefaultTableModel(data,header));
        tbl_adminReg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_adminRegMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_adminReg);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(920, 200, 710, 460);

        jLabel38.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_search.png"))); // NOI18N
        jLabel38.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel38);
        jLabel38.setBounds(1110, 160, 50, 30);

        txtSearch.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch);
        txtSearch.setBounds(1140, 160, 210, 30);

        btnPrint.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrint);
        btnPrint.setBounds(1370, 150, 100, 40);

        book.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        book.setText("Admin Registration");
        getContentPane().add(book);
        book.setBounds(20, 10, 300, 40);

        setSize(new java.awt.Dimension(1728, 954));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddActionPerformed

    private void txtfunameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfunameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfunameActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        if (adminBarcode.getText().trim().isEmpty() || txtadd.getText().trim().isEmpty() || txtage.getText().trim().isEmpty() || txtfname.getText().trim().isEmpty() || txtfuname.getText().trim().isEmpty() || txtmname.getText().trim().isEmpty() || txtuser.getText().trim().isEmpty() || conpass.getPassword().toString().trim().isEmpty() || pass.getPassword().toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Fill up the fields");
        } else {
            String q = "INSERT INTO `tbl_login` VALUES ('" + Global_Variable.log_id + "','" + adminBarcode.getText() + "','" + txtfuname.getText() + "','" + txtuser.getText() + "','" + String.valueOf(conpass.getPassword()) + "')";
            executesqlQuery(q, " Admin Updated");
            try {
                String tempbarcode = adminBarcode.getText();
                String query = "INSERT INTO `tbl_admin` VALUES ('" + Global_Variable.admin_id + "','" + tempbarcode + "','" + txtfname.getText() + "','" + txtmname.getText() + "','" + txtfuname.getText() + "','" + txtage.getText() + "','" + gender.getSelectedItem() + "','" + txtadd.getText() + "','" + txtuser.getText() + "','" + String.valueOf(pass.getPassword().toString()) + "','" + String.valueOf(conpass.getPassword().toString()) + "')";
                executesqlQuery(query, "Admin added");

                adminBarcode.setText("");
                txtfname.setText("");
                txtmname.setText("");
                txtfuname.setText("");
                txtadd.setText("");
                txtage.setText("");
                gender.setSelectedItem("");
                txtuser.setText("");
                pass.setText("");
                conpass.setText("");

                adminBarcode.setEnabled(true);
                txtfname.setEnabled(false);
                txtmname.setEnabled(false);
                txtfuname.setEnabled(false);
                txtadd.setEnabled(false);
                txtage.setEnabled(false);
                gender.setEnabled(false);
                txtuser.setEnabled(false);
                pass.setEnabled(false);
                conpass.setEnabled(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String temp1 = txtSearch.getText() + "%";
        data = theSearch("Select * from tbl_admin where adminBarcode like '" + temp1 + "' || Firstname like '" + temp1 + "'");
        tbl_adminReg.setModel(new javax.swing.table.DefaultTableModel(data, header));
        tbl_adminReg.removeColumn(tbl_adminReg.getColumnModel().getColumn(0));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void conpassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_conpassKeyReleased

    }//GEN-LAST:event_conpassKeyReleased

    private void conpassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_conpassFocusLost
        if (!Arrays.equals(pass.getPassword(), conpass.getPassword())) {
            JOptionPane.showMessageDialog(null, "Password not match");
        }
    }//GEN-LAST:event_conpassFocusLost

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        String temp1 = txtSearch.getText() + "%";
        data = theSearch("Select * from tbl_admin where adminBarcode like '" + temp1 + "' || Firstname like '" + temp1 + "'|| Lastname like '" + temp1 + "'");
        tbl_adminReg.setModel(new javax.swing.table.DefaultTableModel(data, header));
        tbl_adminReg.removeColumn(tbl_adminReg.getColumnModel().getColumn(0));
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String query = "DELETE FROM `tbl_admin` WHERE `adminBarcode` ='" + adminBarcode.getText() + "'";
        executesqlQuery(query, "deleted");

        adminBarcode.setText("");
        txtfname.setText("");
        txtmname.setText("");
        txtfuname.setText("");
        txtadd.setText("");
        txtage.setText("");
        gender.setSelectedItem("");
        txtuser.setText("");
        pass.setText("");
        conpass.setText("");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbl_adminRegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_adminRegMouseClicked
        adminBarcode.setEnabled(true);
        txtfname.setEnabled(true);
        txtmname.setEnabled(true);
        txtfuname.setEnabled(true);
        txtadd.setEnabled(true);
        txtage.setEnabled(true);
        gender.setEnabled(true);
        txtuser.setEnabled(true);
        pass.setEnabled(true);
        conpass.setEnabled(true);

        btnsave.setEnabled(false);
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            int row = tbl_adminReg.getSelectedRow();
            String cell_click = (tbl_adminReg.getModel().getValueAt(row, 1).toString());

            String query = "Select * from tbl_admin where adminBarcode = '" + cell_click + "'";

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.prepareStatement(query);
            rs = st.executeQuery(query); 
            if (rs.next()) {
                //to display the data inside the txtfields
                String barcode = rs.getString("adminBarcode");
                adminBarcode.setText(barcode);

                String firstname = rs.getString("Firstname");
                txtfname.setText(firstname);

                String middle = rs.getString("MiddleName");
                txtmname.setText(middle);

                String last = rs.getString("Lastname");
                txtfuname.setText(last);

                String age = rs.getString("Age");
                txtage.setText(age);

                String genders = rs.getString("Gender");
                gender.setSelectedItem(genders);

                String add = rs.getString("Address");
                txtadd.setText(add);

                String user = rs.getString("Username");
                txtuser.setText(user);

                String passs = rs.getString("Password");
                pass.setText(passs);

                String confirm = rs.getString("ConfirmPass");
                conpass.setText(confirm); 
            } 
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbl_adminRegMouseClicked

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        adminBarcode.setText("");
        txtfname.setText("");
        txtmname.setText("");
        txtfuname.setText("");
        txtadd.setText("");
        txtage.setText("");
        gender.setSelectedItem("");
        txtuser.setText("");
        pass.setText("");
        conpass.setText("");
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        btnsave.setEnabled(true);
        try {
            String q = "UPDATE `tbl_admin` SET `adminBarcode`='" + adminBarcode.getText() + "',`Firstname`='" + txtfname.getText() + "',`MiddleName`='" + txtmname.getText() + "',`Lastname`='" + txtfuname.getText() + "',`Age`='" + txtage.getText() + "',`Gender`='" + gender.getSelectedItem() + "',`Address`='" + txtadd.getText() + "',`Username`='" + txtuser.getText() + "',`Password`='" + String.valueOf(pass.getPassword()) + "',`ConfirmPass`='" + String.valueOf(conpass.getPassword()) + "' WHERE adminBarcode=" + adminBarcode.getText();
            executesqlQuery(q, "Updated");

            adminBarcode.setText("");
            txtfname.setText("");
            txtmname.setText("");
            txtfuname.setText("");
            txtadd.setText("");
            txtage.setText("");
            gender.setSelectedItem("");
            txtuser.setText("");
            pass.setText("");
            conpass.setText("");

            adminBarcode.setEnabled(true);
            txtfname.setEnabled(false);
            txtmname.setEnabled(false);
            txtfuname.setEnabled(false);
            txtadd.setEnabled(false);
            txtage.setEnabled(false);
            gender.setEnabled(false);
            txtuser.setEnabled(false);
            pass.setEnabled(false);
            conpass.setEnabled(false); 
        } catch (Exception e) {
             e.printStackTrace();
        } 
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void adminBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminBarcodeKeyReleased
        adminBarcode.setEnabled(true);
        txtfname.setEnabled(true);
        txtmname.setEnabled(true);
        txtfuname.setEnabled(true);
        txtadd.setEnabled(true);
        txtage.setEnabled(true);
        gender.setEnabled(true);
        txtuser.setEnabled(true);
        pass.setEnabled(true);
        conpass.setEnabled(true);
    }//GEN-LAST:event_adminBarcodeKeyReleased

    private void txtfnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfnameKeyTyped
        int a = evt.getKeyChar();
        if (a == KeyEvent.VK_0 || a == KeyEvent.VK_9) {
            txtfname.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");
        }
    }//GEN-LAST:event_txtfnameKeyTyped

    private void txtageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtageKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Cannot input letters");
        } 
    }//GEN-LAST:event_txtageKeyTyped

    private void txtageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtageKeyReleased
       
    }//GEN-LAST:event_txtageKeyReleased

    private void txtmnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmnameKeyTyped
        int a = evt.getKeyChar();
        if (a == KeyEvent.VK_0 || a == KeyEvent.VK_9) {
            txtmname.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");
        }
    }//GEN-LAST:event_txtmnameKeyTyped

    private void txtfunameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfunameKeyReleased
        int a = evt.getKeyChar();
        if (a == KeyEvent.VK_0 || a == KeyEvent.VK_9) {
            txtfuname.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");
        }
    }//GEN-LAST:event_txtfunameKeyReleased

    private void txtfunameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfunameKeyTyped

    }//GEN-LAST:event_txtfunameKeyTyped

    private void txtfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfnameActionPerformed

    private void txtfnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfnameKeyReleased
        int i = evt.getKeyChar();
        if (!(i < '0' || i > '9')) {
            txtfname.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");
        }
    }//GEN-LAST:event_txtfnameKeyReleased

    private void txtmnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmnameKeyReleased
        int a = evt.getKeyChar();
        if (a == KeyEvent.VK_0 || a == KeyEvent.VK_9) {
            txtmname.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");
        }
    }//GEN-LAST:event_txtmnameKeyReleased

    private Vector<Vector<String>> theSearch(String sqlSearch) {
        Vector<Vector<String>> admin = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null; 
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch); 
            while (rs.next()) {
                Vector<String> Admin = new Vector<String>();

                Admin.add(rs.getString(1));
                Admin.add(rs.getString(2));
                Admin.add(rs.getString(3));
                Admin.add(rs.getString(4));
                Admin.add(rs.getString(5));
                Admin.add(rs.getString(7)); 
                admin.add(Admin);
            }
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return admin;
    } 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adminBarcode;
    private javax.swing.JLabel book;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnsave;
    private javax.swing.JPasswordField conpass;
    private javax.swing.JComboBox gender;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTable tbl_adminReg;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtadd;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtfuname;
    private javax.swing.JTextField txtmname;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
