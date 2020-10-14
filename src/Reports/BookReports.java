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

public class BookReports extends javax.swing.JFrame { 
    Statement st = null;
    dbConn con = new dbConn();
    ResultSet rs = null;
    private Vector<Vector<String>> data;
    private Vector<String> header; 
    
    public BookReports() throws Exception { 
       
        Conn connections = new Conn();
        data = connections.getBook();
        header = new Vector<String>();
        header.add("id");
        header.add("Barcode");
        header.add("Title"); 
        header.add("Copies");
        header.add("Status");
        header.add("Availability");
        initComponents();  
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        table_book.removeColumn(table_book.getColumnModel().getColumn(0));         
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_book = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchtxt = new javax.swing.JTextField();
        year = new com.toedter.calendar.JYearChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        label1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        label1.setText("Book Reports");
        getContentPane().add(label1);
        label1.setBounds(550, 50, 270, 60);

        jDateChooser1.setDateFormatString("MM-dd-yyyy");
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });
        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyReleased(evt);
            }
        });
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(80, 190, 280, 40);

        jButton1.setText("Load");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(780, 190, 110, 40);

        table_book.setFont(new java.awt.Font("Lucida Sans", 1, 12));
        table_book.setModel(new javax.swing.table.DefaultTableModel(data,header));
        table_book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_bookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_book);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(80, 350, 1080, 300);

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(710, 290, 110, 40);

        jLabel1.setText("Search Date");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 160, 100, 20);

        searchtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchtxtKeyReleased(evt);
            }
        });
        getContentPane().add(searchtxt);
        searchtxt.setBounds(340, 290, 350, 40);

        year.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                yearFocusLost(evt);
            }
        });
        year.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                yearPropertyChange(evt);
            }
        });
        year.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                yearKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                yearKeyTyped(evt);
            }
        });
        getContentPane().add(year);
        year.setBounds(80, 250, 100, 40);

        jDateChooser2.setDateFormatString("MM-dd-yyyy");
        getContentPane().add(jDateChooser2);
        jDateChooser2.setBounds(440, 190, 290, 40);

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
       /*ResultSet rs = null;
        Statement st = null; 
       // SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
       // String datereport = s.format(jDateChooser1.getDate());
        String query = "SELECT * FROM `tbl_librarybook`" ; 
        try {
            st = con.dbconn().prepareStatement(query);
            rs = st.executeQuery(query);

            if (rs.next()) { 
                try{
                String dates = rs.getString("DateAcquisition");  
                 String datas[] = dates.split("-");
                int a = Integer.parseInt(datas[1]); 
                String querys = " Select * from tbl_librarybook where "; // something like Select * from Table where 
                StringBuilder concanatedquery= new StringBuilder(); 
                SimpleDateFormat ss = new SimpleDateFormat("MM-dd-"); 
                 //concanatedquery.append("DateAcquisition = '"+ss.format(jDateChooser1.getDate().getTime())+a+"%"+ "'"); 
                concanatedquery.append("DateAcquisition = '"+ss.format(jDateChooser1.getDate())+a+ "'");
                
                querys = querys + concanatedquery.substring(0, concanatedquery.length() ); 
                JOptionPane.showMessageDialog(null, querys);
                 data = theSearch(querys); 
                table_book.setModel(new javax.swing.table.DefaultTableModel(data, header)); 
                }catch(Exception e){
                    e.printStackTrace();
                }
               
            }
        }catch(Exception e){
            e.printStackTrace();
        } */
         
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd-yyyy"); 
        String datedfrom = sd.format(jDateChooser1.getDate()); 
        String dateto = sd.format(jDateChooser2.getDate()); 


        data=theSearch("Select * from tbl_librarybook where DateAcquisition between '" + datedfrom + "' and '"+dateto+"'");
        table_book.setModel(new javax.swing.table.DefaultTableModel(data, header));
        table_book.removeColumn(table_book.getColumnModel().getColumn(0));
        
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void table_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_bookMouseClicked
        
    }//GEN-LAST:event_table_bookMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Connection connect = null; 
        
        //to print using textsearch
        try{
            if(searchtxt.isFocusable()){
                String txtsearch = searchtxt.getText()+ "%";
                try {
                  connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
                  String sqltext = "Select * from tbl_librarybook where ISBNBarcode like '" + txtsearch + "' || BookTitle like '" + txtsearch + "' || BookAuthor like '"+txtsearch+"' || Type like '"+txtsearch+"' || Status like '"+txtsearch+"' || DateAcquisition like '"+txtsearch+"'";
                  Map paramtext= new HashMap();
                  JRDesignQuery newQuerytext = new JRDesignQuery();
                  newQuerytext.setText(sqltext); 

                  InputStream filetext = getClass().getResourceAsStream("/Reports/book.jrxml");
                  JasperDesign jasperdesigntext = JRXmlLoader.load(filetext);
                  jasperdesigntext.setQuery(newQuerytext);

                  JasperReport jasperReporttext = JasperCompileManager.compileReport(jasperdesigntext);
                  JasperPrint jasperPrinttext = JasperFillManager.fillReport(jasperReporttext, paramtext,connect);
                  JasperViewer.viewReport(jasperPrinttext,false); 

               } catch (Exception e) {
                  e.printStackTrace();
               }
            }
        }catch(Exception e){
            e.printStackTrace();
        } 
        
        //to load and print using jcalendar
        try{
            SimpleDateFormat sd = new SimpleDateFormat("MM-dd-yyyy"); 
            String dated = sd.format(jDateChooser1.getDate())+ "%";
           // String dateto = sd.format(jDateChooser2.getDate())+ "%";
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

            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchtxtKeyReleased
       String txtsearch = searchtxt.getText()+ "%";
       data=theSearch("Select * from tbl_librarybook where ISBNBarcode like '" + txtsearch + "' || BookTitle like '" + txtsearch + "' || BookAuthor like '"+txtsearch+"' || Type like '"+txtsearch+"' || Status like '"+txtsearch+"' ");
       table_book.setModel(new javax.swing.table.DefaultTableModel(data, header));
       table_book.removeColumn(table_book.getColumnModel().getColumn(0));
    }//GEN-LAST:event_searchtxtKeyReleased

    private void yearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearKeyReleased
       
    
    }//GEN-LAST:event_yearKeyReleased

    private void yearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearKeyTyped
      
    }//GEN-LAST:event_yearKeyTyped

    private void yearFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_yearFocusLost
       
    }//GEN-LAST:event_yearFocusLost

    private void yearPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_yearPropertyChange
      // JOptionPane.showMessageDialog(null, "release");
       String yearsearch = year.getYear()+ "%";
       data=theSearch("Select * from tbl_librarybook where Year like '" + yearsearch + "'");
       table_book.setModel(new javax.swing.table.DefaultTableModel(data, header));
       table_book.removeColumn(table_book.getColumnModel().getColumn(0));
    }//GEN-LAST:event_yearPropertyChange

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
      
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jDateChooser1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyReleased
        table_book.removeColumn(table_book.getColumnModel().getColumn(0)); 
    }//GEN-LAST:event_jDateChooser1KeyReleased

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
            java.util.logging.Logger.getLogger(BookReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BookReports().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(BookReports.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JTextField searchtxt;
    private javax.swing.JTable table_book;
    private com.toedter.calendar.JYearChooser year;
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
} 
