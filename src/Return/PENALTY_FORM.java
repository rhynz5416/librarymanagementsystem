package Return;

import Global_Variable.Global_Variable;
import Module.dbConn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PENALTY_FORM extends javax.swing.JFrame {

    Global_Variable global = new Global_Variable();
    ResultSet rs = null;
    Statement st = null;
    dbConn con = new dbConn();

    public PENALTY_FORM() {
        initComponents();
        penalty.setText("2");

        try {
            Date l = null, a = null, b = null;
            ResultSet rs = null;
            String query = "SELECT `date_to_return` FROM `tbl_borrowoutside` where category_id ='" + Global_Variable.category_id + "'";
            SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
            Calendar now = Calendar.getInstance();
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            try {
                if (rs.next()) {
                    //to display the data inside the txtfields
                    String dates = rs.getString("date_to_return");
                    String date = rs.getString("date_to_return");
                    datepenalty.setText(date);
                    //   String barcode = rs.getString("ClientBarcode");
                    //   rcBarcode.setText(barcode);

                    String dateafter = now.get(Calendar.MONTH) + 1 + "-" + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR);
                    redate.setText(dateafter);
                   /* l = s.parse(date);

                    a = s.parse(dateafter);
                    if (dates == date) {
                        String penal = penalty.getText();
                        int pe = Integer.parseInt(penal);
                        String ts = Integer.toString(pe);
                        penalty.setText(ts);
                    } else if (l.getTime() < a.getTime()) {
                        String penal = penalty.getText();
                        int pe = Integer.parseInt(penal);
                        int total;
                        total = pe + 1;
                        String t = Integer.toString(total);
                        penalty.setText(t);
                    }*/
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {
            Logger.getLogger(PENALTY_FORM.class.getName()).log(Level.SEVERE, null, ex);
        }
        //  dbConn con = new dbConn();
      /*  String query = "SELECT `date_to_return` FROM `tbl_returnoutside` where category_id ='"+Global_Variable.category_id+"'";

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
         //currentdate
         b = s.parse(dates);
         //db
         l = s.parse(datereturns);

         a = s.parse(dateafter);

         now.add(Calendar.DATE, -1);
         datepenalty.setText(dates);
         //current date
         redate.setText(dates);
         now.add(Calendar.DATE, -1);
         long answer = l.getTime() - a.getTime();
         String answers = Long.toString(answer);
         //  long answer = l.getTime() - a.getTime();
         // String answers = Long.toString(answer);

         // JOptionPane.showMessageDialog(null, dateafter);
        

         } else if (l.getTime() < a.getTime()) {
         String penal = penalty.getText();
         int pe = Integer.parseInt(penal);
         int total;
         total = pe + 1;
         String t = Integer.toString(total);
         penalty.setText(t);

         }

         } catch (Exception e) {
         e.printStackTrace();
         }
         }
         } catch (Exception e) {

         }*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        penalty = new javax.swing.JTextField();
        payment = new javax.swing.JTextField();
        changed = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        datepenalty = new javax.swing.JTextField();
        redate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel1.setText("Changed:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(90, 150, 70, 30);

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel7.setText("Payment:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(90, 100, 80, 30);

        penalty.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        penalty.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        penalty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penaltyActionPerformed(evt);
            }
        });
        jPanel1.add(penalty);
        penalty.setBounds(170, 50, 90, 30);

        payment.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        payment.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        payment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paymentKeyReleased(evt);
            }
        });
        jPanel1.add(payment);
        payment.setBounds(170, 100, 90, 30);

        changed.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        changed.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(changed);
        changed.setBounds(170, 150, 90, 30);

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
        btnSave.setBounds(150, 210, 90, 30);

        jLabel8.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel8.setText("Date of Penalty:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(50, 10, 110, 40);

        jLabel9.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel9.setText("Penalty:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(100, 50, 60, 30);

        datepenalty.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        datepenalty.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(datepenalty);
        datepenalty.setBounds(170, 10, 120, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 80, 360, 270);

        redate.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        redate.setText("Date: ");
        redate.setToolTipText("");
        getContentPane().add(redate);
        redate.setBounds(10, 10, 150, 20);

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel3.setText("PENALTY FORM");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(150, 30, 150, 20);

        setSize(new java.awt.Dimension(436, 420));
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
        String query = "INSERT INTO `tbl_penaltyfee`(`id`, `penaltyFee`) VALUES ('" + Global_Variable.penalty_id + "','" + penalty.getText() + "')";
        executesqlQuery(query, "Penalty Fee");
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
            java.util.logging.Logger.getLogger(PENALTY_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PENALTY_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PENALTY_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PENALTY_FORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new PENALTY_FORM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField changed;
    private javax.swing.JTextField datepenalty;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField payment;
    private javax.swing.JTextField penalty;
    private javax.swing.JLabel redate;
    // End of variables declaration//GEN-END:variables
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
}
