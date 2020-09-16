package MaterialEntry;

import Accession_Classes.C_JournalAccession;
import Classes.C_LibraryMaterialJournal;
import Global_Variable.Global_Variable;
import Module.dbConn;
import connection.Conn;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JOURNAL extends javax.swing.JFrame {

    Statement st;
    ResultSet rs;
    dbConn con = new dbConn();
    private Vector<Vector<String>> data;
    private Vector<String> header;
    private Vector<Vector<String>> datas;
    private Vector<String> headers;

    public JOURNAL() throws Exception {
        Conn connection = new Conn();
        data = connection.getJournal();
        header = new Vector<String>();

        Conn connections = new Conn();
        datas = connections.getJournalAccession();
        headers = new Vector<String>();

        header.add("id");
        header.add("ISBNBarcode");
        header.add("J_Title");
        header.add("Lib_Id");
        header.add("Copies");
        header.add("Status");
        header.add("Availability");

        headers.add("id");
        headers.add("accession");
        headers.add("ISBNBarcode");
        initComponents();

        txtBarcode.setEnabled(true);
        dateJournal.setEnabled(false);
        txtJournalTitle.setEnabled(false);
        txtAuthor.setEnabled(false);
        txtPublisher.setEnabled(false);
        txtedNo.setEnabled(false);
        txtpagevol.setEnabled(false);
        txtplace.setEnabled(false);
        txtsource.setEnabled(false);
        days.setEnabled(false);
        available.setEnabled(false);
        status1.setEnabled(false);
        txtaccession.setEnabled(false);
        Yearjournal.setEnabled(false);
        total.setEditable(false);
        updatejour.hide();
        total.setText("0");

        tbl_journal.removeColumn(tbl_journal.getColumnModel().getColumn(0));
        tbl_access.removeColumn(tbl_access.getColumnModel().getColumn(0));
        setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    public ArrayList<C_LibraryMaterialJournal> getJournalList() {
        ArrayList<C_LibraryMaterialJournal> journal = new ArrayList<C_LibraryMaterialJournal>();
        String query = "select * from `tbl_journal` where category_id ='" + Global_Variable.category_id + "'";
        ResultSet sr;
        try {
            st = null;
            st = con.dbconn().createStatement();
            sr = st.executeQuery(query);
            C_LibraryMaterialJournal jour;
            while (sr.next()) {
                jour = new C_LibraryMaterialJournal(sr.getInt("id"), sr.getString("ISBNBarcode"), sr.getString("DateAcquisition"), sr.getString("J_Title"), sr.getString("J_Author"), sr.getString("J_Publisher"), sr.getInt("EditionNumber"), sr.getInt("Pagevol"), sr.getString("Place"), sr.getInt("Year"), sr.getString("Source"));
                journal.add(jour);
            }
        } catch (Exception a) {
            a.printStackTrace();
        }
        return journal;
    }

    //for journal table
    public void LibraryJournal() {
        ArrayList<C_LibraryMaterialJournal> journs = getJournalList();
        DefaultTableModel model = (DefaultTableModel) tbl_journal.getModel();
        Object[] row = new Object[2];
        for (int b = 0; b < journs.size(); b++) {

            row[0] = journs.get(b).getj_isbnBarcode();
            row[1] = journs.get(b).getj_title();
            model.addRow(row);
        }
    }

    public ArrayList<C_JournalAccession> getJournalAccess() {
        ArrayList<C_JournalAccession> access = new ArrayList<C_JournalAccession>();
        String query = "select * from `tbl_journalaccession` ";
        ResultSet sr;
        try {
            st = null;
            st = con.dbconn().createStatement();
            sr = st.executeQuery(query);
            C_JournalAccession accession;
            while (sr.next()) {
                accession = new C_JournalAccession(sr.getInt("id"), sr.getInt("accession"), sr.getString("Status"));
                access.add(accession);
            }
        } catch (Exception a) {
            a.printStackTrace();
        }
        return access;
    }

    public void JournalAccess() {
        ArrayList<C_JournalAccession> journs = getJournalAccess();
        DefaultTableModel mode = (DefaultTableModel) tbl_access.getModel();
        Object[] row = new Object[1];
        for (int b = 0; b < journs.size(); b++) {

            row[0] = journs.get(b).getaccession();
            mode.addRow(row);
        }
    }
    //for journal query

    public void executeSqlquery(String query, String message) {
        try {
            st = null;
            st = con.dbconn().createStatement();
            if ((st.executeUpdate(query)) == 1) {
                Conn connecting = new Conn();
                data = connecting.getJournal();
                //for setting the table for model
                tbl_journal.setModel(new javax.swing.table.DefaultTableModel(data, header));

                tbl_journal.removeColumn(tbl_journal.getColumnModel().getColumn(0));

                Conn connectn = new Conn();
                datas = connectn.getJournalAccession();
                //for setting the table for model
                tbl_access.setModel(new javax.swing.table.DefaultTableModel(datas, headers));

                tbl_access.removeColumn(tbl_access.getColumnModel().getColumn(0));

                JOptionPane.showMessageDialog(null, "Data " + message + " successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Data " + message + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        btnsave = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_journal = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_access = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        status1 = new javax.swing.JComboBox();
        available = new javax.swing.JComboBox();
        label1 = new javax.swing.JLabel();
        days = new javax.swing.JComboBox();
        txtsource = new javax.swing.JTextField();
        Yearjournal = new com.toedter.calendar.JYearChooser();
        txtplace = new javax.swing.JTextField();
        txtPublisher = new javax.swing.JTextField();
        txtpagevol = new javax.swing.JTextField();
        txtedNo = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        txtJournalTitle = new javax.swing.JTextField();
        txtBarcode = new javax.swing.JTextField();
        dateJournal = new com.toedter.calendar.JDateChooser();
        updatejour = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtaccession = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        total = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        searchAccess = new javax.swing.JTextField();
        btnPrintJournal = new javax.swing.JButton();
        btnPrintaccess = new javax.swing.JButton();
        book = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel4.setLayout(null);

        jLabel51.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_search.png"))); // NOI18N
        jPanel4.add(jLabel51);
        jLabel51.setBounds(1150, 540, 40, 30);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setLayout(null);

        btnsave.setFont(new java.awt.Font("Lucida Fax", 1, 11)); // NOI18N
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        btnsave.setText("Save");
        btnsave.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnsave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel12.add(btnsave);
        btnsave.setBounds(40, 20, 80, 40);

        btndelete.setFont(new java.awt.Font("Lucida Fax", 1, 11)); // NOI18N
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_b_empty.png"))); // NOI18N
        btndelete.setText("Delete");
        btndelete.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btndelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel12.add(btndelete);
        btndelete.setBounds(260, 20, 90, 40);

        btnclear.setFont(new java.awt.Font("Lucida Fax", 1, 11)); // NOI18N
        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_drop.png"))); // NOI18N
        btnclear.setText("Clear");
        btnclear.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnclear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        jPanel12.add(btnclear);
        btnclear.setBounds(370, 20, 90, 40);

        btnEdit.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_b_edit.png"))); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel12.add(btnEdit);
        btnEdit.setBounds(150, 20, 80, 40);

        jPanel4.add(jPanel12);
        jPanel12.setBounds(260, 650, 530, 80);

        tbl_journal.setModel(new javax.swing.table.DefaultTableModel(data,header));
        tbl_journal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_journalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_journalMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_journal);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(900, 220, 810, 130);

        txtsearch.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtsearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        jPanel4.add(txtsearch);
        txtsearch.setBounds(1170, 170, 210, 30);

        tbl_access.setModel(new javax.swing.table.DefaultTableModel(datas,headers));
        jScrollPane2.setViewportView(tbl_access);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(1020, 590, 590, 130);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jLabel28.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel28.setText("Date of Acquisition:");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(40, 90, 130, 50);

        jLabel21.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel21.setText("ISBN Barcode:");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(80, 70, 87, 30);

        jLabel18.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel18.setText("Journal Title:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(80, 130, 84, 30);

        jLabel19.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel19.setText("Author:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(120, 150, 80, 50);

        jLabel46.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel46.setText("Edition Number:");
        jPanel2.add(jLabel46);
        jLabel46.setBounds(70, 180, 110, 50);

        jLabel47.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel47.setText("Page Volume:");
        jPanel2.add(jLabel47);
        jLabel47.setBounds(90, 220, 90, 30);

        jLabel20.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel20.setText("Publisher:");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(110, 250, 64, 30);

        jLabel48.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel48.setText("Place:");
        jPanel2.add(jLabel48);
        jLabel48.setBounds(130, 280, 50, 30);

        jLabel49.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel49.setText("Year:");
        jPanel2.add(jLabel49);
        jLabel49.setBounds(140, 310, 40, 30);

        jLabel50.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel50.setText("Source:");
        jPanel2.add(jLabel50);
        jLabel50.setBounds(120, 340, 60, 30);

        label3.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        label3.setText("Status:");
        jPanel2.add(label3);
        label3.setBounds(120, 370, 70, 40);

        jLabel62.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel62.setText("Availability to be borrow outside:");
        jPanel2.add(jLabel62);
        jLabel62.setBounds(50, 430, 240, 30);

        status1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        status1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Damaged", "Lost" }));
        status1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                status1ItemStateChanged(evt);
            }
        });
        jPanel2.add(status1);
        status1.setBounds(180, 370, 190, 30);

        available.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        available.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YES", "NO" }));
        jPanel2.add(available);
        available.setBounds(270, 430, 60, 30);

        label1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        label1.setText("No of days:");
        jPanel2.add(label1);
        label1.setBounds(90, 400, 80, 30);

        days.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        days.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----", "3", "2", "1" }));
        jPanel2.add(days);
        days.setBounds(180, 400, 190, 30);

        txtsource.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtsource.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtsource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsourceActionPerformed(evt);
            }
        });
        txtsource.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsourceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsourceKeyTyped(evt);
            }
        });
        jPanel2.add(txtsource);
        txtsource.setBounds(180, 340, 290, 30);

        Yearjournal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(Yearjournal);
        Yearjournal.setBounds(180, 310, 120, 30);

        txtplace.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtplace.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplaceActionPerformed(evt);
            }
        });
        txtplace.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtplaceKeyTyped(evt);
            }
        });
        jPanel2.add(txtplace);
        txtplace.setBounds(180, 280, 290, 30);

        txtPublisher.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtPublisher.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtPublisher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPublisherKeyTyped(evt);
            }
        });
        jPanel2.add(txtPublisher);
        txtPublisher.setBounds(180, 250, 290, 30);

        txtpagevol.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtpagevol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtpagevol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpagevolKeyTyped(evt);
            }
        });
        jPanel2.add(txtpagevol);
        txtpagevol.setBounds(180, 220, 190, 30);

        txtedNo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtedNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtedNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtedNoKeyTyped(evt);
            }
        });
        jPanel2.add(txtedNo);
        txtedNo.setBounds(180, 190, 190, 30);

        txtAuthor.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtAuthor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtAuthor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAuthorKeyTyped(evt);
            }
        });
        jPanel2.add(txtAuthor);
        txtAuthor.setBounds(180, 160, 290, 30);

        txtJournalTitle.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtJournalTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtJournalTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJournalTitleActionPerformed(evt);
            }
        });
        txtJournalTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJournalTitleKeyTyped(evt);
            }
        });
        jPanel2.add(txtJournalTitle);
        txtJournalTitle.setBounds(180, 130, 290, 30);

        txtBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarcodeActionPerformed(evt);
            }
        });
        txtBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyTyped(evt);
            }
        });
        jPanel2.add(txtBarcode);
        txtBarcode.setBounds(180, 70, 290, 30);

        dateJournal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        dateJournal.setDateFormatString("MM-dd-yyyy");
        dateJournal.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jPanel2.add(dateJournal);
        dateJournal.setBounds(180, 100, 290, 30);

        updatejour.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        updatejour.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(updatejour);
        updatejour.setBounds(180, 100, 230, 30);

        jPanel4.add(jPanel2);
        jPanel2.setBounds(260, 100, 530, 510);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        txtaccession.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtaccession.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtaccession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaccessionActionPerformed(evt);
            }
        });
        txtaccession.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtaccessionKeyReleased(evt);
            }
        });
        jPanel3.add(txtaccession);
        txtaccession.setBounds(160, 10, 100, 30);

        jButton1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(290, 20, 80, 40);

        total.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        total.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(total);
        total.setBounds(160, 50, 100, 30);

        jLabel53.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel53.setText("Total:");
        jPanel3.add(jLabel53);
        jLabel53.setBounds(110, 50, 50, 30);

        jLabel17.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel17.setText("Accession Number:");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(30, 10, 132, 20);

        jPanel4.add(jPanel3);
        jPanel3.setBounds(1110, 400, 430, 100);

        jLabel52.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_search.png"))); // NOI18N
        jPanel4.add(jLabel52);
        jLabel52.setBounds(1140, 170, 50, 30);

        searchAccess.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        searchAccess.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        searchAccess.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchAccessKeyReleased(evt);
            }
        });
        jPanel4.add(searchAccess);
        searchAccess.setBounds(1180, 540, 190, 30);

        btnPrintJournal.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnPrintJournal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        btnPrintJournal.setText("Print");
        btnPrintJournal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnPrintJournal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrintJournal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintJournalActionPerformed(evt);
            }
        });
        jPanel4.add(btnPrintJournal);
        btnPrintJournal.setBounds(1400, 170, 100, 33);

        btnPrintaccess.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnPrintaccess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        btnPrintaccess.setText("Print");
        btnPrintaccess.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnPrintaccess.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrintaccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintaccessActionPerformed(evt);
            }
        });
        jPanel4.add(btnPrintaccess);
        btnPrintaccess.setBounds(1390, 540, 100, 33);

        book.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        book.setText("Journal");
        jPanel4.add(book);
        book.setBounds(20, 10, 130, 40);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 1750, 920);

        setSize(new java.awt.Dimension(1772, 967));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            String a = txtaccession.getText();
            int access = Integer.valueOf(a);
            a = Integer.toString(++access);

            String queries = "Insert into tbl_journalaccession values ('" + Global_Variable.accjournalId + "','" + txtaccession.getText() + "','" + txtBarcode.getText() + "','" + txtJournalTitle.getText() + "','" + txtAuthor.getText() + "','" + txtPublisher.getText() + "','"+total.getText()+"','" + Global_Variable.category_id + "')";
            executeSqlquery(queries, "Data Successfully Added");
            CountJournal();
            txtaccession.setText(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String queriy = "UPDATE `tbl_journal` SET  `NoOfCopies` ='" + total.getText() + "' WHERE  `ISBNBarcode` =" + txtBarcode.getText();
            executeSqlquery(queriy, "updated");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtaccessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaccessionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccessionActionPerformed

    private void tbl_journalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_journalMouseClicked
        updatejour.show();
        dateJournal.hide();

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        
        btnEdit.setEnabled(true);
        btndelete.setEnabled(true);
        
        txtBarcode.setEnabled(true);
        dateJournal.setEnabled(true);
        txtJournalTitle.setEnabled(true);
        txtAuthor.setEnabled(true);
        txtPublisher.setEnabled(true);
        txtedNo.setEnabled(true);
        txtpagevol.setEnabled(true);
        txtplace.setEnabled(true);
        txtsource.setEnabled(true);
        days.setEnabled(true);
        available.setEnabled(true);
        status1.setEnabled(true);
        Yearjournal.setEnabled(true);
        try {

            int row = tbl_journal.getSelectedRow();
            String cell_click = (tbl_journal.getModel().getValueAt(row, 1).toString());

            String query = "Select * from tbl_journal where ISBNBarcode = '" + cell_click + "'";

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.prepareStatement(query);
            rs = st.executeQuery(query); 
            
            if (rs.next()) {
                String barcode = rs.getString("ISBNBarcode");
                txtBarcode.setText(barcode);

                String date = rs.getString("DateAcquisition");
                updatejour.setText(date);

                String title = rs.getString("J_Title");
                txtJournalTitle.setText(title);

                String author = rs.getString("J_Author");
                txtAuthor.setText(author);

                String publisher = rs.getString("J_Publisher");
                txtPublisher.setText(publisher);

                String edition = rs.getString("EditionNumber");
                txtedNo.setText(edition);

                String page = rs.getString("Pagevol");
                txtpagevol.setText(page);

                String place = rs.getString("Place");
                txtplace.setText(place);

                String source = rs.getString("Source");
                txtsource.setText(source);

                String copies = rs.getString("NoOfCopies");
                total.setText(copies);

                String day = rs.getString("days");
                days.setSelectedItem(day);

                String avail = rs.getString("Availability");
                available.setSelectedItem(avail);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        CountJournal();
        int choice = JOptionPane.showConfirmDialog(null, "Add accession number?");

        if (choice == JOptionPane.YES_OPTION) {
            txtaccession.setEnabled(true);
            tbl_access.setEnabled(false);
            txtaccession.getText();
        }

    }//GEN-LAST:event_tbl_journalMouseClicked

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed

        dateJournal.setDateFormatString("");
        txtJournalTitle.setText("");
        txtAuthor.setText("");
        txtPublisher.setText("");
        txtedNo.setText("");
        txtpagevol.setText("");
        txtplace.setText("");

        txtsource.setText("");
        txtBarcode.setText("");
        updatejour.setText("");
        dateJournal.show();
    }//GEN-LAST:event_btnclearActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        String query = "DELETE FROM `tbl_journal` WHERE ISBNBarcode = " + txtBarcode.getText();
        executeSqlquery(query, "Deleted");

        dateJournal.setDateFormatString("");
        txtJournalTitle.setText("");
        txtAuthor.setText("");
        txtPublisher.setText("");
        txtedNo.setText("");
        txtpagevol.setText("");
        txtplace.setText("");

        txtsource.setText("");
        txtBarcode.setText("");
        updatejour.setText("");
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed

        if (txtBarcode.getText().trim().isEmpty() || txtJournalTitle.getText().trim().isEmpty() || txtAuthor.getText().trim().isEmpty() || txtPublisher.getText().trim().isEmpty() || txtedNo.getText().trim().isEmpty() || txtpagevol.getText().trim().isEmpty() || txtplace.getText().trim().isEmpty() || txtsource.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty");
        } else {

            SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
            String datecd = s.format(dateJournal.getDate());

            String query = "INSERT INTO `tbl_journal` VALUES ('" + Global_Variable.JournalId + "','" + txtBarcode.getText() + "','" + datecd + "','" + txtJournalTitle.getText() + "','" + txtAuthor.getText() + "','" + txtPublisher.getText() + "','" + txtedNo.getText() + "','" + txtpagevol.getText() + "','" + txtplace.getText() + "','" + Yearjournal.getYear() + "','" + txtsource.getText() + "','" + Global_Variable.category_id + "','" + total.getText() + "','" + status1.getSelectedItem() + "','" + days.getSelectedItem() + "','" + available.getSelectedItem() + "')";
            executeSqlquery(query, "added");

            dateJournal.setDateFormatString("");
            txtJournalTitle.setText("");
            txtAuthor.setText("");
            txtPublisher.setText("");
            txtedNo.setText("");
            txtpagevol.setText("");
            txtplace.setText("");
            txtsource.setText("");
            txtBarcode.setText("");

            /* txtBarcode.setEnabled(true);
             dateJournal.setEnabled(false);
             txtJournalTitle.setEnabled(false);
             txtAuthor.setEnabled(false);
             txtPublisher.setEnabled(false);
             txtedNo.setEnabled(false);
             txtpagevol.setEnabled(false);
             txtplace.setEnabled(false);
             txtsource.setEnabled(false);
             days.setEnabled(false);
             available.setEnabled(false);
             status1.setEnabled(false);
             Yearjournal.setEnabled(false);*/
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void txtsourceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsourceKeyTyped
        int i = evt.getKeyChar();
        if (i == KeyEvent.VK_0 || i == KeyEvent.VK_9) {
            txtsource.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");

        }
    }//GEN-LAST:event_txtsourceKeyTyped

    private void txtsourceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsourceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsourceKeyReleased

    private void txtsourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsourceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsourceActionPerformed

    private void txtplaceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtplaceKeyTyped
        int i = evt.getKeyChar();
        if (i == KeyEvent.VK_0 || i == KeyEvent.VK_9) {
            txtplace.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");

        }
    }//GEN-LAST:event_txtplaceKeyTyped

    private void txtplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtplaceActionPerformed

    private void txtpagevolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpagevolKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtpagevolKeyTyped

    private void txtedNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtedNoKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtedNoKeyTyped

    private void txtAuthorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAuthorKeyTyped
        int i = evt.getKeyChar();
        if (i == KeyEvent.VK_0 || i == KeyEvent.VK_9) {
            txtAuthor.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");

        }
    }//GEN-LAST:event_txtAuthorKeyTyped

    private void txtBarcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtBarcodeKeyTyped

    private void txtBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBarcodeActionPerformed

    private void txtPublisherKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPublisherKeyTyped
        int i = evt.getKeyChar();
        if (i == KeyEvent.VK_0 || i == KeyEvent.VK_9) {
            txtPublisher.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");

        }
    }//GEN-LAST:event_txtPublisherKeyTyped

    private void txtJournalTitleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJournalTitleKeyTyped
        int i = evt.getKeyChar();
        if (i == KeyEvent.VK_0 || i == KeyEvent.VK_9) {
            txtJournalTitle.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");
        }
    }//GEN-LAST:event_txtJournalTitleKeyTyped

    private void txtJournalTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJournalTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJournalTitleActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        String temp1 = txtsearch.getText() + "%";
        //int temp2 = Integer.parseInt(txtsearch.getText()+"%");

        data = theSearch("Select * from tbl_journal where ISBNBarcode like '" + temp1 + "' || J_Title like '" + temp1 + "'");

        tbl_journal.setModel(new javax.swing.table.DefaultTableModel(data, header));

        tbl_journal.removeColumn(tbl_journal.getColumnModel().getColumn(0));
    }//GEN-LAST:event_txtsearchKeyReleased

    private void searchAccessKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchAccessKeyReleased
        String temp1 = searchAccess.getText() + "%";
        //int temp2 = Integer.parseInt(txtsearch.getText()+"%");

        datas = SearchAccession("Select * from tbl_journalaccession where accession like '" + temp1 + "' || ISBNBarcode like '" + temp1 + "'");

        tbl_access.setModel(new javax.swing.table.DefaultTableModel(datas, headers));

        tbl_access.removeColumn(tbl_access.getColumnModel().getColumn(0));
    }//GEN-LAST:event_searchAccessKeyReleased

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        txtBarcode.setEnabled(false);
        dateJournal.setEnabled(true);
        txtJournalTitle.setEnabled(true);
        txtAuthor.setEnabled(true);
        txtPublisher.setEnabled(true);
        txtedNo.setEnabled(true);
        txtpagevol.setEnabled(true);
        txtplace.setEnabled(true);
        txtsource.setEnabled(true);
        status1.setEnabled(true);
        days.setEnabled(true);
        available.setEnabled(true);
        Yearjournal.setEnabled(true);
        updatejour.setEnabled(true);

        try {
            String query = "UPDATE `tbl_journal` SET `id`='" + Global_Variable.JournalId + "',`ISBNBarcode`='" + txtBarcode.getText() + "',`DateAcquisition`='" + updatejour.getText() + "',`J_Title`='" + txtJournalTitle.getText() + "',`J_Author`='" + txtAuthor.getText() + "',`J_Publisher`='" + txtPublisher.getText() + "',`EditionNumber`='" + txtedNo.getText() + "',`Pagevol`='" + txtpagevol.getText() + "',`Place`='" + txtplace.getText() + "',`Year`='" + Yearjournal.getYear() + "',`Source`='" + txtsource.getText() + "',`category_id`='" + Global_Variable.category_id + "',`NoOfCopies`='" + total.getText() + "',`Status`='" + status1.getSelectedItem() + "',`days`='" + days.getSelectedItem() + "',`Availability`='" + available.getSelectedItem() + "' WHERE ISBNBarcode=" + txtBarcode.getText();
            executeSqlquery(query, "Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnPrintJournalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintJournalActionPerformed
        MessageFormat header = new MessageFormat("Journal Reports");
        MessageFormat footer = new MessageFormat("page{0,number,integer}");
        try {

            tbl_journal.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("can not print %s %n", e.getMessage());
        }
    }//GEN-LAST:event_btnPrintJournalActionPerformed

    private void btnPrintaccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintaccessActionPerformed
        MessageFormat header = new MessageFormat("Journal accessions with ISBN Barcode Reports");
        MessageFormat footer = new MessageFormat("page{0,number,integer}");
        try {

            tbl_access.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("can not print %s %n", e.getMessage());
        }
    }//GEN-LAST:event_btnPrintaccessActionPerformed

    private void txtBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyReleased
        txtBarcode.setEnabled(true);
        dateJournal.setEnabled(true);
        txtJournalTitle.setEnabled(true);
        txtAuthor.setEnabled(true);
        txtPublisher.setEnabled(true);
        txtedNo.setEnabled(true);
        txtpagevol.setEnabled(true);
        txtplace.setEnabled(true);
        txtsource.setEnabled(true);
        days.setEnabled(true);
        available.setEnabled(true);
        status1.setEnabled(true);
        Yearjournal.setEnabled(true);
    }//GEN-LAST:event_txtBarcodeKeyReleased

    private void txtaccessionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaccessionKeyReleased
        if (validateBarcode(txtaccession.getText())) {
            JOptionPane.showMessageDialog(null, "Duplicate Accession Number");
        }
    }//GEN-LAST:event_txtaccessionKeyReleased

    private void tbl_journalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_journalMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_journalMouseEntered

    private void status1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_status1ItemStateChanged
       switch (status1.getSelectedItem().toString()) {
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
                status1.setEnabled(false);
                break;
        }
    }//GEN-LAST:event_status1ItemStateChanged

    private void CountJournal() {
        try {
            String q = "SELECT COUNT(ISBNBarcode) AS ISBNBarcode FROM tbl_journalaccession where ISBNBarcode =" + txtBarcode.getText();

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
            query = "select id from `tbl_journalaccession` where accession='" + Barcode + "'";
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
    private com.toedter.calendar.JYearChooser Yearjournal;
    private javax.swing.JComboBox available;
    private javax.swing.JLabel book;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPrintJournal;
    private javax.swing.JButton btnPrintaccess;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private com.toedter.calendar.JDateChooser dateJournal;
    private javax.swing.JComboBox days;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JTextField searchAccess;
    private javax.swing.JComboBox status1;
    private javax.swing.JTable tbl_access;
    private javax.swing.JTable tbl_journal;
    private javax.swing.JTextField total;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtJournalTitle;
    private javax.swing.JTextField txtPublisher;
    private javax.swing.JTextField txtaccession;
    private javax.swing.JTextField txtedNo;
    private javax.swing.JTextField txtpagevol;
    private javax.swing.JTextField txtplace;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtsource;
    private javax.swing.JTextField updatejour;
    // End of variables declaration//GEN-END:variables

    private Vector<Vector<String>> theSearch(String sqlSearch) {
        Vector<Vector<String>> journal = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> jour = new Vector<String>();
                jour.add(rs.getString(1));
                jour.add(rs.getString(2));
                jour.add(rs.getString(4));
                jour.add(rs.getString(12));
                jour.add(rs.getString(13));
                jour.add(rs.getString(14));
                jour.add(rs.getString(16));
                journal.add(jour);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return journal;
    }

    private Vector<Vector<String>> SearchAccession(String sqlSearch) {
        Vector<Vector<String>> journalaccess = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> journalAccess = new Vector<String>();
                journalAccess.add(rs.getString(1));
                journalAccess.add(rs.getString(2));
                journalAccess.add(rs.getString(3));
                journalaccess.add(journalAccess);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return journalaccess;
    }
}
