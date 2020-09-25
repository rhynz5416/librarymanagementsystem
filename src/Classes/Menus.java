/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import com.alee.laf.menu.WebMenu;
import com.alee.laf.menu.WebMenuBar;
import com.alee.laf.menu.WebMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menus implements ActionListener{
    WebMenu menuLibraryMaterials, menuTransaction, submenuRegistration, submenuBorrow, submenuReturn, submenuAdmin, menuLogout;
    WebMenuBar menubar;
    WebMenuItem book, cd, magazine, journal, newspaper, registration,
            borrow_b, borrow_c, borrow_m, borrow_j, borrow_n,
            return_b, return_c, return_m, return_j, return_n,
            admin_u, admin_r, admin_t;

    public Menus(){}

    public WebMenuBar MenuBar(){
        menubar = new WebMenuBar();
        
        // Library materials
        menuLibraryMaterials = new WebMenu("Library Materials");
        submenuRegistration = new WebMenu("Client Registration");

        book = new WebMenuItem("Book");
        cd = new WebMenuItem("Cd");
        magazine = new WebMenuItem("Magazine");
        journal = new WebMenuItem("Journal");
        newspaper = new WebMenuItem("Newspaper");
        registration = new WebMenuItem("Registration");

        menuLibraryMaterials.add(book);
        menuLibraryMaterials.add(cd);
        menuLibraryMaterials.add(magazine);
        menuLibraryMaterials.add(journal);
        menuLibraryMaterials.add(newspaper);

        submenuRegistration.add(registration);

        menuLibraryMaterials.add(submenuRegistration);

        // Transaction Menu
        menuTransaction = new WebMenu("Transaction Menu");
        submenuBorrow = new WebMenu("Borrow");
        submenuReturn = new WebMenu("Return"); 
        submenuAdmin = new WebMenu("Admin Menu");

        // setup menu items for transaction menu
        borrow_b = new WebMenuItem("Book");
        borrow_c = new WebMenuItem("Cd");
        borrow_m = new WebMenuItem("Magazine");
        borrow_j = new WebMenuItem("Journal");
        borrow_n = new WebMenuItem("Newspaper");

        return_b = new WebMenuItem("Book");
        return_c = new WebMenuItem("Cd");
        return_m = new WebMenuItem("Magazine");
        return_j = new WebMenuItem("Journal");
        return_n = new WebMenuItem("Newspaper");

        admin_u = new WebMenuItem("Update");
        admin_r = new WebMenuItem("Register");
        admin_t = new WebMenuItem("Transaction Monitoring");

        // add submenu items for borrow
        submenuBorrow.add(borrow_b);
        submenuBorrow.add(borrow_c);
        submenuBorrow.add(borrow_m);
        submenuBorrow.add(borrow_j);
        submenuBorrow.add(borrow_n);

        // add submenu items for return
        submenuReturn.add(return_b);
        submenuReturn.add(return_c);
        submenuReturn.add(return_m);
        submenuReturn.add(return_j);
        submenuReturn.add(return_n);

        // add submenu items for admin
        submenuAdmin.add(admin_u);
        submenuAdmin.add(admin_r);
        submenuAdmin.add(admin_t);

        // add submenu to transaction menu
        menuTransaction.add(submenuBorrow);
        menuTransaction.add(submenuReturn);
        menuTransaction.add(submenuAdmin);

        // Logout
        menuLogout = new WebMenu("Logout");

        // initialize menu bar
        menubar.add(menuLibraryMaterials);
        menubar.add(menuTransaction);
        menubar.add(menuLogout);
        
        // add action listerner for every webmenu item
        book.addActionListener(this);
        cd.addActionListener(this);
        magazine.addActionListener(this);
        journal.addActionListener(this);
        newspaper.addActionListener(this);
        registration.addActionListener(this);
        
        borrow_b.addActionListener(this);
        borrow_c.addActionListener(this);
        borrow_m.addActionListener(this);
        borrow_j.addActionListener(this);
        borrow_n.addActionListener(this);
        
        return_b.addActionListener(this);
        return_c.addActionListener(this);
        return_m.addActionListener(this);
        return_j.addActionListener(this);
        return_n.addActionListener(this);
        
        admin_u.addActionListener(this);
        admin_r.addActionListener(this);
        admin_t.addActionListener(this);
                    
        menuLogout.addActionListener(this);
            
        return menubar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == book){
            System.out.println("Book");
            // function here
        }
        if(e.getSource() == cd){
            System.out.println("Cd");
            // function here
        }
        if(e.getSource() == magazine){
            System.out.println("Magazine");
            // function here
        }
        if(e.getSource() == journal){
            System.out.println("Journal");
            // function here
        }
        if(e.getSource() == newspaper){
            System.out.println("Newspaper");
            // function here
        }
        if(e.getSource() == registration){
            System.out.println("Registration");
            // function here
        }
        
        if(e.getSource() == borrow_b){
            // function here
        }
        if(e.getSource() == borrow_c){
            // function here
        }
        if(e.getSource() == borrow_m){
            // function here
        }
        if(e.getSource() == borrow_j){
            // function here
        }
        if(e.getSource() == borrow_n){
            // function here
        }
        
        if(e.getSource() == return_b){
            // function here
        }
        if(e.getSource() == return_c){
            // function here
        }
        if(e.getSource() == return_m){
            // function here
        }
        if(e.getSource() == return_j){
            // function here
        }
        if(e.getSource() == return_n){
            // function here
        }
        
        if(e.getSource() == admin_u){
            // function here
        }
        if(e.getSource() == admin_r){
            // function here
        }
        if(e.getSource() == admin_t){
            // function here
        }
        
        // Logout
        if(e.getSource() == menuLogout){
            // function for logout
        }
    }
}
