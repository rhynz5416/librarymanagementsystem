package mainframe;

import Borrowing.BOOKBORROW;
import Borrowing.CDBORROW;
import Borrowing.JOURNALBORROW;
import Borrowing.MAGAZINEBORROW;
import Borrowing.NEWSPAPERBORROWS;
import MaterialEntry.BOOK;
import MaterialEntry.CD;
import MaterialEntry.JOURNAL;
import MaterialEntry.MAGAZINE;
import MaterialEntry.NEWSPAPER;
import Return.BOOKRETURN;
import Return.CDRETURN;
import Return.JOURNALRETURN;
import Return.MAGAZINERETURN;
import Return.NEWSPAPERRETURN;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Global_Variable.Global_Variable;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LibraryMainFrame extends javax.swing.JFrame { 
    
    public LibraryMainFrame() {
        initComponents(); 
        ImageIcon iconLogo = new ImageIcon("Images/bisub.png");
        imag.setIcon(iconLogo);  
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        imag = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        clientreg = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenu17 = new javax.swing.JMenu();
        jMenu18 = new javax.swing.JMenu();
        jMenu19 = new javax.swing.JMenu();
        jMenu20 = new javax.swing.JMenu();
        jMenu21 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenu22 = new javax.swing.JMenu();
        jMenu23 = new javax.swing.JMenu();
        jMenu24 = new javax.swing.JMenu();
        jMenu25 = new javax.swing.JMenu();
        jMenu26 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 36)); // NOI18N
        jLabel2.setText("BISU-BALILIHAN LIBRARY MANAGEMENT SYSTEM");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(490, 200, 1010, 50);
        getContentPane().add(imag);
        imag.setBounds(790, 300, 800, 430);

        jMenuBar1.setPreferredSize(new java.awt.Dimension(507, 30));

        jMenu1.setText("Library Materials");
        jMenu1.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N

        jMenu12.setText("BOOK");
        jMenu12.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu12.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu12MenuSelected(evt);
            }
        });
        jMenu12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu12MouseClicked(evt);
            }
        });
        jMenu12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenu12);

        jMenu8.setText("CD");
        jMenu8.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu8.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
                jMenu8MenuDeselected(evt);
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu8MenuSelected(evt);
            }
        });
        jMenu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu8MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu8);

        jMenu9.setText("MAGAZINE");
        jMenu9.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu9MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu9);

        jMenu11.setText("JOURNAL");
        jMenu11.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu11MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu11);

        jMenu10.setText("NEWSPAPER");
        jMenu10.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu10MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu10);

        jMenu2.setText("Client Registration");
        jMenu2.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N

        clientreg.setText("REGISTRATION");
        clientreg.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        clientreg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientregMouseClicked(evt);
            }
        });
        jMenu2.add(clientreg);

        jMenu1.add(jMenu2);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Transaction Menu");
        jMenu3.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N

        jMenu13.setText("BORROW");
        jMenu13.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N

        jMenu17.setText("BOOK");
        jMenu17.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu17MouseClicked(evt);
            }
        });
        jMenu13.add(jMenu17);

        jMenu18.setText("CD");
        jMenu18.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu18MouseClicked(evt);
            }
        });
        jMenu13.add(jMenu18);

        jMenu19.setText("JOURNAL");
        jMenu19.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu19MouseClicked(evt);
            }
        });
        jMenu13.add(jMenu19);

        jMenu20.setText("MAGAZINE");
        jMenu20.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu20MouseClicked(evt);
            }
        });
        jMenu13.add(jMenu20);

        jMenu21.setText("NEWSPAPER");
        jMenu21.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu21MouseClicked(evt);
            }
        });
        jMenu13.add(jMenu21);

        jMenu3.add(jMenu13);

        jMenu14.setText("RETURN");
        jMenu14.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N

        jMenu22.setText("BOOK");
        jMenu22.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu22MouseClicked(evt);
            }
        });
        jMenu22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu22ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenu22);

        jMenu23.setText("CD");
        jMenu23.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu23MouseClicked(evt);
            }
        });
        jMenu14.add(jMenu23);

        jMenu24.setText("JOURNAL");
        jMenu24.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu24MouseClicked(evt);
            }
        });
        jMenu14.add(jMenu24);

        jMenu25.setText("MAGAZINE");
        jMenu25.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu25MouseClicked(evt);
            }
        });
        jMenu14.add(jMenu25);

        jMenu26.setText("NEWSPAPER");
        jMenu26.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu26MouseClicked(evt);
            }
        });
        jMenu14.add(jMenu26);

        jMenu3.add(jMenu14);

        jMenu5.setText("Admin Menu");
        jMenu5.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N

        jMenu16.setText("UPDATE ADMIN");
        jMenu16.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu16MouseClicked(evt);
            }
        });
        jMenu5.add(jMenu16);

        jMenu4.setText("REGISTER ADMIN");
        jMenu4.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu5.add(jMenu4);

        jMenu15.setText("TRANSACTION MONITORING");
        jMenu15.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu15MouseClicked(evt);
            }
        });
        jMenu5.add(jMenu15);

        jMenu3.add(jMenu5);

        jMenuBar1.add(jMenu3);

        jMenu6.setText("Logout");
        jMenu6.setFont(new java.awt.Font("Lucida Fax", 3, 12)); // NOI18N
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1578, 831));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu8MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu8MenuSelected

    }//GEN-LAST:event_jMenu8MenuSelected

    private void jMenu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MouseClicked
        try {
            CD cd = new CD();
            cd.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu8MouseClicked

    private void jMenu11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu11MouseClicked
        try {
            JOURNAL journal = new JOURNAL();
            journal.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu11MouseClicked

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        try {
            MAGAZINE magazine = new MAGAZINE();
            magazine.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu9MouseClicked

    private void jMenu10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu10MouseClicked
        try {
            NEWSPAPER news = new NEWSPAPER();
            news.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu10MouseClicked

    private void clientregMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientregMouseClicked
        try {
            CLIENTREGISTRATION borrower = new CLIENTREGISTRATION(); 
            borrower.setVisible(true);
            borrower.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }//GEN-LAST:event_clientregMouseClicked

    private void jMenu17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu17MouseClicked
        try {
            BOOKBORROW BOOK = new BOOKBORROW();
            BOOK.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu17MouseClicked

    private void jMenu18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu18MouseClicked
        try {
            CDBORROW CD = new CDBORROW();
            CD.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu18MouseClicked

    private void jMenu19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu19MouseClicked
        try {
            JOURNALBORROW JOURNAL = new JOURNALBORROW();
            JOURNAL.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu19MouseClicked

    private void jMenu20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu20MouseClicked
        try {
            MAGAZINEBORROW MAGAZINE = new MAGAZINEBORROW();
            MAGAZINE.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu20MouseClicked

    private void jMenu21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu21MouseClicked
        try {
            NEWSPAPERBORROWS NEWSPAPER = new NEWSPAPERBORROWS();
            NEWSPAPER.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu21MouseClicked

    private void jMenu16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu16MouseClicked
        try {
            ADMIN ADMINS = new ADMIN();
            ADMINS.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu16MouseClicked

    private void jMenu22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu22ActionPerformed

    private void jMenu22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu22MouseClicked
        try {
            BOOKRETURN RETURN = new BOOKRETURN();
            RETURN.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu22MouseClicked

    private void jMenu23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu23MouseClicked
        try {
            CDRETURN RETURN = new CDRETURN();
            RETURN.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu23MouseClicked

    private void jMenu24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu24MouseClicked
        try {
            JOURNALRETURN RETURN = new JOURNALRETURN();
            RETURN.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu24MouseClicked

    private void jMenu25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu25MouseClicked
        try {
            MAGAZINERETURN RETURN = new MAGAZINERETURN();
            RETURN.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu25MouseClicked

    private void jMenu26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu26MouseClicked
        try {
            NEWSPAPERRETURN RETURN = new NEWSPAPERRETURN();
            RETURN.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu26MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
       try {
           REGISTERADMIN admin = new REGISTERADMIN();
            admin.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu15MouseClicked
         try {
           CheckingForm admin = new CheckingForm();
            admin.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu15MouseClicked

    private void jMenu12MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu12MenuSelected
         
    }//GEN-LAST:event_jMenu12MenuSelected

    private void jMenu12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu12MouseClicked
       try {
            BOOK book = new BOOK();
            book.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu12MouseClicked

    private void jMenu12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu12ActionPerformed

    private void jMenu8MenuDeselected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu8MenuDeselected
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu8MenuDeselected

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
        
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        int choicelogout;
        choicelogout = JOptionPane.showConfirmDialog(null, "Do you really want to logout?"); 
        if (choicelogout == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else if (choicelogout == JOptionPane.NO_OPTION) {
            this.setVisible(true);
        } else if (choicelogout == JOptionPane.CANCEL_OPTION) {
            this.setVisible(true);
        } else if (choicelogout == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenu6MouseClicked

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
            java.util.logging.Logger.getLogger(LibraryMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibraryMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibraryMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibraryMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu clientreg;
    private javax.swing.JLabel imag;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu21;
    private javax.swing.JMenu jMenu22;
    private javax.swing.JMenu jMenu23;
    private javax.swing.JMenu jMenu24;
    private javax.swing.JMenu jMenu25;
    private javax.swing.JMenu jMenu26;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
