package Module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class dbConn {

    public Connection dbconn() {
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
            st = dbconn().createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

