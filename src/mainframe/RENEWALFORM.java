package mainframe;

import Global_Variable.Global_Variable;
import Module.dbConn;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class RENEWALFORM extends javax.swing.JFrame {
Global_Variable glo = new Global_Variable();
    ResultSet rs = null;
    Statement st = null;
    dbConn con = new dbConn();

    public RENEWALFORM() {
        initComponents();
        penalty.setText("10.00");

        try {

            ResultSet rs = null;
            String query = "SELECT `DateExpired` FROM `tbl_clientregistration` where category_id ='"+Global_Variable.category_id+"'";
            SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
            Calendar now = Calendar.getInstance();
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                    //to display the data inside the txtfields
                    String date = rs.getString("DateExpired");
                    DateExpired.setText(date);
                 //   String barcode = rs.getString("ClientBarcode");
                 //   rcBarcode.setText(barcode);

                    String dateafter = now.get(Calendar.MONTH) + 1 + "-" + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR);
                    CurrentDate.setText(dateafter);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
   

      try {

            ResultSet rs = null;
            String query = "SELECT `ClientBarcode` FROM `tbl_clientregistration`";
           // SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
            //Calendar now = Calendar.getInstance();
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                    //to display the data inside the txtfields
                    String barcode = rs.getString("ClientBarcode");
                    rcBarcode.setText(barcode);
                 //   String barcode = rs.getString("ClientBarcode");
                 //   rcBarcode.setText(barcode);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        penalty = new javax.swing.JTextField();
        payment = new javax.swing.JTextField();
        changed = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CurrentDate = new javax.swing.JTextField();
        DateExpired = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        rcBarcode = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel1.setText("Changed:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 260, 70, 30);

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel7.setText("Payment:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(80, 210, 80, 30);

        penalty.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        penalty.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        penalty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penaltyActionPerformed(evt);
            }
        });
        jPanel1.add(penalty);
        penalty.setBounds(160, 160, 90, 30);

        payment.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        payment.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        payment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paymentKeyReleased(evt);
            }
        });
        jPanel1.add(payment);
        payment.setBounds(160, 210, 90, 30);

        changed.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        changed.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(changed);
        changed.setBounds(160, 260, 90, 30);

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
        jPanel1.add(btnSave);
        btnSave.setBounds(130, 320, 90, 30);

        jLabel8.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel8.setText("RC Barcode:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(50, 110, 100, 30);

        jLabel9.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel9.setText("Date Expired:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(50, 30, 100, 30);

        jLabel10.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel10.setText("Payment Fee:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(50, 160, 100, 30);
        jPanel1.add(CurrentDate);
        CurrentDate.setBounds(160, 70, 130, 30);
        jPanel1.add(DateExpired);
        DateExpired.setBounds(160, 30, 130, 30);

        jLabel11.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel11.setText("Current Date: ");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(50, 70, 100, 30);
        jPanel1.add(rcBarcode);
        rcBarcode.setBounds(160, 110, 130, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 30, 360, 370);

        setSize(new java.awt.Dimension(453, 469));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void penaltyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penaltyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_penaltyActionPerformed

    private void paymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paymentKeyReleased
        double pay, fee, change;
        pay = Double.parseDouble(payment.getText());
        fee = Double.parseDouble(penalty.getText());
        if (pay > 2) {
            change = pay - fee;
            String ch;
            ch = change + "";
            changed.setText(ch);
        } else {
            changed.setText("");
        }
    }//GEN-LAST:event_paymentKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String query = "INSERT INTO `tbl_clientrenewal`(`id`, `rcbarcode`,`dateexpired`,`daterenew`) VALUES ('" + Global_Variable.renewal_id+ "','" + rcBarcode.getText() + "','"+DateExpired.getText()+"','"+CurrentDate.getText()+"')";
        executesqlQuery(query, "Client Renewed");

        String queri = "UPDATE `tbl_clientregistration` SET  `DateExpired` ='" + CurrentDate.getText() + "' WHERE  `ClientBarcode` =" + rcBarcode.getText();
        executesqlQuery(queri, "Client Updated");
        
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(RENEWALFORM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RENEWALFORM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RENEWALFORM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RENEWALFORM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RENEWALFORM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CurrentDate;
    private javax.swing.JTextField DateExpired;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField changed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField payment;
    private javax.swing.JTextField penalty;
    private javax.swing.JTextField rcBarcode;
    // End of variables declaration//GEN-END:variables
}
