package mainframe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Global_Variable.Global_Variable;
import Module.dbConn;
import java.sql.ResultSet;

public class OUTSIDE_STUDENT extends javax.swing.JFrame {
    Statement st=null;
    dbConn con = new dbConn();
    ResultSet rs=null ;
    
    public OUTSIDE_STUDENT() {
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
        jLabel5 = new javax.swing.JLabel();
        schoolname = new javax.swing.JTextField();
        student_type = new javax.swing.JComboBox();
        studentlevel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        student_adviser = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        student_comaker = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel1.setText("Name of School:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 70, 150, 30);

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel3.setText("Type:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 40, 40, 30);

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel5.setText("Co-maker:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 130, 80, 30);

        schoolname.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        schoolname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(schoolname);
        schoolname.setBounds(140, 70, 250, 30);

        student_type.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        student_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elementary", "HighSchool", "College" }));
        student_type.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(student_type);
        student_type.setBounds(140, 40, 180, 30);

        studentlevel.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        studentlevel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(studentlevel);
        studentlevel.setBounds(140, 100, 70, 30);

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel6.setText("Level:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(80, 100, 50, 30);

        student_adviser.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        student_adviser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(student_adviser);
        student_adviser.setBounds(140, 160, 170, 30);

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel7.setText("Adviser:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(70, 160, 80, 30);

        student_comaker.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        student_comaker.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(student_comaker);
        student_comaker.setBounds(140, 130, 170, 30);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        btnSave.setText("OK");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);
        btnSave.setBounds(80, 40, 70, 23);

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear);
        btnClear.setBounds(200, 40, 65, 23);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(40, 270, 350, 0);

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
        btnsave.setBounds(150, 220, 110, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 50, 420, 300);

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel2.setText("OUTSIDE STUDENT");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 10, 180, 30);

        setSize(new java.awt.Dimension(496, 441));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
      
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        student_adviser.setText("");
        student_comaker.setText("");
        student_type.setSelectedItem("");
        studentlevel.setText("");
        schoolname.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
       String query = "INSERT INTO `tbl_student`VALUES ('"+Global_Variable.student_id+"','"+student_type.getSelectedItem()+"','"+schoolname.getText()+"','"+studentlevel.getText()+"','"+student_comaker.getText()+"','"+student_adviser.getText()+"')";
        executesqlQuery(query, "Added");
    }//GEN-LAST:event_btnsaveActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField schoolname;
    private javax.swing.JTextField student_adviser;
    private javax.swing.JTextField student_comaker;
    private javax.swing.JComboBox student_type;
    private javax.swing.JTextField studentlevel;
    // End of variables declaration//GEN-END:variables
}
