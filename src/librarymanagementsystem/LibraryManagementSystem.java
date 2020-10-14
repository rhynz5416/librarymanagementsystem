/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarymanagementsystem;

import Classes.Themes;
import Global_Variable.Global_Variable;
import JDialogs.LoginDialog;
import JDialogs.SettingsDialog;
import Module.dbConn;
import com.alee.laf.WebLookAndFeel;
import connection.DAObject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author Gerardo Socias Jr
 */
public class LibraryManagementSystem {
    private static Process xamppProcess;
    private static dbConn con;
    
    public static Properties prop;
    
    public static void main(String[] args) throws UnsupportedLookAndFeelException, FileNotFoundException, IOException{
        prop = new Properties();
        
        try {
            xamppProcess = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqld.exe");
            if(xamppProcess.isAlive()){
                System.out.println("xampp is alive");
            }else{
                System.out.println("xampp is disabled");
            }
        } catch (IOException ex) {
            Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }           
        Global_Variable.system_title = "Libray Management System";
        Global_Variable.selected_theme = "tangerine";
        Themes theme = new Themes();
        theme.initializeFontStream();
        
        
        prop.load(new FileInputStream(LibraryManagementSystem.getSystemDirectory()+"/settings.properties"));
        
        
        String host = prop.getProperty("host");
        if(host == null){
            SettingsDialog setting = new SettingsDialog(new javax.swing.JFrame(), true);
            setting.setLocationRelativeTo(null);
            setting.setVisible(true);
        }else{
            LoginDialog a = new LoginDialog(new javax.swing.JFrame(), true);
            a.setLocationRelativeTo(null);
            a.setVisible(true);
        }
    }
    
    public static String getSystemAcronym(){
        return "LMS";
    }
    
    public static String getSystemVersion(){
        return "Ver. 1.0";
    }
    
    public static String getSystemName(){
        return "LMS: Library Management System";
    }
    
    public static String getSystemDirectory(){
        return System.getProperty("user.dir");
    }
    
    public static void setSystemProperty(Properties p){
        prop = p;
    }
    
    public static Properties getSystemSettings(){
        return prop;
    }
}
