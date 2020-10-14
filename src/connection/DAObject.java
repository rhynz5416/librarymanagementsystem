/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gerardo Socias Jr
 */
public class DAObject {
    private String server;
    private String user;
    private String pass;
    private String database;
    private Connection conn;

    public DAObject(){
        server = "localhost";
        user = "root";
        pass = "";
        database = "librarymanagementsystem";
    }
    
    public DAObject(String server, String user, String pass, String db){
        this.server = server;
        this.user = user;
        this.pass = pass;
        this.database = db;
    }
    
    public DAObject(String server, String user, String db){
        this.server = server;
        this.database = db;
        this.user = user;
    }
    
    public Connection Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://"+server+"/"+database+"?zeroDateTimeBehavior=convertToNull", user, pass);
            
            return conn;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }
    
    public void executeQuery(String query) {
        Statement st;
        try {
            st = Connect().createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void Disconnect() throws SQLException{
        conn.close();
    }
    /**
     * @return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * @param server the server to set
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the database
     */
    public String getDatabase() {
        return database;
    }

    /**
     * @param database the database to set
     */
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
