package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import Global_Variable.Global_Variable;

public class Conn {

    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Your not Connected");
        }
        return conn;
    }

    public void executeQuery(String query) {
        Statement st;
        try {
            st = connect().createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } 
    public Vector getUser() throws Exception {
        Vector<Vector<String>> useVector = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_librarybook");
        ResultSet rs = pre.executeQuery();

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
            useVector.add(user);
        }
        if (conn != null) {
            conn.close();
        }

        return useVector;
    }

    public Vector getAccession() throws Exception {
        Vector<Vector<String>> accession = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_bookaccessions");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> access = new Vector<String>();

            access.add(rs.getString(1));
            access.add(rs.getString(2));
            access.add(rs.getString(3));
            accession.add(access);
        }
        if (conn != null) {
            conn.close();
        }

        return accession;
    }

    public Vector getCD() throws Exception {
        Vector<Vector<String>> cd = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_cd");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> cds = new Vector<String>();

            cds.add(rs.getString(1));
            cds.add(rs.getString(2));
            cds.add(rs.getString(4));
            cds.add(rs.getString(10));
            cds.add(rs.getString(11));
            cds.add(rs.getString(12));
            cds.add(rs.getString(13));
            cd.add(cds);
        }
        if (conn != null) {
            conn.close();
        } 
        return cd;
    }

    public Vector getCDAccession() throws Exception {
        Vector<Vector<String>> cdaccess = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_cdaccession");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> cdAccess = new Vector<String>();

            cdAccess.add(rs.getString(1));
            cdAccess.add(rs.getString(2));
            cdAccess.add(rs.getString(3));
            cdaccess.add(cdAccess);
        }
        if (conn != null) {
            conn.close();
        }

        return cdaccess;
    }

    //journal
    public Vector getJournal() throws Exception {
        Vector<Vector<String>> journal = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_journal");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> jour = new Vector<String>();

            jour.add(rs.getString(1));
            jour.add(rs.getString(2));
            jour.add(rs.getString(4));
            jour.add(rs.getString(12));
            jour.add(rs.getString(13));
            jour.add(rs.getString(14));
            jour.add(rs.getString(15));
            journal.add(jour);
        }
        if (conn != null) {
            conn.close();
        }

        return journal;
    }

    public Vector getJournalAccession() throws Exception {
        Vector<Vector<String>> journalaccess = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_journalaccession");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> journalAccess = new Vector<String>();

            journalAccess.add(rs.getString(1));
            journalAccess.add(rs.getString(2));
            journalAccess.add(rs.getString(3));
            journalaccess.add(journalAccess);
        }
        if (conn != null) {
            conn.close();
        }

        return journalaccess;
    }

    //magazine
    public Vector getMagazine() throws Exception {
        Vector<Vector<String>> magazine = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_magazine");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> magz = new Vector<String>();

            magz.add(rs.getString(1));
            magz.add(rs.getString(2));
            magz.add(rs.getString(4));
            magz.add(rs.getString(10));
            magz.add(rs.getString(11));
            magz.add(rs.getString(12));
            magz.add(rs.getString(13));
            magazine.add(magz);
        }
        if (conn != null) {
            conn.close();
        }

        return magazine;
    }

    public Vector getMagazineAccession() throws Exception {
        Vector<Vector<String>> magazineaccess = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_magazineaccession");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> MagazineAccess = new Vector<String>();

            MagazineAccess.add(rs.getString(1));
            MagazineAccess.add(rs.getString(2));
            MagazineAccess.add(rs.getString(3));

            magazineaccess.add(MagazineAccess);
        }
        if (conn != null) {
            conn.close();
        }

        return magazineaccess;
    }

    //newspaper
    public Vector getNewspaper() throws Exception {
        Vector<Vector<String>> newspaper = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_librarynewspaper");
        ResultSet rs = pre.executeQuery();

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
        if (conn != null) {
            conn.close();
        } 
        return newspaper;
    } 
    public Vector getNewspaperAccession() throws Exception {
        Vector<Vector<String>> newspaperaccess = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_newsaccession");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> NewspaperAccess = new Vector<String>();

            NewspaperAccess.add(rs.getString(1));
            NewspaperAccess.add(rs.getString(2));
            NewspaperAccess.add(rs.getString(3));
            newspaperaccess.add(NewspaperAccess);
        }
        if (conn != null) {
            conn.close();
        }

        return newspaperaccess;
    }

    //registration
    public Vector getClient() throws Exception {
        Vector<Vector<String>> client = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_clientregistration");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> Client = new Vector<String>();

            Client.add(rs.getString(1));
            Client.add(rs.getString(2));
            Client.add(rs.getString(3));
            Client.add(rs.getString(5));
            Client.add(rs.getString(7));
            Client.add(rs.getString(9));
            Client.add(rs.getString(10));

            client.add(Client);
        }
        if (conn != null) {
            conn.close();
        }

        return client;
    }

    public Vector getAdmin() throws Exception {
        Vector<Vector<String>> admin = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_admin");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> Admin = new Vector<String>();

            Admin.add(rs.getString(1));
            Admin.add(rs.getString(2));
            Admin.add(rs.getString(3));
            Admin.add(rs.getString(4));
            Admin.add(rs.getString(5));
            Admin.add(rs.getString(7)); 
            admin.add(Admin);
        }
        if (conn != null) {
            conn.close();
        }

        return admin;
    }

    public Vector gettransaction() throws Exception {
        Vector<Vector<String>> transact = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_transaction");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> trans = new Vector<String>();

            trans.add(rs.getString(1));
            trans.add(rs.getString(2));
            trans.add(rs.getString(3));
            trans.add(rs.getString(4));
            trans.add(rs.getString(5));
            transact.add(trans);
        }
        if (conn != null) {
            conn.close();
        }

        return transact;
    }

    public Vector getBorrowInside() throws Exception {
        Vector<Vector<String>> borrowinside = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_borrowinside where category_id='" + Global_Variable.category_id + "'");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> Borrowinside = new Vector<String>();

            Borrowinside.add(rs.getString(1));
            Borrowinside.add(rs.getString(2));
            Borrowinside.add(rs.getString(3));
            Borrowinside.add(rs.getString(4));
            Borrowinside.add(rs.getString(6));
            Borrowinside.add(rs.getString(8));
            Borrowinside.add(rs.getString(9));
            borrowinside.add(Borrowinside);
        }
        if (conn != null) {
            conn.close();
        }

        return borrowinside;
    }

    public Vector getBorrowOutside() throws Exception {
        Vector<Vector<String>> borrowoutside = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_borrowoutside where category_id='" + Global_Variable.category_id + "'");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> Borrowoutside = new Vector<String>();

            Borrowoutside.add(rs.getString(1));
            Borrowoutside.add(rs.getString(2));
            Borrowoutside.add(rs.getString(3));
            Borrowoutside.add(rs.getString(4));
            Borrowoutside.add(rs.getString(5));
            Borrowoutside.add(rs.getString(6));
            Borrowoutside.add(rs.getString(8));
            Borrowoutside.add(rs.getString(9));
            borrowoutside.add(Borrowoutside);
        }
        if (conn != null) {
            conn.close();
        }

        return borrowoutside;
    }

    public Vector getReturnInside() throws Exception {
        Vector<Vector<String>> returninside = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_returninside ");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> Returninside = new Vector<String>();

            Returninside.add(rs.getString(1));
            Returninside.add(rs.getString(2));
            Returninside.add(rs.getString(3));
            Returninside.add(rs.getString(4));
            returninside.add(Returninside);
        }
        if (conn != null) {
            conn.close();
        }

        return returninside;
    }

    public Vector getReturnOutside() throws Exception {
        Vector<Vector<String>> returnoutside = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_returnoutside");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> Returnoutside = new Vector<String>();

            Returnoutside.add(rs.getString(1));
            Returnoutside.add(rs.getString(2));
            Returnoutside.add(rs.getString(3));
            Returnoutside.add(rs.getString(4));
            returnoutside.add(Returnoutside);
        }
        if (conn != null) {
            conn.close();
        }

        return returnoutside;
    }

    public Vector getMatmonitoring() throws Exception {
        Vector<Vector<String>> material = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_matmonitoring where category_id='" + Global_Variable.category_id + "'");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> Material = new Vector<String>();

            Material.add(rs.getString(1));
            Material.add(rs.getString(2));
            Material.add(rs.getString(3));
            Material.add(rs.getString(4));
            material.add(Material);
        }
        if (conn != null) {
            conn.close();
        }

        return material;
    }

    public Vector getTeacher() throws Exception {
        Vector<Vector<String>> teacher = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_teacher");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> Teacher = new Vector<String>();

            Teacher.add(rs.getString(1));
            Teacher.add(rs.getString(2));
            Teacher.add(rs.getString(3));
            Teacher.add(rs.getString(4));
            teacher.add(Teacher);
        }
        if (conn != null) {
            conn.close();
        }

        return teacher;
    }

    public Vector getStudent() throws Exception {
        Vector<Vector<String>> student = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_student");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> Student = new Vector<String>();

            Student.add(rs.getString(1));
            Student.add(rs.getString(2));
            Student.add(rs.getString(3));
            Student.add(rs.getString(4));
            Student.add(rs.getString(5));
            Student.add(rs.getString(6));
            student.add(Student);
        }
        if (conn != null) {
            conn.close();
        }

        return student;
    }

    public Vector getPenalty() throws Exception {
        Vector<Vector<String>> penalty = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_penalty");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> Penalty = new Vector<String>();

            Penalty.add(rs.getString(1));
            Penalty.add(rs.getString(2));
            Penalty.add(rs.getString(3));
            Penalty.add(rs.getString(4));
            Penalty.add(rs.getString(5));
            Penalty.add(rs.getString(6));
            penalty.add(Penalty);
        }
        if (conn != null) {
            conn.close();
        }

        return penalty;
    }

    public Vector getRenewed() throws Exception {
        Vector<Vector<String>> renew = new Vector<Vector<String>>();
        Connection conn = connect();
        PreparedStatement pre = conn.prepareStatement("Select * from tbl_clientrenewal where category_id='" + Global_Variable.category_id + "'");
        ResultSet rs = pre.executeQuery();

        while (rs.next()) {
            Vector<String> Renew = new Vector<String>();

            Renew.add(rs.getString(1));
            Renew.add(rs.getString(2));
            Renew.add(rs.getString(3));
            Renew.add(rs.getString(4));
            renew.add(Renew);
        }
        if (conn != null) {
            conn.close();
        }

        return renew;
    }

}
