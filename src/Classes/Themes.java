/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Global_Variable.Global_Variable;
import com.alee.laf.button.WebButton;
import com.alee.laf.menu.WebMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Gerardo Socias Jr
 */
public class Themes {
    
    private final String tangerine_color = "#f28500";
    private final String bisutheme_color = "#000000";
    private String color = null;
    private final String selected_theme = Global_Variable.selected_theme;
    
    private static Font font;
    
    public Themes() {}
    
    public void setBtnColor(JButton button){
//        button.setBackground();
        button.setForeground(Color.decode(getBtnThemeColor()));
    }
    
    public void setPanelBackGroundColor(JPanel panel){
        panel.setBackground(Color.decode(getBtnThemeColor()));
        panel.setOpaque(true);
    }
    
    public void setFontFields(JTextField tfields, JPasswordField pfields){
        if(tfields != null){
            tfields.setFont(getFontFields());
        }else{
            pfields.setFont(getFontFields());
        }
    }
    
    public void setFontMenu(WebMenu menu, String weight){
        if(weight.equals("plain")){
            menu.setFont(getFontMenuPlain());
        }else{
            menu.setFont(getFontMenuBold());
        }
    }
    
    public void setFontTitle(JLabel label, String weight){
        if(weight.equals("plain")){
            label.setFont(getFontTitlePlain());
        }else{
            label.setFont(getFontTitleBold());
        }
    }
    
    public void setFontLabel(JLabel label){
        label.setFont(getFontLabel());
    }
    
    public void initializeFontStream(){
        // intitalize font sizes
        Global_Variable.titleSize = 40f;
        Global_Variable.labelSize = 18f;
        Global_Variable.fieldSize = 18f;
        Global_Variable.menuSize = 20f;
    }
    
    private InputStream getFontStream() {
        String ttf = null;
        String fontPath = System.getProperty("user.dir") + "/fonts";
        File root = new File(fontPath);
        if(root.canRead()){
            String[] fontFiles = root.list();
            int x = 0;
            for(String fontFile: fontFiles){
                try{
                    if(x == 0){
                        ttf = fontPath + "/" +fontFile;
//                        System.out.println("Font file: "+ttf);
                        break;
                    }
                }catch(Exception e){}
            }   
        }
        InputStream stream;
        try {
            stream = new BufferedInputStream( new FileInputStream(ttf) );
            Global_Variable.fontStream = stream;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Themes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Global_Variable.fontStream;
    }
    
    private Font getFontFields(){
        try {
            font = Font.createFont(Font.PLAIN, getFontStream()).deriveFont(Global_Variable.fieldSize);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Themes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }
    
    private Font getFontMenuPlain(){
        try {
            font = Font.createFont(Font.PLAIN, getFontStream()).deriveFont(Global_Variable.menuSize);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Themes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }
    
    private Font getFontMenuBold(){
        try {
            font = Font.createFont(Font.BOLD, getFontStream()).deriveFont(Global_Variable.menuSize );
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Themes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }
    
    private Font getFontTitlePlain(){
        try {
            font = Font.createFont(Font.PLAIN, getFontStream()).deriveFont(Global_Variable.titleSize);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Themes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }
    
    private Font getFontTitleBold(){
        try {
            font = Font.createFont(Font.BOLD, getFontStream()).deriveFont(Global_Variable.titleSize);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Themes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }
    
    private Font getFontLabel(){
        try {
            font = Font.createFont(Font.PLAIN, getFontStream()).deriveFont(Global_Variable.labelSize);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Themes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }
    
    private String getBtnThemeColor(){
        if("tangerine".equals(selected_theme)){
            color = this.tangerine_color;
        }else{
            color = this.bisutheme_color;
        }
        return color;
    }
    
}
