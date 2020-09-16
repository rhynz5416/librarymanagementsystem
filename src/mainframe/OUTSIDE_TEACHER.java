package mainframe;

import Global_Variable.Global_Variable;
import Module.dbConn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class OUTSIDE_TEACHER extends javax.swing.JFrame {
Statement st =null;
ResultSet rs = null;
dbConn con = new dbConn();
    public OUTSIDE_TEACHER() {
        initComponents();
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
        jLabel3 = new javax.swing.JLabel();
        teacherschoolname = new javax.swing.JTextField();
        teacher_type = new javax.swing.JComboBox();
        teacherlevel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel1.setText("Name of School:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 40, 150, 30);

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel3.setText("Type:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 70, 50, 30);

        teacherschoolname.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        teacherschoolname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(teacherschoolname);
        teacherschoolname.setBounds(140, 40, 250, 30);

        teacher_type.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        teacher_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elementary", "HighSchool", "College" }));
        teacher_type.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(teacher_type);
        teacher_type.setBounds(140, 70, 180, 30);

        teacherlevel.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        teacherlevel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(teacherlevel);
        teacherlevel.setBounds(140, 100, 70, 30);

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel6.setText("Level:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(90, 100, 50, 30);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        btnSave.setText("OK");
        jPanel2.add(btnSave);
        btnSave.setBounds(24, 34, 70, 23);

        btnUpdate.setText("UPDATE");
        jPanel2.add(btnUpdate);
        btnUpdate.setBounds(140, 30, 73, 23);

        btnClear.setText("CLEAR");
        jPanel2.add(btnClear);
        btnClear.setBounds(250, 30, 65, 23);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(40, 270, 350, 0);

        jButton1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        jButton1.setText("SAVE");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(110, 160, 90, 40);

        jButton2.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_drop.png"))); // NOI18N
        jButton2.setText("CLEAR");
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(240, 160, 90, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 50, 430, 240);

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel2.setText("OUTSIDE TEACHER");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 10, 150, 30);

        setSize(new java.awt.Dimension(486, 363));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        teacher_type.setSelectedItem("");
        teacherlevel.setText("");
        teacherschoolname.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String query = "INSERT INTO `tbl_teacher` VALUES ('"+Global_Variable.teacher_id+"','"+teacherschoolname.getText()+"','"+teacher_type.getSelectedItem()+"','"+teacherlevel.getText()+"')";
        executesqlQuery(query, "Added");
    }//GEN-LAST:event_jButton1ActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox teacher_type;
    private javax.swing.JTextField teacherlevel;
    private javax.swing.JTextField teacherschoolname;
    // End of variables declaration//GEN-END:variables
}
