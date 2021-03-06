package Reports;

import Classes.C_LibraryMaterialBook;
import connection.Conn;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import Global_Variable.Global_Variable;
import Module.dbConn;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ReportFrame extends javax.swing.JFrame { 
    Statement st = null;
    dbConn con = new dbConn();
    ResultSet rs = null;
    private Vector<Vector<String>> data;
    private Vector<String> header; 
    
    public ReportFrame() throws Exception { 
       
        
        initComponents(); 
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
                
    }
      
     public void executeSQlquery(String query, String message) {
        try {
            st = null;
            st = con.dbconn().createStatement();
            if ((st.executeUpdate(query)) == 1) {
                Conn connecting = new Conn();
                data = connecting.getBook();
                //for setting the table for model
                table_book.setModel(new javax.swing.table.DefaultTableModel(data, header));

                table_book.removeColumn(table_book.getColumnModel().getColumn(0)); 
                JOptionPane.showMessageDialog(null, message + " successfully");

            } else {
                JOptionPane.showMessageDialog(null, message + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_book = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        label1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        label1.setText("Library Reports");
        getContentPane().add(label1);
        label1.setBounds(380, 50, 270, 60);

        jDateChooser1.setDateFormatString("MM-dd-yyyy");
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(510, 190, 280, 40);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Book", "Cd", "Journal", "Magazine", "Newspaper" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(70, 190, 280, 40);

        jButton1.setText("LOad");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(500, 280, 110, 40);

        table_book.setFont(new java.awt.Font("Lucida Sans", 1, 12));
        table_book.setModel(new javax.swing.table.DefaultTableModel(data,header));
        table_book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_bookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_book);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 350, 870, 90);

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(890, 180, 110, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // SimpleDateFormat sd = new SimpleDateFormat("MM-dd-yyyy"); 
      //  String dated = sd.format(jDateChooser1.getDate())+ "%"; 
        
       // Date d = new Date();
       // SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
        //jDateChooser1.setDateFormatString(s.format(jDateChooser1.getDate()));
        
       // SimpleDateFormat sss = new SimpleDateFormat("yyyy/MM/d");
       // String dateissue = sss.format(jDateChooser1.getDate());
       // String data[] = dateissue.split("/");
        
       // int a = Integer.parseInt(data[2]);
       // SimpleDateFormat ss = new SimpleDateFormat("MM-dd-"); 
       // txtexpirydate.setText(ss.format(jDateChooser1.getDate()) + " " + a);
        
       // String str = "10-12-2020"; 
       /* ResultSet rs = null;
        Statement st = null; 
        String query = "SELECT * FROM `tbl_librarybook`" ; 
        try {
            st = con.dbconn().prepareStatement(query);
            rs = st.executeQuery(query);

            if (rs.next()) {
                //gkan sa db
                try{
                String dates = rs.getString("DateAcquisition"); 
                String data[] = dates.split("-");
        
                 int a = Integer.parseInt(data[2]); 
                String querys = " Select * from tbl_librarybook where "; // something like Select * from Table where 
                StringBuilder concanatedquery= new StringBuilder(); 
                SimpleDateFormat ss = new SimpleDateFormat("MM-dd-"); 
                concanatedquery.append("DateAcquisition = '"+ss.format(jDateChooser1.getDate())+a+"'");    
                
                querys = querys + concanatedquery.substring(0, concanatedquery.length() ); //4 characters are removed as 'AND  ' will be extra at the end.
                
                 //   concanatedquery.append(data[i]);
               
                String me = querys.toString(); 
                //String me = querys.toString();
                JOptionPane.showMessageDialog(null, me);
              
                // String temp1 = txtsearch.getText() + "%";
              // data = theSearch(me.toString());
                
                
                }catch(Exception e){
                    
                }
                //String datefetch = jDateChooser1.getDateFormatString();
                // String temp1 = txtsearch.getText() + "%";
               // 
              //table_book.setModel(new javax.swing.table.DefaultTableModel(data, header));
               
            }
            
        }catch(Exception w){
        
        }*/ 
       
       /* try {
            java.util.Date date = new SimpleDateFormat("MM-dd-yyyy").parse(((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText());
            java.util.Date date2 = new SimpleDateFormat("MM-dd-yyyy").parse(((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText());
            //Date value1 = jDateChooser1.getDate();
            //Date value2 = jDateChooser2.getDate();
            String sql = "Select * from tbl_librarybook where DateAcquisition between "+date+" and "+date2+"";
            PreparedStatement pst;
            try {
                pst = con.dbconn().prepareStatement(sql);
                pst.setDate(1, new java.sql.Date(date.getMonth()));
                pst.setDate(2, new java.sql.Date(date2.getMonth()));
                rs = pst.executeQuery();
                JOptionPane.showMessageDialog(null, rs);
            } catch (SQLException ex) {
                Logger.getLogger(ReportFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
           // pst = con.dbconn().prepareStatement(sql);
            
        } catch (ParseException ex) {
            Logger.getLogger(ReportFrame.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       // jComboBox1.getSelectedItem().toString();

         SimpleDateFormat sd = new SimpleDateFormat("MM-dd-yyyy"); 
        String dated = sd.format(jDateChooser1.getDate())+ "%"; 
        
        data = theSearch("Select * from tbl_librarybook where DateAcquisition like '" + dated + "'");
        table_book.setModel(new javax.swing.table.DefaultTableModel(data, header));
        table_book.removeColumn(table_book.getColumnModel().getColumn(0)); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void table_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_bookMouseClicked
        
    }//GEN-LAST:event_table_bookMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Connection connect = null;  
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd-yyyy"); 
        String dated = sd.format(jDateChooser1.getDate())+ "%";
        //DateFormat sds = new SimpleDateFormat("MM"); 
        //String dateds = sds.format(jDateChooser1.getDate())+ "%"; 
         
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            String sql = "Select * from tbl_librarybook where DateAcquisition like '" + dated + "'";
            Map param= new HashMap();
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql); 
            
            InputStream file = getClass().getResourceAsStream("/Reports/book.jrxml");
            JasperDesign jasperdesign = JRXmlLoader.load(file);
            jasperdesign.setQuery(newQuery);
            
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperdesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param,connect);
            JasperViewer.viewReport(jasperPrint,false); 
            
            //JasperDesign jd = JRXmlLoader.load(getClass().getResourceAsStream("/Reports/librarybook.jrxml"));
            //String sql = "Select * from tbl_librarybook where DateAcquisition like " + temp + "  ";
            // Map param = new HashMap();
            //JRDesignQuery newQuery = new JRDesignQuery();
            //newQuery.setText(sql);
            //jd.setQuery(newQuery);
            //JasperReport jr = JasperCompileManager.compileReport(jd);
            //JasperPrint jp = JasperFillManager.fillReport(jr, param, connect);
            //JasperViewer.viewReport(jp, false);*/
            // String fileName="./src/Reports/book.jrxml";
            //String filetoFill="./src/Reports/book.jasper";  
            // JasperCompileManager.compileReport(file);
            //Map param= new HashMap();
            //JasperFillManager.fillReport(filetoFill, param, connect);
            //JasperPrint jp=JasperFillManager.fillReport(filetoFill, param,connect);
            // JasperViewer.viewReport(jp,false);
         } catch (Exception e) {
         e.printStackTrace();
         }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        
        Conn connection = new Conn(); 
        header = new Vector<String>(); 
        try {
            data = connection.getBook();
        } catch (Exception ex) {
            Logger.getLogger(ReportFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch (jComboBox1.getSelectedItem().toString()) {
            case "Book":   
                header.add("id");
                header.add("Barcode");
                header.add("Title"); 
                header.add("Copies");
                header.add("Status");
                header.add("Availability");
                
                data = theSearch("Select * from tbl_librarybook");
                table_book.setModel(new javax.swing.table.DefaultTableModel(data, header));
                table_book.removeColumn(table_book.getColumnModel().getColumn(0)); 
              
                break;
            case "Cd":
               header.add("id");
               header.add("Barcode");
               header.add("Title"); 
               header.add("Copies");
               header.add("Status");
               header.add("Availability");

               data = theSearchJorMag("Select * from tbl_journal");
               table_book.setModel(new javax.swing.table.DefaultTableModel(data, header)); 
               table_book.removeColumn(table_book.getColumnModel().getColumn(0));
               break;
            case "Journal":
                header.add("id");
                header.add("Barcode");
                header.add("Title"); 
                header.add("Copies");
                header.add("Status"); 
                header.add("Availability");
                
               data = theSearchJorMag("Select * from tbl_journal");
                table_book.setModel(new javax.swing.table.DefaultTableModel(data, header)); 
                table_book.removeColumn(table_book.getColumnModel().getColumn(0));
                break;
            case "Magazine":
                header.add("id");
                header.add("Barcode");
                header.add("Title"); 
                header.add("Copies");
                header.add("Status");
                header.add("Availability");
                
                data = theSearchJorMag("Select * from tbl_magazine");
                table_book.setModel(new javax.swing.table.DefaultTableModel(data, header));
                table_book.removeColumn(table_book.getColumnModel().getColumn(0));
                break;
            case "Newspaper":
                header.add("id");
                header.add("Barcode");
                header.add("Type");
                header.add("Heading"); 
                header.add("Copies");
                header.add("Status");
                header.add("Availability");
                
                data = theSearch("Select * from tbl_librarynewspaper");
                table_book.setModel(new javax.swing.table.DefaultTableModel(data, header)); 
                table_book.removeColumn(table_book.getColumnModel().getColumn(0));
                break; 
            default:
                jComboBox1.setEnabled(true);
                break;
        }
       
    }//GEN-LAST:event_jComboBox1ItemStateChanged

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
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JTable table_book;
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
                user.add(rs.getString(14));
                user.add(rs.getString(15)); 
                user.add(rs.getString(17));
                useVector.add(user); 
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return useVector;
    }
  
    private Vector<Vector<String>> theSearchJorMag(String sqlSearchJorMag) {
        Vector<Vector<String>> useVectorJorMag = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearchJorMag);

            while (rs.next()) {
                Vector<String> userjormag = new Vector<String>();
                userjormag.add(rs.getString(1));
                userjormag.add(rs.getString(2));
                userjormag.add(rs.getString(4));
                userjormag.add(rs.getString(12));
                userjormag.add(rs.getString(13)); 
                userjormag.add(rs.getString(15));
                useVectorJorMag.add(userjormag); 
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return useVectorJorMag;
    }
     
} 
