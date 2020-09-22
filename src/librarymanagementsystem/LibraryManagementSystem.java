/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package librarymanagementsystem;

import JDialogs.LoginDialog;
import com.alee.laf.WebLookAndFeel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Global_Variable.Global_Variable;
/**
 *
 * @author Gerardo Socias Jr
 */
public class LibraryManagementSystem {
    private static Process xamppProcess;
    
    public static void main(String[] args) throws UnsupportedLookAndFeelException{
        LookAndFeel laf = new WebLookAndFeel();
        UIManager.setLookAndFeel(laf);
        WebLookAndFeel.setDecorateAllWindows(true);
       
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

        LoginDialog a = new LoginDialog(new javax.swing.JFrame(), true);
        a.setLocationRelativeTo(null);
        a.setVisible(true);
    }
}
