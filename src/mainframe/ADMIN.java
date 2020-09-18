package mainframe;

import Global_Variable.Global_Variable;
import Module.Data;
import Module.dbConn;
import connection.Conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ADMIN extends javax.swing.JFrame {

    dbConn con = new dbConn();
    Global_Variable global_var = new Global_Variable();
    Statement st = null;
    Data data = new Data();
    private Vector<Vector<String>> datas;
    private Vector<String> headers;

    public ADMIN() throws Exception { 
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
    } 
    @SuppressWarnings("unchecked")

    private void executesqlQuery(String query, String message) {
        try {
            st = null;
            st = con.dbconn().createStatement();
            if ((st.executeUpdate(query)) == 1) {

                Conn connecting = new Conn();
                datas = connecting.gettransaction();
                //for setting the table for model
                tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));

                tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));

                JOptionPane.showMessageDialog(null, "Data " + message + " successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Data " + message + ".");
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtadminbarcode = new javax.swing.JTextField();
        txtadmin = new javax.swing.JTextField();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        btnupdate = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_trans = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        searchTrannsact = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchItem = new javax.swing.JComboBox();
        book = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel5.setText("Admin Barcode:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 50, 130, 30);

        jLabel7.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel7.setText("Admin User:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 90, 87, 30);

        jLabel6.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel6.setText("Username:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(70, 130, 90, 30);

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel3.setText("Password:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 170, 71, 30);

        txtadminbarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtadminbarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtadminbarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadminbarcodeActionPerformed(evt);
            }
        });
        txtadminbarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtadminbarcodeKeyReleased(evt);
            }
        });
        jPanel1.add(txtadminbarcode);
        txtadminbarcode.setBounds(150, 50, 210, 30);

        txtadmin.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtadmin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtadmin);
        txtadmin.setBounds(150, 90, 210, 30);

        txtusername.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtusername.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtusername);
        txtusername.setBounds(150, 130, 210, 30);

        txtpassword.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtpassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtpassword);
        txtpassword.setBounds(150, 170, 210, 30);

        btnupdate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_b_edit.png"))); // NOI18N
        btnupdate.setText("Update");
        btnupdate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnupdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnupdate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnupdateItemStateChanged(evt);
            }
        });
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        btnupdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnupdateKeyPressed(evt);
            }
        });
        jPanel1.add(btnupdate);
        btnupdate.setBounds(90, 330, 90, 40);

        btncancel.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btncancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_drop.png"))); // NOI18N
        btncancel.setText("Cancel");
        btncancel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btncancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btncancel);
        btncancel.setBounds(220, 330, 100, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(330, 170, 390, 410);

        tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas,headers));
        jScrollPane1.setViewportView(tbl_trans);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(850, 300, 660, 280);

        jLabel38.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_search.png"))); // NOI18N
        getContentPane().add(jLabel38);
        jLabel38.setBounds(1020, 250, 60, 30);

        searchTrannsact.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        searchTrannsact.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        searchTrannsact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTrannsactMouseClicked(evt);
            }
        });
        searchTrannsact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTrannsactKeyReleased(evt);
            }
        });
        getContentPane().add(searchTrannsact);
        searchTrannsact.setBounds(1050, 250, 210, 30);

        btnPrint.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnPrint.setContentAreaFilled(false);
        btnPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrint);
        btnPrint.setBounds(1290, 250, 110, 40);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel1.setText("Select to be Search:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1000, 190, 140, 30);

        searchItem.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        searchItem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Borrow_Inside", "Borrow_Outside", "Return_Inside", "Return_Outside", "Material_Monitoring", "Outside_Teacher", "Outside_Student", "Transactions", "Penalty", "Client_Renewed" }));
        searchItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        searchItem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchItemItemStateChanged(evt);
            }
        });
        getContentPane().add(searchItem);
        searchItem.setBounds(1140, 190, 230, 30);

        book.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        book.setText("Admin");
        getContentPane().add(book);
        book.setBounds(20, 10, 150, 40);

        setSize(new java.awt.Dimension(1627, 864));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtadminbarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadminbarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadminbarcodeActionPerformed

    private void txtadminbarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtadminbarcodeKeyReleased
        txtadmin.setEnabled(true);
        txtusername.setEnabled(true);
        txtpassword.setEnabled(true);
        try {
            ResultSet rs = null;

            String tempbarcode = txtadminbarcode.getText();

            String query = "SELECT * FROM `tbl_login` WHERE adminBarcode= " + tempbarcode; 
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                    //to display the data inside the txtfields
                    String barcode = rs.getString("adminBarcode");
                    txtadminbarcode.setText(barcode);

                    String admin = rs.getString("administrator");
                    txtadmin.setText(admin);

                    String username = rs.getString("Username");
                    txtusername.setText(username);

                    String password = rs.getString("Password");
                    txtpassword.setText(password); 
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            txtadminbarcode.getText();
            txtadmin.getText();
            txtusername.getText();
            txtpassword.getText(); 

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_txtadminbarcodeKeyReleased

    private void btnupdateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnupdateItemStateChanged

    }//GEN-LAST:event_btnupdateItemStateChanged

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        String query = "UPDATE `tbl_login` SET `adminBarcode`='" + txtadminbarcode.getText() + "',`administrator`='" + txtadmin.getText() + "',`Username`='" + txtusername.getText() + "',`Password`='" + txtpassword.getText() + "' WHERE adminBarcode='" + txtadminbarcode.getText() + "'";
        executesqlQuery(query, "Update");
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnupdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnupdateKeyPressed

    }//GEN-LAST:event_btnupdateKeyPressed

    private void searchTrannsactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTrannsactMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTrannsactMouseClicked

    private void searchTrannsactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTrannsactKeyReleased
        String temp1 = searchTrannsact.getText() + "%"; 
        switch (searchItem.getSelectedItem().toString()) {
            case "Borrow_Inside":

                datas = getBorrowInside("Select * from tbl_borrowinside where material like '" + temp1 + "'|| ISBNBarcode like '" + temp1 + "' || accession_number like '" + temp1 + "'|| borrower_barcode like '" + temp1 + "'|| date like '" + temp1 + "'|| time like '" + temp1 + "'");
                tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                break;
            case "Borrow_Outside":

                datas = getBorrowOutside("Select * from tbl_borrowoutside where material like '" + temp1 + "'|| ISBNBarcode like '" + temp1 + "' || accession_number like '" + temp1 + "'|| borrower_barcode like '" + temp1 + "'|| date like '" + temp1 + "'|| time like '" + temp1 + "'|| date_to_return like '" + temp1 + "'");
                tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                break;
            case "Return_Inside":

                datas = getReturnInside("Select * from tbl_returninside where borrowid like '" + temp1 + "' || date like '" + temp1 + "'|| time like '" + temp1 + "'");
                tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                break;
            case "Return_Outside":

                datas = getReturnOutside("Select * from tbl_returnoutside where borrow_id like '" + temp1 + "' || date like '" + temp1 + "' || time like '" + temp1 + "'");
                tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                break;
            case "Outside_Teacher":

                datas = getTeacher("Select * from tbl_teacher where NameofSchool like '" + temp1 + "'|| Type like '" + temp1 + "' || Level like '" + temp1 + "'");
                tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                break;
            case "Transactions":

                datas = gettransaction("Select * from tbl_transaction where Accession like '" + temp1 + "'|| ISBNBarcode like '" + temp1 + "' || RCBarcode like '" + temp1 + "'|| Status like '"+temp1+"'");
                tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                break;
            case "Outside_Student":

                datas = getStudent("Select * from tbl_student where NameofSchool like '" + temp1 + "'|| Type like '" + temp1 + "' || Level like '" + temp1 + "'|| Comaker like '" + temp1 + "'|| Adviser like '" + temp1 + "'");
                tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                break;
            case "Material_Monitoring":

                datas = getMatmonitoring("Select * from tbl_matmonitoring where accession like '" + temp1 + "'|| barcode like '" + temp1 + "' || status like '" + temp1 + "'");
                tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                break;
            case "Penalty":

                datas = getPenalty("Select * from tbl_penalty where accession like '" + temp1 + "'|| barcode like '" + temp1 + "' || rcbarcode like '" + temp1 + "'|| name like '" + temp1 + "'|| datereturn like '" + temp1 + "'");
                tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                break;
            case "Client_Renewed":

                datas = getRenewed("Select * from tbl_clientrenewal where  rcbarcode like '" + temp1 + "'|| dateexpired like '" + temp1 + "'|| daterenew like '" + temp1 + "'");
                tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                break;
            default:
                searchItem.setEnabled(false);
                break;
        } 
    }//GEN-LAST:event_searchTrannsactKeyReleased

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

        switch (searchItem.getSelectedItem().toString()) {
            case "Borrow_Inside":

                MessageFormat header = new MessageFormat("Borrow Inside Transaction Reports");
                MessageFormat footer = new MessageFormat("page{0,number,integer}");

                try {
                    tbl_trans.print(JTable.PrintMode.FIT_WIDTH, header, footer);
                } catch (java.awt.print.PrinterException e) {
                    System.err.format("can not print %s %n", e.getMessage());
                }
                break;
            case "Borrow_Outside":

                MessageFormat headers = new MessageFormat("Borrow Outside Transaction Reports");
                MessageFormat footers = new MessageFormat("page{0,number,integer}");

                try {
                    tbl_trans.print(JTable.PrintMode.FIT_WIDTH, headers, footers);
                } catch (java.awt.print.PrinterException e) {
                    System.err.format("can not print %s %n", e.getMessage());
                }
                break;
            case "Return_Inside":

                MessageFormat headera = new MessageFormat("Return Inside Transaction Reports");
                MessageFormat footera = new MessageFormat("page{0,number,integer}");

                try {
                    tbl_trans.print(JTable.PrintMode.FIT_WIDTH, headera, footera);
                } catch (java.awt.print.PrinterException e) {
                    System.err.format("can not print %s %n", e.getMessage());
                }
                break;
            case "Return_Outside":

                MessageFormat headerq = new MessageFormat("Return Outside Transaction Reports");
                MessageFormat footerq = new MessageFormat("page{0,number,integer}");

                try {
                    tbl_trans.print(JTable.PrintMode.FIT_WIDTH, headerq, footerq);
                } catch (java.awt.print.PrinterException e) {
                    System.err.format("can not print %s %n", e.getMessage());
                }
                break;
            case "Outside_Teacher":

                MessageFormat headerx = new MessageFormat("Outside Teacher Registration Reports");
                MessageFormat footerx = new MessageFormat("page{0,number,integer}");

                try {
                    tbl_trans.print(JTable.PrintMode.FIT_WIDTH, headerx, footerx);
                } catch (java.awt.print.PrinterException e) {
                    System.err.format("can not print %s %n", e.getMessage());
                }
                break;
            case "Outside_Student":

                MessageFormat headerc = new MessageFormat("Outside Student Registration Reports");
                MessageFormat footerc = new MessageFormat("page{0,number,integer}");

                try {
                    tbl_trans.print(JTable.PrintMode.FIT_WIDTH, headerc, footerc);
                } catch (java.awt.print.PrinterException e) {
                    System.err.format("can not print %s %n", e.getMessage());
                }
                break;
            case "Material_Monitoring":

                MessageFormat headerv = new MessageFormat(" Material Monitoring Transaction Reports");
                MessageFormat footerv = new MessageFormat("page{0,number,integer}");

                try {
                    tbl_trans.print(JTable.PrintMode.FIT_WIDTH, headerv, footerv);
                } catch (java.awt.print.PrinterException e) {
                    System.err.format("can not print %s %n", e.getMessage());
                }
                break;
            case "Transactions":

                MessageFormat headerb = new MessageFormat("Transaction Reports");
                MessageFormat footerb = new MessageFormat("page{0,number,integer}");

                try {
                    tbl_trans.print(JTable.PrintMode.FIT_WIDTH, headerb, footerb);
                } catch (java.awt.print.PrinterException e) {
                    System.err.format("can not print %s %n", e.getMessage());
                }
                break;
            case "Penalty":

                MessageFormat headerba = new MessageFormat("Penalty Reports");
                MessageFormat footerba = new MessageFormat("page{0,number,integer}");

                try {
                    tbl_trans.print(JTable.PrintMode.FIT_WIDTH, headerba, footerba);
                } catch (java.awt.print.PrinterException e) {
                    System.err.format("can not print %s %n", e.getMessage());
                }
                break;
            case "Client_Renewed":

                MessageFormat headerbaa = new MessageFormat("Client Renewed Reports");
                MessageFormat footerbaa = new MessageFormat("page{0,number,integer}");

                try {
                    tbl_trans.print(JTable.PrintMode.FIT_WIDTH, headerbaa, footerbaa);
                } catch (java.awt.print.PrinterException e) {
                    System.err.format("can not print %s %n", e.getMessage());
                }
                break;
            default:
                searchItem.setEnabled(false);
                break;
        }

    }//GEN-LAST:event_btnPrintActionPerformed

    private void searchItemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchItemItemStateChanged

        switch (searchItem.getSelectedItem().toString()) {
            case "Borrow_Inside":

                try {

                    Conn connections = new Conn();
                    datas = connections.getBorrowInside();
                    headers = new Vector<String>();

                    headers.add("id");
                    headers.add("Material");
                    headers.add("Accession");
                    headers.add("ISBNBarcode");
                    headers.add("RCBarcode");
                    headers.add("Date");
                    headers.add("Time");
                    tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                    tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case "Borrow_Outside":
                try {

                    Conn connections = new Conn();
                    datas = connections.getBorrowOutside();
                    headers = new Vector<String>();

                    headers.add("id");
                    headers.add("Material");
                    headers.add("Accession");
                    headers.add("ISBNBarcode");
                    headers.add("RCBarcode");
                    headers.add("DateReturn");
                    headers.add("Date");
                    headers.add("Time");
                    tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                    tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Return_Inside":
                try {
                    Conn connections = new Conn();
                    datas = connections.getReturnInside();
                    headers = new Vector<String>();

                    headers.add("id");
                    headers.add("BorrowID");
                    headers.add("Date");
                    headers.add("Time");
                    tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                    tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Return_Outside":
                try {
                    Conn connections = new Conn();
                    datas = connections.getReturnOutside();
                    headers = new Vector<String>();

                    headers.add("id");
                    headers.add("BorrowID");
                    headers.add("Date");
                    headers.add("Time");
                    tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                    tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Outside_Teacher":
                try {
                    Conn connections = new Conn();
                    datas = connections.getTeacher();
                    headers = new Vector<String>();

                    headers.add("id");
                    headers.add("Name of School");
                    headers.add("Type");
                    headers.add("Level");
                    tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                    tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Outside_Student":
                try {
                    Conn connections = new Conn();
                    datas = connections.getStudent();
                    headers = new Vector<String>();

                    headers.add("id");
                    headers.add("Type");
                    headers.add("Name of School");
                    headers.add("Level");
                    headers.add("Comaker");
                    headers.add("Adviser");

                    tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                    tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Material_Monitoring":
                try {
                    Conn connections = new Conn();
                    datas = connections.getMatmonitoring();
                    headers = new Vector<String>();

                    headers.add("id");
                    headers.add("Accession");
                    headers.add("Barcode");
                    headers.add("Status");

                    tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                    tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Transactions":
                try {
                    Conn connections = new Conn();
                    datas = connections.gettransaction();
                    headers = new Vector<String>();

                    headers.add("id");
                    headers.add("Accession");
                    headers.add("Barcode");
                    headers.add("RCBarcode");
                    headers.add("Status");

                    tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                    tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Penalty":
                try {
                    Conn connections = new Conn();
                    datas = connections.getPenalty();
                    headers = new Vector<String>();

                    headers.add("id");
                    headers.add("Accession");
                    headers.add("Barcode");
                    headers.add("RCBarcode");
                    headers.add("Name");
                    headers.add("Date Return");

                    tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                    tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Client_Renewed":
                try {
                    Conn connections = new Conn();
                    datas = connections.getRenewed();
                    headers = new Vector<String>();

                    headers.add("id");
                    headers.add("RCBarcode");
                    headers.add("Date Expired");
                    headers.add("Date Renewed");

                    tbl_trans.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
                    tbl_trans.removeColumn(tbl_trans.getColumnModel().getColumn(0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                searchItem.setEnabled(false);
                break;
        }
    }//GEN-LAST:event_searchItemItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel book;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox searchItem;
    private javax.swing.JTextField searchTrannsact;
    private javax.swing.JTable tbl_trans;
    private javax.swing.JTextField txtadmin;
    private javax.swing.JTextField txtadminbarcode;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
     private Vector<Vector<String>> gettransaction(String sqlSearch) {
        Vector<Vector<String>> transact = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> trans = new Vector<String>();
                trans.add(rs.getString(1));
                trans.add(rs.getString(2));
                trans.add(rs.getString(3));
                trans.add(rs.getString(4));
                trans.add(rs.getString(5));
                transact.add(trans);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return transact;
    }

    private Vector<Vector<String>> getBorrowInside(String sqlSearch) {
        Vector<Vector<String>> borrowinside = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> Borrowinside = new Vector<String>();
                Borrowinside.add(rs.getString(1));
                Borrowinside.add(rs.getString(2));
                Borrowinside.add(rs.getString(3));
                Borrowinside.add(rs.getString(4));
                Borrowinside.add(rs.getString(6));
                Borrowinside.add(rs.getString(8));
                Borrowinside.add(rs.getString(9));
                borrowinside.add(Borrowinside);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return borrowinside;
    }

    private Vector<Vector<String>> getBorrowOutside(String sqlSearch) {
        Vector<Vector<String>> borrowoutside = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> Borrowoutside = new Vector<String>();
                Borrowoutside.add(rs.getString(1));
                Borrowoutside.add(rs.getString(2));
                Borrowoutside.add(rs.getString(3));
                Borrowoutside.add(rs.getString(4));
                Borrowoutside.add(rs.getString(5));
                Borrowoutside.add(rs.getString(6));
                Borrowoutside.add(rs.getString(8));
                Borrowoutside.add(rs.getString(9));
                borrowoutside.add(Borrowoutside);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return borrowoutside;
    }

    private Vector<Vector<String>> getReturnInside(String sqlSearch) {
        Vector<Vector<String>> returninside = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> Returninside = new Vector<String>();

                Returninside.add(rs.getString(1));
                Returninside.add(rs.getString(2));
                Returninside.add(rs.getString(3));
                Returninside.add(rs.getString(4));
                returninside.add(Returninside);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return returninside;
    }

    private Vector<Vector<String>> getReturnOutside(String sqlSearch) {
        Vector<Vector<String>> returnoutside = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> Returnoutside = new Vector<String>();

                Returnoutside.add(rs.getString(1));
                Returnoutside.add(rs.getString(2));
                Returnoutside.add(rs.getString(3));
                Returnoutside.add(rs.getString(4));
                returnoutside.add(Returnoutside);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return returnoutside;
    }

    private Vector<Vector<String>> getMatmonitoring(String sqlSearch) {
        Vector<Vector<String>> material = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> Material = new Vector<String>();

                Material.add(rs.getString(1));
                Material.add(rs.getString(2));
                Material.add(rs.getString(3));
                Material.add(rs.getString(4));
                material.add(Material);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return material;
    }

    private Vector<Vector<String>> getTeacher(String sqlSearch) {
        Vector<Vector<String>> teacher = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> Teacher = new Vector<String>();

                Teacher.add(rs.getString(1));
                Teacher.add(rs.getString(2));
                Teacher.add(rs.getString(3));
                Teacher.add(rs.getString(4));
                teacher.add(Teacher);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return teacher;
    }

    private Vector<Vector<String>> getStudent(String sqlSearch) {
        Vector<Vector<String>> student = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> Student = new Vector<String>();

                Student.add(rs.getString(1));
                Student.add(rs.getString(2));
                Student.add(rs.getString(3));
                Student.add(rs.getString(4));
                student.add(Student);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return student;
    }

    private Vector<Vector<String>> getPenalty(String sqlSearch) {
        Vector<Vector<String>> penalty = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> Penalty = new Vector<String>();

                Penalty.add(rs.getString(1));
                Penalty.add(rs.getString(2));
                Penalty.add(rs.getString(3));
                Penalty.add(rs.getString(4));
                Penalty.add(rs.getString(5));
                Penalty.add(rs.getString(6));
                penalty.add(Penalty);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return penalty;
    }

    private Vector<Vector<String>> getRenewed(String sqlSearch) {
        Vector<Vector<String>> renew = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> Renew = new Vector<String>();

                Renew.add(rs.getString(1));
                Renew.add(rs.getString(2));
                Renew.add(rs.getString(3));
                Renew.add(rs.getString(4));
                renew.add(Renew);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return renew;
    }
}
