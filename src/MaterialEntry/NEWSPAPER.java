package MaterialEntry;

import Accession_Classes.C_NewspaperAccession;
import Classes.C_LibraryMaterialNewspaper;
import Global_Variable.Global_Variable;
import Module.dbConn;
import connection.Conn;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel; 

public class NEWSPAPER extends javax.swing.JFrame { 
    Statement st;
    ResultSet rs;
    dbConn con = new dbConn();
    private Vector<Vector<String>> data;
    private Vector<String> header;

    private Vector<Vector<String>> datas;
    private Vector<String> headers;

    public NEWSPAPER() throws Exception {
        Conn connection = new Conn();
        data = connection.getNewspaper();
        header = new Vector<String>();

        Conn connections = new Conn();
        datas = connections.getNewspaperAccession();
        headers = new Vector<String>();

        header.add("id");
        header.add("ISBNBarcode");
        header.add("Headline"); 
        header.add("Copies");
        header.add("Status");
        header.add("Availability");

        headers.add("id");
        headers.add("accession");
        headers.add("ISBNBarcode");
        initComponents();

        txtaccession.setEnabled(false);
        total.setEditable(false);
        total.setText("0");
        jComboBox_newspaper_Type.setEnabled(false);
        jTextField_N_Heading.setEnabled(false);
        jTextField_N_Volume.setEnabled(false);
        status.setEnabled(false);
        days.setEnabled(false);
        available.setEnabled(false);
        dateNewspaper.setEnabled(false);
        txtnewsBarcode.setEnabled(true);
        updateDte.hide();
        tbl_news.removeColumn(tbl_news.getColumnModel().getColumn(0));
        tbl_searchNews.removeColumn(tbl_searchNews.getColumnModel().getColumn(0));
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
    }   
    //for  newspaper query
    private void executeSqLQuery(String query, String message) {
        try {
            st = null;
            st = con.dbconn().createStatement();
            if ((st.executeUpdate(query)) == 1) {

                Conn connecting = new Conn();
                data = connecting.getNewspaper();
                //for setting the table for model
                tbl_news.setModel(new javax.swing.table.DefaultTableModel(data, header));

                tbl_news.removeColumn(tbl_news.getColumnModel().getColumn(0));

                Conn connectn = new Conn();
                datas = connectn.getNewspaperAccession();
                //for setting the table for model
                tbl_searchNews.setModel(new javax.swing.table.DefaultTableModel(datas, headers));

                tbl_searchNews.removeColumn(tbl_searchNews.getColumnModel().getColumn(0));
                JOptionPane.showMessageDialog(null, message + "successfully");
            } else {
                JOptionPane.showMessageDialog(null, message+ ".");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_searchNews = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        seacrhnews = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jButton_newspaper_save = new javax.swing.JButton();
        jButton_newspaper_edit = new javax.swing.JButton();
        jButton_newspaper_delete = new javax.swing.JButton();
        jButton_newspaper_Clear = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        searchAccess = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        dateNewspaper = new com.toedter.calendar.JDateChooser();
        jTextField_N_Volume = new javax.swing.JTextField();
        jTextField_N_Heading = new javax.swing.JTextField();
        jComboBox_newspaper_Type = new javax.swing.JComboBox();
        txtnewsBarcode = new javax.swing.JTextField();
        updateDte = new javax.swing.JTextField();
        status = new javax.swing.JComboBox();
        days = new javax.swing.JComboBox();
        available = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        txtaccession = new javax.swing.JTextField();
        saveAccess = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_news = new javax.swing.JTable();
        book = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel2.setLayout(null);

        jPanel4.setLayout(null);

        tbl_searchNews.setModel(new javax.swing.table.DefaultTableModel(datas,headers));
        jScrollPane4.setViewportView(tbl_searchNews);

        jPanel4.add(jScrollPane4);
        jScrollPane4.setBounds(1030, 530, 470, 120);

        jLabel47.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_search.png"))); // NOI18N
        jPanel4.add(jLabel47);
        jLabel47.setBounds(1130, 490, 30, 30);

        seacrhnews.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        seacrhnews.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        seacrhnews.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                seacrhnewsKeyReleased(evt);
            }
        });
        jPanel4.add(seacrhnews);
        seacrhnews.setBounds(1130, 160, 280, 30);

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setLayout(null);

        jButton_newspaper_save.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        jButton_newspaper_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        jButton_newspaper_save.setText("Save");
        jButton_newspaper_save.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        jButton_newspaper_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_newspaper_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_newspaper_saveActionPerformed(evt);
            }
        });
        jPanel9.add(jButton_newspaper_save);
        jButton_newspaper_save.setBounds(20, 20, 90, 40);

        jButton_newspaper_edit.setFont(new java.awt.Font("Lucida Fax", 1, 11)); // NOI18N
        jButton_newspaper_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_b_edit.png"))); // NOI18N
        jButton_newspaper_edit.setText("Edit");
        jButton_newspaper_edit.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        jButton_newspaper_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_newspaper_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_newspaper_editActionPerformed(evt);
            }
        });
        jPanel9.add(jButton_newspaper_edit);
        jButton_newspaper_edit.setBounds(130, 20, 90, 40);

        jButton_newspaper_delete.setFont(new java.awt.Font("Lucida Fax", 1, 11)); // NOI18N
        jButton_newspaper_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_b_empty.png"))); // NOI18N
        jButton_newspaper_delete.setText("Delete");
        jButton_newspaper_delete.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        jButton_newspaper_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_newspaper_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_newspaper_deleteActionPerformed(evt);
            }
        });
        jPanel9.add(jButton_newspaper_delete);
        jButton_newspaper_delete.setBounds(230, 20, 100, 40);

        jButton_newspaper_Clear.setFont(new java.awt.Font("Lucida Fax", 1, 11)); // NOI18N
        jButton_newspaper_Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_drop.png"))); // NOI18N
        jButton_newspaper_Clear.setText("Clear");
        jButton_newspaper_Clear.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        jButton_newspaper_Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_newspaper_Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_newspaper_ClearMouseClicked(evt);
            }
        });
        jButton_newspaper_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_newspaper_ClearActionPerformed(evt);
            }
        });
        jPanel9.add(jButton_newspaper_Clear);
        jButton_newspaper_Clear.setBounds(340, 20, 90, 40);

        jPanel4.add(jPanel9);
        jPanel9.setBounds(260, 580, 450, 80);

        jLabel48.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_search.png"))); // NOI18N
        jPanel4.add(jLabel48);
        jLabel48.setBounds(1100, 160, 30, 30);

        searchAccess.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        searchAccess.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        searchAccess.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchAccessKeyReleased(evt);
            }
        });
        jPanel4.add(searchAccess);
        searchAccess.setBounds(1160, 490, 230, 30);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel8.setText("ISBN Barcode:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(80, 50, 100, 40);

        jLabel38.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel38.setText("Newspaper Type:");
        jPanel3.add(jLabel38);
        jLabel38.setBounds(60, 90, 130, 20);

        jLabel9.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel9.setText("Headline:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(110, 110, 80, 40);

        jLabel10.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel10.setText("Volume:");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(120, 140, 80, 40);

        jLabel41.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel41.setText("Date Receive:");
        jPanel3.add(jLabel41);
        jLabel41.setBounds(80, 170, 110, 40);

        label3.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        label3.setText("Status:");
        jPanel3.add(label3);
        label3.setBounds(120, 210, 70, 30);

        jLabel62.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel62.setText("Availability to be borrow outside:");
        jPanel3.add(jLabel62);
        jLabel62.setBounds(30, 270, 240, 30);

        label1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        label1.setText("No of days:");
        jPanel3.add(label1);
        label1.setBounds(90, 240, 80, 30);

        dateNewspaper.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        dateNewspaper.setDateFormatString("MM-dd-yyyy");
        dateNewspaper.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jPanel3.add(dateNewspaper);
        dateNewspaper.setBounds(180, 180, 220, 30);

        jTextField_N_Volume.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jTextField_N_Volume.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField_N_Volume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_N_VolumeActionPerformed(evt);
            }
        });
        jTextField_N_Volume.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_N_VolumeKeyTyped(evt);
            }
        });
        jPanel3.add(jTextField_N_Volume);
        jTextField_N_Volume.setBounds(180, 150, 110, 30);

        jTextField_N_Heading.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jTextField_N_Heading.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextField_N_Heading.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_N_HeadingKeyTyped(evt);
            }
        });
        jPanel3.add(jTextField_N_Heading);
        jTextField_N_Heading.setBounds(180, 120, 220, 30);

        jComboBox_newspaper_Type.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jComboBox_newspaper_Type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bohol Chronicle", "Philippine Daily Inquirer", "Philippine Star", " ", " " }));
        jComboBox_newspaper_Type.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBox_newspaper_Type.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBox_newspaper_TypeKeyTyped(evt);
            }
        });
        jPanel3.add(jComboBox_newspaper_Type);
        jComboBox_newspaper_Type.setBounds(180, 90, 220, 30);

        txtnewsBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtnewsBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtnewsBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnewsBarcodeKeyReleased(evt);
            }
        });
        jPanel3.add(txtnewsBarcode);
        txtnewsBarcode.setBounds(180, 60, 220, 30);

        updateDte.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        updateDte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        updateDte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                updateDteKeyReleased(evt);
            }
        });
        jPanel3.add(updateDte);
        updateDte.setBounds(180, 180, 170, 30);

        status.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Damaged", "Lost" }));
        status.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        status.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statusItemStateChanged(evt);
            }
        });
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel3.add(status);
        status.setBounds(180, 210, 300, 30);

        days.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        days.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---", "5", "4", "3", "2", "1" }));
        days.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(days);
        days.setBounds(180, 240, 90, 30);

        available.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        available.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YES", "NO" }));
        available.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(available);
        available.setBounds(250, 270, 70, 30);

        jPanel4.add(jPanel3);
        jPanel3.setBounds(260, 130, 540, 400);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setLayout(null);

        jLabel42.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel42.setText("Accession Number:");
        jPanel7.add(jLabel42);
        jLabel42.setBounds(20, 0, 140, 40);

        txtaccession.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtaccession.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtaccession.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtaccessionKeyReleased(evt);
            }
        });
        jPanel7.add(txtaccession);
        txtaccession.setBounds(150, 10, 130, 30);

        saveAccess.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        saveAccess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        saveAccess.setText("Save");
        saveAccess.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        saveAccess.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAccessActionPerformed(evt);
            }
        });
        jPanel7.add(saveAccess);
        saveAccess.setBounds(300, 10, 80, 40);

        jLabel39.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel39.setText("Total:");
        jPanel7.add(jLabel39);
        jLabel39.setBounds(110, 40, 50, 30);

        total.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        total.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel7.add(total);
        total.setBounds(150, 40, 70, 30);

        jPanel4.add(jPanel7);
        jPanel7.setBounds(1070, 380, 400, 90);

        tbl_news.setModel(new javax.swing.table.DefaultTableModel(data,header));
        tbl_news.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_newsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_news);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(890, 210, 740, 130);

        book.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        book.setText("Newspaper");
        jPanel4.add(book);
        book.setBounds(20, 10, 170, 40);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(0, 20, 1690, 900);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(null);
        jPanel2.add(jPanel6);
        jPanel6.setBounds(540, 90, 390, 100);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, -20, 1720, 920);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1690, 880);

        setSize(new java.awt.Dimension(1684, 952));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_newsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_newsMouseClicked
        updateDte.show();
        dateNewspaper.hide(); 
        jComboBox_newspaper_Type.setEnabled(true);
        jTextField_N_Heading.setEnabled(true);
        jTextField_N_Volume.setEnabled(true);
        status.setEnabled(true);
        days.setEnabled(true);
        available.setEnabled(true);
        txtnewsBarcode.setEnabled(true); 
        updateDte.setEnabled(true);
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null; 
        jButton_newspaper_edit.setEnabled(true);
        jButton_newspaper_delete.setEnabled(true);

        try {
            int row = tbl_news.getSelectedRow();
            String cell_click = (tbl_news.getModel().getValueAt(row, 1).toString());
            String query = "Select * from tbl_librarynewspaper where ISBNBarcode = '" + cell_click + "'";

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.prepareStatement(query);
            rs = st.executeQuery(query); 
          
            if (rs.next()) {

                String barcode = rs.getString("ISBNBarcode");
                txtnewsBarcode.setText(barcode);

                String date = rs.getString("NDateReceive");
                updateDte.setText(date);

                String type = rs.getString("NType");
                jComboBox_newspaper_Type.setSelectedItem(type);

                String heading = rs.getString("NHeading");
                jTextField_N_Heading.setText(heading);

                String volume = rs.getString("NVolume");
                jTextField_N_Volume.setText(volume);

                String day = rs.getString("days");
                days.setSelectedItem(day);

                String avail = rs.getString("Availability");
                available.setSelectedItem(avail);
            }

        } catch (Exception e) {
            e.printStackTrace(); 
        } 
        CountNewspaper();
        int choice;
        choice = JOptionPane.showConfirmDialog(null, "Add accession number?"); 
        if (choice == JOptionPane.YES_OPTION) {
            txtaccession.setEnabled(true);
            tbl_news.setEnabled(false); 
            txtaccession.getText(); 
        }
          Connection cnn = null;
        Statement stt = null;
        ResultSet rss = null;
        
        try { 
            String query = "Select * from tbl_journalaccession"; 
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            stt = cnn.prepareStatement(query);
            rss = stt.executeQuery(query); 
            if (rss.next()) {  
                int a;
                a = Integer.parseInt(total.getText());
                if (a == 0){
                    txtaccession.setText("");
                } 
                else{
                    String accessnum = rss.getString("accession");
                    txtaccession.setText(accessnum); 
                } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbl_newsMouseClicked

    private void jComboBox_newspaper_TypeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox_newspaper_TypeKeyTyped

    }//GEN-LAST:event_jComboBox_newspaper_TypeKeyTyped

    private void jTextField_N_HeadingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_N_HeadingKeyTyped
        int i = evt.getKeyChar();
        if (i == KeyEvent.VK_0 || i == KeyEvent.VK_9) {
            jTextField_N_Heading.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer ");
        }
    }//GEN-LAST:event_jTextField_N_HeadingKeyTyped

    private void jTextField_N_VolumeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_N_VolumeKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            getToolkit().beep();
            evt.consume(); 
        }
    }//GEN-LAST:event_jTextField_N_VolumeKeyTyped

    private void jTextField_N_VolumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_N_VolumeActionPerformed

    }//GEN-LAST:event_jTextField_N_VolumeActionPerformed

    private void searchAccessKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchAccessKeyReleased
        String temp1 = searchAccess.getText() + "%";
        datas = SearchAccession("Select * from tbl_newsaccession where accession like '" + temp1 + "' || ISBNBarcode like '" + temp1 + "'");
        tbl_searchNews.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
        tbl_searchNews.removeColumn(tbl_searchNews.getColumnModel().getColumn(0));
    }//GEN-LAST:event_searchAccessKeyReleased

    private void jButton_newspaper_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_newspaper_ClearActionPerformed
        jComboBox_newspaper_Type.setSelectedItem("");
        jTextField_N_Heading.setText("");
        jTextField_N_Volume.setText("");
        status.setSelectedItem("");
        days.setSelectedItem("");
        available.setSelectedItem("");
        txtnewsBarcode.setText("");
    }//GEN-LAST:event_jButton_newspaper_ClearActionPerformed

    private void jButton_newspaper_ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_newspaper_ClearMouseClicked
        txtnewsBarcode.setText("");
        jComboBox_newspaper_Type.setSelectedItem("");
        jTextField_N_Heading.setText("");
        jTextField_N_Volume.setText("");
    }//GEN-LAST:event_jButton_newspaper_ClearMouseClicked

    private void jButton_newspaper_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_newspaper_deleteActionPerformed
        String query = "DELETE FROM `tbl_librarynewspaper` WHERE ISBNBarcode= " + txtnewsBarcode.getText();
        executeSqLQuery(query, "Deleted ");
        jComboBox_newspaper_Type.setSelectedItem("");
        jTextField_N_Heading.setText("");
        jTextField_N_Volume.setText("");
        txtnewsBarcode.setText("");
        updateDte.setText("");
        txtaccession.setText("");
        total.setText("");
    }//GEN-LAST:event_jButton_newspaper_deleteActionPerformed

    private void jButton_newspaper_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_newspaper_editActionPerformed
        jComboBox_newspaper_Type.setEnabled(true);
        jTextField_N_Heading.setEnabled(true);
        jTextField_N_Volume.setEnabled(true);
        status.setEnabled(true);
        days.setEnabled(true);
        available.setEnabled(true);
        txtnewsBarcode.setEnabled(false);
        try {
            String query = "UPDATE `tbl_librarynewspaper` SET `ISBNBarcode`='" + txtnewsBarcode.getText() + "',`NType`='" + jComboBox_newspaper_Type.getSelectedItem() + "',`NHeading`='" + jTextField_N_Heading.getText() + "',`NVolume`='" + jTextField_N_Volume.getText() + "',`NDateReceive`='" + updateDte.getText() + "' WHERE ISBNBarcode = " + txtnewsBarcode.getText();
            executeSqLQuery(query, jTextField_N_Heading.getText()+" updated");

            jComboBox_newspaper_Type.setSelectedItem("");
            jTextField_N_Heading.setText("");
            jTextField_N_Volume.setText("");
            status.setSelectedItem("");
            days.setSelectedItem("");
            available.setSelectedItem("");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }//GEN-LAST:event_jButton_newspaper_editActionPerformed

    private void jButton_newspaper_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_newspaper_saveActionPerformed

        if (txtnewsBarcode.getText().trim().isEmpty() || jTextField_N_Heading.getText().trim().isEmpty() || jTextField_N_Heading.getText().trim().isEmpty() || jTextField_N_Volume.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty");
        } else {

            SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
            String dateBook = s.format(dateNewspaper.getDate());
            String query = "INSERT INTO `tbl_librarynewspaper` VALUES ('" + Global_Variable.NewspaperId + "','" + txtnewsBarcode.getText() + "','" + jComboBox_newspaper_Type.getSelectedItem() + "','" + jTextField_N_Heading.getText() + "','" + jTextField_N_Volume.getText() + "','" + dateBook + "','" + total.getText() + "','" + status.getSelectedItem() + "','" + days.getSelectedItem() + "','" + available.getSelectedItem() + "')";
            executeSqLQuery(query, jTextField_N_Heading.getText()+" added");
            
            txtnewsBarcode.setText("");
            jComboBox_newspaper_Type.setSelectedItem("");
            jTextField_N_Heading.setText("");
            jTextField_N_Volume.setText("");
            status.setSelectedItem("");
            days.setSelectedItem("");
            available.setSelectedItem("");
            dateNewspaper.setDateFormatString("");

            jComboBox_newspaper_Type.setEnabled(false);
             jTextField_N_Heading.setEnabled(false);
             jTextField_N_Volume.setEnabled(false);
             status.setEnabled(false);
             days.setEnabled(false);
             available.setEnabled(false);
             dateNewspaper.setEnabled(false);
             txtnewsBarcode.setEnabled(true);
             updateDte.setEnabled(false);
        }
    }//GEN-LAST:event_jButton_newspaper_saveActionPerformed

    private void saveAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAccessActionPerformed
        try {
            String a = txtaccession.getText();
            int access = Integer.valueOf(a);
            a = Integer.toString(++access);  
            String queries = "Insert into tbl_newsaccession values ('" + Global_Variable.accnewspaperId + "','" + txtaccession.getText() + "','" + txtnewsBarcode.getText() + "','"+jTextField_N_Heading.getText()+"','"+jTextField_N_Volume.getText()+"')";
            executeSqLQuery(queries, "Accession number for "+jTextField_N_Heading.getText()+" added");
            CountNewspaper();
            txtaccession.setText(a);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        try {
            String query = "UPDATE `tbl_librarynewspaper` SET  `Copies` ='" + total.getText() + "' WHERE  `ISBNBarcode` =" + txtnewsBarcode.getText();
            executeSqLQuery(query, "Number of Copies for "+jTextField_N_Heading.getText()+" updated");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }//GEN-LAST:event_saveAccessActionPerformed

    private void seacrhnewsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seacrhnewsKeyReleased
        String temp1 = seacrhnews.getText() + "%"; 
        data = theSearch("Select * from tbl_librarynewspaper where ISBNBarcode like '" + temp1 + "' || NHeading like '" + temp1 + "'");
        tbl_news.setModel(new javax.swing.table.DefaultTableModel(data, header));
        tbl_news.removeColumn(tbl_news.getColumnModel().getColumn(0));
    }//GEN-LAST:event_seacrhnewsKeyReleased

    private void txtaccessionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaccessionKeyReleased
        if (validateBarcode(txtaccession.getText())) {
            JOptionPane.showMessageDialog(null, "Duplicate Accession Number!");
        }
    }//GEN-LAST:event_txtaccessionKeyReleased

    private void updateDteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updateDteKeyReleased
        updateDte.hide();
        dateNewspaper.show();
    }//GEN-LAST:event_updateDteKeyReleased

    private void txtnewsBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnewsBarcodeKeyReleased
        jComboBox_newspaper_Type.setEnabled(true);
        jTextField_N_Heading.setEnabled(true);
        jTextField_N_Volume.setEnabled(true);
        status.setEnabled(true);
        days.setEnabled(true);
        available.setEnabled(true);
        dateNewspaper.setEnabled(true);
        txtnewsBarcode.setEnabled(true);
    }//GEN-LAST:event_txtnewsBarcodeKeyReleased

    private void statusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statusItemStateChanged
        switch (status.getSelectedItem().toString()) {
            case "Available":
            days.setEnabled(true);
            available.setEnabled(true);
            break;
            case "Damaged":
            days.setEnabled(false);
            available.setEnabled(false);
            break;
            case "Lost":
            days.setEnabled(false);
            available.setEnabled(false);
            break;
            default:
            status.setEnabled(false);
            break;
        }
    }//GEN-LAST:event_statusItemStateChanged

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void CountNewspaper() {
        try {
            String q = "SELECT COUNT(ISBNBarcode) AS ISBNBarcode FROM tbl_newsaccession where ISBNBarcode =" + txtnewsBarcode.getText();

            ResultSet rs;
            PreparedStatement ps = con.dbconn().prepareStatement(q);
            rs = ps.executeQuery();
            if (rs.next()) {
                total.setText(rs.getString("ISBNBarcode"));
            }
        } catch (Exception e) {

        }
    }

    private boolean validateBarcode(String Barcode) {
        boolean queue = false;
        ResultSet rs;
        //String barcode = adminbarcode.getText();
        String query;
        try {
            query = "select id from `tbl_newsaccession` where accession='" + Barcode + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                queue = true;
                //rs.getString("adminBarcode");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return queue;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox available;
    private javax.swing.JLabel book;
    private com.toedter.calendar.JDateChooser dateNewspaper;
    private javax.swing.JComboBox days;
    private javax.swing.JButton jButton_newspaper_Clear;
    private javax.swing.JButton jButton_newspaper_delete;
    private javax.swing.JButton jButton_newspaper_edit;
    private javax.swing.JButton jButton_newspaper_save;
    private javax.swing.JComboBox jComboBox_newspaper_Type;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField_N_Heading;
    private javax.swing.JTextField jTextField_N_Volume;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JButton saveAccess;
    private javax.swing.JTextField seacrhnews;
    private javax.swing.JTextField searchAccess;
    private javax.swing.JComboBox status;
    private javax.swing.JTable tbl_news;
    private javax.swing.JTable tbl_searchNews;
    private javax.swing.JTextField total;
    private javax.swing.JTextField txtaccession;
    private javax.swing.JTextField txtnewsBarcode;
    private javax.swing.JTextField updateDte;
    // End of variables declaration//GEN-END:variables
      private Vector<Vector<String>> theSearch(String sqlSearch) {
        Vector<Vector<String>> newspaper = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> news = new Vector<String>();
                news.add(rs.getString(1));
                news.add(rs.getString(2));
                news.add(rs.getString(4));
                news.add(rs.getString(7));
                news.add(rs.getString(8));
                news.add(rs.getString(9));
                news.add(rs.getString(10));
                newspaper.add(news);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return newspaper;
    }

    private Vector<Vector<String>> SearchAccession(String sqlSearch) {
        Vector<Vector<String>> newspaperaccess = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> NewspaperAccess = new Vector<String>();
                NewspaperAccess.add(rs.getString(1));
                NewspaperAccess.add(rs.getString(2));
                NewspaperAccess.add(rs.getString(3));
                newspaperaccess.add(NewspaperAccess);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return newspaperaccess;
    }
}
