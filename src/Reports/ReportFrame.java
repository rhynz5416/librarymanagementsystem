/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import connection.Conn;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rose
 */
public class ReportFrame extends javax.swing.JFrame {
     private Vector<Vector<String>> data;
    private Vector<String> header;
    public ReportFrame() throws Exception {
        initComponents();
        
        Conn connection = new Conn();
        data = connection.getBook();
        header = new Vector<String>(); 

        header.add("id");
        header.add("Barcode");
        header.add("Title");
        header.add("Author"); 
        header.add("Copies");
        header.add("Status");
        header.add("Availability");
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        label1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        label1.setText("Library Reports");
        getContentPane().add(label1);
        label1.setBounds(380, 50, 270, 60);

        jDateChooser1.setDateFormatString("MM dd, yyyy");
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(120, 180, 280, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Book", "Cd", "Journal", "Magazine", "Newspaper" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(510, 170, 280, 40);

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(890, 170, 110, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection connect = null;  
        
         try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
         //JasperDesign jd = JRXmlLoader.load(getClass().getResourceAsStream("/Reports/librarybook.jrxml"));
         //String sql = "Select * from tbl_librarybook where ISBNBarcode like " + temp + "  ";
         // Map param = new HashMap();
         //JRDesignQuery newQuery = new JRDesignQuery();
         //newQuery.setText(sql);
         //jd.setQuery(newQuery);
         //JasperReport jr = JasperCompileManager.compileReport(jd);
         //JasperPrint jp = JasperFillManager.fillReport(jr, param, connect);
         //JasperViewer.viewReport(jp, false);*/
           // String fileName="./src/Reports/book.jrxml";
            //String filetoFill="./src/Reports/book.jasper";
            
            Map param= new HashMap();
            
            InputStream file = getClass().getResourceAsStream("/Reports/book.jrxml");
            JasperDesign jasperdesign = JRXmlLoader.load(file);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperdesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param,connect);
            JasperViewer.viewReport(jasperPrint,false);
            
            // JasperCompileManager.compileReport(file);
            //Map param= new HashMap();
            //JasperFillManager.fillReport(filetoFill, param, connect);
            //JasperPrint jp=JasperFillManager.fillReport(filetoFill, param,connect);
           // JasperViewer.viewReport(jp,false);
         } catch (Exception e) {
         e.printStackTrace();
         }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ReportFrame().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ReportFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
    private Vector<Vector<String>> theSearch(String sqlSearch) {
        Vector<Vector<String>> useVector = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> user = new Vector<String>();
                user.add(rs.getString(1));
                user.add(rs.getString(2));
                user.add(rs.getString(4));
                user.add(rs.getString(5));
                user.add(rs.getString(14));
                user.add(rs.getString(15));
                user.add(rs.getString(16));
                user.add(rs.getString(17));
                useVector.add(user); 
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return useVector;
    } 
}
