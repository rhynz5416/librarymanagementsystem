package mainframe;

import Global_Variable.Global_Variable;
import Module.dbConn; 
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.sql.*;  
public class A_LoginFrame extends javax.swing.JFrame {

    dbConn con = new dbConn();
    Global_Variable global_var = new Global_Variable();
    Statement st = null; 

    public A_LoginFrame() {
        initComponents();
        adminusername.setEnabled(false);
        adminpassword.setEnabled(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        adminbarcode = new javax.swing.JTextField();
        adminpassword = new javax.swing.JPasswordField();
        btnlogin = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        adminusername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        adminbarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        adminbarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        adminbarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adminbarcodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                adminbarcodeKeyTyped(evt);
            }
        });
        jPanel1.add(adminbarcode);
        adminbarcode.setBounds(1100, 350, 190, 30);

        adminpassword.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        adminpassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(adminpassword);
        adminpassword.setBounds(1100, 470, 190, 30);

        btnlogin.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        btnlogin.setText("LOG IN");
        btnlogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnlogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        btnlogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnloginKeyPressed(evt);
            }
        });
        jPanel1.add(btnlogin);
        btnlogin.setBounds(1020, 560, 100, 40);

        jButton4.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jButton4.setText("EXIT");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(1190, 560, 80, 40);

        jLabel2.setBackground(new java.awt.Color(255, 204, 255));
        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel2.setText("Admin Barcode:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(970, 350, 140, 30);

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel3.setText("Password:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(1010, 480, 100, 17);

        jLabel6.setBackground(new java.awt.Color(255, 204, 255));
        jLabel6.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel6.setText("Username:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(1010, 410, 110, 30);

        adminusername.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        adminusername.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(adminusername);
        adminusername.setBounds(1100, 410, 190, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_admin.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(640, 320, 720, 301);

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 1, 36)); // NOI18N
        jLabel5.setText("LIBRARY ADMINISTRATOR LOGIN ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(670, 110, 717, 30);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1631, 812));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        if (adminbarcode.getText().trim().isEmpty() || adminusername.getText().trim().isEmpty() || adminpassword.getPassword().toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill up the fields");
        } else {
            login();
        }
    }//GEN-LAST:event_btnloginActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int choice;
        choice = JOptionPane.showConfirmDialog(null, "Do you really want to exit?");

        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else if (choice == JOptionPane.NO_OPTION) {
            this.setVisible(true);
        } else if (choice == JOptionPane.CANCEL_OPTION) {
            this.setVisible(true);
        } else if (choice == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnloginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnloginKeyPressed
        login();
    }//GEN-LAST:event_btnloginKeyPressed

    private void adminbarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminbarcodeKeyReleased
        adminusername.setEnabled(false);
        adminpassword.setEnabled(true); 
        try {
            ResultSet rs = null;
            String tempbarcode = adminbarcode.getText();
            String query = "SELECT * FROM `tbl_login` WHERE adminBarcode = " + tempbarcode;

            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                    //to display the data inside the txtfields
                    String username = rs.getString("Username");
                    adminusername.setText(username);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            adminusername.getText();

        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }//GEN-LAST:event_adminbarcodeKeyReleased

    private void adminbarcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminbarcodeKeyTyped

    }//GEN-LAST:event_adminbarcodeKeyTyped
    private void login() {
        try { 
            st = null;
            st = con.dbconn().createStatement();
            ResultSet rss = st.executeQuery("SELECT id,adminBarcode FROM `tbl_login` WHERE `Username`= '" + adminusername.getText() + "' and Password = '" + String.valueOf(adminpassword.getPassword()) + "'");

            if (rss.next()) {
                global_var.id = rss.getString("id"); 
                global_var.adminBarcode = rss.getString("adminBarcode");

                LibraryMainFrame Lib = new LibraryMainFrame();
                Lib.setVisible(true);
                Lib.setLocationRelativeTo(null); 
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Log in!");
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(A_LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A_LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A_LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A_LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A_LoginFrame().setVisible(true);
            }
        });
    } 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adminbarcode;
    private javax.swing.JPasswordField adminpassword;
    private javax.swing.JTextField adminusername;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
