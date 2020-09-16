package mainframe;

import Global_Variable.Global_Variable;
import Module.dbConn;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckingForm extends javax.swing.JFrame {

    dbConn con = new dbConn();
    Global_Variable gloval = new Global_Variable();

    public CheckingForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cops = new javax.swing.JLabel();
        txtborrowBookAccNo = new javax.swing.JTextField();
        txtborrowBookBarcode = new javax.swing.JTextField();
        txtborrowBookTitle = new javax.swing.JTextField();
        status = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel4.setText("Accession Barcode: ");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 40, 130, 30);

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel3.setText("ISBN Number:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 80, 90, 30);

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel5.setText("RC Barcode:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(80, 120, 90, 30);

        cops.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        cops.setText("Status:");
        jPanel2.add(cops);
        cops.setBounds(110, 160, 70, 30);

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
        txtborrowBookAccNo.setBounds(170, 40, 100, 30);

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
        txtborrowBookBarcode.setBounds(170, 80, 170, 30);

        txtborrowBookTitle.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtborrowBookTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtborrowBookTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtborrowBookTitleActionPerformed(evt);
            }
        });
        jPanel2.add(txtborrowBookTitle);
        txtborrowBookTitle.setBounds(170, 120, 220, 30);

        status.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        status.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(status);
        status.setBounds(170, 160, 220, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(40, 50, 420, 250);

        setSize(new java.awt.Dimension(532, 409));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtborrowBookTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtborrowBookTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtborrowBookTitleActionPerformed

    private void txtborrowBookBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtborrowBookBarcodeKeyReleased

        txtborrowBookTitle.setEditable(false);
        status.setEditable(false);
    }//GEN-LAST:event_txtborrowBookBarcodeKeyReleased

    private void txtborrowBookBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtborrowBookBarcodeKeyPressed

    }//GEN-LAST:event_txtborrowBookBarcodeKeyPressed

    private void txtborrowBookBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtborrowBookBarcodeActionPerformed

    }//GEN-LAST:event_txtborrowBookBarcodeActionPerformed

    private void txtborrowBookAccNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtborrowBookAccNoKeyReleased
         Statement st = null;
        try {

            String accession = txtborrowBookAccNo.getText();
            String query = "SELECT * FROM `tbl_transaction` WHERE Accession='" + accession + "'and category_id='" + Global_Variable.category_id + "' ";
            ResultSet rs;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {

                //to display the data inside the txtfields
                String barcode = rs.getString("ISBNBarcode");
                txtborrowBookBarcode.setText(barcode);

                String title = rs.getString("RCBarcode");
                txtborrowBookTitle.setText(title);

                String copy = rs.getString("Status");
                status.setText(copy);

                String a = status.getText();
                status.setText(a);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        txtborrowBookBarcode.getText();
        txtborrowBookTitle.getText();
        status.getText();
    }//GEN-LAST:event_txtborrowBookAccNoKeyReleased

    private void txtborrowBookAccNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtborrowBookAccNoActionPerformed
        Statement st = null;
        try {

            String accession = txtborrowBookAccNo.getText();
            String query = "SELECT * FROM `tbl_transaction` WHERE Accession='" + accession + "'and category_id='" + Global_Variable.category_id + "' ";
            ResultSet rs;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {

                //to display the data inside the txtfields
                String barcode = rs.getString("ISBNBarcode");
                txtborrowBookBarcode.setText(barcode);

                String title = rs.getString("RCBarcode");
                txtborrowBookTitle.setText(title);

                String copy = rs.getString("Status");
                status.setText(copy);

                String a = status.getText();
                status.setText(a);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        txtborrowBookBarcode.getText();
        txtborrowBookTitle.getText();
        status.getText();

        
    }//GEN-LAST:event_txtborrowBookAccNoActionPerformed

    private void txtborrowBookAccNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtborrowBookAccNoFocusLost
       
    }//GEN-LAST:event_txtborrowBookAccNoFocusLost

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
            java.util.logging.Logger.getLogger(CheckingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckingForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cops;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField status;
    private javax.swing.JTextField txtborrowBookAccNo;
    private javax.swing.JTextField txtborrowBookBarcode;
    private javax.swing.JTextField txtborrowBookTitle;
    // End of variables declaration//GEN-END:variables
}
