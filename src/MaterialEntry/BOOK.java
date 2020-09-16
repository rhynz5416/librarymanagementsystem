package MaterialEntry;

import Classes.C_LibraryMaterialBook;
import Global_Variable.Global_Variable;
import Module.dbConn;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import Accession_Classes.C_BookAccession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Vector;
import connection.Conn;
import java.text.MessageFormat;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*import net.sf.jasperreports.engine.JasperCompileManager;
 import net.sf.jasperreports.engine.JasperFillManager;
 import net.sf.jasperreports.engine.JasperPrint;
 import net.sf.jasperreports.engine.JasperReport;
 import net.sf.jasperreports.engine.design.JasperDesign;
 import net.sf.jasperreports.engine.xml.JRXmlLoader;
 import net.sf.jasperreports.view.JasperViewer;
 import net.sf.jasperreports.engine.design.JRDesignQuery;*/
public class BOOK extends javax.swing.JFrame {

    Statement st = null;
    dbConn con = new dbConn();

    private Vector<Vector<String>> data;
    private Vector<String> header;

    private Vector<Vector<String>> datas;
    private Vector<String> headers;

    public BOOK() throws Exception {

        Conn connection = new Conn();
        data = connection.getUser();
        header = new Vector<String>();

        Conn connections = new Conn();
        datas = connections.getAccession();
        headers = new Vector<String>();

        header.add("id");
        header.add("Barcode");
        header.add("Title");
        header.add("Author");
        header.add("Lib_Id");
        header.add("Copies");
        header.add("Status");
        header.add("Availability");

        headers.add("id");
        headers.add("accessID");
        headers.add("ISBNBarcode");

        initComponents();
        txtBarcode.setEnabled(true);
        txtBookTitle.setEnabled(false);
        DateBook.setEnabled(false);
        YearBook.setEnabled(false);
        txtauthor.setEnabled(false);
        txtedNumber.setEnabled(false);
        txtPageVol.setEnabled(false);
        txtPlace.setEnabled(false);
        txtPublisher.setEnabled(false);
        combobinding.setEnabled(false);
        DateBook.setEnabled(false);
        txtPrice.setEnabled(false);

        comboxtype.setEnabled(false);
        status.setEnabled(false);
        days.setEnabled(false);
        available.setEnabled(false);
        updatebook.hide();
        accession.setEnabled(false);
        totalcopies.setEditable(false);
        totalcopies.setText("0");

        table_book.removeColumn(table_book.getColumnModel().getColumn(0));
        accessTable.removeColumn(accessTable.getColumnModel().getColumn(0));
        setExtendedState(JFrame.MAXIMIZED_BOTH);  

    }

    //this is for bookpane:
    public ArrayList<C_LibraryMaterialBook> getBookList() {
        ArrayList<C_LibraryMaterialBook> Material = new ArrayList<C_LibraryMaterialBook>();

        String query = "select * from `tbl_librarybook` where category_id='" + Global_Variable.category_id + "'";

        ResultSet rs;

        try {
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);

            C_LibraryMaterialBook libbook;
            while (rs.next()) {

                libbook = new C_LibraryMaterialBook(rs.getInt("id"), rs.getString("ISBNBarcode"), rs.getString("DateAcquisition"), rs.getString("BookTitle"), rs.getString("BookAuthor"), rs.getInt("EditionNumber"), rs.getInt("Pagevolume"), rs.getString("Place"), rs.getString("BookPublisher"), rs.getInt("Year"), rs.getString("Binding"), rs.getDouble("Price"), rs.getString("BookType"));
                Material.add(libbook);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Material;
    }

    public ArrayList<C_BookAccession> getAccess() {
        ArrayList<C_BookAccession> access = new ArrayList<C_BookAccession>();

        String query = "select * from `tbl_bookaccessions`";

        ResultSet rs;

        try {
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);

            C_BookAccession accession;
            while (rs.next()) {

                accession = new C_BookAccession(rs.getInt("id"), rs.getInt("accessID"), rs.getString("Status"));
                access.add(accession);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return access;
    }

    public void LibraryBook() {
        ArrayList<C_LibraryMaterialBook> book = getBookList();
        DefaultTableModel model = (DefaultTableModel) table_book.getModel();
        Object[] row = new Object[2];
        for (int b = 0; b < book.size(); b++) {

            row[0] = book.get(b).getisbnBarcode();
            row[1] = book.get(b).getbookTitle();
            model.addRow(row);
        }
    }

    //for the query
    private void executesqlQuery(String query, String message) {
        try {
            st = null;
            st = con.dbconn().createStatement();
            if ((st.executeUpdate(query)) == 1) {
                //for tablebook
                Conn connecting = new Conn();
                data = connecting.getUser();
                //for setting the table for model
                table_book.setModel(new javax.swing.table.DefaultTableModel(data, header));

                table_book.removeColumn(table_book.getColumnModel().getColumn(0));

                Conn connectn = new Conn();
                datas = connectn.getAccession();
                //for setting the table for model
                accessTable.setModel(new javax.swing.table.DefaultTableModel(datas, headers));

                accessTable.removeColumn(accessTable.getColumnModel().getColumn(0));

                JOptionPane.showMessageDialog(null, "Data " + message + " successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Data " + message + ".");
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_book = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        book = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        accessTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btndelete1 = new javax.swing.JButton();
        txtaccession = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        available = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox();
        days = new javax.swing.JComboBox();
        combobinding = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboxtype = new javax.swing.JComboBox();
        txtPrice = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        YearBook = new com.toedter.calendar.JYearChooser();
        txtPublisher = new javax.swing.JTextField();
        txtPlace = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtPageVol = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtedNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtauthor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtBookTitle = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        DateBook = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        updatebook = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        saveAccess = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        accession = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        totalcopies = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        btnaccessPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel2.setLayout(null);
        jPanel2.add(jLabel27);
        jLabel27.setBounds(-10, 30, 990, 0);

        jToolBar1.setRollover(true);
        jPanel2.add(jToolBar1);
        jToolBar1.setBounds(0, 0, 13, 2);

        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jButton1);
        jButton1.setBounds(20, 40, 0, 0);

        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jButton2);
        jButton2.setBounds(30, 30, 0, 0);

        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jButton3);
        jButton3.setBounds(50, 30, 0, 0);

        jLabel37.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_search.png"))); // NOI18N
        jPanel2.add(jLabel37);
        jLabel37.setBounds(1210, 590, 40, 30);

        table_book.setFont(new java.awt.Font("Lucida Sans", 1, 12));
        table_book.setModel(new javax.swing.table.DefaultTableModel(data,header));
        table_book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_bookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_book);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(900, 230, 870, 140);

        txtsearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        jPanel2.add(txtsearch);
        txtsearch.setBounds(1180, 180, 220, 30);

        book.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        book.setText("Book");
        jPanel2.add(book);
        book.setBounds(20, 10, 70, 40);

        accessTable.setModel(new javax.swing.table.DefaultTableModel(datas,headers));
        accessTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accessTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(accessTable);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(940, 640, 800, 160);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(null);

        btnSave.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel6.add(btnSave);
        btnSave.setBounds(80, 20, 100, 40);

        btnEdit.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_b_edit.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel6.add(btnEdit);
        btnEdit.setBounds(190, 20, 100, 40);

        btnClear.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_drop.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel6.add(btnClear);
        btnClear.setBounds(420, 20, 80, 40);

        btndelete1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btndelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_b_empty.png"))); // NOI18N
        btndelete1.setText("Delete");
        btndelete1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btndelete1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelete1ActionPerformed(evt);
            }
        });
        jPanel6.add(btndelete1);
        btndelete1.setBounds(300, 20, 110, 40);

        jPanel2.add(jPanel6);
        jPanel6.setBounds(140, 710, 590, 80);

        txtaccession.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtaccession.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtaccessionKeyReleased(evt);
            }
        });
        jPanel2.add(txtaccession);
        txtaccession.setBounds(1240, 590, 140, 30);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel11.setText("Availability to be borrow outside:");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(50, 490, 250, 50);

        available.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        available.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YES", "NO" }));
        available.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.add(available);
        available.setBounds(270, 500, 70, 30);

        jLabel13.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel13.setText("Status:");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(140, 430, 80, 50);

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
        jPanel4.add(status);
        status.setBounds(200, 440, 300, 30);

        days.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        days.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---", "5", "4", "3", "2", "1" }));
        days.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.add(days);
        days.setBounds(200, 470, 90, 30);

        combobinding.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        combobinding.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hardbound", "Softbound" }));
        combobinding.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.add(combobinding);
        combobinding.setBounds(200, 340, 300, 30);

        jLabel12.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel12.setText("No of days:");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(110, 460, 90, 50);

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel3.setText("Book Type:");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(110, 390, 80, 60);

        comboxtype.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        comboxtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "General Collection", "General References", "Law Books", "Filipiniana", "Circular Collection", "Thesis", "Reserved Books", "Children's Section" }));
        comboxtype.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        comboxtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxtypeActionPerformed(evt);
            }
        });
        jPanel4.add(comboxtype);
        comboxtype.setBounds(200, 400, 300, 40);

        txtPrice.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtPrice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });
        jPanel4.add(txtPrice);
        txtPrice.setBounds(200, 370, 90, 30);

        jLabel34.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel34.setText("Price:");
        jPanel4.add(jLabel34);
        jLabel34.setBounds(150, 370, 50, 40);

        jLabel33.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel33.setText("Binding:");
        jPanel4.add(jLabel33);
        jLabel33.setBounds(130, 340, 60, 40);

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel5.setText("Publisher:");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(120, 280, 70, 40);

        jLabel32.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel32.setText("Year:");
        jPanel4.add(jLabel32);
        jLabel32.setBounds(150, 310, 50, 40);

        YearBook.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.add(YearBook);
        YearBook.setBounds(200, 310, 70, 30);

        txtPublisher.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtPublisher.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtPublisher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPublisherKeyTyped(evt);
            }
        });
        jPanel4.add(txtPublisher);
        txtPublisher.setBounds(200, 280, 300, 30);

        txtPlace.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtPlace.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlaceActionPerformed(evt);
            }
        });
        txtPlace.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPlaceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlaceKeyTyped(evt);
            }
        });
        jPanel4.add(txtPlace);
        txtPlace.setBounds(200, 250, 300, 30);

        jLabel31.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel31.setText("Place:");
        jPanel4.add(jLabel31);
        jLabel31.setBounds(150, 250, 50, 40);

        jLabel30.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel30.setText("Pages Volume:");
        jPanel4.add(jLabel30);
        jLabel30.setBounds(100, 220, 110, 40);

        txtPageVol.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtPageVol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtPageVol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPageVolKeyTyped(evt);
            }
        });
        jPanel4.add(txtPageVol);
        txtPageVol.setBounds(200, 220, 90, 30);

        jLabel29.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel29.setText("Edition Number:");
        jPanel4.add(jLabel29);
        jLabel29.setBounds(90, 190, 130, 40);

        txtedNumber.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtedNumber.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtedNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtedNumberKeyTyped(evt);
            }
        });
        jPanel4.add(txtedNumber);
        txtedNumber.setBounds(200, 190, 90, 30);

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel4.setText("Author:");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(140, 160, 60, 40);

        txtauthor.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtauthor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtauthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtauthorActionPerformed(evt);
            }
        });
        txtauthor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtauthorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtauthorKeyTyped(evt);
            }
        });
        jPanel4.add(txtauthor);
        txtauthor.setBounds(200, 160, 300, 30);

        jLabel8.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel8.setText("Book Title:");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(120, 130, 70, 40);

        txtBookTitle.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtBookTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBookTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBookTitleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBookTitleKeyTyped(evt);
            }
        });
        jPanel4.add(txtBookTitle);
        txtBookTitle.setBounds(200, 130, 300, 30);

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel7.setText("Date of Acquisition:");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(60, 100, 130, 40);

        DateBook.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        DateBook.setDateFormatString("MM-dd-yyyy");
        DateBook.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        DateBook.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DateBookPropertyChange(evt);
            }
        });
        jPanel4.add(DateBook);
        DateBook.setBounds(200, 100, 300, 30);

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel6.setText("ISBN Barcode:");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(100, 70, 100, 40);

        txtBarcode.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        txtBarcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyTyped(evt);
            }
        });
        jPanel4.add(txtBarcode);
        txtBarcode.setBounds(200, 70, 300, 30);

        updatebook.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        updatebook.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        updatebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebookActionPerformed(evt);
            }
        });
        updatebook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                updatebookKeyReleased(evt);
            }
        });
        jPanel4.add(updatebook);
        updatebook.setBounds(200, 100, 300, 30);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(140, 80, 680, 590);

        jLabel38.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b_search.png"))); // NOI18N
        jPanel2.add(jLabel38);
        jLabel38.setBounds(1150, 180, 40, 30);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(null);

        saveAccess.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        saveAccess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Image_save.png"))); // NOI18N
        saveAccess.setText("SAVE");
        saveAccess.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        saveAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAccessActionPerformed(evt);
            }
        });
        jPanel5.add(saveAccess);
        saveAccess.setBounds(320, 30, 90, 40);

        jLabel10.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel10.setText("Accession Number:");
        jPanel5.add(jLabel10);
        jLabel10.setBounds(10, 10, 140, 25);

        accession.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        accession.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        accession.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                accessionKeyReleased(evt);
            }
        });
        jPanel5.add(accession);
        accession.setBounds(140, 10, 160, 30);

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel2.setText("Total:");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(100, 50, 50, 30);

        totalcopies.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        totalcopies.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.add(totalcopies);
        totalcopies.setBounds(140, 50, 80, 30);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(1110, 460, 430, 100);

        btnPrint.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        btnPrint.setText("PRINT");
        btnPrint.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel2.add(btnPrint);
        btnPrint.setBounds(1420, 180, 100, 30);

        btnaccessPrint.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        btnaccessPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        btnaccessPrint.setText("Print");
        btnaccessPrint.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        btnaccessPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnaccessPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaccessPrintActionPerformed(evt);
            }
        });
        jPanel2.add(btnaccessPrint);
        btnaccessPrint.setBounds(1390, 590, 100, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1820, 880);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1840, 840);

        setSize(new java.awt.Dimension(1843, 926));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAccessActionPerformed
        try {
            String a = accession.getText();
            int access = Integer.valueOf(a);
            a = Integer.toString(++access);
            String query = "Insert into tbl_bookaccessions values ('" + Global_Variable.accbookId + "','" + accession.getText() + "','" + txtBarcode.getText() + "','" + txtBookTitle.getText() + "','" + txtauthor.getText() + "','" + txtPublisher.getText() + "','" + comboxtype.getSelectedItem() + "','" + totalcopies.getText() + "','"+Global_Variable.category_id+"')";
            executesqlQuery(query, "Successfully Added");
            accession.setText(a);
            CountBooks();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String queries = "UPDATE `tbl_librarybook` SET  `NoOfCopies` ='" + totalcopies.getText() + "' WHERE  `ISBNBarcode` =" + txtBarcode.getText();
            executesqlQuery(queries, "updated");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_saveAccessActionPerformed

    private void accessTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accessTableMouseClicked
       /*  updatebook.show();
        DateBook.hide();
        txtBarcode.setEnabled(true);
        txtBookTitle.setEnabled(true);
        DateBook.setEnabled(true);
        YearBook.setEnabled(true);
        txtauthor.setEnabled(true);
        txtedNumber.setEnabled(true);
        txtPageVol.setEnabled(true);
        txtPlace.setEnabled(true);
        txtPublisher.setEnabled(true);
        combobinding.setEnabled(true);
        DateBook.setEnabled(true);
        txtPrice.setEnabled(true);

        comboxtype.setEnabled(true);
        status.setEnabled(true);
        days.setEnabled(true);
        available.setEnabled(true);

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        btnEdit.setEnabled(true);
        btndelete1.setEnabled(true);

        try {
            int row = accessTable.getSelectedRow();
            String cell_click = (accessTable.getModel().getValueAt(row, 1).toString());

            String query = "Select * from tbl_bookaccessions where accessID = '" + cell_click + "' and category_id=" + Global_Variable.category_id;

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.prepareStatement(query);
            rs = st.executeQuery(query);
 
            if (rs.next()) {
                //to display the data inside the txtfields
                String barcode = rs.getString("ISBNBarcode");
                txtBarcode.setText(barcode);
 
                String title = rs.getString("BookTitle");
                txtBookTitle.setText(title);

                String author = rs.getString("BookAuthor");
                txtauthor.setText(author);

                String pubisher = rs.getString("BookPublisher");
                txtPublisher.setText(pubisher); 
                
                String bindings = rs.getString("BookType");
                comboxtype.setSelectedItem(bindings); 
                
                validatebookType();  
            }
            
            int rowsbook = accessTable.getSelectedRow();
            String cell_clickbook = (accessTable.getModel().getValueAt(rowsbook, 2).toString());

            String querybook = "Select * from tbl_librarybook where ISBNBarcode = '" + cell_clickbook + "' and category_id=" + Global_Variable.category_id;

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.prepareStatement(querybook);
            rs = st.executeQuery(querybook);
 
            if (rs.next()) {
                //to display the data inside the txtfields
                 String section = rs.getString("Pagevolume");
                txtPageVol.setText(section);

                String edition = rs.getString("EditionNumber");
                txtedNumber.setText(edition);

                String place = rs.getString("Place");
                txtPlace.setText(place);

                String year = rs.getString("Year");
                txtPageVol.setText(year);

                String binding = rs.getString("Binding");
                combobinding.setSelectedItem(binding);
                
                 String bindings = rs.getString("Type");
                comboxtype.setSelectedItem(bindings);

                String price = rs.getString("Price");
                txtPrice.setText(price);

                String status = rs.getString("Status");
                txtPlace.setText(status);

                String day = rs.getString("days");
                days.setSelectedItem(day);

                validatebookType();

                String availa = rs.getString("Availability");
                available.setSelectedItem(availa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }//GEN-LAST:event_accessTableMouseClicked

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void table_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_bookMouseClicked
        updatebook.show();
        DateBook.hide();
        txtBarcode.setEnabled(true);
        txtBookTitle.setEnabled(true);
        DateBook.setEnabled(true);
        YearBook.setEnabled(true);
        txtauthor.setEnabled(true);
        txtedNumber.setEnabled(true);
        txtPageVol.setEnabled(true);
        txtPlace.setEnabled(true);
        txtPublisher.setEnabled(true);
        combobinding.setEnabled(true);
        DateBook.setEnabled(true);
        txtPrice.setEnabled(true);

        comboxtype.setEnabled(true);
        status.setEnabled(true);
        days.setEnabled(true);
        available.setEnabled(true);

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        btnEdit.setEnabled(true);
        btndelete1.setEnabled(true);

        try {
            int row = table_book.getSelectedRow();
            String cell_click = (table_book.getModel().getValueAt(row, 1).toString());

            String query = "Select * from tbl_librarybook where ISBNBarcode = '" + cell_click + "' and category_id=" + Global_Variable.category_id;

            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = cn.prepareStatement(query);
            rs = st.executeQuery(query);

            //SimpleDateFormat s = new SimpleDateFormat("yyyy MMM d");
            if (rs.next()) {
                //to display the data inside the txtfields
                String barcode = rs.getString("ISBNBarcode");
                txtBarcode.setText(barcode);

                String date = rs.getString("DateAcquisition");
                updatebook.setText(date);

                String title = rs.getString("BookTitle");
                txtBookTitle.setText(title);

                String author = rs.getString("BookAuthor");
                txtauthor.setText(author);

                String pubisher = rs.getString("BookPublisher");
                txtPublisher.setText(pubisher);

                String section = rs.getString("Pagevolume");
                txtPageVol.setText(section);

                String edition = rs.getString("EditionNumber");
                txtedNumber.setText(edition);

                String place = rs.getString("Place");
                txtPlace.setText(place);

                String year = rs.getString("Year");
                txtPageVol.setText(year);

                String binding = rs.getString("Binding");
                combobinding.setSelectedItem(binding);
                
                 String bindings = rs.getString("Type");
                comboxtype.setSelectedItem(bindings);

                String price = rs.getString("Price");
                txtPrice.setText(price);

                String status = rs.getString("Status");
                txtPlace.setText(status);

                String day = rs.getString("days");
                days.setSelectedItem(day);

                validatebookType();

                String availa = rs.getString("Availability");
                available.setSelectedItem(availa);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        CountBooks();
        int choice;
        choice = JOptionPane.showConfirmDialog(null, "Add accession number?");

        if (choice == JOptionPane.YES_OPTION) {
            accession.setEnabled(true);
            accessTable.setEnabled(false);
            accession.getText();
            totalcopies.getText();
        }

    }//GEN-LAST:event_table_bookMouseClicked

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
        txtBookTitle.setText("");
        txtauthor.setText("");
        txtedNumber.setText("");
        txtPageVol.setText("");
        txtPlace.setText("");
        txtPublisher.setText("");
        combobinding.setSelectedItem("");
        txtPrice.setText("");

        comboxtype.setSelectedItem("");
        txtBarcode.setText("");
    }//GEN-LAST:event_btnClearMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        txtBarcode.setEnabled(false);
        txtBookTitle.setEnabled(true);
        DateBook.setEnabled(true);
        YearBook.setEnabled(true);
        txtauthor.setEnabled(true);
        txtedNumber.setEnabled(true);
        txtPageVol.setEnabled(true);
        txtPlace.setEnabled(true);
        txtPublisher.setEnabled(true);
        combobinding.setEnabled(true);
        DateBook.setEnabled(true);
        txtPrice.setEnabled(true);

        comboxtype.setEnabled(true);
        status.setEnabled(true);
        days.setEnabled(true);
        available.setEnabled(true);

        try {
            if (txtBarcode.getText().trim().isEmpty() || txtBookTitle.getText().trim().isEmpty() || txtauthor.getText().trim().isEmpty() || txtedNumber.getText().trim().isEmpty() || txtPageVol.getText().trim().isEmpty() || txtPlace.getText().trim().isEmpty() || txtPublisher.getText().trim().isEmpty() || txtPrice.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fields cannot be empty");
            } else {
                String query = "UPDATE `tbl_librarybook` SET `ISBNBarcode`='" + txtBarcode.getText() + "',`DateAcquisition`='" + DateBook.getDateFormatString() + "',`BookTitle`='" + txtBookTitle.getText() + "',`BookAuthor`='" + txtauthor.getText() + "',`EditionNumber`='" + txtedNumber.getText() + "',`Pagevolume`='" + txtPageVol.getText() + "',`Place`='" + txtPlace.getText() + "',`BookPublisher`='" + txtPublisher.getText() + "',`Year`='" + YearBook.getYear() + "',`Binding`='" + combobinding.getSelectedItem() + "',`Price`='" + txtPrice.getText() + "',`Type`='" + comboxtype.getSelectedItem() + "',`ISBNBarcode`='" + txtBarcode.getText() + "' WHERE ISBNBarcode=" + txtBarcode.getText();
                executesqlQuery(query, "updated");

                days.setEnabled(true);
                available.setEnabled(true);
                txtBookTitle.setText("");
                txtauthor.setText("");
                txtedNumber.setText("");
                txtPageVol.setText("");
                txtPlace.setText("");
                txtPublisher.setText("");
                combobinding.setSelectedItem("");
                txtPrice.setText("");

                comboxtype.setSelectedItem("");
                txtBarcode.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtBarcode.getText().trim().isEmpty() || txtBookTitle.getText().trim().isEmpty() || txtauthor.getText().trim().isEmpty() || txtedNumber.getText().trim().isEmpty() || txtPageVol.getText().trim().isEmpty() || txtPlace.getText().trim().isEmpty() || txtPublisher.getText().trim().isEmpty() || txtPrice.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty");
        } else {

            String tempisbn = txtBarcode.getText();
            SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
            String date = s.format(DateBook.getDate());
 
            String query = "INSERT INTO `tbl_librarybook` VALUES ('" + Global_Variable.BookId + "','" + tempisbn + "','" + date + "','" + txtBookTitle.getText() + "','" + txtauthor.getText() + "','" + txtedNumber.getText() + "','" + txtPageVol.getText() + "','" + txtPlace.getText()+ "','" + txtPublisher.getText()+ "','" + YearBook.getYear() + "','" + combobinding.getSelectedItem() + "','" + txtPrice.getText() + "','" + comboxtype.getSelectedItem() + "','" + Global_Variable.category_id + "','" + totalcopies.getText() + "','" + status.getSelectedItem() + "','" + days.getSelectedItem() + "','" + available.getSelectedItem() + "')";
            executesqlQuery(query, "Added");
           
            txtBarcode.setText("");
            txtBookTitle.setText("");
            txtauthor.setText("");
            txtedNumber.setText("");
            txtPageVol.setText("");
            txtPlace.setText("");
            txtPublisher.setText("");
            combobinding.setSelectedItem("");
            DateBook.setDateFormatString("");
            txtPrice.setText(""); 
            comboxtype.setSelectedItem("");

            /* txtBarcode.setEnabled(true);
             txtBookTitle.setEnabled(false);
             DateBook.setEnabled(false);
             YearBook.setEnabled(false);
             txtauthor.setEnabled(false);
             txtedNumber.setEnabled(false);
             txtPageVol.setEnabled(false);
             txtPlace.setEnabled(false);
             txtPublisher.setEnabled(false);
             combobinding.setEnabled(false);
             DateBook.setEnabled(false);
             txtPrice.setEnabled(false);
             txtSource.setEnabled(false);
             comboxtype.setEnabled(false);
             status.setEnabled(false);
             days.setEnabled(false);
             available.setEnabled(false);*/
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Cannot input letters");

        }
    }//GEN-LAST:event_txtPriceKeyTyped

    private void txtPlaceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlaceKeyTyped

    }//GEN-LAST:event_txtPlaceKeyTyped

    private void txtPlaceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlaceKeyReleased
        int i = evt.getKeyChar();
        if (!(i < '0' || i > '9')) {
            txtPlace.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");
        }
    }//GEN-LAST:event_txtPlaceKeyReleased

    private void txtPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlaceActionPerformed

    }//GEN-LAST:event_txtPlaceActionPerformed

    private void txtPageVolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPageVolKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Cannot input letters");

        }
    }//GEN-LAST:event_txtPageVolKeyTyped

    private void txtedNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtedNumberKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Cannot input letters");

        }
    }//GEN-LAST:event_txtedNumberKeyTyped

    private void txtBarcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyTyped

    }//GEN-LAST:event_txtBarcodeKeyTyped

    private void txtBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyReleased

        txtBarcode.setEnabled(true);
        txtBookTitle.setEnabled(true);
        DateBook.setEnabled(true);
        YearBook.setEnabled(true);
        txtauthor.setEnabled(true);
        txtedNumber.setEnabled(true);
        txtPageVol.setEnabled(true);
        txtPlace.setEnabled(true);
        txtPublisher.setEnabled(true);
        combobinding.setEnabled(true);
        DateBook.setEnabled(true);
        txtPrice.setEnabled(true);

        comboxtype.setEnabled(true);
        status.setEnabled(true);
        days.setEnabled(true);
        available.setEnabled(true);
        updatebook.hide();
        DateBook.show();
    }//GEN-LAST:event_txtBarcodeKeyReleased

    private void txtBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyPressed

    }//GEN-LAST:event_txtBarcodeKeyPressed

    private void txtPublisherKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPublisherKeyTyped
        int b = evt.getKeyChar();
        if (b == KeyEvent.VK_0 || b == KeyEvent.VK_9) {
            txtPlace.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");
        }
    }//GEN-LAST:event_txtPublisherKeyTyped

    private void txtauthorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtauthorKeyTyped
        int i = evt.getKeyChar();
        if (i == KeyEvent.VK_0 || i == KeyEvent.VK_9) {
            txtauthor.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");
        }
    }//GEN-LAST:event_txtauthorKeyTyped

    private void txtauthorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtauthorKeyReleased
        int i = evt.getKeyChar();
        if (!(i < '0' || i > '9')) {
            txtauthor.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");
        }
    }//GEN-LAST:event_txtauthorKeyReleased

    private void txtauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtauthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtauthorActionPerformed

    private void comboxtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxtypeActionPerformed

    }//GEN-LAST:event_comboxtypeActionPerformed

    private void txtBookTitleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBookTitleKeyTyped
        int i = evt.getKeyChar();
        if (i == KeyEvent.VK_0 || i == KeyEvent.VK_9) {
            txtauthor.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");
        }
    }//GEN-LAST:event_txtBookTitleKeyTyped

    private void txtBookTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBookTitleKeyReleased
        int i = evt.getKeyChar();
        if (!(i < '0' || i > '9')) {
            txtBookTitle.setText("");
            JOptionPane.showMessageDialog(null, "Cannot input integer");
        }
    }//GEN-LAST:event_txtBookTitleKeyReleased

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtBookTitle.setText("");
        txtauthor.setText("");
        txtedNumber.setText("");
        txtPageVol.setText("");
        txtPlace.setText("");
        txtPublisher.setText("");
        combobinding.setSelectedItem("");
        txtPrice.setText("");

        comboxtype.setSelectedItem("");
        txtBarcode.setText("");
        updatebook.hide();
        DateBook.show();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        String temp1 = txtsearch.getText() + "%";
        data = theSearch("Select * from tbl_librarybook where ISBNBarcode like '" + temp1 + "' || BookTitle like '" + temp1 + "'");
        table_book.setModel(new javax.swing.table.DefaultTableModel(data, header));
        table_book.removeColumn(table_book.getColumnModel().getColumn(0));
    }//GEN-LAST:event_txtsearchKeyReleased

    private void txtaccessionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaccessionKeyReleased
        String temp1 = txtaccession.getText() + "%";
        datas = SearchAccession("Select * from tbl_bookaccessions where accessID like '" + temp1 + "' || ISBNBarcode like '" + temp1 + "'");
        accessTable.setModel(new javax.swing.table.DefaultTableModel(datas, headers));
        accessTable.removeColumn(accessTable.getColumnModel().getColumn(0));
    }//GEN-LAST:event_txtaccessionKeyReleased

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        /*  String temp = txtsearch.getText() + "%";
         Connection connect = null;
      
         //Map param = new HashMap();
         try {
         connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagesystem?zeroDateTimeBehavior=convertToNull", "root", "");
         JasperDesign jd = JRXmlLoader.load(getClass().getResourceAsStream("/Reports/Rose.jrxml"));
         String sql = "Select * from tbl_borrowinside where ISBNBarcode like " + temp + "  ";
         JRDesignQuery newQuery = new JRDesignQuery();
         newQuery.setText(sql);
         jd.setQuery(newQuery);
         JasperReport jr = JasperCompileManager.compileReport(jd);
         JasperPrint jp = JasperFillManager.fillReport(jr, null, connect);
         JasperViewer.viewReport(jp, false);
         } catch (Exception e) {
         e.printStackTrace();
         }*/

        MessageFormat header = new MessageFormat("Library Book Reports");
        MessageFormat footer = new MessageFormat("page{0,number,integer}");

        try {
            table_book.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("can not print %s %n", e.getMessage());
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnaccessPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaccessPrintActionPerformed
        /*   String temp = txtaccession.getText() + "%";
         Connection connect = null;
      
         //Map param = new HashMap();
         try {
         connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagesystem?zeroDateTimeBehavior=convertToNull", "root", "");
         JasperDesign jd = JRXmlLoader.load(getClass().getResourceAsStream("/Reports/BookAccessions.jrxml"));
         String sql = "Select * from tbl_bookaccessions where accessID like " + temp + " || ISBNBarcode like " + temp + " ";
         JRDesignQuery newQuery = new JRDesignQuery();
         newQuery.setText(sql);
         jd.setQuery(newQuery);
         JasperReport jr = JasperCompileManager.compileReport(jd);
         JasperPrint jp = JasperFillManager.fillReport(jr, null, connect);
         JasperViewer.viewReport(jp, false);
         } catch (Exception e) {
         e.printStackTrace();
         }*/

        MessageFormat header = new MessageFormat("Book accessions with ISBNBarcode Reports");
        MessageFormat footer = new MessageFormat("page{0,number,integer}");
        try {

            accessTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("can not print %s %n", e.getMessage());
        }
    }//GEN-LAST:event_btnaccessPrintActionPerformed

    private void btndelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelete1ActionPerformed
         updatebook.show();
        DateBook.hide();
        
        String query = "DELETE from tbl_librarybook where ISBNBarcode =" + txtBarcode.getText();
        executesqlQuery(query, "Deleted");
        txtBookTitle.setText("");
        txtauthor.setText("");
        txtedNumber.setText("");
        txtPageVol.setText("");
        txtPlace.setText("");
        txtPublisher.setText("");
        combobinding.setSelectedItem("");
        txtPrice.setText("");
        comboxtype.setSelectedItem("");
        txtBarcode.setText("");
        updatebook.setText("");
        DateBook.setDateFormatString("");
        
        txtBarcode.setEnabled(true);
        txtBookTitle.setEnabled(false);
        DateBook.setEnabled(false);
        YearBook.setEnabled(false);
        txtauthor.setEnabled(false);
        txtedNumber.setEnabled(false);
        txtPageVol.setEnabled(false);
        txtPlace.setEnabled(false);
        txtPublisher.setEnabled(false);
        combobinding.setEnabled(false);
        DateBook.setEnabled(false);
        txtPrice.setEnabled(false); 
        comboxtype.setEnabled(false);
        status.setEnabled(false);
        days.setEnabled(false);
        available.setEnabled(false);
        updatebook.setEnabled(false);
        //DateBook.show();
       // updatebook.show();
    }//GEN-LAST:event_btndelete1ActionPerformed

    private void accessionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accessionKeyReleased
      
    }//GEN-LAST:event_accessionKeyReleased

    private void updatebookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updatebookKeyReleased
        updatebook.hide();
        DateBook.show();
    }//GEN-LAST:event_updatebookKeyReleased

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

    private void updatebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updatebookActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void DateBookPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DateBookPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_DateBookPropertyChange
    //to get the book type for the database

    private String validatebookType() {
        Statement st;
        String id = "";
        ResultSet rs;
        String query;
        try {
            query = "select booktype from `tbl_booktype` where booktype='" + comboxtype.getSelectedItem().toString() + "'";
            st = null;
            st = con.dbconn().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("booktype");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    private boolean validateBarcode(String Barcode) {
        boolean queue = false;
        ResultSet rs;
        //String barcode = adminbarcode.getText();
        String query;
        try {
            query = "select id from `tbl_bookaccessions` where accessID='" + Barcode + "'";
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

    private void CountBooks() {
        try {
            String q = "SELECT COUNT(ISBNBarcode) AS ISBNBarcode FROM tbl_bookaccessions where ISBNBarcode =" + txtBarcode.getText();

            ResultSet rs;
            PreparedStatement ps = con.dbconn().prepareStatement(q);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalcopies.setText(rs.getString("ISBNBarcode"));
            }
        } catch (Exception e) {

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateBook;
    private com.toedter.calendar.JYearChooser YearBook;
    private javax.swing.JTable accessTable;
    private javax.swing.JTextField accession;
    private javax.swing.JComboBox available;
    private javax.swing.JLabel book;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnaccessPrint;
    private javax.swing.JButton btndelete1;
    private javax.swing.JComboBox combobinding;
    private javax.swing.JComboBox comboxtype;
    private javax.swing.JComboBox days;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton saveAccess;
    private javax.swing.JComboBox status;
    private javax.swing.JTable table_book;
    private javax.swing.JTextField totalcopies;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtBookTitle;
    private javax.swing.JTextField txtPageVol;
    private javax.swing.JTextField txtPlace;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtPublisher;
    private javax.swing.JTextField txtaccession;
    private javax.swing.JTextField txtauthor;
    private javax.swing.JTextField txtedNumber;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField updatebook;
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
                user.add(rs.getString(18));
                useVector.add(user);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return useVector;
    }

    private Vector<Vector<String>> SearchAccession(String sqlSearch) {
        Vector<Vector<String>> accession = new Vector<Vector<String>>();
        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlSearch);

            while (rs.next()) {
                Vector<String> access = new Vector<String>();
                access.add(rs.getString(1));
                access.add(rs.getString(2));
                access.add(rs.getString(3));
                accession.add(access);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());
        }
        return accession;
    }

}
